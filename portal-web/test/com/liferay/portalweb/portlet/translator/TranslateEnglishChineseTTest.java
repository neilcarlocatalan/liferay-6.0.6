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

package com.liferay.portalweb.portlet.translator;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TranslateEnglishChineseTTest extends BaseTestCase {
	public void testTranslateEnglishChineseT() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Translator Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Translator Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.select("_26_id",
			RuntimeVariables.replace("label=English to Chinese (Taiwan)"));
		selenium.type("_26_text",
			RuntimeVariables.replace(
				"My name is Liferay Translator, fluent in over 6 million forms of communication."));
		selenium.click(RuntimeVariables.replace("//input[@value='Translate']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"\u6211\u7684\u540d\u5b57\u662fLiferay\u8b6f\u8005\uff0c\u6d41\u5229\u5b8c\u5168\u6210\u529f6\u901a\u4fe1\u7684\u767e\u842c\u500b\u5f62\u5f0f\u3002"));
	}
}