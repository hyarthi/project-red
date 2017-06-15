/**
 * 
 */
package org.openntf.red.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.ACL;
import org.openntf.red.ACL.Level;
import org.openntf.red.Agent;
import org.openntf.red.DateTime;
import org.openntf.red.Document;
import org.openntf.red.DocumentCollection;
import org.openntf.red.Form;
import org.openntf.red.NoteCollection;
import org.openntf.red.NoteCollection.SelectOption;
import org.openntf.red.Outline;
import org.openntf.red.Replication;
import org.openntf.red.Session;
import org.openntf.red.View;
import org.openntf.red.design.DatabaseDesign;
import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoEventFactory;
import org.openntf.red.nsf.endpoint.Note;
//import org.openntf.red.events.IDominoListener;
import org.openntf.red.schema.IDatabaseSchema;
import org.openntf.red.transactions.IDatabaseTransaction;
import org.openntf.red.util.AutoMime;
import org.openntf.red.util.HexConverter;

//import lotus.domino.NotesException;
import lotus.notes.addins.DominoServer;

/**
 * Entity representing a database.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.Database
 */
public class Database extends Base<org.openntf.red.Session> implements org.openntf.red.Database {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(Database.class.getName());
	/** Back-end object. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Database beObject;
	/** Path to the database (relative to "server data root"). */
	private String dbPath;

	/**
	 * Default constructor.
	 * 
	 * @param _parent
	 *            Parent session.
	 * @param dbpath
	 *            Path to the database.
	 * @param _beObject
	 *            Back-end object used to manipulate data.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	protected Database(org.openntf.red.impl.Session _parent, String dbpath,
			org.openntf.red.nsf.endpoint.Database _beObject) {
		// TODO Auto-generated constructor stub
		super(_parent, Base.NOTES_DATABASE);
		dbPath = dbpath;
		beObject = _beObject;
		log.finest("API Database finished init...");
	}

	/**
	 * Unused. Under consideration.
	 */
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the ancestor session.
	 * 
	 * @return Ancestor session
	 * @since 0.4.0
	 */
	@Override
	public Session getAncestorSession() {
		return parent;
	}

