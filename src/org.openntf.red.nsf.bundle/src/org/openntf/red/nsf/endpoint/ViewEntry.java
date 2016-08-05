/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ViewEntry extends HasProperties {
	public Object getColumn(int idx);
	public Object getColumn(String name);
}
