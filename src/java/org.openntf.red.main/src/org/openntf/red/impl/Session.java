/**
 * 
 */
package org.openntf.red.impl;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.AdministrationProcess;
import org.openntf.red.AgentContext;
import org.openntf.red.ColorObject;
import org.openntf.red.Database;
import org.openntf.red.DateRange;
import org.openntf.red.DbDirectory;
import org.openntf.red.Directory;
import org.openntf.red.DxlExporter;
import org.openntf.red.DxlImporter;
import org.openntf.red.International;
import org.openntf.red.Log;
import org.openntf.red.Name;
import org.openntf.red.Newsletter;
import org.openntf.red.NotesCalendar;
import org.openntf.red.PropertyBroker;
import org.openntf.red.Registration;
import org.openntf.red.RichTextParagraphStyle;
import org.openntf.red.RichTextStyle;
import org.openntf.red.Stream;
import org.openntf.red.core.modules.ModuleManager;
import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoEventFactory;
import org.openntf.red.exceptions.OpenNTFNotesException;
//import org.openntf.red.nsf.IDataBroker;
import org.openntf.red.nsf.endpoint.Endpoint;
//import org.openntf.red.security.ISecurityManager;
//import org.openntf.red.security.session.ISessionManager;
import org.openntf.red.security.session.impl.SessionOptions;
import org.openntf.red.util.AutoMime;

import lotus.domino.DateTime;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import lotus.domino.NotesException;

/**
 * <i>Parts of code borrowed from OpenNTF Domino API.</i><br>
 * Entity representing a Notes session.
 * 
 * @author Vladimir Kornienko
 * @see org.openntf.red.Session
 * @since 0.4.0
 */
public class Session extends BaseImpl implements org.openntf.red.Session {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(Session.class.getName());

	/** Session's user name */
	private String userName;
	/** Who really created this session */
	private String effectiveUserName;
	/** Session type */
	private org.openntf.red.Session.Type type;
	/** The path of the database that this session is attached to. */
	private String curdbPath;

	/**
	 * Not implemented yet.
	 * 
	 * @return
	 */
	public static Session getSession() {
		return null;
	}

	/**
	 * Default way to create a session. Under consideration.
	 * 
	 * @param options
	 *            Session options needed to set up the session.
	 * @return The newly created session.
	 * @see SessionOptions
	 * @since 0.4.0
	 */
	public static org.openntf.red.Session createSession(SessionOptions options) {
		Session session = new Session(options);

		ModuleManager.getSecurityManager().getSessionManager().registerSession(session);

		return session;
	}

