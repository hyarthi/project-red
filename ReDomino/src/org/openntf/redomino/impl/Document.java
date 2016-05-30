/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openntf.domino.AutoMime;
import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.EmbeddedObject;
import org.openntf.domino.Form;
import org.openntf.domino.Item;
import org.openntf.domino.Item.Flags;
import org.openntf.domino.Item.Type;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.events.EnumEvent;
import org.openntf.domino.events.IDominoEvent;
import org.openntf.domino.exceptions.BlockedCrashException;
import org.openntf.domino.exceptions.DataNotCompatibleException;
import org.openntf.domino.exceptions.Domino32KLimitException;
import org.openntf.domino.exceptions.ItemNotFoundException;
import org.openntf.domino.MIMEEntity;
import org.openntf.domino.ext.Name;
import org.openntf.domino.ext.NoteClass;
import org.openntf.domino.utils.Strings;
import org.openntf.domino.ext.Database.Events;
import org.openntf.domino.utils.Documents;
import org.openntf.redomino.utils.Factory;

import org.openntf.domino.utils.LMBCSUtils;

import javolution.util.FastSet;
import javolution.util.FastSortedMap;
import javolution.util.function.Equalities;

import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.transactions.DatabaseTransaction;
import org.openntf.domino.types.BigString;
import org.openntf.domino.types.Null;
import org.openntf.domino.utils.DominoUtils;

