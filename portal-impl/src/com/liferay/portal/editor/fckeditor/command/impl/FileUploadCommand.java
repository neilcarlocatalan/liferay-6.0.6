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

package com.liferay.portal.editor.fckeditor.command.impl;

import com.liferay.portal.editor.fckeditor.command.Command;
import com.liferay.portal.editor.fckeditor.command.CommandArgument;
import com.liferay.portal.editor.fckeditor.receiver.CommandReceiver;
import com.liferay.portal.editor.fckeditor.receiver.CommandReceiverFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivica Cardic
 */
public class FileUploadCommand implements Command {

	public void execute(
		CommandArgument argument, HttpServletRequest request,
		HttpServletResponse response) {

		CommandReceiver receiver = CommandReceiverFactory.getCommandReceiver(
			argument.getType());

		receiver.fileUpload(argument, request, response);
	}

}