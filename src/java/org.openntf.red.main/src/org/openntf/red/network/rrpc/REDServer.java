/**
 * 
 */
package org.openntf.red.network.rrpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;

import org.openntf.red.Session;
import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;
import org.openntf.red.core.modules.ModuleManager;
import org.openntf.red.core.thread.IServerTask;
import org.openntf.red.core.thread.ThreadManager;
import org.openntf.red.network.INetworkManager.Defaults;
import org.openntf.red.network.exceptions.REDServerException;
import org.openntf.red.network.rrpc.handlers.NoteCollectionRequestHandler;
import org.openntf.red.network.rrpc.handlers.NoteInfoRequestHandler;
import org.openntf.red.network.rrpc.handlers.NoteRequestHandler;
import org.openntf.red.network.rrpc.handlers.NullRequestHandler;
import org.openntf.red.network.rrpc.messages.Base.Request;
import org.openntf.red.network.rrpc.messages.Base.Response;
import org.openntf.red.security.session.impl.SessionOptions;
import org.openntf.red.network.rrpc.messages.Base.Request.PayloadCase;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;

import javolution.util.FastMap;
import javolution.util.FastTable;

/**
 * Server task that services the RRPC protocol.
 * 
 * @author Vladimir Kornienko
 * @see IServerTask
 * @since 0.4.0
 */
public class REDServer implements IServerTask {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(REDServer.class.getName());
	/**
	 * Instance of this RED Server (only one such object should exist in a
	 * runtime).
	 */
	private static REDServer _instance = null;
	/** Server socket that the task is listening to. */
	private ServerSocket socket;
	/** Task status. */
	private Status _status;
	/** Port number the task is listening to. */
	private int port;
	/**
	 * Timeout between arrival of packages when getting a request from the
	 * client.
	 */
	private int requestTimeout;
	/**
	 * Session timeout. When a session expires, all resources associated with it
	 * are recycled.
	 */
	private int sessionTimeout;
	/**
	 * A list of connections from clients that are currently being processed.
	 */
	private FastTable<Connection> connections = null;
	/** A map of default request handlers for RRPC protocol. */
	private FastMap<Integer, RequestHandler<?, ?>> defaultHandlers;
	// TODO implement custom request handlers.

	/**
	 * Returns the task instance. the only method that should be used to get the
	 * instance.
	 * 
	 * @return RED Server instance.
	 * @since 0.4.0
	 */
	public static REDServer getInstance() {
		synchronized (REDServer.class) {
			if (null == _instance)
				_instance = new REDServer();
		}
		return _instance;
	}

	/**
	 * Default constructor.
	 */
	private REDServer() {
		// TODO Auto-generated constructor stub
		// _status = Status.STOPPED;
		setStatus(Status.STOPPED);
	}

