/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.util.logging.Logger;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.impl.StdCouchDbInstance;
import org.openntf.red.nsf.endpoint.Database;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.exceptions.DatabaseNotFoundException;
import org.openntf.red.nsf.exceptions.EndpointException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchDatabase implements Database<CouchEndpoint, CouchEndpointFactory, CouchEndpoint> {
	private final CouchDbOptions options;
	private final CouchEndpoint parent;
	private final CouchDbInstance inst;
	private final CouchDbConnector conn;
	private static Logger log = Logger.getLogger(CouchDatabase.class.getName());

	/**
	 * 
	 */
	CouchDatabase(CouchDbOptions _options, CouchEndpoint _parent) throws DatabaseNotFoundException, EndpointException {
		options = _options;
		parent = _parent;
		inst = new StdCouchDbInstance(options.getClient());
		boolean exists = inst.checkIfDbExists(options.getDbpath());
		if (!exists && !options.isCreateOnFail())
			throw new DatabaseNotFoundException("No database found.");
		conn = inst.createConnector(options.getDbpath(), options.isCreateOnFail());
		// setup database (e.g. if creating from template)
		if (!exists)
			initDatabase();
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
		if (null == unid)
			throw new EndpointException("Can not work with a null note UNID.");
		JsonNode rawnote = conn.find(JsonNode.class, unid);
		if (null == rawnote)
			return null;
		CouchNote note = new CouchNote((ObjectNode)rawnote, this);
		
		return note;
	}
	
	private void initDatabase() throws EndpointException {
		// TODO code here
	}

}
