/**
 * 
 */
package org.openntf.red.network.rrpc.handlers;

import org.openntf.red.network.exceptions.REDServerException;
import org.openntf.red.network.rrpc.RequestHandler;
import org.openntf.red.network.rrpc.REDServer.Connection;
import org.openntf.red.network.rrpc.REDServer.Payloads;
import org.openntf.red.network.rrpc.REDServer.ServerStates;
import org.openntf.red.network.rrpc.messages.Base.Request;
import org.openntf.red.network.rrpc.messages.Base.Response;
import org.openntf.red.network.rrpc.messages.Notes.NoteCollection;
import org.openntf.red.network.rrpc.messages.Notes.RequestNoteCollection;

/**
 * Handles RRPC requests for Note Collections.
 * 
 * Not implemented yet.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NoteCollectionRequestHandler extends RequestHandler<RequestNoteCollection, NoteCollection> {

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public NoteCollectionRequestHandler() {
		super(RequestNoteCollection.class, NoteCollection.class, Payloads.PAYLOAD_NCOLLECTION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processRequest(Request request, Connection connection, Response.Builder builder)
			throws REDServerException {
		// TODO Auto-generated method stub
		throw new REDServerException("Not implemented.", ServerStates.NOT_IMPLEMENTED);
	}

}
