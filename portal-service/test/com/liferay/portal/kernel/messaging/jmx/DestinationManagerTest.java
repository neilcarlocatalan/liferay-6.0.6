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

package com.liferay.portal.kernel.messaging.jmx;

import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.test.TestCase;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;

/**
 * @author Michael C. Han
 */
public class DestinationManagerTest extends TestCase {

	public void setUp() throws Exception {
		_mBeanServer = ManagementFactory.getPlatformMBeanServer();
		_mockery = new JUnit4Mockery();
	}

	public void testRegisterMBean() throws Exception {
		_mBeanServer.registerMBean(
			new DestinationManager(_mockery.mock(Destination.class)),
			DestinationManager.createObjectName("test"));

		assertTrue(
			_mBeanServer.isRegistered(
				DestinationManager.createObjectName("test")));
	}

	private MBeanServer _mBeanServer;
	private Mockery _mockery;

}