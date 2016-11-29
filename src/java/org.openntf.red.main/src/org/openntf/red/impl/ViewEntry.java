/**
 * 
 */
package org.openntf.red.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.Document;
import org.openntf.red.Session;
import org.openntf.red.View;
import org.openntf.red.ViewEntryCollection;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntry extends Base<org.openntf.red.ViewEntryCollection> implements org.openntf.red.ViewEntry {
	
	private static Logger log = Logger.getLogger(ViewEntry.class.getName());
	
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.ViewEntry beObject;

	@SuppressWarnings("rawtypes")
	protected ViewEntry(ViewEntryCollection prnt, org.openntf.red.nsf.endpoint.ViewEntry _beObject) {
		super(prnt, Base.NOTES_VIEWENTRY);
		beObject = _beObject;
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
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
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
	 * @see java.util.Map#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
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
	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
	 * @see org.openntf.red.ViewEntry#getChildCount()
	 */
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnIndentLevel()
	 */
	@Override
	public int getColumnIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnValues()
	 */
	@Override
	public Vector<Object> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getDescendantCount()
	 */
	@Override
	public int getDescendantCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getDocument()
	 */
	@Override
	public Document getDocument() {
		String unid = beObject.getDocumentUNID();
		return getAncestorDatabase().getDocumentByUNID(unid);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getIndentLevel()
	 */
	@Override
	public int getIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getNoteID()
	 */
	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getNoteIDAsInt()
	 */
	@Override
	public int getNoteIDAsInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getParent()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Base getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getPosition(char)
	 */
	@Override
	public String getPosition(char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getRead()
	 */
	@Override
	public boolean getRead() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getSiblingCount()
	 */
	@Override
	public int getSiblingCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getUniversalID()
	 */
	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isCategory()
	 */
	@Override
	public boolean isCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isConflict()
	 */
	@Override
	public boolean isConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isDocument()
	 */
	@Override
	public boolean isDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isTotal()
	 */
	@Override
	public boolean isTotal() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getParentView()
	 */
	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnValue(java.lang.String)
	 */
	@Override
	public Object getColumnValue(String columnName) {
		// TODO add legacy support (returning Vector instead of FastTable)
		return beObject.getColumnValue(columnName);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnValuesMap()
	 */
	@Override
	public Map<String, Object> getColumnValuesMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnValuesEx()
	 */
	@Override
	public Collection<Object> getColumnValuesEx() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getColumnValue(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> T getColumnValue(String columnName, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getPosition()
	 */
	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getMetaversalID()
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntry#getCategoryValue()
	 */
	@Override
	public Object getCategoryValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
