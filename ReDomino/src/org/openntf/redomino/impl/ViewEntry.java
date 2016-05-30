/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.openntf.domino.Base;
import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.impl.ODAPincher;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntry extends BaseNonThreadSafe<org.openntf.domino.ViewEntry, lotus.domino.ViewEntry, View> implements
org.openntf.domino.ViewEntry {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewEntry(lotus.domino.ViewEntry delegate, View parent) {
		super(delegate, parent, NOTES_VIEWENTRY);
		// TODO Auto-generated constructor stub
	}
	
	protected static lotus.domino.View getParentView(final lotus.domino.ViewEntry base) {
		return ODAPincher.getParentView(base);
	}

	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getColumnValue(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getColumnValuesMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> getColumnValuesEx() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getColumnValue(String columnName, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCategoryValue() {
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
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object key) {
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
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(Object key) {
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
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Object> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDescendantCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTSearchScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNoteIDAsInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Base<?> getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPosition(char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRead(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSiblingCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPreferJavaDates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTotal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPreferJavaDates(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}
