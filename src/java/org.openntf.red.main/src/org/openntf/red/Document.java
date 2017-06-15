package org.openntf.red;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.openntf.red.exceptions.DataNotCompatibleException;
import org.openntf.red.exceptions.ItemNotFoundException;
import org.openntf.red.ext.HasBEObject;
import org.openntf.red.nsf.endpoint.Field.Flags;
import org.openntf.red.types.DatabaseDescendant;
import org.openntf.red.util.AutoMime;
import org.openntf.red.util.NoteClass;

import lotus.domino.NotesException;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Document.
 */
public interface Document extends Base, lotus.domino.Document, DatabaseDescendant, Map<String, Object>, AsDocMap,
		ExceptionDetails, HasBEObject<org.openntf.red.nsf.endpoint.Note<?, ?, ?>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String)
	 */
	@Override
	public Item appendItemValue(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String, double)
	 */
	@Override
	public Item appendItemValue(final String name, final double value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String, int)
	 */
	@Override
	public Item appendItemValue(final String name, final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#appendItemValue(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Item appendItemValue(final String name, final Object value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#attachVCard(lotus.domino.Base)
	 */
	@Override
	public void attachVCard(final lotus.domino.Base document);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#attachVCard(lotus.domino.Base,
	 * java.lang.String)
	 */
	@Override
	public void attachVCard(final lotus.domino.Base document, final String arg1);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities()
	 */
	@Override
	public boolean closeMIMEEntities();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities(boolean)
	 */
	@Override
	public boolean closeMIMEEntities(final boolean savechanges);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#closeMIMEEntities(boolean, java.lang.String)
	 */
	@Override
	public boolean closeMIMEEntities(final boolean savechanges, final String entityitemname);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#computeWithForm(boolean, boolean)
	 */
	@Override
	public boolean computeWithForm(final boolean dodatatypes, final boolean raiseerror);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME()
	 */
	@Override
	public void convertToMIME();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME(int)
	 */
	@Override
	public void convertToMIME(final int conversiontype);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#convertToMIME(int, int)
	 */
	@Override
	public void convertToMIME(final int conversiontype, final int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyAllItems(lotus.domino.Document, boolean)
	 */
	@Override
	public void copyAllItems(final lotus.domino.Document doc, final boolean replace);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyItem(lotus.domino.Item)
	 */
	@Override
	public Item copyItem(final lotus.domino.Item item);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyItem(lotus.domino.Item, java.lang.String)
	 */
	@Override
	public Item copyItem(final lotus.domino.Item item, final String newName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#copyToDatabase(lotus.domino.Database)
	 */
	@Override
	public Document copyToDatabase(final lotus.domino.Database db);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createMIMEEntity()
	 */
	@Override
	public MIMEEntity createMIMEEntity();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity createMIMEEntity(final String itemName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createReplyMessage(boolean)
	 */
	@Override
	public Document createReplyMessage(final boolean toall);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#createRichTextItem(java.lang.String)
	 */
	@Override
	public RichTextItem createRichTextItem(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#encrypt()
	 */
	@Override
	public void encrypt();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML()
	 */
	@Override
	public String generateXML();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML(java.lang.Object,
	 * lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void generateXML(final Object style, final lotus.domino.XSLTResultTarget target) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#generateXML(java.io.Writer)
	 */
	@Override
	public void generateXML(final Writer w) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getAttachment(java.lang.String)
	 */
	@Override
	public EmbeddedObject getAttachment(final String fileName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getAuthors()
	 */
	@Override
	public Vector<String> getAuthors();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getColumnValues()
	 */
	@Override
	public Vector<Object> getColumnValues();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getCreated()
	 */
	@Override
	public DateTime getCreated();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getEmbeddedObjects()
	 */
	@Override
	public Vector<EmbeddedObject> getEmbeddedObjects();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getEncryptionKeys()
	 */
	@Override
	public Vector<String> getEncryptionKeys();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFirstItem(java.lang.String)
	 */
	@Override
	public Item getFirstItem(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFolderReferences()
	 */
	@Override
	public Vector<String> getFolderReferences();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getHttpURL()
	 */
	@Override
	public String getHttpURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getInitiallyModified()
	 */
	@Override
	public DateTime getInitiallyModified();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItems()
	 */
	// @SuppressWarnings("unchecked")
	@Override
	public Vector<Item> getItems();

	public List<Item> getItemsEx();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValue(java.lang.String)
	 */
	@Override
	public Vector<Object> getItemValue(final String name);

	public List<Object> getItemValueEx(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomData(java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(final String itemName) throws IOException, ClassNotFoundException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomData(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Object getItemValueCustomData(final String itemName, final String dataTypeName)
			throws IOException, ClassNotFoundException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueCustomDataBytes(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public byte[] getItemValueCustomDataBytes(final String itemName, final String dataTypeName) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueDateTimeArray(java.lang.String)
	 */
	@Override
	public Vector<Base> getItemValueDateTimeArray(final String name) throws NotesException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueDouble(java.lang.String)
	 */
	@Override
	public double getItemValueDouble(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueInteger(java.lang.String)
	 */
	@Override
	public int getItemValueInteger(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getItemValueString(java.lang.String)
	 */
	@Override
	public String getItemValueString(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getKey()
	 */
	@Override
	public String getKey();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLastAccessed()
	 */
	@Override
	public DateTime getLastAccessed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLastModified()
	 */
	@Override
	public DateTime getLastModified();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getLockHolders()
	 */
	@Override
	public Vector<String> getLockHolders();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getMIMEEntity()
	 */
	@Override
	public MIMEEntity getMIMEEntity();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getMIMEEntity(java.lang.String)
	 */
	@Override
	public MIMEEntity getMIMEEntity(final String itemName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNameOfProfile()
	 */
	@Override
	public String getNameOfProfile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNoteID()
	 */
	@Override
	public String getNoteID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getNotesURL()
	 */
	@Override
	public String getNotesURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentDatabase()
	 */
	@Override
	public org.openntf.red.Database getParentDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentDocumentUNID()
	 */
	@Override
	public String getParentDocumentUNID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getParentView()
	 */
	@Override
	public View getParentView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getRead()
	 */
	@Override
	public boolean getRead();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(final String username);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getReceivedItemText()
	 */
	@Override
	public Vector<String> getReceivedItemText();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getResponses()
	 */
	@Override
	public DocumentCollection getResponses();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getSigner()
	 */
	@Override
	public String getSigner();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getSize()
	 */
	@Override
	public int getSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getUniversalID()
	 */
	@Override
	public String getUniversalID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getURL()
	 */
	@Override
	public String getURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#getVerifier()
	 */
	@Override
	public String getVerifier();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#hasEmbedded()
	 */
	@Override
	public boolean hasEmbedded();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#hasItem(java.lang.String)
	 */
	@Override
	public boolean hasItem(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isDeleted()
	 */
	@Override
	public boolean isDeleted();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isEncrypted()
	 */
	@Override
	public boolean isEncrypted();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isEncryptOnSend()
	 */
	@Override
	public boolean isEncryptOnSend();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isNewNote()
	 */
	@Override
	public boolean isNewNote();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isProfile()
	 */
	@Override
	public boolean isProfile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isResponse()
	 */
	@Override
	public boolean isResponse();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSaveMessageOnSend()
	 */
	@Override
	public boolean isSaveMessageOnSend();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSentByAgent()
	 */
	@Override
	public boolean isSentByAgent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSigned()
	 */
	@Override
	public boolean isSigned();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isSignOnSend()
	 */
	@Override
	public boolean isSignOnSend();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#isValid()
	 */
	@Override
	public boolean isValid();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock()
	 */
	@Override
	public boolean lock();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(boolean)
	 */
	@Override
	public boolean lock(final boolean provisionalok);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.lang.String)
	 */
	@Override
	public boolean lock(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(final String name, final boolean provisionalok);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(final Vector names, final boolean provisionalok);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional()
	 */
	@Override
	public boolean lockProvisional();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#makeResponse(lotus.domino.Document)
	 */
	@Override
	public void makeResponse(final lotus.domino.Document doc);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markRead()
	 */
	@Override
	public void markRead();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markRead(java.lang.String)
	 */
	@Override
	public void markRead(final String username);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markUnread()
	 */
	@Override
	public void markUnread();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#markUnread(java.lang.String)
	 */
	@Override
	public void markUnread(final String username);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#putInFolder(java.lang.String)
	 */
	@Override
	public void putInFolder(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#putInFolder(java.lang.String, boolean)
	 */
	@Override
	public void putInFolder(final String name, final boolean createonfail);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#remove(boolean)
	 */
	@Override
	public boolean remove(final boolean force);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removeFromFolder(java.lang.String)
	 */
	@Override
	public void removeFromFolder(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removeItem(java.lang.String)
	 */
	@Override
	public void removeItem(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#removePermanently(boolean)
	 */
	@Override
	public boolean removePermanently(final boolean force);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#renderToRTItem(lotus.domino.RichTextItem)
	 */
	@Override
	public boolean renderToRTItem(final lotus.domino.RichTextItem rtitem);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValue(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Item replaceItemValue(final String itemName, final Object value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValueCustomData(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(final String itemName, final Object userObj) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#replaceItemValueCustomData(java.lang.String,
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public Item replaceItemValueCustomData(final String itemName, final String dataTypeName, final Object userObj)
			throws IOException;
	
	public Item replaceItemValueCustomData(final String itemName, final int dataTypeCode, final long flags, final Object value);
	
	public Item replaceItemValueCustomData(final String itemName, final int dataTypeCode, final List<Flags> flags, final Object value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Document#replaceItemValueCustomDataBytes(java.lang.String,
	 * java.lang.String, byte[])
	 */
	@Override
	public Item replaceItemValueCustomDataBytes(final String itemName, final String dataTypeName,
			final byte[] byteArray) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save()
	 */
	@Override
	public boolean save();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean)
	 */
	@Override
	public boolean save(final boolean force);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean, boolean)
	 */
	@Override
	public boolean save(final boolean force, final boolean makeresponse);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#save(boolean, boolean, boolean)
	 */
	@Override
	public boolean save(final boolean force, final boolean makeresponse, final boolean markread);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send()
	 */
	@Override
	public void send();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean)
	 */
	@Override
	public void send(final boolean attachform);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean, java.lang.String)
	 */
	@Override
	public void send(final boolean attachform, final String recipient);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(boolean, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(final boolean attachform, final Vector recipients);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(java.lang.String)
	 */
	@Override
	public void send(final String recipient);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#send(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void send(final Vector recipients);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setEncryptionKeys(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setEncryptionKeys(final Vector keys);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setEncryptOnSend(boolean)
	 */
	@Override
	public void setEncryptOnSend(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setSaveMessageOnSend(boolean)
	 */
	@Override
	public void setSaveMessageOnSend(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setSignOnSend(boolean)
	 */
	@Override
	public void setSignOnSend(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#setUniversalID(java.lang.String)
	 */
	@Override
	public void setUniversalID(final String unid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#sign()
	 */
	@Override
	public void sign();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Document#unlock()
	 */
	@Override
	public void unlock();

	/**
	 * Appends a value to an existing Item, with an option to only add it if the
	 * value does not already exist in the Item.
	 * 
	 * <p>
	 * The method is only useful if a single value is being appended, because it
	 * use containsValue(value) This allows the developer to avoid duplicate
	 * values but also avoid unnecessary saves with transactional processing.
	 * </p>
	 * 
	 * @param name
	 *            String Item name
	 * @param value
	 *            Object value
	 * @param unique
	 *            Boolean whether to only add the value if the Item does not
	 *            already hold the value
	 * @return Item being updated
	 * @since org.openntf.domino 5.0.0
	 */
	public Item appendItemValue(String name, Object value, boolean unique);

	/**
	 * Converts the Document to JSON, with whether or not to compact the
	 * resulting JSON, removing spaces that would make the output more readable
	 * 
	 * @param compact
	 *            Boolean whether or not to compact
	 * @return String JSON output of the Document
	 * @since org.openntf.domino 2.5.0
	 */
	public String toJson(boolean compact);

	/**
	 * Gets the created date of the Document, returning as a Java Date instead
	 * of a DateTime
	 * 
	 * @return Date the document was created
	 * @since org.openntf.domino 1.0.0
	 */
	public Date getCreatedDate();

	/**
	 * 
	 * @return A List of the attachments from the document's Rich Text items, as
	 *         EmbeddedObjects
	 */
	public List<org.openntf.red.EmbeddedObject> getAttachments();

	/**
	 * Gets the Form name the Document is based upon
	 * 
	 * @return String form name
	 * @since org.openntf.domino 4.5.0
	 */
	public String getFormName();

	/**
	 * Returns whether the Document is restricted to specific Readers or visible
	 * to anyone who has access to the database.
	 * 
	 * @return Boolean whether or not Readers restrictions apply
	 * @since org.openntf.domino 5.0.0
	 */
	public boolean hasReaders();

	/**
	 * Gets the Form design element the Document is based upon
	 * 
	 * @return Form design element
	 * @since org.openntf.domino 4.5.0
	 */
	public org.openntf.red.Form getForm();

	/**
	 * Gets the initially modified date as a Java Date rather than a DateTime
	 * 
	 * @return the initially modified date
	 * @since org.openntf.domino 1.0.0
	 */
	public Date getInitiallyModifiedDate();

	/**
	 * Gets the last accessed date as a Java Date rather than a DateTime
	 * 
	 * @return Date the document was last accessed
	 * @since org.openntf.domino 1.0.0
	 */
	public Date getLastAccessedDate();

	/**
	 * Gets the last modified date.
	 * 
	 * @return Date the document was last modified
	 */
	public Date getLastModifiedDate();

	/**
	 * Gets the parent Document if the current Document is a response / response
	 * to response / conflict
	 * 
	 * @return Document that is the parent
	 * @since org.openntf.domino 2.5.0
	 */
	public Document getParentDocument();

	/**
	 * Identifies whether any Item on the Document has been updated, used by
	 * transactional processing to avoid unnecessary saves.
	 * 
	 * @return Boolean whether or not the document has been changed
	 * @since org.openntf.domino 2.5.0
	 */
	public boolean isDirty();

	/**
	 * Tests whether a MIMEEntity exists on the Document and, if so, returns it.
	 * This exists because you have to switch off auto-conversion of MIME in
	 * order for hasMIMEEntity() to return true.
	 * 
	 * @return MIMEEntity or null, if no MIMEEntity exists
	 * @since org.openntf.domino 5.0.0
	 * @deprecated pending update from NTF
	 */
	@Deprecated
	public MIMEEntity testMIMEEntity(final String name);

	/**
	 * Gets an Item value, casting it to a specific class, e.g.
	 * java.util.ArrayList.class
	 * 
	 * @param name
	 *            Item name to retrieve the value from
	 * @param T
	 *            Java class to cast value to
	 * @return Java object of type T, containing the values from the object
	 * @throws ItemNotFoundException
	 *             if the Item does not exist
	 * @throws DataNotCompatibleException
	 *             if the values cannot be cast to the Java class T
	 * @since org.openntf.domino 2.5.0
	 */
	public <T> T getItemValue(final String name, final Class<T> type)
			throws ItemNotFoundException, DataNotCompatibleException;

	/**
	 * Gets an Item value as list, Elements in list are casted it to a specific
	 * class, e.g. java.lang.String.class
	 * 
	 * @param name
	 *            Item name to retrieve the value from
	 * @param T
	 *            Java class to cast value to
	 * @return Java object of type List<T>, containing the values from the
	 *         object
	 * @throws ItemNotFoundException
	 *             if the Item does not exist
	 * @throws DataNotCompatibleException
	 *             if the values cannot be cast to the Java class T
	 * @since org.openntf.domino 2.5.0
	 */
	public <T> List<T> getItemValues(final String name, final Class<T> type)
			throws ItemNotFoundException, DataNotCompatibleException;

	/**
	 * Replaces an item value, setting the Item as Summary type or not
	 * 
	 * @param name
	 *            Item to replace the value of
	 * @param value
	 *            Object
	 * @param isSummary
	 *            Passed to the Item's setSummary method directly
	 * @return An Item object for the resultant set item.
	 */
	public Item replaceItemValue(final String name, final Object value, final boolean isSummary);

	/**
	 * Checks whether or not a Document contains a specific value, restricting
	 * the search to specific Item names
	 * 
	 * @param value
	 *            Object value to check for
	 * @param itemnames
	 *            String[] items to look through
	 * @return Boolean whether or not one of the Items contains the value
	 * @since org.openntf.domino 4.5.0
	 */
	public boolean containsValue(final Object value, final String[] itemnames);

	/**
	 * Checks whether or not a Document contains a specific value, restricting
	 * the search to specific Item names
	 * 
	 * @param value
	 *            Object value to check for
	 * @param itemnames
	 *            Collection<String> items to look through
	 * @return Boolean whether or not one of the Items contains the value
	 * @since org.openntf.domino 4.5.0
	 */
	public boolean containsValue(final Object value, final Collection<String> itemnames);

	/**
	 * Receives a Map where the key is an Item name and the value is a value to
	 * look for in the relevant Item. If one key/value pair matches (so one of
	 * the Items contains the value to look for), the method returns true.
	 * 
	 * <code>
	 * 	HashMap<String,Object> check = new Map<String,Object>();
	 *  check.put("Form","Person");
	 *  check.put("FirstName","Fred");
	 *  return doc.containsValues(check);
	 * </code>
	 * 
	 * <p>
	 * Returns true if the relevant Document's Form item contains "Person" or
	 * the Document's FirstName item contains "Fred".<br/>
	 * Returns false if the relevant Document's Form does not contain "Person"
	 * and the Document's FirstName item does not contain "Fred".
	 * </p>
	 * 
	 * @param filterMap
	 *            Map<String,Object> to check
	 * @return Boolean whether one of the items contains a value
	 * @since org.openntf.domino 4.5.0
	 */
	public boolean containsValues(final Map<String, Object> filterMap);

	/**
	 * Gets the metaversal ID, which appends replicaID + documentID
	 * 
	 * @return String metaversal ID
	 * @since org.openntf.domino 5.0.0
	 */
	public String getMetaversalID();

	/**
	 * Gets the metaversal ID specific to a server, so appending serverName +
	 * "!!" + replicaID + documentID
	 * 
	 * @param serverName
	 *            String server name to add to metaversal ID
	 * @return String server-specific metaversal ID
	 * @since org.openntf.domino 5.0.0
	 */
	public String getMetaversalID(String serverName);

	// public <T> T getItemValue(String name, Class<T> type, ClassLoader loader)
	// throws ItemNotFoundException, DataNotCompatibleException;

	/**
	 * Attempts to force deletion of the document, using soft deletion, if
	 * enabled
	 * 
	 * @return Boolean success or failure of attempt to remove the Document
	 * @since org.openntf.domino 5.0.0
	 */
	public boolean forceDelegateRemove();

	/**
	 * Rolls back any changes to the Document
	 * 
	 * @since org.openntf.domino 5.0.0
	 */
	public void rollback();

	/**
	 * Gets a list of all Items on the Document matching a specific Type, using
	 * {@link org.openntf.domino.Item.Type}
	 * 
	 * @param type
	 *            Item.Type to look for
	 * @return List<Item> matching the specific Item.Type
	 * @since org.openntf.domino 5.0.0
	 */
	public List<Item> getItems(org.openntf.red.Item.Type type);

	/**
	 * Gets a list of all Items on the Document matching a specific Flag, using
	 * {@link org.openntf.domino.Item.Flags}
	 * 
	 * @param type
	 *            Item.Flags to look for
	 * @return List<Item> matching the specific Item.Flags
	 * @since org.openntf.domino 5.0.0
	 */
	public List<Item> getItems(org.openntf.red.Item.Flags flags);

	/**
	 * Replaces the item value in a document, deciding whether the Item should
	 * have the Summary flag set, whether the value should be auto-boxed, and
	 * whether to return the Item
	 * 
	 * @param itemName
	 *            String Item name
	 * @param value
	 *            Object value to set
	 * @param isSummary
	 *            Boolean whether the Item should be set to Summary
	 * @param autoBox
	 *            Boolean whether the value should be autoboxed
	 * @param returnItem
	 *            Boolean whether the Item should be returned
	 * @return Item or null, if final parameter is false
	 * @since org.openntf.domino 5.0.0
	 */
	Item replaceItemValue(String itemName, Object value, Boolean isSummary, final boolean boxCompatibleOnly,
			boolean returnItem);

	/**
	 * Retrieves whether or not the session is auto-mime-enabled
	 * 
	 * @return AutoMime enum
	 * @since org.openntf.domino 5.0.0
	 */
	public AutoMime getAutoMime();

	/**
	 * Sets whether the session should be auto-mime-enabled, using
	 * {@link org.openntf.red.util.domino.AutoMime}
	 * 
	 * @param value
	 *            AutoMime whether mime should be enabled or not
	 * @since org.openntf.domino 5.0.0
	 */
	public void setAutoMime(final AutoMime value);

	/**
	 * Mark the document as dirty
	 * 
	 * @since org.openntf.domino 5.0.0
	 */
	public void markDirty();

	/**
	 * Gets an Item, determining whether or not AutoMime should be switched back
	 * on at the end of the process
	 * 
	 * @param name
	 *            String Item name
	 * @param returnMime
	 *            Boolean whether AutoMime should always be on
	 * @return Item if found on the Document
	 * @since org.openntf.domino 5.0.0
	 */
	public Item getFirstItem(final String name, final boolean returnMime);

	// public void writeBinaryChunk(String name, int chunk, byte[] data);

	public void writeBinary(String name, byte[] data, int chunkSize);

	public byte[] readBinaryChunk(String name, int chunk);

	public byte[] readBinary(String name);

	public List<?> getItemSeriesValues(CharSequence name);

	public <T> T getItemSeriesValues(CharSequence name, Class<T> type);

	public Map<String, List<Object>> getItemTable(CharSequence... itemnames);

	public List<Map<String, Object>> getItemTablePivot(final CharSequence... itemnames);

	public void setItemTable(final Map<String, List<Object>> table);

	public void setItemTablePivot(final List<Map<String, Object>> pivot);

	public Name getItemValueName(String itemName);

	public NoteClass getNoteClass();

	boolean isDefault();

	boolean isPrivate();

	/**
	 * Add a separate $REF field to display a document in a hierarchical view.
	 * NOTE: you must add code to the select formula in the view that copies the
	 * value of <code>itemName</code> (=$REFxxx) back to original $REF field for
	 * these documents. See this example:
	 * 
	 * <pre>
	 *  &#64;If(Form="YourForm"; FIELD $REF := $REFxxx; "");
	 *  SELECT Form = ...
	 * </pre>
	 */
	public void makeResponse(final lotus.domino.Document doc, String itemName);

	/**
	 * Sets the Note ID system value. This is a restricted function, since it modifies one of the primary note lookup params.
	 * <p>
	 * Implementations may vary, but the general principle is as follows: <br>
	 * 1) If a Note ID coincides with an existing Note ID, the system attempts to overwrite the note with this one.<br>
	 * 2) If a Note ID is set to 0, a new Note is created.
	 * 
	 * @param id Note ID value
	 */
	public void setNoteID(long id);
}
