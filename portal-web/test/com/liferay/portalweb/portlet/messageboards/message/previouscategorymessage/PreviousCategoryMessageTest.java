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

package com.liferay.portalweb.portlet.messageboards.message.previouscategorymessage;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class PreviousCategoryMessageTest extends BaseTestCase {
	public void testPreviousCategoryMessage() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[5]/td[1]/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("T\u00e9st1 M\u00e9ssag\u00e91"),
			selenium.getText("//div[1]/h1/span"));
		selenium.clickAt("//form/div[2]/div[1]/a",
			RuntimeVariables.replace("Previous"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("T\u00e9st2 M\u00e9ssag\u00e92"),
			selenium.getText("//div[1]/h1/span"));
		selenium.clickAt("//form/div[2]/div[1]/a[1]",
			RuntimeVariables.replace("Previous"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("T\u00e9st3 M\u00e9ssag\u00e93"),
			selenium.getText("//div[1]/h1/span"));
	}
}