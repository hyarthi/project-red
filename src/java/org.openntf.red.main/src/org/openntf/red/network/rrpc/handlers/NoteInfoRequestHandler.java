/**
 * 
 */
package org.openntf.red.network.rrpc.handlers;

import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.Document;
import org.openntf.red.Session;
import org.openntf.red.network.exceptions.REDServerException;
import org.openntf.red.network.rrpc.RequestHandler;
import org.openntf.red.network.rrpc.REDServer;
import org.openntf.red.network.rrpc.REDServer.Connection;
import org.openntf.red.network.rrpc.REDServer.Payloads;
import org.openntf.red.network.rrpc.REDServer.ServerStates;
import org.openntf.red.network.rrpc.messages.Base.Request;
import org.openntf.red.network.rrpc.messages.Base.Response;
import org.openntf.red.network.rrpc.messages.Notes.Action;
import org.openntf.red.network.rrpc.messages.Notes.NoteInfo;
import org.openntf.red.network.rrpc.messages.Notes.RequestNoteInfo;

/**
 * Handles RRPC requests for Note info (header info).
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NoteInfoRequestHandler extends RequestHandler<RequestNoteInfo, NoteInfo> {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(NoteInfoRequestHandler.class.getName());

	/** Reference to parent server. */
	REDServer server;

	/**
	 * Default constructor.
	 * 
	 * @param parentserver
	 *            Parent server.
	 * @since 0.4.0
	 */
	public NoteInfoRequestHandler(REDServer parentserver) {
		super(RequestNoteInfo.class, NoteInfo.class, Payloads.PAYLOAD_NOTEINFO);
		server = parentserver;
	}

	@Override
	public void processRequest(Request request, Connection connection, Response.Builder builder)
			throws REDServerException {
		log.finest("RED Server: Note Info request handler launched.");
		log.finest("RED Server: Received request: " + request);
		RequestNoteInfo noteinfo = request.getNoteInfo();
		String dbid = server.parseDatabaseId(noteinfo.getDbId());
		Session session = connection.getSession(dbid, Session.Type._REMOTE);
		Database db = session.getDatabase("", dbid, false);
		log.finest("RED Server: Database is " + db);
		if (null == db) {
			throw new REDServerException("Database not found.", ServerStates.NOT_FOUND);
		}
		Document doc = null;
		// TODO also need Note for design notes
		NoteInfo.Builder nbuilder = NoteInfo.newBuilder();
		if (!noteinfo.getUnid().isEmpty()) { // UNID takes precedence
			log.finest("Doing Note UNID...");
			doc = db.getDocumentByUNID(noteinfo.getUnid());
			nbuilder.setUnid(noteinfo.getUnid());
		} else if (noteinfo.getNoteId() != 0) { // else -> check if Note ID is
												// present
			log.finest("Doing NoteID...");
			doc = db.getDocumentByID((int) noteinfo.getNoteId());
			nbuilder.setNoteId(noteinfo.getNoteId());
		}

		if (null == doc) // TODO also need Note for design notes
			throw new REDServerException("Document not found.", ServerStates.NOT_FOUND);

		switch (noteinfo.getActionValue()) {
		case (Action.READ_VALUE):
			// TODO
			throw new REDServerException("Not implemented.", ServerStates.NOT_IMPLEMENTED);
		case (Action.UPDATE_VALUE):
			boolean result = updateNoteInfo(doc, noteinfo);

			if (!result) {
				// TODO
				log.finest("RED Server: Failed to update note info.");
				throw new REDServerException("Failed to update note info.", ServerStates.INTERNAL_SERVER_ERROR);
			}
			log.finest("RED Server: Note Info updated.");
			break;
		case (Action.REMOVE_VALUE):
			throw new REDServerException("Not implemented.", ServerStates.NOT_IMPLEMENTED);
		default:
			throw new REDServerException("Not implemented.", ServerStates.NOT_IMPLEMENTED);
		}

		NoteInfo rnoteinfo = nbuilder.build();
		builder.setNoteInfo(rnoteinfo);
		builder.setStatus(ServerStates.OK);

		log.finest("Response Note Info is: " + rnoteinfo + ".");
	}

	/**
	 * Updates the info sections of a note (header).
	 * 
	 * @param doc
	 *            Document to update.
	 * @param request
	 *            Request payload reference.
	 * @return Whether the update was successful.
	 * @since 0.4.0
	 */
	private boolean updateNoteInfo(Document doc, RequestNoteInfo request) {
		log.finest("RED Server: Updating note info.");

		// if it has UNID & NoteID - NoteID can be updated
		if ((!request.getUnid().isEmpty()) && (request.getNoteId() != 0)) {
			log.finest("Updating NoteID: " + doc.getNoteID() + " -> " + request.getNoteId());
			doc.setNoteID(request.getNoteId());
		}

		// TODO

		log.finest("RED Server: Saving document.");
		return doc.save(true, false, false);
	}

}
