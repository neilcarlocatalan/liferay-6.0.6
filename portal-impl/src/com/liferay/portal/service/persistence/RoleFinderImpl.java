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

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.impl.RoleImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleFinderImpl
	extends BasePersistenceImpl<Role> implements RoleFinder {

	public static String COUNT_BY_COMMUNITY =
		RoleFinder.class.getName() + ".countByCommunity";

	public static String COUNT_BY_ORGANIZATION =
		RoleFinder.class.getName() + ".countByOrganization";

	public static String COUNT_BY_ORGANIZATION_COMMUNITY =
		RoleFinder.class.getName() + ".countByOrganizationCommunity";

	public static String COUNT_BY_USER =
		RoleFinder.class.getName() + ".countByUser";

	public static String COUNT_BY_USER_GROUP =
		RoleFinder.class.getName() + ".countByUserGroup";

	public static String COUNT_BY_USER_GROUP_COMMUNITY =
		RoleFinder.class.getName() + ".countByUserGroupCommunity";

	public static String COUNT_BY_U_G_R =
		RoleFinder.class.getName() + ".countByU_G_R";

	public static String COUNT_BY_C_N_D_T =
		RoleFinder.class.getName() + ".countByC_N_D_T";

	public static String FIND_BY_SYSTEM =
		RoleFinder.class.getName() + ".findBySystem";

	public static String FIND_BY_USER_GROUP_GROUP_ROLE =
		RoleFinder.class.getName() + ".findByUserGroupGroupRole";

	public static String FIND_BY_USER_GROUP_ROLE =
		RoleFinder.class.getName() + ".findByUserGroupRole";

	public static String FIND_BY_C_N =
		RoleFinder.class.getName() + ".findByC_N";

	public static String FIND_BY_U_G =
		RoleFinder.class.getName() + ".findByU_G";

	public static String FIND_BY_C_N_D_T =
		RoleFinder.class.getName() + ".findByC_N_D_T";

	public static String FIND_BY_C_N_S_P =
		RoleFinder.class.getName() + ".findByC_N_S_P";

	public static String JOIN_BY_ROLES_PERMISSIONS =
		RoleFinder.class.getName() + ".joinByRolesPermissions";

	public static String JOIN_BY_USERS_ROLES =
		RoleFinder.class.getName() + ".joinByUsersRoles";

	public int countByR_U(long roleId, long userId) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			StringBundler sb = new StringBundler(13);

			sb.append("(");
			sb.append(CustomSQLUtil.get(COUNT_BY_COMMUNITY));
			sb.append(") UNION (");
			sb.append(CustomSQLUtil.get(COUNT_BY_ORGANIZATION));
			sb.append(") UNION (");
			sb.append(CustomSQLUtil.get(COUNT_BY_ORGANIZATION_COMMUNITY));
			sb.append(") UNION (");
			sb.append(CustomSQLUtil.get(COUNT_BY_USER));
			sb.append(") UNION (");
			sb.append(CustomSQLUtil.get(COUNT_BY_USER_GROUP));
			sb.append(") UNION (");
			sb.append(CustomSQLUtil.get(COUNT_BY_USER_GROUP_COMMUNITY));
			sb.append(")");

			SQLQuery q = session.createSQLQuery(sb.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			for (int i = 0; i < 6; i++) {
				qPos.add(roleId);
				qPos.add(userId);
			}

			return q.list().size();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByU_G_R(long userId, long groupId, long roleId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_U_G_R);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(roleId);
			qPos.add(groupId);
			qPos.add(userId);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByC_N_D_T(
			long companyId, String name, String description, Integer[] types,
			LinkedHashMap<String, Object> params)
		throws SystemException {

		name = StringUtil.lowerCase(name);
		description = StringUtil.lowerCase(description);

		if (types == null) {
			types = new Integer[0];
		}

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_C_N_D_T);

			sql = StringUtil.replace(sql, " AND ([$TYPE$])", getTypes(types));
			sql = StringUtil.replace(sql, "[$JOIN$]", getJoin(params));
			sql = StringUtil.replace(sql, "[$WHERE$]", getWhere(params));

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			setJoin(qPos, params);
			qPos.add(companyId);
			qPos.add(name);
			qPos.add(name);
			qPos.add(description);
			qPos.add(description);
			qPos.add(types);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Role> findBySystem(long companyId) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_SYSTEM);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Role> findByUserGroupGroupRole(long userId, long groupId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_USER_GROUP_GROUP_ROLE);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);
			qPos.add(groupId);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Role> findByUserGroupRole(long userId, long groupId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_USER_GROUP_ROLE);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);
			qPos.add(groupId);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Role findByC_N(long companyId, String name)
		throws NoSuchRoleException, SystemException {

		name = StringUtil.lowerCase(name);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_N);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(name);

			List<Role> list = q.list();

			if (!list.isEmpty()) {
				return list.get(0);
			}
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}

		StringBundler sb = new StringBundler(5);

		sb.append("No Role exists with the key {companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		throw new NoSuchRoleException(sb.toString());
	}

	public List<Role> findByU_G(long userId, long groupId)
		throws SystemException {

		return findByU_G(userId, new long[] {groupId});
	}

	public List<Role> findByU_G(long userId, long[] groupIds)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_U_G);

			sql = StringUtil.replace(
				sql, "[$GROUP_ID$]", getGroupIds(groupIds, "Groups_Roles"));

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);
			qPos.add(groupIds);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Role> findByU_G(long userId, List<Group> groups)
		throws SystemException {

		long[] groupIds = new long[groups.size()];

		for (int i = 0; i < groups.size(); i++) {
			Group group = groups.get(i);

			groupIds[i] = group.getGroupId();
		}

		return findByU_G(userId, groupIds);
	}

	public List<Role> findByC_N_D_T(
			long companyId, String name, String description, Integer[] types,
			LinkedHashMap<String, Object> params, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		name = StringUtil.lowerCase(name);
		description = StringUtil.lowerCase(description);

		if (types == null) {
			types = new Integer[0];
		}

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_N_D_T);

			sql = StringUtil.replace(sql, " AND ([$TYPE$])", getTypes(types));
			sql = StringUtil.replace(sql, "[$JOIN$]", getJoin(params));
			sql = StringUtil.replace(sql, "[$WHERE$]", getWhere(params));
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Role_", RoleImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			setJoin(qPos, params);
			qPos.add(companyId);
			qPos.add(name);
			qPos.add(name);
			qPos.add(description);
			qPos.add(description);
			qPos.add(types);

			return (List<Role>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Map<String, List<String>> findByC_N_S_P(
			long companyId, String name, int scope, String primKey)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_N_S_P);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("roleName", Type.STRING);
			q.addScalar("actionId", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(name);
			qPos.add(scope);
			qPos.add(primKey);

			Map<String, List<String>> roleMap =
				new HashMap<String, List<String>>();

			Iterator<Object[]> itr = q.list().iterator();

			while (itr.hasNext()) {
				Object[] array = itr.next();

				String roleName = (String)array[0];
				String actionId = (String)array[1];

				List<String> roleList = roleMap.get(roleName);

				if (roleList == null) {
					roleList = new ArrayList<String>();
				}

				roleList.add(actionId);

				roleMap.put(roleName, roleList);
			}

			return roleMap;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getGroupIds(long[] groupIds, String table) {
		if (groupIds.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(groupIds.length * 3 - 1);

		for (int i = 0; i < groupIds.length; i++) {
			sb.append(table);
			sb.append(".groupId = ?");

			if ((i + 1) < groupIds.length) {
				sb.append(" OR ");
			}
		}

		return sb.toString();
	}

	protected String getJoin(LinkedHashMap<String, Object> params) {
		if ((params == null) || params.isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(params.size());

		Iterator<Map.Entry<String, Object>> itr = params.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Object> entry = itr.next();

			String key = entry.getKey();
			Object value = entry.getValue();

			if (Validator.isNotNull(value)) {
				sb.append(getJoin(key));
			}
		}

		return sb.toString();
	}

	protected String getJoin(String key) {
		String join = StringPool.BLANK;

		if (key.equals("permissionsResourceId")) {
			join = CustomSQLUtil.get(JOIN_BY_ROLES_PERMISSIONS);
		}
		else if (key.equals("usersRoles")) {
			join = CustomSQLUtil.get(JOIN_BY_USERS_ROLES);
		}

		if (Validator.isNotNull(join)) {
			int pos = join.indexOf("WHERE");

			if (pos != -1) {
				join = join.substring(0, pos);
			}
		}

		return join;
	}

	protected String getTypes(Integer[] types) {
		if (types.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(types.length * 2);

		sb.append(" AND ");

		for (int i = 0; i < types.length; i++) {
			sb.append("Role_.type_ = ?");

			if ((i + 1) < types.length) {
				sb.append(" OR ");
			}
		}

		return sb.toString();
	}

	protected String getWhere(LinkedHashMap<String, Object> params) {
		if ((params == null) || params.isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(params.size());

		Iterator<Map.Entry<String, Object>> itr = params.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<String, Object> entry = itr.next();

			String key = entry.getKey();
			Object value = entry.getValue();

			if (Validator.isNotNull(value)) {
				sb.append(getWhere(key));
			}
		}

		return sb.toString();
	}

	protected String getWhere(String key) {
		String join = StringPool.BLANK;

		if (key.equals("permissionsResourceId")) {
			join = CustomSQLUtil.get(JOIN_BY_ROLES_PERMISSIONS);
		}
		else if (key.equals("usersRoles")) {
			join = CustomSQLUtil.get(JOIN_BY_USERS_ROLES);
		}

		if (Validator.isNotNull(join)) {
			int pos = join.indexOf("WHERE");

			if (pos != -1) {
				join = join.substring(pos + 5, join.length()).concat(" AND ");
			}
			else {
				join = StringPool.BLANK;
			}
		}

		return join;
	}

	protected void setJoin(
		QueryPos qPos, LinkedHashMap<String, Object> params) {

		if (params != null) {
			Iterator<Map.Entry<String, Object>> itr =
				params.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, Object> entry = itr.next();

				Object value = entry.getValue();

				if (value instanceof Long) {
					Long valueLong = (Long)value;

					if (Validator.isNotNull(valueLong)) {
						qPos.add(valueLong);
					}
				}
				else if (value instanceof String) {
					String valueString = (String)value;

					if (Validator.isNotNull(valueString)) {
						qPos.add(valueString);
					}
				}
			}
		}
	}

}