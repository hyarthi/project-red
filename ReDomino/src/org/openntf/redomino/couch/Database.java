/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;
import java.util.logging.Logger;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class Database implements lotus.domino.Database, CouchBase {

	private static final Logger log_ = Logger.getLogger(Session.class.getName());

	private String serverPath;
	private String dbPath;
	private String dbFilePath;
	private WebTarget target;
	// not sure i need this. it's already implemented in impl wrapper
	private Session parent;

	/**
	 * 
	 * @param _serverPath
	 * @param _dbFilePath
	 * @param _target
	 */
	Database(String _serverPath, String _dbFilePath, WebTarget _target, Session _parent) {
		serverPath = _serverPath;
		dbFilePath = _dbFilePath;
		target = _target;
		dbPath = target.getUri().toString();
		parent = _parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub
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
	 * @see lotus.domino.Database#FTDomainSearch(java.lang.String, int, int,
	 * int, int, int, java.lang.String)
	 */
	@Override
	public lotus.domino.Document FTDomainSearch(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5,
			String arg6) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String)
	 */
	@Override
	public DocumentCollection FTSearch(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int)
	 */
	@Override
	public DocumentCollection FTSearch(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int, int, int)
	 */
	@Override
	public DocumentCollection FTSearch(String arg0, int arg1, int arg2, int arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearchRange(java.lang.String, int, int, int,
	 * int)
	 */
	@Override
	public DocumentCollection FTSearchRange(String arg0, int arg1, int arg2, int arg3, int arg4) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compact()
	 */
	@Override
	public int compact() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(java.lang.String)
	 */
	@Override
	public int compactWithOptions(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int)
	 */
	@Override
	public int compactWithOptions(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int, java.lang.String)
	 */
	@Override
	public int compactWithOptions(int arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String)
	 */
	@Override
	public lotus.domino.Database createCopy(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String,
	 * int)
	 */
	@Override
	public lotus.domino.Database createCopy(String arg0, String arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocument()
	 */
	@Override
	public lotus.domino.Document createDocument() throws NotesException {
		lotus.domino.Document doc = new Document(null, this, new JsonJavaObject());
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocumentCollection()
	 */
	@Override
	public DocumentCollection createDocumentCollection() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFTIndex(int, boolean)
	 */
	@Override
	public void createFTIndex(int arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String,
	 * java.lang.String, boolean)
	 */
	@Override
	public lotus.domino.Database createFromTemplate(String arg0, String arg1, boolean arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String,
	 * java.lang.String, boolean, int)
	 */
	@Override
	public lotus.domino.Database createFromTemplate(String arg0, String arg1, boolean arg2, int arg3)
			throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createNoteCollection(boolean)
	 */
	@Override
	public NoteCollection createNoteCollection(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String)
	 */
	@Override
	public Outline createOutline(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String, boolean)
	 */
	@Override
	public Outline createOutline(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public View createQueryView(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createQueryView(String arg0, String arg1, lotus.domino.View arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createQueryView(String arg0, String arg1, lotus.domino.View arg2, boolean arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createReplica(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public lotus.domino.Database createReplica(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView()
	 */
	@Override
	public View createView() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String)
	 */
	@Override
	public View createView(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createView(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String,
	 * lotus.domino.View)
	 */
	@Override
	public View createView(String arg0, String arg1, lotus.domino.View arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String,
	 * lotus.domino.View, boolean)
	 */
	@Override
	public View createView(String arg0, String arg1, lotus.domino.View arg2, boolean arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#enableFolder(java.lang.String)
	 */
	@Override
	public void enableFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup()
	 */
	@Override
	public void fixup() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup(int)
	 */
	@Override
	public void fixup(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getACL()
	 */
	@Override
	public ACL getACL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getACLActivityLog()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getACLActivityLog() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgent(java.lang.String)
	 */
	@Override
	public Agent getAgent(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgents()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getAgents() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllDocuments()
	 */
	@Override
	public DocumentCollection getAllDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments()
	 */
	@Override
	public DocumentCollection getAllReadDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllReadDocuments(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments()
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCategories()
	 */
	@Override
	public String getCategories() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCreated()
	 */
	@Override
	public DateTime getCreated() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCurrentAccessLevel()
	 */
	@Override
	public int getCurrentAccessLevel() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDB2Schema()
	 */
	@Override
	public String getDB2Schema() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDesignTemplateName()
	 */
	@Override
	public String getDesignTemplateName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param id
	 *            String ID of the document
	 * @return CouchDB Document object, null if the document was not found
	 * @see {@link Document}
	 */
	@Override
	public lotus.domino.Document getDocumentByID(String id) throws NotesException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByUNID(java.lang.String)
	 */
	@Override
	public lotus.domino.Document getDocumentByUNID(String id) throws NotesException {
		if (null == target)
			return null;
		if (null == id)
			return null;

		WebTarget docTarget;
		Response response;
		JsonJavaObject body;

		docTarget = target.path(id);
		response = docTarget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).get();
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			// document not there
			response.close();
			return null;
		}
		body = response.readEntity(JsonJavaObject.class);

		return new Document(docTarget, this, body);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean)
	 */
	@Override
	public lotus.domino.Document getDocumentByURL(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean,
	 * boolean, boolean, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public lotus.domino.Document getDocumentByURL(String arg0, boolean arg1, boolean arg2, boolean arg3, String arg4,
			String arg5, String arg6, String arg7, String arg8, boolean arg9) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFTIndexFrequency()
	 */
	@Override
	public int getFTIndexFrequency() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileFormat()
	 */
	@Override
	public int getFileFormat() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileName()
	 */
	@Override
	public String getFileName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFilePath()
	 */
	@Override
	public String getFilePath() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFolderReferencesEnabled()
	 */
	@Override
	public boolean getFolderReferencesEnabled() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForm(java.lang.String)
	 */
	@Override
	public Form getForm(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForms()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getForms() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getHttpURL()
	 */
	@Override
	public String getHttpURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFTIndexed()
	 */
	@Override
	public DateTime getLastFTIndexed() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFixup()
	 */
	@Override
	public DateTime getLastFixup() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastModified()
	 */
	@Override
	public DateTime getLastModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitRevisions()
	 */
	@Override
	public double getLimitRevisions() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitUpdatedBy()
	 */
	@Override
	public double getLimitUpdatedBy() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getListInDbCatalog()
	 */
	@Override
	public boolean getListInDbCatalog() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getManagers()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getManagers() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getMaxSize()
	 */
	@Override
	public long getMaxSize() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments()
	 */
	@Override
	public DocumentCollection getModifiedDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime,
	 * int)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getNotesURL()
	 */
	@Override
	public String getNotesURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOption(int)
	 */
	@Override
	public boolean getOption(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOutline(java.lang.String)
	 */
	@Override
	public Outline getOutline(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getParent()
	 */
	@Override
	public Session getParent() throws NotesException {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getPercentUsed()
	 */
	@Override
	public double getPercentUsed() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocCollection(java.lang.String)
	 */
	@Override
	public DocumentCollection getProfileDocCollection(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocument(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public lotus.domino.Document getProfileDocument(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicaID()
	 */
	@Override
	public String getReplicaID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicationInfo()
	 */
	@Override
	public Replication getReplicationInfo() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getServer()
	 */
	@Override
	public String getServer() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSize()
	 */
	@Override
	public double getSize() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeQuota()
	 */
	@Override
	public int getSizeQuota() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeWarning()
	 */
	@Override
	public long getSizeWarning() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTemplateName()
	 */
	@Override
	public String getTemplateName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTitle()
	 */
	@Override
	public String getTitle() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getType()
	 */
	@Override
	public int getType() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURL()
	 */
	@Override
	public String getURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURLHeaderInfo(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getURLHeaderInfo(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5)
			throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getUndeleteExpireTime()
	 */
	@Override
	public int getUndeleteExpireTime() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getView(java.lang.String)
	 */
	@Override
	public View getView(String name) throws NotesException {
		if (null == target || null == name || name.isEmpty())
			return null;
		
		// TODO implement search by view human name
		WebTarget vtarget = target.path(FieldNames.DESIGN).path(FieldNames.VIEW_PREFIX + name);
		Response response = vtarget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE)
				.get();
		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			// document not there
			response.close();
			return null;
		}
		JsonJavaObject body = response.readEntity(JsonJavaObject.class);
		response.close();

		return new View(vtarget, this, name, body);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getViews()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getViews() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#grantAccess(java.lang.String, int)
	 */
	@Override
	public void grantAccess(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isAllowOpenSoftDeleted()
	 */
	@Override
	public boolean isAllowOpenSoftDeleted() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isClusterReplication()
	 */
	@Override
	public boolean isClusterReplication() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isConfigurationDirectory()
	 */
	@Override
	public boolean isConfigurationDirectory() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicReader()
	 */
	@Override
	public boolean isCurrentAccessPublicReader() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicWriter()
	 */
	@Override
	public boolean isCurrentAccessPublicWriter() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDB2()
	 */
	@Override
	public boolean isDB2() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDelayUpdates()
	 */
	@Override
	public boolean isDelayUpdates() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDesignLockingEnabled()
	 */
	@Override
	public boolean isDesignLockingEnabled() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDirectoryCatalog()
	 */
	@Override
	public boolean isDirectoryCatalog() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDocumentLockingEnabled()
	 */
	@Override
	public boolean isDocumentLockingEnabled() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isFTIndexed()
	 */
	@Override
	public boolean isFTIndexed() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInMultiDbIndexing()
	 */
	@Override
	public boolean isInMultiDbIndexing() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInService()
	 */
	@Override
	public boolean isInService() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isLink()
	 */
	@Override
	public boolean isLink() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isMultiDbSearch()
	 */
	@Override
	public boolean isMultiDbSearch() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isOpen()
	 */
	@Override
	public boolean isOpen() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPendingDelete()
	 */
	@Override
	public boolean isPendingDelete() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPrivateAddressBook()
	 */
	@Override
	public boolean isPrivateAddressBook() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPublicAddressBook()
	 */
	@Override
	public boolean isPublicAddressBook() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#markForDelete()
	 */
	@Override
	public void markForDelete() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#open()
	 */
	@Override
	public boolean open() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openByReplicaID(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean openByReplicaID(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openIfModified(java.lang.String,
	 * java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public boolean openIfModified(String arg0, String arg1, lotus.domino.DateTime arg2) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openWithFailover(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean openWithFailover(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccess(java.lang.String)
	 */
	@Override
	public int queryAccess(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessPrivileges(java.lang.String)
	 */
	@Override
	public int queryAccessPrivileges(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessRoles(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector queryAccessRoles(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#removeFTIndex()
	 */
	@Override
	public void removeFTIndex() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#replicate(java.lang.String)
	 */
	@Override
	public boolean replicate(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#revokeAccess(java.lang.String)
	 */
	@Override
	public void revokeAccess(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String)
	 */
	@Override
	public DocumentCollection search(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String,
	 * lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection search(String arg0, lotus.domino.DateTime arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String,
	 * lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection search(String arg0, lotus.domino.DateTime arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setAllowOpenSoftDeleted(boolean)
	 */
	@Override
	public void setAllowOpenSoftDeleted(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setCategories(java.lang.String)
	 */
	@Override
	public void setCategories(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDelayUpdates(boolean)
	 */
	@Override
	public void setDelayUpdates(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDesignLockingEnabled(boolean)
	 */
	@Override
	public void setDesignLockingEnabled(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDocumentLockingEnabled(boolean)
	 */
	@Override
	public void setDocumentLockingEnabled(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFTIndexFrequency(int)
	 */
	@Override
	public void setFTIndexFrequency(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFolderReferencesEnabled(boolean)
	 */
	@Override
	public void setFolderReferencesEnabled(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInMultiDbIndexing(boolean)
	 */
	@Override
	public void setInMultiDbIndexing(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInService(boolean)
	 */
	@Override
	public void setInService(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitRevisions(double)
	 */
	@Override
	public void setLimitRevisions(double arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitUpdatedBy(double)
	 */
	@Override
	public void setLimitUpdatedBy(double arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setListInDbCatalog(boolean)
	 */
	@Override
	public void setListInDbCatalog(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setOption(int, boolean)
	 */
	@Override
	public void setOption(int arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeQuota(int)
	 */
	@Override
	public void setSizeQuota(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeWarning(int)
	 */
	@Override
	public void setSizeWarning(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setUndeleteExpireTime(int)
	 */
	@Override
	public void setUndeleteExpireTime(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign()
	 */
	@Override
	public void sign() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int)
	 */
	@Override
	public void sign(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean)
	 */
	@Override
	public void sign(int arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String)
	 */
	@Override
	public void sign(int arg0, boolean arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String, boolean)
	 */
	@Override
	public void sign(int arg0, boolean arg1, String arg2, boolean arg3) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#updateFTIndex(boolean)
	 */
	@Override
	public void updateFTIndex(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	WebTarget getTarget() {
		return target;
	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}
}
