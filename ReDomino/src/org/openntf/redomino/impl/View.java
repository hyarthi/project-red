/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Session;
import org.openntf.domino.ViewColumn;
import org.openntf.domino.ViewEntry;
import org.openntf.domino.ViewEntryCollection;
import org.openntf.domino.ViewNavigator;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.ext.NoteCollection;
import org.openntf.domino.impl.View.DominoColumnInfo;
import org.openntf.domino.utils.DominoUtils;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class View extends BaseThreadSafe<org.openntf.domino.View, lotus.domino.View, Database>
		implements org.openntf.domino.View {
	private Vector<String> aliases_;
	private String name_;
	private String universalId_;

	/**
	 * @param delegate
	 * @param parent
	 */
	protected View(lotus.domino.View delegate, Database parent) {
		super(delegate, parent, NOTES_VIEW);
		// TODO Auto-generated constructor stub
		if (null == beObject)
			initialize(delegate);
	}

	@SuppressWarnings("unchecked")
	private void initialize(final lotus.domino.View delegate) {
		try {
			aliases_ = delegate.getAliases();
			name_ = delegate.getName();
			universalId_ = delegate.getUniversalID();
		} catch (NotesException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteCollection getNoteCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getXPageAlt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUnique(Object key, Document srcDoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, ViewColumn> getColumnMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexType getIndexType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTimeSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDisableAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHideEmptyCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDiscardIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isManualRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutomaticRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoRefreshAfterFirstUse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAutoRefreshSeconds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDiscardHours() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document getFirstDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getFirstDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Document getFirstDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Document getFirstDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getFirstEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getFirstEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getEntryAtPosition(String position, char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getEntryAtPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsDocument(Document doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEntry(ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getAncestorDatabase() {
		return parent;
	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
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
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public ViewColumn copyColumn(int sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn copyColumn(int sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn copyColumn(String sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn copyColumn(String sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn createColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn createColumn(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn createColumn(int position, String columnTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn createColumn(int position, String columnTitle, String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection createViewEntryCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNav() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNav(int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFrom(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFrom(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromAllUnread() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromAllUnread(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromChildren(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromChildren(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavMaxLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewNavigator createViewNavMaxLevel(int level, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int FTSearch(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllDocumentsByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getAllDocumentsByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection getAllEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) {
		return getAllEntriesByKey(key, false);
	}

	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		List<lotus.domino.Base> recycleThis = new ArrayList<lotus.domino.Base>();
		try {
			if (null == beObject) {
				// Lotus object - follow ODA
				Object domKey = null;
				if (key != null) {
					domKey = toDominoFriendly(key, getAncestorSession(), recycleThis);
				}
				lotus.domino.ViewEntryCollection rawColl;
				if (domKey instanceof java.util.Vector) {
					rawColl = getDelegate().getAllEntriesByKey((Vector<?>) domKey, exact);
				} else {
					rawColl = getDelegate().getAllEntriesByKey(domKey, exact);
				}
				return fromLotus(rawColl, ViewEntryCollection.SCHEMA, this);
			} else {
				// Couch object
				ViewEntryCollection result = fromCouch(
						((org.openntf.redomino.couch.View) beObject).getAllEntriesByKey(key),
						ViewEntryCollection.SCHEMA, this);
				//System.out.println("<><> VEC wrapped: " + result);
				return result;
			}
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) {
		return getAllEntriesByKey((Object) keys, false);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) {
		return getAllEntriesByKey((Object) keys, exact);
	}

	@Override
	public ViewEntryCollection getAllReadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection getAllReadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection getAllUnreadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntryCollection getAllUnreadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBackgroundColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document getChild(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewColumn getColumn(int columnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ViewColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getColumnValues(int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document getFirstDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeaderLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getLastDocument() {
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNextSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNthDocument(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getParentDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getPrevSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getReaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSelectionFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectionQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTopLevelEntryCount() {
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
	public String getViewInheritedName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCalendar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCategorized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefaultView() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnableNoteIDsForCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFolder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHierarchical() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProhibitDesignRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtectReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQueryView() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalOk) {
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
	public boolean lock(Vector names, boolean provisionalOk) {
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
	public void markAllRead() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllRead(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeColumn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeColumn(int column) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeColumn(String column) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resortView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resortView(String column) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resortView(String column, boolean ascending) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAliases(String alias) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setAliases(Vector aliases) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAutoUpdate(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBackgroundColor(int color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaultView(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnableNoteIDsForCategories(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProhibitDesignRefresh(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProtectReaders(boolean flag) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setReaders(Vector readers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionFormula(String formula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionQuery(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpacing(int spacing) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void resurrect() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		return parent.getAncestorSession().getFactory();
	}

	protected Map<String, DominoColumnInfo> getColumnInfoMap() {
		// TODO Auto-generated method stub
		return null;
	}

	protected List<DominoColumnInfo> getColumnInfos() {
		// TODO Auto-generated method stub
		return null;
	}

}
