/**
 * 
 */
package org.openntf.red.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.DateTime;
import org.openntf.red.Document;
import org.openntf.red.MIMEEntity;
import org.openntf.red.Session;
//import org.openntf.red.events.EnumEvent;
//import org.openntf.red.events.IDominoEvent;
//import org.openntf.red.events.IDominoListener;
import org.xml.sax.InputSource;

//import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * Entity representing a document item.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.Item
 */
public class Item extends Base<Document> implements org.openntf.red.Item {
	/** Logger object. */
	private static final Logger log = Logger.getLogger(Item.class.getName());

	/** Back-end object that manipulates data. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Field beObject;

	/**
	 * Default constructor.
	 * 
	 * @param prnt
	 *            Parent document
	 * @param _beObject
	 *            Back-end object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	Item(Document prnt, org.openntf.red.nsf.endpoint.Field _beObject) {
		super(prnt, Base.NOTES_ITEM);
		// TODO Auto-generated constructor stub
		beObject = _beObject;
	}

	/**
	 * Under consideration. Not sure if needed.
	 * 
	 * @param classId
	 */
	Item(int classId) {
		super(classId);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the ancestor document.
	 * 
	 * @return Ancestor document.
	 * @since 0.4.0
	 */
	@Override
	public Document getAncestorDocument() {
		return parent;
	}

	/**
	 * Returns the ancestor database.
	 * 
	 * @return Ancestor database.
	 * @since 0.4.0
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent.getAncestorDatabase();
	}

	/**
	 * Returns the ancestor session.
	 * 
	 * @return Ancestor session.
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
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String abstractText(int maxLen, boolean dropVowels, boolean userDict) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void appendToTextList(String value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void appendToTextList(Vector values) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Item copyItemToDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.Item copyItemToDocument(lotus.domino.Document doc, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getDateTimeValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public InputSource getInputSource() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public InputStream getInputStream() {
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
	public MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getName() {
		return beObject.getName();
	}

	/**
	 * Returns parent document.<br>
	 * Similar to <code>getAncestorDocument()</code> in this case.
	 * 
	 * @return Parent document
	 * @since 0.4.0
	 */
	@Override
	public Document getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getText(int maxLen) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the item Notes type code (e.g. TEXT - 1280).
	 * 
	 * @return Item type code.
	 * @since 0.4.0
	 */
	@Override
	public int getType() {
		return beObject.getType();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getValueCustomData() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getValueCustomData(String dataTypeName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public byte[] getValueCustomDataBytes(String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<DateTime> getValueDateTimeArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public double getValueDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getValueInteger() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getValueLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets a {@link List} of item values.<br>
	 * Should be more effective than {@link Vector}.
	 * 
	 * @return A {@link List} of item values.
	 * @since 0.4.0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getValuesEx() {
		return beObject.getValue();
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAuthors() {
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
	public boolean isNames() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isProtected() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isSaveToDisk() {
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
	public boolean isSummary() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.w3c.dom.Document parseXML(boolean validate) throws IOException {
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
	public void setAuthors(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setDateTimeValue(lotus.domino.DateTime dateTime) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEncrypted(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setNames(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setProtected(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setReaders(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSaveToDisk(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSigned(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSummary(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueCustomData(Object userObj) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueCustomData(String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueCustomDataBytes(String dataTypeName, byte[] byteArray) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueDouble(double value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueInteger(int value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setValues(Vector values) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setValueString(String value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void transformXML(Object style, XSLTResultTarget result) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public <T> T getValues(Class<T> type) {
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
	public boolean hasFlag(Flags flag) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isReadersNamesAuthors() {
		// TODO Auto-generated method stub
		return false;
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
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

}
