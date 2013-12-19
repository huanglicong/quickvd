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

// TODO: Auto-generated Javadoc
/**
 * 验证异常.
 * 
 * @author huanglicong
 * @version V1.0
 */
public class ValidatorException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2654864880853177212L;

	/**
	 * Instantiates a new validator exception.
	 */
	public ValidatorException() {

		super();
	}

	/**
	 * Instantiates a new validator exception.
	 * 
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public ValidatorException(String arg0, Throwable arg1) {

		super(arg0, arg1);
	}

	/**
	 * Instantiates a new validator exception.
	 * 
	 * @param arg0 the arg0
	 */
	public ValidatorException(String arg0) {

		super(arg0);
	}

	/**
	 * Instantiates a new validator exception.
	 * 
	 * @param arg0 the arg0
	 */
	public ValidatorException(Throwable arg0) {

		super(arg0);
	}

}
