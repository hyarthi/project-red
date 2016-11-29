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
//import org.openntf.red.events.IDominoListener;
import org.openntf.red.schema.IDatabaseSchema;
import org.openntf.red.transactions.IDatabaseTransaction;
import org.openntf.red.util.AutoMime;
import org.openntf.red.util.HexConverter;

//import lotus.domino.NotesException;
import lotus.notes.addins.DominoServer;

/**
 * @author Vladimir Kornienko
 *
 */
public class Database extends Base<org.openntf.red.Session> implements org.openntf.red.Database {
	
	private static Logger log = Logger.getLogger(Database.class.getName());

	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Database beObject;
	private String dbPath;
	
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	protected Database(org.openntf.red.impl.Session _parent, String dbpath, org.openntf.red.nsf.endpoint.Database _beObject) {
		// TODO Auto-generated constructor stub
		super(_parent, Base.NOTES_DATABASE);
		dbPath = dbpath;
		beObject = _beObject;
		log.finest("API Database finished init...");
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
	 * @see org.openntf.red.types.SessionDescendant#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
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
	 * @see org.openntf.red.Database#getACLActivityLog()
	 */
	@Override
	public Vector<String> getACLActivityLog() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compact()
	 */
	@Override
	public int compact() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compactWithOptions(int)
	 */
	@Override
	public int compactWithOptions(int options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compactWithOptions(int, java.lang.String)
	 */
	@Override
	public int compactWithOptions(int options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compactWithOptions(java.lang.String)
	 */
	@Override
	public int compactWithOptions(String options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createCopy(java.lang.String, java.lang.String)
	 */
	@Override
	public org.openntf.red.Database createCopy(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createCopy(java.lang.String, java.lang.String, int)
	 */
	@Override
	public org.openntf.red.Database createCopy(String server, String dbFile, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createDocument()
	 */
	@Override
	public Document createDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createDocumentCollection()
	 */
	@Override
	public DocumentCollection createDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createFromTemplate(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public org.openntf.red.Database createFromTemplate(String server, String dbFile, boolean inherit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createFromTemplate(java.lang.String, java.lang.String, boolean, int)
	 */
	@Override
	public org.openntf.red.Database createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createFTIndex(int, boolean)
	 */
	@Override
	public void createFTIndex(int options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createNoteCollection(boolean)
	 */
	@Override
	public NoteCollection createNoteCollection(boolean selectAllFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createOutline(java.lang.String)
	 */
	@Override
	public Outline createOutline(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createOutline(java.lang.String, boolean)
	 */
	@Override
	public Outline createOutline(String name, boolean defaultOutline) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createQueryView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createQueryView(String viewName, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createReplica(java.lang.String, java.lang.String)
	 */
	@Override
	public org.openntf.red.Database createReplica(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createView()
	 */
	@Override
	public View createView() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createView(java.lang.String)
	 */
	@Override
	public View createView(String viewName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createView(String viewName, String selectionFormula) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView,
			boolean prohibitDesignRefresh) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#enableFolder(java.lang.String)
	 */
	@Override
	public void enableFolder(String folder) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#fixup()
	 */
	@Override
	public void fixup() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#fixup(int)
	 */
	@Override
	public void fixup(int options) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTDomainSearch(java.lang.String, int, int, int, int, int, java.lang.String)
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, int sortOpt, int otherOpt, int start, int count,
			String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearch(java.lang.String)
	 */
	@Override
	public DocumentCollection FTSearch(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearch(java.lang.String, int)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearch(java.lang.String, int, int, int)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, int sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearch(java.lang.String, int, org.openntf.red.Database.FTSortOption, int)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearchRange(java.lang.String, int, int, int, int)
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearchRange(java.lang.String, int, org.openntf.red.Database.FTSortOption, int, int)
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt, int otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getACL()
	 */
	@Override
	public ACL getACL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAgent(java.lang.String)
	 */
	@Override
	public Agent getAgent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAgents()
	 */
	@Override
	public Vector<Agent> getAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAllDocuments()
	 */
	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAllReadDocuments()
	 */
	@Override
	public DocumentCollection getAllReadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAllReadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllReadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAllUnreadDocuments()
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAllUnreadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getCategories()
	 */
	@Override
	public String getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getCreated()
	 */
	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getCurrentAccessLevel()
	 */
	@Override
	public int getCurrentAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDB2Schema()
	 */
	@Override
	public String getDB2Schema() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDesignTemplateName()
	 */
	@Override
	public String getDesignTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByID(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByID(String noteid) {
		org.openntf.red.nsf.endpoint.View view = beObject.getIDTableView();
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = view.getAllEntriesByKey(HexConverter.toInteger(noteid), true);
		org.openntf.red.nsf.endpoint.ViewEntry entry = vecoll.getFirstEntry();
		String unid = entry.getDocumentUNID();
		return getDocumentByUNID(unid);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByUNID(java.lang.String)
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

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByURL(java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByURL(java.lang.String, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload, boolean reloadIfModified, boolean urlList,
			String charSet, String webUser, String webPassword, String proxyUser, String proxyPassword,
			boolean returnImmediately) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getFileFormat()
	 */
	@Override
	public int getFileFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getFileName()
	 */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getFilePath()
	 */
	@Override
	public String getFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getFolderReferencesEnabled()
	 */
	@Override
	public boolean getFolderReferencesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getForm(java.lang.String)
	 */
	@Override
	public Form getForm(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getForms()
	 */
	@Override
	public Vector<Form> getForms() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getFTIndexFrequency()
	 */
	@Override
	public int getFTIndexFrequency() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getHttpURL()
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastFixup()
	 */
	@Override
	public DateTime getLastFixup() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastFTIndexed()
	 */
	@Override
	public DateTime getLastFTIndexed() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastModified()
	 */
	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLimitRevisions()
	 */
	@Override
	public double getLimitRevisions() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLimitUpdatedBy()
	 */
	@Override
	public double getLimitUpdatedBy() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getListInDbCatalog()
	 */
	@Override
	public boolean getListInDbCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getManagers()
	 */
	@Override
	public Vector<String> getManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getMaxSize()
	 */
	@Override
	public long getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments()
	 */
	@Override
	public DocumentCollection getModifiedDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments(lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments(lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, int noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getNotesURL()
	 */
	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getOption(int)
	 */
	@Override
	public boolean getOption(int optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getOutline(java.lang.String)
	 */
	@Override
	public Outline getOutline(String outlineName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getParent()
	 */
	@Override
	public Session getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getPercentUsed()
	 */
	@Override
	public double getPercentUsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getProfileDocCollection(java.lang.String)
	 */
	@Override
	public DocumentCollection getProfileDocCollection(String profileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getProfileDocument(java.lang.String, java.lang.String)
	 */
	@Override
	public Document getProfileDocument(String profileName, String profileKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getReplicaID()
	 */
	@Override
	public String getReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getReplicationInfo()
	 */
	@Override
	public Replication getReplicationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getServer()
	 */
	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getSize()
	 */
	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getSizeQuota()
	 */
	@Override
	public int getSizeQuota() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getSizeWarning()
	 */
	@Override
	public long getSizeWarning() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getTemplateName()
	 */
	@Override
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getTitle()
	 */
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getType()
	 */
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getUndeleteExpireTime()
	 */
	@Override
	public int getUndeleteExpireTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getURL()
	 */
	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getURLHeaderInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getURLHeaderInfo(String url, String header, String webUser, String webPassword, String proxyUser,
			String proxyPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getView(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public View getView(String name) {
		org.openntf.red.nsf.endpoint.View view = beObject.getView(name);
		if (null == view)
			return null;
		
		return new org.openntf.red.impl.View(this, name, view);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getViews()
	 */
	@Override
	public Vector<View> getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#grantAccess(java.lang.String, int)
	 */
	@Override
	public void grantAccess(String name, int level) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isAllowOpenSoftDeleted()
	 */
	@Override
	public boolean isAllowOpenSoftDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isClusterReplication()
	 */
	@Override
	public boolean isClusterReplication() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isConfigurationDirectory()
	 */
	@Override
	public boolean isConfigurationDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isCurrentAccessPublicReader()
	 */
	@Override
	public boolean isCurrentAccessPublicReader() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isCurrentAccessPublicWriter()
	 */
	@Override
	public boolean isCurrentAccessPublicWriter() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isDB2()
	 */
	@Override
	public boolean isDB2() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isDelayUpdates()
	 */
	@Override
	public boolean isDelayUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isDesignLockingEnabled()
	 */
	@Override
	public boolean isDesignLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isDirectoryCatalog()
	 */
	@Override
	public boolean isDirectoryCatalog() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isDocumentLockingEnabled()
	 */
	@Override
	public boolean isDocumentLockingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isFTIndexed()
	 */
	@Override
	public boolean isFTIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isInMultiDbIndexing()
	 */
	@Override
	public boolean isInMultiDbIndexing() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isInService()
	 */
	@Override
	public boolean isInService() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isLink()
	 */
	@Override
	public boolean isLink() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isMultiDbSearch()
	 */
	@Override
	public boolean isMultiDbSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isOpen()
	 */
	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isPendingDelete()
	 */
	@Override
	public boolean isPendingDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isPrivateAddressBook()
	 */
	@Override
	public boolean isPrivateAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isPublicAddressBook()
	 */
	@Override
	public boolean isPublicAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#markForDelete()
	 */
	@Override
	public void markForDelete() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#open()
	 */
	@Override
	public boolean open() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#openByReplicaID(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean openByReplicaID(String server, String replicaId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#openIfModified(java.lang.String, java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public boolean openIfModified(String server, String dbFile, lotus.domino.DateTime modifiedSince) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#openWithFailover(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean openWithFailover(String server, String dbFile) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#queryAccess(java.lang.String)
	 */
	@Override
	public int queryAccess(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#queryAccessPrivileges(java.lang.String)
	 */
	@Override
	public int queryAccessPrivileges(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#queryAccessRoles(java.lang.String)
	 */
	@Override
	public Vector<String> queryAccessRoles(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#removeFTIndex()
	 */
	@Override
	public void removeFTIndex() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#replicate(java.lang.String)
	 */
	@Override
	public boolean replicate(String server) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#revokeAccess(java.lang.String)
	 */
	@Override
	public void revokeAccess(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#search(java.lang.String)
	 */
	@Override
	public DocumentCollection search(String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#search(java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#search(java.lang.String, lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setAllowOpenSoftDeleted(boolean)
	 */
	@Override
	public void setAllowOpenSoftDeleted(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setCategories(java.lang.String)
	 */
	@Override
	public void setCategories(String categories) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setDelayUpdates(boolean)
	 */
	@Override
	public void setDelayUpdates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setDesignLockingEnabled(boolean)
	 */
	@Override
	public void setDesignLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setDocumentLockingEnabled(boolean)
	 */
	@Override
	public void setDocumentLockingEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setFolderReferencesEnabled(boolean)
	 */
	@Override
	public void setFolderReferencesEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setFTIndexFrequency(int)
	 */
	@Override
	public void setFTIndexFrequency(int frequency) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setInMultiDbIndexing(boolean)
	 */
	@Override
	public void setInMultiDbIndexing(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setInService(boolean)
	 */
	@Override
	public void setInService(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setLimitRevisions(double)
	 */
	@Override
	public void setLimitRevisions(double revisions) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setLimitUpdatedBy(double)
	 */
	@Override
	public void setLimitUpdatedBy(double updatedBys) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setListInDbCatalog(boolean)
	 */
	@Override
	public void setListInDbCatalog(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setOption(int, boolean)
	 */
	@Override
	public void setOption(int optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setSizeQuota(int)
	 */
	@Override
	public void setSizeQuota(int quota) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setSizeWarning(int)
	 */
	@Override
	public void setSizeWarning(int warning) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setUndeleteExpireTime(int)
	 */
	@Override
	public void setUndeleteExpireTime(int hours) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign()
	 */
	@Override
	public void sign() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(int)
	 */
	@Override
	public void sign(int documentType) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(int, boolean)
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(int, boolean, java.lang.String)
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(int, boolean, java.lang.String, boolean)
	 */
	@Override
	public void sign(int documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#updateFTIndex(boolean)
	 */
	@Override
	public void updateFTIndex(boolean create) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getEventFactory()
	 */
	@Override
	public IDominoEventFactory getEventFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setEventFactory(org.openntf.red.events.IDominoEventFactory)
	 */
	@Override
	public void setEventFactory(IDominoEventFactory factory) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#generateEvent(org.openntf.red.events.EnumEvent, org.openntf.red.Base, java.lang.Object)
	 */
	@Override
	public IDominoEvent generateEvent(EnumEvent event, org.openntf.red.Base source, Object payload) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createMergeableDocumentCollection()
	 */
	@Override
	public DocumentCollection createMergeableDocumentCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getApiPath()
	 */
	@Override
	public String getApiPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compactWithOptions(java.util.Set)
	 */
	@Override
	public int compactWithOptions(Set<CompactOption> options) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#compactWithOptions(java.util.Set, java.lang.String)
	 */
	@Override
	public int compactWithOptions(Set<CompactOption> options, String spaceThreshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createDocument(java.lang.Object[])
	 */
	@Override
	public Document createDocument(Object... keyValuePairs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#createFTIndex(java.util.Set, boolean)
	 */
	@Override
	public void createFTIndex(Set<FTIndexOption> options, boolean recreate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#fixup(java.util.Set)
	 */
	@Override
	public void fixup(Set<FixupOption> options) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTDomainSearch(java.lang.String, int, org.openntf.red.Database.FTDomainSortOption, java.util.Set, int, int, java.lang.String)
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt,
			Set<FTDomainSearchOption> otherOpt, int start, int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTDomainSearch(java.lang.String, int, org.openntf.red.Database.FTDomainSortOption, int, int, int, java.lang.String)
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt, int otherOpt, int start,
			int count, String entryForm) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearch(java.lang.String, int, org.openntf.red.Database.FTSortOption, java.util.Set)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, Set<FTSearchOption> otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#FTSearchRange(java.lang.String, int, org.openntf.red.Database.FTSortOption, java.util.Set, int)
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt,
			Set<FTSearchOption> otherOpt, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDesign()
	 */
	@Override
	public DatabaseDesign getDesign() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getXPageSharedDesignTemplate()
	 */
	@Override
	public org.openntf.red.Database getXPageSharedDesignTemplate() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentWithKey(java.io.Serializable)
	 */
	@Override
	public Document getDocumentWithKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByKey(java.io.Serializable)
	 */
	@Override
	public Document getDocumentByKey(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByKey(java.io.Serializable, boolean)
	 */
	@Override
	public Document getDocumentByKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentWithKey(java.io.Serializable, boolean)
	 */
	@Override
	public Document getDocumentWithKey(Serializable key, boolean createOnFail) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments(lotus.domino.DateTime, org.openntf.red.Database.ModifiedDocClass)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments(java.util.Date, org.openntf.red.Database.ModifiedDocClass)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(Date since, ModifiedDocClass noteClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedDocuments(java.util.Date)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(Date since) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedNoteCount(java.util.Date, java.util.Set)
	 */
	@Override
	public int getModifiedNoteCount(Date since, Set<SelectOption> noteClass) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getModifiedNoteCount(java.util.Date)
	 */
	@Override
	public int getModifiedNoteCount(Date since) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastModifiedDate()
	 */
	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastFixupDate()
	 */
	@Override
	public Date getLastFixupDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLastFTIndexedDate()
	 */
	@Override
	public Date getLastFTIndexedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getOption(org.openntf.red.Database.DBOption)
	 */
	@Override
	public boolean getOption(DBOption optionName) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#grantAccess(java.lang.String, org.openntf.red.ACL.Level)
	 */
	@Override
	public void grantAccess(String name, Level level) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setFTIndexFrequency(org.openntf.red.Database.FTIndexFrequency)
	 */
	@Override
	public void setFTIndexFrequency(FTIndexFrequency frequency) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setOption(org.openntf.red.Database.DBOption, boolean)
	 */
	@Override
	public void setOption(DBOption optionName, boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(org.openntf.red.Database.SignDocType)
	 */
	@Override
	public void sign(SignDocType documentType) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(org.openntf.red.Database.SignDocType, boolean)
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(org.openntf.red.Database.SignDocType, boolean, java.lang.String)
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#sign(org.openntf.red.Database.SignDocType, boolean, java.lang.String, boolean)
	 */
	@Override
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#startTransaction()
	 */
	@Override
	public IDatabaseTransaction startTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#closeTransaction()
	 */
	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getTransaction()
	 */
	@Override
	public IDatabaseTransaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getUNID(java.lang.String)
	 */
	@Override
	public String getUNID(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getUNID(int)
	 */
	@Override
	public String getUNID(int noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentByID(int, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByID(int noteid) {
		log.finest("Database: looking for noteid " + noteid);
		org.openntf.red.nsf.endpoint.View view = beObject.getIDTableView();
		if (null == view) return null;
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = view.getAllEntriesByKey(Integer.valueOf(noteid), true);
		if (null == vecoll) return null;
		org.openntf.red.nsf.endpoint.ViewEntry entry = vecoll.getFirstEntry();
		if (null == entry) return null;
		String unid = entry.getDocumentUNID();
		// TODO add exception throws around here, because it's the core views impacted
		log.finest("Got UNID: " + unid);
		return getDocumentByUNID(unid);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setTransaction(org.openntf.red.transactions.IDatabaseTransaction)
	 */
	@Override
	public void setTransaction(IDatabaseTransaction txn) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDominoServer()
	 */
	@Override
	public DominoServer getDominoServer() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#refreshDesign()
	 */
	@Override
	public void refreshDesign() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#openMail()
	 */
	@Override
	public void openMail() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getMail()
	 */
	@Override
	public org.openntf.red.Database getMail() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getDocumentMap()
	 */
	@Override
	public Map<Serializable, Document> getDocumentMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getSchema()
	 */
	@Override
	public IDatabaseSchema getSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setSchema(org.openntf.red.schema.IDatabaseSchema)
	 */
	@Override
	public void setSchema(IDatabaseSchema schema) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#isReplicationDisabled()
	 */
	@Override
	public boolean isReplicationDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getHttpURL(boolean)
	 */
	@Override
	public String getHttpURL(boolean usePath) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getAutoMime()
	 */
	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#setAutoMime(org.openntf.red.util.AutoMime)
	 */
	@Override
	public void setAutoMime(AutoMime autoMime) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getLocale()
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getMetaReplicaID()
	 */
	@Override
	public String getMetaReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getTypeEx()
	 */
	@Override
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Database#getView(org.openntf.red.Document)
	 */
	@Override
	public View getView(Document viewDocument) {
		// TODO Auto-generated method stub
		return null;
	}

}
