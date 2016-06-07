/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.openntf.domino.ACL;
import org.openntf.domino.ACL.Level;
import org.openntf.domino.Agent;
import org.openntf.domino.AutoMime;
import org.openntf.domino.Base;
import org.openntf.domino.Document;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Form;
import org.openntf.domino.NoteCollection;
import org.openntf.domino.NoteCollection.SelectOption;
import org.openntf.domino.Outline;
import org.openntf.domino.Replication;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.design.DatabaseDesign;
import org.openntf.domino.events.EnumEvent;
import org.openntf.domino.events.IDominoEvent;
import org.openntf.domino.events.IDominoEventFactory;
import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.helpers.DatabaseMetaData;
import org.openntf.domino.schema.IDatabaseSchema;
import org.openntf.domino.transactions.DatabaseTransaction;
import org.openntf.redomino.utils.Factory;
import org.openntf.domino.utils.DominoUtils;

import lotus.domino.DateTime;
import lotus.domino.NotesException;
import lotus.notes.addins.DominoServer;

/**
 * @author Vladimir Kornienko
 *
 */
public class Database extends BaseThreadSafe<org.openntf.domino.Database, lotus.domino.Database, Session>
		implements org.openntf.domino.Database {

	private String server_;
	private DatabaseMetaData shadowedMetaData_;
	private String path_;
	private transient String apiPath_;
	private transient String fileName_;
	private String replid_;

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Database(lotus.domino.Database delegate, Session parent) {
		super(delegate, parent, NOTES_DATABASE);
		// TODO Auto-generated constructor stub
	}

	protected Database(final Session parent, final DatabaseMetaData metaData) {
		super(null, parent, NOTES_DATABASE);
		initialize(metaData);
	}

	protected void initialize(final DatabaseMetaData metaData) {
		shadowedMetaData_ = metaData;
		server_ = metaData.getServer();
		path_ = metaData.getFilePath();
		replid_ = metaData.getReplicaID();
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
	public IDominoEvent generateEvent(EnumEvent event, Base<?> source, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection createMergeableDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApiPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compactWithOptions(Set<CompactOption> options) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(Set<CompactOption> options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createFTIndex(Set<FTIndexOption> options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixup(Set<FixupOption> options) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt,
			Set<FTDomainSearchOption> otherOpt, int start, int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt, int otherOpt, int start,
			int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, Set<FTSearchOption> otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt,
			Set<FTSearchOption> otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatabaseDesign getDesign() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Database getXPageSharedDesignTemplate() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentWithKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentWithKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getModifiedDocuments(DateTime since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getModifiedDocuments(Date since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getModifiedDocuments(Date since) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getModifiedNoteCount(Date since, Set<SelectOption> noteClass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getModifiedNoteCount(Date since) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastFixupDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastFTIndexedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getOption(DBOption optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFTIndexFrequency(FTIndexFrequency frequency) {
		// TODO Auto-generated method stub

	}

	@Override
	public DatabaseTransaction startTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public DatabaseTransaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUNID(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUNID(int noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByUNID(String unid, boolean deferDelegate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByID(String noteid, boolean deferDelegate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByID(int noteid, boolean deferDelegate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransaction(DatabaseTransaction txn) {
		// TODO Auto-generated method stub

	}

	@Override
	public DominoServer getDominoServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refreshDesign() {
		// TODO Auto-generated method stub

	}

	@Override
	public void openMail() {
		// TODO Auto-generated method stub

	}

	@Override
	public org.openntf.domino.Database getMail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Serializable, Document> getDocumentMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDatabaseSchema getSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchema(IDatabaseSchema schema) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReplicationDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHttpURL(boolean usePath) {
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
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetaReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView(Document viewDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		//System.out.println("<><><> Returning session: " + parent);
		return parent;
	}

	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<String> getACLActivityLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compact() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int options) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(String options) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public org.openntf.domino.Database createCopy(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Database createCopy(String server, String dbFile, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document createDocument() {
		Document result = null;
		if (null == beObject) {
			// Lotus object - follow ODA
			boolean go;
			go = !hasListeners() ? true : fireListener(generateEvent(Events.BEFORE_CREATE_DOCUMENT, this, null));
			if (go) {
				try {
					open();
					result = fromLotus(getDelegate().createDocument(), Document.SCHEMA, this);
				} catch (NotesException e) {
					DominoUtils.handleException(e, this);
				}
				if (hasListeners())
					fireListener(generateEvent(Events.AFTER_CREATE_DOCUMENT, this, null));
			}
		} else {
			// Couch object
			// TODO consider ODA logic (listeners?)
			try {
				result = fromCouch(((org.openntf.redomino.couch.Database) beObject).createDocument(), Document.SCHEMA,
						this);
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DominoUtils.handleException(e, this);
			}
		}
		return result;
	}

	@Override
	public Document createDocument(Object... keyValuePairs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection createDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Database createFromTemplate(String server, String dbFile, boolean inherit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Database createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFTIndex(int options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	@Override
	public NoteCollection createNoteCollection(boolean selectAllFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outline createOutline(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outline createOutline(String name, boolean defaultOutline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createQueryView(String viewName, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Database createReplica(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView(String viewName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView(String viewName, String selectionFormula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableFolder(String folder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixup(int options) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document FTDomainSearch(String query, int maxDocs, int sortOpt, int otherOpt, int start, int count,
			String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearch(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, int sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ACL getACL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent getAgent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Agent> getAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllReadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllReadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllUnreadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllUnreadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrentAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDB2Schema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDesignTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByID(String noteid) {
		// TODO Auto-generated method stub
		if (Factory.SessionType.isCouchSession(parent)) {
			try {
				// TODO additional checks?
				System.out.println("<><> Started wrapping...");
				return fromCouch(((org.openntf.redomino.couch.Database) beObject).getDocumentByID(noteid),
						Document.SCHEMA, this);
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// Lotus object - follow ODA
			try {
				if (!getDelegate().isOpen()) {
					getDelegate().open();
				}
				return fromLotus(getDelegate().getDocumentByID(noteid), Document.SCHEMA, this);
			} catch (Exception e) {
				DominoUtils.handleException(e, this, "NoteId=" + noteid);
				return null;

			}
		}
		return null;
	}

	@Override
	public Document getDocumentByUNID(String unid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByURL(String url, boolean reload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByURL(String url, boolean reload, boolean reloadIfModified, boolean urlList,
			String charSet, String webUser, String webPassword, String proxyUser, String proxyPassword,
			boolean returnImmediately) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFileFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFolderReferencesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form getForm(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Form> getForms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTIndexFrequency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DateTime getLastFixup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DateTime getLastFTIndexed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getLimitRevisions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLimitUpdatedBy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getListInDbCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<String> getManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocumentCollection getModifiedDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getModifiedDocuments(DateTime since) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getModifiedDocuments(DateTime since, int noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getOption(int optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Outline getOutline(String outlineName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPercentUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocumentCollection getProfileDocCollection(String profileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getProfileDocument(String profileName, String profileKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Replication getReplicationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeQuota() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSizeWarning() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUndeleteExpireTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURLHeaderInfo(String url, String header, String webUser, String webPassword, String proxyUser,
			String proxyPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView(String name) {
		try {
			if (null == beObject) {
				// Lotus object - follow ODA
				if (!getDelegate().isOpen()) {
					getDelegate().open();
				}
				View result = fromLotus(getDelegate().getView(name), View.SCHEMA, this);
				if (result != null) {
					if (getAncestorSession().isFixEnabled(Fixes.VIEW_UPDATE_OFF)) {
						result.setAutoUpdate(false);
					}
				}
				return result;
			} else {
				// Couch Object
				View result = fromCouch(((org.openntf.redomino.couch.Database) beObject).getView(name), View.SCHEMA,
						this);
				return result;
			}
		} catch (NotesException e) {
			DominoUtils.handleException(e, this);
			return null;

		}
	}

	@Override
	public Vector<View> getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void grantAccess(String name, int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void grantAccess(String name, Level level) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAllowOpenSoftDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isClusterReplication() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConfigurationDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrentAccessPublicReader() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrentAccessPublicWriter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDB2() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDelayUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDesignLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirectoryCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocumentLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFTIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInMultiDbIndexing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInService() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLink() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMultiDbSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPendingDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivateAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPublicAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void markForDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean open() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openByReplicaID(String server, String replicaId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openIfModified(String server, String dbFile, DateTime modifiedSince) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openWithFailover(String server, String dbFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int queryAccess(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryAccessPrivileges(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> queryAccessRoles(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFTIndex() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean replicate(String server) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void revokeAccess(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public DocumentCollection search(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection search(String formula, DateTime startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection search(String formula, DateTime startDate, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllowOpenSoftDeleted(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCategories(String categories) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDelayUpdates(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDesignLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFolderReferencesEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFTIndexFrequency(int frequency) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInMultiDbIndexing(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInService(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLimitRevisions(double revisions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLimitUpdatedBy(double updatedBys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListInDbCatalog(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOption(int optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOption(DBOption optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSizeQuota(int quota) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSizeWarning(int warning) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUndeleteExpireTime(int hours) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(SignDocType documentType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFTIndex(boolean create) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void resurrect() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		return parent.getFactory();
	}

}
