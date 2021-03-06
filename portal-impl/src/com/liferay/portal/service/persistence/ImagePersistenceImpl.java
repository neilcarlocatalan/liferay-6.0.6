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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchImageException;
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
import com.liferay.portal.model.Image;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.impl.ImageImpl;
import com.liferay.portal.model.impl.ImageModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.imagegallery.service.persistence.IGImagePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the image service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ImageUtil} to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImagePersistence
 * @see ImageUtil
 * @generated
 */
public class ImagePersistenceImpl extends BasePersistenceImpl<Image>
	implements ImagePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LTSIZE = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByLtSize",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LTSIZE = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByLtSize", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image to cache
	 */
	public void cacheResult(Image image) {
		EntityCacheUtil.putResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey(), image);
	}

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images to cache
	 */
	public void cacheResult(List<Image> images) {
		for (Image image : images) {
			if (EntityCacheUtil.getResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
						ImageImpl.class, image.getPrimaryKey(), this) == null) {
				cacheResult(image);
			}
		}
	}

	/**
	 * Clears the cache for all images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ImageImpl.class.getName());
		EntityCacheUtil.clearCache(ImageImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Image image) {
		EntityCacheUtil.removeResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey());
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param imageId the primary key for the new image
	 * @return the new image
	 */
	public Image create(long imageId) {
		Image image = new ImageImpl();

		image.setNew(true);
		image.setPrimaryKey(imageId);

		return image;
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the image to remove
	 * @return the image that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the image to remove
	 * @return the image that was removed
	 * @throws com.liferay.portal.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image remove(long imageId)
		throws NoSuchImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Image image = (Image)session.get(ImageImpl.class, new Long(imageId));

			if (image == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + imageId);
				}

				throw new NoSuchImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					imageId);
			}

			return remove(image);
		}
		catch (NoSuchImageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image removeImpl(Image image) throws SystemException {
		image = toUnwrappedModel(image);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, image);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey());

		return image;
	}

	public Image updateImpl(com.liferay.portal.model.Image image, boolean merge)
		throws SystemException {
		image = toUnwrappedModel(image);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, image, merge);

			image.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageImpl.class, image.getPrimaryKey(), image);

		return image;
	}

	protected Image toUnwrappedModel(Image image) {
		if (image instanceof ImageImpl) {
			return image;
		}

		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setNew(image.isNew());
		imageImpl.setPrimaryKey(image.getPrimaryKey());

		imageImpl.setImageId(image.getImageId());
		imageImpl.setModifiedDate(image.getModifiedDate());
		imageImpl.setText(image.getText());
		imageImpl.setType(image.getType());
		imageImpl.setHeight(image.getHeight());
		imageImpl.setWidth(image.getWidth());
		imageImpl.setSize(image.getSize());

		return imageImpl;
	}

	/**
	 * Finds the image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the image to find
	 * @return the image
	 * @throws com.liferay.portal.NoSuchModelException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the image with the primary key or throws a {@link com.liferay.portal.NoSuchImageException} if it could not be found.
	 *
	 * @param imageId the primary key of the image to find
	 * @return the image
	 * @throws com.liferay.portal.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image findByPrimaryKey(long imageId)
		throws NoSuchImageException, SystemException {
		Image image = fetchByPrimaryKey(imageId);

		if (image == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + imageId);
			}

			throw new NoSuchImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				imageId);
		}

		return image;
	}

	/**
	 * Finds the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image to find
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image to find
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image fetchByPrimaryKey(long imageId) throws SystemException {
		Image image = (Image)EntityCacheUtil.getResult(ImageModelImpl.ENTITY_CACHE_ENABLED,
				ImageImpl.class, imageId, this);

		if (image == null) {
			Session session = null;

			try {
				session = openSession();

				image = (Image)session.get(ImageImpl.class, new Long(imageId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (image != null) {
					cacheResult(image);
				}

				closeSession(session);
			}
		}

		return image;
	}

	/**
	 * Finds all the images where size &lt; &#63;.
	 *
	 * @param size the size to search with
	 * @return the matching images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findByLtSize(int size) throws SystemException {
		return findByLtSize(size, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the images where size &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param size the size to search with
	 * @param start the lower bound of the range of images to return
	 * @param end the upper bound of the range of images to return (not inclusive)
	 * @return the range of matching images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findByLtSize(int size, int start, int end)
		throws SystemException {
		return findByLtSize(size, start, end, null);
	}

	/**
	 * Finds an ordered range of all the images where size &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param size the size to search with
	 * @param start the lower bound of the range of images to return
	 * @param end the upper bound of the range of images to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findByLtSize(int size, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				size,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Image> list = (List<Image>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LTSIZE,
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

			query.append(_SQL_SELECT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_LTSIZE_SIZE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(size);

				list = (List<Image>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_LTSIZE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LTSIZE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first image in the ordered set where size &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param size the size to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching image
	 * @throws com.liferay.portal.NoSuchImageException if a matching image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image findByLtSize_First(int size,
		OrderByComparator orderByComparator)
		throws NoSuchImageException, SystemException {
		List<Image> list = findByLtSize(size, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("size=");
			msg.append(size);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last image in the ordered set where size &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param size the size to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching image
	 * @throws com.liferay.portal.NoSuchImageException if a matching image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image findByLtSize_Last(int size, OrderByComparator orderByComparator)
		throws NoSuchImageException, SystemException {
		int count = countByLtSize(size);

		List<Image> list = findByLtSize(size, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("size=");
			msg.append(size);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchImageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the images before and after the current image in the ordered set where size &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param imageId the primary key of the current image
	 * @param size the size to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next image
	 * @throws com.liferay.portal.NoSuchImageException if a image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Image[] findByLtSize_PrevAndNext(long imageId, int size,
		OrderByComparator orderByComparator)
		throws NoSuchImageException, SystemException {
		Image image = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByLtSize_PrevAndNext(session, image, size,
					orderByComparator, true);

			array[1] = image;

			array[2] = getByLtSize_PrevAndNext(session, image, size,
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

	protected Image getByLtSize_PrevAndNext(Session session, Image image,
		int size, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMAGE_WHERE);

		query.append(_FINDER_COLUMN_LTSIZE_SIZE_2);

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
			query.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(size);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(image);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Image> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the images.
	 *
	 * @return the images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of images to return
	 * @param end the upper bound of the range of images to return (not inclusive)
	 * @return the range of images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of images to return
	 * @param end the upper bound of the range of images to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of images
	 * @throws SystemException if a system exception occurred
	 */
	public List<Image> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Image> list = (List<Image>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGE.concat(ImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Image>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the images where size &lt; &#63; from the database.
	 *
	 * @param size the size to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLtSize(int size) throws SystemException {
		for (Image image : findByLtSize(size)) {
			remove(image);
		}
	}

	/**
	 * Removes all the images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Image image : findAll()) {
			remove(image);
		}
	}

	/**
	 * Counts all the images where size &lt; &#63;.
	 *
	 * @param size the size to search with
	 * @return the number of matching images
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLtSize(int size) throws SystemException {
		Object[] finderArgs = new Object[] { size };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LTSIZE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_LTSIZE_SIZE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(size);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LTSIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the images.
	 *
	 * @return the number of images
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

				Query q = session.createQuery(_SQL_COUNT_IMAGE);

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
	 * Initializes the image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.Image")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Image>> listenersList = new ArrayList<ModelListener<Image>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Image>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = BrowserTrackerPersistence.class)
	protected BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ClusterGroupPersistence.class)
	protected ClusterGroupPersistence clusterGroupPersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = EmailAddressPersistence.class)
	protected EmailAddressPersistence emailAddressPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = LayoutPersistence.class)
	protected LayoutPersistence layoutPersistence;
	@BeanReference(type = LayoutPrototypePersistence.class)
	protected LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(type = LayoutSetPersistence.class)
	protected LayoutSetPersistence layoutSetPersistence;
	@BeanReference(type = LayoutSetPrototypePersistence.class)
	protected LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(type = ListTypePersistence.class)
	protected ListTypePersistence listTypePersistence;
	@BeanReference(type = LockPersistence.class)
	protected LockPersistence lockPersistence;
	@BeanReference(type = MembershipRequestPersistence.class)
	protected MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrgGroupPermissionPersistence.class)
	protected OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(type = OrgGroupRolePersistence.class)
	protected OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(type = OrgLaborPersistence.class)
	protected OrgLaborPersistence orgLaborPersistence;
	@BeanReference(type = PasswordPolicyPersistence.class)
	protected PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(type = PasswordPolicyRelPersistence.class)
	protected PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(type = PasswordTrackerPersistence.class)
	protected PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(type = PermissionPersistence.class)
	protected PermissionPersistence permissionPersistence;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = PluginSettingPersistence.class)
	protected PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = PortletItemPersistence.class)
	protected PortletItemPersistence portletItemPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;
	@BeanReference(type = ResourceCodePersistence.class)
	protected ResourceCodePersistence resourceCodePersistence;
	@BeanReference(type = ResourcePermissionPersistence.class)
	protected ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = ServiceComponentPersistence.class)
	protected ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(type = ShardPersistence.class)
	protected ShardPersistence shardPersistence;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = TeamPersistence.class)
	protected TeamPersistence teamPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupGroupRolePersistence.class)
	protected UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(type = UserGroupRolePersistence.class)
	protected UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(type = UserIdMapperPersistence.class)
	protected UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(type = UserTrackerPersistence.class)
	protected UserTrackerPersistence userTrackerPersistence;
	@BeanReference(type = UserTrackerPathPersistence.class)
	protected UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(type = WebDAVPropsPersistence.class)
	protected WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(type = WebsitePersistence.class)
	protected WebsitePersistence websitePersistence;
	@BeanReference(type = WorkflowDefinitionLinkPersistence.class)
	protected WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	@BeanReference(type = IGImagePersistence.class)
	protected IGImagePersistence igImagePersistence;
	private static final String _SQL_SELECT_IMAGE = "SELECT image FROM Image image";
	private static final String _SQL_SELECT_IMAGE_WHERE = "SELECT image FROM Image image WHERE ";
	private static final String _SQL_COUNT_IMAGE = "SELECT COUNT(image) FROM Image image";
	private static final String _SQL_COUNT_IMAGE_WHERE = "SELECT COUNT(image) FROM Image image WHERE ";
	private static final String _FINDER_COLUMN_LTSIZE_SIZE_2 = "image.size < ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "image.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Image exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Image exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ImagePersistenceImpl.class);
}