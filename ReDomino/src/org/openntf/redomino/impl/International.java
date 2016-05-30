/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class International extends BaseNonThreadSafe<org.openntf.domino.International, lotus.domino.International, Session> implements
org.openntf.domino.International {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected International(lotus.domino.International delegate, Session parent) {
		super(delegate, parent, NOTES_INTL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAMString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrencyDigits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrencySymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDateSep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDecimalSep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPMString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getThousandsSep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeSep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTimeZone() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getToday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTomorrow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getYesterday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCurrencySpace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrencySuffix() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrencyZero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateDMY() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateMDY() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateYMD() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDST() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTime24Hour() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
