/**
 * 
 */
package org.openntf.red.security.authorization.impl;

import org.openntf.red.Base;
import org.openntf.red.Session;
import org.openntf.red.security.authorization.IAuthorizationManager;

/**
 * @author Vladimir Kornienko
 *
 */
public class REDAuthorizationManager implements IAuthorizationManager {

	/**
	 * 
	 */
	private REDAuthorizationManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAccess(Session session, Base entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExecute(Session session, Base object, int action) {
		// TODO Auto-generated method stub
		return false;
	}

}
