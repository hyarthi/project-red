/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.client.ClientResponse;
//import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import lotus.domino.AdministrationProcess;
import lotus.domino.AgentContext;
import lotus.domino.Base;
import lotus.domino.ColorObject;
//import lotus.domino.Database;
import lotus.domino.DateRange;
import lotus.domino.DateTime;
import lotus.domino.DbDirectory;
import lotus.domino.Directory;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import lotus.domino.DxlExporter;
import lotus.domino.DxlImporter;
import lotus.domino.International;
import lotus.domino.Log;
import lotus.domino.Name;
import lotus.domino.Newsletter;
import lotus.domino.NotesCalendar;
import lotus.domino.NotesException;
import lotus.domino.PropertyBroker;
import lotus.domino.Registration;
import lotus.domino.RichTextParagraphStyle;
import lotus.domino.RichTextStyle;
import lotus.domino.Stream;

import org.openntf.redomino.utils.Factory;
import org.openntf.redomino.utils.Factory.SessionType;

import com.ibm.commons.util.io.json.JsonJavaObject;

/**
 * @author Vladimir Kornienko
 *
 */
public class Session implements lotus.domino.Session, CouchBase {

	private static final Logger log_ = Logger.getLogger(Session.class.getName());

	protected Client endpoint;

	/**
	 * 
	 */
	public Session() {
		// register custom JSON MessageBodyReader/MessageBodyWriter
		ClientConfig config = new ClientConfig();
		config.register(REDJsonProvider.class);
		endpoint = ClientBuilder.newClient(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		endpoint.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createAdministrationProcess(java.lang.String)
	 */
	@Override
	public AdministrationProcess createAdministrationProcess(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createColorObject()
	 */
	@Override
	public ColorObject createColorObject() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateRange()
	 */
	@Override
	public DateRange createDateRange() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateRange(lotus.domino.DateTime,
	 * lotus.domino.DateTime)
	 */
	@Override
	public DateRange createDateRange(DateTime arg0, DateTime arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public DateRange createDateRange(Date arg0, Date arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateTime(java.util.Date)
	 */
	@Override
	public DateTime createDateTime(Date arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateTime(java.util.Calendar)
	 */
	@Override
	public DateTime createDateTime(Calendar arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDateTime(java.lang.String)
	 */
	@Override
	public DateTime createDateTime(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDxlExporter()
	 */
	@Override
	public DxlExporter createDxlExporter() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createDxlImporter()
	 */
	@Override
	public DxlImporter createDxlImporter() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createLog(java.lang.String)
	 */
	@Override
	public Log createLog(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createName(java.lang.String)
	 */
	@Override
	public Name createName(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createName(java.lang.String, java.lang.String)
	 */
	@Override
	public Name createName(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Session#createNewsletter(lotus.domino.DocumentCollection)
	 */
	@Override
	public Newsletter createNewsletter(DocumentCollection arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createRegistration()
	 */
	@Override
	public Registration createRegistration() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createRichTextParagraphStyle()
	 */
	@Override
	public RichTextParagraphStyle createRichTextParagraphStyle() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createRichTextStyle()
	 */
	@Override
	public RichTextStyle createRichTextStyle() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#createStream()
	 */
	@Override
	public Stream createStream() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#evaluate(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector evaluate(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#evaluate(java.lang.String,
	 * lotus.domino.Document)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector evaluate(String arg0, Document arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#freeResourceSearch(lotus.domino.DateTime,
	 * lotus.domino.DateTime, java.lang.String, int, int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4)
			throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#freeResourceSearch(lotus.domino.DateTime,
	 * lotus.domino.DateTime, java.lang.String, int, int, java.lang.String, int,
	 * java.lang.String, java.lang.String, int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4, String arg5,
			int arg6, String arg7, String arg8, int arg9) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#freeTimeSearch(lotus.domino.DateRange, int,
	 * java.lang.Object, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector freeTimeSearch(DateRange arg0, int arg1, Object arg2, boolean arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getAddressBooks()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getAddressBooks() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getAgentContext()
	 */
	@Override
	public AgentContext getAgentContext() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getCalendar(lotus.domino.Database)
	 */
	@Override
	public NotesCalendar getCalendar(lotus.domino.Database arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getCommonUserName()
	 */
	@Override
	public String getCommonUserName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getCredentials()
	 */
	@Override
	public Object getCredentials() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getCurrentDatabase()
	 */
	@Override
	public lotus.domino.Database getCurrentDatabase() throws NotesException {
		// TODO Auto-generated method stub
		return Factory.getSession(SessionType.CURRENT).getCurrentDatabase();
	}

	/**
	 * Tries to get a Couch database object. If database does not exist -
	 * creates it.
	 * 
	 * @param server
	 *            server URL (with port) of the CouchDB server OR server name
	 *            specified in notes.ini param OR null/empty String if local
	 *            server (not implemented yet)
	 * @param db
	 *            CouchDB database path (relative to server root)
	 * @return Couch database object (implements {@link lotus.domino.Database});
	 *         null if no database found
	 * @see org.openntf.redomino.couch.Database
	 */
	@Override
	public lotus.domino.Database getDatabase(String server, String db) throws NotesException {
		return getDatabase(server, db, true);
	}

	/**
	 * Tries to get a Couch database object. If database does not exist - can
	 * create it.
	 * 
	 * @param server
	 *            server URL (with port) of the CouchDB server OR server name
	 *            specified in notes.ini param OR null/empty String if local
	 *            server (not implemented yet)
	 * @param db
	 *            CouchDB database path (relative to server root)
	 * @param createonfail
	 *            whether the database should be created
	 * @return Couch database object (implements {@link lotus.domino.Database});
	 *         null if no database found
	 * @see org.openntf.redomino.couch.Database
	 */
	@Override
	public lotus.domino.Database getDatabase(String server, String db, boolean createonfail) throws NotesException {
		WebTarget starget, target;
		UriBuilder suri;
		String spath;
		Response response;

		// check if local server
		if (null == server)
			return null; // STUB
		if (server.isEmpty())
			return null; // STUB

		// check if server value us an URL
		if (server.contains(":"))
			// definitely not Lotus server name
			// URL should start with http:// , so leave this as it is for now
			spath = server;
		else
			spath = Factory.getCouchServerUrl(server);

		suri = UriBuilder.fromPath(spath);
		starget = endpoint.target(suri);
		target = starget.path(db);

		// NOTE: no ReplicaID surrogate yet, so use path only
		// NOTE: no async mode yet (NB: since it's usually single-thread - do I
		// really need async? - needs investigation)
		response = starget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).get();
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			// server unavailable
			// exception, maybe?
			response.close();
			return null;
		}

		response.close();

		response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
		JsonJavaObject body = response.readEntity(JsonJavaObject.class);
		if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode() && body.getAsString("reason").contains("no_db_file")) {
			// no database found
			// if need to create on fail, do it
			if (createonfail) {
				response.close();
				// try to create a database
				response = target.request(MediaType.APPLICATION_JSON_TYPE)
						.put(Entity.entity("", MediaType.TEXT_PLAIN_TYPE));

				if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
					response.close();
					return null;
				} else {
					response.close();
					return new Database(server, db, target, this);
				}
			}
			response.close();
			return null;
		}

		response.close();
		return new Database(server, db, target, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getDbDirectory(java.lang.String)
	 */
	@Override
	public DbDirectory getDbDirectory(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getDirectory()
	 */
	@Override
	public Directory getDirectory() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getDirectory(java.lang.String)
	 */
	@Override
	public Directory getDirectory(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getEffectiveUserName()
	 */
	@Override
	public String getEffectiveUserName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getEnvironmentString(java.lang.String)
	 */
	@Override
	public String getEnvironmentString(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getEnvironmentString(java.lang.String, boolean)
	 */
	@Override
	public String getEnvironmentString(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getEnvironmentValue(java.lang.String)
	 */
	@Override
	public Object getEnvironmentValue(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getEnvironmentValue(java.lang.String, boolean)
	 */
	@Override
	public Object getEnvironmentValue(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getHttpURL()
	 */
	@Override
	public String getHttpURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getInternational()
	 */
	@Override
	public International getInternational() throws NotesException {
		// TODO Auto-generated method stub
		International inter = new org.openntf.redomino.couch.International();
		return inter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getNotesVersion()
	 */
	@Override
	public String getNotesVersion() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getOrgDirectoryPath()
	 */
	@Override
	public String getOrgDirectoryPath() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getPlatform()
	 */
	@Override
	public String getPlatform() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getPropertyBroker()
	 */
	@Override
	public PropertyBroker getPropertyBroker() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getServerName()
	 */
	@Override
	public String getServerName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getSessionToken()
	 */
	@Override
	public String getSessionToken() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getSessionToken(java.lang.String)
	 */
	@Override
	public String getSessionToken(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getURL()
	 */
	@Override
	public String getURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getURLDatabase()
	 */
	@Override
	public Database getURLDatabase() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserGroupNameList()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getUserGroupNameList() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserName()
	 */
	@Override
	public String getUserName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserNameList()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getUserNameList() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserNameObject()
	 */
	@Override
	public Name getUserNameObject() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserPolicySettings(java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public Document getUserPolicySettings(String arg0, String arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#getUserPolicySettings(java.lang.String,
	 * java.lang.String, int, java.lang.String)
	 */
	@Override
	public Document getUserPolicySettings(String arg0, String arg1, int arg2, String arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#hashPassword(java.lang.String)
	 */
	@Override
	public String hashPassword(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isConvertMIME()
	 */
	@Override
	public boolean isConvertMIME() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isConvertMime()
	 */
	@Override
	public boolean isConvertMime() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isOnServer()
	 */
	@Override
	public boolean isOnServer() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isRestricted()
	 */
	@Override
	public boolean isRestricted() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isTrackMillisecInJavaDates()
	 */
	@Override
	public boolean isTrackMillisecInJavaDates() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isTrustedSession()
	 */
	@Override
	public boolean isTrustedSession() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#resetUserPassword(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean resetUserPassword(String arg0, String arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#resetUserPassword(java.lang.String,
	 * java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean resetUserPassword(String arg0, String arg1, String arg2, int arg3) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#resolve(java.lang.String)
	 */
	@Override
	public Base resolve(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#sendConsoleCommand(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String sendConsoleCommand(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setAllowLoopBack(boolean)
	 */
	@Override
	public void setAllowLoopBack(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setConvertMIME(boolean)
	 */
	@Override
	public void setConvertMIME(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setConvertMime(boolean)
	 */
	@Override
	public void setConvertMime(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setEnvironmentVar(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setEnvironmentVar(String arg0, Object arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setEnvironmentVar(java.lang.String,
	 * java.lang.Object, boolean)
	 */
	@Override
	public void setEnvironmentVar(String arg0, Object arg1, boolean arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#setTrackMillisecInJavaDates(boolean)
	 */
	@Override
	public void setTrackMillisecInJavaDates(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Session#verifyPassword(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean verifyPassword(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Session getAncestorSession() {
		return this;
	}
}
