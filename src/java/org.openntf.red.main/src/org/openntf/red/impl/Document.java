/**
 * 
 */
package org.openntf.red.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.DateTime;
import org.openntf.red.DocumentCollection;
import org.openntf.red.EmbeddedObject;
import org.openntf.red.Form;
import org.openntf.red.Item;
import org.openntf.red.Item.Flags;
import org.openntf.red.Item.Type;
import org.openntf.red.MIMEEntity;
import org.openntf.red.Name;
import org.openntf.red.RichTextItem;
import org.openntf.red.Session;
import org.openntf.red.View;
import org.openntf.red.exceptions.DataNotCompatibleException;
import org.openntf.red.exceptions.ItemNotFoundException;
import org.openntf.red.util.AutoMime;
import org.openntf.red.util.NoteClass;

import javolution.util.FastTable;
import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class Document extends Base<org.openntf.red.Database> implements org.openntf.red.Document {
	
	private static Logger log = Logger.getLogger(Document.class.getName());
	
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Note beObject;

	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	Document(Database _parent, org.openntf.red.nsf.endpoint.Note _beObject) {
		super(_parent, Base.NOTES_NOTE);
		// TODO Auto-generated constructor stub
		beObject = _beObject;
	}

	/**
	 * @param classId
	 */
	public Document(int classId) {
		super(classId);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Document#getItemValueDateTimeArray(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getItemValueDateTimeArray(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.DatabaseDescendant#getAncestorDatabase()
	 */
	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
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
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {
		if (!(key instanceof String))
			return null;
		return beObject.getField((String)key).getValue();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> keySet() {
		return beObject.keySet();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return beObject.getAllFieldNames().size();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.AsDocMap#asDocMap()
	 */
	@Override
	public Map<String, Object> asDocMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ExceptionDetails#fillExceptionDetails(java.util.List)
	 */
	@Override
	public void fillExceptionDetails(List<org.openntf.red.ExceptionDetails.Entry> result) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#appendItemValue(java.lang.String)
	 */
	@Override
	public Item appendItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#appendItemValue(java.lang.String, double)
	 */
	@Override
	public Item appendItemValue(String name, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#appendItemValue(java.lang.String, int)
	 */
	@Override
	public Item appendItemValue(String name, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#appendItemValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public Item appendItemValue(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#attachVCard(lotus.domino.Base)
	 */
	@Override
	public void attachVCard(lotus.domino.Base document) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#attachVCard(lotus.domino.Base, java.lang.String)
	 */
	@Override
	public void attachVCard(lotus.domino.Base document, String arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#closeMIMEEntities()
	 */
	@Override
	public boolean closeMIMEEntities() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#closeMIMEEntities(boolean)
	 */
	@Override
	public boolean closeMIMEEntities(boolean savechanges) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#closeMIMEEntities(boolean, java.lang.String)
	 */
	@Override
	public boolean closeMIMEEntities(boolean savechanges, String entityitemname) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#computeWithForm(boolean, boolean)
	 */
	@Override
	public boolean computeWithForm(boolean dodatatypes, boolean raiseerror) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#convertToMIME()
	 */
	@Override
	public void convertToMIME() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#convertToMIME(int)
	 */
	@Override
	public void convertToMIME(int conversiontype) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#convertToMIME(int, int)
	 */
	@Override
	public void convertToMIME(int conversiontype, int options) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#copyAllItems(lotus.domino.Document, boolean)
	 */
	@Override
	public void copyAllItems(lotus.domino.Document doc, boolean replace) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#copyItem(lotus.domino.Item)
	 */
	@Override
	public Item copyItem(lotus.domino.Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#copyItem(lotus.domino.Item, java.lang.String)
	 */
	@Override
	public Item copyItem(lotus.domino.Item item, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#copyToDatabase(lotus.domino.Database)
	 */
	@Override
	public org.openntf.red.Document copyToDatabase(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#createMIMEEntity()
	 */
	@Override
	public MIMEEntity createMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#createMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity createMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#createReplyMessage(boolean)
	 */
	@Override
	public org.openntf.red.Document createReplyMessage(boolean toall) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#createRichTextItem(java.lang.String)
	 */
	@Override
	public RichTextItem createRichTextItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#encrypt()
	 */
	@Override
	public void encrypt() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#generateXML()
	 */
	@Override
	public String generateXML() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#generateXML(java.lang.Object, lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void generateXML(Object style, XSLTResultTarget target) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#generateXML(java.io.Writer)
	 */
	@Override
	public void generateXML(Writer w) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getAttachment(java.lang.String)
	 */
	@Override
	public EmbeddedObject getAttachment(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getAuthors()
	 */
	@Override
	public Vector<String> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getColumnValues()
	 */
	@Override
	public Vector<Object> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getCreated()
	 */
	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getEmbeddedObjects()
	 */
	@Override
	public Vector<EmbeddedObject> getEmbeddedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getEncryptionKeys()
	 */
	@Override
	public Vector<String> getEncryptionKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getFirstItem(java.lang.String)
	 */
	@Override
	public Item getFirstItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getFolderReferences()
	 */
	@Override
	public Vector<String> getFolderReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getHttpURL()
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getInitiallyModified()
	 */
	@Override
	public DateTime getInitiallyModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItems()
	 */
	@Override
	public Vector<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemsEx() {
		FastTable<Item> items = new FastTable<Item>();
		List<String> itemNames = beObject.getAllFieldNames();
		Item item;
		
		for (String itemName : itemNames) {
			// TODO add to children
			item = new org.openntf.red.impl.Item(this, beObject.getField(itemName));
			items.add(item);
		}
		
		return items;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValue(java.lang.String)
	 */
	@Override
	public Vector<Object> getItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueCustomData(java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueCustomData(java.lang.String, java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(String itemName, String dataTypeName)
			throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueCustomDataBytes(java.lang.String, java.lang.String)
	 */
	@Override
	public byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueDouble(java.lang.String)
	 */
	@Override
	public double getItemValueDouble(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueInteger(java.lang.String)
	 */
	@Override
	public int getItemValueInteger(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueString(java.lang.String)
	 */
	@Override
	public String getItemValueString(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getKey()
	 */
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getLastAccessed()
	 */
	@Override
	public DateTime getLastAccessed() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getLastModified()
	 */
	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getLockHolders()
	 */
	@Override
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getMIMEEntity()
	 */
	@Override
	public MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity getMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getNameOfProfile()
	 */
	@Override
	public String getNameOfProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getNoteID()
	 */
	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getNotesURL()
	 */
	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getParentDatabase()
	 */
	@Override
	public Database getParentDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getParentDocumentUNID()
	 */
	@Override
	public String getParentDocumentUNID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getParentView()
	 */
	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getRead()
	 */
	@Override
	public boolean getRead() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getReceivedItemText()
	 */
	@Override
	public Vector<String> getReceivedItemText() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getResponses()
	 */
	@Override
	public DocumentCollection getResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getSigner()
	 */
	@Override
	public String getSigner() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getSize()
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getUniversalID()
	 */
	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getURL()
	 */
	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getVerifier()
	 */
	@Override
	public String getVerifier() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#hasEmbedded()
	 */
	@Override
	public boolean hasEmbedded() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#hasItem(java.lang.String)
	 */
	@Override
	public boolean hasItem(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isDeleted()
	 */
	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isEncrypted()
	 */
	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isEncryptOnSend()
	 */
	@Override
	public boolean isEncryptOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isNewNote()
	 */
	@Override
	public boolean isNewNote() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isProfile()
	 */
	@Override
	public boolean isProfile() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isResponse()
	 */
	@Override
	public boolean isResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isSaveMessageOnSend()
	 */
	@Override
	public boolean isSaveMessageOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isSentByAgent()
	 */
	@Override
	public boolean isSentByAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isSigned()
	 */
	@Override
	public boolean isSigned() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isSignOnSend()
	 */
	@Override
	public boolean isSignOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock()
	 */
	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock(boolean)
	 */
	@Override
	public boolean lock(boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock(java.lang.String)
	 */
	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(String name, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lockProvisional()
	 */
	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#makeResponse(lotus.domino.Document)
	 */
	@Override
	public void makeResponse(lotus.domino.Document doc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#markRead()
	 */
	@Override
	public void markRead() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#markRead(java.lang.String)
	 */
	@Override
	public void markRead(String username) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#markUnread()
	 */
	@Override
	public void markUnread() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#markUnread(java.lang.String)
	 */
	@Override
	public void markUnread(String username) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#putInFolder(java.lang.String)
	 */
	@Override
	public void putInFolder(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#putInFolder(java.lang.String, boolean)
	 */
	@Override
	public void putInFolder(String name, boolean createonfail) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#remove(boolean)
	 */
	@Override
	public boolean remove(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#removeFromFolder(java.lang.String)
	 */
	@Override
	public void removeFromFolder(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#removeItem(java.lang.String)
	 */
	@Override
	public void removeItem(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#removePermanently(boolean)
	 */
	@Override
	public boolean removePermanently(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#renderToRTItem(lotus.domino.RichTextItem)
	 */
	@Override
	public boolean renderToRTItem(lotus.domino.RichTextItem rtitem) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValue(java.lang.String, java.lang.Object)
	 */
	@Override
	public Item replaceItemValue(String itemName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValueCustomData(java.lang.String, java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(String itemName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValueCustomData(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValueCustomDataBytes(java.lang.String, java.lang.String, byte[])
	 */
	@Override
	public Item replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#save()
	 */
	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#save(boolean)
	 */
	@Override
	public boolean save(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#save(boolean, boolean)
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#save(boolean, boolean, boolean)
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse, boolean markread) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send()
	 */
	@Override
	public void send() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send(boolean)
	 */
	@Override
	public void send(boolean attachform) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send(boolean, java.lang.String)
	 */
	@Override
	public void send(boolean attachform, String recipient) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send(boolean, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(boolean attachform, Vector recipients) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send(java.lang.String)
	 */
	@Override
	public void send(String recipient) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#send(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(Vector recipients) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setEncryptionKeys(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setEncryptionKeys(Vector keys) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setEncryptOnSend(boolean)
	 */
	@Override
	public void setEncryptOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setSaveMessageOnSend(boolean)
	 */
	@Override
	public void setSaveMessageOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setSignOnSend(boolean)
	 */
	@Override
	public void setSignOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setUniversalID(java.lang.String)
	 */
	@Override
	public void setUniversalID(String unid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#sign()
	 */
	@Override
	public void sign() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#unlock()
	 */
	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#appendItemValue(java.lang.String, java.lang.Object, boolean)
	 */
	@Override
	public Item appendItemValue(String name, Object value, boolean unique) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#toJson(boolean)
	 */
	@Override
	public String toJson(boolean compact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getCreatedDate()
	 */
	@Override
	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getAttachments()
	 */
	@Override
	public List<EmbeddedObject> getAttachments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getFormName()
	 */
	@Override
	public String getFormName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#hasReaders()
	 */
	@Override
	public boolean hasReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getForm()
	 */
	@Override
	public Form getForm() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getInitiallyModifiedDate()
	 */
	@Override
	public Date getInitiallyModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getLastAccessedDate()
	 */
	@Override
	public Date getLastAccessedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getLastModifiedDate()
	 */
	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getParentDocument()
	 */
	@Override
	public org.openntf.red.Document getParentDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isDirty()
	 */
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#testMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity testMIMEEntity(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValue(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> T getItemValue(String name, Class<T> type) throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValues(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> List<T> getItemValues(String name, Class<T> type)
			throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValue(java.lang.String, java.lang.Object, boolean)
	 */
	@Override
	public Item replaceItemValue(String name, Object value, boolean isSummary) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#containsValue(java.lang.Object, java.lang.String[])
	 */
	@Override
	public boolean containsValue(Object value, String[] itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#containsValue(java.lang.Object, java.util.Collection)
	 */
	@Override
	public boolean containsValue(Object value, Collection<String> itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#containsValues(java.util.Map)
	 */
	@Override
	public boolean containsValues(Map<String, Object> filterMap) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getMetaversalID()
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getMetaversalID(java.lang.String)
	 */
	@Override
	public String getMetaversalID(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#forceDelegateRemove()
	 */
	@Override
	public boolean forceDelegateRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#rollback()
	 */
	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItems(org.openntf.red.Item.Type)
	 */
	@Override
	public List<Item> getItems(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItems(org.openntf.red.Item.Flags)
	 */
	@Override
	public List<Item> getItems(Flags flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#replaceItemValue(java.lang.String, java.lang.Object, java.lang.Boolean, boolean, boolean)
	 */
	@Override
	public Item replaceItemValue(String itemName, Object value, Boolean isSummary, boolean boxCompatibleOnly,
			boolean returnItem) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getAutoMime()
	 */
	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setAutoMime(org.openntf.red.util.AutoMime)
	 */
	@Override
	public void setAutoMime(AutoMime value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#markDirty()
	 */
	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getFirstItem(java.lang.String, boolean)
	 */
	@Override
	public Item getFirstItem(String name, boolean returnMime) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#writeBinary(java.lang.String, byte[], int)
	 */
	@Override
	public void writeBinary(String name, byte[] data, int chunkSize) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#readBinaryChunk(java.lang.String, int)
	 */
	@Override
	public byte[] readBinaryChunk(String name, int chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#readBinary(java.lang.String)
	 */
	@Override
	public byte[] readBinary(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemSeriesValues(java.lang.CharSequence)
	 */
	@Override
	public List<?> getItemSeriesValues(CharSequence name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemSeriesValues(java.lang.CharSequence, java.lang.Class)
	 */
	@Override
	public <T> T getItemSeriesValues(CharSequence name, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemTable(java.lang.CharSequence[])
	 */
	@Override
	public Map<String, List<Object>> getItemTable(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemTablePivot(java.lang.CharSequence[])
	 */
	@Override
	public List<Map<String, Object>> getItemTablePivot(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setItemTable(java.util.Map)
	 */
	@Override
	public void setItemTable(Map<String, List<Object>> table) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#setItemTablePivot(java.util.List)
	 */
	@Override
	public void setItemTablePivot(List<Map<String, Object>> pivot) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getItemValueName(java.lang.String)
	 */
	@Override
	public Name getItemValueName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#getNoteClass()
	 */
	@Override
	public NoteClass getNoteClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isDefault()
	 */
	@Override
	public boolean isDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#isPrivate()
	 */
	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Document#makeResponse(lotus.domino.Document, java.lang.String)
	 */
	@Override
	public void makeResponse(lotus.domino.Document doc, String itemName) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getItemValueEx(String name) {
		// TODO implement lighter version
		return beObject.getField(name).getValue();
	}

}
