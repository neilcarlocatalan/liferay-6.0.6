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

package com.liferay.portal.increment;

import com.liferay.portal.kernel.cache.key.CacheKeyGenerator;
import com.liferay.portal.kernel.cache.key.CacheKeyGeneratorUtil;
import com.liferay.portal.kernel.concurrent.BatchablePipe;
import com.liferay.portal.kernel.increment.BufferedIncrement;
import com.liferay.portal.kernel.increment.Increment;
import com.liferay.portal.kernel.increment.IncrementFactory;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.MethodTargetClassKey;
import com.liferay.portal.spring.aop.AnnotationChainableMethodAdvice;

import java.lang.annotation.Annotation;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Zsolt Berentey
 * @author Shuyang Zhou
 */
public class BufferedIncrementAdvice
	extends AnnotationChainableMethodAdvice<BufferedIncrement> {

	@SuppressWarnings("rawtypes")
	public Object before(MethodInvocation methodInvocation) throws Throwable {
		MethodTargetClassKey methodTargetClassKey = buildMethodTargetClassKey(
			methodInvocation);

		BufferedIncrement bufferedIncrement = findAnnotation(
			methodTargetClassKey);

		if (bufferedIncrement == _nullBufferedIncrement) {
			return null;
		}

		Object[] arguments = methodInvocation.getArguments();

		Object value = arguments[arguments.length - 1];

		CacheKeyGenerator cacheKeyGenerator =
			CacheKeyGeneratorUtil.getCacheKeyGenerator(
				BufferedIncrementAdvice.class.getName());

		cacheKeyGenerator.append(methodTargetClassKey.toString());

		for (int i = 0; i < arguments.length - 1; i++) {
			cacheKeyGenerator.append(String.valueOf(arguments[i]));
		}

		String batchKey = cacheKeyGenerator.finish();

		Increment<?> increment = IncrementFactory.createIncrement(
			bufferedIncrement.incrementClass(), value);

		BufferedIncreasableEntry bufferedIncreasableEntry =
			new BufferedIncreasableEntry(
				nextMethodInterceptor, methodInvocation, batchKey, increment);

		_batchablePipe.put(bufferedIncreasableEntry);

		MessageBusUtil.sendMessage(
			DestinationNames.BUFFERED_INCREMENT, _batchablePipe);

		return nullResult;
	}

	public BufferedIncrement getNullAnnotation() {
		return _nullBufferedIncrement;
	}

	@SuppressWarnings("rawtypes")
	private static BatchablePipe<String, BufferedIncreasableEntry>
		_batchablePipe = new BatchablePipe<String, BufferedIncreasableEntry>();

	private static BufferedIncrement _nullBufferedIncrement =
		new BufferedIncrement() {

			public Class<? extends Annotation> annotationType() {
				return BufferedIncrement.class;
			}

			public Class<? extends Increment<?>> incrementClass() {
				return null;
			}

		};

}