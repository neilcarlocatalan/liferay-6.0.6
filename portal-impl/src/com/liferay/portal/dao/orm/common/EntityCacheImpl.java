/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.dao.orm.common;

import com.liferay.portal.cache.transactional.TransactionalPortalCache;
import com.liferay.portal.kernel.cache.CacheRegistryItem;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.cache.key.CacheKeyGeneratorUtil;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.dao.shard.ShardUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.AutoResetThreadLocal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.util.PropsValues;

import java.io.Serializable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections.map.LRUMap;

/**
 * @author Brian Wing Shun Chan
 */
public class EntityCacheImpl implements CacheRegistryItem, EntityCache {

	public static final String CACHE_NAME = EntityCache.class.getName();

	public void afterPropertiesSet() {
		CacheRegistryUtil.register(this);
	}

	public void clearCache() {
		clearLocalCache();

		for (PortalCache portalCache : _portalCaches.values()) {
			portalCache.removeAll();
		}
	}

	public void clearCache(String className) {
		clearLocalCache();

		PortalCache portalCache = _getPortalCache(className, false);

		if (portalCache != null) {
			portalCache.removeAll();
		}
	}

	public void clearLocalCache() {
		if (_localCacheAvailable) {
			_localCache.remove();
		}
	}

	public String getRegistryName() {
		return CACHE_NAME;
	}

