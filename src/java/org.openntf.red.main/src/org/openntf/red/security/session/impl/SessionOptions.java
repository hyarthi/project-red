/**
 * 
 */
package org.openntf.red.security.session.impl;

import org.openntf.red.Session;

/**
 * Utility object that stores the session options for session initialization.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class SessionOptions {

	/** Database path that the session is tied to. */
	private String dbPath;
	/** Session type. */
	private Session.Type type;
	// TODO add invoker source

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public SessionOptions(String _dbPath, Session.Type _type) {
		dbPath = _dbPath;
		type = _type;
	}

	/**
	 * Returns the database path that the session is tied to.
	 * 
	 * @return Database path.
	 * @since 0.4.0
	 */
	public String getDbPath() {
		return dbPath;
	}

	/**
	 * Sets the database path that the session is tied to.
	 * 
	 * @param dbPath
	 *            Database path.
	 * @since 0.4.0
	 */
	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}

	/**
	 * Returns the session type.
	 * 
	 * @return Session type.
	 * @since 0.4.0
	 */
	public Session.Type getType() {
		return type;
	}

	/**
	 * Sets the session type.
	 * 
	 * @param type
	 *            Session type.
	 * @since 0.4.0
	 */
	public void setType(Session.Type type) {
		this.type = type;
	}

}
