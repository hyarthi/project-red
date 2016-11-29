/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.DbOptions;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.exceptions.EndpointException;
import org.openntf.red.nsf.impl.exceptions.DatabaseNotFoundException;
import org.openntf.red.security.authentication.http.BasicHttpAuthentication;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
//import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchEndpoint implements Endpoint<CouchEndpoint, CouchEndpointFactory, CouchEndpointFactory> {

	// private String name;
	private EndpointConfig config;
	private CouchEndpointFactory parent;
	// private HttpClient client;
	private Client client;
	private HttpAuthenticationFeature authfeature;
	// private BasicAuthSecurityHandler authhandler;
	private BasicHttpAuthentication auth;
	private WebTarget basetarget;
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
		// try {
		String url = config.options().get(ConfigProperties.REPOSITORY_URL);
		if (!(url.startsWith("http://") || url.startsWith("HTTP://")))
			url = "http://" + url;
		int port = 5984;
		if (config.options().containsKey(ConfigProperties.REPOSITORY_PORT)
				&& !"".equals(config.options().get(ConfigProperties.REPOSITORY_PORT)))
			port = Integer.parseInt(config.options().get(ConfigProperties.REPOSITORY_PORT));

		client = _parent.getBuilder().build();
		// authentication with CouchDB
		log.finest("Repository binding user: [" + config.options().get(ConfigProperties.REPOSITORY_BINDING_USER) + "]");
		log.finest("Repository binding password: [" + config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD) + "]");
		authfeature = HttpAuthenticationFeature.universal(
				config.options().get(ConfigProperties.REPOSITORY_BINDING_USER),
				config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD));
		/*auth = new BasicHttpAuthentication(config.options().get(ConfigProperties.REPOSITORY_BINDING_USER),
				config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD));*/
		client.register(authfeature);
		//client.register(auth);
		basetarget = client.target(url + ":" + port);
		/*
		 * client = _parent.getBuilder().url(url).port(port)
		 * .username(config.options().get(ConfigProperties.
		 * REPOSITORY_BINDING_USER))
		 * .password(config.options().get(ConfigProperties.
		 * REPOSITORY_BINDING_PASSWORD))
		 * .useExpectContinue(true).relaxedSSLSettings(true).
		 * cleanupIdleConnections(true).build();
		 */
		/*
		 * } catch (MalformedURLException e) { throw new
		 * EndpointException("Failed to create a CouchDB endpoint: Failed to build HTTP connector."
		 * , e); }
		 */
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
		if (null == dbpath || "".equals(dbpath))
			throw new EndpointException("Couch Endpoint " + config.name() + ": Database path is null or empty.");
		try {
			dbpath = URLEncoder.encode(dbpath, "UTF-8"); // make the db path
															// Couch-friendly
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// dbpath = dbpath.replaceAll("[/]", "%2F"); // make the db path
		// Couch-friendly (alt)
		log.finest("Couch Endpoint " + config.name() + ": Getting a database at path " + dbpath);
		CouchDbOptions options = new CouchDbOptions(basetarget).dbPath(dbpath).createOnFail(createOnFail);
		try {
			CouchDatabase db = new CouchDatabase(options, this);

			return db;
		} catch (DatabaseNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.Endpoint#openDatabase(lotus.domino.Database)
	 */
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