	public Object getResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory) {

		if (!PropsValues.VALUE_OBJECT_ENTITY_CACHE_ENABLED ||
			!entityCacheEnabled || !CacheRegistryUtil.isActive()) {

			return null;
		}

		Object result = null;

		Map<String, Object> localCache = null;

		String localCacheKey = null;

		if (_localCacheAvailable) {
			localCache = _localCache.get();

			localCacheKey = _encodeLocalCacheKey(classObj, primaryKeyObj);

			result = localCache.get(localCacheKey);
		}

		if (result == null) {
			PortalCache portalCache = _getPortalCache(classObj.getName(), true);

			String cacheKey = _encodeCacheKey(primaryKeyObj);

			result = portalCache.get(cacheKey);

			if (result == null) {
				result = StringPool.BLANK;

				portalCache.put(cacheKey, result);
			}

			if (_localCacheAvailable) {
				localCache.put(localCacheKey, result);
			}
		}

		if (result != null) {
			result = _objectToResult(result);
		}

		return result;
	}

	public void invalidate() {
		clearCache();
	}

	public Object loadResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, SessionFactory sessionFactory) {

		if (!PropsValues.VALUE_OBJECT_ENTITY_CACHE_ENABLED ||
			!entityCacheEnabled || !CacheRegistryUtil.isActive()) {

			Session session = null;

			try {
				session = sessionFactory.openSession();

				return session.load(classObj, primaryKeyObj);
			}
			finally {
				sessionFactory.closeSession(session);
			}
		}

		Object result = null;

		Map<String, Object> localCache = null;

		String localCacheKey = null;

		if (_localCacheAvailable) {
			localCache = _localCache.get();

			localCacheKey = _encodeLocalCacheKey(classObj, primaryKeyObj);

			result = localCache.get(localCacheKey);
		}

		boolean load = false;

		if (result == null) {
			PortalCache portalCache = _getPortalCache(classObj.getName(), true);

			String cacheKey = _encodeCacheKey(primaryKeyObj);

			result = portalCache.get(cacheKey);

			if (result == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Load " + classObj + " " + primaryKeyObj +
							" from session");
				}

				load = true;

				Session session = null;

				try {
					session = sessionFactory.openSession();

					result = session.load(classObj, primaryKeyObj);
				}
				finally {
					if (result == null) {
						result = StringPool.BLANK;
					}
					else {
						result = _objectToResult(result);
					}

					portalCache.put(cacheKey, result);

					sessionFactory.closeSession(session);
				}
			}

			if (_localCacheAvailable) {
				localCache.put(localCacheKey, result);
			}
		}

		if (!load) {
			return _objectToResult(result);
		}

		if (result instanceof String) {
			return null;
		}
		else {
			return result;
		}
	}

	public void putResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj, Object result) {

		if (!PropsValues.VALUE_OBJECT_ENTITY_CACHE_ENABLED ||
			!entityCacheEnabled || !CacheRegistryUtil.isActive() ||
			(result == null)) {

			return;
		}

		result = _objectToResult(result);

		if (_localCacheAvailable) {
			Map<String, Object> localCache = _localCache.get();

			String localCacheKey = _encodeLocalCacheKey(
				classObj, primaryKeyObj);

			localCache.put(localCacheKey, result);
		}

		PortalCache portalCache = _getPortalCache(classObj.getName(), true);

		String cacheKey = _encodeCacheKey(primaryKeyObj);

		portalCache.put(cacheKey, result);
	}

	public void removeCache(String className) {
		String groupKey = _GROUP_KEY_PREFIX.concat(className);

		_portalCaches.remove(groupKey);
		_multiVMPool.removeCache(groupKey);
	}

	public void removeResult(
		boolean entityCacheEnabled, Class<?> classObj,
		Serializable primaryKeyObj) {

		if (!PropsValues.VALUE_OBJECT_ENTITY_CACHE_ENABLED ||
			!entityCacheEnabled || !CacheRegistryUtil.isActive()) {

			return;
		}

		if (_localCacheAvailable) {
			Map<String, Object> localCache = _localCache.get();

			String localCacheKey = _encodeLocalCacheKey(
				classObj, primaryKeyObj);

			localCache.remove(localCacheKey);
		}

		PortalCache portalCache = _getPortalCache(classObj.getName(), true);

		String cacheKey = _encodeCacheKey(primaryKeyObj);

		portalCache.remove(cacheKey);
	}

	public void setMultiVMPool(MultiVMPool multiVMPool) {
		_multiVMPool = multiVMPool;
	}

	private String _encodeCacheKey(Serializable primaryKeyObj) {
		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(CACHE_NAME);

		cacheKeyGenerator.append(ShardUtil.getCurrentShardName());
		cacheKeyGenerator.append(primaryKeyObj.toString());

		return cacheKeyGenerator.finish();
	}

	private String _encodeLocalCacheKey(
		Class<?> classObj, Serializable primaryKeyObj) {

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(CACHE_NAME);

		cacheKeyGenerator.append(ShardUtil.getCurrentShardName());
		cacheKeyGenerator.append(classObj.getName());
		cacheKeyGenerator.append(primaryKeyObj.toString());

		return cacheKeyGenerator.finish();
	}

	private PortalCache _getPortalCache(
		String className, boolean createIfAbsent) {

		String groupKey = _GROUP_KEY_PREFIX.concat(className);

		PortalCache portalCache = _portalCaches.get(groupKey);

		if ((portalCache == null) && createIfAbsent) {
			portalCache = _multiVMPool.getCache(
				groupKey, PropsValues.VALUE_OBJECT_ENTITY_BLOCKING_CACHE);

			if (PropsValues.TRANSACTIONAL_CACHE_ENABLED) {
				portalCache = new TransactionalPortalCache(portalCache);
			}

			PortalCache previousPortalCache = _portalCaches.putIfAbsent(
				groupKey, portalCache);

			if (previousPortalCache != null) {
				portalCache = previousPortalCache;
			}

			portalCache.setDebug(true);
		}

		return portalCache;
	}

	private Object _objectToResult(Object result) {
		if (result instanceof String) {
			return null;
		}
		else {
			result = ((BaseModel<?>)result).clone();

			BaseModel<?> model = (BaseModel<?>)result;

			model.setCachedModel(true);

			return model;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EntityCacheImpl.class);

	private static final String _GROUP_KEY_PREFIX = CACHE_NAME.concat(
		StringPool.PERIOD);

	private static ThreadLocal<LRUMap> _localCache;
	private static boolean _localCacheAvailable;

	static {
		if (PropsValues.VALUE_OBJECT_ENTITY_THREAD_LOCAL_CACHE_MAX_SIZE > 0) {
			_localCache = new AutoResetThreadLocal<LRUMap>(
				EntityCacheImpl.class + "._localCache",
				new LRUMap(
					PropsValues.
						VALUE_OBJECT_ENTITY_THREAD_LOCAL_CACHE_MAX_SIZE));
			_localCacheAvailable = true;
		}
	}

	private MultiVMPool _multiVMPool;
	private ConcurrentMap<String, PortalCache> _portalCaches =
		new ConcurrentHashMap<String, PortalCache>();

}