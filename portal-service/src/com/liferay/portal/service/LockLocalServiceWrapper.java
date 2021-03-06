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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link LockLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LockLocalService
 * @generated
 */
public class LockLocalServiceWrapper implements LockLocalService {
	public LockLocalServiceWrapper(LockLocalService lockLocalService) {
		_lockLocalService = lockLocalService;
	}

	/**
	* Adds the lock to the database. Also notifies the appropriate model listeners.
	*
	* @param lock the lock to add
	* @return the lock that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock addLock(
		com.liferay.portal.model.Lock lock)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.addLock(lock);
	}

	/**
	* Creates a new lock with the primary key. Does not add the lock to the database.
	*
	* @param lockId the primary key for the new lock
	* @return the new lock
	*/
	public com.liferay.portal.model.Lock createLock(long lockId) {
		return _lockLocalService.createLock(lockId);
	}

	/**
	* Deletes the lock with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lockId the primary key of the lock to delete
	* @throws PortalException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLock(long lockId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lockLocalService.deleteLock(lockId);
	}

	/**
	* Deletes the lock from the database. Also notifies the appropriate model listeners.
	*
	* @param lock the lock to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLock(com.liferay.portal.model.Lock lock)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lockLocalService.deleteLock(lock);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the lock with the primary key.
	*
	* @param lockId the primary key of the lock to get
	* @return the lock
	* @throws PortalException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock getLock(long lockId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.getLock(lockId);
	}

	/**
	* Gets a range of all the locks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @return the range of locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> getLocks(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.getLocks(start, end);
	}

	/**
	* Gets the number of locks.
	*
	* @return the number of locks
	* @throws SystemException if a system exception occurred
	*/
	public int getLocksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.getLocksCount();
	}

	/**
	* Updates the lock in the database. Also notifies the appropriate model listeners.
	*
	* @param lock the lock to update
	* @return the lock that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock updateLock(
		com.liferay.portal.model.Lock lock)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.updateLock(lock);
	}

	/**
	* Updates the lock in the database. Also notifies the appropriate model listeners.
	*
	* @param lock the lock to update
	* @param merge whether to merge the lock with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lock that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock updateLock(
		com.liferay.portal.model.Lock lock, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.updateLock(lock, merge);
	}

	public void clear()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lockLocalService.clear();
	}

	public com.liferay.portal.model.Lock getLock(java.lang.String className,
		long key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.getLock(className, key);
	}

	public com.liferay.portal.model.Lock getLock(java.lang.String className,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.getLock(className, key);
	}

	public boolean hasLock(long userId, java.lang.String className, long key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.hasLock(userId, className, key);
	}

	public boolean hasLock(long userId, java.lang.String className,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.hasLock(userId, className, key);
	}

	public boolean isLocked(java.lang.String className, long key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.isLocked(className, key);
	}

	public boolean isLocked(java.lang.String className, java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.isLocked(className, key);
	}

	public com.liferay.portal.model.Lock lock(long userId,
		java.lang.String className, long key, java.lang.String owner,
		boolean inheritable, long expirationTime)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.lock(userId, className, key, owner,
			inheritable, expirationTime);
	}

	public com.liferay.portal.model.Lock lock(long userId,
		java.lang.String className, java.lang.String key,
		java.lang.String owner, boolean inheritable, long expirationTime)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.lock(userId, className, key, owner,
			inheritable, expirationTime);
	}

	public com.liferay.portal.model.Lock refresh(java.lang.String uuid,
		long expirationTime)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lockLocalService.refresh(uuid, expirationTime);
	}

	public void unlock(java.lang.String className, long key)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lockLocalService.unlock(className, key);
	}

	public void unlock(java.lang.String className, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lockLocalService.unlock(className, key);
	}

	public LockLocalService getWrappedLockLocalService() {
		return _lockLocalService;
	}

	private LockLocalService _lockLocalService;
}