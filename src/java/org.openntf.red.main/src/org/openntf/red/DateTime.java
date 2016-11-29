package org.openntf.red;

import java.io.Externalizable;
import java.util.Calendar;
import java.util.Date;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface DateTime.
 */
public interface DateTime extends Base, lotus.domino.DateTime, Externalizable, SessionDescendant, Cloneable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustDay(int)
	 */
	@Override
	public void adjustDay(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustDay(int, boolean)
	 */
	@Override
	public void adjustDay(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustHour(int)
	 */
	@Override
	public void adjustHour(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustHour(int, boolean)
	 */
	@Override
	public void adjustHour(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMinute(int)
	 */
	@Override
	public void adjustMinute(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMinute(int, boolean)
	 */
	@Override
	public void adjustMinute(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMonth(int)
	 */
	@Override
	public void adjustMonth(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMonth(int, boolean)
	 */
	@Override
	public void adjustMonth(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustSecond(int)
	 */
	@Override
	public void adjustSecond(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustSecond(int, boolean)
	 */
	@Override
	public void adjustSecond(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustYear(int)
	 */
	@Override
	public void adjustYear(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustYear(int, boolean)
	 */
	@Override
	public void adjustYear(final int n, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#convertToZone(int, boolean)
	 */
	@Override
	public void convertToZone(final int zone, final boolean isDST);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getDateOnly()
	 */
	@Override
	public String getDateOnly();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getGMTTime()
	 */
	@Override
	public String getGMTTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getLocalTime()
	 */
	@Override
	public String getLocalTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getParent()
	 */
	@Override
	public org.openntf.red.Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getTimeOnly()
	 */
	@Override
	public String getTimeOnly();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getTimeZone()
	 */
	@Override
	public int getTimeZone();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getZoneTime()
	 */
	@Override
	public String getZoneTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#isDST()
	 */
	@Override
	public boolean isDST();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setAnyDate()
	 */
	@Override
	public void setAnyDate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setAnyTime()
	 */
	@Override
	public void setAnyTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalDate(int, int, int)
	 */
	@Override
	public void setLocalDate(final int year, final int month, final int day);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalDate(int, int, int, boolean)
	 */
	@Override
	public void setLocalDate(final int year, final int month, final int day, final boolean preserveLocalTime);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.util.Calendar)
	 */
	@Override
	public void setLocalTime(final java.util.Calendar calendar);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.util.Date)
	 */
	@Override
	public void setLocalTime(final Date date);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(int, int, int, int)
	 */
	@Override
	public void setLocalTime(final int hour, final int minute, final int second, final int hundredth);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.lang.String)
	 */
	@Override
	public void setLocalTime(final String time);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setNow()
	 */
	@Override
	public void setNow();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#timeDifference(lotus.domino.DateTime)
	 */
	@Override
	public int timeDifference(final lotus.domino.DateTime dt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#timeDifferenceDouble(lotus.domino.DateTime)
	 */
	@Override
	public double timeDifferenceDouble(final lotus.domino.DateTime dt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#toJavaDate()
	 */
	@Override
	public Date toJavaDate();

	// /**
	// * To java cal.
	// *
	// * @return Java Calendar object, same as used internally by
	// org.openntf.domino.DateTime class
	// */
	// public Calendar toJavaCal();

	/**
	 * Compares current date with another and returns boolean of whether they
	 * are the same.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not the two dates are the same
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean equals(final org.openntf.red.DateTime compareDate);

	/**
	 * Compares two DateTimes to see if they are the same time (including
	 * millisecond), ignoring date element
	 * 
	 * @param comparDate
	 *            DateTime to compare to the current DateTime
	 * @return boolean true if time is the same
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean equalsIgnoreDate(final org.openntf.red.DateTime compareDate);

	/**
	 * Compares two DateTimes to see if they are the same date, ignoring the
	 * time element
	 * 
	 * @param comparDate
	 *            DateTime to compare to the current DateTime
	 * @return boolean true if date is the same
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean equalsIgnoreTime(final org.openntf.red.DateTime compareDate);

	/**
	 * Compares current date with another and returns boolean of whether current
	 * date is after parameter.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not current date is after the parameter
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean isAfter(final org.openntf.red.DateTime compareDate);

	/**
	 * Checks whether the DateTime is defined as any time, so just a specific
	 * Date
	 * 
	 * @return boolean, whether the DateTime is a date-only value (e.g.
	 *         [1/1/2013])
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean isAnyTime();

	/**
	 * Checks whether the DateTime is defined as any date, so just a specific
	 * Time
	 * 
	 * @return boolean, whether the DateTime is a time-only value (e.g. [1:00
	 *         PM])
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean isAnyDate();

	/**
	 * Compares current date with another and returns boolean of whether current
	 * date is before parameter.
	 * 
	 * @param comparDate
	 *            DateTime to compare to current date
	 * @return boolean, whether or not current date is before the parameter
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean isBefore(final org.openntf.red.DateTime compareDate);

	/**
	 * Returns a Java Calendar object for the DateTime object, same as used
	 * internally by org.openntf.domino.DateTime class
	 * 
	 * @return Java Calendar object representing the DateTime object
	 * @since org.openntf.domino 1.0.0
	 */
	public Calendar toJavaCal();

	public org.openntf.red.DateTime clone();
}
