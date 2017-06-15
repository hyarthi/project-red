/**
 * 
 */
package org.openntf.red.security.session.impl;

import java.util.List;
//import java.util.Map;
import java.util.logging.Logger;

import org.openntf.red.Session;
//import org.openntf.red.Session.Type;
import org.openntf.red.security.exceptions.SessionManagerException;
import org.openntf.red.security.session.ISessionManager;

import javolution.util.FastMap;
import javolution.util.FastTable;

/**
 * Default implementation of a Session Manager.<br>
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see ISessionManager
 */
public class REDSessionManager implements ISessionManager {

	/** Logger object. */
	private static Logger log = Logger.getLogger(REDSessionManager.class.getName());
	/** Session Manager instance. There can be only 1 per runtime. */
	private static REDSessionManager _instance = null;
	/** Is the service initialized. */
	private boolean _started;
	/** Cache of user sessions. */
	private FastMap<String, List<Session>> _userSessionCache;

	/**
	 * Static function to get the Session Manager instance.
	 * 
	 * @return Session Manager instance.
	 * @since 0.4.0
	 */
	public static REDSessionManager getInstance() {
		synchronized (REDSessionManager.class) {
			if (null == _instance)
				_instance = new REDSessionManager();
		}
		return _instance;
	}

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	private REDSessionManager() {
		_started = false;
	}

	@Override
	public void startup() {
		log.info("Session Manager: Starting...");
		_userSessionCache = new FastMap<String, List<Session>>().atomic();
		// TODO Auto-generated method stub
		_started = true;
		log.info("Session Manager: Started.");
	}

	@Override
	public void shutdown() {
		if (!_started)
			return; // FIXME throw exception here
		log.info("Session Manager: Shutting down...");
		for (List<Session> sessions : _userSessionCache.values()) {
			for (Session session : sessions) {
				session.recycle();
			}
			sessions.clear();
		}
		_userSessionCache.clear();
		// TODO Auto-generated method stub
		_started = false;
		log.info("Session Manager: Stopped.");
	}

	@Override
	public boolean isStarted() {
		return _started;
	}

	@Override
	public void registerSession(Session session) {
		log.finer("Session Manager: Registering session...");
		if (!_started)
			throw new SessionManagerException("Session Manager not running.");
		String user = session.getEffectiveUserName();
		List<Session> sessions;
		if (_userSessionCache.containsKey(user))
			sessions = _userSessionCache.get(user);
		else {
			sessions = new FastTable<Session>().atomic();
			_userSessionCache.put(user, sessions);
		}
		sessions.add(session);
	}

	@Override
	public void deregisterSession(Session session) {
		log.finer("Session Manager: Deregistering session...");
		if (!_started)
			throw new SessionManagerException("Session Manager not running.");
		String user = session.getEffectiveUserName();
		if (!_userSessionCache.containsKey(user))
			return;
		_userSessionCache.get(user).remove(session);
	}

	/*
	 * // TODO - do we really need session processing this complex?
	 * 
	 * @Override public Session processSession(Session session) { if (!_started)
	 * return null; // FIXME probably better to throw exception here String user
	 * = session.getEffectiveUserName(); Map<String, Map<Session.Type, Session>>
	 * dbsessions; if (_userSessionCache.containsKey(user)) { dbsessions =
	 * _userSessionCache.get(user); } else { dbsessions = new FastMap<String,
	 * Map<Session.Type, Session>>().atomic(); _userSessionCache.put(user,
	 * dbsessions); } Map<Session.Type, Session> sessions; String dbPath =
	 * session.getCurrentDatabasePath(); if (dbsessions.containsKey(dbPath)) {
	 * sessions = dbsessions.get(dbPath); } else { sessions = new
	 * FastMap<Session.Type, Session>().atomic(); dbsessions.put(dbPath,
	 * sessions); } Type type; if
	 * (sessions.containsKey(session.getSessionType())) { type =
	 * session.getSessionType(); session.recycle(); return sessions.get(type); }
	 * else { sessions.put(session.getSessionType(), session); return session; }
	 * }
	 */

	/*
	 * @Override public Session getSession() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Session getSession(Type type) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
