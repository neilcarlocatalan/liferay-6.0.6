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

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the message boards message flag local service. This utility wraps {@link com.liferay.portlet.messageboards.service.impl.MBMessageFlagLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.messageboards.service.impl.MBMessageFlagLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBMessageFlagLocalService
 * @see com.liferay.portlet.messageboards.service.base.MBMessageFlagLocalServiceBaseImpl
 * @see com.liferay.portlet.messageboards.service.impl.MBMessageFlagLocalServiceImpl
 * @generated
 */
public class MBMessageFlagLocalServiceUtil {
	/**
	* Adds the message boards message flag to the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessageFlag the message boards message flag to add
	* @return the message boards message flag that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBMessageFlag addMBMessageFlag(
		com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMBMessageFlag(mbMessageFlag);
	}

	/**
	* Creates a new message boards message flag with the primary key. Does not add the message boards message flag to the database.
	*
	* @param messageFlagId the primary key for the new message boards message flag
	* @return the new message boards message flag
	*/
	public static com.liferay.portlet.messageboards.model.MBMessageFlag createMBMessageFlag(
		long messageFlagId) {
		return getService().createMBMessageFlag(messageFlagId);
	}

	/**
	* Deletes the message boards message flag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageFlagId the primary key of the message boards message flag to delete
	* @throws PortalException if a message boards message flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMBMessageFlag(long messageFlagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMBMessageFlag(messageFlagId);
	}

	/**
	* Deletes the message boards message flag from the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessageFlag the message boards message flag to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMBMessageFlag(
		com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMBMessageFlag(mbMessageFlag);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the message boards message flag with the primary key.
	*
	* @param messageFlagId the primary key of the message boards message flag to get
	* @return the message boards message flag
	* @throws PortalException if a message boards message flag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBMessageFlag getMBMessageFlag(
		long messageFlagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBMessageFlag(messageFlagId);
	}

	/**
	* Gets a range of all the message boards message flags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message boards message flags to return
	* @param end the upper bound of the range of message boards message flags to return (not inclusive)
	* @return the range of message boards message flags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.messageboards.model.MBMessageFlag> getMBMessageFlags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBMessageFlags(start, end);
	}

	/**
	* Gets the number of message boards message flags.
	*
	* @return the number of message boards message flags
	* @throws SystemException if a system exception occurred
	*/
	public static int getMBMessageFlagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMBMessageFlagsCount();
	}

	/**
	* Updates the message boards message flag in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessageFlag the message boards message flag to update
	* @return the message boards message flag that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
		com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMBMessageFlag(mbMessageFlag);
	}

	/**
	* Updates the message boards message flag in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessageFlag the message boards message flag to update
	* @param merge whether to merge the message boards message flag with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the message boards message flag that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.messageboards.model.MBMessageFlag updateMBMessageFlag(
		com.liferay.portlet.messageboards.model.MBMessageFlag mbMessageFlag,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMBMessageFlag(mbMessageFlag, merge);
	}

	public static void addReadFlags(long userId,
		com.liferay.portlet.messageboards.model.MBThread thread)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addReadFlags(userId, thread);
	}

	public static void addQuestionFlag(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addQuestionFlag(messageId);
	}

	public static void deleteAnswerFlags(long threadId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAnswerFlags(threadId, messageId);
	}

	public static void deleteFlags(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFlags(userId);
	}

	public static void deleteFlags(long messageId, int flag)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFlags(messageId, flag);
	}

	public static void deleteQuestionAndAnswerFlags(long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestionAndAnswerFlags(threadId);
	}

	public static void deleteThreadFlags(long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteThreadFlags(threadId);
	}

	public static com.liferay.portlet.messageboards.model.MBMessageFlag getReadFlag(
		long userId, com.liferay.portlet.messageboards.model.MBThread thread)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getReadFlag(userId, thread);
	}

	public static boolean hasAnswerFlag(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasAnswerFlag(messageId);
	}

	public static boolean hasQuestionFlag(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasQuestionFlag(messageId);
	}

	public static boolean hasReadFlag(long userId,
		com.liferay.portlet.messageboards.model.MBThread thread)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().hasReadFlag(userId, thread);
	}

	public static MBMessageFlagLocalService getService() {
		if (_service == null) {
			_service = (MBMessageFlagLocalService)PortalBeanLocatorUtil.locate(MBMessageFlagLocalService.class.getName());
		}

		return _service;
	}

	public void setService(MBMessageFlagLocalService service) {
		_service = service;
	}

	private static MBMessageFlagLocalService _service;
}