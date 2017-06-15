/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Interface assigned to any entity that can be worked with on a map/property
 * principle.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface HasProperties {
	/**
	 * Returns a specified property value.
	 * 
	 * @param name
	 *            Property name.
	 * @return Property value.
	 * @since 0.4.0
	 */
	public Object getProperty(String name);

	/**
	 * Sets the specified property value.
	 * 
	 * @param name
	 *            Property name.
	 * @param value
	 *            New property value.
	 * @since 0.4.0
	 */
	public void setProperty(String name, Object value);

	/**
	 * Remove/clear a property.
	 * 
	 * @param name
	 *            Property name.
	 * @return Old property value.
	 * @since 0.4.0
	 */
	public Object removeProperty(String name);
}
