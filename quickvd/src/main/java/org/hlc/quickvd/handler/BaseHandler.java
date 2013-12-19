package org.hlc.quickvd.handler;

import java.util.Collection;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseHandler.
 *
 * @author  huanglicong
 * @since  quickvd
 * @version V1.3
 */
public abstract class BaseHandler<T> implements ValidateHandler<T> {

	/**
	 * Checks if is collection.
	 *
	 * @param value the value
	 * @return true, if is collection
	 */
	public boolean isCollection(Object value) {
		return (value instanceof Collection || value instanceof Object[]);
	}

	/**
	 * Checks if is map.
	 *
	 * @param value the value
	 * @return true, if is map
	 */
	public boolean isMap(Object value) {
		return (value instanceof Map);
	}

	/**
	 * Checks if is string.
	 *
	 * @param value the value
	 * @return true, if is string
	 */
	public boolean isString(Object value) {
		return (value instanceof String);
	}

}
