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
package org.hlc.quickvd.handler;

import java.util.Collection;
import java.util.Map;

import org.hlc.quickvd.annotation.Length;

// TODO: Auto-generated Javadoc
/**
 * TODO.
 * 
 * @author huanglicong
 * @version V1.0
 */
public class LengthHandler extends BaseHandler<Length> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean handle(Length length, Object value) {

		if (length != null && value != null) {
			boolean bool = false;
			if (value instanceof Collection) {
				bool = (((Collection<?>) value).size() > length.value());
			} else if (value instanceof Map) {
				bool = (((Map<?, ?>) value).size() > length.value());
			} else if (value instanceof String) {
				bool = (((String) value).length() > length.value());
			} else if (value instanceof Object[]) {
				bool = (((Object[]) value).length > length.value());
			}
			return bool;
		}
		return false;
	}

}
