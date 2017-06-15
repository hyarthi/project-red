/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openntf.red.nsf.DataBrokerException;
import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.DbOptions;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.exceptions.EndpointException;
import org.openntf.red.nsf.impl.couch.CouchEndpointFactory.DefaultResponseFields;
import org.openntf.red.nsf.impl.exceptions.DatabaseNotFoundException;
import org.openntf.red.security.authentication.http.BasicHttpAuthentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;

/**
 * Endpoint implementation for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see Endpoint
 */
public class CouchEndpoint implements Endpoint<CouchEndpoint, CouchEndpointFactory, CouchEndpointFactory> {

	// private String name;
	/** Endpoint config. */
	private EndpointConfig config;
	/** Parent endpoint factory. */
	private CouchEndpointFactory parent;
	// private HttpClient client;
	/** HTTP client (Jersey) used for data access & manipulation. */
	private Client client;
	/** HTTP authentication mechanism used in the client. */
	private HttpAuthenticationFeature authfeature;
	// private BasicAuthSecurityHandler authhandler;
	/** Basic HTTP authentication. */
	private BasicHttpAuthentication auth;
	/** CouchDB web target. */
	private WebTarget basetarget;
	/** CouchDB unique id generator web target. */
	private WebTarget unidgenerator;
	/** Object mapper instance (used for JSON manipulation). */
	private ObjectMapper mapper;
	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchEndpoint.class.getName());

	/**
	 * Default constructor.
	 * 
	 * @param _config
	 *            Endpoint config.
	 * @param _parent
	 *            Parent endpoint factory.
	 * @since 0.4.0
	 */
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
		log.finest("Repository binding password: [" + config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD)
				+ "]");
		authfeature = HttpAuthenticationFeature.universal(
				config.options().get(ConfigProperties.REPOSITORY_BINDING_USER),
				config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD));
		/*
		 * auth = new
		 * BasicHttpAuthentication(config.options().get(ConfigProperties.
		 * REPOSITORY_BINDING_USER),
		 * config.options().get(ConfigProperties.REPOSITORY_BINDING_PASSWORD));
		 */
		client.register(authfeature);
		// client.register(auth);
		basetarget = client.target(url + ":" + port);
		unidgenerator = basetarget.path(Defaults.UNID_GENERATOR);
		mapper = new ObjectMapper();
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

	@Override
	public String generateUniversalID() {
		Response response = unidgenerator.request(MediaType.APPLICATION_JSON_TYPE).get();
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			// something's wrong
			throw new DataBrokerException("Couch Endpoint: Failed to generate UNID.");
		}
		ObjectNode respTree = null;
		try {
			respTree = (ObjectNode) mapper.readTree(response.readEntity(String.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == respTree || !respTree.has(DefaultResponseFields.UUIDS)
				|| !respTree.get(DefaultResponseFields.UUIDS).isArray())
			throw new DataBrokerException("Couch Endpoint: Failed to generate UNID.");
		ArrayNode arr = (ArrayNode) respTree.get(DefaultResponseFields.UUIDS);
		if (arr.size() == 0 || !arr.get(0).isTextual())
			throw new DataBrokerException("Couch Endpoint: Failed to generate UNID.");

		return arr.get(0).asText().toUpperCase();
	}

	/**
	 * Default paths/names within the CouchDB endpoint.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Defaults {
		/** Unique id generator suffix. */
		public static final String UNID_GENERATOR = "_uuids";
	}
}
