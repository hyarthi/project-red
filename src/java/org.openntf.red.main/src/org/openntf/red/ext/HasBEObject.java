/**
 * 
 */
package org.openntf.red.ext;

/**
 * Interface identifying that this object has a back-end object that handles
 * data.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface HasBEObject<T extends org.openntf.red.nsf.endpoint.Base<?, ?, ?>> {
	/**
	 * Returns the back-end object instance. Restricted function.
	 * 
	 * @return Back-end object instance
	 * @since 0.4.0
	 */
	public T getBEObject();
}
