/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface HasProperties {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object getProperty(String name);
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void setProperty(String name, Object value);
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Object removeProperty(String name);
}
