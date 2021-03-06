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

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalFeed;
import com.liferay.portlet.journal.model.JournalFeedModel;
import com.liferay.portlet.journal.model.JournalFeedSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the JournalFeed service. Represents a row in the &quot;JournalFeed&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.journal.model.JournalFeedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalFeedImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a journal feed model instance should use the {@link com.liferay.portlet.journal.model.JournalFeed} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalFeedImpl
 * @see com.liferay.portlet.journal.model.JournalFeed
 * @see com.liferay.portlet.journal.model.JournalFeedModel
 * @generated
 */
public class JournalFeedModelImpl extends BaseModelImpl<JournalFeed>
	implements JournalFeedModel {
	public static final String TABLE_NAME = "JournalFeed";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", new Integer(Types.VARCHAR) },
			{ "id_", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "userName", new Integer(Types.VARCHAR) },
			{ "createDate", new Integer(Types.TIMESTAMP) },
			{ "modifiedDate", new Integer(Types.TIMESTAMP) },
			{ "feedId", new Integer(Types.VARCHAR) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "description", new Integer(Types.VARCHAR) },
			{ "type_", new Integer(Types.VARCHAR) },
			{ "structureId", new Integer(Types.VARCHAR) },
			{ "templateId", new Integer(Types.VARCHAR) },
			{ "rendererTemplateId", new Integer(Types.VARCHAR) },
			{ "delta", new Integer(Types.INTEGER) },
			{ "orderByCol", new Integer(Types.VARCHAR) },
			{ "orderByType", new Integer(Types.VARCHAR) },
			{ "targetLayoutFriendlyUrl", new Integer(Types.VARCHAR) },
			{ "targetPortletId", new Integer(Types.VARCHAR) },
			{ "contentField", new Integer(Types.VARCHAR) },
			{ "feedType", new Integer(Types.VARCHAR) },
			{ "feedVersion", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table JournalFeed (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,feedId VARCHAR(75) null,name VARCHAR(75) null,description STRING null,type_ VARCHAR(75) null,structureId VARCHAR(75) null,templateId VARCHAR(75) null,rendererTemplateId VARCHAR(75) null,delta INTEGER,orderByCol VARCHAR(75) null,orderByType VARCHAR(75) null,targetLayoutFriendlyUrl VARCHAR(255) null,targetPortletId VARCHAR(75) null,contentField VARCHAR(75) null,feedType VARCHAR(75) null,feedVersion DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table JournalFeed";
	public static final String ORDER_BY_JPQL = " ORDER BY journalFeed.feedId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JournalFeed.feedId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.journal.model.JournalFeed"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.journal.model.JournalFeed"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JournalFeed toModel(JournalFeedSoap soapModel) {
		JournalFeed model = new JournalFeedImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFeedId(soapModel.getFeedId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setType(soapModel.getType());
		model.setStructureId(soapModel.getStructureId());
		model.setTemplateId(soapModel.getTemplateId());
		model.setRendererTemplateId(soapModel.getRendererTemplateId());
		model.setDelta(soapModel.getDelta());
		model.setOrderByCol(soapModel.getOrderByCol());
		model.setOrderByType(soapModel.getOrderByType());
		model.setTargetLayoutFriendlyUrl(soapModel.getTargetLayoutFriendlyUrl());
		model.setTargetPortletId(soapModel.getTargetPortletId());
		model.setContentField(soapModel.getContentField());
		model.setFeedType(soapModel.getFeedType());
		model.setFeedVersion(soapModel.getFeedVersion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JournalFeed> toModels(JournalFeedSoap[] soapModels) {
		List<JournalFeed> models = new ArrayList<JournalFeed>(soapModels.length);

		for (JournalFeedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.journal.model.JournalFeed"));

	public JournalFeedModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFeedId() {
		if (_feedId == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedId;
		}
	}

	public void setFeedId(String feedId) {
		if (_originalFeedId == null) {
			_originalFeedId = _feedId;
		}

		_feedId = feedId;
	}

	public String getOriginalFeedId() {
		return GetterUtil.getString(_originalFeedId);
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_type = type;
	}

	public String getStructureId() {
		if (_structureId == null) {
			return StringPool.BLANK;
		}
		else {
			return _structureId;
		}
	}

	public void setStructureId(String structureId) {
		_structureId = structureId;
	}

	public String getTemplateId() {
		if (_templateId == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateId;
		}
	}

	public void setTemplateId(String templateId) {
		_templateId = templateId;
	}

	public String getRendererTemplateId() {
		if (_rendererTemplateId == null) {
			return StringPool.BLANK;
		}
		else {
			return _rendererTemplateId;
		}
	}

	public void setRendererTemplateId(String rendererTemplateId) {
		_rendererTemplateId = rendererTemplateId;
	}

	public int getDelta() {
		return _delta;
	}

	public void setDelta(int delta) {
		_delta = delta;
	}

	public String getOrderByCol() {
		if (_orderByCol == null) {
			return StringPool.BLANK;
		}
		else {
			return _orderByCol;
		}
	}

	public void setOrderByCol(String orderByCol) {
		_orderByCol = orderByCol;
	}

	public String getOrderByType() {
		if (_orderByType == null) {
			return StringPool.BLANK;
		}
		else {
			return _orderByType;
		}
	}

	public void setOrderByType(String orderByType) {
		_orderByType = orderByType;
	}

	public String getTargetLayoutFriendlyUrl() {
		if (_targetLayoutFriendlyUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _targetLayoutFriendlyUrl;
		}
	}

	public void setTargetLayoutFriendlyUrl(String targetLayoutFriendlyUrl) {
		_targetLayoutFriendlyUrl = targetLayoutFriendlyUrl;
	}

	public String getTargetPortletId() {
		if (_targetPortletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _targetPortletId;
		}
	}

	public void setTargetPortletId(String targetPortletId) {
		_targetPortletId = targetPortletId;
	}

	public String getContentField() {
		if (_contentField == null) {
			return StringPool.BLANK;
		}
		else {
			return _contentField;
		}
	}

	public void setContentField(String contentField) {
		_contentField = contentField;
	}

	public String getFeedType() {
		if (_feedType == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedType;
		}
	}

	public void setFeedType(String feedType) {
		_feedType = feedType;
	}

	public double getFeedVersion() {
		return _feedVersion;
	}

	public void setFeedVersion(double feedVersion) {
		_feedVersion = feedVersion;
	}

	public JournalFeed toEscapedModel() {
		if (isEscapedModel()) {
			return (JournalFeed)this;
		}
		else {
			return (JournalFeed)Proxy.newProxyInstance(JournalFeed.class.getClassLoader(),
				new Class[] { JournalFeed.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					JournalFeed.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		JournalFeedImpl journalFeedImpl = new JournalFeedImpl();

		journalFeedImpl.setUuid(getUuid());

		JournalFeedModelImpl journalFeedModelImpl = journalFeedImpl;

		journalFeedModelImpl._originalUuid = journalFeedModelImpl._uuid;

		journalFeedImpl.setId(getId());

		journalFeedImpl.setGroupId(getGroupId());

		journalFeedModelImpl._originalGroupId = journalFeedModelImpl._groupId;

		journalFeedModelImpl._setOriginalGroupId = false;
		journalFeedImpl.setCompanyId(getCompanyId());

		journalFeedImpl.setUserId(getUserId());

		journalFeedImpl.setUserName(getUserName());

		journalFeedImpl.setCreateDate(getCreateDate());

		journalFeedImpl.setModifiedDate(getModifiedDate());

		journalFeedImpl.setFeedId(getFeedId());

		journalFeedModelImpl._originalFeedId = journalFeedModelImpl._feedId;

		journalFeedImpl.setName(getName());

		journalFeedImpl.setDescription(getDescription());

		journalFeedImpl.setType(getType());

		journalFeedImpl.setStructureId(getStructureId());

		journalFeedImpl.setTemplateId(getTemplateId());

		journalFeedImpl.setRendererTemplateId(getRendererTemplateId());

		journalFeedImpl.setDelta(getDelta());

		journalFeedImpl.setOrderByCol(getOrderByCol());

		journalFeedImpl.setOrderByType(getOrderByType());

		journalFeedImpl.setTargetLayoutFriendlyUrl(getTargetLayoutFriendlyUrl());

		journalFeedImpl.setTargetPortletId(getTargetPortletId());

		journalFeedImpl.setContentField(getContentField());

		journalFeedImpl.setFeedType(getFeedType());

		journalFeedImpl.setFeedVersion(getFeedVersion());

		return journalFeedImpl;
	}

	public int compareTo(JournalFeed journalFeed) {
		int value = 0;

		value = getFeedId().compareTo(journalFeed.getFeedId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JournalFeed journalFeed = null;

		try {
			journalFeed = (JournalFeed)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = journalFeed.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", feedId=");
		sb.append(getFeedId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", structureId=");
		sb.append(getStructureId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", rendererTemplateId=");
		sb.append(getRendererTemplateId());
		sb.append(", delta=");
		sb.append(getDelta());
		sb.append(", orderByCol=");
		sb.append(getOrderByCol());
		sb.append(", orderByType=");
		sb.append(getOrderByType());
		sb.append(", targetLayoutFriendlyUrl=");
		sb.append(getTargetLayoutFriendlyUrl());
		sb.append(", targetPortletId=");
		sb.append(getTargetPortletId());
		sb.append(", contentField=");
		sb.append(getContentField());
		sb.append(", feedType=");
		sb.append(getFeedType());
		sb.append(", feedVersion=");
		sb.append(getFeedVersion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.journal.model.JournalFeed");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedId</column-name><column-value><![CDATA[");
		sb.append(getFeedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structureId</column-name><column-value><![CDATA[");
		sb.append(getStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rendererTemplateId</column-name><column-value><![CDATA[");
		sb.append(getRendererTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delta</column-name><column-value><![CDATA[");
		sb.append(getDelta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderByCol</column-name><column-value><![CDATA[");
		sb.append(getOrderByCol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderByType</column-name><column-value><![CDATA[");
		sb.append(getOrderByType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetLayoutFriendlyUrl</column-name><column-value><![CDATA[");
		sb.append(getTargetLayoutFriendlyUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetPortletId</column-name><column-value><![CDATA[");
		sb.append(getTargetPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentField</column-name><column-value><![CDATA[");
		sb.append(getContentField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedType</column-name><column-value><![CDATA[");
		sb.append(getFeedType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedVersion</column-name><column-value><![CDATA[");
		sb.append(getFeedVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _feedId;
	private String _originalFeedId;
	private String _name;
	private String _description;
	private String _type;
	private String _structureId;
	private String _templateId;
	private String _rendererTemplateId;
	private int _delta;
	private String _orderByCol;
	private String _orderByType;
	private String _targetLayoutFriendlyUrl;
	private String _targetPortletId;
	private String _contentField;
	private String _feedType;
	private double _feedVersion;
	private transient ExpandoBridge _expandoBridge;
}