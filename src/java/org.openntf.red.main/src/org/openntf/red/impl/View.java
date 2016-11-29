/**
 * 
 */
package org.openntf.red.impl;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
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
import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoListener;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class View extends Base<org.openntf.red.Database> implements org.openntf.red.View {
	
	private static Logger log = Logger.getLogger(View.class.getName());
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.View beObject;
	private String name;

	@SuppressWarnings("rawtypes")
	protected View(org.openntf.red.impl.Database prnt, String _name, org.openntf.red.nsf.endpoint.View beview) {
		super(prnt, Base.NOTES_VIEW);
		beObject = beview;
		name = _name;
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
	 * @see org.openntf.red.types.Design#getNoteID()
	 */
	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.Design#getDocument()
	 */
	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.DatabaseDescendant#getAncestorDatabase()
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.types.SessionDescendant#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object arg0) {
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
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Object get(Object arg0) {
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
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object arg0) {
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
	 * @see org.openntf.red.View#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(int)
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(int, int)
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(java.lang.String)
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(java.lang.String, int)
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(lotus.domino.ViewColumn)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#copyColumn(lotus.domino.ViewColumn, int)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn, int destinationIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createColumn()
	 */
	@Override
	public ViewColumn createColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createColumn(int)
	 */
	@Override
	public ViewColumn createColumn(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createColumn(int, java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createColumn(int, java.lang.String, java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle, String formula) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewEntryCollection()
	 */
	@Override
	public ViewEntryCollection createViewEntryCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNav()
	 */
	@Override
	public ViewNavigator createViewNav() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNav(int)
	 */
	@Override
	public ViewNavigator createViewNav(int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFrom(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFrom(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromAllUnread()
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromAllUnread(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromCategory(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromCategory(java.lang.String, int)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromChildren(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromChildren(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromDescendants(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavFromDescendants(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavMaxLevel(int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#createViewNavMaxLevel(int, int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level, int cacheSize) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearch(java.lang.String)
	 */
	@Override
	public int FTSearch(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearch(java.lang.String, int)
	 */
	@Override
	public int FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String, int)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String, int, int)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String, int, int, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String, int, java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.lang.String, int, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector)
	 */
	@Override
	public int FTSearchSorted(Vector query) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector, int)
	 */
	@Override
	public int FTSearchSorted(Vector query, int maxDocs) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector, int, int)
	 */
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector, int, int, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants,
			boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector, int, java.lang.String)
	 */
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#FTSearchSorted(java.util.Vector, int, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column, boolean ascending, boolean exact,
			boolean variants, boolean fuzzy) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAliases()
	 */
	@Override
	public Vector<String> getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllDocumentsByKey(java.lang.Object)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllDocumentsByKey(java.lang.Object, boolean)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllDocumentsByKey(java.util.Vector)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllDocumentsByKey(java.util.Vector, boolean)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllEntries()
	 */
	@Override
	public ViewEntryCollection getAllEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllEntriesByKey(java.lang.Object)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllEntriesByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllEntriesByKey(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) {
		return getAllEntriesByKey(keys, true);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllEntriesByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) {
		org.openntf.red.nsf.endpoint.ViewEntryCollection vecoll = beObject.getAllEntriesByKey(keys, exact);
		
		if (null == vecoll)
			return null;
		
		return new org.openntf.red.impl.ViewEntryCollection(this, vecoll);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllReadEntries()
	 */
	@Override
	public ViewEntryCollection getAllReadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllReadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllReadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllUnreadEntries()
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllUnreadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getBackgroundColor()
	 */
	@Override
	public int getBackgroundColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getChild(lotus.domino.Document)
	 */
	@Override
	public Document getChild(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumn(int)
	 */
	@Override
	public ViewColumn getColumn(int columnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumnNames()
	 */
	@Override
	public Vector<String> getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumns()
	 */
	@Override
	public Vector<ViewColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumnValues(int)
	 */
	@Override
	public Vector<Object> getColumnValues(int column) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getCreated()
	 */
	@Override
	public DateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getDocumentByKey(java.lang.Object)
	 */
	@Override
	public Document getDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getDocumentByKey(java.lang.Object, boolean)
	 */
	@Override
	public Document getDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getDocumentByKey(java.util.Vector)
	 */
	@Override
	public Document getDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getDocumentByKey(java.util.Vector, boolean)
	 */
	@Override
	public Document getDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryByKey(java.lang.Object)
	 */
	@Override
	public ViewEntry getEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntry getEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryByKey(java.util.Vector)
	 */
	@Override
	public ViewEntry getEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryByKey(java.util.Vector, boolean)
	 */
	@Override
	public ViewEntry getEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryCount()
	 */
	@Override
	public int getEntryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstDocument()
	 */
	@Override
	public Document getFirstDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getHeaderLines()
	 */
	@Override
	public int getHeaderLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getHttpURL()
	 */
	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getLastDocument()
	 */
	@Override
	public Document getLastDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getLastModified()
	 */
	@Override
	public DateTime getLastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getLockHolders()
	 */
	@Override
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getNextDocument(lotus.domino.Document)
	 */
	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getNextSibling(lotus.domino.Document)
	 */
	@Override
	public Document getNextSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getNotesURL()
	 */
	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getNthDocument(int)
	 */
	@Override
	public Document getNthDocument(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getParent()
	 */
	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getParentDocument(lotus.domino.Document)
	 */
	@Override
	public Document getParentDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getPrevDocument(lotus.domino.Document)
	 */
	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getPrevSibling(lotus.domino.Document)
	 */
	@Override
	public Document getPrevSibling(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getReaders()
	 */
	@Override
	public Vector<String> getReaders() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getRowLines()
	 */
	@Override
	public int getRowLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getSelectionFormula()
	 */
	@Override
	public String getSelectionFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getSelectionQuery()
	 */
	@Override
	public String getSelectionQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getSpacing()
	 */
	@Override
	public int getSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getTopLevelEntryCount()
	 */
	@Override
	public int getTopLevelEntryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getUniversalID()
	 */
	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getURL()
	 */
	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getViewInheritedName()
	 */
	@Override
	public String getViewInheritedName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isAutoUpdate()
	 */
	@Override
	public boolean isAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isCalendar()
	 */
	@Override
	public boolean isCalendar() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isCategorized()
	 */
	@Override
	public boolean isCategorized() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isConflict()
	 */
	@Override
	public boolean isConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isDefaultView()
	 */
	@Override
	public boolean isDefaultView() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isEnableNoteIDsForCategories()
	 */
	@Override
	public boolean isEnableNoteIDsForCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isFolder()
	 */
	@Override
	public boolean isFolder() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isHierarchical()
	 */
	@Override
	public boolean isHierarchical() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isModified()
	 */
	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isPrivate()
	 */
	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isProhibitDesignRefresh()
	 */
	@Override
	public boolean isProhibitDesignRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isProtectReaders()
	 */
	@Override
	public boolean isProtectReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isQueryView()
	 */
	@Override
	public boolean isQueryView() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock()
	 */
	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock(boolean)
	 */
	@Override
	public boolean lock(boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock(java.lang.String)
	 */
	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(String name, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock(java.util.Vector)
	 */
	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lock(java.util.Vector, boolean)
	 */
	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lockProvisional()
	 */
	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#lockProvisional(java.util.Vector)
	 */
	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#markAllRead()
	 */
	@Override
	public void markAllRead() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String userName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#markAllUnread()
	 */
	@Override
	public void markAllUnread() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String userName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#refresh()
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#remove()
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#removeColumn()
	 */
	@Override
	public void removeColumn() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#removeColumn(int)
	 */
	@Override
	public void removeColumn(int column) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#removeColumn(java.lang.String)
	 */
	@Override
	public void removeColumn(String column) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#resortView()
	 */
	@Override
	public void resortView() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#resortView(java.lang.String)
	 */
	@Override
	public void resortView(String column) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#resortView(java.lang.String, boolean)
	 */
	@Override
	public void resortView(String column, boolean ascending) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setAliases(java.lang.String)
	 */
	@Override
	public void setAliases(String alias) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setAliases(java.util.Vector)
	 */
	@Override
	public void setAliases(Vector aliases) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setAutoUpdate(boolean)
	 */
	@Override
	public void setAutoUpdate(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setBackgroundColor(int)
	 */
	@Override
	public void setBackgroundColor(int color) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setDefaultView(boolean)
	 */
	@Override
	public void setDefaultView(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setEnableNoteIDsForCategories(boolean)
	 */
	@Override
	public void setEnableNoteIDsForCategories(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setProhibitDesignRefresh(boolean)
	 */
	@Override
	public void setProhibitDesignRefresh(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setProtectReaders(boolean)
	 */
	@Override
	public void setProtectReaders(boolean flag) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setReaders(java.util.Vector)
	 */
	@Override
	public void setReaders(Vector readers) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setSelectionFormula(java.lang.String)
	 */
	@Override
	public void setSelectionFormula(String formula) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setSelectionQuery(java.lang.String)
	 */
	@Override
	public void setSelectionQuery(String query) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#setSpacing(int)
	 */
	@Override
	public void setSpacing(int spacing) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#unlock()
	 */
	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAllDocuments()
	 */
	@Override
	public DocumentCollection getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getNoteCollection()
	 */
	@Override
	public NoteCollection getNoteCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getXPageAlt()
	 */
	@Override
	public String getXPageAlt() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isIndexed()
	 */
	@Override
	public boolean isIndexed() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#checkUnique(java.lang.Object, org.openntf.red.Document)
	 */
	@Override
	public boolean checkUnique(Object key, Document srcDoc) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getColumnMap()
	 */
	@Override
	public Map<String, ViewColumn> getColumnMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getIndexType()
	 */
	@Override
	public IndexType getIndexType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isTimeSensitive()
	 */
	@Override
	public boolean isTimeSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isDisableAutoUpdate()
	 */
	@Override
	public boolean isDisableAutoUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isHideEmptyCategories()
	 */
	@Override
	public boolean isHideEmptyCategories() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isDiscardIndex()
	 */
	@Override
	public boolean isDiscardIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isManualRefresh()
	 */
	@Override
	public boolean isManualRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isAutomaticRefresh()
	 */
	@Override
	public boolean isAutomaticRefresh() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#isAutoRefreshAfterFirstUse()
	 */
	@Override
	public boolean isAutoRefreshAfterFirstUse() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getAutoRefreshSeconds()
	 */
	@Override
	public int getAutoRefreshSeconds() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getDiscardHours()
	 */
	@Override
	public int getDiscardHours() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstDocumentByKey(java.lang.Object)
	 */
	@Override
	public Document getFirstDocumentByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstDocumentByKey(java.lang.Object, boolean)
	 */
	@Override
	public Document getFirstDocumentByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstDocumentByKey(java.util.Vector)
	 */
	@Override
	public Document getFirstDocumentByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstDocumentByKey(java.util.Vector, boolean)
	 */
	@Override
	public Document getFirstDocumentByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstEntryByKey(java.lang.Object)
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstEntryByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Object key, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstEntryByKey(java.util.Vector)
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getFirstEntryByKey(java.util.Vector, boolean)
	 */
	@Override
	public ViewEntry getFirstEntryByKey(Vector keys, boolean exact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryAtPosition(java.lang.String, char)
	 */
	@Override
	public ViewEntry getEntryAtPosition(String position, char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getEntryAtPosition(java.lang.String)
	 */
	@Override
	public ViewEntry getEntryAtPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#containsDocument(org.openntf.red.Document)
	 */
	@Override
	public boolean containsDocument(Document doc) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#containsEntry(org.openntf.red.ViewEntry)
	 */
	@Override
	public boolean containsEntry(ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.View#getMetaversalID()
	 */
	@Override
	public String getMetaversalID() {
		// TODO Auto-generated method stub
		return null;
	}

}
