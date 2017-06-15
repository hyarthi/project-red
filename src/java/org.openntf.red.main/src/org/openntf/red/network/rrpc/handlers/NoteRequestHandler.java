/**
 * 
 */
package org.openntf.red.network.rrpc.handlers;

import java.util.List;
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
import org.openntf.red.network.rrpc.messages.Notes.Item;
import org.openntf.red.network.rrpc.messages.Notes.Note;
import org.openntf.red.network.rrpc.messages.Notes.RequestNote;
import org.openntf.red.nsf.endpoint.Field.Type;

//import javolution.util.FastMap;
import javolution.util.FastTable;

/**
 * Handles RRPC requests for Note operations.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NoteRequestHandler extends RequestHandler<RequestNote, Note> {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(NoteRequestHandler.class.getName());
	/** Parent server reference. */
	private REDServer server;
	// private Connection connection;

	/**
	 * Default constructor.
	 * 
	 * @param parentServer
	 *            Parent server.
	 * @since 0.4.0
	 */
	public NoteRequestHandler(REDServer parentServer) {
		super(RequestNote.class, Note.class, Payloads.PAYLOAD_NOTE);
		server = parentServer;
		// connection = parentConnection;
	}

	@Override
	public void processRequest(Request request, Connection connection, Response.Builder builder)
			throws REDServerException {
		log.finest("RED Server: Note request handler launched.");
		log.finest("RED Server: Received request: " + request);
		RequestNote note = request.getNote();
		String dbid = server.parseDatabaseId(note.getDbId());
		Session session = connection.getSession(dbid, Session.Type._REMOTE);
		Database db = session.getDatabase("", dbid, false);
		log.finest("RED Server: Database is " + db);
		if (null == db) {
			throw new REDServerException("Database not found.", ServerStates.NOT_FOUND);
		}
		Document doc = null;
		// TODO also need Note for design notes
		Note.Builder nbuilder = Note.newBuilder();
		if (!note.getUnid().isEmpty()) { // UNID takes precedence
			log.finest("Doing Note UNID...");
			doc = db.getDocumentByUNID(note.getUnid());
			nbuilder.setUnid(note.getUnid());
		} else if (note.getNoteId() != 0) { // else -> check if Note ID is
											// present
			log.finest("Doing NoteID...");
			doc = db.getDocumentByID((int) note.getNoteId());
			nbuilder.setNoteId(note.getNoteId());
		} else { // else -> it's a new or malformed document query
			log.finest("Doing undefined...");
			if (Action.UPDATE_VALUE == note.getActionValue()) {
				log.finest("Creating new document...");
				// it's a new document/note save request -> spawn document/note
				// stub
				doc = db.createDocument();
				nbuilder.setUnid(doc.getUniversalID());
			} else
				throw new REDServerException(
						"Can not work with NULL UNID/NoteID on action " + note.getAction().toString() + ".",
						ServerStates.BAD_REQUEST);
		}

		if (null == doc) // TODO also need Note for design notes
			throw new REDServerException("Document not found.", ServerStates.NOT_FOUND);

		switch (note.getActionValue()) {
		case (Action.READ_VALUE):
			List<org.openntf.red.Item> items = doc.getItemsEx();
			Item.Builder ibuilder;
			for (org.openntf.red.Item item : items) {
				// TODO check on flags (stub) + deprecated
				ibuilder = Item.newBuilder().setName(item.getName()).setType(item.getType()).setFlags(0x0000);
				List<Object> vals = item.getValuesEx();
				for (Object val : vals) {
					// FIXME temporary stub
					ibuilder.addTvalue(server.parseValueToString(val));
				}
				nbuilder.addItems(ibuilder.build());
			}
			break;
		case (Action.UPDATE_VALUE):
			log.finest("Will be updating.");
			if (null != doc) { // TODO also need Note for design notes
				boolean result = updateDocument(doc, note);
				if (!result) {
					// TODO
					log.finest("RED Server: Failed to update document.");
					throw new REDServerException("Failed to update document.", ServerStates.INTERNAL_SERVER_ERROR);
				}
				log.finest("RED Server: Document updated.");
			}
			// TODO
			break;
		case (Action.REMOVE_VALUE):
			log.finest("Will be deleting.");
			if (null != doc) { // TODO also need Note for design notes
				boolean result = removeDocument(doc, note);
				if (!result) {
					// TODO
					log.finest("RED Server: Failed to delete document.");
					throw new REDServerException("Failed to delete document.", ServerStates.INTERNAL_SERVER_ERROR);
				}
				log.finest("RED Server: Document deleted.");
			}
			// TODO
			break;
		default:
			// TODO
			throw new REDServerException("Not implemented.", ServerStates.BAD_REQUEST);
		}

		Note rnote = nbuilder.build();
		builder.setNote(rnote);
		builder.setStatus(ServerStates.OK);

		log.finest("Response Note is: " + rnote + ".");
	}

	/**
	 * Updates the document.
	 * 
	 * @param doc
	 *            Document to update.
	 * @param request
	 *            Request payload reference.
	 * @return Whether the update was successful.
	 * @since 0.4.0
	 */
	private boolean updateDocument(Document doc, RequestNote request) {
		log.finest("RED Server: Updating document.");

		// FIXME TEMP - ignore attachments for now
		List<Item> items = request.getItemsList();
		List<String> itemsexist = new FastTable<String>();
		org.openntf.red.Item docitem;
		log.finest("RED Server: Processing items.");
		for (Item item : items) {
			log.finest("RED Server: Item - name: " + item.getName() + ", type - " + item.getType());
			itemsexist.add(item.getName());

			switch (item.getType()) {
			case Type.NUMBERS:
				docitem = doc.replaceItemValueCustomData(item.getName(), item.getType(), item.getFlags(),
						item.getNvalueList());
				if (null == docitem)
					return false;
				break;
			case Type.TEXT:
			default:
				docitem = doc.replaceItemValueCustomData(item.getName(), item.getType(), item.getFlags(),
						item.getTvalueList());
				if (null == docitem)
					return false;
				break;
			}
		}
		log.finest("RED Server: Cleaning up removed items.");
		// clean up removed items
		for (String iname : doc.keySet()) {
			if (!itemsexist.contains(iname)) {
				log.finest("RED Server: Removing item [" + iname + "]");
				doc.removeItem(iname);
			}
		}

		log.finest("RED Server: Saving document.");
		return doc.save(true, false, false);
	}

	/**
	 * Updates the note (design).<br>
	 * Not implemented yet.
	 * 
	 * @return
	 */
	private boolean updateNote() {
		return false;
	}

	/**
	 * Deletes a document.
	 * 
	 * @param doc
	 *            Document to delete.
	 * @param request
	 *            Request payload reference.
	 * @return Whether the delete was successful.
	 * @since 0.4.0
	 */
	private boolean removeDocument(Document doc, RequestNote request) {
		// TODO TEMP
		return doc.removePermanently(true);
	}

}
