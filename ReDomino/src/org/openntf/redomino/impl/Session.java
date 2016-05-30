/**
 * 
 */
package org.openntf.redomino.impl;

import java.awt.Color;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.domino.AdministrationProcess;
import org.openntf.domino.AgentContext;
import org.openntf.domino.AutoMime;
import org.openntf.domino.Base;
import org.openntf.domino.ColorObject;
import org.openntf.domino.Database;
import org.openntf.domino.DateRange;
import org.openntf.domino.DateTime;
import org.openntf.domino.DbDirectory;
import org.openntf.domino.Directory;
import org.openntf.domino.Document;
import org.openntf.domino.DxlExporter;
import org.openntf.domino.DxlImporter;
import org.openntf.domino.International;
import org.openntf.domino.Log;
import org.openntf.domino.Newsletter;
import org.openntf.domino.NotesCalendar;
import org.openntf.domino.PropertyBroker;
import org.openntf.domino.Registration;
import org.openntf.domino.RichTextParagraphStyle;
import org.openntf.domino.RichTextStyle;
import org.openntf.domino.Stream;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.events.EnumEvent;
import org.openntf.domino.events.IDominoEvent;
import org.openntf.domino.events.IDominoEventFactory;
import org.openntf.domino.exceptions.UserAccessException;
import org.openntf.domino.ext.Name;
//import org.openntf.redomino.couch.CouchBase;
import org.openntf.redomino.impl.Session;
import org.openntf.domino.utils.DominoFormatter;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.redomino.utils.Factory;
import org.openntf.redomino.utils.Factory.SessionType;

import com.ibm.icu.util.Calendar;

