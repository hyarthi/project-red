/**
 * 
 */
package org.openntf.red.security;

import org.openntf.red.core.IREDService;
import org.openntf.red.security.session.ISessionManager;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ISecurityManager extends IREDService {
	public ISessionManager getSessionManager();
}