	@Override
	public void run() {
		log.info("RED Server: Starting...");
		if (_status == Status.ERROR)
			throw new REDServerException("RED Server is in error state.");
		if (_status != Status.STOPPED)
			throw new REDServerException("RED Server is already running.");
		setStatus(Status.STARTING);
		log.finest("RED Server: Initializing default request handlers.");
		initDefaultHandlers();
		log.finest("RED Server: Default request handlers initialized.");
		// FIXME change this to dynamic settings
		requestTimeout = 10000;
		sessionTimeout = 1800000;
		// discover port
		Integer oport = ConfigManager
				.getPropertyAsInteger(ConfigProperties.SECTION_NOTES + "." + ConfigProperties.RED_SERVER_PORT);
		if (null == oport)
			port = Defaults.DEFAULT_PORT_RRPC;
		else
			port = oport.intValue();
		log.finest("RED Server: Binding to port " + port + "...");
		// claim port
		socket = ModuleManager.getNetworkManager().claimPort(_instance, port);
		if (null == socket) {
			reset();
			throw new REDServerException("Failed to bind to port (" + port + ").");
		}
		log.finest("RED Server: Enabling SO_REUSEADDR option on port.");
		try {
			if (!socket.getReuseAddress())
				socket.setReuseAddress(true);
		} catch (SocketException e) {
			log.severe(
					"RED Server: Failed to enable SO_REUSEADDR on port. This may raise exceptions on server restart.");
			log.throwing(REDServer.class.getName(), "run()", e);
		}

		// prepare Connection table
		connections = new FastTable<Connection>().atomic();

		// run task
		setStatus(Status.RUNNING);
		log.info("RED Server: Listening on port " + port + ".");
		while (Status.RUNNING == _status) {
			try {
				Socket csocket = socket.accept();
				Connection connection = new Connection(csocket, sessionTimeout, requestTimeout);
				connections.add(connection);
				log.finest("RED Server: Connection established.");
				// transactions.add(transaction);
				ThreadManager.runThread(connection);
			} catch (SocketException se) {
				// do nothing, we're terminating
			} catch (Exception e) {
				e.printStackTrace();
				log.severe("Error in processing request.");
				// TODO maybe some other logging here?
			}
		}
		log.info("RED Server: Terminating...");
		if (null != socket) {
			if (!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			socket = null;
		}
		setStatus(Status.STOPPED);
		log.info("RED Server: Stopped.");
	}

	@Override
	public Status status() {
		return _status;
	}

	/**
	 * Changes the state of the task.
	 * 
	 * @param s
	 *            New task state.
	 * @see Status
	 * @since 0.4.0
	 */
	protected synchronized void setStatus(Status s) {
		_status = s;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		log.info("RED Server: Resetting...");
		if (null != socket) {
			if (!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
				}
			ModuleManager.getNetworkManager().releasePort(port);
			socket = null;
		}
		port = 0;
		setStatus(Status.STOPPED);
		// TODO restart task
		log.info("RED Server: Reset complete.");
	}

	@Override
	public void terminate() {
		log.fine("RED Server: Received termination command...");
		for (Connection connection : connections)
			connection.terminate();
		setStatus(Status.STOPPING);
		if (!socket.isClosed())
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		socket = null;
		// setStatus(Status.STOPPED);
	}

	/**
	 * Parses the database id, so that it's consistent with the internal format.
	 * 
	 * @param dbid
	 *            Database id.
	 * @return Parsed database id.
	 * @since 0.4.0
	 */
	public String parseDatabaseId(String dbid) {
		// FIXME temporary stub - replace with proper parsing once encoding db
		// names is decided upon
		return dbid.replaceAll("^[\\\\/]", "") // remove the starting \ or /
												// character
				.replaceAll("[\\\\]", "/") // replace all \ with / (e.g.
											// folder\db.nsf -> folder/db.nsf) -
											// for Windows-based Dominos (just
											// in case - this should actually be
											// handled by the hooks)
				.replaceAll("[\\.]", "_"); // replace all . with _ (e.g. db.nsf
											// -> db_nsf)
		// .replaceAll("[/]", "%2F"); // replace all / with %2F combination to
		// make the db address Couch-friendly (e.g. folder/db.nsf ->
		// folder%2Fdb.nsf)
	}

	/**
	 * STUB
	 * 
	 * @param value
	 * @return
	 */
	public String parseValueToString(Object value) {
		// FIXME temporary stub
		return value.toString();
	}

	/**
	 * STUB
	 * 
	 * @param value
	 * @return
	 */
	public int parseValueToNumber(Object value) {
		return 0;
	}

	/**
	 * Initializes default RRPC request handlers.
	 * 
	 * @since 0.4.0
	 */
	private void initDefaultHandlers() {
		defaultHandlers = new FastMap<Integer, RequestHandler<?, ?>>().atomic();
		// null
		defaultHandlers.put(Integer.valueOf(Payloads.PAYLOAD_NOT_SET), new NullRequestHandler());
		// RequestNote
		defaultHandlers.put(Integer.valueOf(Payloads.PAYLOAD_NOTE), new NoteRequestHandler(this));
		// RequestNoteInfo
		defaultHandlers.put(Integer.valueOf(Payloads.PAYLOAD_NOTEINFO), new NoteInfoRequestHandler(this));
		// RequestNoteCollection
		defaultHandlers.put(Integer.valueOf(Payloads.PAYLOAD_NCOLLECTION), new NoteCollectionRequestHandler());
		// TODO continue for other types
	}

	/**
	 * Gets a default request handler associated with a specific request type.
	 * 
	 * @param type
	 *            Request type.
	 * @return Request handler.
	 * @since 0.4.0
	 */
	public RequestHandler<?, ?> getRequestHandler(int type) {
		// TODO do custom handlers
		if (defaultHandlers.containsKey(Integer.valueOf(type)))
			return defaultHandlers.get(Integer.valueOf(type));
		return null;
	}

	/**
	 * Class representing a single interaction with the client over RRPC.
	 * 
	 * @author Vladimir Kornienko
	 * @see Runnable
	 * @since 0.4.0
	 */
	public class Connection implements Runnable {
		/** Socket to communicate with the client. */
		private Socket socket;
		/**
		 * Timeout between arrival of packages when getting a request from the
		 * client.
		 */
		private int requestTimeout;
		/**
		 * Session timeout. When a session expires, all resources associated
		 * with it are recycled.
		 */
		private int sessionTimeout;
		/** List of sessions used by the current connection. */
		private FastMap<String, FastMap<Session.Type, Session>> dbsessions;
		/** (Currently unused) Authenticated user name. Needed for security. */
		private String authUserName;
		/** Keep the connection open until the session expires. */
		private boolean keepOpen;

		/**
		 * Default constructor.
		 * 
		 * @param _socket
		 *            Socket to communicate with the client.
		 * @param stimeout
		 *            Session timeout.
		 * @param rtimeout
		 *            Request timeout.
		 * @since 0.4.0
		 */
		Connection(Socket _socket, int stimeout, int rtimeout) {
			socket = _socket;
			requestTimeout = rtimeout;
			sessionTimeout = stimeout;
			dbsessions = new FastMap<String, FastMap<Session.Type, Session>>();
			authUserName = null;
			keepOpen = false;
		}

		@Override
		public void run() {
			// TODO Session authentication
			authUserName = "cn=lotus01/o=trade";
			log.info("RED Server: Received RRPC connection from " + socket.getRemoteSocketAddress().toString() + ".");
			try {
				socket.setSoTimeout(sessionTimeout);
				// InputStream in = socket.getInputStream();
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				CodedInputStream cin;
				byte[] bmsgsize = new byte[4];
				keepOpen = true;
				int bytesread = -1, msgsize = -1;
				while (keepOpen) {
					try {
						bytesread = in.read(bmsgsize);
						if (4 != bytesread) {
							if (-1 == bytesread) {
								// nothing left to process, close down
								keepOpen = false;
								break;
							}
							log.severe("RED Connection: Failed to read message header.");
							throw new IOException("RED Connection: Failed to read message header.");
						}
						log.finest("RED Connection: Received packet: " + bytesread + " bytes of header read.");
						log.finest("RED Connection: Msg header: " + String.format("0x%02X%02X%02X%02X", bmsgsize[0],
								bmsgsize[1], bmsgsize[2], bmsgsize[3]));
						cin = CodedInputStream.newInstance(bmsgsize);
						msgsize = cin.readRawLittleEndian32();
						log.finest("RED Connection: Packet size is " + msgsize + ".");
					} catch (SocketTimeoutException ste) {
						// connection timed out
						log.finest("RED Connection: Timed out.");
						keepOpen = false;
						break;
					} catch (SocketException se) {
						// socket was closed
						log.finest("RED Connection: Socket was closed. Wrapping up.");
						keepOpen = false;
						break;
					} catch (Exception e) {
						// TODO issue RESEND response
						e.printStackTrace();
						// flush inputstream
						in.skip(in.available());
						continue;
					}
					if (bytesread != -1 && msgsize != -1) {
						byte[] msgbody = new byte[msgsize];
						socket.setSoTimeout(requestTimeout);
						try {
							bytesread = in.read(msgbody);
							if (-1 == bytesread || msgsize != bytesread) {
								log.finest("RED Connection: Failed to read message body: expected - " + msgsize
										+ " bytes, read - " + bytesread + " bytes.");
								throw new REDServerException("RED Connection: Failed to read message body: expected - "
										+ msgsize + " bytes, read - " + bytesread + " bytes.");
							}
						} catch (REDServerException rse) {
							// TODO issue RESEND response
							// flush inputstream
							in.skip(in.available());
							continue;
						} catch (SocketTimeoutException ste) {
							// connection timed out
							log.finest("RED Connection: Timed out.");
							keepOpen = false;
							break;
						} catch (SocketException se) {
							// socket was closed
							log.finest("RED Connection: Socket was closed. Wrapping up.");
							keepOpen = false;
							break;
						} catch (Exception e) {
							// TODO issue RESEND response
							e.printStackTrace();
							// flush inputstream
							in.skip(in.available());
							continue;
						}
						log.finest("RED Connection: Parsing request.");
						CodedInputStream bcin = CodedInputStream.newInstance(msgbody);
						Request request = Request.parseFrom(bcin);
						log.finest("RED Connection: Processing request.");
						Response response = processRequest(request);
						log.finest("RED Connection: Response state: " + response.getStatus());
						log.finest("RED Connection: Writing response.");
						CodedOutputStream cout = CodedOutputStream.newInstance(out);
						int respsize = response.getSerializedSize();
						try {
							cout.writeFixed32NoTag(respsize);
							response.writeTo(cout);
							cout.flush();
						} catch (SocketException se) {
							// socket was closed
							log.finest("RED Connection: Socket was closed. Wrapping up.");
							keepOpen = false;
							break;
						} catch (Exception e) {
							// TODO issue RESEND response
							e.printStackTrace();
							// flush inputstream
							in.skip(in.available());
							// socket.setSoTimeout(sessionTimeout);
							continue;
						}
						if (in.available() > 0)
							continue;
						keepOpen = false;
						// socket.setSoTimeout(sessionTimeout);
					}
				}
			} catch (IOException e) {
				log.throwing(Connection.class.getName(), "run()", e);
				e.printStackTrace();
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// TODO TEMPORARY
				log.finest("RED Connection: Closing sessions...");
				for (FastMap<Session.Type, Session> sessions : dbsessions.values()) {
					for (Session sess : sessions.values()) {
						// TODO also temporary
						ModuleManager.getSecurityManager().getSessionManager().deregisterSession(sess);
						sess.recycle();
					}
				}
				log.finest("RED Connection: Closing socket.");
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * Terminates the connection, closes socket and releases all resources.
		 * 
		 * @since 0.4.0
		 */
		public synchronized void terminate() {
			keepOpen = false;
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * Processes the RRPC request.
		 * 
		 * @param request
		 *            RRPC request object.
		 * @return RRPC response object.
		 * @since 0.4.0
		 */
		private Response processRequest(Request request) {
			PayloadCase msgcontenttype = request.getPayloadCase();
			Response.Builder respbuilder = Response.newBuilder();
			// TODO expand this section
			int msgtype = msgcontenttype.getNumber();
			RequestHandler<?, ?> handler = getRequestHandler(msgtype);
			if (null == handler) {
				log.severe("RED Server: Could not find handler for request of type " + msgtype + ".");
				respbuilder.setStatus(ServerStates.INTERNAL_SERVER_ERROR);
				return respbuilder.build();
			}
			try {
				handler.processRequest(request, this, respbuilder);
				// respbuilder.setStatus(ServerStates.OK);
			} catch (REDServerException rse) {
				respbuilder.setStatus(rse.getStatus());
				log.severe("CUCKOOO!");
				rse.printStackTrace();
			} catch (Exception e) {
				respbuilder.setStatus(ServerStates.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}

			Response resp = respbuilder.build();
			log.finest("Returning: " + resp + ", status: " + resp.getStatus() + ".");

			return resp;
		}

		/**
		 * Gets (or instantiates) a session to work with data.
		 * 
		 * @param dbid
		 *            Database id.
		 * @param type
		 *            Session type.
		 * @return RED session.
		 * @since 0.4.0
		 * @see Session.Type
		 */
		public Session getSession(String dbid, Session.Type type) {
			Session session = null;
			if (!dbsessions.containsKey(dbid)) {
				FastMap<Session.Type, Session> sessions = new FastMap<Session.Type, Session>();
				dbsessions.put(dbid, sessions);
			}
			if (!dbsessions.get(dbid).containsKey(Session.Type._REMOTE)) {
				SessionOptions soptions = new SessionOptions(null, Session.Type._REMOTE);
				session = org.openntf.red.impl.Session.createSession(soptions);
				dbsessions.get(dbid).put(session.getSessionType(), session);
			} else
				session = dbsessions.get(dbid).get(Session.Type._REMOTE);
			return session;
		}

		/*
		 * This is done by handlers now.
		 * 
		 * private Note processNoteRequest(RequestNote request) throws
		 * REDServerException { SessionOptions soptions = new
		 * SessionOptions(null, Session.Type._REMOTE); Session session; String
		 * dbid = parseDatabaseId(request.getDbId()); if
		 * (!dbsessions.containsKey(dbid)) { FastMap<Session.Type, Session>
		 * sessions = new FastMap<Session.Type, Session>(); dbsessions.put(dbid,
		 * sessions); } if
		 * (!dbsessions.get(dbid).containsKey(Session.Type._REMOTE)) { session =
		 * org.openntf.red.impl.Session.createSession(soptions);
		 * dbsessions.get(dbid).put(session.getSessionType(), session); } else
		 * session = dbsessions.get(dbid).get(Session.Type._REMOTE); Database db
		 * = session.getDatabase("", dbid, false);
		 * log.finest("RED Server: Database is " + db); if (null == db) { throw
		 * new REDServerException("Database not found.",
		 * ServerStates.NOT_FOUND); } log.finest("Getting ID case"); IdCase
		 * idtype = request.getIdCase(); Document doc = null; // TODO also need
		 * Note for design notes Note.Builder nbuilder = Note.newBuilder();
		 * log.finest("ID case is: " + idtype.getNumber()); switch
		 * (idtype.getNumber()) { case (Payloads.PAYLOAD_NOTE_ID_UNID): doc =
		 * db.getDocumentByUNID(request.getUnid());
		 * nbuilder.setUnid(request.getUnid()); break; case
		 * (Payloads.PAYLOAD_NOTE_ID_NOTEID): log.finest("Doing NoteID..."); doc
		 * = db.getDocumentByID((int) request.getNoteId());
		 * nbuilder.setNoteId(request.getNoteId()); break; case
		 * (Payloads.PAYLOAD_NOT_SET): // TODO if (Action.UPDATE_VALUE ==
		 * request.getActionValue()) { // it's a new document/note save request
		 * -> spawn document/note stub } break; default: // TODO break; } if
		 * (null == doc) // TODO also need Note for design notes throw new
		 * REDServerException("Document not found.", ServerStates.NOT_FOUND);
		 * 
		 * switch (request.getActionValue()) { case (Action.READ_VALUE):
		 * List<org.openntf.red.Item> items = doc.getItemsEx(); Item.Builder
		 * ibuilder; for (org.openntf.red.Item item : items) { // TODO check on
		 * flags (stub) + deprecated ibuilder =
		 * Item.newBuilder().setName(item.getName()).setType(item.getType()).
		 * setFlags(0x0000); List<Object> vals = item.getValuesEx(); for (Object
		 * val : vals) { // FIXME temporary stub
		 * ibuilder.addTvalue(parseValueToString(val)); }
		 * nbuilder.addItems(ibuilder.build()); } break; case
		 * (Action.UPDATE_VALUE): if (null != doc) { // TODO also need Note for
		 * design notes boolean result = updateDocument(doc, request); if
		 * (!result) { // TODO } } // TODO break; case (Action.REMOVE_VALUE): //
		 * TODO break; default: // TODO break; }
		 * 
		 * return nbuilder.build(); }
		 * 
		 * private boolean updateDocument(Document doc, RequestNote request) {
		 * if (doc.isNewNote()) { // set up system fields // TODO }
		 * 
		 * // FIXME TEMP - ignore attachments for now List<Item> items =
		 * request.getItemsList(); List<String> itemsexist = new
		 * FastTable<String>(); org.openntf.red.Item docitem; for (Item item :
		 * items) { itemsexist.add(item.getName());
		 * 
		 * switch(item.getType()) { case Type.NUMBERS: docitem =
		 * doc.replaceItemValueCustomData(item.getName(), item.getType(),
		 * item.getFlags(), item.getNvalueList()); if (null == docitem) return
		 * false; break; case Type.TEXT: default: docitem =
		 * doc.replaceItemValueCustomData(item.getName(), item.getType(),
		 * item.getFlags(), item.getTvalueList()); if (null == docitem) return
		 * false; break; } } // clean up removed items for (String iname :
		 * doc.keySet()) { if (!itemsexist.contains(iname))
		 * doc.removeItem(iname); }
		 * 
		 * return doc.save(true, false, false); }
		 * 
		 * private boolean updateNote() { return false; }
		 */

	}

	/**
	 * List of ids and codes for processing RRPC payloads.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Payloads {
		// request payloads
		public static final int PAYLOAD_NOT_SET = 0;
		public static final int PAYLOAD_NOTEINFO = 1;
		public static final int PAYLOAD_NOTE = 2;
		public static final int PAYLOAD_NCOLLECTION = 3;
		// Note ids
		public static final int PAYLOAD_NOTE_ID_UNID = 1;
		public static final int PAYLOAD_NOTE_ID_NOTEID = 2;
	}

	/**
	 * RED server response status. Follows HTTP response status standard (for
	 * the most part).
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class ServerStates {
		// normal response status
		public static final int OK = 0x000000C8; // 200
		// errors
		public static final int BAD_REQUEST = 0x00000190; // 400
		public static final int UNAUTHORIZED = 0x00000191; // 401
		public static final int FORBIDDEN = 0x00000193; // 403
		public static final int NOT_FOUND = 0x00000194; // 404
		public static final int METHOD_NOT_ALLOWED = 0x00000195; // 405
		public static final int NOT_ACCEPTABLE = 0x00000196; // 406
		public static final int INTERNAL_SERVER_ERROR = 0x000001F4; // 500
		public static final int NOT_IMPLEMENTED = 0x000001F5; // 501

	}
}
