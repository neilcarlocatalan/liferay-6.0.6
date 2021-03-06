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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the workflow instance link service. This utility wraps {@link WorkflowInstanceLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see WorkflowInstanceLinkPersistence
 * @see WorkflowInstanceLinkPersistenceImpl
 * @generated
 */
public class WorkflowInstanceLinkUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WorkflowInstanceLink workflowInstanceLink) {
		getPersistence().clearCache(workflowInstanceLink);
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
	public static List<WorkflowInstanceLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowInstanceLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowInstanceLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static WorkflowInstanceLink remove(
		WorkflowInstanceLink workflowInstanceLink) throws SystemException {
		return getPersistence().remove(workflowInstanceLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WorkflowInstanceLink update(
		WorkflowInstanceLink workflowInstanceLink, boolean merge)
		throws SystemException {
		return getPersistence().update(workflowInstanceLink, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WorkflowInstanceLink update(
		WorkflowInstanceLink workflowInstanceLink, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(workflowInstanceLink, merge, serviceContext);
	}

	/**
	* Caches the workflow instance link in the entity cache if it is enabled.
	*
	* @param workflowInstanceLink the workflow instance link to cache
	*/
	public static void cacheResult(
		com.liferay.portal.model.WorkflowInstanceLink workflowInstanceLink) {
		getPersistence().cacheResult(workflowInstanceLink);
	}

	/**
	* Caches the workflow instance links in the entity cache if it is enabled.
	*
	* @param workflowInstanceLinks the workflow instance links to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.model.WorkflowInstanceLink> workflowInstanceLinks) {
		getPersistence().cacheResult(workflowInstanceLinks);
	}

	/**
	* Creates a new workflow instance link with the primary key. Does not add the workflow instance link to the database.
	*
	* @param workflowInstanceLinkId the primary key for the new workflow instance link
	* @return the new workflow instance link
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink create(
		long workflowInstanceLinkId) {
		return getPersistence().create(workflowInstanceLinkId);
	}

	/**
	* Removes the workflow instance link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowInstanceLinkId the primary key of the workflow instance link to remove
	* @return the workflow instance link that was removed
	* @throws com.liferay.portal.NoSuchWorkflowInstanceLinkException if a workflow instance link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink remove(
		long workflowInstanceLinkId)
		throws com.liferay.portal.NoSuchWorkflowInstanceLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(workflowInstanceLinkId);
	}

	public static com.liferay.portal.model.WorkflowInstanceLink updateImpl(
		com.liferay.portal.model.WorkflowInstanceLink workflowInstanceLink,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workflowInstanceLink, merge);
	}

	/**
	* Finds the workflow instance link with the primary key or throws a {@link com.liferay.portal.NoSuchWorkflowInstanceLinkException} if it could not be found.
	*
	* @param workflowInstanceLinkId the primary key of the workflow instance link to find
	* @return the workflow instance link
	* @throws com.liferay.portal.NoSuchWorkflowInstanceLinkException if a workflow instance link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink findByPrimaryKey(
		long workflowInstanceLinkId)
		throws com.liferay.portal.NoSuchWorkflowInstanceLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(workflowInstanceLinkId);
	}

	/**
	* Finds the workflow instance link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowInstanceLinkId the primary key of the workflow instance link to find
	* @return the workflow instance link, or <code>null</code> if a workflow instance link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink fetchByPrimaryKey(
		long workflowInstanceLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workflowInstanceLinkId);
	}

	/**
	* Finds all the workflow instance links where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findByG_C_C_C(
		long groupId, long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C(groupId, companyId, classNameId, classPK);
	}

	/**
	* Finds a range of all the workflow instance links where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param start the lower bound of the range of workflow instance links to return
	* @param end the upper bound of the range of workflow instance links to return (not inclusive)
	* @return the range of matching workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findByG_C_C_C(
		long groupId, long companyId, long classNameId, long classPK,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C(groupId, companyId, classNameId, classPK,
			start, end);
	}

	/**
	* Finds an ordered range of all the workflow instance links where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param start the lower bound of the range of workflow instance links to return
	* @param end the upper bound of the range of workflow instance links to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findByG_C_C_C(
		long groupId, long companyId, long classNameId, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C(groupId, companyId, classNameId, classPK,
			start, end, orderByComparator);
	}

	/**
	* Finds the first workflow instance link in the ordered set where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching workflow instance link
	* @throws com.liferay.portal.NoSuchWorkflowInstanceLinkException if a matching workflow instance link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink findByG_C_C_C_First(
		long groupId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWorkflowInstanceLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C_First(groupId, companyId, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Finds the last workflow instance link in the ordered set where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching workflow instance link
	* @throws com.liferay.portal.NoSuchWorkflowInstanceLinkException if a matching workflow instance link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink findByG_C_C_C_Last(
		long groupId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWorkflowInstanceLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C_Last(groupId, companyId, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Finds the workflow instance links before and after the current workflow instance link in the ordered set where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param workflowInstanceLinkId the primary key of the current workflow instance link
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next workflow instance link
	* @throws com.liferay.portal.NoSuchWorkflowInstanceLinkException if a workflow instance link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.WorkflowInstanceLink[] findByG_C_C_C_PrevAndNext(
		long workflowInstanceLinkId, long groupId, long companyId,
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWorkflowInstanceLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_C_C_PrevAndNext(workflowInstanceLinkId, groupId,
			companyId, classNameId, classPK, orderByComparator);
	}

	/**
	* Finds all the workflow instance links.
	*
	* @return the workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the workflow instance links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of workflow instance links to return
	* @param end the upper bound of the range of workflow instance links to return (not inclusive)
	* @return the range of workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the workflow instance links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of workflow instance links to return
	* @param end the upper bound of the range of workflow instance links to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.WorkflowInstanceLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the workflow instance links where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_C_C(long groupId, long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByG_C_C_C(groupId, companyId, classNameId, classPK);
	}

	/**
	* Removes all the workflow instance links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the workflow instance links where groupId = &#63; and companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param groupId the group id to search with
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_C_C(long groupId, long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_C_C_C(groupId, companyId, classNameId, classPK);
	}

	/**
	* Counts all the workflow instance links.
	*
	* @return the number of workflow instance links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WorkflowInstanceLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowInstanceLinkPersistence)PortalBeanLocatorUtil.locate(WorkflowInstanceLinkPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(WorkflowInstanceLinkPersistence persistence) {
		_persistence = persistence;
	}

	private static WorkflowInstanceLinkPersistence _persistence;
}