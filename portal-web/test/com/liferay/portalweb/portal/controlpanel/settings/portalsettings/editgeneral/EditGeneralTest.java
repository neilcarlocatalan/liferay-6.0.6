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

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.editgeneral;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditGeneralTest extends BaseTestCase {
	public void testEditGeneral() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("generalLink", RuntimeVariables.replace(""));
		selenium.type("_130_legalId", RuntimeVariables.replace("LIFE"));
		selenium.type("_130_sicCode", RuntimeVariables.replace("1234"));
		selenium.type("_130_tickerSymbol", RuntimeVariables.replace("LFRY"));
		selenium.type("_130_industry", RuntimeVariables.replace("Web Portal"));
		selenium.type("_130_type", RuntimeVariables.replace("Open Source"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals("LIFE", selenium.getValue("_130_legalId"));
		assertEquals("1234", selenium.getValue("_130_sicCode"));
		assertEquals("LFRY", selenium.getValue("_130_tickerSymbol"));
		assertEquals("Web Portal", selenium.getValue("_130_industry"));
		assertEquals("Open Source", selenium.getValue("_130_type"));
	}
}