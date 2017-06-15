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
import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.util.AutoMime;
import org.openntf.red.util.NoteClass;

import javolution.util.FastTable;
import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * Entity representing a document.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.Document
 *
 */
public class Document extends Base<org.openntf.red.Database> implements org.openntf.red.Document {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(Document.class.getName());

	/** Back-end object. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Note beObject;

	/**
	 * Default constructor.
	 * 
	 * @param _parent
	 *            Parent database
	 * @param _beObject
	 *            Back-end object for data manipulation
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	Document(Database _parent, org.openntf.red.nsf.endpoint.Note _beObject) {
		super(_parent, Base.NOTES_NOTE);
		// TODO Auto-generated constructor stub
		beObject = _beObject;
	}

	/**
	 * Under consideration. Not sure if needed.
	 * 
	 * @param classId
	 */
	public Document(int classId) {
		super(classId);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getItemValueDateTimeArray(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the ancestor database.
	 * 
	 * @return The ancestor database.
	 * @since 0.4.0
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent;
	}

	/**
	 * Gets the ancestor session.
	 * 
	 * @return Ancestor session
	 * @since 0.4.0
	 */
	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the value of a field with a name <code>key</code>.
	 * 
	 * @param key
	 *            Field name. Should be a String.
	 * @return Field value. If the field is multi-value, returns a
	 *         <code>List</code> of values.
	 * @since 0.4.0
	 * @see java.util.List
	 */
	@Override
	public Object get(Object key) {
		if (!(key instanceof String))
			return null;
		return beObject.getField((String) key).getValue();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns a {@link Set} of field names of a document.
	 * 
	 * @return A {@link Set} of field names of a document.
	 * @since 0.4.0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> keySet() {
		return beObject.keySet();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a number of named fields in a document.
	 * 
	 * @return Number of named fields in a document.
	 * @since 0.4.0
	 */
	@Override
	public int size() {
		return beObject.getAllFieldNames().size();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Map<String, Object> asDocMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void fillExceptionDetails(List<org.openntf.red.ExceptionDetails.Entry> result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item appendItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item appendItemValue(String name, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item appendItemValue(String name, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item appendItemValue(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void attachVCard(lotus.domino.Base document) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void attachVCard(lotus.domino.Base document, String arg1) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean closeMIMEEntities() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean closeMIMEEntities(boolean savechanges) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean closeMIMEEntities(boolean savechanges, String entityitemname) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean computeWithForm(boolean dodatatypes, boolean raiseerror) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void convertToMIME() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void convertToMIME(int conversiontype) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void convertToMIME(int conversiontype, int options) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void copyAllItems(lotus.domino.Document doc, boolean replace) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item copyItem(lotus.domino.Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item copyItem(lotus.domino.Item item, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document copyToDatabase(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public MIMEEntity createMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public MIMEEntity createMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Document createReplyMessage(boolean toall) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public RichTextItem createRichTextItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void encrypt() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String generateXML() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void generateXML(Object style, XSLTResultTarget target) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void generateXML(Writer w) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public EmbeddedObject getAttachment(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> getColumnValues() {
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
	public Vector<EmbeddedObject> getEmbeddedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getEncryptionKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item getFirstItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getFolderReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getFTSearchScore() {
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
	public DateTime getInitiallyModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns all document items as a {@link List}.<br>
	 * Should be more efficient than a {@link Vector}.<br>
	 * Current implementation uses a {@link FastTable}.
	 * 
	 * @return All document items as a {@link List}.
	 * @since 0.4.0
	 */
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

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> getItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getItemValueCustomData(String itemName, String dataTypeName)
			throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getItemValueDouble(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getItemValueInteger(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getItemValueString(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getLastAccessed() {
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
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public MIMEEntity getMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getNameOfProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a document's Note ID formatted as a String.
	 * 
	 * @return A document's Note ID.
	 * @since 0.4.0
	 */
	@Override
	public String getNoteID() {
		long noteid = beObject.getNoteID();
		if (0 == noteid)
			return null;

		return String.format("%1$X", noteid);
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
	 * Returns a parent database. Acts similar to {@link getAncestorDatabase()}
	 * in this instance.
	 * 
	 * @return Parent database.
	 * @since 0.4.0
	 */
	@Override
	public Database getParentDatabase() {
		return parent;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getParentDocumentUNID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getRead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean getRead(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getReceivedItemText() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getSigner() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the document's UNID.
	 * 
	 * @return Document's UNID.
	 * @since 0.4.0
	 */
	@Override
	public String getUniversalID() {
		return beObject.getUniversalID();
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
	public String getVerifier() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean hasEmbedded() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean hasItem(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isEncryptOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Determines whether this document has just been created, or it's an
	 * existing document.<br>
	 * New documents do not have a Note ID set, but may have a UNID. However,
	 * this UNID will not be registered anywhere, since the document has not
	 * been saved yet.
	 * 
	 * @return Whether it's a new document
	 * @since 0.4.0
	 */
	@Override
	public boolean isNewNote() {
		return beObject.isNewNote();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPreferJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isProfile() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isSaveMessageOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isSentByAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isSigned() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isSignOnSend() {
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
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(String name, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void makeResponse(lotus.domino.Document doc) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markRead() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markRead(String username) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markUnread() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markUnread(String username) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putInFolder(String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putInFolder(String name, boolean createonfail) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean remove(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeFromFolder(String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Removes an item from a document.
	 * 
	 * @param name
	 *            Name of the item to remove
	 * @since 0.4.0
	 */
	@Override
	public void removeItem(String name) {
		beObject.removeField(name);
	}

	/**
	 * Hard-deletes a document from the back-end database.
	 * 
	 * @param force
	 *            Whether the delete should be forced (i.e. ignore conflicts,
	 *            etc.)
	 * @return Whether the delete was successful
	 * @since 0.4.0
	 */
	@Override
	public boolean removePermanently(boolean force) {
		return beObject.deleteNote(force);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean renderToRTItem(lotus.domino.RichTextItem rtitem) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Replaces the item value with the data specified.
	 * <p>
	 * The item's type will be set/reset in the process. So if you're willing to
	 * preserve the old item type, use one of the
	 * <code>replaceItemValueCustomData(...)</code> functions instead.
	 * <p>
	 * If an item does not exist, it's created.
	 * 
	 * @param itemName
	 *            Name of the item to replace
	 * @param value
	 *            New value of the item. May be a collection.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Item replaceItemValue(String itemName, Object value) {
		Field field = beObject.createField(itemName, value);
		if (null == field)
			return null;

		return new org.openntf.red.impl.Item(this, field);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item replaceItemValueCustomData(String itemName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Submits the document for a save.
	 * 
	 * @return Whether the save was successful.
	 * @since 0.4.0
	 */
	@Override
	public boolean save() {
		return save(false, false, false);
	}

	/**
	 * Submits the document for a save.
	 * 
	 * @param force
	 *            Whether the save should be forced (i.e. ignores conflicts,
	 *            etc.).
	 * @return Whether the save was successful.
	 * @since 0.4.0
	 */
	@Override
	public boolean save(boolean force) {
		return save(force, false, false);
	}

	/**
	 * Submits the document for a save.
	 * 
	 * @param force
	 *            Whether the save should be forced (i.e. ignores conflicts,
	 *            etc.).
	 * @param makeresponse
	 *            Whether the document should be saved as a response if there is
	 *            a conflict.
	 * @return Whether the save was successful.
	 * @since 0.4.0
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse) {
		return save(force, makeresponse, false);
	}

	/**
	 * Submits the document for a save.
	 * 
	 * @param force
	 *            Whether the save should be forced (i.e. ignores conflicts,
	 *            etc.).
	 * @param makeresponse
	 *            Whether the document should be saved as a response if there is
	 *            a conflict.
	 * @param markread
	 *            Whether the document should be marked as read after it's been
	 *            saved.
	 * @return Whether the save was successful.
	 * @since 0.4.0
	 */
	@Override
	public boolean save(boolean force, boolean makeresponse, boolean markread) {
		if (beObject.updateNote(force)) {

		} else {
			if (makeresponse) {
				// TODO make the note a response doc
			} else
				return false;
		}
		if (markread) {
			// TODO mark the note as read - need to figure out a mechanism for
			// that
		}
		return true;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void send() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void send(boolean attachform) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void send(boolean attachform, String recipient) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(boolean attachform, Vector recipients) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void send(String recipient) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(Vector recipients) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setEncryptionKeys(Vector keys) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEncryptOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSaveMessageOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSignOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setUniversalID(String unid) {
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
	public void unlock() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item appendItemValue(String name, Object value, boolean unique) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String toJson(boolean compact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public List<EmbeddedObject> getAttachments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getFormName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean hasReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Form getForm() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getInitiallyModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Date getLastAccessedDate() {
		// TODO Auto-generated method stub
		return null;
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
	public org.openntf.red.Document getParentDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public MIMEEntity testMIMEEntity(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public <T> T getItemValue(String name, Class<T> type) throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public <T> List<T> getItemValues(String name, Class<T> type)
			throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item replaceItemValue(String name, Object value, boolean isSummary) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValue(Object value, String[] itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValue(Object value, Collection<String> itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValues(Map<String, Object> filterMap) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet. Under consideration. Not sure if needed.
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet. Under consideration. Not sure if needed.
	 */
	@Override
	public String getMetaversalID(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet. Under consideration. Not sure if needed.
	 */
	@Override
	public boolean forceDelegateRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public List<Item> getItems(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public List<Item> getItems(Flags flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item replaceItemValue(String itemName, Object value, Boolean isSummary, boolean boxCompatibleOnly,
			boolean returnItem) {
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
	public void setAutoMime(AutoMime value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Item getFirstItem(String name, boolean returnMime) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void writeBinary(String name, byte[] data, int chunkSize) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public byte[] readBinaryChunk(String name, int chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public byte[] readBinary(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public List<?> getItemSeriesValues(CharSequence name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public <T> T getItemSeriesValues(CharSequence name, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Map<String, List<Object>> getItemTable(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public List<Map<String, Object>> getItemTablePivot(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setItemTable(Map<String, List<Object>> table) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setItemTablePivot(List<Map<String, Object>> pivot) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Name getItemValueName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public NoteClass getNoteClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void makeResponse(lotus.domino.Document doc, String itemName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets item value as a {@link List}.<br>
	 * Currently uses {@link FastTable}.<br>
	 * Should be more effective than {@link Vector}.
	 * 
	 * @param name
	 *            Item name
	 * @return Item value as a {@link List}
	 * @since 0.4.0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getItemValueEx(String name) {
		// TODO implement lighter version
		return beObject.getField(name).getValue();
	}

	/**
	 * Returns a back-end object that manipulates data. Restricted function.
	 * 
	 * @return Back-end object
	 * @since 0.4.0
	 */
	@Override
	public Note<?, ?, ?> getBEObject() {
		// TODO security check
		return beObject;
	}

	/**
	 * Resets the document item and sets it's value to the specified.
	 * 
	 * @param itemName
	 *            Item name
	 * @param dataTypeCode
	 *            Code of the data type. Corresponds to Notes data types (e.g.
	 *            1280 - TEXT).
	 * @param flags
	 *            Item flags (bitwise union). Correspond to Notes item flags.
	 * @param value
	 *            New value of the item.
	 * @return The item that was reset.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Item replaceItemValueCustomData(String itemName, int dataTypeCode, long flags, Object value) {
		Field field = beObject.createField(itemName, dataTypeCode, flags, value);
		if (null == field)
			return null;

		return new org.openntf.red.impl.Item(this, field);
	}

	/**
	 * Resets the document item and sets it's value to the specified.
	 * 
	 * @param itemName
	 *            Item name
	 * @param dataTypeCode
	 *            Code of the data type. Corresponds to Notes data types (e.g.
	 *            1280 - TEXT).
	 * @param flags
	 *            Item flags (list of enums).
	 * @param value
	 *            New value of the item.
	 * @return The item that was reset.
	 * @since 0.4.0
	 * @see org.openntf.red.nsf.endpoint.Field.Flags
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Item replaceItemValueCustomData(String itemName, int dataTypeCode,
			List<org.openntf.red.nsf.endpoint.Field.Flags> flags, Object value) {
		Field field = beObject.createField(itemName, dataTypeCode, flags, value);
		if (null == field)
			return null;

		return new org.openntf.red.impl.Item(this, field);
	}

	/**
	 * Sets the Note ID. Implementations may vary, but in general, a Note ID of
	 * 0 would mean a new document will be created.
	 * <p>
	 * Not finished yet.
	 * 
	 * @param id
	 *            The new value of a Note ID
	 * @since 0.4.0
	 */
	@Override
	public void setNoteID(long id) {
		beObject.setNoteID(id);
	}

}
