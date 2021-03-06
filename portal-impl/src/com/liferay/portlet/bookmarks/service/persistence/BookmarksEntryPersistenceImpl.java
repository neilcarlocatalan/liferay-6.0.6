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

package com.liferay.portlet.bookmarks.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistence;
import com.liferay.portlet.bookmarks.NoSuchEntryException;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.impl.BookmarksEntryImpl;
import com.liferay.portlet.bookmarks.model.impl.BookmarksEntryModelImpl;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bookmarks entry service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link BookmarksEntryUtil} to access the bookmarks entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookmarksEntryPersistence
 * @see BookmarksEntryUtil
 * @generated
 */
public class BookmarksEntryPersistenceImpl extends BasePersistenceImpl<BookmarksEntry>
	implements BookmarksEntryPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = BookmarksEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_U = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_G_F = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByG_F",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_G_F = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByG_F",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the bookmarks entry in the entity cache if it is enabled.
	 *
	 * @param bookmarksEntry the bookmarks entry to cache
	 */
	public void cacheResult(BookmarksEntry bookmarksEntry) {
		EntityCacheUtil.putResult(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryImpl.class, bookmarksEntry.getPrimaryKey(),
			bookmarksEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				bookmarksEntry.getUuid(), new Long(bookmarksEntry.getGroupId())
			}, bookmarksEntry);
	}

	/**
	 * Caches the bookmarks entries in the entity cache if it is enabled.
	 *
	 * @param bookmarksEntries the bookmarks entries to cache
	 */
	public void cacheResult(List<BookmarksEntry> bookmarksEntries) {
		for (BookmarksEntry bookmarksEntry : bookmarksEntries) {
			if (EntityCacheUtil.getResult(
						BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
						BookmarksEntryImpl.class,
						bookmarksEntry.getPrimaryKey(), this) == null) {
				cacheResult(bookmarksEntry);
			}
		}
	}

	/**
	 * Clears the cache for all bookmarks entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(BookmarksEntryImpl.class.getName());
		EntityCacheUtil.clearCache(BookmarksEntryImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the bookmarks entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(BookmarksEntry bookmarksEntry) {
		EntityCacheUtil.removeResult(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryImpl.class, bookmarksEntry.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				bookmarksEntry.getUuid(), new Long(bookmarksEntry.getGroupId())
			});
	}

	/**
	 * Creates a new bookmarks entry with the primary key. Does not add the bookmarks entry to the database.
	 *
	 * @param entryId the primary key for the new bookmarks entry
	 * @return the new bookmarks entry
	 */
	public BookmarksEntry create(long entryId) {
		BookmarksEntry bookmarksEntry = new BookmarksEntryImpl();

		bookmarksEntry.setNew(true);
		bookmarksEntry.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		bookmarksEntry.setUuid(uuid);

		return bookmarksEntry;
	}

	/**
	 * Removes the bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bookmarks entry to remove
	 * @return the bookmarks entry that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the bookmarks entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the bookmarks entry to remove
	 * @return the bookmarks entry that was removed
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry remove(long entryId)
		throws NoSuchEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BookmarksEntry bookmarksEntry = (BookmarksEntry)session.get(BookmarksEntryImpl.class,
					new Long(entryId));

			if (bookmarksEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					entryId);
			}

			return remove(bookmarksEntry);
		}
		catch (NoSuchEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookmarksEntry removeImpl(BookmarksEntry bookmarksEntry)
		throws SystemException {
		bookmarksEntry = toUnwrappedModel(bookmarksEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bookmarksEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		BookmarksEntryModelImpl bookmarksEntryModelImpl = (BookmarksEntryModelImpl)bookmarksEntry;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				bookmarksEntryModelImpl.getUuid(),
				new Long(bookmarksEntryModelImpl.getGroupId())
			});

		EntityCacheUtil.removeResult(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryImpl.class, bookmarksEntry.getPrimaryKey());

		return bookmarksEntry;
	}

	public BookmarksEntry updateImpl(
		com.liferay.portlet.bookmarks.model.BookmarksEntry bookmarksEntry,
		boolean merge) throws SystemException {
		bookmarksEntry = toUnwrappedModel(bookmarksEntry);

		boolean isNew = bookmarksEntry.isNew();

		BookmarksEntryModelImpl bookmarksEntryModelImpl = (BookmarksEntryModelImpl)bookmarksEntry;

		if (Validator.isNull(bookmarksEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bookmarksEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bookmarksEntry, merge);

			bookmarksEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
			BookmarksEntryImpl.class, bookmarksEntry.getPrimaryKey(),
			bookmarksEntry);

		if (!isNew &&
				(!Validator.equals(bookmarksEntry.getUuid(),
					bookmarksEntryModelImpl.getOriginalUuid()) ||
				(bookmarksEntry.getGroupId() != bookmarksEntryModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					bookmarksEntryModelImpl.getOriginalUuid(),
					new Long(bookmarksEntryModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(bookmarksEntry.getUuid(),
					bookmarksEntryModelImpl.getOriginalUuid()) ||
				(bookmarksEntry.getGroupId() != bookmarksEntryModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					bookmarksEntry.getUuid(),
					new Long(bookmarksEntry.getGroupId())
				}, bookmarksEntry);
		}

		return bookmarksEntry;
	}

	protected BookmarksEntry toUnwrappedModel(BookmarksEntry bookmarksEntry) {
		if (bookmarksEntry instanceof BookmarksEntryImpl) {
			return bookmarksEntry;
		}

		BookmarksEntryImpl bookmarksEntryImpl = new BookmarksEntryImpl();

		bookmarksEntryImpl.setNew(bookmarksEntry.isNew());
		bookmarksEntryImpl.setPrimaryKey(bookmarksEntry.getPrimaryKey());

		bookmarksEntryImpl.setUuid(bookmarksEntry.getUuid());
		bookmarksEntryImpl.setEntryId(bookmarksEntry.getEntryId());
		bookmarksEntryImpl.setGroupId(bookmarksEntry.getGroupId());
		bookmarksEntryImpl.setCompanyId(bookmarksEntry.getCompanyId());
		bookmarksEntryImpl.setUserId(bookmarksEntry.getUserId());
		bookmarksEntryImpl.setCreateDate(bookmarksEntry.getCreateDate());
		bookmarksEntryImpl.setModifiedDate(bookmarksEntry.getModifiedDate());
		bookmarksEntryImpl.setFolderId(bookmarksEntry.getFolderId());
		bookmarksEntryImpl.setName(bookmarksEntry.getName());
		bookmarksEntryImpl.setUrl(bookmarksEntry.getUrl());
		bookmarksEntryImpl.setComments(bookmarksEntry.getComments());
		bookmarksEntryImpl.setVisits(bookmarksEntry.getVisits());
		bookmarksEntryImpl.setPriority(bookmarksEntry.getPriority());

		return bookmarksEntryImpl;
	}

	/**
	 * Finds the bookmarks entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bookmarks entry to find
	 * @return the bookmarks entry
	 * @throws com.liferay.portal.NoSuchModelException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the bookmarks entry with the primary key or throws a {@link com.liferay.portlet.bookmarks.NoSuchEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the bookmarks entry to find
	 * @return the bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByPrimaryKey(long entryId)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = fetchByPrimaryKey(entryId);

		if (bookmarksEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return bookmarksEntry;
	}

	/**
	 * Finds the bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bookmarks entry to find
	 * @return the bookmarks entry, or <code>null</code> if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the bookmarks entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the bookmarks entry to find
	 * @return the bookmarks entry, or <code>null</code> if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry fetchByPrimaryKey(long entryId)
		throws SystemException {
		BookmarksEntry bookmarksEntry = (BookmarksEntry)EntityCacheUtil.getResult(BookmarksEntryModelImpl.ENTITY_CACHE_ENABLED,
				BookmarksEntryImpl.class, entryId, this);

		if (bookmarksEntry == null) {
			Session session = null;

			try {
				session = openSession();

				bookmarksEntry = (BookmarksEntry)session.get(BookmarksEntryImpl.class,
						new Long(entryId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (bookmarksEntry != null) {
					cacheResult(bookmarksEntry);
				}

				closeSession(session);
			}
		}

		return bookmarksEntry;
	}

	/**
	 * Finds all the bookmarks entries where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the bookmarks entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<BookmarksEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first bookmarks entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<BookmarksEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last bookmarks entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByUuid(uuid);

		List<BookmarksEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the bookmarks entries before and after the current bookmarks entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the primary key of the current bookmarks entry
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry[] findByUuid_PrevAndNext(long entryId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			BookmarksEntry[] array = new BookmarksEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, bookmarksEntry, uuid,
					orderByComparator, true);

			array[1] = bookmarksEntry;

			array[2] = getByUuid_PrevAndNext(session, bookmarksEntry, uuid,
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

	protected BookmarksEntry getByUuid_PrevAndNext(Session session,
		BookmarksEntry bookmarksEntry, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

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
			query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(bookmarksEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookmarksEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the bookmarks entry where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.bookmarks.NoSuchEntryException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = fetchByUUID_G(uuid, groupId);

		if (bookmarksEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return bookmarksEntry;
	}

	/**
	 * Finds the bookmarks entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching bookmarks entry, or <code>null</code> if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the bookmarks entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching bookmarks entry, or <code>null</code> if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<BookmarksEntry> list = q.list();

				result = list;

				BookmarksEntry bookmarksEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					bookmarksEntry = list.get(0);

					cacheResult(bookmarksEntry);

					if ((bookmarksEntry.getUuid() == null) ||
							!bookmarksEntry.getUuid().equals(uuid) ||
							(bookmarksEntry.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, bookmarksEntry);
					}
				}

				return bookmarksEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (BookmarksEntry)result;
			}
		}
	}

	/**
	 * Finds all the bookmarks entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the bookmarks entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
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

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<BookmarksEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first bookmarks entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<BookmarksEntry> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last bookmarks entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByGroupId(groupId);

		List<BookmarksEntry> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the bookmarks entries before and after the current bookmarks entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the primary key of the current bookmarks entry
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry[] findByGroupId_PrevAndNext(long entryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			BookmarksEntry[] array = new BookmarksEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, bookmarksEntry,
					groupId, orderByComparator, true);

			array[1] = bookmarksEntry;

			array[2] = getByGroupId_PrevAndNext(session, bookmarksEntry,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookmarksEntry getByGroupId_PrevAndNext(Session session,
		BookmarksEntry bookmarksEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(bookmarksEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookmarksEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the bookmarks entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the bookmarks entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByGroupId(long groupId, int start,
		int end) throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the bookmarks entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BookmarksEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BookmarksEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<BookmarksEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_U(long groupId, long userId)
		throws SystemException {
		return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_U(long groupId, long userId, int start,
		int end) throws SystemException {
		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_U,
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

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				list = (List<BookmarksEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_U,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_U,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first bookmarks entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<BookmarksEntry> list = findByG_U(groupId, userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last bookmarks entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByG_U(groupId, userId);

		List<BookmarksEntry> list = findByG_U(groupId, userId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the bookmarks entries before and after the current bookmarks entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the primary key of the current bookmarks entry
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry[] findByG_U_PrevAndNext(long entryId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			BookmarksEntry[] array = new BookmarksEntryImpl[3];

			array[0] = getByG_U_PrevAndNext(session, bookmarksEntry, groupId,
					userId, orderByComparator, true);

			array[1] = bookmarksEntry;

			array[2] = getByG_U_PrevAndNext(session, bookmarksEntry, groupId,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookmarksEntry getByG_U_PrevAndNext(Session session,
		BookmarksEntry bookmarksEntry, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

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
			query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(bookmarksEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookmarksEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Filters by the user's permissions and finds all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_U(long groupId, long userId)
		throws SystemException {
		return filterFindByG_U(groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_U(long groupId, long userId,
		int start, int end) throws SystemException {
		return filterFindByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_U(long groupId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_U(groupId, userId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BookmarksEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BookmarksEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<BookmarksEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @return the matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long folderId)
		throws SystemException {
		return findByG_F(groupId, folderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long folderId,
		int start, int end) throws SystemException {
		return findByG_F(groupId, folderId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long folderId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, folderId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_F,
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

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_F_FOLDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(folderId);

				list = (List<BookmarksEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_F,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_F,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first bookmarks entry in the ordered set where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByG_F_First(long groupId, long folderId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<BookmarksEntry> list = findByG_F(groupId, folderId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", folderId=");
			msg.append(folderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last bookmarks entry in the ordered set where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a matching bookmarks entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry findByG_F_Last(long groupId, long folderId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByG_F(groupId, folderId);

		List<BookmarksEntry> list = findByG_F(groupId, folderId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", folderId=");
			msg.append(folderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the bookmarks entries before and after the current bookmarks entry in the ordered set where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryId the primary key of the current bookmarks entry
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next bookmarks entry
	 * @throws com.liferay.portlet.bookmarks.NoSuchEntryException if a bookmarks entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BookmarksEntry[] findByG_F_PrevAndNext(long entryId, long groupId,
		long folderId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			BookmarksEntry[] array = new BookmarksEntryImpl[3];

			array[0] = getByG_F_PrevAndNext(session, bookmarksEntry, groupId,
					folderId, orderByComparator, true);

			array[1] = bookmarksEntry;

			array[2] = getByG_F_PrevAndNext(session, bookmarksEntry, groupId,
					folderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookmarksEntry getByG_F_PrevAndNext(Session session,
		BookmarksEntry bookmarksEntry, long groupId, long folderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_F_GROUPID_2);

		query.append(_FINDER_COLUMN_G_F_FOLDERID_2);

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
			query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(folderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(bookmarksEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BookmarksEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @return the matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long[] folderIds)
		throws SystemException {
		return findByG_F(groupId, folderIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long[] folderIds,
		int start, int end) throws SystemException {
		return findByG_F(groupId, folderIds, start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findByG_F(long groupId, long[] folderIds,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, StringUtil.merge(folderIds),
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_F,
				finderArgs, this);

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_BOOKMARKSENTRY_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_F_GROUPID_5);

			conjunctionable = true;

			if ((folderIds == null) || (folderIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < folderIds.length; i++) {
					query.append(_FINDER_COLUMN_G_F_FOLDERID_5);

					if ((i + 1) < folderIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (folderIds != null) {
					qPos.add(folderIds);
				}

				list = (List<BookmarksEntry>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_G_F,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_F,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Filters by the user's permissions and finds all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @return the matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long folderId)
		throws SystemException {
		return filterFindByG_F(groupId, folderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long folderId,
		int start, int end) throws SystemException {
		return filterFindByG_F(groupId, folderId, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long folderId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_F(groupId, folderId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_F_GROUPID_2);

		query.append(_FINDER_COLUMN_G_F_FOLDERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BookmarksEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BookmarksEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(folderId);

			return (List<BookmarksEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Filters by the user's permissions and finds all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @return the matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long[] folderIds)
		throws SystemException {
		return filterFindByG_F(groupId, folderIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Filters by the user's permissions and finds a range of all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long[] folderIds,
		int start, int end) throws SystemException {
		return filterFindByG_F(groupId, folderIds, start, end, null);
	}

	/**
	 * Filters by the user's permissions and finds an ordered range of all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> filterFindByG_F(long groupId, long[] folderIds,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_F(groupId, folderIds, start, end, orderByComparator);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_F_GROUPID_5);

		conjunctionable = true;

		if ((folderIds == null) || (folderIds.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < folderIds.length; i++) {
				query.append(_FINDER_COLUMN_G_F_FOLDERID_5);

				if ((i + 1) < folderIds.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(BookmarksEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, BookmarksEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, BookmarksEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (folderIds != null) {
				qPos.add(folderIds);
			}

			return (List<BookmarksEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Finds all the bookmarks entries.
	 *
	 * @return the bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the bookmarks entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @return the range of bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the bookmarks entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookmarks entries to return
	 * @param end the upper bound of the range of bookmarks entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<BookmarksEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<BookmarksEntry> list = (List<BookmarksEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKMARKSENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKMARKSENTRY.concat(BookmarksEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BookmarksEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BookmarksEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the bookmarks entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (BookmarksEntry bookmarksEntry : findByUuid(uuid)) {
			remove(bookmarksEntry);
		}
	}

	/**
	 * Removes the bookmarks entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException, SystemException {
		BookmarksEntry bookmarksEntry = findByUUID_G(uuid, groupId);

		remove(bookmarksEntry);
	}

	/**
	 * Removes all the bookmarks entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (BookmarksEntry bookmarksEntry : findByGroupId(groupId)) {
			remove(bookmarksEntry);
		}
	}

	/**
	 * Removes all the bookmarks entries where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_U(long groupId, long userId)
		throws SystemException {
		for (BookmarksEntry bookmarksEntry : findByG_U(groupId, userId)) {
			remove(bookmarksEntry);
		}
	}

	/**
	 * Removes all the bookmarks entries where groupId = &#63; and folderId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_F(long groupId, long folderId)
		throws SystemException {
		for (BookmarksEntry bookmarksEntry : findByG_F(groupId, folderId)) {
			remove(bookmarksEntry);
		}
	}

	/**
	 * Removes all the bookmarks entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BookmarksEntry bookmarksEntry : findAll()) {
			remove(bookmarksEntry);
		}
	}

	/**
	 * Counts all the bookmarks entries where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the bookmarks entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the bookmarks entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the bookmarks entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_U(long groupId, long userId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_U, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the bookmarks entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param userId the user id to search with
	 * @return the number of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_U(long groupId, long userId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_U(groupId, userId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_F(long groupId, long folderId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, folderId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_F,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_F_GROUPID_2);

			query.append(_FINDER_COLUMN_G_F_FOLDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(folderId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @return the number of matching bookmarks entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_F(long groupId, long[] folderIds)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, StringUtil.merge(folderIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_F,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_BOOKMARKSENTRY_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_F_GROUPID_5);

			conjunctionable = true;

			if ((folderIds == null) || (folderIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < folderIds.length; i++) {
					query.append(_FINDER_COLUMN_G_F_FOLDERID_5);

					if ((i + 1) < folderIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (folderIds != null) {
					qPos.add(folderIds);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_F, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Filters by the user's permissions and counts all the bookmarks entries where groupId = &#63; and folderId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderId the folder id to search with
	 * @return the number of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_F(long groupId, long folderId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_F(groupId, folderId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_BOOKMARKSENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_F_GROUPID_2);

		query.append(_FINDER_COLUMN_G_F_FOLDERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(folderId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Filters by the user's permissions and counts all the bookmarks entries where groupId = &#63; and folderId = any &#63;.
	 *
	 * @param groupId the group id to search with
	 * @param folderIds the folder ids to search with
	 * @return the number of matching bookmarks entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByG_F(long groupId, long[] folderIds)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_F(groupId, folderIds);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_BOOKMARKSENTRY_WHERE);

		boolean conjunctionable = false;

		if (conjunctionable) {
			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_F_GROUPID_5);

		conjunctionable = true;

		if ((folderIds == null) || (folderIds.length > 0)) {
			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(StringPool.OPEN_PARENTHESIS);

			for (int i = 0; i < folderIds.length; i++) {
				query.append(_FINDER_COLUMN_G_F_FOLDERID_5);

				if ((i + 1) < folderIds.length) {
					query.append(WHERE_OR);
				}
			}

			query.append(StringPool.CLOSE_PARENTHESIS);

			conjunctionable = true;
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				BookmarksEntry.class.getName(), _FILTER_COLUMN_PK,
				_FILTER_COLUMN_USERID, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (folderIds != null) {
				qPos.add(folderIds);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Counts all the bookmarks entries.
	 *
	 * @return the number of bookmarks entries
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

				Query q = session.createQuery(_SQL_COUNT_BOOKMARKSENTRY);

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
	 * Initializes the bookmarks entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.bookmarks.model.BookmarksEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BookmarksEntry>> listenersList = new ArrayList<ModelListener<BookmarksEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BookmarksEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BookmarksEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = BookmarksEntryPersistence.class)
	protected BookmarksEntryPersistence bookmarksEntryPersistence;
	@BeanReference(type = BookmarksFolderPersistence.class)
	protected BookmarksFolderPersistence bookmarksFolderPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	private static final String _SQL_SELECT_BOOKMARKSENTRY = "SELECT bookmarksEntry FROM BookmarksEntry bookmarksEntry";
	private static final String _SQL_SELECT_BOOKMARKSENTRY_WHERE = "SELECT bookmarksEntry FROM BookmarksEntry bookmarksEntry WHERE ";
	private static final String _SQL_COUNT_BOOKMARKSENTRY = "SELECT COUNT(bookmarksEntry) FROM BookmarksEntry bookmarksEntry";
	private static final String _SQL_COUNT_BOOKMARKSENTRY_WHERE = "SELECT COUNT(bookmarksEntry) FROM BookmarksEntry bookmarksEntry WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "bookmarksEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "bookmarksEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(bookmarksEntry.uuid IS NULL OR bookmarksEntry.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "bookmarksEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "bookmarksEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(bookmarksEntry.uuid IS NULL OR bookmarksEntry.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "bookmarksEntry.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "bookmarksEntry.groupId = ?";
	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "bookmarksEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "bookmarksEntry.userId = ?";
	private static final String _FINDER_COLUMN_G_F_GROUPID_2 = "bookmarksEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_F_GROUPID_5 = "(" +
		_removeConjunction(_FINDER_COLUMN_G_F_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_G_F_FOLDERID_2 = "bookmarksEntry.folderId = ?";
	private static final String _FINDER_COLUMN_G_F_FOLDERID_5 = "(" +
		_removeConjunction(_FINDER_COLUMN_G_F_FOLDERID_2) + ")";

	private static String _removeConjunction(String sql) {
		int pos = sql.indexOf(" AND ");

		if (pos != -1) {
			sql = sql.substring(0, pos);
		}

		return sql;
	}

	private static final String _FILTER_SQL_SELECT_BOOKMARKSENTRY_WHERE = "SELECT DISTINCT {bookmarksEntry.*} FROM BookmarksEntry bookmarksEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {BookmarksEntry.*} FROM (SELECT DISTINCT bookmarksEntry.entryId FROM BookmarksEntry bookmarksEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_BOOKMARKSENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN BookmarksEntry ON TEMP_TABLE.entryId = BookmarksEntry.entryId";
	private static final String _FILTER_SQL_COUNT_BOOKMARKSENTRY_WHERE = "SELECT COUNT(DISTINCT bookmarksEntry.entryId) AS COUNT_VALUE FROM BookmarksEntry bookmarksEntry WHERE ";
	private static final String _FILTER_COLUMN_PK = "bookmarksEntry.entryId";
	private static final String _FILTER_COLUMN_USERID = "bookmarksEntry.userId";
	private static final String _FILTER_ENTITY_ALIAS = "bookmarksEntry";
	private static final String _FILTER_ENTITY_TABLE = "BookmarksEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookmarksEntry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "BookmarksEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookmarksEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BookmarksEntry exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(BookmarksEntryPersistenceImpl.class);
}