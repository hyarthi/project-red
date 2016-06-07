/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.Base;
import lotus.domino.Database;
import lotus.domino.DateTime;
import lotus.domino.Document;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class DocumentCollection implements lotus.domino.DocumentCollection, CouchBase {

	/**
	 * 
	 */
	public DocumentCollection() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#FTSearch(java.lang.String)
	 */
	@Override
	public void FTSearch(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#FTSearch(java.lang.String, int)
	 */
	@Override
	public void FTSearch(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#addDocument(lotus.domino.Document)
	 */
	@Override
	public void addDocument(Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#addDocument(lotus.domino.Document, boolean)
	 */
	@Override
	public void addDocument(Document arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#cloneCollection()
	 */
	@Override
	public lotus.domino.DocumentCollection cloneCollection() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#contains(int)
	 */
	@Override
	public boolean contains(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#contains(lotus.domino.Base)
	 */
	@Override
	public boolean contains(Base arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#deleteDocument(lotus.domino.Document)
	 */
	@Override
	public void deleteDocument(Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getCount()
	 */
	@Override
	public int getCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getDocument(lotus.domino.Document)
	 */
	@Override
	public Document getDocument(Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getFirstDocument()
	 */
	@Override
	public Document getFirstDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getLastDocument()
	 */
	@Override
	public Document getLastDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getNextDocument()
	 */
	@Override
	public Document getNextDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getNextDocument(lotus.domino.Document)
	 */
	@Override
	public Document getNextDocument(Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getNthDocument(int)
	 */
	@Override
	public Document getNthDocument(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getParent()
	 */
	@Override
	public Database getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getPrevDocument()
	 */
	@Override
	public Document getPrevDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getPrevDocument(lotus.domino.Document)
	 */
	@Override
	public Document getPrevDocument(Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getQuery()
	 */
	@Override
	public String getQuery() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#getUntilTime()
	 */
	@Override
	public DateTime getUntilTime() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#intersect(int)
	 */
	@Override
	public void intersect(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#intersect(java.lang.String)
	 */
	@Override
	public void intersect(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#intersect(lotus.domino.Base)
	 */
	@Override
	public void intersect(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#isSorted()
	 */
	@Override
	public boolean isSorted() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#markAllRead()
	 */
	@Override
	public void markAllRead() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#markAllUnread()
	 */
	@Override
	public void markAllUnread() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#merge(int)
	 */
	@Override
	public void merge(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#merge(java.lang.String)
	 */
	@Override
	public void merge(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#merge(lotus.domino.Base)
	 */
	@Override
	public void merge(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#putAllInFolder(java.lang.String)
	 */
	@Override
	public void putAllInFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#putAllInFolder(java.lang.String, boolean)
	 */
	@Override
	public void putAllInFolder(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#removeAll(boolean)
	 */
	@Override
	public void removeAll(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#removeAllFromFolder(java.lang.String)
	 */
	@Override
	public void removeAllFromFolder(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#stampAll(java.lang.String, java.lang.Object)
	 */
	@Override
	public void stampAll(String arg0, Object arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#subtract(int)
	 */
	@Override
	public void subtract(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#subtract(java.lang.String)
	 */
	@Override
	public void subtract(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#subtract(lotus.domino.Base)
	 */
	@Override
	public void subtract(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.DocumentCollection#updateAll()
	 */
	@Override
	public void updateAll() throws NotesException {
		// TODO Auto-generated method stub

	}

}
