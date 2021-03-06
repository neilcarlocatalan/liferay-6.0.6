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

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageTag extends TagSupport {

	public int doEndTag() throws JspException {
		try {
			String value =  StringPool.BLANK;

			if (_arguments == null) {
				value = LanguageUtil.get(pageContext, _key);
			}
			else {
				value = LanguageUtil.format(
					pageContext, _key, _arguments, _translateArguments);
			}

			pageContext.getOut().print(value);

			return EVAL_PAGE;
		}
		catch (Exception e) {
			throw new JspException(e);
		}
		finally {
			if (!ServerDetector.isResin()) {
				_arguments = null;
				_key = null;
				_translateArguments = true;
			}
		}
	}

	public void setArguments(Object argument) {
		_arguments = new Object[] {argument};
	}

	public void setArguments(Object[] arguments) {
		_arguments = arguments;
	}

	public void setKey(String key) {
		_key = key;
	}

	public void setTranslateArguments(boolean translateArguments) {
		_translateArguments = translateArguments;
	}

	private Object[] _arguments;
	private String _key;
	private boolean _translateArguments = true;

}