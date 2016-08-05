/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.DbOptions;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointException;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchEndpoint implements Endpoint {

	// private String name;
	private EndpointConfig config;
	private HttpClient client;
	private static Logger log = Logger.getLogger(CouchEndpoint.class.getName());

	protected CouchEndpoint(EndpointConfig _config) {
		if (null == _config)
			throw new EndpointException("No endpoint configuration.");
		if (null == _config.name())
			throw new EndpointException("Endpoint does not have a name.");
		if (null == _config.type() || !_config.name().equals(ConfigProperties.REPOSITORY_TYPE_COUCH))
			throw new EndpointException("This is not a couch endpoint.");
		config = _config;
		try {
			client = new StdHttpClient.Builder().url(config.options().get(ConfigProperties.REPOSITORY_URL))
					.build();
		} catch (MalformedURLException e) {
			e.printStackTrace();
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
	@Override
	public Database getDatabase(String dbpath, boolean createOnFail) throws EndpointException {
		// TODO Auto-generated method stub
		return null;
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

}
