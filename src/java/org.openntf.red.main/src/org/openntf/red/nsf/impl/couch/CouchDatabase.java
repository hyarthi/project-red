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
import org.openntf.red.nsf.impl.exceptions.DatabaseNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchDatabase implements Database<CouchEndpoint, CouchEndpointFactory, CouchEndpoint> {
	private CouchDbOptions options;
	private CouchEndpoint parent;
	private ObjectMapper mapper;
	//private final CouchDbInstance inst;
	//private final CouchDbConnector conn;
	private WebTarget target;
	private static Logger log = Logger.getLogger(CouchDatabase.class.getName());

	/**
	 * 
	 */
	CouchDatabase(CouchDbOptions _options, CouchEndpoint _parent) throws DatabaseNotFoundException, EndpointException {
		log.finest("Start init of CouchDB database.");
		options = _options;
		parent = _parent;
		//inst = new StdCouchDbInstance(options.getClient());
		//boolean exists = inst.checkIfDbExists(options.getDbpath());
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
		//conn = inst.createConnector(options.getDbpath(), options.isCreateOnFail());
		//log.finest("Response body: [" + response.readEntity(String.class) + "]");
		// setup database (e.g. if creating from template)
		if (!exists) {
			log.finest("Couch: Initializing database.");
			initDatabase();
		} else {
			log.finest("Couch: Reading entity.");
			try {
				//response.readEntity(JsonNode.class);
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
		//JsonNode rawnote = conn.find(JsonNode.class, unid);
		/*if (null == rawnote)
			return null;*/
		CouchNote note = new CouchNote(doctarget, (ObjectNode)rawnote, this);
		
		return note;
	}
	
	private void initDatabase() throws EndpointException {
		// TODO code here
		
	}
	
	WebTarget getTarget() {
		return this.target;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getView(String name) {
		if (null == name)
			throw new EndpointException("Can not work with a null view name.");
		//ViewQuery view = new ViewQuery();
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
		if(null == rawview)
			return null;
		CouchView view = new CouchView(notetarget, (ObjectNode)rawview, this);
		return view;
	}
	
	public static class DbPaths {
		public static final String DESIGN = "_design";
		public static final String VIEW_SEARCH = "_find";
		public static final String VIEW_INDEX = "_index";
		public static final String VIEW_REGULAR = "_view";
	}
	
	public static class Defaults {
		public static final String ID_TABLE_NAME = "SYS_ID_table";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getIDTableView() {
		return getView(Defaults.ID_TABLE_NAME);
	}
}
