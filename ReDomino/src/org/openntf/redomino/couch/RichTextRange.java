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
public class RichTextRange implements lotus.domino.RichTextRange, CouchBase {

	/**
	 * 
	 */
	public RichTextRange() {
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
	 * @see lotus.domino.RichTextRange#Clone()
	 */
	@Override
	public lotus.domino.RichTextRange Clone() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#findandReplace(java.lang.String, java.lang.String)
	 */
	@Override
	public int findandReplace(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#findandReplace(java.lang.String, java.lang.String, long)
	 */
	@Override
	public int findandReplace(String arg0, String arg1, long arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#getNavigator()
	 */
	@Override
	public RichTextNavigator getNavigator() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#getStyle()
	 */
	@Override
	public RichTextStyle getStyle() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#getTextParagraph()
	 */
	@Override
	public String getTextParagraph() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#getTextRun()
	 */
	@Override
	public String getTextRun() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#getType()
	 */
	@Override
	public int getType() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#reset(boolean, boolean)
	 */
	@Override
	public void reset(boolean arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#setBegin(lotus.domino.Base)
	 */
	@Override
	public void setBegin(lotus.domino.Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#setEnd(lotus.domino.Base)
	 */
	@Override
	public void setEnd(lotus.domino.Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextRange#setStyle(lotus.domino.RichTextStyle)
	 */
	@Override
	public void setStyle(lotus.domino.RichTextStyle arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
