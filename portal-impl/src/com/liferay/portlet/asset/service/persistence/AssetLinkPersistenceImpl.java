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

package com.liferay.portlet.asset.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.NoSuchLinkException;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.model.impl.AssetLinkImpl;
import com.liferay.portlet.asset.model.impl.AssetLinkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the asset link service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link AssetLinkUtil} to access the asset link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetLinkPersistence
 * @see AssetLinkUtil
 * @generated
 */
public class AssetLinkPersistenceImpl extends BasePersistenceImpl<AssetLink>
	implements AssetLinkPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = AssetLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_E1 = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE1",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E1 = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE1", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_E2 = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE2",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E2 = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE2", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_E_E = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E_E = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE_E",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_E1_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE1_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E1_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE1_T",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_E2_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE2_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E2_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE2_T",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_E_E_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByE_E_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_E_E_T = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByE_E_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the asset link in the entity cache if it is enabled.
	 *
	 * @param assetLink the asset link to cache
	 */
	public void cacheResult(AssetLink assetLink) {
		EntityCacheUtil.putResult(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkImpl.class, assetLink.getPrimaryKey(), assetLink);
	}

	/**
	 * Caches the asset links in the entity cache if it is enabled.
	 *
	 * @param assetLinks the asset links to cache
	 */
	public void cacheResult(List<AssetLink> assetLinks) {
		for (AssetLink assetLink : assetLinks) {
			if (EntityCacheUtil.getResult(
						AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
						AssetLinkImpl.class, assetLink.getPrimaryKey(), this) == null) {
				cacheResult(assetLink);
			}
		}
	}

	/**
	 * Clears the cache for all asset links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(AssetLinkImpl.class.getName());
		EntityCacheUtil.clearCache(AssetLinkImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the asset link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(AssetLink assetLink) {
		EntityCacheUtil.removeResult(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkImpl.class, assetLink.getPrimaryKey());
	}

	/**
	 * Creates a new asset link with the primary key. Does not add the asset link to the database.
	 *
	 * @param linkId the primary key for the new asset link
	 * @return the new asset link
	 */
	public AssetLink create(long linkId) {
		AssetLink assetLink = new AssetLinkImpl();

		assetLink.setNew(true);
		assetLink.setPrimaryKey(linkId);

		return assetLink;
	}

	/**
	 * Removes the asset link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the asset link to remove
	 * @return the asset link that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the asset link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the asset link to remove
	 * @return the asset link that was removed
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink remove(long linkId)
		throws NoSuchLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AssetLink assetLink = (AssetLink)session.get(AssetLinkImpl.class,
					new Long(linkId));

			if (assetLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkId);
				}

				throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					linkId);
			}

			return remove(assetLink);
		}
		catch (NoSuchLinkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink removeImpl(AssetLink assetLink)
		throws SystemException {
		assetLink = toUnwrappedModel(assetLink);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, assetLink);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkImpl.class, assetLink.getPrimaryKey());

		return assetLink;
	}

	public AssetLink updateImpl(
		com.liferay.portlet.asset.model.AssetLink assetLink, boolean merge)
		throws SystemException {
		assetLink = toUnwrappedModel(assetLink);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, assetLink, merge);

			assetLink.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
			AssetLinkImpl.class, assetLink.getPrimaryKey(), assetLink);

		return assetLink;
	}

	protected AssetLink toUnwrappedModel(AssetLink assetLink) {
		if (assetLink instanceof AssetLinkImpl) {
			return assetLink;
		}

		AssetLinkImpl assetLinkImpl = new AssetLinkImpl();

		assetLinkImpl.setNew(assetLink.isNew());
		assetLinkImpl.setPrimaryKey(assetLink.getPrimaryKey());

		assetLinkImpl.setLinkId(assetLink.getLinkId());
		assetLinkImpl.setCompanyId(assetLink.getCompanyId());
		assetLinkImpl.setUserId(assetLink.getUserId());
		assetLinkImpl.setUserName(assetLink.getUserName());
		assetLinkImpl.setCreateDate(assetLink.getCreateDate());
		assetLinkImpl.setEntryId1(assetLink.getEntryId1());
		assetLinkImpl.setEntryId2(assetLink.getEntryId2());
		assetLinkImpl.setType(assetLink.getType());
		assetLinkImpl.setWeight(assetLink.getWeight());

		return assetLinkImpl;
	}

	/**
	 * Finds the asset link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the asset link to find
	 * @return the asset link
	 * @throws com.liferay.portal.NoSuchModelException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the asset link with the primary key or throws a {@link com.liferay.portlet.asset.NoSuchLinkException} if it could not be found.
	 *
	 * @param linkId the primary key of the asset link to find
	 * @return the asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByPrimaryKey(long linkId)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = fetchByPrimaryKey(linkId);

		if (assetLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkId);
			}

			throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				linkId);
		}

		return assetLink;
	}

	/**
	 * Finds the asset link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the asset link to find
	 * @return the asset link, or <code>null</code> if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the asset link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the asset link to find
	 * @return the asset link, or <code>null</code> if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink fetchByPrimaryKey(long linkId) throws SystemException {
		AssetLink assetLink = (AssetLink)EntityCacheUtil.getResult(AssetLinkModelImpl.ENTITY_CACHE_ENABLED,
				AssetLinkImpl.class, linkId, this);

		if (assetLink == null) {
			Session session = null;

			try {
				session = openSession();

				assetLink = (AssetLink)session.get(AssetLinkImpl.class,
						new Long(linkId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (assetLink != null) {
					cacheResult(assetLink);
				}

				closeSession(session);
			}
		}

		return assetLink;
	}

	/**
	 * Finds all the asset links where entryId1 = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1(long entryId1) throws SystemException {
		return findByE1(entryId1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the asset links where entryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1(long entryId1, int start, int end)
		throws SystemException {
		return findByE1(entryId1, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1(long entryId1, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId1,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E1,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E1_ENTRYID1_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E1,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E1,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE1_First(long entryId1,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE1(entryId1, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE1_Last(long entryId1,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE1(entryId1);

		List<AssetLink> list = findByE1(entryId1, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId1 the entry id1 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE1_PrevAndNext(long linkId, long entryId1,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE1_PrevAndNext(session, assetLink, entryId1,
					orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE1_PrevAndNext(session, assetLink, entryId1,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE1_PrevAndNext(Session session,
		AssetLink assetLink, long entryId1,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E1_ENTRYID1_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId1);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links where entryId2 = &#63;.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2(long entryId2) throws SystemException {
		return findByE2(entryId2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the asset links where entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2(long entryId2, int start, int end)
		throws SystemException {
		return findByE2(entryId2, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2(long entryId2, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId2,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E2,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E2_ENTRYID2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId2);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E2,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E2,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE2_First(long entryId2,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE2(entryId2, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId2=");
			msg.append(entryId2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE2_Last(long entryId2,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE2(entryId2);

		List<AssetLink> list = findByE2(entryId2, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId2=");
			msg.append(entryId2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE2_PrevAndNext(long linkId, long entryId2,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE2_PrevAndNext(session, assetLink, entryId2,
					orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE2_PrevAndNext(session, assetLink, entryId2,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE2_PrevAndNext(Session session,
		AssetLink assetLink, long entryId2,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E2_ENTRYID2_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E(long entryId1, long entryId2)
		throws SystemException {
		return findByE_E(entryId1, entryId2, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the asset links where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E(long entryId1, long entryId2, int start,
		int end) throws SystemException {
		return findByE_E(entryId1, entryId2, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E(long entryId1, long entryId2, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId1, entryId2,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E_E,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E_E_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E_E_ENTRYID2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(entryId2);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E_E,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E_E,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE_E_First(long entryId1, long entryId2,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE_E(entryId1, entryId2, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", entryId2=");
			msg.append(entryId2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE_E_Last(long entryId1, long entryId2,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE_E(entryId1, entryId2);

		List<AssetLink> list = findByE_E(entryId1, entryId2, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", entryId2=");
			msg.append(entryId2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE_E_PrevAndNext(long linkId, long entryId1,
		long entryId2, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE_E_PrevAndNext(session, assetLink, entryId1,
					entryId2, orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE_E_PrevAndNext(session, assetLink, entryId1,
					entryId2, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE_E_PrevAndNext(Session session,
		AssetLink assetLink, long entryId1, long entryId2,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E_E_ENTRYID1_2);

		query.append(_FINDER_COLUMN_E_E_ENTRYID2_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId1);

		qPos.add(entryId2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links where entryId1 = &#63; and type = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1_T(long entryId1, int type)
		throws SystemException {
		return findByE1_T(entryId1, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the asset links where entryId1 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1_T(long entryId1, int type, int start,
		int end) throws SystemException {
		return findByE1_T(entryId1, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId1 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE1_T(long entryId1, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId1, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E1_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E1_T_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E1_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(type);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E1_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E1_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId1 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE1_T_First(long entryId1, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE1_T(entryId1, type, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId1 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE1_T_Last(long entryId1, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE1_T(entryId1, type);

		List<AssetLink> list = findByE1_T(entryId1, type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId1 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE1_T_PrevAndNext(long linkId, long entryId1,
		int type, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE1_T_PrevAndNext(session, assetLink, entryId1,
					type, orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE1_T_PrevAndNext(session, assetLink, entryId1,
					type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE1_T_PrevAndNext(Session session,
		AssetLink assetLink, long entryId1, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E1_T_ENTRYID1_2);

		query.append(_FINDER_COLUMN_E1_T_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId1);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links where entryId2 = &#63; and type = &#63;.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2_T(long entryId2, int type)
		throws SystemException {
		return findByE2_T(entryId2, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the asset links where entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2_T(long entryId2, int type, int start,
		int end) throws SystemException {
		return findByE2_T(entryId2, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE2_T(long entryId2, int type, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId2, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E2_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E2_T_ENTRYID2_2);

			query.append(_FINDER_COLUMN_E2_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId2);

				qPos.add(type);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E2_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E2_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE2_T_First(long entryId2, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE2_T(entryId2, type, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId2=");
			msg.append(entryId2);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE2_T_Last(long entryId2, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE2_T(entryId2, type);

		List<AssetLink> list = findByE2_T(entryId2, type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId2=");
			msg.append(entryId2);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE2_T_PrevAndNext(long linkId, long entryId2,
		int type, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE2_T_PrevAndNext(session, assetLink, entryId2,
					type, orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE2_T_PrevAndNext(session, assetLink, entryId2,
					type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE2_T_PrevAndNext(Session session,
		AssetLink assetLink, long entryId2, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E2_T_ENTRYID2_2);

		query.append(_FINDER_COLUMN_E2_T_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId2);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @return the matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E_T(long entryId1, long entryId2, int type)
		throws SystemException {
		return findByE_E_T(entryId1, entryId2, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the asset links where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E_T(long entryId1, long entryId2, int type,
		int start, int end) throws SystemException {
		return findByE_E_T(entryId1, entryId2, type, start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findByE_E_T(long entryId1, long entryId2, int type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				entryId1, entryId2, type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_E_E_T,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E_E_T_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E_E_T_ENTRYID2_2);

			query.append(_FINDER_COLUMN_E_E_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(entryId2);

				qPos.add(type);

				list = (List<AssetLink>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_E_E_T,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_E_E_T,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE_E_T_First(long entryId1, long entryId2, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		List<AssetLink> list = findByE_E_T(entryId1, entryId2, type, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", entryId2=");
			msg.append(entryId2);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a matching asset link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink findByE_E_T_Last(long entryId1, long entryId2, int type,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		int count = countByE_E_T(entryId1, entryId2, type);

		List<AssetLink> list = findByE_E_T(entryId1, entryId2, type, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entryId1=");
			msg.append(entryId1);

			msg.append(", entryId2=");
			msg.append(entryId2);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchLinkException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the asset links before and after the current asset link in the ordered set where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param linkId the primary key of the current asset link
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next asset link
	 * @throws com.liferay.portlet.asset.NoSuchLinkException if a asset link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AssetLink[] findByE_E_T_PrevAndNext(long linkId, long entryId1,
		long entryId2, int type, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		AssetLink assetLink = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			AssetLink[] array = new AssetLinkImpl[3];

			array[0] = getByE_E_T_PrevAndNext(session, assetLink, entryId1,
					entryId2, type, orderByComparator, true);

			array[1] = assetLink;

			array[2] = getByE_E_T_PrevAndNext(session, assetLink, entryId1,
					entryId2, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssetLink getByE_E_T_PrevAndNext(Session session,
		AssetLink assetLink, long entryId1, long entryId2, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSETLINK_WHERE);

		query.append(_FINDER_COLUMN_E_E_T_ENTRYID1_2);

		query.append(_FINDER_COLUMN_E_E_T_ENTRYID2_2);

		query.append(_FINDER_COLUMN_E_E_T_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(AssetLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(entryId1);

		qPos.add(entryId2);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(assetLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssetLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the asset links.
	 *
	 * @return the asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the asset links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @return the range of asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the asset links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of asset links to return
	 * @param end the upper bound of the range of asset links to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of asset links
	 * @throws SystemException if a system exception occurred
	 */
	public List<AssetLink> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<AssetLink> list = (List<AssetLink>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSETLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSETLINK.concat(AssetLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AssetLink>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AssetLink>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the asset links where entryId1 = &#63; from the database.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE1(long entryId1) throws SystemException {
		for (AssetLink assetLink : findByE1(entryId1)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links where entryId2 = &#63; from the database.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE2(long entryId2) throws SystemException {
		for (AssetLink assetLink : findByE2(entryId2)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links where entryId1 = &#63; and entryId2 = &#63; from the database.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE_E(long entryId1, long entryId2)
		throws SystemException {
		for (AssetLink assetLink : findByE_E(entryId1, entryId2)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links where entryId1 = &#63; and type = &#63; from the database.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE1_T(long entryId1, int type) throws SystemException {
		for (AssetLink assetLink : findByE1_T(entryId1, type)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links where entryId2 = &#63; and type = &#63; from the database.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE2_T(long entryId2, int type) throws SystemException {
		for (AssetLink assetLink : findByE2_T(entryId2, type)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links where entryId1 = &#63; and entryId2 = &#63; and type = &#63; from the database.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByE_E_T(long entryId1, long entryId2, int type)
		throws SystemException {
		for (AssetLink assetLink : findByE_E_T(entryId1, entryId2, type)) {
			remove(assetLink);
		}
	}

	/**
	 * Removes all the asset links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AssetLink assetLink : findAll()) {
			remove(assetLink);
		}
	}

	/**
	 * Counts all the asset links where entryId1 = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE1(long entryId1) throws SystemException {
		Object[] finderArgs = new Object[] { entryId1 };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E1,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E1_ENTRYID1_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E1, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links where entryId2 = &#63;.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE2(long entryId2) throws SystemException {
		Object[] finderArgs = new Object[] { entryId2 };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E2,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E2_ENTRYID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId2);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E2, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links where entryId1 = &#63; and entryId2 = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE_E(long entryId1, long entryId2)
		throws SystemException {
		Object[] finderArgs = new Object[] { entryId1, entryId2 };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E_E,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E_E_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E_E_ENTRYID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(entryId2);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_E, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links where entryId1 = &#63; and type = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param type the type to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE1_T(long entryId1, int type) throws SystemException {
		Object[] finderArgs = new Object[] { entryId1, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E1_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E1_T_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E1_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E1_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links where entryId2 = &#63; and type = &#63;.
	 *
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE2_T(long entryId2, int type) throws SystemException {
		Object[] finderArgs = new Object[] { entryId2, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E2_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E2_T_ENTRYID2_2);

			query.append(_FINDER_COLUMN_E2_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId2);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E2_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links where entryId1 = &#63; and entryId2 = &#63; and type = &#63;.
	 *
	 * @param entryId1 the entry id1 to search with
	 * @param entryId2 the entry id2 to search with
	 * @param type the type to search with
	 * @return the number of matching asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByE_E_T(long entryId1, long entryId2, int type)
		throws SystemException {
		Object[] finderArgs = new Object[] { entryId1, entryId2, type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E_E_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ASSETLINK_WHERE);

			query.append(_FINDER_COLUMN_E_E_T_ENTRYID1_2);

			query.append(_FINDER_COLUMN_E_E_T_ENTRYID2_2);

			query.append(_FINDER_COLUMN_E_E_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entryId1);

				qPos.add(entryId2);

				qPos.add(type);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_E_T,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the asset links.
	 *
	 * @return the number of asset links
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ASSETLINK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the asset link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.asset.model.AssetLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AssetLink>> listenersList = new ArrayList<ModelListener<AssetLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AssetLink>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AssetLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = AssetCategoryPersistence.class)
	protected AssetCategoryPersistence assetCategoryPersistence;
	@BeanReference(type = AssetCategoryPropertyPersistence.class)
	protected AssetCategoryPropertyPersistence assetCategoryPropertyPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@BeanReference(type = AssetTagPropertyPersistence.class)
	protected AssetTagPropertyPersistence assetTagPropertyPersistence;
	@BeanReference(type = AssetTagStatsPersistence.class)
	protected AssetTagStatsPersistence assetTagStatsPersistence;
	@BeanReference(type = AssetVocabularyPersistence.class)
	protected AssetVocabularyPersistence assetVocabularyPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_ASSETLINK = "SELECT assetLink FROM AssetLink assetLink";
	private static final String _SQL_SELECT_ASSETLINK_WHERE = "SELECT assetLink FROM AssetLink assetLink WHERE ";
	private static final String _SQL_COUNT_ASSETLINK = "SELECT COUNT(assetLink) FROM AssetLink assetLink";
	private static final String _SQL_COUNT_ASSETLINK_WHERE = "SELECT COUNT(assetLink) FROM AssetLink assetLink WHERE ";
	private static final String _FINDER_COLUMN_E1_ENTRYID1_2 = "assetLink.entryId1 = ?";
	private static final String _FINDER_COLUMN_E2_ENTRYID2_2 = "assetLink.entryId2 = ?";
	private static final String _FINDER_COLUMN_E_E_ENTRYID1_2 = "assetLink.entryId1 = ? AND ";
	private static final String _FINDER_COLUMN_E_E_ENTRYID2_2 = "assetLink.entryId2 = ?";
	private static final String _FINDER_COLUMN_E1_T_ENTRYID1_2 = "assetLink.entryId1 = ? AND ";
	private static final String _FINDER_COLUMN_E1_T_TYPE_2 = "assetLink.type = ?";
	private static final String _FINDER_COLUMN_E2_T_ENTRYID2_2 = "assetLink.entryId2 = ? AND ";
	private static final String _FINDER_COLUMN_E2_T_TYPE_2 = "assetLink.type = ?";
	private static final String _FINDER_COLUMN_E_E_T_ENTRYID1_2 = "assetLink.entryId1 = ? AND ";
	private static final String _FINDER_COLUMN_E_E_T_ENTRYID2_2 = "assetLink.entryId2 = ? AND ";
	private static final String _FINDER_COLUMN_E_E_T_TYPE_2 = "assetLink.type = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assetLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AssetLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AssetLink exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(AssetLinkPersistenceImpl.class);
}