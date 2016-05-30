/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.MIMEEntity;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;
import org.xml.sax.InputSource;

import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class Item extends BaseNonThreadSafe<org.openntf.domino.Item, lotus.domino.Item, Document> implements org.openntf.domino.Item {

	private String name_;
	
	/**
	 * @param delegate
	 * @param parent
	 */
	protected Item(final lotus.domino.Item delegate, final Document parent) {
		super(delegate, parent, NOTES_ITEM);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Item(final lotus.domino.RichTextItem delegate, final Document parent) {
		super(delegate, parent, NOTES_RTITEM);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param parent
	 * @param name
	 */
	protected Item(final Document parent, final String name) {
		super(null, parent, NOTES_ITEM);
		name_ = name;
	}

	@Override
	public <T> T getValues(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasFlag(Flags flag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadersNamesAuthors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getTypeEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getAncestorDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillExceptionDetails(List<Entry> result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String abstractText(int maxLen, boolean dropVowels, boolean userDict) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendToTextList(String value) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void appendToTextList(Vector values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public org.openntf.domino.Item copyItemToDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Item copyItemToDocument(lotus.domino.Document doc, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getDateTimeValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputSource getInputSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MIMEEntity getMIMEEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(int maxLen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueCustomData() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValueCustomData(String dataTypeName) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getValueCustomDataBytes(String dataTypeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<DateTime> getValueDateTimeArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getValueDouble() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValueInteger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValueLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Object> getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNames() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveToDisk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSummary() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public org.w3c.dom.Document parseXML(boolean validate) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAuthors(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDateTimeValue(lotus.domino.DateTime dateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEncrypted(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNames(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProtected(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReaders(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSaveToDisk(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSigned(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSummary(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueCustomData(Object userObj) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueCustomData(String dataTypeName, Object userObj) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueCustomDataBytes(String dataTypeName, byte[] byteArray) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueDouble(double value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueInteger(int value) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setValues(Vector values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueString(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformXML(Object style, XSLTResultTarget result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
