/**
 * 
 */
package org.openntf.red.impl;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.DateTime;
import org.openntf.red.Document;
import org.openntf.red.DocumentCollection;
import org.openntf.red.NoteCollection;
import org.openntf.red.Session;
import org.openntf.red.ViewColumn;
import org.openntf.red.ViewEntry;
import org.openntf.red.ViewEntryCollection;
import org.openntf.red.ViewNavigator;

/**
 * Entity representing a view (index).
 * 
 * @author Vladimir Kornienko
 * @see org.openntf.red.View
 * @since 0.4.0
 */
public class View extends Base<org.openntf.red.Database> implements org.openntf.red.View {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(View.class.getName());
	/** Back-end object used to manipulate data. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.View beObject;
	/** View name. */
	private String name;

	/**
	 * Default constructor.
	 * 
	 * @param prnt
	 *            Parent database.
	 * @param _name
	 *            View name.
	 * @param beview
	 *            Back-end object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	protected View(org.openntf.red.impl.Database prnt, String _name, org.openntf.red.nsf.endpoint.View beview) {
		super(prnt, Base.NOTES_VIEW);
		beObject = beview;
		name = _name;
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
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the ancestor database.
	 * 
	 * @return Ancestor database
	 * @since 0.4.0
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent;
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
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsValue(Object arg0) {
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
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object get(Object arg0) {
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
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Object remove(Object arg0) {
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
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn createColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn createColumn(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle, String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection createViewEntryCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNav() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNav(int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearch(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) {
		return getAllEntriesByKey(keys, true);
	}

	/**
	 * Looks up the view for a collection of entries that fit the criteria.
	 * First ordered column is looked up on first key, second - on the second,
	 * etc.
	 * <p>
	 * If the number of keys is less than the number of ordered columns, these
	 * last ordered columns are not filtered by.
	 * <p>
	 * If the number of keys is greater than the number of ordered columns (or
	 * if no ordered columns present in the view), returns an empty collection.
	 * 
	 * @param keys
	 *            Lookup keys
	 * @param exact
	 *            Whether the keys should be looked up exactly as they
	 *            mentioned. If <code>false</code>, partial matches are allowed.
	 * @return The collection of entries that fit the criteria
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) {
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = beObject.getAllEntriesByKey(keys, exact);

		if (null == vecoll)
			return null;

		return new org.openntf.red.impl.ViewEntryCollection(this, vecoll);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllReadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllReadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getBackgroundColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getChild(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewColumn getColumn(int columnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<ViewColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<Object> getColumnValues(int column) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getEntryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getFirstDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getHeaderLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getLastDocument() {
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
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getNextSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getNthDocument(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the parent database. Similar to
	 * <code>getAncestorDatabase()</code> in this case.
	 * 
	 * @return Parent database
	 * @since 0.4.0
	 */
	@Override
	public Database getParent() {
		return parent;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getParentDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getPrevSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Vector<String> getReaders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getRowLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getSelectionFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getSelectionQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getTopLevelEntryCount() {
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
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getViewInheritedName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isCalendar() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isCategorized() {
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
	public boolean isDefaultView() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isEnableNoteIDsForCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isFolder() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isHierarchical() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isProhibitDesignRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isProtectReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isQueryView() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lock(String name, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markAllRead() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markAllRead(String userName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markAllUnread() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void markAllUnread(String userName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

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
	public void removeColumn() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeColumn(int column) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeColumn(String column) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void resortView() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void resortView(String column) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void resortView(String column, boolean ascending) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setAliases(String alias) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setAliases(Vector aliases) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setAutoUpdate(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setBackgroundColor(int color) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setDefaultView(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setEnableNoteIDsForCategories(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setProhibitDesignRefresh(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setProtectReaders(boolean flag) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setReaders(Vector readers) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSelectionFormula(String formula) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSelectionQuery(String query) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void setSpacing(int spacing) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public NoteCollection getNoteCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getXPageAlt() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean checkUnique(Object key, Document srcDoc) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Map<String, ViewColumn> getColumnMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public IndexType getIndexType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isTimeSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDisableAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isHideEmptyCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isDiscardIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isManualRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAutomaticRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isAutoRefreshAfterFirstUse() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getAutoRefreshSeconds() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getDiscardHours() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getFirstDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public Document getFirstDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getFirstDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getFirstDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getEntryAtPosition(String position, char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getEntryAtPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsDocument(Document doc) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean containsEntry(ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet. Under consideration. Not sure if needed.
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

}
