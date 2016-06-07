/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.Base;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextNavigator implements lotus.domino.RichTextNavigator, CouchBase {

	/**
	 * 
	 */
	public RichTextNavigator() {
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
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#Clone()
	 */
	@Override
	public lotus.domino.RichTextNavigator Clone() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findFirstElement(int)
	 */
	@Override
	public boolean findFirstElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findFirstString(java.lang.String)
	 */
	@Override
	public boolean findFirstString(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findFirstString(java.lang.String, int)
	 */
	@Override
	public boolean findFirstString(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findLastElement(int)
	 */
	@Override
	public boolean findLastElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNextElement()
	 */
	@Override
	public boolean findNextElement() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNextElement(int)
	 */
	@Override
	public boolean findNextElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNextElement(int, int)
	 */
	@Override
	public boolean findNextElement(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNextString(java.lang.String)
	 */
	@Override
	public boolean findNextString(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNextString(java.lang.String, int)
	 */
	@Override
	public boolean findNextString(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#findNthElement(int, int)
	 */
	@Override
	public boolean findNthElement(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getElement()
	 */
	@Override
	public Base getElement() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getFirstElement(int)
	 */
	@Override
	public Base getFirstElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getLastElement(int)
	 */
	@Override
	public Base getLastElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getNextElement()
	 */
	@Override
	public Base getNextElement() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getNextElement(int)
	 */
	@Override
	public Base getNextElement(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getNextElement(int, int)
	 */
	@Override
	public Base getNextElement(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#getNthElement(int, int)
	 */
	@Override
	public Base getNthElement(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#setCharOffset(int)
	 */
	@Override
	public void setCharOffset(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#setPosition(lotus.domino.Base)
	 */
	@Override
	public void setPosition(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextNavigator#setPositionAtEnd(lotus.domino.Base)
	 */
	@Override
	public void setPositionAtEnd(Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
