/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Field extends HasProperties {
	/**
	 * 
	 * @return
	 */
	public Object getValue();
	/**
	 * 
	 * @param value
	 */
	public void setValue(Object value);
}