import lotus.domino.DocumentCollection;
import lotus.domino.NotesError;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class Session extends BaseThreadSafe<org.openntf.domino.Session, lotus.domino.Session, WrapperFactory>
		implements org.openntf.domino.Session {

	/** The Constant log_. */
	private static final Logger log_ = Logger.getLogger(Session.class.getName());

	/** The formatter_. */
	private DominoFormatter formatter_;
	private static final Object getDB_lock = new Object();
	private transient Database currentDatabase_;
	private transient Boolean isConvertMime_;
	private String currentDatabaseApiPath_;

	private String username_;

	private Set<Fixes> fixes_ = EnumSet.noneOf(Fixes.class);

	private IDominoEventFactory eventFactory_;
	private AutoMime isAutoMime_;
	private SessionType sessionType_;
	private boolean identCleared_ = false;
	private boolean featureRestricted_ = false;

	/**
	 * @param lotus
	 * @param parent
	 */
	protected Session(lotus.domino.Session lotus, WrapperFactory parent) {
		super(lotus, parent, NOTES_SESSION);
		initialize(lotus);
		featureRestricted_ = false; // currently not implemented
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize.
	 * 
	 * @param session
	 *            the session
	 */
	private void initialize(final lotus.domino.Session session) {
		setFixEnable(Fixes.DOC_UNID_NULLS, true);
		try {
			username_ = session.getEffectiveUserName();
			formatter_ = new DominoFormatter(getInternational());
		} catch (NotesException e) {
			DominoUtils.handleException(e, this);
		}
	}

	public void setSessionType(final SessionType sessionType) {
		// TODO Auto-generated method stub
		if (sessionType_ != null)
			throw new IllegalStateException("SessionType cannot be changed");
		sessionType_ = sessionType;
	}

	@Override
	public void setSessionType(final org.openntf.domino.utils.Factory.SessionType sessionType) {
		// TODO Auto-generated method stub
		if (sessionType_ != null)
			throw new IllegalStateException("SessionType cannot be changed");
		sessionType_ = SessionType.getAsREDSessionType(sessionType);
	}

	private org.openntf.domino.Session recreateSession() {
		switch (sessionType_) {
		case _NAMED_FULL_ACCESS_internal:
			return Factory.getNamedSession(username_, true);
		case _NAMED_internal:
			return Factory.getNamedSession(username_, false);
		default:
			return Factory.getSession(sessionType_);
		}
	}

	@Override
	public org.openntf.domino.Database getDatabase(final String server, final String db, final boolean createOnFail) {
		if (Factory.SessionType.isCouchSession(sessionType_)) {
			// get Couch database
			org.openntf.domino.Database result;
			lotus.domino.Database raw;
			try {
				raw = ((org.openntf.redomino.couch.Session) beObject).getDatabase(server, db, createOnFail);
				result = ((org.openntf.redomino.impl.WrapperFactory) this.parent).fromCouch(raw, Database.SCHEMA, this);
				return result;
			} catch (NotesException ne) {
				ne.printStackTrace();
				return null;
			}
		} else {
			// get Lotus database
			if ((server == null || server.isEmpty()) && (db == null || db.isEmpty())) {
				try {
					synchronized (getDB_lock) {
						return fromLotus(getDelegate().getDatabase("", ""), Database.SCHEMA, this);
					}
				} catch (NotesException e) {
					DominoUtils.handleException(e, this);
					return null;
				}
			}

			if (db == null || db.isEmpty()) {
				throw new IllegalArgumentException(
						"Filepath argument cannot be null or empty string unless the server is also empty.");
			}

			lotus.domino.Database database = null;
			org.openntf.domino.Database result = null;

			if (result == null) {
				try {
					boolean isDbRepId = DominoUtils.isReplicaId(db);
					if (isDbRepId) {
						lotus.domino.Database nullDb;
						synchronized (getDB_lock) {
							nullDb = getDelegate().getDatabase(null, null);
						}
						boolean opened = nullDb.openByReplicaID(server, db);
						if (opened) {
							result = fromLotus(nullDb, Database.SCHEMA, this);
						} else {
							s_recycle(nullDb);
							result = null;
						}
					} else {
						synchronized (getDB_lock) {
							database = getDelegate().getDatabase(server, db, createOnFail);
						}
						result = fromLotus(database, Database.SCHEMA, this);
					}
				} catch (NotesException e) {
					if (e.id == NotesError.NOTES_ERR_DBNOACCESS) {
						throw new UserAccessException("User " + getEffectiveUserName() + " cannot open database " + db
								+ " on server " + server, e);
					} else {
						DominoUtils.handleException(e, this);
						return null;
					}
				}
			}
			return result;
		}
	}

	@Override
	public IDominoEventFactory getEventFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEventFactory(IDominoEventFactory factory) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDominoEvent generateEvent(EnumEvent event, Base<?> source, Base<?> target, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, Collection<String> names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DateRange> freeTimeSearch(DateRange window, int duration, String names, boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Database> getAddressBookCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getUserGroupNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getUserNameCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime createDateTime(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Name createNameNonODA(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAnonymous() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFixEnabled(Fixes fix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fixes[] getEnabledFixes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFixEnable(Fixes fix, boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toCommonName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boogie() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFeatureRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUnique() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabaseByReplicaID(String server, String replicaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabaseWithFailover(String server, String dbfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabaseIfModified(String server, String dbfile, lotus.domino.DateTime modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabaseIfModified(String server, String dbfile, Date modifiedsince) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getMailDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabase(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByMetaversalID(String metaversalID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByMetaversalID(String metaversalID, String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAutoMime(AutoMime autoMime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCurrentDatabase(Database db) {
		// TODO Auto-generated method stub

	}

	@Override
	public DominoFormatter getFormatter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNoRecycle(boolean noRecycle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearIdentity() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdministrationProcess createAdministrationProcess(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorObject createColorObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorObject createColorObject(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateRange createDateRange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateRange createDateRange(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateRange createDateRange(lotus.domino.DateTime startTime, lotus.domino.DateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime createDateTime(java.util.Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime createDateTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime createDateTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime createDateTime(int y, int m, int d, int h, int i, int s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DxlExporter createDxlExporter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DxlImporter createDxlImporter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log createLog(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Name createName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Name createName(String name, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Newsletter createNewsletter(DocumentCollection collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Registration createRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextParagraphStyle createRichTextParagraphStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextStyle createRichTextStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream createStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> evaluate(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> evaluate(String formula, lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> freeResourceSearch(lotus.domino.DateTime arg0, lotus.domino.DateTime arg1, String arg2,
			int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> freeResourceSearch(lotus.domino.DateTime arg0, lotus.domino.DateTime arg1, String arg2,
			int arg3, int arg4, String arg5, int arg6, String arg7, String arg8, int arg9) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<DateRange> freeTimeSearch(lotus.domino.DateRange window, int duration, Object names,
			boolean firstFit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Database> getAddressBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgentContext getAgentContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendar getCalendar(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommonUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getCurrentDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabase(String server, String db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbDirectory getDbDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Directory getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Directory getDirectory(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectiveUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvironmentString(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvironmentString(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String vname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String vname, boolean isSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public International getInternational() {
		// TODO Couch implementation
		try {
			//System.out.println("<><><> Getting International...");
			//System.out.println("<><><> Is it a Couch Object? " + (null != this.beObject));
			if (null != this.beObject) {
				//System.out.println("<><><> Getting from Couch...");
				return fromCouch(((org.openntf.redomino.couch.Session)beObject).getInternational(), International.SCHEMA, this);
			}
			return fromLotus(getDelegate().getInternational(), International.SCHEMA, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e, this);
			return null;

		}
	}

	@Override
	public String getNotesVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgDirectoryPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlatform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyBroker getPropertyBroker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSessionToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSessionToken(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getURLDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<org.openntf.domino.Name> getUserGroupNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<org.openntf.domino.Name> getUserNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Name getUserNameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getUserPolicySettings(String server, String name, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getUserPolicySettings(String server, String name, int type, String explicitPolicy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hashPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConvertMime() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConvertMIME() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRestricted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrackMillisecInJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrustedSession() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetUserPassword(String serverName, String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetUserPassword(String serverName, String userName, String password, int downloadCount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Base<?> resolve(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendConsoleCommand(String serverName, String consoleCommand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllowLoopBack(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConvertMime(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConvertMIME(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnvironmentVar(String vname, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnvironmentVar(String vname, Object value, boolean isSystem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTrackMillisecInJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verifyPassword(String password, String hashedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void resurrect() {
		// TODO Auto-generated method stub

	}

	@Override
	public final WrapperFactory getFactory() {
		System.out.println("<><><> Returning factory: " + parent);
		return parent;
	}
	
	public final boolean isCouch() {
		return Factory.SessionType.isCouchSession(sessionType_);
	}
}
