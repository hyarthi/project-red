/**
 * 
 */
package org.openntf.red.security.authorization.impl;

import org.openntf.red.Base;
import org.openntf.red.Session;
import org.openntf.red.security.authorization.IAuthorizationManager;

/**
 * Default implementation of the Authorization Manager.<br>
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see IAuthorizationManager
 */
public class REDAuthorizationManager implements IAuthorizationManager {

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
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
