/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.util.logging.Logger;

import javax.ws.rs.client.WebTarget;

import org.openntf.red.nsf.endpoint.DbOptions;

/**
 * CouchDB-specific options.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see DbOptions
 */
public class CouchDbOptions extends DbOptions {
	// FIXME Is this class even needed? For now leave as it is, with minimal use
	// - might be needed for special access modes in the future.
	/** Database "path" (adjusted for CouchDB). */
	private String dbpath = null;
	/**
	 * Whether the server should attempt to create a database if none is found.
	 */
	private boolean createOnFail = false;
	/** Database web target (Java RS). */
	private final WebTarget basetarget;
	/** Logger object. */
	private static final Logger log = Logger.getLogger(CouchDbOptions.class.getName());

	/**
	 * Default constructor.
	 * 
	 * @param _target
	 *            Database web target (Java RS).
	 * @since 0.4.0
	 */
	public CouchDbOptions(WebTarget _target) {
		basetarget = _target;
	}

	/**
	 * Returns the database "path" (adjusted for CouchDB).
	 * 
	 * @return Database "path".
	 * @since 0.4.0
	 */
	public String getDbpath() {
		return dbpath;
	}

	/**
	 * Sets the database "path".
	 * 
	 * @param dbpath
	 *            New database "path"
	 * @since 0.4.0
	 */
	public void setDbpath(String dbpath) {
		this.dbpath = dbpath;
	}

	/**
	 * Sets the database "path".
	 * 
	 * @param dbpath
	 *            New database "path".
	 * @return Object instance.
	 * @since 0.4.0
	 */
	public CouchDbOptions dbPath(String dbpath) {
		this.dbpath = dbpath;
		return this;
	}

	/**
	 * Returns whether the server should attempt to create a database if none is
	 * found.
	 * 
	 * @return Whether the server should attempt to create a database if none is
	 *         found.
	 * @since 0.4.0
	 */
	public boolean isCreateOnFail() {
		return createOnFail;
	}

	/**
	 * Sets whether the server should attempt to create a database if none is
	 * found.
	 * 
	 * @param createOnFail
	 *            Whether the server should attempt to create a database if none
	 *            is found.
	 * @since 0.4.0
	 */
	public void setCreateOnFail(boolean createOnFail) {
		this.createOnFail = createOnFail;
	}

	/**
	 * Sets whether the server should attempt to create a database if none is
	 * found.
	 * 
	 * @param createOnFail
	 *            Whether the server should attempt to create a database if none
	 *            is found.
	 * @return Object instance.
	 * @since 0.4.0
	 */
	public CouchDbOptions createOnFail(boolean createOnFail) {
		this.createOnFail = createOnFail;
		return this;
	}

	/**
	 * Returns the database web target (Java RS).
	 * 
	 * @return Database web target.
	 * @since 0.4.0
	 */
	public WebTarget getBaseTarget() {
		return basetarget;
	}

}
