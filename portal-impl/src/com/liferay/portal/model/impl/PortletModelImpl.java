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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletModel;
import com.liferay.portal.model.PortletSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the Portlet service. Represents a row in the &quot;Portlet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.PortletModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortletImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a portlet model instance should use the {@link com.liferay.portal.model.Portlet} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletImpl
 * @see com.liferay.portal.model.Portlet
 * @see com.liferay.portal.model.PortletModel
 * @generated
 */
public class PortletModelImpl extends BaseModelImpl<Portlet>
	implements PortletModel {
	public static final String TABLE_NAME = "Portlet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "portletId", new Integer(Types.VARCHAR) },
			{ "roles", new Integer(Types.VARCHAR) },
			{ "active_", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table Portlet (id_ LONG not null primary key,companyId LONG,portletId VARCHAR(200) null,roles STRING null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Portlet";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.Portlet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.Portlet"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Portlet toModel(PortletSoap soapModel) {
		Portlet model = new PortletImpl();

		model.setId(soapModel.getId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setPortletId(soapModel.getPortletId());
		model.setRoles(soapModel.getRoles());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Portlet> toModels(PortletSoap[] soapModels) {
		List<Portlet> models = new ArrayList<Portlet>(soapModels.length);

		for (PortletSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.Portlet"));

	public PortletModelImpl() {
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public String getPortletId() {
		if (_portletId == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletId;
		}
	}

	public void setPortletId(String portletId) {
		if (_originalPortletId == null) {
			_originalPortletId = _portletId;
		}

		_portletId = portletId;
	}

	public String getOriginalPortletId() {
		return GetterUtil.getString(_originalPortletId);
	}

	public String getRoles() {
		if (_roles == null) {
			return StringPool.BLANK;
		}
		else {
			return _roles;
		}
	}

	public void setRoles(String roles) {
		_roles = roles;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Portlet toEscapedModel() {
		if (isEscapedModel()) {
			return (Portlet)this;
		}
		else {
			return (Portlet)Proxy.newProxyInstance(Portlet.class.getClassLoader(),
				new Class[] { Portlet.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Portlet.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		PortletImpl portletImpl = new PortletImpl();

		portletImpl.setId(getId());

		portletImpl.setCompanyId(getCompanyId());

		PortletModelImpl portletModelImpl = portletImpl;

		portletModelImpl._originalCompanyId = portletModelImpl._companyId;

		portletModelImpl._setOriginalCompanyId = false;
		portletImpl.setPortletId(getPortletId());

		portletModelImpl._originalPortletId = portletModelImpl._portletId;

		portletImpl.setRoles(getRoles());

		portletImpl.setActive(getActive());

		return portletImpl;
	}

	public int compareTo(Portlet portlet) {
		long pk = portlet.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Portlet portlet = null;

		try {
			portlet = (Portlet)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = portlet.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", roles=");
		sb.append(getRoles());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.Portlet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roles</column-name><column-value><![CDATA[");
		sb.append(getRoles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _portletId;
	private String _originalPortletId;
	private String _roles;
	private boolean _active;
	private transient ExpandoBridge _expandoBridge;
}