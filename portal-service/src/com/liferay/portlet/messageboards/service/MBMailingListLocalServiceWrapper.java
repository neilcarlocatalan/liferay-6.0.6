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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBMailingListLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMailingListLocalService
 * @generated
 */
public class MBMailingListLocalServiceWrapper
	implements MBMailingListLocalService {
	public MBMailingListLocalServiceWrapper(
		MBMailingListLocalService mbMailingListLocalService) {
		_mbMailingListLocalService = mbMailingListLocalService;
	}

	/**
	* Adds the message boards mailing list to the database. Also notifies the appropriate model listeners.
	*
	* @param mbMailingList the message boards mailing list to add
	* @return the message boards mailing list that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList addMBMailingList(
		com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.addMBMailingList(mbMailingList);
	}

	/**
	* Creates a new message boards mailing list with the primary key. Does not add the message boards mailing list to the database.
	*
	* @param mailingListId the primary key for the new message boards mailing list
	* @return the new message boards mailing list
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList createMBMailingList(
		long mailingListId) {
		return _mbMailingListLocalService.createMBMailingList(mailingListId);
	}

	/**
	* Deletes the message boards mailing list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mailingListId the primary key of the message boards mailing list to delete
	* @throws PortalException if a message boards mailing list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBMailingList(long mailingListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMailingListLocalService.deleteMBMailingList(mailingListId);
	}

	/**
	* Deletes the message boards mailing list from the database. Also notifies the appropriate model listeners.
	*
	* @param mbMailingList the message boards mailing list to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBMailingList(
		com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
		throws com.liferay.portal.kernel.exception.SystemException {
		_mbMailingListLocalService.deleteMBMailingList(mbMailingList);
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
		return _mbMailingListLocalService.dynamicQuery(dynamicQuery);
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
		return _mbMailingListLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _mbMailingListLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _mbMailingListLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the message boards mailing list with the primary key.
	*
	* @param mailingListId the primary key of the message boards mailing list to get
	* @return the message boards mailing list
	* @throws PortalException if a message boards mailing list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList getMBMailingList(
		long mailingListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.getMBMailingList(mailingListId);
	}

	/**
	* Gets the message boards mailing list with the UUID and group id.
	*
	* @param uuid the UUID of message boards mailing list to get
	* @param groupId the group id of the message boards mailing list to get
	* @return the message boards mailing list
	* @throws PortalException if a message boards mailing list with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList getMBMailingListByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.getMBMailingListByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Gets a range of all the message boards mailing lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards mailing lists to return
	* @param end the upper bound of the range of message boards mailing lists to return (not inclusive)
	* @return the range of message boards mailing lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> getMBMailingLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.getMBMailingLists(start, end);
	}

	/**
	* Gets the number of message boards mailing lists.
	*
	* @return the number of message boards mailing lists
	* @throws SystemException if a system exception occurred
	*/
	public int getMBMailingListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.getMBMailingListsCount();
	}

	/**
	* Updates the message boards mailing list in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMailingList the message boards mailing list to update
	* @return the message boards mailing list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
		com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.updateMBMailingList(mbMailingList);
	}

	/**
	* Updates the message boards mailing list in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMailingList the message boards mailing list to update
	* @param merge whether to merge the message boards mailing list with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the message boards mailing list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
		com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.updateMBMailingList(mbMailingList,
			merge);
	}

	public com.liferay.portlet.messageboards.model.MBMailingList addMailingList(
		long userId, long groupId, long categoryId,
		java.lang.String emailAddress, java.lang.String inProtocol,
		java.lang.String inServerName, int inServerPort, boolean inUseSSL,
		java.lang.String inUserName, java.lang.String inPassword,
		int inReadInterval, java.lang.String outEmailAddress,
		boolean outCustom, java.lang.String outServerName, int outServerPort,
		boolean outUseSSL, java.lang.String outUserName,
		java.lang.String outPassword, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.addMailingList(userId, groupId,
			categoryId, emailAddress, inProtocol, inServerName, inServerPort,
			inUseSSL, inUserName, inPassword, inReadInterval, outEmailAddress,
			outCustom, outServerName, outServerPort, outUseSSL, outUserName,
			outPassword, active, serviceContext);
	}

	public void deleteCategoryMailingList(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMailingListLocalService.deleteCategoryMailingList(groupId, categoryId);
	}

	public void deleteMailingList(long mailingListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMailingListLocalService.deleteMailingList(mailingListId);
	}

	public void deleteMailingList(
		com.liferay.portlet.messageboards.model.MBMailingList mailingList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMailingListLocalService.deleteMailingList(mailingList);
	}

	public com.liferay.portlet.messageboards.model.MBMailingList getCategoryMailingList(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.getCategoryMailingList(groupId,
			categoryId);
	}

	public com.liferay.portlet.messageboards.model.MBMailingList updateMailingList(
		long mailingListId, java.lang.String emailAddress,
		java.lang.String inProtocol, java.lang.String inServerName,
		int inServerPort, boolean inUseSSL, java.lang.String inUserName,
		java.lang.String inPassword, int inReadInterval,
		java.lang.String outEmailAddress, boolean outCustom,
		java.lang.String outServerName, int outServerPort, boolean outUseSSL,
		java.lang.String outUserName, java.lang.String outPassword,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMailingListLocalService.updateMailingList(mailingListId,
			emailAddress, inProtocol, inServerName, inServerPort, inUseSSL,
			inUserName, inPassword, inReadInterval, outEmailAddress, outCustom,
			outServerName, outServerPort, outUseSSL, outUserName, outPassword,
			active, serviceContext);
	}

	public MBMailingListLocalService getWrappedMBMailingListLocalService() {
		return _mbMailingListLocalService;
	}

	private MBMailingListLocalService _mbMailingListLocalService;
}