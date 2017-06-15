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

	/** Logger object. */
	private static final Logger log = Logger.getLogger(ViewEntryCollection.class.getName());
	/** Back-end object used to manipulate data. */
	@SuppressWarnings("rawtypes")
	private org.openntf.red.nsf.endpoint.ViewEntryCollection beObject;

	/**
	 * Default constructor.
	 * 
	 * @param prnt
	 *            Parent view.
	 * @param _beObject
	 *            Back-end object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	protected ViewEntryCollection(View prnt, org.openntf.red.nsf.endpoint.ViewEntryCollection _beObject) {
		super(prnt, Base.NOTES_VECOLL);
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
	 * Not implemented yet.
	 */
	@Override
	public Iterator<ViewEntry> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the ancestor database.
	 * 
	 * @return Ancestor database.
	 * @since 0.4.0
	 */
	@Override
	public Database getAncestorDatabase() {
		return parent.getAncestorDatabase();
	}

	/**
	 * Returns the ancestor session.
	 * 
	 * @return Ancestor session
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
	public void addEntry(Object obh) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void addEntry(Object obj, boolean checkDups) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public org.openntf.red.ViewEntryCollection cloneCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean contains(int noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean contains(String noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void deleteEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void FTSearch(String query) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getEntry(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntry() {
		org.openntf.red.nsf.endpoint.ViewEntry entry = beObject.getFirstEntry();

		if (null == entry)
			return null;
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getNextEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getNextEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getNthEntry(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public View getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getPrevEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public ViewEntry getPrevEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void intersect(int noteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void intersect(String noteid) {
		// TODO Auto-generated method stub

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
	public void merge(int noteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void merge(String noteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putAllInFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void putAllInFolder(String folderName, boolean createOnFail) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeAll(boolean force) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void removeAllFromFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void stampAll(String itemName, Object value) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void subtract(int noteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void subtract(String noteid) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void stampAll(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean contains(lotus.domino.Base obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void intersect(lotus.domino.Base obj) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void merge(lotus.domino.Base obj) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public void subtract(lotus.domino.Base obj) {
		// TODO Auto-generated method stub

	}

}
