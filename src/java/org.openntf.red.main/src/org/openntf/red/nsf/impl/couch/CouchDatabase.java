/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.ektorp.CouchDbConnector;
//import org.ektorp.CouchDbInstance;
//import org.ektorp.ViewQuery;
//import org.ektorp.impl.StdCouchDbInstance;
import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.exceptions.EndpointException;
import org.openntf.red.nsf.impl.couch.CouchField.SysNames;
import org.openntf.red.nsf.impl.exceptions.DatabaseNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Database implementation for CouchDB access.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see Database
 */
public class CouchDatabase implements Database<CouchEndpoint, CouchEndpointFactory, CouchEndpoint> {
	/** Couch-specific database options. */
	private CouchDbOptions options;
	/** Parent endpoint. */
	private CouchEndpoint parent;
	/** Object mapper used for JSON manipulation. */
	private ObjectMapper mapper;
	// private final CouchDbInstance inst;
	// private final CouchDbConnector conn;
	/** Web target of the database (Java RS). */
	private WebTarget target;
	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchDatabase.class.getName());

	/**
	 * Default constructor.
	 * 
	 * @param _options
	 *            CouchDB options.
	 * @param _parent
	 *            Parent endpoint.
	 * @throws DatabaseNotFoundException
	 *             If the database was not found and/or could not be created.
	 * @throws EndpointException
	 *             If endpoint-specific errors occur.
	 * @since 0.4.0
	 */
	CouchDatabase(CouchDbOptions _options, CouchEndpoint _parent) throws DatabaseNotFoundException, EndpointException {
		log.finest("Start init of CouchDB database.");
		options = _options;
		parent = _parent;
		// inst = new StdCouchDbInstance(options.getClient());
		// boolean exists = inst.checkIfDbExists(options.getDbpath());
		log.finest("Getting target.");
		target = options.getBaseTarget().path(options.getDbpath());
		log.finest("Getting builder.");
		Invocation.Builder reqbuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		log.finest("Getting response.");
		Response response = null;
		log.finest("Response is " + response);
		try {
			response = reqbuilder.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.finest("Response is " + response);
		log.finest("Getting status.");
		boolean exists = response.getStatus() == Response.Status.OK.getStatusCode();
		log.finest("Response from CouchDB: " + response.getStatus());
		log.finest("Database exists: " + exists);
		if (!exists && !options.isCreateOnFail())
			throw new DatabaseNotFoundException("No database found.");
		// conn = inst.createConnector(options.getDbpath(),
		// options.isCreateOnFail());
		// log.finest("Response body: [" + response.readEntity(String.class) +
		// "]");
		// setup database (e.g. if creating from template)
		if (!exists) {
			log.finest("Couch: Initializing database.");
			initDatabase();
		} else {
			log.finest("Couch: Reading entity.");
			try {
				// response.readEntity(JsonNode.class);
				mapper = new ObjectMapper();
				mapper.readTree(response.readEntity(String.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO equip this with instruments to look into database params
		}
		log.finest("Couch: Finished getting database.");
	}

	@Override
	public CouchEndpointFactory getAncestorFactory() {
		return parent.getAncestorFactory();
	}

	@Override
	public CouchEndpoint getAncestorEndpoint() {
		return parent;
	}

	@Override
	public CouchEndpoint getParent() {
		return parent;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Note getNoteByUNID(String unid) {
		log.finest("Couch: Getting document by unid " + unid);
		if (null == unid)
			throw new EndpointException("Can not work with a null note UNID.");
		WebTarget doctarget = target.path(unid);
		log.finest("Will be querying: " + doctarget.toString());
		Response response = doctarget.request(MediaType.APPLICATION_JSON_TYPE).get();
		log.finest("Response from CouchDB: " + response.getStatus());
		if (response.getStatus() != Response.Status.OK.getStatusCode())
			return null;
		JsonNode rawnote = null;
		try {
			rawnote = mapper.readTree(response.readEntity(String.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == rawnote)
			return null;
		// JsonNode rawnote = conn.find(JsonNode.class, unid);
		/*
		 * if (null == rawnote) return null;
		 */
		CouchNote note = new CouchNote(doctarget, (ObjectNode) rawnote, this);

		return note;
	}

	/**
	 * (Under construction)
	 * 
	 * @throws EndpointException
	 */
	private void initDatabase() throws EndpointException {
		// TODO code here

	}

	/**
	 * Returns the web target of the current database (Java RS).
	 * 
	 * @return Database web target.
	 * @since 0.4.0
	 */
	WebTarget getTarget() {
		return this.target;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getView(String name) {
		if (null == name)
			throw new EndpointException("Can not work with a null view name.");
		// ViewQuery view = new ViewQuery();
		// try to find using programmatic name
		WebTarget notetarget = target.path(DbPaths.DESIGN).path(name);
		Response response = notetarget.request(MediaType.APPLICATION_JSON_TYPE).get();
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			return null;
			// TODO add a search mechanism for human-readable name lookup
		}
		JsonNode rawview = null;
		try {
			rawview = mapper.readTree(response.readEntity(String.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == rawview)
			return null;
		CouchView view = new CouchView(notetarget, (ObjectNode) rawview, this);
		return view;
	}

	/**
	 * CouchDB-specific paths within the database.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class DbPaths {
		/** Design doc prefix/section. */
		public static final String DESIGN = "_design";
		/** Mango lookup section. */
		public static final String VIEW_SEARCH = "_find";
		/** Mango utility section. */
		public static final String VIEW_INDEX = "_index";
		/** View prefix. */
		public static final String VIEW_REGULAR = "_view";
	}

	/**
	 * System names list for CouchDB (all reserved).
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Defaults {
		/** Equivalent of an ID Table in Notes. */
		public static final String ID_TABLE_NAME = "SYS_ID_table";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getIDTableView() {
		return getView(Defaults.ID_TABLE_NAME);
	}

	/**
	 * Returns the object mapper object.
	 * 
	 * @return Object mapper object.
	 * @since 0.4.0
	 */
	protected ObjectMapper getMapper() {
		return mapper;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Note createNote() {
		return createNote(false);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Note createNote(boolean isDesign) {
		if (isDesign) {
			// TODO spawn design note
			return null; // TEMP
		} else {
			String unid = parent.generateUniversalID();
			ObjectNode rawdoc = mapper.createObjectNode();
			WebTarget doctarget = target.path(unid);
			// TODO maybe also NoteID?
			rawdoc.put(SysNames.FIELD_UNID, unid);

			return new CouchNote(doctarget, rawdoc, this);
		}
	}
}
