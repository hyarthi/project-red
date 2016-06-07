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
public class ColorObject implements lotus.domino.ColorObject, CouchBase {

	/**
	 * 
	 */
	public ColorObject() {
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
	 * @see lotus.domino.ColorObject#getBlue()
	 */
	@Override
	public int getBlue() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getGreen()
	 */
	@Override
	public int getGreen() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getHue()
	 */
	@Override
	public int getHue() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getLuminance()
	 */
	@Override
	public int getLuminance() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getNotesColor()
	 */
	@Override
	public int getNotesColor() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getRed()
	 */
	@Override
	public int getRed() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#getSaturation()
	 */
	@Override
	public int getSaturation() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#setHSL(int, int, int)
	 */
	@Override
	public int setHSL(int arg0, int arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#setNotesColor(int)
	 */
	@Override
	public void setNotesColor(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ColorObject#setRGB(int, int, int)
	 */
	@Override
	public int setRGB(int arg0, int arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

}
