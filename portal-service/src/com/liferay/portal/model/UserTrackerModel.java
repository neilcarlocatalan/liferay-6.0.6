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

package com.liferay.portal.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserTracker service. Represents a row in the &quot;UserTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserTrackerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserTrackerImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a user tracker model instance should use the {@link UserTracker} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTracker
 * @see com.liferay.portal.model.impl.UserTrackerImpl
 * @see com.liferay.portal.model.impl.UserTrackerModelImpl
 * @generated
 */
public interface UserTrackerModel extends BaseModel<UserTracker> {
	/**
	 * Gets the primary key of this user tracker.
	 *
	 * @return the primary key of this user tracker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user tracker
	 *
	 * @param pk the primary key of this user tracker
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the user tracker id of this user tracker.
	 *
	 * @return the user tracker id of this user tracker
	 */
	public long getUserTrackerId();

	/**
	 * Sets the user tracker id of this user tracker.
	 *
	 * @param userTrackerId the user tracker id of this user tracker
	 */
	public void setUserTrackerId(long userTrackerId);

	/**
	 * Gets the company id of this user tracker.
	 *
	 * @return the company id of this user tracker
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this user tracker.
	 *
	 * @param companyId the company id of this user tracker
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this user tracker.
	 *
	 * @return the user id of this user tracker
	 */
	public long getUserId();

	/**
	 * Sets the user id of this user tracker.
	 *
	 * @param userId the user id of this user tracker
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this user tracker.
	 *
	 * @return the user uuid of this user tracker
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user tracker.
	 *
	 * @param userUuid the user uuid of this user tracker
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the modified date of this user tracker.
	 *
	 * @return the modified date of this user tracker
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this user tracker.
	 *
	 * @param modifiedDate the modified date of this user tracker
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the session id of this user tracker.
	 *
	 * @return the session id of this user tracker
	 */
	@AutoEscape
	public String getSessionId();

	/**
	 * Sets the session id of this user tracker.
	 *
	 * @param sessionId the session id of this user tracker
	 */
	public void setSessionId(String sessionId);

	/**
	 * Gets the remote addr of this user tracker.
	 *
	 * @return the remote addr of this user tracker
	 */
	@AutoEscape
	public String getRemoteAddr();

	/**
	 * Sets the remote addr of this user tracker.
	 *
	 * @param remoteAddr the remote addr of this user tracker
	 */
	public void setRemoteAddr(String remoteAddr);

	/**
	 * Gets the remote host of this user tracker.
	 *
	 * @return the remote host of this user tracker
	 */
	@AutoEscape
	public String getRemoteHost();

	/**
	 * Sets the remote host of this user tracker.
	 *
	 * @param remoteHost the remote host of this user tracker
	 */
	public void setRemoteHost(String remoteHost);

	/**
	 * Gets the user agent of this user tracker.
	 *
	 * @return the user agent of this user tracker
	 */
	@AutoEscape
	public String getUserAgent();

	/**
	 * Sets the user agent of this user tracker.
	 *
	 * @param userAgent the user agent of this user tracker
	 */
	public void setUserAgent(String userAgent);

	/**
	 * Gets a copy of this user tracker as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public UserTracker toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UserTracker userTracker);

	public int hashCode();

	public String toString();

	public String toXmlString();
}