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

import com.liferay.portal.model.Lock;

/**
 * The persistence interface for the lock service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link LockUtil} to access the lock persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LockPersistenceImpl
 * @see LockUtil
 * @generated
 */
public interface LockPersistence extends BasePersistence<Lock> {
	/**
	* Caches the lock in the entity cache if it is enabled.
	*
	* @param lock the lock to cache
	*/
	public void cacheResult(com.liferay.portal.model.Lock lock);

	/**
	* Caches the locks in the entity cache if it is enabled.
	*
	* @param locks the locks to cache
	*/
	public void cacheResult(java.util.List<com.liferay.portal.model.Lock> locks);

	/**
	* Creates a new lock with the primary key. Does not add the lock to the database.
	*
	* @param lockId the primary key for the new lock
	* @return the new lock
	*/
	public com.liferay.portal.model.Lock create(long lockId);

	/**
	* Removes the lock with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lockId the primary key of the lock to remove
	* @return the lock that was removed
	* @throws com.liferay.portal.NoSuchLockException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock remove(long lockId)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Lock updateImpl(
		com.liferay.portal.model.Lock lock, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the lock with the primary key or throws a {@link com.liferay.portal.NoSuchLockException} if it could not be found.
	*
	* @param lockId the primary key of the lock to find
	* @return the lock
	* @throws com.liferay.portal.NoSuchLockException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByPrimaryKey(long lockId)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the lock with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lockId the primary key of the lock to find
	* @return the lock, or <code>null</code> if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock fetchByPrimaryKey(long lockId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the locks where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the locks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @return the range of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the locks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first lock in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching lock
	* @throws com.liferay.portal.NoSuchLockException if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last lock in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching lock
	* @throws com.liferay.portal.NoSuchLockException if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the locks before and after the current lock in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param lockId the primary key of the current lock
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next lock
	* @throws com.liferay.portal.NoSuchLockException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock[] findByUuid_PrevAndNext(long lockId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the locks where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date to search with
	* @return the matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the locks where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param expirationDate the expiration date to search with
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @return the range of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the locks where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param expirationDate the expiration date to search with
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findByLtExpirationDate(
		java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first lock in the ordered set where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param expirationDate the expiration date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching lock
	* @throws com.liferay.portal.NoSuchLockException if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByLtExpirationDate_First(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last lock in the ordered set where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param expirationDate the expiration date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching lock
	* @throws com.liferay.portal.NoSuchLockException if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByLtExpirationDate_Last(
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the locks before and after the current lock in the ordered set where expirationDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param lockId the primary key of the current lock
	* @param expirationDate the expiration date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next lock
	* @throws com.liferay.portal.NoSuchLockException if a lock with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock[] findByLtExpirationDate_PrevAndNext(
		long lockId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the lock where className = &#63; and key = &#63; or throws a {@link com.liferay.portal.NoSuchLockException} if it could not be found.
	*
	* @param className the class name to search with
	* @param key the key to search with
	* @return the matching lock
	* @throws com.liferay.portal.NoSuchLockException if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock findByC_K(java.lang.String className,
		java.lang.String key)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the lock where className = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name to search with
	* @param key the key to search with
	* @return the matching lock, or <code>null</code> if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock fetchByC_K(
		java.lang.String className, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the lock where className = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name to search with
	* @param key the key to search with
	* @return the matching lock, or <code>null</code> if a matching lock could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Lock fetchByC_K(
		java.lang.String className, java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the locks.
	*
	* @return the locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the locks.
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
	public java.util.List<com.liferay.portal.model.Lock> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the locks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of locks to return
	* @param end the upper bound of the range of locks to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of locks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Lock> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the locks where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the locks where expirationDate &lt; &#63; from the database.
	*
	* @param expirationDate the expiration date to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLtExpirationDate(java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the lock where className = &#63; and key = &#63; from the database.
	*
	* @param className the class name to search with
	* @param key the key to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_K(java.lang.String className, java.lang.String key)
		throws com.liferay.portal.NoSuchLockException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the locks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the locks where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the locks where expirationDate &lt; &#63;.
	*
	* @param expirationDate the expiration date to search with
	* @return the number of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public int countByLtExpirationDate(java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the locks where className = &#63; and key = &#63;.
	*
	* @param className the class name to search with
	* @param key the key to search with
	* @return the number of matching locks
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_K(java.lang.String className, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the locks.
	*
	* @return the number of locks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}