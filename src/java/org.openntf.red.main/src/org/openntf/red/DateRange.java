package org.openntf.red;

import java.io.Externalizable;
import java.util.Date;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface DateRange.
 */
public interface DateRange extends Base, lotus.domino.DateRange, Externalizable, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#getEndDateTime()
	 */
	@Override
	public DateTime getEndDateTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#getStartDateTime()
	 */
	@Override
	public DateTime getStartDateTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#getText()
	 */
	@Override
	public String getText();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#setEndDateTime(lotus.domino.DateTime)
	 */
	@Override
	public void setEndDateTime(final lotus.domino.DateTime end);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#setStartDateTime(lotus.domino.DateTime)
	 */
	@Override
	public void setStartDateTime(final lotus.domino.DateTime start);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateRange#setText(java.lang.String)
	 */
	@Override
	public void setText(final String text);

	/**
	 * Checks whether a DateRange contains a specific date/time
	 * 
	 * @param dt
	 *            DateTime to check within the range
	 * @return boolean whether the DateTime is within the range
	 * @since org.openntf.domino 2.5.0
	 */
	public boolean contains(final org.openntf.red.DateTime dt);

	/**
	 * Checks whether a DateRange contains a specific Java date/time
	 * 
	 * @param dt
	 *            Date to check within the range
	 * @return boolean whether the Java Date is within the range
	 * @since org.openntf.domino 2.5.0
	 */
	public boolean contains(final Date date);

	public org.openntf.red.DateRange clone();

}
