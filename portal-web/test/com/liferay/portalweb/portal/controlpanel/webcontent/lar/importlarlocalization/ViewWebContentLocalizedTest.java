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

package com.liferay.portalweb.portal.controlpanel.webcontent.lar.importlarlocalization;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentLocalizedTest extends BaseTestCase {
	public void testViewWebContentLocalized() throws Exception {
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
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[3]/a",
			RuntimeVariables.replace("Hello World Localized Article"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals("Hello World Page Name", selenium.getValue("page-name"));
		assertEquals("Hello World Page Description",
			selenium.getValue("page-description"));
		selenium.select("_15_languageId",
			RuntimeVariables.replace("label=Chinese (China)"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals("\u4e16\u754c\u60a8\u597d Page Name",
			selenium.getValue("page-name"));
		assertEquals("\u4e16\u754c\u60a8\u597d Page Description",
			selenium.getValue("page-description"));
		selenium.select("_15_languageId",
			RuntimeVariables.replace("label=English (United States)"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Structures", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("LOCALIZED"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Test Localized Structure\nThis is a test localized structure."),
			selenium.getText("//td[3]/a"));
		selenium.clickAt("link=Templates", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("LOCALIZED"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace(
				"Test Localized Template\n This is a test localized template."),
			selenium.getText("//td[3]/a"));
	}
}