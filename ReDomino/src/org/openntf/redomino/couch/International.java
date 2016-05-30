/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.NotesException;
//import lotus.domino.Session;

/**
 * @author Vladimir Kornienko
 *
 */
public class International implements lotus.domino.International, CouchBase {

	private boolean stub;
	private Session parent;
	/**
	 * 
	 */
	public International() {
		// TODO Auto-generated constructor stub
		stub = true;
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
	 * @see lotus.domino.International#getAMString()
	 */
	@Override
	public String getAMString() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getCurrencyDigits()
	 */
	@Override
	public int getCurrencyDigits() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getCurrencySymbol()
	 */
	@Override
	public String getCurrencySymbol() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getDateSep()
	 */
	@Override
	public String getDateSep() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getDecimalSep()
	 */
	@Override
	public String getDecimalSep() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getPMString()
	 */
	@Override
	public String getPMString() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getParent()
	 */
	@Override
	public Session getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getThousandsSep()
	 */
	@Override
	public String getThousandsSep() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getTimeSep()
	 */
	@Override
	public String getTimeSep() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getTimeZone()
	 */
	@Override
	public int getTimeZone() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getToday()
	 */
	@Override
	public String getToday() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getTomorrow()
	 */
	@Override
	public String getTomorrow() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#getYesterday()
	 */
	@Override
	public String getYesterday() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isCurrencySpace()
	 */
	@Override
	public boolean isCurrencySpace() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isCurrencySuffix()
	 */
	@Override
	public boolean isCurrencySuffix() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isCurrencyZero()
	 */
	@Override
	public boolean isCurrencyZero() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isDST()
	 */
	@Override
	public boolean isDST() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isDateDMY()
	 */
	@Override
	public boolean isDateDMY() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isDateMDY()
	 */
	@Override
	public boolean isDateMDY() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isDateYMD()
	 */
	@Override
	public boolean isDateYMD() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.International#isTime24Hour()
	 */
	@Override
	public boolean isTime24Hour() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Session getAncestorSession() {
		return parent;
	}

}
