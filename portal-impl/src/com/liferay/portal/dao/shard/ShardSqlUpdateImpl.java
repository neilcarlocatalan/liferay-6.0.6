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

package com.liferay.portal.dao.shard;

import com.liferay.portal.dao.jdbc.spring.SqlUpdateImpl;
import com.liferay.portal.kernel.dao.shard.ShardUtil;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

/**
 * @author Alexander Chow
 */
public class ShardSqlUpdateImpl extends SqlUpdateImpl {

	public ShardSqlUpdateImpl(DataSource dataSource, String sql, int[] types) {
		super(dataSource, sql, types);
	}

	public int update(Object... params) throws DataAccessException {
		setDataSource(ShardUtil.getDataSource());

		return super.update(params);
	}

}