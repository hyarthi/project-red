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
 * @author Vladimir Kornienko
 *
 */
public class Item extends Base<Document> implements org.openntf.red.Item {
	
	private static Logger log = Logger.getLogger(Item.class.getName());
	
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.Field beObject;

	@SuppressWarnings("rawtypes")
	Item(Document prnt, org.openntf.red.nsf.endpoint.Field _beObject) {
		super(prnt, Base.NOTES_ITEM);
		// TODO Auto-generated constructor stub
		beObject = _beObject;
	}
	
	Item(int classId) {
		super(classId);
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
	 * @see org.openntf.red.types.DocumentDescendant#getAncestorDocument()
	 */
	@Override
	public Document getAncestorDocument() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.DatabaseDescendant#getAncestorDatabase()
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent.getAncestorDatabase();
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.SessionDescendant#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ExceptionDetails#fillExceptionDetails(java.util.List)
	 */
	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#abstractText(int, boolean, boolean)
	 */
	@Override
	public String abstractText(int maxLen, boolean dropVowels, boolean userDict) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#appendToTextList(java.lang.String)
	 */
	@Override
	public void appendToTextList(String value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#appendToTextList(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void appendToTextList(Vector values) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#copyItemToDocument(lotus.domino.Document)
	 */
	@Override
	public org.openntf.red.Item copyItemToDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#copyItemToDocument(lotus.domino.Document, java.lang.String)
	 */
	@Override
	public org.openntf.red.Item copyItemToDocument(lotus.domino.Document doc, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getDateTimeValue()
	 */
	@Override
	public DateTime getDateTimeValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getInputSource()
	 */
	@Override
	public InputSource getInputSource() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getInputStream()
	 */
	@Override
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getLastModified()
	 */
	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getMIMEEntity()
	 */
	@Override
	public MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getName()
	 */
	@Override
	public String getName() {
		return beObject.getName();
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getParent()
	 */
	@Override
	public Document getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getReader()
	 */
	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getText()
	 */
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getText(int)
	 */
	@Override
	public String getText(int maxLen) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getType()
	 */
	@Override
	public int getType() {
		return beObject.getType();
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueCustomData()
	 */
	@Override
	public Object getValueCustomData() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueCustomData(java.lang.String)
	 */
	@Override
	public Object getValueCustomData(String dataTypeName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueCustomDataBytes(java.lang.String)
	 */
	@Override
	public byte[] getValueCustomDataBytes(String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueDateTimeArray()
	 */
	@Override
	public Vector<DateTime> getValueDateTimeArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueDouble()
	 */
	@Override
	public double getValueDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueInteger()
	 */
	@Override
	public int getValueInteger() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueLength()
	 */
	@Override
	public int getValueLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValues()
	 */
	@Override
	public Vector<Object> getValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getValuesEx() {
		return beObject.getValue();
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValueString()
	 */
	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isAuthors()
	 */
	@Override
	public boolean isAuthors() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isEncrypted()
	 */
	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isNames()
	 */
	@Override
	public boolean isNames() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isProtected()
	 */
	@Override
	public boolean isProtected() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isReaders()
	 */
	@Override
	public boolean isReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isSaveToDisk()
	 */
	@Override
	public boolean isSaveToDisk() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isSigned()
	 */
	@Override
	public boolean isSigned() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isSummary()
	 */
	@Override
	public boolean isSummary() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#parseXML(boolean)
	 */
	@Override
	public org.w3c.dom.Document parseXML(boolean validate) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setAuthors(boolean)
	 */
	@Override
	public void setAuthors(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setDateTimeValue(lotus.domino.DateTime)
	 */
	@Override
	public void setDateTimeValue(lotus.domino.DateTime dateTime) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setEncrypted(boolean)
	 */
	@Override
	public void setEncrypted(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setNames(boolean)
	 */
	@Override
	public void setNames(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setProtected(boolean)
	 */
	@Override
	public void setProtected(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setReaders(boolean)
	 */
	@Override
	public void setReaders(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setSaveToDisk(boolean)
	 */
	@Override
	public void setSaveToDisk(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setSigned(boolean)
	 */
	@Override
	public void setSigned(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setSummary(boolean)
	 */
	@Override
	public void setSummary(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueCustomData(java.lang.Object)
	 */
	@Override
	public void setValueCustomData(Object userObj) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueCustomData(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setValueCustomData(String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueCustomDataBytes(java.lang.String, byte[])
	 */
	@Override
	public void setValueCustomDataBytes(String dataTypeName, byte[] byteArray) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueDouble(double)
	 */
	@Override
	public void setValueDouble(double value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueInteger(int)
	 */
	@Override
	public void setValueInteger(int value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValues(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setValues(Vector values) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#setValueString(java.lang.String)
	 */
	@Override
	public void setValueString(String value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#transformXML(java.lang.Object, lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void transformXML(Object style, XSLTResultTarget result) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getValues(java.lang.Class)
	 */
	@Override
	public <T> T getValues(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getLastModifiedDate()
	 */
	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#hasFlag(org.openntf.red.Item.Flags)
	 */
	@Override
	public boolean hasFlag(Flags flag) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#isReadersNamesAuthors()
	 */
	@Override
	public boolean isReadersNamesAuthors() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#markDirty()
	 */
	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.Item#getTypeEx()
	 */
	@Override
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

}