	/**
	 * Not implemented yet.
	 */
	public static Session getSessionFullAccess() {
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	public static Session getSessionAsSigner() {
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	public static Session getSessionAsSignerFullAccess() {
		return null;
	}

	/**
	 * Default constructor.
	 * 
	 * @param options
	 *            Session options needed to set up a session.
	 * @see SessionOptions
	 * @since 0.4.0
	 */
	private Session(SessionOptions options) {
		if (null == ModuleManager.getSecurityManager().getSessionManager())
			throw new OpenNTFNotesException("Could not instantiate session: no session manager present.");
		// FIXME STUB - replace this with authentication
		this.effectiveUserName = "cn=lotus01/o=trade";
		// set session options
		if (options.getType() == null)
			type = Type.CURRENT;
		else
			type = options.getType();
		curdbPath = options.getDbPath();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public AdministrationProcess createAdministrationProcess(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ColorObject createColorObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateRange createDateRange() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateRange createDateRange(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateRange createDateRange(DateTime startTime, DateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(int y, int m, int d, int h, int i, int s) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DxlExporter createDxlExporter() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DxlImporter createDxlImporter() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Log createLog(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Name createName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Name createName(String name, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Newsletter createNewsletter(DocumentCollection collection) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Registration createRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public RichTextParagraphStyle createRichTextParagraphStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public RichTextStyle createRichTextStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Stream createStream() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> evaluate(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> evaluate(String formula, Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4, String arg5,
			int arg6, String arg7, String arg8, int arg9) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<DateRange> freeTimeSearch(lotus.domino.DateRange window, int duration, Object names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Database> getAddressBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public AgentContext getAgentContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public NotesCalendar getCalendar(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getCommonUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getCurrentDatabase() {
		// TODO Add authorization here

		return null;
	}

	/**
	 * Returns and opens a database given a server and db path specified.
	 * 
	 * @param server
	 *            Server name to look for a database. Leave blank/null for local
	 *            server.
	 * @param db
	 *            Database path relative to data directory.
	 * @return The database (or null of none exist).
	 * @since 0.4.0
	 */
	@Override
	public Database getDatabase(String server, String db) {
		// TODO enable replica search
		return getDatabase(server, db, false);
	}

	/**
	 * Returns and opens a database given a server and db path specified.
	 * 
	 * @param server
	 *            Server name to look for a database. Leave blank/null for local
	 *            server.
	 * @param db
	 *            Database path relative to data directory.
	 * @param createOnFail
	 *            Will attempt to create the database if none exist.
	 * @return The database (or null of none exist).
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Database getDatabase(String server, String dbpath, boolean createOnFail) {
		// TODO Authorization check here
		// TODO enable replica search
		Endpoint endpoint = ModuleManager.getDataBroker().getEndpoint(server);
		log.finest("API: Getting BE database...");
		org.openntf.red.nsf.endpoint.Database bedb = endpoint.getDatabase(dbpath, createOnFail);
		log.finest("API: Got BE database " + bedb);
		if (null == bedb)
			return null;
		log.finest("API: creating wrapper for database...");
		return new org.openntf.red.impl.Database(this, dbpath, bedb);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DbDirectory getDbDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Directory getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Directory getDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the effective user name (name of the user that instantiated the
	 * session).
	 * 
	 * @return Effective user name
	 * @since 0.4.0
	 */
	@Override
	public String getEffectiveUserName() {
		return effectiveUserName;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getEnvironmentString(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getEnvironmentString(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getEnvironmentValue(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getEnvironmentValue(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public International getInternational() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getNotesVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getOrgDirectoryPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getPlatform() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public PropertyBroker getPropertyBroker() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getSessionToken() {
		// FIXME - change this to a more adequate version
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getSessionToken(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getURLDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Name> getUserGroupNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the session user name. May differ from effective user name.
	 * 
	 * @return Session user name.
	 * @since 0.4.0
	 */
	@Override
	public String getUserName() {
		return userName;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Name> getUserNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Name getUserNameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document getUserPolicySettings(String server, String name, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document getUserPolicySettings(String server, String name, int type, String explicitPolicy) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String hashPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isConvertMime() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isConvertMIME() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isOnServer() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isTrackMillisecInJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isTrustedSession() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean resetUserPassword(String serverName, String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean resetUserPassword(String serverName, String userName, String password, int downloadCount) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Base<?> resolve(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String sendConsoleCommand(String serverName, String consoleCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setAllowLoopBack(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setConvertMime(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setConvertMIME(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEnvironmentVar(String vname, Object value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEnvironmentVar(String vname, Object value, boolean isSystem) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setTrackMillisecInJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean verifyPassword(String password, String hashedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IDominoEventFactory getEventFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEventFactory(IDominoEventFactory factory) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	public IDominoEvent generateEvent(EnumEvent event, Base<?> source, Base<?> target, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ColorObject createColorObject(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, Collection<String> names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, String names, boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<Database> getAddressBookCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<String> getUserGroupNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<String> getUserNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Name createNameNonODA(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAnonymous() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isFixEnabled(Fixes fix) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Fixes[] getEnabledFixes() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setFixEnable(Fixes fix, boolean value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String toCommonName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void boogie() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isFeatureRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getUnique() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getDatabaseByReplicaID(String server, String replicaid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getDatabaseWithFailover(String server, String dbfile) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getDatabaseIfModified(String server, String dbfile, DateTime modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getDatabaseIfModified(String server, String dbfile, Date modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getMailDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Database getDatabase(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document getDocumentByMetaversalID(String metaversalID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document getDocumentByMetaversalID(String metaversalID, String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setAutoMime(AutoMime autoMime) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setCurrentDatabase(Database db) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setNoRecycle(boolean noRecycle) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void recycle() {
		// TODO Auto-generated method stub
		ModuleManager.getSecurityManager().getSessionManager().deregisterSession(this);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void clearIdentity() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IDominoEvent generateEvent(EnumEvent event, org.openntf.red.Base source, org.openntf.red.Base target,
			Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns the current db path.
	 * 
	 * @return Current db path.
	 * @since 0.4.0
	 */
	@Override
	public String getCurrentDatabasePath() {
		return curdbPath;
	}

	/**
	 * Returns the session type.
	 * 
	 * @return Session type.
	 * @see Type
	 * @since 0.4.0
	 */
	@Override
	public Type getSessionType() {
		return this.type;
	}

}
