/**
 * 
 */
package org.openntf.red.security.impl;

import org.openntf.red.security.ISecurityManager;
import org.openntf.red.security.session.ISessionManager;
import org.openntf.red.security.session.impl.REDSessionManager;

/**
 * Default implementation of the Security Manager.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see ISecurityManager
 */
public class REDSecurityManager implements ISecurityManager {

	/** Session Manager reference. */
	private ISessionManager sessionManager = null;
	/** Flag - whether the service is initialized. */
	private boolean _started;
	/**
	 * Object instance reference. There can be only 1 Security Manager instance
	 * per runtime.
	 */
	private static REDSecurityManager _instance = null;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	private REDSecurityManager() {
		_started = false;
	}

	/**
	 * Static function to get the object reference.
	 * 
	 * @return Security Manager instance.
	 * @since 0.4.0
	 */
	public static REDSecurityManager getInstance() {
		synchronized (REDSecurityManager.class) {
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
