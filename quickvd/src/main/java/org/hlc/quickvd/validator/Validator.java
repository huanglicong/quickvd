/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hlc.quickvd.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hlc.quickvd.annotation.Length;
import org.hlc.quickvd.annotation.Max;
import org.hlc.quickvd.annotation.Min;
import org.hlc.quickvd.annotation.NotEmpty;
import org.hlc.quickvd.annotation.NotNull;
import org.hlc.quickvd.annotation.Pattern;
import org.hlc.quickvd.handler.LengthHandler;
import org.hlc.quickvd.handler.MaxHandler;
import org.hlc.quickvd.handler.MinHandler;
import org.hlc.quickvd.handler.NotEmptyHandler;
import org.hlc.quickvd.handler.NotNullHandler;
import org.hlc.quickvd.handler.PatternHandler;
import org.hlc.quickvd.handler.ValidateHandler;
import org.hlc.quickvd.utils.ReflectionUtils;

/**
 * TODO.
 * 
 * @author huanglicong
 * @version V1.0
 */
public class Validator {

	private static final Validator VALIDATOR = new Validator();

	@SuppressWarnings("rawtypes")
	private Map<Class, ValidateHandler> handlers = new LinkedHashMap<Class, ValidateHandler>();

	private Validator() {
		handlers.put(Length.class, new LengthHandler());
		handlers.put(Max.class, new MaxHandler());
		handlers.put(Min.class, new MinHandler());
		handlers.put(NotEmpty.class, new NotEmptyHandler());
		handlers.put(NotNull.class, new NotNullHandler());
		handlers.put(Pattern.class, new PatternHandler());
	}

	public static Validator getinstance() {
		return VALIDATOR;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void validateField(Field field, Object target, ValidateResult result) {

		Object value = null;
		try {
			value = ReflectionUtils.invokeGetterMethod(target, field.getName());
		} catch (Exception e) {
			throw new ValidatorException(e);
		}
		Annotation[] annotations = field.getDeclaredAnnotations();
		ValidateHandler handler = null;
		for (Annotation item : annotations) {
			handler = handlers.get(item.annotationType());
			if (handler == null) {
				continue;
			}
			if (handler.handle(item, value)) {
				result.setMessage(target.getClass().getSimpleName(), field.getName(), item.annotationType().getSimpleName(), value);
			}
		}
	}

	public void validate(Object target, ValidateResult result) {
		Class<?> type = target.getClass();
		Field[] fields = type.getDeclaredFields();
		for (Field item : fields) {
			validateField(item, target, result);
		}
	}
}
