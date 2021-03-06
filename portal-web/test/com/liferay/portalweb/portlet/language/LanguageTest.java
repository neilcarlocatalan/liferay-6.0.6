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

package com.liferay.portalweb.portlet.language;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class LanguageTest extends BaseTestCase {
	public void testLanguage() throws Exception {
		selenium.clickAt("//img[@alt='\u0627\u0644\u0639\u0631\u0628\u064a\u0629 (\u0627\u0644\u0633\u0639\u0648\u062f\u064a\u0629)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("\u0623\u0636\u0641"));
		selenium.clickAt("//img[@alt='catal\u00e0 (Andorra)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Afegeix"));
		selenium.clickAt("//img[@alt='catal\u00e0 (Espanya)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Afegeix"));
		selenium.clickAt("//img[@alt='\u4e2d\u6587 (\u4e2d\u56fd)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("\u6dfb\u52a0"));
		selenium.clickAt("//img[@alt='\u4e2d\u6587 (\u53f0\u7063)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("\u589e\u52a0"));
		selenium.clickAt("//img[@alt='\u010de\u0161tina (\u010cesk\u00e1 republika)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("P\u0159idat"));
		selenium.clickAt("//img[@alt='Nederlands (Nederland)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Toevoegen"));
		selenium.clickAt("//img[@alt='suomi (Suomi)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Lis\u00e4\u00e4"));
		selenium.clickAt("//img[@alt='fran\u00e7ais (France)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Ajouter"));
		selenium.clickAt("//img[@alt='Deutsch (Deutschland)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Hinzuf\u00fcgen"));
		selenium.clickAt("//img[@alt='\u03b5\u03bb\u03bb\u03b7\u03bd\u03b9\u03ba\u03ac (\u0395\u03bb\u03bb\u03ac\u03b4\u03b1)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"\u03a0\u03c1\u03bf\u03c3\u03b8\u03ae\u03ba\u03b7"));
		selenium.clickAt("//img[@alt='magyar (Magyarorsz\u00e1g)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Add"));
		selenium.clickAt("//img[@alt='italiano (Italia)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Aggiungi"));
		selenium.clickAt("//img[@alt='\u65e5\u672c\u8a9e (\u65e5\u672c)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("\u8ffd\u52a0"));
		selenium.clickAt("//img[@alt='Persian (Iran)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"\u0627\u0636\u0627\u0641\u0647 \u06a9\u0631\u062f\u0646"));
		selenium.clickAt("//img[@alt='Ti\u1ebfng Vi\u1ec7t (Vi\u1ec7t Nam)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Th\u00eam"));
		selenium.clickAt("//img[@alt='T\u00fcrk\u00e7e (T\u00fcrkiye)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Ekle"));
		selenium.clickAt("//img[@alt='svenska (Sverige)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("L\u00e4gg till"));
		selenium.clickAt("//img[@alt='espa\u00f1ol (Espa\u00f1a)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("A\u00f1adir"));
		selenium.clickAt("//img[@alt='\u0440\u0443\u0441\u0441\u043a\u0438\u0439 (\u0420\u043e\u0441\u0441\u0438\u044f)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c"));
		selenium.clickAt("//img[@alt='portugu\u00eas (Brasil)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Adicionar"));
		selenium.clickAt("//img[@alt='English (United States)']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Add"));
	}
}