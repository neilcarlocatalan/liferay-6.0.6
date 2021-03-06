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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertAutoSuggestionDropDownTest extends BaseTestCase {
	public void testAssertAutoSuggestionDropDown() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Tags Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Tags3 Blogs3 Test3 Entry3")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Tags3 Blogs3 Test3 Entry3",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//li[2]/span/span/input")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.type("//li[2]/span/span/input", RuntimeVariables.replace(""));
		selenium.typeKeys("//li[2]/span/span/input",
			RuntimeVariables.replace("selenium"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium1 liferay1"),
			selenium.getText(
				"//li[@class='aui-autocomplete-list-item aui-autocomplete-selected']"));
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText(
				"xPath=(//li[@class='aui-autocomplete-list-item'])"));
		assertEquals(RuntimeVariables.replace("selenium3 liferay3"),
			selenium.getText(
				"xPath=(//li[@class='aui-autocomplete-list-item'])[2]"));
		assertEquals(RuntimeVariables.replace("selenium4 liferay4"),
			selenium.getText(
				"xPath=(//li[@class='aui-autocomplete-list-item'])[3]"));
		selenium.typeKeys("//li[2]/span/span/input",
			RuntimeVariables.replace("2."));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText(
				"//li[@class='aui-autocomplete-list-item aui-autocomplete-selected']"));
		assertFalse(selenium.isElementPresent(
				"xPath=(//li[@class='aui-autocomplete-list-item'])"));
		assertFalse(selenium.isElementPresent(
				"xPath=(//li[@class='aui-autocomplete-list-item'])[2]"));
		assertFalse(selenium.isElementPresent(
				"xPath=(//li[@class='aui-autocomplete-list-item'])[3]"));
	}
}