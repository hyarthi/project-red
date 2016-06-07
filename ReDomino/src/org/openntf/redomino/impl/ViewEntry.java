/**
 * 
 */
package org.openntf.redomino.impl;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.openntf.domino.Base;
import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.impl.ODAPincher;
import org.openntf.domino.impl.View.DominoColumnInfo;
import org.openntf.domino.utils.DominoUtils;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntry extends BaseNonThreadSafe<org.openntf.domino.ViewEntry, lotus.domino.ViewEntry, View>
		implements org.openntf.domino.ViewEntry {

	private Vector<Object> columnValues_;

	private static Method getParentViewMethod;

	static {
		try {
			AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
				@Override
				public Object run() throws Exception {
					getParentViewMethod = lotus.domino.local.ViewEntry.class.getDeclaredMethod("getParentView",
							(Class<?>[]) null);
					getParentViewMethod.setAccessible(true);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			DominoUtils.handleException(e);
		}

	}

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewEntry(lotus.domino.ViewEntry delegate, View parent) {
		super(delegate, parent, NOTES_VIEWENTRY);

		if (null == beObject)
			try {
				if (getAncestorSession().isFixEnabled(Fixes.FORCE_JAVA_DATES)) {
					delegate.setPreferJavaDates(true);
				}
			} catch (NotesException ne) {
				DominoUtils.handleException(ne);
			}
	}

	protected static lotus.domino.View getParentView(final lotus.domino.ViewEntry base) {
		// FIXME get rid of this and merge
		return ODAPincher.getParentView(base);
	}

	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getColumnValue(String columnName) {
		if (null == beObject) {
			// Lotus object - follow ODA
			Map<String, DominoColumnInfo> colInfoMap = ((org.openntf.redomino.impl.View) getParentView())
					.getColumnInfoMap();

			DominoColumnInfo colInfo = colInfoMap.get(columnName);
			if (colInfo != null) {
				int idx = colInfo.getColumnValuesIndex();
				if (idx == 65535) {
					return colInfo.getConstantValue();
				} else {
					Vector<Object> columnValues = getColumnValues(false);
					if (idx < columnValues.size())
						return (columnValues.get(idx));
				}
			}
		} else {
			// Couch object
			// FIXME implement ColumnInfo on Couch and merge - does not wrap Couch DateTime/DateRange objects
			return ((org.openntf.redomino.couch.ViewEntry)beObject).getColumnValue(columnName);
		}
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
		return parent.getAncestorSession();
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
		return getColumnValues(getAncestorSession().isFixEnabled(Fixes.VIEWENTRY_RETURN_CONSTANT_VALUES));
	}

	/**
	 * Returns the columnValues of this entry.
	 * 
	 * @param returnConstants
	 *            this parameter controls if constant values should also be
	 *            returned
	 */
	protected java.util.Vector<Object> getColumnValues(final boolean returnConstants) {
		try {

			if (columnValues_ == null) {
				// cache the columnValues and rely that the caller will NOT
				// modify the objects inside
				if (null == beObject)
					// Lotus object - follow ODA
					columnValues_ = wrapColumnValues(getDelegate().getColumnValues(), this.getAncestorSession());
				else
					// Couch object
					columnValues_ = wrapColumnValues(
							((org.openntf.redomino.couch.ViewEntry) beObject).getColumnValues(),
							this.getAncestorSession());
			}

			if (null == beObject)
				if (returnConstants) {
					List<DominoColumnInfo> colInfos = ((org.openntf.redomino.impl.View) getParentView())
							.getColumnInfos();
					if (colInfos.size() > columnValues_.size()) { // there were
																	// constant
																	// columns

						Vector<Object> ret = new Vector<Object>(colInfos.size());
						for (DominoColumnInfo colInfo : colInfos) {
							int idx = colInfo.getColumnValuesIndex();
							if (idx < 65535) {
								if (idx < columnValues_.size()) {
									ret.add(columnValues_.get(idx));
								} else {
									ret.add(null); // Categories!
								}
							} else {
								ret.add(colInfo.getConstantValue());
							}
						}
						return ret;
					}
				}
			return columnValues_;
		} catch (NotesException e) {
			if (e.id == 4432) {
				return new Vector<Object>();
			}
			DominoUtils.handleException(e);
			return null;
		}
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
		return parent;
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
		return parent.getAncestorSession().getFactory();
	}
}
