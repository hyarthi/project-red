/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.util.logging.Logger;

import javax.ws.rs.client.WebTarget;

import org.openntf.red.nsf.endpoint.DbOptions;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchDbOptions extends DbOptions {
	// FIXME Is this class even needed? For now leave as it is, with minimal use - might be needed for special access modes in the future.
	private String dbpath = null;
	private boolean createOnFail = false;
	private final WebTarget basetarget;
	private static final Logger log = Logger.getLogger(CouchDbOptions.class.getName());

	/**
	 * 
	 */
	public CouchDbOptions(WebTarget _target) {
		basetarget = _target;
	}

	public String getDbpath() {
		return dbpath;
	}

	public void setDbpath(String dbpath) {
		this.dbpath = dbpath;
	}
	
	public CouchDbOptions dbPath(String dbpath) {
		this.dbpath = dbpath;
		return this;
	}

	public boolean isCreateOnFail() {
		return createOnFail;
	}

	public void setCreateOnFail(boolean createOnFail) {
		this.createOnFail = createOnFail;
	}
	
	public CouchDbOptions createOnFail(boolean createOnFail) {
		this.createOnFail = createOnFail;
		return this;
	}
	
	public WebTarget getBaseTarget() {
		return basetarget;
	}

}