import lotus.domino.Base;
import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class Document extends BaseNonThreadSafe<org.openntf.domino.Document, lotus.domino.Document, Database>
		implements org.openntf.domino.Document {

	private static final Logger log_ = Logger.getLogger(Document.class.getName());
	private long threadid_;
	protected Map<String, Set<MIMEEntity>> openMIMEEntities_;
	private boolean mimeWarned_ = false;
	private String noteid_;
	private RemoveType removeType_;
	private boolean shouldWriteItemMeta_ = false; // TODO NTF create rules for
													// making this true
	private FastSet<String> fieldNames_;
	private boolean isNew_;
	private String unid_;
	/** The last modified_. */
	private Date lastModified_;
	/** The last accessed_. */
	private Date lastAccessed_;
	private boolean isDirty_ = false;
	private boolean isQueued_ = false;
	private boolean isRemoveQueued_ = false;

	protected static int MAX_NATIVE_FIELD_SIZE = 32000;
	protected static int MAX_SUMMARY_FIELD_SIZE = 14000;

	protected static enum RemoveType {
		SOFT_FALSE, SOFT_TRUE, HARD_FALSE, HARD_TRUE;
	}

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Document(lotus.domino.Document delegate, Database parent) {
		super(delegate, parent, NOTES_NOTE);
		// TODO Auto-generated constructor stub
		threadid_ = System.identityHashCode(Thread.currentThread());
	}

	/**
	 * @param parent
	 * @param metaData
	 */
	protected Document(Database parent, Object metaData) {
		super(null, parent, NOTES_NOTE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item appendItemValue(String name, Object value, boolean unique) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson(boolean compact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmbeddedObject> getAttachments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form getForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getInitiallyModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastAccessedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.ext.Document getParentDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MIMEEntity testMIMEEntity(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getItemValue(String name, Class<T> type) throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getItemValues(String name, Class<T> type)
			throws ItemNotFoundException, DataNotCompatibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item replaceItemValue(String name, Object value, boolean isSummary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsValue(Object value, String[] itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value, Collection<String> itemnames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValues(Map<String, Object> filterMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetaversalID(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean forceDelegateRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> getItems(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItems(Flags flags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item replaceItemValue(String itemName, Object value, Boolean isSummary, boolean boxCompatibleOnly,
			boolean returnItem) {
		// TODO Auto-generated method stub
		if (null == beObject) {
			// Lotus object - follow ODA
			Item result = null;
			try {

				try {
					result = replaceItemValueLotus(itemName, value, isSummary, returnItem);
				} catch (Exception ex2) {
					if (this.getAutoMime() == AutoMime.WRAP_NONE) {
						// AutoMime completely disabled.
						throw ex2;
					}
					if (!boxCompatibleOnly || ex2 instanceof Domino32KLimitException) {
						// if the value exceeds 32k or we are called from put()
						// (means boxCompatibleOnly=false) we try to write the
						// object as MIME
						result = replaceItemValueCustomData(itemName, "mime-bean", value, returnItem);
					} else if (this.getAutoMime() == AutoMime.WRAP_ALL) {
						// Compatibility mode
						result = replaceItemValueCustomData(itemName, "mime-bean", value, returnItem);
						log_.log(Level.INFO,
								"Writing " + value == null ? "null"
										: value.getClass() + " causes a " + ex2
												+ " as AutoMime.WRAP_ALL is enabled, the value will be wrapped in a MIME bean."
												+ " Consider using 'put' or something similar in your code.");
					} else {
						throw ex2;
					}
				}

				// TODO RPr: What is this?
				if (this.shouldWriteItemMeta_) {
					// If we've gotten this far, it must be legal - update or
					// create the item info map
					Class<?> valueClass;
					if (value == null) {
						valueClass = Null.class;
					} else {
						valueClass = value.getClass();
					}
					Map<String, Map<String, Serializable>> itemInfo = getItemInfo();
					Map<String, Serializable> infoNode = null;
					if (itemInfo.containsKey(itemName)) {
						infoNode = itemInfo.get(itemName);
					} else {
						infoNode = new HashMap<String, Serializable>();
					}
					infoNode.put("valueClass", valueClass.getName());
					infoNode.put("updated", new Date()); // For sanity checking
															// if the value was
															// changed outside
															// of Java
					itemInfo.put(itemName, infoNode);
				}

			} catch (Throwable t) {
				DominoUtils.handleException(t, this, "Item=" + itemName);
			}
			return result;
		} else {
			// Couch object
			// TODO implement ODA stuff
			lotus.domino.Item item = null;
			Item result = null;
			try {
				item = ((org.openntf.redomino.couch.Document) beObject).replaceItemValue(itemName, value);
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DominoUtils.handleException(e, this);
			}
			if (null != item) {
				result = ((org.openntf.redomino.impl.WrapperFactory) getAncestorSession().getFactory()).fromCouch(item,
						Item.SCHEMA, this);
			}
			return result;
		}
	}

	@Override
	public AutoMime getAutoMime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAutoMime(AutoMime value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public Item getFirstItem(String name, boolean returnMime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBinary(String name, byte[] data, int chunkSize) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] readBinaryChunk(String name, int chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] readBinary(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getItemSeriesValues(CharSequence name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getItemSeriesValues(CharSequence name, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Object>> getItemTable(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getItemTablePivot(CharSequence... itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItemTable(Map<String, List<Object>> table) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemTablePivot(List<Map<String, Object>> pivot) {
		// TODO Auto-generated method stub

	}

	@Override
	public Name getItemValueName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteClass getNoteClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeResponse(lotus.domino.Document doc, String itemName) {
		// TODO Auto-generated method stub

	}

	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> asDocMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillExceptionDetails(List<org.openntf.domino.ExceptionDetails.Entry> result) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item appendItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item appendItemValue(String name, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item appendItemValue(String name, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item appendItemValue(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachVCard(Base document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachVCard(Base document, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean closeMIMEEntities() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean savechanges) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean savechanges, String entityitemname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean computeWithForm(boolean dodatatypes, boolean raiseerror) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void convertToMIME() {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int conversiontype) {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int conversiontype, int options) {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyAllItems(lotus.domino.Document doc, boolean replace) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item copyItem(lotus.domino.Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item copyItem(lotus.domino.Item item, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Document copyToDatabase(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity createMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity createMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Document createReplyMessage(boolean toall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextItem createRichTextItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encrypt() {
		// TODO Auto-generated method stub

	}

	@Override
	public String generateXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateXML(Object style, XSLTResultTarget target) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateXML(Writer w) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public EmbeddedObject getAttachment(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<EmbeddedObject> getEmbeddedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getEncryptionKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getFirstItem(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getFolderReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTSearchScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getInitiallyModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getItemValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItemValueCustomData(String itemName, String dataTypeName)
			throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<org.openntf.domino.Base<?>> getItemValueDateTimeArray(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getItemValueDouble(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemValueInteger(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getItemValueString(final String name) {
		String ret;
		getAncestorSession();
		if (Factory.SessionType.isCouchSession(getAncestorSession())) {
			// Couch object
			try {
				// TODO expand this logic
				ret = ((org.openntf.redomino.couch.Document) beObject).getItemValueString(name);

				return ret;
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// Lotus object - follow ODA
			checkMimeOpen();
			// TODO RPr: is this mime-safe?
			try {
				ret = getDelegate().getItemValueString(name);
				if (ret != null && ret.length() != 0)
					return ret;
				MIMEEntity me = getMIMEEntity(name);
				if (me == null)
					return "";
				closeMIMEEntities(false, name);
				Vector<?> v = getItemValue(name);
				ret = "";
				if (v.size() > 0 && v.elementAt(0) instanceof String)
					ret = (String) v.elementAt(0);
				return ret;
			} catch (NotesException e) {
				DominoUtils.handleException(e, this, "Item=" + name);
			}
		}
		return null;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getLastAccessed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getMIMEEntity(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameOfProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() {
		if (null == beObject) {
			// Lotus object - follow ODA
			try {
				return getDelegate().getNoteID();
			} catch (NotesException e) {
				DominoUtils.handleException(e, this);
			}
		} else {
			// Couch object
			try {
				return ((org.openntf.redomino.couch.Document) beObject).getNoteID();
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DominoUtils.handleException(e, this);
			}
		}
		return null;
	}

	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParentDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParentDocumentUNID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRead(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<String> getReceivedItemText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSigner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVerifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEmbedded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasItem(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncryptOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNewNote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPreferJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProfile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveMessageOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSentByAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSignOnSend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names, boolean provisionalok) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeResponse(lotus.domino.Document doc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markUnread() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markUnread(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String name, boolean createonfail) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromFolder(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(String name) {
		if (name == null)
			return; // TODO NTF There's nothing to do here. Maybe we should
					// throw an exception?
		if (null == beObject) {
			// Lotus object - follow ODA
			checkMimeOpen();
			beginEdit();
			try {
				// RPr: it is important to check if this is a MIME entity and
				// remove that this way.
				// Otherwise dangling $FILE items are hanging around in the
				// document
				MIMEEntity mimeChk = getMIMEEntity(name);
				if (mimeChk != null) {
					try {
						mimeChk.remove();
					} finally {
						closeMIMEEntities(true, name);
					}
				}
				if (getAncestorSession().isFixEnabled(Fixes.REMOVE_ITEM)) {
					while (getDelegate().hasItem(name)) {
						getDelegate().removeItem(name);
					}
				} else {
					if (getDelegate().hasItem(name))
						getDelegate().removeItem(name);
				}
				markDirty(name, false);
			} catch (NotesException e) {
				DominoUtils.handleException(e, this, "Item=" + name);
			}
		} else {
			// Couch object
			// TODO implement ODA logic
			try {
				((org.openntf.redomino.couch.Document)beObject).removeItem(name);
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DominoUtils.handleException(e, this, "Item=" + name);
			}
		}
	}

	@Override
	public boolean removePermanently(boolean force) {
		boolean result = false;
		if (null == beObject) {
			// Lotus object - follow ODA
			boolean go = true;
			go = getAncestorDatabase().fireListener(generateEvent(Events.BEFORE_DELETE_DOCUMENT, null));
			if (go) {
				removeType_ = force ? RemoveType.HARD_TRUE : RemoveType.HARD_FALSE;
				if (!queueRemove()) {
					result = forceDelegateRemove();
				} else {
					result = true;
				}
			} else {
				result = false;
			}
			if (result) {
				getAncestorDatabase().fireListener(generateEvent(Events.AFTER_DELETE_DOCUMENT, null));
			}
		} else {
			// Couch object
			// TODO implement ODA logic
			try {
				result = ((org.openntf.redomino.couch.Document) beObject).removePermanently(force);
			} catch (NotesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private boolean queueRemove() {
		if (!isRemoveQueued_) {
			DatabaseTransaction txn = getParentDatabase().getTransaction();
			if (txn != null) {
				// System.out.println("DEBUG: Found a transaction: " + txn + "
				// from parent Database " + getParentDatabase().getApiPath());
				txn.queueRemove(this);
				isRemoveQueued_ = true;
				return true; // we queued this, so whoever asked shouldn't do it
								// yet.
			} else {
				return false; // calling function should just go ahead and
								// execute
			}
		} else { // we already queued this for removal.
			return false;
		}
	}

	@Override
	public boolean renderToRTItem(lotus.domino.RichTextItem rtitem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item replaceItemValue(final String itemName, final Object value) {
		return replaceItemValue(itemName, value, null, true, true);
	}

	@Override
	public Item replaceItemValueCustomData(String itemName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Item replaceItemValueCustomData(final String itemName, final String dataTypeName, final Object value,
			final boolean returnItem) {
		checkMimeOpen();
		lotus.domino.Item result = null;
		try {
			if (!"mime-bean".equalsIgnoreCase(dataTypeName)) {
				// if data-type is != "mime-bean" the object is written in
				// native mode.
				beginEdit();
				result = getDelegate().replaceItemValueCustomData(itemName, dataTypeName, value);
				markDirty(itemName, true);
			} else if (value instanceof Serializable) {

				Documents.saveState((Serializable) value, this, itemName);

				// TODO RPr: Discuss if the other strategies make sense here.
				// In my opinion NoteCollection does work UNTIL the next compact
				// task runs.
				// So it makes NO sense to serialize NoteIDs!
			} else if (value instanceof DocumentCollection) {
				// NoteIDs would be faster for this and, particularly,
				// NoteCollection, but it should be replica-friendly
				DocumentCollection docs = (DocumentCollection) value;
				String[] unids = new String[docs.getCount()];
				int index = 0;
				for (org.openntf.domino.Document doc : docs) {
					unids[index++] = doc.getUniversalID();
				}
				Map<String, String> headers = new HashMap<String, String>(1);
				headers.put("X-Original-Java-Class", "org.openntf.domino.DocumentCollection");
				Documents.saveState(unids, this, itemName, true, headers);

			} else if (value instanceof NoteCollection) {
				// Maybe it'd be faster to use .getNoteIDs - I'm not sure how
				// the performance compares
				// NTF .getNoteIDs() *IS* faster. By about an order of
				// magnitude.
				NoteCollection notes = (NoteCollection) value;
				String[] unids = new String[notes.getCount()];
				String noteid = notes.getFirstNoteID();
				int index = 0;
				while (noteid != null && !noteid.isEmpty()) {
					unids[index++] = notes.getUNID(noteid);
					noteid = notes.getNextNoteID(noteid);
				}
				Map<String, String> headers = new HashMap<String, String>(1);
				headers.put("X-Original-Java-Class", "org.openntf.domino.NoteCollection");
				Documents.saveState(unids, this, itemName, true, headers);

			} else {
				// Check to see if it's a StateHolder
				// TODO RPr: Is this really needed or only a theoretical
				// approach? See above...
				try {
					Class<?> stateHolderClass = Class.forName("javax.faces.component.StateHolder", true,
							Factory.getClassLoader());
					if (stateHolderClass.isInstance(value)) {
						Class<?> facesContextClass = Class.forName("javax.faces.context.FacesContext", true,
								Factory.getClassLoader());
						Method getCurrentInstance = facesContextClass.getMethod("getCurrentInstance");
						Method saveState = stateHolderClass.getMethod("saveState", facesContextClass);
						Serializable state = (Serializable) saveState.invoke(value, getCurrentInstance.invoke(null));
						Map<String, String> headers = new HashMap<String, String>();
						headers.put("X-Storage-Scheme", "StateHolder");
						headers.put("X-Original-Java-Class", value.getClass().getName());
						Documents.saveState(state, this, itemName, true, headers);

					} else {
						throw new IllegalArgumentException(value.getClass()
								+ " is not of type Serializable, DocumentCollection, NoteCollection or StateHolder");
					}
				} catch (ClassNotFoundException cnfe) {
					throw new IllegalArgumentException(
							value.getClass() + " is not of type Serializable, DocumentCollection or NoteCollection");
				}
			}

			if (returnItem) {
				if (result == null) {
					return getFirstItem(itemName, true); // MSt: This is safe
															// now. (Was
															// tested.)
				}
				// NTF if we do a .getFirstItem here and return an item that we
				// MIMEBeaned, it will invalidate the MIME and
				// convert back to a RichTextItem before the document is saved.
				// returnItem *MUST* be treated as false if we've written a MIME
				// attachment.
				// If we didn't write a MIME attachment, then result is already
				// assigned, and therefore we don't need to get it again.
				return fromLotus(result, Item.SCHEMA, this);
			} else {
				return null;
			}
		} catch (Exception e) {
			DominoUtils.handleException(e, this, "Item=" + itemName);
			return null;
		}
	}

	@Override
	public Item replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save() {
		return save(false, false, false);
	}

	@Override
	public boolean save(final boolean force) {
		return save(force, false, false);
	}

	@Override
	public boolean save(final boolean force, final boolean makeresponse) {
		return save(force, makeresponse, false);
	}

	@Override
	public boolean save(boolean force, boolean makeresponse, boolean markread) {
		if (beObject == null) {
			// Lotus object - follow ODA
			checkMimeOpen();
			// System.out.println("Starting save operation...");
			boolean result = false;
			if (removeType_ != null) {
				log_.log(Level.INFO,
						"Save called on a document marked for a transactional delete. So there's no point...");
				return true;
			}
			if (isNewNote() || isDirty()) {
				boolean go = true;
				Database db = getAncestorDatabase();
				go = !db.hasListeners() ? true : db.fireListener(generateEvent(Events.BEFORE_UPDATE_DOCUMENT, null));
				if (go) {
					writeItemInfo();
					fieldNames_ = null;
					isNew_ = false;
					try {
						lotus.domino.Document del = getDelegate();
						if (del != null) {
							result = del.save(force, makeresponse, markread);
							noteid_ = del.getNoteID();
							unid_ = del.getUniversalID();
							isNew_ = noteid_.equals("0") || noteid_.isEmpty();
							invalidateCaches();
						} else {
							log_.severe("Delegate document for " + unid_ + " is NULL!??!");
						}

					} catch (NotesException e) {
						// System.out.println("Exception from attempted
						// save...");
						// e.printStackTrace();
						if (e.text.contains("Database already contains a document with this ID")) {
							String newunid = DominoUtils.toUnid(new Date().getTime());
							String message = "Unable to save a document with id " + getUniversalID()
									+ " because that id already exists. Saving a " + this.getFormName()
									+ (this.hasItem("$$Key") ? " (" + getItemValueString("$$Key") + ")" : "")
									+ " to a different unid instead: " + newunid;
							setUniversalID(newunid);
							try {
								getDelegate().save(force, makeresponse, markread);
								noteid_ = getDelegate().getNoteID();
								isNew_ = noteid_.equals("0") || noteid_.isEmpty();
								System.out.println(message);
								log_.log(Level.WARNING, message/* , t */);
							} catch (NotesException ne) {
								log_.log(Level.SEVERE, "Okay, now it's time to really panic. Sorry...");
								DominoUtils.handleException(e, this);
							}
						} else {
							DominoUtils.handleException(e, this);
						}
					}
					if (result) {
						clearDirty();
						getAncestorDatabase().fireListener(generateEvent(Events.AFTER_UPDATE_DOCUMENT, null));
					}
				} else {
					// System.out.println("Before Update listener blocked
					// save.");
					if (log_.isLoggable(Level.FINE)) {
						log_.log(Level.FINE, "Document " + getNoteID()
								+ " was not saved because the DatabaseListener for update returned false.");
					}
					result = false;
				}
			} else {
				// System.out.println("No changes occured therefore not
				// saving.");
				if (log_.isLoggable(Level.FINE)) {
					log_.log(Level.FINE,
							"Document " + getNoteID() + " was not saved because nothing on it was changed.");
				}
				result = true; // because nothing changed, we don't want to
								// activate any potential failure behavior in
								// the caller
			}
			// System.out.println("Save completed returning " +
			// String.valueOf(result));
			return result;
		} else {
			// Couch object
			// TODO implement ODA caching & logging & failovers
			boolean result = false;
			try {
				result = ((org.openntf.redomino.couch.Document) beObject).save(force, makeresponse, markread);
			} catch (NotesException e) {
				e.printStackTrace();
				DominoUtils.handleException(e, this);
			}
			return result;
		}
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean attachform) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean attachform, String recipient) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void send(boolean attachform, Vector recipients) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(String recipient) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void send(Vector recipients) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setEncryptionKeys(Vector keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEncryptOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSaveMessageOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSignOnSend(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUniversalID(String unid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		System.out.println("<><><> Getting factory for document.");
		return parent.getAncestorSession().getFactory();
	}

	protected boolean checkMimeOpen() {
		if (openMIMEEntities_ != null && !openMIMEEntities_.isEmpty()
				&& getAncestorSession().isFixEnabled(Fixes.MIME_BLOCK_ITEM_INTERFACE) && mimeWarned_ == false) {
			if (getAncestorSession().isOnServer()) {
				System.out.println("******** WARNING ********");
				System.out.println("Document Items were accessed in a document while MIMEEntities are still open.");
				System.out.println("This can cause errors leading to JRE crashes.");
				System.out.println("Document: " + this.noteid_ + " in " + getAncestorDatabase().getApiPath());
				System.out.println("MIMEEntities: " + Strings.join(openMIMEEntities_.keySet(), ", "));
				Throwable t = new Throwable();
				StackTraceElement[] elements = t.getStackTrace();
				for (int i = 0; i < 10; i++) {
					if (elements.length > i) {
						StackTraceElement element = elements[i];
						System.out.println("at " + element.getClassName() + "." + element.getMethodName() + "("
								+ element.getFileName() + ":" + element.getLineNumber() + ")");
					}
				}
				System.out.println("******** END WARNING ********");
				mimeWarned_ = true;
				return true;
			} else {
				throw new BlockedCrashException("There are open MIME items: " + openMIMEEntities_.keySet());
			}
		}
		return false;
	}

	private void writeItemInfo() {
		if (this.shouldWriteItemMeta_) {
			Map<String, Map<String, Serializable>> itemInfo = getItemInfo();
			if (itemInfo != null && itemInfo.size() > 0) {
				boolean convertMime = this.getAncestorSession().isConvertMime();
				this.getAncestorSession().setConvertMime(false);
				try {
					Documents.saveState((Serializable) getItemInfo(), this, "$$ItemInfo", false, null);
				} catch (Throwable e) {
					DominoUtils.handleException(e, this);
				}
				this.getAncestorSession().setConvertMime(convertMime);
			}
		}
	}

	private IDominoEvent generateEvent(final EnumEvent event, final Object payload) {
		return getAncestorDatabase().generateEvent(event, this, payload);
	}

	private Map<String, Map<String, Serializable>> itemInfo_;

	@SuppressWarnings("unchecked")
	protected Map<String, Map<String, Serializable>> getItemInfo() {
		// TODO NTF make this optional
		if (itemInfo_ == null) {
			if (this.hasItem("$$ItemInfo")) {
				if (this.getFirstItem("$$ItemInfo", true).getTypeEx() == Item.Type.MIME_PART) {
					// Then use the existing value
					try {
						itemInfo_ = (Map<String, Map<String, Serializable>>) Documents.restoreState(this, "$$ItemInfo");
					} catch (Throwable t) {
						DominoUtils.handleException(t, this);
					}
				} else {
					// Then destroy it (?)
					this.removeItem("$$ItemInfo");
					itemInfo_ = new FastSortedMap<String, Map<String, Serializable>>();
				}
			} else {
				itemInfo_ = new FastSortedMap<String, Map<String, Serializable>>();
			}
		}
		return itemInfo_;
	}

	protected void invalidateCaches() {
		// RPr: Invalidate cached values
		lastModified_ = null;
		lastAccessed_ = null;
	}

	protected void clearDirty() {
		isDirty_ = false;
		isQueued_ = false;
	}

	@SuppressWarnings("unchecked")
	public Item replaceItemValueLotus(final String itemName, Object value, final Boolean isSummary,
			final boolean returnItem) throws Domino32KLimitException {
		checkMimeOpen();
		// writing a value of "Null" leads to a remove of the item if configured
		// in SESSION
		if (value == null || value instanceof Null) {
			if (hasItem(itemName)) {
				if (getAncestorSession().isFixEnabled(Fixes.REPLACE_ITEM_NULL)) {
					removeItem(itemName);
					return null;
				} else {
					value = "";
				}
			} else {
				return null;
			}
		}

		Vector<Object> dominoFriendlyVec = null;
		Object dominoFriendlyObj = null;
		List<lotus.domino.Base> recycleThis = null;

		boolean isNonSummary = false;
		lotus.domino.Item result;
		try {
			// Special case. If the argument is an Item, just copy it.
			if (value instanceof Item) {
				recycleThis = new ArrayList<lotus.domino.Base>();
				// remove the mime item first, so that it will not collide with
				// MIME etc.
				MIMEEntity mimeChk = getMIMEEntity(itemName);
				if (mimeChk != null) {
					try {
						mimeChk.remove();
					} finally {
						closeMIMEEntities(true, itemName);
					}
				}
				beginEdit();
				result = getDelegate().replaceItemValue(itemName,
						toDominoFriendly(value, getAncestorSession(), recycleThis));
				markDirty(itemName, true);

				s_recycle(result);

				if (returnItem) {
					return getFactory().create(Item.SCHEMA, this, itemName);
				} else {
					return null;
				}
			}

			// first step: Make it domino friendly and put all converted objects
			// into "dominoFriendly"
			if (value instanceof String || value instanceof Integer || value instanceof Double) {
				dominoFriendlyObj = value;
			} else if (value instanceof Collection) {
				if (isFriendlyVector(value)) {
					recycleThis = null;
					dominoFriendlyVec = (Vector<Object>) value;
				} else {
					recycleThis = new ArrayList<lotus.domino.Base>();
					Collection<?> coll = (Collection<?>) value;
					dominoFriendlyVec = new Vector<Object>(coll.size());
					for (Object valNode : coll) {
						if (valNode != null) { // CHECKME: Should NULL values
												// discarded?
							if (valNode instanceof BigString)
								isNonSummary = true;
							dominoFriendlyVec.add(toItemFriendly(valNode, getAncestorSession(), recycleThis));
						}
					}
				}
			} else if (value.getClass().isArray()) {
				recycleThis = new ArrayList<lotus.domino.Base>();
				int lh = Array.getLength(value);
				if (lh > MAX_NATIVE_FIELD_SIZE) { // Then skip making
													// dominoFriendly if it's a
													// primitive
					String cn = value.getClass().getName();
					if (cn.length() == 2) // It is primitive
						throw new Domino32KLimitException();
				}
				dominoFriendlyVec = new Vector<Object>(lh);
				for (int i = 0; i < lh; i++) {
					Object o = Array.get(value, i);
					if (o != null) { // CHECKME: Should NULL values be
										// discarded?
						if (o instanceof BigString)
							isNonSummary = true;
						dominoFriendlyVec.add(toItemFriendly(o, getAncestorSession(), recycleThis));
					}
				}
			} else { // Scalar
				recycleThis = new ArrayList<lotus.domino.Base>();
				if (value instanceof BigString)
					isNonSummary = true;
				dominoFriendlyObj = toItemFriendly(value, getAncestorSession(), recycleThis);
			}
			Object firstElement = null;

			// empty vectors are treated as "null"
			if (dominoFriendlyObj == null) {
				if (dominoFriendlyVec == null || dominoFriendlyVec.size() == 0) {
					return replaceItemValueLotus(itemName, null, isSummary, returnItem);
				} else {
					firstElement = dominoFriendlyVec.get(0);
				}
			} else {
				firstElement = dominoFriendlyObj;
			}

			int payloadOverhead = 0;

			if (dominoFriendlyVec != null && dominoFriendlyVec.size() > 1) { // compute
																				// overhead
																				// first
																				// for
																				// multi
																				// values
				// String lists have an global overhead of 2 bytes (maybe the
				// count of values) + 2 bytes for the length of value
				if (firstElement instanceof String)
					payloadOverhead = 2 + 2 * dominoFriendlyVec.size();
				else
					payloadOverhead = 4;
			}

			// Next step: Type checking + length computation
			//
			// Remark: The special case of a String consisting of only ONE
			// @NewLine (i.e.
			// if (s.equals("\n") || s.equals("\r") || s.equals("\r\n"))
			// where Domino is a bit ailing) won't be extra considered any
			// longer.
			// Neither serialization nor throwing an exception would be
			// reasonable here.

			int payload = payloadOverhead;
			Class<?> firstElementClass;
			if (firstElement instanceof String)
				firstElementClass = String.class;
			else if (firstElement instanceof Number)
				firstElementClass = Number.class;
			else if (firstElement instanceof lotus.domino.DateTime)
				firstElementClass = lotus.domino.DateTime.class;
			else if (firstElement instanceof lotus.domino.DateRange)
				firstElementClass = lotus.domino.DateRange.class;
			// Remark: Domino Java API doesn't accept any Vector of DateRanges
			// (cf. DateRange.java), so the implementation
			// here will work only with Vectors of size 1 (or Vectors of size >=
			// 2000, when Mime Beaning is enabled).
			else
				throw new DataNotCompatibleException(firstElement.getClass() + " is not a supported data type");

			if (dominoFriendlyVec != null) {
				for (Object o : dominoFriendlyVec)
					payload += getLotusPayload(o, firstElementClass);
			} else {
				payload += getLotusPayload(dominoFriendlyObj, firstElementClass);
			}

			if (payload > MAX_NATIVE_FIELD_SIZE) {
				// the datatype is OK, but there's no way to store the data in
				// the Document
				throw new Domino32KLimitException();
			}
			if (firstElementClass == String.class) { // Strings have to be
														// further inspected,
														// because
				// each sign may demand up to 3 bytes in LMBCS
				int calc = ((payload - payloadOverhead) * 3) + payloadOverhead;
				if (calc >= MAX_NATIVE_FIELD_SIZE) {
					if (dominoFriendlyVec != null) {
						payload = payloadOverhead + LMBCSUtils.getPayload(dominoFriendlyVec);
					} else {
						payload = payloadOverhead + LMBCSUtils.getPayload((String) dominoFriendlyObj);
					}
					if (payload > MAX_NATIVE_FIELD_SIZE)
						throw new Domino32KLimitException();
				}
			}
			if (payload > MAX_SUMMARY_FIELD_SIZE) {
				isNonSummary = true;
			}

			MIMEEntity mimeChk = getMIMEEntity(itemName);
			if (mimeChk != null) {
				try {
					mimeChk.remove();
				} finally {
					closeMIMEEntities(true, itemName);
				}
			}
			beginEdit();
			if (dominoFriendlyVec == null || dominoFriendlyVec.size() == 1) {
				result = getDelegate().replaceItemValue(itemName, firstElement);
			} else {
				result = getDelegate().replaceItemValue(itemName, dominoFriendlyVec);
			}
			markDirty(itemName, true);
			if (isSummary == null) {
				// Auto detect
				if (isNonSummary)
					result.setSummary(false);
			} else {
				result.setSummary(isSummary.booleanValue());
			}

			s_recycle(result);
			if (returnItem) {
				// to keep compatibility and speed, return a blank item, that
				// will resurrect on demand
				return getFactory().create(Item.SCHEMA, this, itemName);
				// return fromLotus(result, Item.SCHEMA, this);
			}

		} catch (NotesException ex) {
			DominoUtils.handleException(ex, this, "Item=" + itemName);
		} finally {
			s_recycle(recycleThis);
		}

		return null;
	}

	protected void beginEdit() {

	}

	protected void markDirty(final String fieldName, final boolean itemWritten) {
		markDirtyInt();
		if (itemWritten) {
			keySetInt().add(fieldName);
		} else {
			keySetInt().remove(fieldName);
		}

	}

	protected void markDirtyInt() {
		isDirty_ = true;
		if (!isQueued_) {
			DatabaseTransaction txn = getParentDatabase().getTransaction();
			if (txn != null) {
				txn.queueUpdate(this);
				isQueued_ = true;
			}
		}
	}

	protected FastSet<String> keySetInt() {
		if (fieldNames_ == null) {
			fieldNames_ = new FastSet<String>(Equalities.LEXICAL_CASE_INSENSITIVE);
			//
			// evaluate("@DocFields",...) is 3 times faster than
			// lotus.domino.Document.getItems()
			//
			try {
				// This must be done on the raw session!
				lotus.domino.Session rawSess = toLotus(getAncestorSession());
				Vector<?> v = null;
				try {
					v = rawSess.evaluate("@DocFields", getDelegate());
				} catch (NotesException ne) {
					v = new Vector<Object>();
				}
				for (Object o : v)
					fieldNames_.add((String) o);
			} catch (Exception e) {
				DominoUtils.handleException(e, this);
			}
			// ItemVector items = (ItemVector) this.getItems();
			// String[] names = items.getNames();
			// for (int i = 0; i < names.length; i++) {
			// fieldNames_.add(names[i]);
			// }
		}
		return fieldNames_;
	}

	private int getLotusPayload(final Object o, final Class<?> c) {
		if (c.isAssignableFrom(o.getClass())) {
			if (o instanceof String) {
				return ((String) o).length(); // LMBCS investigation will be
												// done later (in general not
												// necessary)
			}
			if (o instanceof lotus.domino.DateRange) {
				return 16;
			} else {
				return 8; // Number + DateTime has 8 bytes payload
			}
		}
		throw new DataNotCompatibleException("Got a " + o.getClass() + " but " + c + " expected");
	}

	protected boolean isFriendlyVector(final Object value) {
		if (!(value instanceof Vector))
			return false;
		for (Object v : (Vector<?>) value) {
			if (v instanceof String || v instanceof Integer || v instanceof Double) {
				// ok
			} else {
				return false;
			}
		}
		return true;
	}

}
