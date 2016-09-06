/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.http.StdHttpClient.Builder;
import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.DbOptions;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.exceptions.DatabaseNotFoundException;
import org.openntf.red.nsf.exceptions.EndpointException;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchEndpoint implements Endpoint<CouchEndpoint, CouchEndpointFactory, CouchEndpointFactory> {

	// private String name;
	private EndpointConfig config;
	private CouchEndpointFactory parent;
	private HttpClient client;
	private static Logger log = Logger.getLogger(CouchEndpoint.class.getName());

	CouchEndpoint(EndpointConfig _config, CouchEndpointFactory _parent) {
		if (null == _config)
			throw new EndpointException("No endpoint configuration.");
		if (null == _parent)
			throw new EndpointException("No endpoint factory.");
		if (null == _config.name())
			throw new EndpointException("Endpoint does not have a name.");
		if (null == _config.type() || !_config.type().equals(ConfigProperties.REPOSITORY_TYPE_COUCH))
			throw new EndpointException("This is not a couch endpoint.");
		config = _config;
		parent = _parent;
		if (!config.options().containsKey(ConfigProperties.REPOSITORY_URL))
			throw new EndpointException("No endpoint URL.");
		if (!config.options().containsKey(ConfigProperties.REPOSITORY_BINDING_USER))
			throw new EndpointException("No endpoint binding user.");
		if (!config.options().containsKey(ConfigProperties.REPOSITORY_BINDING_PASSWORD))
			throw new EndpointException("No endpoint binding user password.");
		try {
			String url = config.options().get(ConfigProperties.REPOSITORY_URL);
			if (!(url.startsWith("http://") || url.startsWith("HTTP://")))
				url = "http://" + url;
			int port = 5984;
			if (config.options().containsKey(ConfigProperties.REPOSITORY_PORT)
					&& !"".equals(config.options().get(ConfigProperties.REPOSITORY_PORT)))
				port = Integer.parseInt(config.options().get(ConfigProperties.REPOSITORY_PORT));
			client = _parent.getBuilder().url(url).port(port)
					.username(config.options().get(ConfigProperties.REPOSITORY_BINDING_USER))
					.password(config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD))
					.useExpectContinue(true).relaxedSSLSettings(true).cleanupIdleConnections(true).build();
		} catch (MalformedURLException e) {
			throw new EndpointException("Failed to create a CouchDB endpoint: Failed to build HTTP connector.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#getDatabase(lotus.domino.Session,
	 * java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Database getDatabase(String dbpath, boolean createOnFail) throws EndpointException {
		log.finest("Couch Endpoint " + config.name() + ": Getting a database at path " + dbpath);
		if (null == dbpath || "".equals(dbpath))
			throw new EndpointException("Couch Endpoint " + config.name() + ": Database path is null or empty.");
		CouchDbOptions options = new CouchDbOptions(client).dbPath(dbpath).createOnFail(createOnFail);
		try {
			CouchDatabase db = new CouchDatabase(options, this);

			return db;
		} catch (DatabaseNotFoundException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#openDatabase(lotus.domino.Database)
	 */
	@Override
	public boolean openDatabase(Database db) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#createDatabase(lotus.domino.
	 * Session, java.lang.String, java.lang.String)
	 */
	@Override
	public Database createDatabase(String server, String dbpath) throws EndpointException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#createDatabase(lotus.domino.
	 * Session, org.openntf.red.nsf.endpoint.DbOptions)
	 */
	@Override
	public Database createDatabase(DbOptions options) throws EndpointException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#updateDatabase(lotus.domino.
	 * Database, org.openntf.red.nsf.endpoint.DbOptions)
	 */
	@Override
	public boolean updateDatabase(Database db, DbOptions options) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#removeDatabase(lotus.domino.
	 * Database)
	 */
	@Override
	public boolean removeDatabase(Database db) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#getNote(lotus.domino.Database,
	 * java.lang.String)
	 */
	@Override
	public Note getNote(Database db, String unid) throws EndpointException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#createNote(org.openntf.red.nsf.
	 * endpoint.Note)
	 */
	@Override
	public boolean createNote(Note note) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#updateNote(org.openntf.red.nsf.
	 * endpoint.Note)
	 */
	@Override
	public boolean updateNote(Note note) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#removeNote(org.openntf.red.nsf.
	 * endpoint.Note)
	 */
	@Override
	public boolean removeNote(Note note) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Endpoint#removeNote(java.lang.String)
	 */
	@Override
	public boolean removeNote(String unid) throws EndpointException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recycle() {
		// TODO Auto-generated method stub

	}

	@Override
	public CouchEndpointFactory getAncestorFactory() {
		return parent;
	}

	@Override
	public CouchEndpoint getAncestorEndpoint() {
		return this;
	}

	@Override
	public CouchEndpointFactory getParent() {
		return parent;
	}

}
