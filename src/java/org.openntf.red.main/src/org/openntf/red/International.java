package org.openntf.red;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface International.<br/>
 * Represents the international settings in the operating environment, for
 * example, the Regional Settings in the Windows Control Panel. When settings
 * change in the operating environment, Notes recognizes the new settings
 * immediately.
 */
public interface International extends Base, lotus.domino.International, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getAMString()
	 */
	@Override
	public String getAMString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getCurrencyDigits()
	 */
	@Override
	public int getCurrencyDigits();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getCurrencySymbol()
	 */
	@Override
	public String getCurrencySymbol();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getDateSep()
	 */
	@Override
	public String getDateSep();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getDecimalSep()
	 */
	@Override
	public String getDecimalSep();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getPMString()
	 */
	@Override
	public String getPMString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getThousandsSep()
	 */
	@Override
	public String getThousandsSep();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getTimeSep()
	 */
	@Override
	public String getTimeSep();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getTimeZone()
	 */
	@Override
	public int getTimeZone();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getToday()
	 */
	@Override
	public String getToday();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getTomorrow()
	 */
	@Override
	public String getTomorrow();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#getYesterday()
	 */
	@Override
	public String getYesterday();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isCurrencySpace()
	 */
	@Override
	public boolean isCurrencySpace();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isCurrencySuffix()
	 */
	@Override
	public boolean isCurrencySuffix();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isCurrencyZero()
	 */
	@Override
	public boolean isCurrencyZero();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isDateDMY()
	 */
	@Override
	public boolean isDateDMY();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isDateMDY()
	 */
	@Override
	public boolean isDateMDY();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isDateYMD()
	 */
	@Override
	public boolean isDateYMD();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isDST()
	 */
	@Override
	public boolean isDST();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.International#isTime24Hour()
	 */
	@Override
	public boolean isTime24Hour();

}
