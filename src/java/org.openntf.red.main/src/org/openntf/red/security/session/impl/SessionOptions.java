/**
 * 
 */
package org.openntf.red.security.session.impl;

import org.openntf.red.Session;

/**
 * @author Vladimir Kornienko
 *
 */
public class SessionOptions {
	
	private String dbPath;
	private Session.Type type;
	// TODO add invoker source

	/**
	 * 
	 */
	public SessionOptions(String _dbPath, Session.Type _type) {
		dbPath = _dbPath;
		type = _type;
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}

	public Session.Type getType() {
		return type;
	}

	public void setType(Session.Type type) {
		this.type = type;
	}

}
