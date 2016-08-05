/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Note extends HasProperties {
	/**
	 * 
	 * @param type
	 * @return
	 */
	public <T extends Base> T castTo(Class<T> type) throws ClassCastException;
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Field getField(String name);
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setField(String name, Field value);
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Field removeField(String name);
}
