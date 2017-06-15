/**
 * 
 */
package org.openntf.red.security;

import org.openntf.red.core.IREDService;
import org.openntf.red.security.session.ISessionManager;

/**
 * Entity representing an abstract Security Manager service.<br>
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface ISecurityManager extends IREDService {
	/**
	 * Returns the current Session Manager implementation.
	 * 
	 * @return Session Manager implementation.
	 * @since 0.4.0
	 */
	public ISessionManager getSessionManager();
}
