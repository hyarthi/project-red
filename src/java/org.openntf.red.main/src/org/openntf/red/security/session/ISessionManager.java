/**
 * 
 */
package org.openntf.red.security.session;

import org.openntf.red.core.IREDService;
//import org.openntf.red.Session.Type;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ISessionManager extends IREDService {
	//public org.openntf.red.Session getSession();
	//public org.openntf.red.Session getSession(Type type);
	//public org.openntf.red.Session processSession(org.openntf.red.Session session);
	public void registerSession(org.openntf.red.Session session);
	public void deregisterSession(org.openntf.red.Session session);
}
