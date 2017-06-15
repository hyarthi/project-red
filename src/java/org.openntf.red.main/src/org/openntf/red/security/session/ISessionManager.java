/**
 * 
 */
package org.openntf.red.security.session;

import org.openntf.red.core.IREDService;

/**
 * Entity representing an abstract Session Manager.<br>
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface ISessionManager extends IREDService {
	// public org.openntf.red.Session getSession();
	// public org.openntf.red.Session getSession(Type type);
	// public org.openntf.red.Session processSession(org.openntf.red.Session
	// session);
	/**
	 * Registers a user session.
	 * 
	 * @param session
	 *            User session to register.
	 * @since 0.4.0
	 */
	public void registerSession(org.openntf.red.Session session);

	/**
	 * Deregisters a user session.
	 * 
	 * @param session
	 *            User session to register.
	 * @since 0.4.0
	 */
	public void deregisterSession(org.openntf.red.Session session);
}
