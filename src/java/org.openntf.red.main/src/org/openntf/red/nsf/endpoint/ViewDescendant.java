/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Interface implemented by all objects that stem from a view object.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface ViewDescendant {
	/**
	 * Returns the ancestor view.
	 * 
	 * @return Ancestor view.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public View getAncestorView();
}
