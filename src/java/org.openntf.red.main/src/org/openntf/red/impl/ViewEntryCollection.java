/**
 * 
 */
package org.openntf.red.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.openntf.red.Database;
import org.openntf.red.Session;
import org.openntf.red.View;
import org.openntf.red.ViewEntry;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntryCollection extends Base<org.openntf.red.View> implements org.openntf.red.ViewEntryCollection {
	
	private static Logger log = Logger.getLogger(ViewEntryCollection.class.getName());
	
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.ViewEntryCollection beObject;

	@SuppressWarnings("rawtypes")
	protected ViewEntryCollection(View prnt, org.openntf.red.nsf.endpoint.ViewEntryCollection _beObject) {
		super(prnt, Base.NOTES_VECOLL);
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
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<ViewEntry> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	 * @see org.openntf.red.ViewEntryCollection#addEntry(java.lang.Object)
	 */
	@Override
	public void addEntry(Object obh) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#addEntry(java.lang.Object, boolean)
	 */
	@Override
	public void addEntry(Object obj, boolean checkDups) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#cloneCollection()
	 */
	@Override
	public org.openntf.red.ViewEntryCollection cloneCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#contains(int)
	 */
	@Override
	public boolean contains(int noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#deleteEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public void deleteEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#FTSearch(java.lang.String)
	 */
	@Override
	public void FTSearch(String query) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#FTSearch(java.lang.String, int)
	 */
	@Override
	public void FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getEntry(java.lang.Object)
	 */
	@Override
	public ViewEntry getEntry(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getFirstEntry()
	 */
	@SuppressWarnings("unused")
	@Override
	public ViewEntry getFirstEntry() {
		org.openntf.red.nsf.endpoint.ViewEntry entry = beObject.getFirstEntry();
		
		if(null == entry)
			return null;
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getLastEntry()
	 */
	@Override
	public ViewEntry getLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getNextEntry()
	 */
	@Override
	public ViewEntry getNextEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getNextEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getNextEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getNthEntry(int)
	 */
	@Override
	public ViewEntry getNthEntry(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getParent()
	 */
	@Override
	public View getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getPrevEntry()
	 */
	@Override
	public ViewEntry getPrevEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getPrevEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getPrevEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#getQuery()
	 */
	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#intersect(int)
	 */
	@Override
	public void intersect(int noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#intersect(java.lang.String)
	 */
	@Override
	public void intersect(String noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#markAllRead()
	 */
	@Override
	public void markAllRead() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String userName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#markAllUnread()
	 */
	@Override
	public void markAllUnread() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String userName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#merge(int)
	 */
	@Override
	public void merge(int noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#merge(java.lang.String)
	 */
	@Override
	public void merge(String noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#putAllInFolder(java.lang.String)
	 */
	@Override
	public void putAllInFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#putAllInFolder(java.lang.String, boolean)
	 */
	@Override
	public void putAllInFolder(String folderName, boolean createOnFail) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#removeAll(boolean)
	 */
	@Override
	public void removeAll(boolean force) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#removeAllFromFolder(java.lang.String)
	 */
	@Override
	public void removeAllFromFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#stampAll(java.lang.String, java.lang.Object)
	 */
	@Override
	public void stampAll(String itemName, Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#subtract(int)
	 */
	@Override
	public void subtract(int noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#subtract(java.lang.String)
	 */
	@Override
	public void subtract(String noteid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#updateAll()
	 */
	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.ViewEntryCollection#stampAll(java.util.Map)
	 */
	@Override
	public void stampAll(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(lotus.domino.Base obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void intersect(lotus.domino.Base obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(lotus.domino.Base obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtract(lotus.domino.Base obj) {
		// TODO Auto-generated method stub
		
	}

}
