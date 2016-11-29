/**
 * 
 */
package org.openntf.red.security.authorization;

import org.openntf.red.Base;
import org.openntf.red.Session;

/**
 * @author Vladimir Kornienko
 *
 */
public interface IAuthorizationManager {
	public boolean canAccess(Session session, Base entity);
	public boolean canExecute(Session session, Base object, int action);
	
	public static enum Action {
		OPEN(0),
		READ(1),
		WRITE(2),
		DELETE(3),
		RUN(4),
		CREATE(5)
		;
		private int code;
		
		private Action(int _code) {
			code = _code;
		}
	}
}
