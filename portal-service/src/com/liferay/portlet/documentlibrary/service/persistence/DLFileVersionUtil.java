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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.documentlibrary.model.DLFileVersion;

import java.util.List;

/**
 * The persistence utility for the d l file version service. This utility wraps {@link DLFileVersionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionPersistence
 * @see DLFileVersionPersistenceImpl
 * @generated
 */
public class DLFileVersionUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DLFileVersion dlFileVersion) {
		getPersistence().clearCache(dlFileVersion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DLFileVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DLFileVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DLFileVersion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static DLFileVersion remove(DLFileVersion dlFileVersion)
		throws SystemException {
		return getPersistence().remove(dlFileVersion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DLFileVersion update(DLFileVersion dlFileVersion,
		boolean merge) throws SystemException {
		return getPersistence().update(dlFileVersion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DLFileVersion update(DLFileVersion dlFileVersion,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dlFileVersion, merge, serviceContext);
	}

	/**
	* Caches the d l file version in the entity cache if it is enabled.
	*
	* @param dlFileVersion the d l file version to cache
	*/
	public static void cacheResult(
		com.liferay.portlet.documentlibrary.model.DLFileVersion dlFileVersion) {
		getPersistence().cacheResult(dlFileVersion);
	}

	/**
	* Caches the d l file versions in the entity cache if it is enabled.
	*
	* @param dlFileVersions the d l file versions to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> dlFileVersions) {
		getPersistence().cacheResult(dlFileVersions);
	}

	/**
	* Creates a new d l file version with the primary key. Does not add the d l file version to the database.
	*
	* @param fileVersionId the primary key for the new d l file version
	* @return the new d l file version
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion create(
		long fileVersionId) {
		return getPersistence().create(fileVersionId);
	}

	/**
	* Removes the d l file version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileVersionId the primary key of the d l file version to remove
	* @return the d l file version that was removed
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a d l file version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion remove(
		long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence().remove(fileVersionId);
	}

	public static com.liferay.portlet.documentlibrary.model.DLFileVersion updateImpl(
		com.liferay.portlet.documentlibrary.model.DLFileVersion dlFileVersion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dlFileVersion, merge);
	}

	/**
	* Finds the d l file version with the primary key or throws a {@link com.liferay.portlet.documentlibrary.NoSuchFileVersionException} if it could not be found.
	*
	* @param fileVersionId the primary key of the d l file version to find
	* @return the d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a d l file version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByPrimaryKey(
		long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence().findByPrimaryKey(fileVersionId);
	}

	/**
	* Finds the d l file version with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileVersionId the primary key of the d l file version to find
	* @return the d l file version, or <code>null</code> if a d l file version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion fetchByPrimaryKey(
		long fileVersionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fileVersionId);
	}

	/**
	* Finds all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @return the matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N(
		long groupId, long folderId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_F_N(groupId, folderId, name);
	}

	/**
	* Finds a range of all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @return the range of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N(
		long groupId, long folderId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_F_N(groupId, folderId, name, start, end);
	}

	/**
	* Finds an ordered range of all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N(
		long groupId, long folderId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_F_N(groupId, folderId, name, start, end,
			orderByComparator);
	}

	/**
	* Finds the first d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByG_F_N_First(
		long groupId, long folderId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_First(groupId, folderId, name, orderByComparator);
	}

	/**
	* Finds the last d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByG_F_N_Last(
		long groupId, long folderId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_Last(groupId, folderId, name, orderByComparator);
	}

	/**
	* Finds the d l file versions before and after the current d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileVersionId the primary key of the current d l file version
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a d l file version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion[] findByG_F_N_PrevAndNext(
		long fileVersionId, long groupId, long folderId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_PrevAndNext(fileVersionId, groupId, folderId,
			name, orderByComparator);
	}

	/**
	* Finds the d l file version where groupId = &#63; and folderId = &#63; and name = &#63; and version = &#63; or throws a {@link com.liferay.portlet.documentlibrary.NoSuchFileVersionException} if it could not be found.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param version the version to search with
	* @return the matching d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByG_F_N_V(
		long groupId, long folderId, java.lang.String name,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence().findByG_F_N_V(groupId, folderId, name, version);
	}

	/**
	* Finds the d l file version where groupId = &#63; and folderId = &#63; and name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param version the version to search with
	* @return the matching d l file version, or <code>null</code> if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion fetchByG_F_N_V(
		long groupId, long folderId, java.lang.String name,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_F_N_V(groupId, folderId, name, version);
	}

	/**
	* Finds the d l file version where groupId = &#63; and folderId = &#63; and name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param version the version to search with
	* @return the matching d l file version, or <code>null</code> if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion fetchByG_F_N_V(
		long groupId, long folderId, java.lang.String name,
		java.lang.String version, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_F_N_V(groupId, folderId, name, version,
			retrieveFromCache);
	}

	/**
	* Finds all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @return the matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N_S(
		long groupId, long folderId, java.lang.String name, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_F_N_S(groupId, folderId, name, status);
	}

	/**
	* Finds a range of all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @return the range of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N_S(
		long groupId, long folderId, java.lang.String name, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_F_N_S(groupId, folderId, name, status, start, end);
	}

	/**
	* Finds an ordered range of all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findByG_F_N_S(
		long groupId, long folderId, java.lang.String name, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_F_N_S(groupId, folderId, name, status, start, end,
			orderByComparator);
	}

	/**
	* Finds the first d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByG_F_N_S_First(
		long groupId, long folderId, java.lang.String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_S_First(groupId, folderId, name, status,
			orderByComparator);
	}

	/**
	* Finds the last d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a matching d l file version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion findByG_F_N_S_Last(
		long groupId, long folderId, java.lang.String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_S_Last(groupId, folderId, name, status,
			orderByComparator);
	}

	/**
	* Finds the d l file versions before and after the current d l file version in the ordered set where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileVersionId the primary key of the current d l file version
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next d l file version
	* @throws com.liferay.portlet.documentlibrary.NoSuchFileVersionException if a d l file version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.documentlibrary.model.DLFileVersion[] findByG_F_N_S_PrevAndNext(
		long fileVersionId, long groupId, long folderId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		return getPersistence()
				   .findByG_F_N_S_PrevAndNext(fileVersionId, groupId, folderId,
			name, status, orderByComparator);
	}

	/**
	* Finds all the d l file versions.
	*
	* @return the d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the d l file versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @return the range of d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the d l file versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d l file versions to return
	* @param end the upper bound of the range of d l file versions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.documentlibrary.model.DLFileVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_F_N(long groupId, long folderId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_F_N(groupId, folderId, name);
	}

	/**
	* Removes the d l file version where groupId = &#63; and folderId = &#63; and name = &#63; and version = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param version the version to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_F_N_V(long groupId, long folderId,
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchFileVersionException {
		getPersistence().removeByG_F_N_V(groupId, folderId, name, version);
	}

	/**
	* Removes all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_F_N_S(long groupId, long folderId,
		java.lang.String name, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_F_N_S(groupId, folderId, name, status);
	}

	/**
	* Removes all the d l file versions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63;.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @return the number of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_F_N(long groupId, long folderId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_F_N(groupId, folderId, name);
	}

	/**
	* Counts all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and version = &#63;.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param version the version to search with
	* @return the number of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_F_N_V(long groupId, long folderId,
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_F_N_V(groupId, folderId, name, version);
	}

	/**
	* Counts all the d l file versions where groupId = &#63; and folderId = &#63; and name = &#63; and status = &#63;.
	*
	* @param groupId the group id to search with
	* @param folderId the folder id to search with
	* @param name the name to search with
	* @param status the status to search with
	* @return the number of matching d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_F_N_S(long groupId, long folderId,
		java.lang.String name, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_F_N_S(groupId, folderId, name, status);
	}

	/**
	* Counts all the d l file versions.
	*
	* @return the number of d l file versions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DLFileVersionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DLFileVersionPersistence)PortalBeanLocatorUtil.locate(DLFileVersionPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(DLFileVersionPersistence persistence) {
		_persistence = persistence;
	}

	private static DLFileVersionPersistence _persistence;
}