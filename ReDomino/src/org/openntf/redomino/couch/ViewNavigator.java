/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewNavigator implements lotus.domino.ViewNavigator, CouchBase {

	/**
	 * 
	 */
	public ViewNavigator() {
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
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getBufferMaxEntries()
	 */
	@Override
	public int getBufferMaxEntries() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getCacheSize()
	 */
	@Override
	public int getCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getChild()
	 */
	@Override
	public ViewEntry getChild() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getChild(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getChild(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getCurrent()
	 */
	@Override
	public ViewEntry getCurrent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getEntryOptions()
	 */
	@Override
	public int getEntryOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getFirst()
	 */
	@Override
	public ViewEntry getFirst() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getFirstDocument()
	 */
	@Override
	public ViewEntry getFirstDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getLast()
	 */
	@Override
	public ViewEntry getLast() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getLastDocument()
	 */
	@Override
	public ViewEntry getLastDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getMaxLevel()
	 */
	@Override
	public int getMaxLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNext()
	 */
	@Override
	public ViewEntry getNext() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNext(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getNext(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNextCategory()
	 */
	@Override
	public ViewEntry getNextCategory() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNextDocument()
	 */
	@Override
	public ViewEntry getNextDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNextSibling()
	 */
	@Override
	public ViewEntry getNextSibling() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNextSibling(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getNextSibling(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getNth(int)
	 */
	@Override
	public ViewEntry getNth(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getParent()
	 */
	@Override
	public ViewEntry getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getParent(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getParent(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getParentView()
	 */
	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPos(java.lang.String, char)
	 */
	@Override
	public ViewEntry getPos(String arg0, char arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrev()
	 */
	@Override
	public ViewEntry getPrev() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrev(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getPrev(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrevCategory()
	 */
	@Override
	public ViewEntry getPrevCategory() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrevDocument()
	 */
	@Override
	public ViewEntry getPrevDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrevSibling()
	 */
	@Override
	public ViewEntry getPrevSibling() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#getPrevSibling(lotus.domino.ViewEntry)
	 */
	@Override
	public ViewEntry getPrevSibling(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoChild()
	 */
	@Override
	public boolean gotoChild() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoChild(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoChild(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoEntry(java.lang.Object)
	 */
	@Override
	public boolean gotoEntry(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoFirst()
	 */
	@Override
	public boolean gotoFirst() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoFirstDocument()
	 */
	@Override
	public boolean gotoFirstDocument() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoLast()
	 */
	@Override
	public boolean gotoLast() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoLastDocument()
	 */
	@Override
	public boolean gotoLastDocument() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNext()
	 */
	@Override
	public boolean gotoNext() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNext(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoNext(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNextCategory()
	 */
	@Override
	public boolean gotoNextCategory() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNextDocument()
	 */
	@Override
	public boolean gotoNextDocument() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNextSibling()
	 */
	@Override
	public boolean gotoNextSibling() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoNextSibling(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoNextSibling(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoParent()
	 */
	@Override
	public boolean gotoParent() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoParent(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoParent(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPos(java.lang.String, char)
	 */
	@Override
	public boolean gotoPos(String arg0, char arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrev()
	 */
	@Override
	public boolean gotoPrev() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrev(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoPrev(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrevCategory()
	 */
	@Override
	public boolean gotoPrevCategory() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrevDocument()
	 */
	@Override
	public boolean gotoPrevDocument() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrevSibling()
	 */
	@Override
	public boolean gotoPrevSibling() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#gotoPrevSibling(lotus.domino.ViewEntry)
	 */
	@Override
	public boolean gotoPrevSibling(lotus.domino.ViewEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#markAllRead()
	 */
	@Override
	public void markAllRead() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#markAllUnread()
	 */
	@Override
	public void markAllUnread() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setAutoExpandGuidance(int, lotus.domino.NoteCollection, lotus.domino.NoteCollection)
	 */
	@Override
	public void setAutoExpandGuidance(int arg0, lotus.domino.NoteCollection arg1, lotus.domino.NoteCollection arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setAutoExpandGuidance(int, int[], int[])
	 */
	@Override
	public void setAutoExpandGuidance(int arg0, int[] arg1, int[] arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setBufferMaxEntries(int)
	 */
	@Override
	public void setBufferMaxEntries(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setCacheGuidance(int)
	 */
	@Override
	public void setCacheGuidance(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setCacheGuidance(int, int)
	 */
	@Override
	public void setCacheGuidance(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setCacheSize(int)
	 */
	@Override
	public void setCacheSize(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setEntryOptions(int)
	 */
	@Override
	public void setEntryOptions(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#setMaxLevel(int)
	 */
	@Override
	public void setMaxLevel(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ViewNavigator#skip(int)
	 */
	@Override
	public int skip(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
