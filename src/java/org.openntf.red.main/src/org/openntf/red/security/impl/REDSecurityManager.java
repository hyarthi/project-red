/**
 * 
 */
package org.openntf.red.security.impl;

import org.openntf.red.security.ISecurityManager;
import org.openntf.red.security.session.ISessionManager;
import org.openntf.red.security.session.impl.REDSessionManager;

/**
 * @author Vladimir Kornienko
 *
 */
public class REDSecurityManager implements ISecurityManager {
	
	private ISessionManager sessionManager = null;
	private boolean _started;
	private static REDSecurityManager _instance = null;
	
	/**
	 * 
	 */
	private REDSecurityManager() {
		_started = false;
	}
	
	public static REDSecurityManager getInstance() {
		synchronized(REDSecurityManager.class) {
			if (null == _instance) {
				_instance = new REDSecurityManager();
			}
		}
		return _instance;
	}

	@Override
	public void startup() {
		// FIXME Make settings-based
		sessionManager = REDSessionManager.getInstance();
		sessionManager.startup();
		_started = true;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		_started = false;
	}

	@Override
	public ISessionManager getSessionManager() {
		return sessionManager;
	}

	@Override
	public boolean isStarted() {
		return _started;
	}
	
}
