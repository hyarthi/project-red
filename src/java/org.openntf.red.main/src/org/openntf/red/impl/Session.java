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
 * 
 * @author Vladimir Kornienko
 *
 */
public class Session extends BaseImpl implements org.openntf.red.Session {
	
	private static Logger log = Logger.getLogger(Session.class.getName());
	
	/** Session's user name */
	private String userName;
	/** Who really created this session */
	private String effectiveUserName;
	/** Session type */
	private org.openntf.red.Session.Type type;
	private String curdbPath;
	
	public static Session getSession() {
		return null;
	}
	
	public static org.openntf.red.Session createSession(SessionOptions options) {
		Session session = new Session(options);
		
		ModuleManager.getSecurityManager().getSessionManager().registerSession(session);
		
		return session;
	}
	
	public static Session getSessionFullAccess() {
		return null;
	}
	
	public static Session getSessionAsSigner() {
		return null;
	}
	
	public static Session getSessionAsSignerFullAccess() {
		return null;
	}
	
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

	/* (non-Javadoc)
	 * @see org.openntf.red.Base#isDead()
	 */
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ExceptionDetails#fillExceptionDetails(java.util.List)
	 */
	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createAdministrationProcess(java.lang.String)
	 */
	@Override
	public AdministrationProcess createAdministrationProcess(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createColorObject()
	 */
	@Override
	public ColorObject createColorObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateRange()
	 */
	@Override
	public DateRange createDateRange() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateRange(java.util.Date, java.util.Date)
	 */
	@Override
	public DateRange createDateRange(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateRange(lotus.domino.DateTime, lotus.domino.DateTime)
	 */
	@Override
	public DateRange createDateRange(DateTime startTime, DateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateTime(java.util.Date)
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateTime(java.lang.String)
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateTime(int, int, int, int, int, int)
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(int y, int m, int d, int h, int i, int s) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDxlExporter()
	 */
	@Override
	public DxlExporter createDxlExporter() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDxlImporter()
	 */
	@Override
	public DxlImporter createDxlImporter() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createLog(java.lang.String)
	 */
	@Override
	public Log createLog(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createName(java.lang.String)
	 */
	@Override
	public Name createName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createName(java.lang.String, java.lang.String)
	 */
	@Override
	public Name createName(String name, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createNewsletter(lotus.domino.DocumentCollection)
	 */
	@Override
	public Newsletter createNewsletter(DocumentCollection collection) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createRegistration()
	 */
	@Override
	public Registration createRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createRichTextParagraphStyle()
	 */
	@Override
	public RichTextParagraphStyle createRichTextParagraphStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createRichTextStyle()
	 */
	@Override
	public RichTextStyle createRichTextStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createStream()
	 */
	@Override
	public Stream createStream() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#evaluate(java.lang.String)
	 */
	@Override
	public Vector<Object> evaluate(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#evaluate(java.lang.String, lotus.domino.Document)
	 */
	@Override
	public Vector<Object> evaluate(String formula, Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#freeResourceSearch(lotus.domino.DateTime, lotus.domino.DateTime, java.lang.String, int, int)
	 */
	@Override
	public Vector<String> freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#freeResourceSearch(lotus.domino.DateTime, lotus.domino.DateTime, java.lang.String, int, int, java.lang.String, int, java.lang.String, java.lang.String, int)
	 */
	@Override
	public Vector<String> freeResourceSearch(DateTime arg0, DateTime arg1, String arg2, int arg3, int arg4, String arg5,
			int arg6, String arg7, String arg8, int arg9) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#freeTimeSearch(lotus.domino.DateRange, int, java.lang.Object, boolean)
	 */
	@Override
	public Vector<DateRange> freeTimeSearch(lotus.domino.DateRange window, int duration, Object names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getAddressBooks()
	 */
	@Override
	public Vector<Database> getAddressBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getAgentContext()
	 */
	@Override
	public AgentContext getAgentContext() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getCalendar(lotus.domino.Database)
	 */
	@Override
	public NotesCalendar getCalendar(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getCommonUserName()
	 */
	@Override
	public String getCommonUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getCurrentDatabase()
	 */
	@Override
	public Database getCurrentDatabase() {
		// TODO Add authorization here
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabase(java.lang.String, java.lang.String)
	 */
	@Override
	public Database getDatabase(String server, String db) {
		return getDatabase(server, db, false);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabase(java.lang.String, java.lang.String, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Database getDatabase(String server, String dbpath, boolean createOnFail) {
		// TODO Authorization check here
		Endpoint endpoint = ModuleManager.getDataBroker().getEndpoint(server);
		log.finest("API: Getting BE database...");
		org.openntf.red.nsf.endpoint.Database bedb = endpoint.getDatabase(dbpath, createOnFail);
		log.finest("API: Got BE database " + bedb);
		if (null == bedb)
			return null;
		log.finest("API: creating wrapper for database...");
		return new org.openntf.red.impl.Database(this, dbpath, bedb);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDbDirectory(java.lang.String)
	 */
	@Override
	public DbDirectory getDbDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDirectory()
	 */
	@Override
	public Directory getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDirectory(java.lang.String)
	 */
	@Override
	public Directory getDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEffectiveUserName()
	 */
	@Override
	public String getEffectiveUserName() {
		return effectiveUserName;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEnvironmentString(java.lang.String)
	 */
	@Override
	public String getEnvironmentString(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEnvironmentString(java.lang.String, boolean)
	 */
	@Override
	public String getEnvironmentString(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEnvironmentValue(java.lang.String)
	 */
	@Override
	public Object getEnvironmentValue(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEnvironmentValue(java.lang.String, boolean)
	 */
	@Override
	public Object getEnvironmentValue(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getHttpURL()
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getInternational()
	 */
	@Override
	public International getInternational() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getNotesVersion()
	 */
	@Override
	public String getNotesVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getOrgDirectoryPath()
	 */
	@Override
	public String getOrgDirectoryPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getPlatform()
	 */
	@Override
	public String getPlatform() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getPropertyBroker()
	 */
	@Override
	public PropertyBroker getPropertyBroker() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getServerName()
	 */
	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getSessionToken()
	 */
	@Override
	public String getSessionToken() {
		// FIXME - change this to a more adequate version
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getSessionToken(java.lang.String)
	 */
	@Override
	public String getSessionToken(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getURL()
	 */
	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getURLDatabase()
	 */
	@Override
	public Database getURLDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserGroupNameList()
	 */
	@Override
	public Vector<Name> getUserGroupNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserName()
	 */
	@Override
	public String getUserName() {
		return userName;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserNameList()
	 */
	@Override
	public Vector<Name> getUserNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserNameObject()
	 */
	@Override
	public Name getUserNameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserPolicySettings(java.lang.String, java.lang.String, int)
	 */
	@Override
	public org.openntf.red.Document getUserPolicySettings(String server, String name, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserPolicySettings(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	@Override
	public org.openntf.red.Document getUserPolicySettings(String server, String name, int type, String explicitPolicy) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#hashPassword(java.lang.String)
	 */
	@Override
	public String hashPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isConvertMime()
	 */
	@Override
	public boolean isConvertMime() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isConvertMIME()
	 */
	@Override
	public boolean isConvertMIME() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isOnServer()
	 */
	@Override
	public boolean isOnServer() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isRestricted()
	 */
	@Override
	public boolean isRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isTrackMillisecInJavaDates()
	 */
	@Override
	public boolean isTrackMillisecInJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isTrustedSession()
	 */
	@Override
	public boolean isTrustedSession() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#resetUserPassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean resetUserPassword(String serverName, String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#resetUserPassword(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public boolean resetUserPassword(String serverName, String userName, String password, int downloadCount) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#resolve(java.lang.String)
	 */
	@Override
	public Base<?> resolve(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#sendConsoleCommand(java.lang.String, java.lang.String)
	 */
	@Override
	public String sendConsoleCommand(String serverName, String consoleCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setAllowLoopBack(boolean)
	 */
	@Override
	public void setAllowLoopBack(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setConvertMime(boolean)
	 */
	@Override
	public void setConvertMime(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setConvertMIME(boolean)
	 */
	@Override
	public void setConvertMIME(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setEnvironmentVar(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setEnvironmentVar(String vname, Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setEnvironmentVar(java.lang.String, java.lang.Object, boolean)
	 */
	@Override
	public void setEnvironmentVar(String vname, Object value, boolean isSystem) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setTrackMillisecInJavaDates(boolean)
	 */
	@Override
	public void setTrackMillisecInJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#verifyPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean verifyPassword(String password, String hashedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEventFactory()
	 */
	@Override
	public IDominoEventFactory getEventFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setEventFactory(org.openntf.red.events.IDominoEventFactory)
	 */
	@Override
	public void setEventFactory(IDominoEventFactory factory) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#generateEvent(org.openntf.red.events.EnumEvent, org.openntf.red.Base, org.openntf.red.Base, java.lang.Object)
	 */
	public IDominoEvent generateEvent(EnumEvent event, Base<?> source, Base<?> target, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createColorObject(java.awt.Color)
	 */
	@Override
	public ColorObject createColorObject(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#freeTimeSearch(org.openntf.red.DateRange, int, java.util.Collection, boolean)
	 */
	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, Collection<String> names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#freeTimeSearch(org.openntf.red.DateRange, int, java.lang.String, boolean)
	 */
	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, String names, boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getAddressBookCollection()
	 */
	@Override
	public Collection<Database> getAddressBookCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserGroupNameCollection()
	 */
	@Override
	public Collection<String> getUserGroupNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUserNameCollection()
	 */
	@Override
	public Collection<String> getUserNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createDateTime(java.util.Calendar)
	 */
	@Override
	public org.openntf.red.DateTime createDateTime(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#createNameNonODA(java.lang.String)
	 */
	@Override
	public Name createNameNonODA(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isAnonymous()
	 */
	@Override
	public boolean isAnonymous() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isFixEnabled(org.openntf.red.Session.Fixes)
	 */
	@Override
	public boolean isFixEnabled(Fixes fix) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getEnabledFixes()
	 */
	@Override
	public Fixes[] getEnabledFixes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setFixEnable(org.openntf.red.Session.Fixes, boolean)
	 */
	@Override
	public void setFixEnable(Fixes fix, boolean value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#toCommonName(java.lang.String)
	 */
	@Override
	public String toCommonName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#boogie()
	 */
	@Override
	public void boogie() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#isFeatureRestricted()
	 */
	@Override
	public boolean isFeatureRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getUnique()
	 */
	@Override
	public String getUnique() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabaseByReplicaID(java.lang.String, java.lang.String)
	 */
	@Override
	public Database getDatabaseByReplicaID(String server, String replicaid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabaseWithFailover(java.lang.String, java.lang.String)
	 */
	@Override
	public Database getDatabaseWithFailover(String server, String dbfile) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabaseIfModified(java.lang.String, java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public Database getDatabaseIfModified(String server, String dbfile, DateTime modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabaseIfModified(java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public Database getDatabaseIfModified(String server, String dbfile, Date modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getMailDatabase()
	 */
	@Override
	public Database getMailDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDatabase(java.lang.String)
	 */
	@Override
	public Database getDatabase(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDocumentByMetaversalID(java.lang.String)
	 */
	@Override
	public org.openntf.red.Document getDocumentByMetaversalID(String metaversalID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getDocumentByMetaversalID(java.lang.String, java.lang.String)
	 */
	@Override
	public org.openntf.red.Document getDocumentByMetaversalID(String metaversalID, String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#getAutoMime()
	 */
	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setAutoMime(org.openntf.red.util.AutoMime)
	 */
	@Override
	public void setAutoMime(AutoMime autoMime) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setCurrentDatabase(org.openntf.red.Database)
	 */
	@Override
	public void setCurrentDatabase(Database db) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#setNoRecycle(boolean)
	 */
	@Override
	public void setNoRecycle(boolean noRecycle) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#recycle()
	 */
	@Override
	public void recycle() {
		// TODO Auto-generated method stub
		ModuleManager.getSecurityManager().getSessionManager().deregisterSession(this);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Session#clearIdentity()
	 */
	@Override
	public void clearIdentity() {
		// TODO Auto-generated method stub

	}

	@Override
	public IDominoEvent generateEvent(EnumEvent event, org.openntf.red.Base source, org.openntf.red.Base target,
			Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentDatabasePath() {
		return curdbPath;
	}

	@Override
	public Type getSessionType() {
		return this.type;
	}

}
