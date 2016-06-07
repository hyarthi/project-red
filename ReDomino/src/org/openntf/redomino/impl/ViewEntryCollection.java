/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Iterator;
import java.util.Map;

import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.ViewEntry;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.iterators.ViewEntryIterator;
import org.openntf.domino.utils.DominoUtils;

import lotus.domino.Base;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntryCollection
		extends BaseNonThreadSafe<org.openntf.domino.ViewEntryCollection, lotus.domino.ViewEntryCollection, View>
		implements org.openntf.domino.ViewEntryCollection {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewEntryCollection(lotus.domino.ViewEntryCollection delegate, View parent) {
		super(delegate, parent, NOTES_VECOLL);
		// System.out.println("<><> ViewEntryCollection wrapper initialized.");
	}

	@Override
	public void stampAll(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<ViewEntry> iterator() {
		//System.out.println("<><> Iterator called.");
		return new ViewEntryIterator(this);
	}

	@Override
	public Database getAncestorDatabase() {
		return parent.getAncestorDatabase();
	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	@Override
	public void addEntry(Object obh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(Object obj, boolean checkDups) {
		// TODO Auto-generated method stub

	}

	@Override
	public org.openntf.domino.ViewEntryCollection cloneCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Base obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(int noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return getDelegate().getCount();
			else
				// Couch object
				return ((org.openntf.redomino.couch.ViewEntryCollection) beObject).getCount();
		} catch (Throwable t) {
			DominoUtils.handleException(t);
			return 0;
		}
	}

	@Override
	public ViewEntry getEntry(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getFirstEntry() {
		//System.out.println("<><> getFirstEntry()");
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return fromLotus(getDelegate().getFirstEntry(), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				return fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getFirstEntry(),
						ViewEntry.SCHEMA, parent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public ViewEntry getLastEntry() {
		//System.out.println("<><> getLastEntry()");
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return fromLotus(getDelegate().getLastEntry(), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				return fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getLastEntry(),
						ViewEntry.SCHEMA, parent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public ViewEntry getNextEntry() {
		//System.out.println("<><> getNextEntry()");
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return fromLotus(getDelegate().getNextEntry(), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				return fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getNextEntry(),
						ViewEntry.SCHEMA, parent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public ViewEntry getNextEntry(lotus.domino.ViewEntry entry) {
		//System.out.println("<><> getNextEntry(...)");
		try {
			ViewEntry result;
			if (null == beObject)
				// Lotus object - follow ODA
				result = fromLotus(getDelegate().getNextEntry(toLotus(entry)), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				result = fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getNextEntry(entry),
						ViewEntry.SCHEMA, parent);
			entry.recycle();
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public ViewEntry getNthEntry(int n) {
		//System.out.println("<><> getNthEntry()");
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return fromLotus(getDelegate().getNthEntry(n), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				return fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getNthEntry(n),
						ViewEntry.SCHEMA, parent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public View getParent() {
		return parent;
	}

	@Override
	public ViewEntry getPrevEntry() {
		//System.out.println("<><> getPrevEntry()");
		try {
			if (null == beObject)
				// Lotus object - follow ODA
				return fromLotus(getDelegate().getPrevEntry(), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				return fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getPrevEntry(),
						ViewEntry.SCHEMA, parent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public ViewEntry getPrevEntry(lotus.domino.ViewEntry entry) {
		//System.out.println("<><> getPrevEntry(...)");
		try {
			ViewEntry result;
			if (null == beObject)
				// Lotus object - follow ODA
				result = fromLotus(getDelegate().getPrevEntry(toLotus(entry)), ViewEntry.SCHEMA, parent);
			else
				// Couch object
				result = fromCouch(((org.openntf.redomino.couch.ViewEntryCollection) beObject).getPrevEntry(entry),
						ViewEntry.SCHEMA, parent);
			entry.recycle();
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void intersect(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(String noteid) {
		// TODO Auto-generated method stub

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
	public void merge(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(String noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String folderName, boolean createOnFail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll(boolean force) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllFromFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stampAll(String itemName, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(String noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		return parent.getAncestorSession().getFactory();
	}

}