	/**
	 * Unused. Under consideration.
	 */
	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Unused. Under consideration.
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * Unused. Under consideration.
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getACLActivityLog() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compact() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compactWithOptions(int options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compactWithOptions(int options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compactWithOptions(String options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database createCopy(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database createCopy(String server, String dbFile, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates a new document within this database.
	 * 
	 * @return New document
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document createDocument() {
		Note note = beObject.createNote(false);
		if (null == note)
			return null;

		// TODO Auto-generated method stub
		return new org.openntf.red.impl.Document(this, note);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection createDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database createFromTemplate(String server, String dbFile, boolean inherit) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void createFTIndex(int options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public NoteCollection createNoteCollection(boolean selectAllFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Outline createOutline(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Outline createOutline(String name, boolean defaultOutline) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createQueryView(String viewName, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database createReplica(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createView(String viewName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createView(String viewName, String selectionFormula) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void enableFolder(String folder) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void fixup() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void fixup(int options) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, int sortOpt, int otherOpt, int start, int count,
			String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearch(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, int sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ACL getACL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Agent getAgent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Agent> getAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllReadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllReadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getCurrentAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getDB2Schema() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getDesignTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a document by Note ID.
	 * 
	 * @param noteid
	 *            Note ID
	 * @return Existing document or <code>NULL</code>
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByID(String noteid) {
		org.openntf.red.nsf.endpoint.View view = beObject.getIDTableView();
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = view
				.getAllEntriesByKey(HexConverter.toInteger(noteid), true);
		org.openntf.red.nsf.endpoint.ViewEntry entry = vecoll.getFirstEntry();
		String unid = entry.getDocumentUNID();
		return getDocumentByUNID(unid);
	}

	/**
	 * Returns a document by UNID.
	 * 
	 * @param unid
	 *            UNID
	 * @return Existing document or <code>NULL</code>
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByUNID(String unid) {
		// TODO Auto-generated method stub
		log.finest("Getting document by unid " + unid);
		org.openntf.red.nsf.endpoint.Note note = beObject.getNoteByUNID(unid);
		if (null == note)
			return null;

		return new org.openntf.red.impl.Document(this, note);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload, boolean reloadIfModified, boolean urlList,
			String charSet, String webUser, String webPassword, String proxyUser, String proxyPassword,
			boolean returnImmediately) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getFileFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getFolderReferencesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Form getForm(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Form> getForms() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getFTIndexFrequency() {
		// TODO Auto-generated method stub
		return 0;
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
	public DateTime getLastFixup() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getLastFTIndexed() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getLimitRevisions() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getLimitUpdatedBy() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getListInDbCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public long getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, int noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getOption(int optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Outline getOutline(String outlineName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the parent (Session).
	 * 
	 * @return Parent session
	 * @since 0.4.0
	 */
	@Override
	public Session getParent() {
		return parent;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getPercentUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getProfileDocCollection(String profileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getProfileDocument(String profileName, String profileKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Replication getReplicationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getSizeQuota() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public long getSizeWarning() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getUndeleteExpireTime() {
		// TODO Auto-generated method stub
		return 0;
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
	public String getURLHeaderInfo(String url, String header, String webUser, String webPassword, String proxyUser,
			String proxyPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a view handler object for a view name.
	 * 
	 * @param name
	 *            View name
	 * @return View handler object
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public View getView(String name) {
		org.openntf.red.nsf.endpoint.View view = beObject.getView(name);
		if (null == view)
			return null;

		return new org.openntf.red.impl.View(this, name, view);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<View> getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void grantAccess(String name, int level) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAllowOpenSoftDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isClusterReplication() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isConfigurationDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isCurrentAccessPublicReader() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isCurrentAccessPublicWriter() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDB2() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDelayUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDesignLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDirectoryCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDocumentLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isFTIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isInMultiDbIndexing() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isInService() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isLink() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isMultiDbSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPendingDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPrivateAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPublicAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markForDelete() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean open() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean openByReplicaID(String server, String replicaId) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean openIfModified(String server, String dbFile, lotus.domino.DateTime modifiedSince) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean openWithFailover(String server, String dbFile) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int queryAccess(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int queryAccessPrivileges(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> queryAccessRoles(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeFTIndex() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean replicate(String server) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void revokeAccess(String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection search(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setAllowOpenSoftDeleted(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setCategories(String categories) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setDelayUpdates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setDesignLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setDocumentLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setFolderReferencesEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setFTIndexFrequency(int frequency) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setInMultiDbIndexing(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setInService(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setLimitRevisions(double revisions) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setLimitUpdatedBy(double updatedBys) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setListInDbCatalog(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setOption(int optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSizeQuota(int quota) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSizeWarning(int warning) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setUndeleteExpireTime(int hours) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(int documentType) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void updateFTIndex(boolean create) {
		// TODO Auto-generated method stub

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
	@Override
	public IDominoEvent generateEvent(EnumEvent event, org.openntf.red.Base source, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection createMergeableDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getApiPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compactWithOptions(Set<CompactOption> options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int compactWithOptions(Set<CompactOption> options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document createDocument(Object... keyValuePairs) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void createFTIndex(Set<FTIndexOption> options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void fixup(Set<FixupOption> options) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt,
			Set<FTDomainSearchOption> otherOpt, int start, int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt, int otherOpt, int start,
			int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, Set<FTSearchOption> otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt,
			Set<FTSearchOption> otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DatabaseDesign getDesign() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database getXPageSharedDesignTemplate() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentWithKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentWithKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments(Date since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getModifiedDocuments(Date since) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getModifiedNoteCount(Date since, Set<SelectOption> noteClass) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getModifiedNoteCount(Date since) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getLastFixupDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getLastFTIndexedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getOption(DBOption optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void grantAccess(String name, Level level) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setFTIndexFrequency(FTIndexFrequency frequency) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setOption(DBOption optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(SignDocType documentType) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IDatabaseTransaction startTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IDatabaseTransaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getUNID(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getUNID(int noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByID(int noteid) {
		log.finest("Database: looking for noteid " + noteid);
		org.openntf.red.nsf.endpoint.View view = beObject.getIDTableView();
		if (null == view)
			return null;
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = view.getAllEntriesByKey(Integer.valueOf(noteid),
				true);
		if (null == vecoll)
			return null;
		org.openntf.red.nsf.endpoint.ViewEntry entry = vecoll.getFirstEntry();
		if (null == entry)
			return null;
		String unid = entry.getDocumentUNID();
		// TODO add exception throws around here, because it's the core views
		// impacted
		log.finest("Got UNID: " + unid);
		return getDocumentByUNID(unid);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setTransaction(IDatabaseTransaction txn) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DominoServer getDominoServer() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void refreshDesign() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void openMail() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Database getMail() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Map<Serializable, Document> getDocumentMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IDatabaseSchema getSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSchema(IDatabaseSchema schema) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isReplicationDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getHttpURL(boolean usePath) {
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
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getMetaReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View getView(Document viewDocument) {
		// TODO Auto-generated method stub
		return null;
	}

}
