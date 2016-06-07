/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.Base;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntryCollection implements lotus.domino.ViewEntryCollection, CouchBase {
	private JsonJavaArray raw;
	private View parent;
	private int idx;
	private JsonJavaObject columns;

	ViewEntryCollection(View _parent, JsonJavaArray _raw, JsonJavaObject _columns) {
		parent = _parent;
		raw = _raw;
		idx = 0;
		columns = _columns;
		//System.out.println("<><> raw: " + raw.toString());
		//System.out.println("<><> columns: " + columns.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector v) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#FTSearch(java.lang.String)
	 */
	@Override
	public void FTSearch(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#FTSearch(java.lang.String, int)
	 */
	@Override
	public void FTSearch(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#addEntry(java.lang.Object)
	 */
	@Override
	public void addEntry(Object arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#addEntry(java.lang.Object, boolean)
	 */
	@Override
	public void addEntry(Object arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#cloneCollection()
	 */
	@Override
	public lotus.domino.ViewEntryCollection cloneCollection() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#contains(int)
	 */
	@Override
	public boolean contains(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#contains(lotus.domino.Base)
	 */
	@Override
	public boolean contains(Base arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#deleteEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public void deleteEntry(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getCount()
	 */
	@Override
	public int getCount() throws NotesException {
		return raw.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getEntry(java.lang.Object)
	 */
	@Override
	public ViewEntry getEntry(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getFirstEntry()
	 */
	@Override
	public ViewEntry getFirstEntry() throws NotesException {
		idx = 0;
		JsonJavaObject entry = raw.getAsObject(idx);

		return new ViewEntry(this, idx, entry, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getLastEntry()
	 */
	@Override
	public ViewEntry getLastEntry() throws NotesException {
		idx = raw.size() - 1;
		JsonJavaObject entry = raw.getAsObject(idx);

		return new ViewEntry(this, idx, entry, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getNextEntry()
	 */
	@Override
	public ViewEntry getNextEntry() throws NotesException {
		idx++;
		if (idx >= raw.size())
			return null;
		JsonJavaObject entry = raw.getAsObject(idx);

		return new ViewEntry(this, idx, entry, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.ViewEntryCollection#getNextEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getNextEntry(lotus.domino.ViewEntry entry) throws NotesException {
		if (!(entry instanceof CouchBase))
			// FIXME change exception type
			throw new IllegalArgumentException("Illegal data type.");
		ViewEntry e = (ViewEntry) entry;
		int index = e.getIndex() + 1;
		if (index >= raw.size())
			return null;
		JsonJavaObject je = raw.getAsObject(index);

		return new ViewEntry(this, index, je, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getNthEntry(int)
	 */
	@Override
	public ViewEntry getNthEntry(int n) throws NotesException {
		if (n >= raw.size())
			return null;
		JsonJavaObject entry = raw.getAsObject(n - 1);
		
		return new ViewEntry(this, n - 1, entry, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getParent()
	 */
	@Override
	public View getParent() throws NotesException {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getPrevEntry()
	 */
	@Override
	public ViewEntry getPrevEntry() throws NotesException {
		idx--;
		if (idx < 0)
			return null;
		JsonJavaObject entry = raw.getAsObject(idx);

		return new ViewEntry(this, idx, entry, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.ViewEntryCollection#getPrevEntry(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getPrevEntry(lotus.domino.ViewEntry entry) throws NotesException {
		if (!(entry instanceof CouchBase))
			// FIXME change exception type
			throw new IllegalArgumentException("Illegal data type.");
		ViewEntry e = (ViewEntry) entry;
		int index = e.getIndex() - 1;
		if (index < 0)
			return null;
		JsonJavaObject je = raw.getAsObject(index);

		return new ViewEntry(this, index, je, columns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#getQuery()
	 */
	@Override
	public String getQuery() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#intersect(int)
	 */
	@Override
	public void intersect(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#intersect(java.lang.String)
	 */
	@Override
	public void intersect(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#intersect(lotus.domino.Base)
	 */
	@Override
	public void intersect(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#markAllRead()
	 */
	@Override
	public void markAllRead() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#markAllUnread()
	 */
	@Override
	public void markAllUnread() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#merge(int)
	 */
	@Override
	public void merge(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#merge(java.lang.String)
	 */
	@Override
	public void merge(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#merge(lotus.domino.Base)
	 */
	@Override
	public void merge(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#putAllInFolder(java.lang.String)
	 */
	@Override
	public void putAllInFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#putAllInFolder(java.lang.String,
	 * boolean)
	 */
	@Override
	public void putAllInFolder(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#removeAll(boolean)
	 */
	@Override
	public void removeAll(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.ViewEntryCollection#removeAllFromFolder(java.lang.String)
	 */
	@Override
	public void removeAllFromFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#stampAll(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void stampAll(String arg0, Object arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#subtract(int)
	 */
	@Override
	public void subtract(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#subtract(java.lang.String)
	 */
	@Override
	public void subtract(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#subtract(lotus.domino.Base)
	 */
	@Override
	public void subtract(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntryCollection#updateAll()
	 */
	@Override
	public void updateAll() throws NotesException {
		// TODO Auto-generated method stub

	}

}
