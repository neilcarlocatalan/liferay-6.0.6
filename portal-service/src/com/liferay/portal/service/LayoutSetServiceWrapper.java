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

package com.liferay.portal.service;

/**
 * <p>
 * This class is a wrapper for {@link LayoutSetService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutSetService
 * @generated
 */
public class LayoutSetServiceWrapper implements LayoutSetService {
	public LayoutSetServiceWrapper(LayoutSetService layoutSetService) {
		_layoutSetService = layoutSetService;
	}

	public void updateLogo(long groupId, boolean privateLayout, boolean logo,
		java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_layoutSetService.updateLogo(groupId, privateLayout, logo, file);
	}

	public com.liferay.portal.model.LayoutSet updateLookAndFeel(long groupId,
		boolean privateLayout, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetService.updateLookAndFeel(groupId, privateLayout,
			themeId, colorSchemeId, css, wapTheme);
	}

	public com.liferay.portal.model.LayoutSet updateSettings(long groupId,
		boolean privateLayout, java.lang.String settings)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetService.updateSettings(groupId, privateLayout, settings);
	}

	public com.liferay.portal.model.LayoutSet updateVirtualHost(long groupId,
		boolean privateLayout, java.lang.String virtualHost)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layoutSetService.updateVirtualHost(groupId, privateLayout,
			virtualHost);
	}

	public LayoutSetService getWrappedLayoutSetService() {
		return _layoutSetService;
	}

	private LayoutSetService _layoutSetService;
}