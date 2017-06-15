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
 * Entity representing a view entry.
 * 
 * @author Vladimir Kornienko
 * @see org.openntf.red.ViewEntry
 * @since 0.4.0
 */
public class ViewEntry extends Base<org.openntf.red.ViewEntryCollection> implements org.openntf.red.ViewEntry {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(ViewEntry.class.getName());
	/** Back-end object used to manipulate data. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.ViewEntry beObject;

	/**
	 * Default constructor.
	 * 
	 * @param prnt
	 *            Parent ViewEntryCollection
	 * @param _beObject
	 *            Back-end object
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	protected ViewEntry(ViewEntryCollection prnt, org.openntf.red.nsf.endpoint.ViewEntry _beObject) {
		super(prnt, Base.NOTES_VIEWENTRY);
		beObject = _beObject;
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
	 * Returns the ancestor database.
	 * 
	 * @return Ancestor database
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
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
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
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
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
	 * Not implemented yet.
	 */
	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getColumnIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
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
	public int getDescendantCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the document represented by this view entry.
	 * 
	 * @return Document represented by this view entry. Null if the entry does
	 *         not represent a document.
	 * @since 0.4.0
	 */
	@Override
	public Document getDocument() {
		String unid = beObject.getDocumentUNID();
		return getAncestorDatabase().getDocumentByUNID(unid);
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
	public int getIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getNoteIDAsInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Base getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getPosition(char separator) {
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
	public boolean getRead(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getSiblingCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDocument() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isTotal() {
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
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns the view that contains this view entry.
	 * 
	 * @return View that contains this view entry.
	 * @since 0.4.0
	 */
	@Override
	public View getParentView() {
		return parent.getParent();
	}

	/**
	 * Returns the value stored in the specified column of this entry.
	 * 
	 * @param columnName
	 *            Name of the column
	 * @return Value in the column
	 * @since 0.4.0
	 */
	@Override
	public Object getColumnValue(String columnName) {
		// TODO add legacy support (returning Vector instead of FastTable)
		return beObject.getColumnValue(columnName);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Map<String, Object> getColumnValuesMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Collection<Object> getColumnValuesEx() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public <T> T getColumnValue(String columnName, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object getCategoryValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
