/**
 * 
 */
package org.openntf.redomino.couch;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openntf.redomino.couch.Item.Type;

import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.Base;
import lotus.domino.Database;
import lotus.domino.DateTime;
//import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import lotus.domino.EmbeddedObject;
import lotus.domino.MIMEEntity;
import lotus.domino.NotesException;
import lotus.domino.RichTextItem;
import lotus.domino.View;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class Document<P extends Database&CouchBase> implements lotus.domino.Document, CouchBase {

	private WebTarget target;
	private P parent;
	/** Items that were changed */
	private Map<String, Item> items;
	private List<String> removedItems;
	private JsonJavaObject raw;
	private String id;
	private String revision;

	private static enum SysFields {
		;
		public static final String ID = "_id";
		public static final String ID_REPONSE = "id";
		public static final String REVISION = "_rev";
		public static final String REVISION_RESPONSE = "rev";
		public static final String RESPONSE = "$REF";
		public static final String CONFLICT = "$Conflict";
		public static final String CONFLICT_ID = "_conflictid";
	}

	/**
	 * 
	 */
	Document() {
		// TODO Auto-generated constructor stub
	}

	Document(WebTarget _target, P _parent, JsonJavaObject _items) {
		target = _target;
		parent = _parent;
		raw = _items;
		if (raw.containsKey(SysFields.ID))
			id = raw.getAsString(SysFields.ID);
		else
			id = null;
		if (raw.containsKey(SysFields.REVISION))
			revision = raw.getAsString(SysFields.REVISION);
		else
			revision = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub
		raw.clear();
		// if (null != items) {
		// for (String item : items.keySet()) {
		// items.get(item).recycle();
		// }
		// items.clear();
		// }
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
	 * @see lotus.domino.Document#appendItemValue(java.lang.String)
	 */
	@Override
	public Item appendItemValue(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Item appendItemValue(String arg0, Object arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String, int)
	 */
	@Override
	public Item appendItemValue(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String, double)
	 */
	@Override
	public Item appendItemValue(String arg0, double arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#attachVCard(lotus.domino.Base)
	 */
	@Override
	public void attachVCard(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#attachVCard(lotus.domino.Base,
	 * java.lang.String)
	 */
	@Override
	public void attachVCard(Base arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities()
	 */
	@Override
	public boolean closeMIMEEntities() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities(boolean)
	 */
	@Override
	public boolean closeMIMEEntities(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities(boolean, java.lang.String)
	 */
	@Override
	public boolean closeMIMEEntities(boolean arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#computeWithForm(boolean, boolean)
	 */
	@Override
	public boolean computeWithForm(boolean arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME()
	 */
	@Override
	public void convertToMIME() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME(int)
	 */
	@Override
	public void convertToMIME(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME(int, int)
	 */
	@Override
	public void convertToMIME(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyAllItems(lotus.domino.Document, boolean)
	 */
	@Override
	public void copyAllItems(lotus.domino.Document arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyItem(lotus.domino.Item)
	 */
	@Override
	public lotus.domino.Item copyItem(lotus.domino.Item arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyItem(lotus.domino.Item, java.lang.String)
	 */
	@Override
	public lotus.domino.Item copyItem(lotus.domino.Item arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyToDatabase(lotus.domino.Database)
	 */
	@Override
	public lotus.domino.Document copyToDatabase(Database arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createMIMEEntity()
	 */
	@Override
	public MIMEEntity createMIMEEntity() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity createMIMEEntity(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createReplyMessage(boolean)
	 */
	@Override
	public lotus.domino.Document createReplyMessage(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createRichTextItem(java.lang.String)
	 */
	@Override
	public RichTextItem createRichTextItem(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#encrypt()
	 */
	@Override
	public void encrypt() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML()
	 */
	@Override
	public String generateXML() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML(java.io.Writer)
	 */
	@Override
	public void generateXML(Writer arg0) throws NotesException, IOException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML(java.lang.Object,
	 * lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void generateXML(Object arg0, XSLTResultTarget arg1) throws IOException, NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getAttachment(java.lang.String)
	 */
	@Override
	public EmbeddedObject getAttachment(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getAuthors()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getAuthors() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getColumnValues()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getColumnValues() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getCreated()
	 */
	@Override
	public DateTime getCreated() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getEmbeddedObjects()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getEmbeddedObjects() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getEncryptionKeys()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getEncryptionKeys() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFirstItem(java.lang.String)
	 */
	@Override
	public Item getFirstItem(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFolderReferences()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getFolderReferences() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getHttpURL()
	 */
	@Override
	public String getHttpURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getInitiallyModified()
	 */
	@Override
	public DateTime getInitiallyModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValue(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getItemValue(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomData(java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(String arg0) throws IOException, ClassNotFoundException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomData(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(String arg0, String arg1)
			throws IOException, ClassNotFoundException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomDataBytes(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public byte[] getItemValueCustomDataBytes(String arg0, String arg1) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueDateTimeArray(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getItemValueDateTimeArray(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueDouble(java.lang.String)
	 */
	@Override
	public double getItemValueDouble(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueInteger(java.lang.String)
	 */
	@Override
	public int getItemValueInteger(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueString(java.lang.String)
	 */
	@Override
	public String getItemValueString(String name) throws NotesException {
		Item item;
		String result;

		if (!raw.containsKey(name))
			return null;

		if (null == items || !items.containsKey(name)) {
			// get from raw
			item = new Item(name, this, raw.getAsObject(name));
			result = item.getValueString();

			item.recycle();
		} else {
			// get from cached changes
			result = items.get(name).getValueString();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItems()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getItems() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getKey()
	 */
	@Override
	public String getKey() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLastAccessed()
	 */
	@Override
	public DateTime getLastAccessed() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLastModified()
	 */
	@Override
	public DateTime getLastModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLockHolders()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getLockHolders() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getMIMEEntity()
	 */
	@Override
	public MIMEEntity getMIMEEntity() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity getMIMEEntity(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNameOfProfile()
	 */
	@Override
	public String getNameOfProfile() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNoteID()
	 */
	@Override
	public String getNoteID() throws NotesException {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNotesURL()
	 */
	@Override
	public String getNotesURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentDatabase()
	 */
	@Override
	public Database getParentDatabase() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentDocumentUNID()
	 */
	@Override
	public String getParentDocumentUNID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentView()
	 */
	@Override
	public View getParentView() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getRead()
	 */
	@Override
	public boolean getRead() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getReceivedItemText()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getReceivedItemText() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getResponses()
	 */
	@Override
	public DocumentCollection getResponses() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getSigner()
	 */
	@Override
	public String getSigner() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getSize()
	 */
	@Override
	public int getSize() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getURL()
	 */
	@Override
	public String getURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getUniversalID()
	 */
	@Override
	public String getUniversalID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getVerifier()
	 */
	@Override
	public String getVerifier() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#hasEmbedded()
	 */
	@Override
	public boolean hasEmbedded() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#hasItem(java.lang.String)
	 */
	@Override
	public boolean hasItem(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isDeleted()
	 */
	@Override
	public boolean isDeleted() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isEncryptOnSend()
	 */
	@Override
	public boolean isEncryptOnSend() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isEncrypted()
	 */
	@Override
	public boolean isEncrypted() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isNewNote()
	 */
	@Override
	public boolean isNewNote() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isProfile()
	 */
	@Override
	public boolean isProfile() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isResponse()
	 */
	@Override
	public boolean isResponse() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSaveMessageOnSend()
	 */
	@Override
	public boolean isSaveMessageOnSend() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSentByAgent()
	 */
	@Override
	public boolean isSentByAgent() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSignOnSend()
	 */
	@Override
	public boolean isSignOnSend() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSigned()
	 */
	@Override
	public boolean isSigned() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isValid()
	 */
	@Override
	public boolean isValid() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock()
	 */
	@Override
	public boolean lock() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(boolean)
	 */
	@Override
	public boolean lock(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.lang.String)
	 */
	@Override
	public boolean lock(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional()
	 */
	@Override
	public boolean lockProvisional() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#makeResponse(lotus.domino.Document)
	 */
	@Override
	public void makeResponse(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markRead()
	 */
	@Override
	public void markRead() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markRead(java.lang.String)
	 */
	@Override
	public void markRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markUnread()
	 */
	@Override
	public void markUnread() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markUnread(java.lang.String)
	 */
	@Override
	public void markUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#putInFolder(java.lang.String)
	 */
	@Override
	public void putInFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#putInFolder(java.lang.String, boolean)
	 */
	@Override
	public void putInFolder(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#remove(boolean)
	 */
	@Override
	public boolean remove(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removeFromFolder(java.lang.String)
	 */
	@Override
	public void removeFromFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removeItem(java.lang.String)
	 */
	@Override
	public void removeItem(String name) throws NotesException {
		if (null == removedItems)
			removedItems = new ArrayList<String>(0);
		removedItems.add(name);
		if (null != items && items.containsKey(name)) {
			items.remove(name);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removePermanently(boolean)
	 */
	@Override
	public boolean removePermanently(boolean force) throws NotesException {
		// TODO Auto-generated method stub
		if (null != id) {
			lotus.domino.Document doc = parent.getDocumentByID(id);
			if (null != doc) {
				if (!revision.equals(((org.openntf.redomino.couch.Document) doc).getRevision()))
					revision = ((org.openntf.redomino.couch.Document) doc).getRevision();
				doc.recycle();
				Response response = target.queryParam(SysFields.REVISION_RESPONSE, revision)
						.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).delete();
				JsonJavaObject jobject = response.readEntity(JsonJavaObject.class);
				System.out.println("<> Queried Couch for delete. Status: " + response.getStatus());
				System.out.println("<> Queried Couch for delete. Body: " + jobject.toString());
				if (response.getStatus() == Response.Status.OK.getStatusCode()) {
					recycle();
					return true;
				} else {
					// TODO remove failed - throw an exception
				}
			} else {
				// TODO no document exists - check what needs to be done
			}
		} else {
			// TODO document doesn't exist - throw exception
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#renderToRTItem(lotus.domino.RichTextItem)
	 */
	@Override
	public boolean renderToRTItem(RichTextItem arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValue(java.lang.String,
	 * java.lang.Object)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public lotus.domino.Item replaceItemValue(String name, Object value) throws NotesException {
		Item item = null;
		// TODO Auto-generated method stub
		// TODO refactor code - looks ugly, honestly
		if (null == items)
			items = new HashMap<String, Item>(0);
		else
			items.remove(name);

		if (raw.containsKey(name)) {
			// replace the existing value
			item = new Item(name, this, raw.getAsObject(name));
			if (value instanceof String) {
				item.setValueString((String) value);
			}
		} else {
			// create a new item
			item = new Item(name, this, Type.TEXT);
		}

		if (null != item)
			items.put(name, item);

		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValueCustomData(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(String arg0, Object arg1) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValueCustomData(java.lang.String,
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(String arg0, String arg1, Object arg2) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Document#replaceItemValueCustomDataBytes(java.lang.String,
	 * java.lang.String, byte[])
	 */
	@Override
	public Item replaceItemValueCustomDataBytes(String arg0, String arg1, byte[] arg2)
			throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save()
	 */
	@Override
	public boolean save() throws NotesException {
		return save(false, false, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean)
	 */
	@Override
	public boolean save(boolean force) throws NotesException {
		return save(force, false, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean, boolean)
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse) throws NotesException {
		return save(force, makeresponse, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean, boolean, boolean)
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse, boolean markread) throws NotesException {
		Document doc = (org.openntf.redomino.couch.Document) parent.getDocumentByID(id);
		if (null != doc) {
			System.out.println("<><><><><> It's an existing document!");
			if (!revision.equals(doc.getRevision())) {
				// conflict resolution
				if (force) {
					// new guy wins - change revision version so that Couch
					// takes it
					// as a correct document version
					revision = doc.getRevision();
					raw.putString(SysFields.REVISION, revision);
				} else if (makeresponse) {
					// make it a response - TODO investigate what would be the
					// best
					// way to implement this
					items.put(SysFields.RESPONSE, new Item(SysFields.RESPONSE, this, id));
					id = null;
					raw.remove(SysFields.ID);
					revision = null;
					raw.remove(SysFields.REVISION);
				} else {
					// save as a conflict - TODO investigate what would be the
					// best
					// way to implement this
					items.put(SysFields.CONFLICT, new Item(SysFields.CONFLICT, this, "1"));
					raw.putString(SysFields.CONFLICT_ID, id);
					id = null;
					raw.remove(SysFields.ID);
					revision = null;
					raw.remove(SysFields.REVISION);
				}
			}
		} else {
			// FIXME probably don't need that
			id = null;
			raw.remove(SysFields.ID);
			revision = null;
			raw.remove(SysFields.REVISION);
		}
		if (markread) {
			// TODO need to investigate what can replace this in Couch
			markRead();
		}
		// bring fields into the JSON object
		collapseForSave();
		// do the save
		if (null == id) {
			// create new document
			WebTarget pTarget = ((org.openntf.redomino.couch.Database) parent).getTarget();
			Response response = pTarget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(raw, MediaType.APPLICATION_JSON_TYPE));
			JsonJavaObject jobject = response.readEntity(JsonJavaObject.class);
			if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
				// doc created
				id = jobject.getAsString(SysFields.ID_REPONSE);
				target = pTarget.path(id);
				raw.putString(SysFields.ID, id);
				revision = jobject.getAsString(SysFields.REVISION_RESPONSE);
				raw.putString(SysFields.REVISION, revision);
				return true;
			} else {
				// failed to save - TODO throw exception
				return false;
			}
		} else {
			// save existing document
			System.out.println("<><><><><> Saving an existing document!");
			System.out.println("<><><><><> Submitting to: " + target.getUri().toString());
			System.out.println("<><><><><> Data to submit: " + raw.toString());
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE)
					.put(Entity.entity(raw, MediaType.APPLICATION_JSON_TYPE));
			JsonJavaObject jobject = response.readEntity(JsonJavaObject.class);
			System.out.println("<><><><><> Queried CouchDB. Status: " + response.getStatus());
			System.out.println("<><><><><> Queried CouchDB. Body: " + jobject.toString());
			if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
				// doc saved
				revision = jobject.getAsString(SysFields.REVISION_RESPONSE);
				raw.putString(SysFields.REVISION, revision);
				return true;
			} else {
				// failed to save - TODO throw exception
				return false;
			}
		}
	}

	private void collapseForSave() {
		// JsonJavaObject jobject = (JsonJavaObject) raw.clone();
		// add/update items
		if (null != items)
			for (String itemName : items.keySet()) {
				if (!removedItems.contains(itemName))
					raw.putObject(itemName, items.get(itemName).getRaw());
			}
		// remove items
		if (null != removedItems) {
			for (String name : removedItems) {
				raw.remove(name);
			}
		}
		// return jobject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send()
	 */
	@Override
	public void send() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(java.lang.String)
	 */
	@Override
	public void send(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean)
	 */
	@Override
	public void send(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(boolean arg0, Vector arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean, java.lang.String)
	 */
	@Override
	public void send(boolean arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setEncryptOnSend(boolean)
	 */
	@Override
	public void setEncryptOnSend(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setEncryptionKeys(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setEncryptionKeys(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setSaveMessageOnSend(boolean)
	 */
	@Override
	public void setSaveMessageOnSend(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setSignOnSend(boolean)
	 */
	@Override
	public void setSignOnSend(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setUniversalID(java.lang.String)
	 */
	@Override
	public void setUniversalID(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#sign()
	 */
	@Override
	public void sign() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#unlock()
	 */
	@Override
	public void unlock() throws NotesException {
		// TODO Auto-generated method stub

	}

	String getRevision() {
		return revision;
	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}
}
