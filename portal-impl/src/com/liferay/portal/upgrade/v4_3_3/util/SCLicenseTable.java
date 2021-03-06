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

package com.liferay.portal.upgrade.v4_3_3.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class SCLicenseTable {

	public static String TABLE_NAME = "SCLicense";

	public static Object[][] TABLE_COLUMNS = {
		{"licenseId", new Integer(Types.BIGINT)},
		{"name", new Integer(Types.VARCHAR)},
		{"url", new Integer(Types.VARCHAR)},
		{"openSource", new Integer(Types.BOOLEAN)},
		{"active_", new Integer(Types.BOOLEAN)},
		{"recommended", new Integer(Types.BOOLEAN)}
	};

	public static String TABLE_SQL_CREATE = "create table SCLicense (licenseId LONG not null primary key,name VARCHAR(75) null,url STRING null,openSource BOOLEAN,active_ BOOLEAN,recommended BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table SCLicense";

}