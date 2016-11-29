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
 * @author Vladimir Kornienko
 *
 */
public class REDSessionManager implements ISessionManager {

	private static Logger log = Logger.getLogger(REDSessionManager.class.getName());
	private static REDSessionManager _instance = null;
	private boolean _started;
	private FastMap<String, List<Session>> _userSessionCache;

	public static REDSessionManager getInstance() {
		synchronized (REDSessionManager.class) {
			if (null == _instance)
				_instance = new REDSessionManager();
		}
		return _instance;
	}

	/**
	 * 
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

	/*// TODO - do we really need session processing this complex?
	@Override
	public Session processSession(Session session) {
		if (!_started)
			return null; // FIXME probably better to throw exception here
		String user = session.getEffectiveUserName();
		Map<String, Map<Session.Type, Session>> dbsessions;
		if (_userSessionCache.containsKey(user)) {
			dbsessions = _userSessionCache.get(user);
		} else {
			dbsessions = new FastMap<String, Map<Session.Type, Session>>().atomic();
			_userSessionCache.put(user, dbsessions);
		}
		Map<Session.Type, Session> sessions;
		String dbPath = session.getCurrentDatabasePath();
		if (dbsessions.containsKey(dbPath)) {
			sessions = dbsessions.get(dbPath);
		} else {
			sessions = new FastMap<Session.Type, Session>().atomic();
			dbsessions.put(dbPath, sessions);
		}
		Type type;
		if (sessions.containsKey(session.getSessionType())) {
			type = session.getSessionType();
			session.recycle();
			return sessions.get(type);
		} else {
			sessions.put(session.getSessionType(), session);
			return session;
		}
	}*/

	/*
	 * @Override public Session getSession() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Session getSession(Type type) { // TODO Auto-generated
	 * method stub return null; }
	 */

}
