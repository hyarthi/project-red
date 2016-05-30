/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

import org.openntf.domino.exceptions.OpenNTFNotesException;
import org.openntf.redomino.utils.Strings;
import org.openntf.redomino.utils.TimeZones;

import lotus.domino.NotesException;
//import lotus.domino.Session;

/**
 * @author Vladimir Kornienko
 *
 */
public class DateTime<P extends lotus.domino.Base & CouchBase> implements lotus.domino.DateTime, CouchBase {
	private Calendar date, ztdate;
	private TimeZones tz;
	private Session parent;
	private Type type;

	public enum Type {
		DATEONLY, TIMEONLY, DATETIME,;
	}

	/**
	 * 
	 */
	DateTime(Session _parent) {
		date = Calendar.getInstance();
		tz = TimeZones.getByArea(date.getTimeZone().getID());
		type = Type.DATETIME;
		parent = _parent;
	}
	
	DateTime(Session _parent, int _index, Type _type, String _internal_value) {
		tz = TimeZones.get(_index);
		type = _type;
		date = Calendar.getInstance(TimeZone.getTimeZone(tz.getArea()));
		castFromStorage(_internal_value);
		parent = _parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		date = null;
		ztdate = null;
		tz = null;
		type = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector objects) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustDay(int)
	 */
	@Override
	public void adjustDay(int n) throws NotesException {
		date.add(Calendar.DAY_OF_MONTH, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustDay(int, boolean)
	 */
	@Override
	public void adjustDay(int n, boolean preserveLocalTime) throws NotesException {
		int hour = 0, minute = 0;
		if (preserveLocalTime) {
			hour = date.get(Calendar.HOUR_OF_DAY);
			minute = date.get(Calendar.MINUTE);
		}
		adjustDay(n);
		if (preserveLocalTime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustHour(int)
	 */
	@Override
	public void adjustHour(int n) throws NotesException {
		date.add(Calendar.HOUR_OF_DAY, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustHour(int, boolean)
	 */
	@Override
	public void adjustHour(int n, boolean preservelocaltime) throws NotesException {
		int hour = 0, minute = 0;
		if (preservelocaltime) {
			hour = (date.get(Calendar.HOUR_OF_DAY) + n) % 24;
			minute = date.get(Calendar.MINUTE);
		}
		adjustHour(n);
		if (preservelocaltime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMinute(int)
	 */
	@Override
	public void adjustMinute(int n) throws NotesException {
		date.add(Calendar.MINUTE, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMinute(int, boolean)
	 */
	@Override
	public void adjustMinute(int n, boolean preservelocaltime) throws NotesException {
		// TODO Auto-generated method stub
		int hour = 0, minute = 0;
		if (preservelocaltime) {
			hour = (date.get(Calendar.HOUR_OF_DAY) + n / 60) % 24;
			minute = (date.get(Calendar.MINUTE) + n) % 60;
		}
		adjustMinute(n);
		if (preservelocaltime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMonth(int)
	 */
	@Override
	public void adjustMonth(int n) throws NotesException {
		date.add(Calendar.MONTH, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustMonth(int, boolean)
	 */
	@Override
	public void adjustMonth(int n, boolean preservelocaltime) throws NotesException {
		int hour = 0, minute = 0;
		if (preservelocaltime) {
			hour = date.get(Calendar.HOUR_OF_DAY);
			minute = date.get(Calendar.MINUTE);
		}
		adjustMonth(n);
		if (preservelocaltime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustSecond(int)
	 */
	@Override
	public void adjustSecond(int n) throws NotesException {
		date.add(Calendar.SECOND, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustSecond(int, boolean)
	 */
	@Override
	public void adjustSecond(int n, boolean preservelocaltime) throws NotesException {
		int hour = 0, minute = 0;
		if (preservelocaltime) {
			hour = (date.get(Calendar.HOUR_OF_DAY) + n / 3600) % 24;
			minute = (date.get(Calendar.MINUTE) + n / 60) % 60;
		}
		adjustSecond(n);
		if (preservelocaltime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustYear(int)
	 */
	@Override
	public void adjustYear(int n) throws NotesException {
		date.add(Calendar.YEAR, n);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#adjustYear(int, boolean)
	 */
	@Override
	public void adjustYear(int n, boolean preservelocaltime) throws NotesException {
		int hour = 0, minute = 0;
		if (preservelocaltime) {
			hour = date.get(Calendar.HOUR_OF_DAY);
			minute = date.get(Calendar.MINUTE);
		}
		adjustYear(n);
		if (preservelocaltime) {
			date.set(Calendar.HOUR_OF_DAY, hour);
			date.set(Calendar.MINUTE, minute);
		}
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#convertToZone(int, boolean)
	 */
	@Override
	public void convertToZone(int zone, boolean isDST) throws NotesException {
		String[] tzs;
		TimeZone timez = null;
		if (zone > 12 || zone < -12)
			throw new OpenNTFNotesException("Time zone value out of bounds.");
		if (null == tz)
			return;
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DAY_OF_MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minute = date.get(Calendar.MINUTE);

		tzs = TimeZone.getAvailableIDs(zone * 3600000);
		ztdate = (Calendar) date.clone();

		for (String strtz : tzs) {
			timez = TimeZone.getTimeZone(strtz);
			if (timez.useDaylightTime() == isDST)
				break;
			timez = null;
		}

		if (null == timez)
			throw new OpenNTFNotesException(
					"No time zone found for offset " + zone + " and " + (isDST ? "" : "no ") + "DST.");
		tz = TimeZones.getByArea(timez.getID());
		ztdate.setTimeZone(timez);

		ztdate.set(Calendar.YEAR, year);
		ztdate.set(Calendar.MONTH, month);
		ztdate.set(Calendar.DAY_OF_MONTH, day);
		ztdate.set(Calendar.HOUR_OF_DAY, hour);
		ztdate.set(Calendar.MINUTE, minute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getDateOnly()
	 */
	@Override
	public String getDateOnly() throws NotesException {
		if (type.equals(Type.TIMEONLY))
			return null; // throw exception?
		if (getParent().getInternational().isDateDMY()) {
			return String.format(
					Strings.FORMAT_DATEONLY_DMY.replace("{dsep}", getParent().getInternational().getDateSep()), date);
		} else if (getParent().getInternational().isDateMDY()) {
			return String.format(
					Strings.FORMAT_DATEONLY_MDY.replace("{dsep}", getParent().getInternational().getDateSep()), date);
		} else if (getParent().getInternational().isDateYMD()) {
			return String.format(
					Strings.FORMAT_DATEONLY_YMD.replace("{dsep}", getParent().getInternational().getDateSep()), date);
		} else {
			// TODO throw exception
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getGMTTime()
	 */
	@Override
	public String getGMTTime() throws NotesException {
		Calendar utcdate = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		utcdate.setTime(date.getTime());
		if (type.equals(Type.DATETIME)) {
			if (getParent().getInternational().isDateDMY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_DMY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (utcdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							utcdate);
				else
					return String.format(Strings.FORMAT_DATETIME_DMY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), utcdate);
			} else if (getParent().getInternational().isDateMDY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_MDY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (utcdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							utcdate);
				else
					return String.format(Strings.FORMAT_DATETIME_MDY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), utcdate);
			} else if (getParent().getInternational().isDateYMD()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_YMD_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (utcdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							utcdate);
				else
					return String.format(Strings.FORMAT_DATETIME_YMD_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), utcdate);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.DATEONLY)) {
			if (getParent().getInternational().isDateDMY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_DMY.replace("{dsep}", getParent().getInternational().getDateSep()),
						utcdate);
			} else if (getParent().getInternational().isDateMDY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_MDY.replace("{dsep}", getParent().getInternational().getDateSep()),
						utcdate);
			} else if (getParent().getInternational().isDateYMD()) {
				return String.format(
						Strings.FORMAT_DATEONLY_YMD.replace("{dsep}", getParent().getInternational().getDateSep()),
						utcdate);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.TIMEONLY)) {
			if (getParent().getInternational().getAMString() != null)
				return String.format(
						Strings.FORMAT_TIMEONLY_AM.replace("{tsep}", getParent().getInternational().getTimeSep())
								.replace("{ampm}",
										(utcdate.get(Calendar.HOUR_OF_DAY) > 12)
												? getParent().getInternational().getPMString()
												: getParent().getInternational().getAMString()),
						utcdate);
			else
				return String.format(
						Strings.FORMAT_TIMEONLY_NOAM.replace("{tsep}", getParent().getInternational().getTimeSep()),
						utcdate);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getLocalTime()
	 */
	@Override
	public String getLocalTime() throws NotesException {
		if (type.equals(Type.DATETIME)) {
			if (getParent().getInternational().isDateDMY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_DMY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()).replace("{ampm}",
									(date.get(Calendar.HOUR_OF_DAY) > 12) ? getParent().getInternational().getPMString()
											: getParent().getInternational().getAMString()),
							date);
				else
					return String.format(Strings.FORMAT_DATETIME_DMY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), date);
			} else if (getParent().getInternational().isDateMDY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_MDY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()).replace("{ampm}",
									(date.get(Calendar.HOUR_OF_DAY) > 12) ? getParent().getInternational().getPMString()
											: getParent().getInternational().getAMString()),
							date);
				else
					return String.format(Strings.FORMAT_DATETIME_MDY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), date);
			} else if (getParent().getInternational().isDateYMD()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_YMD_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()).replace("{ampm}",
									(date.get(Calendar.HOUR_OF_DAY) > 12) ? getParent().getInternational().getPMString()
											: getParent().getInternational().getAMString()),
							date);
				else
					return String.format(Strings.FORMAT_DATETIME_YMD_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), date);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.DATEONLY)) {
			if (getParent().getInternational().isDateDMY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_DMY.replace("{dsep}", getParent().getInternational().getDateSep()),
						date);
			} else if (getParent().getInternational().isDateMDY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_MDY.replace("{dsep}", getParent().getInternational().getDateSep()),
						date);
			} else if (getParent().getInternational().isDateYMD()) {
				return String.format(
						Strings.FORMAT_DATEONLY_YMD.replace("{dsep}", getParent().getInternational().getDateSep()),
						date);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.TIMEONLY)) {
			if (getParent().getInternational().getAMString() != null)
				return String.format(
						Strings.FORMAT_TIMEONLY_AM.replace("{tsep}", getParent().getInternational().getTimeSep())
								.replace("{ampm}",
										(date.get(Calendar.HOUR_OF_DAY) > 12)
												? getParent().getInternational().getPMString()
												: getParent().getInternational().getAMString()),
						date);
			else
				return String.format(
						Strings.FORMAT_TIMEONLY_NOAM.replace("{tsep}", getParent().getInternational().getTimeSep()),
						date);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getParent()
	 */
	@Override
	public Session getParent() throws NotesException {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getTimeOnly()
	 */
	@Override
	public String getTimeOnly() throws NotesException {
		if (type.equals(Type.DATEONLY))
			return null; // exception?
		if (getParent().getInternational().getAMString() != null)
			return String.format(Strings.FORMAT_TIMEONLY_AM
					.replace("{tsep}", getParent().getInternational().getTimeSep()).replace("{ampm}",
							(date.get(Calendar.HOUR_OF_DAY) > 12) ? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
					date);
		else
			return String.format(
					Strings.FORMAT_TIMEONLY_NOAM.replace("{tsep}", getParent().getInternational().getTimeSep()), date);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getTimeZone()
	 */
	@Override
	public int getTimeZone() throws NotesException {
		if (null == tz)
			return 0;
		int result = date.getTimeZone().getRawOffset() / 3600000;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#getZoneTime()
	 */
	@Override
	public String getZoneTime() throws NotesException {
		if (null == ztdate)
			return getLocalTime();
		if (type.equals(Type.DATETIME)) {
			if (getParent().getInternational().isDateDMY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_DMY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (ztdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							ztdate);
				else
					return String.format(Strings.FORMAT_DATETIME_DMY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), ztdate);
			} else if (getParent().getInternational().isDateMDY()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_MDY_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (ztdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							ztdate);
				else
					return String.format(Strings.FORMAT_DATETIME_MDY_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), ztdate);
			} else if (getParent().getInternational().isDateYMD()) {
				if (getParent().getInternational().getAMString() != null)
					return String.format(Strings.FORMAT_DATETIME_YMD_AM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep())
							.replace("{ampm}", (ztdate.get(Calendar.HOUR_OF_DAY) > 12)
									? getParent().getInternational().getPMString()
									: getParent().getInternational().getAMString()),
							ztdate);
				else
					return String.format(Strings.FORMAT_DATETIME_YMD_NOAM
							.replace("{dsep}", getParent().getInternational().getDateSep())
							.replace("{tsep}", getParent().getInternational().getTimeSep()), ztdate);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.DATEONLY)) {
			if (getParent().getInternational().isDateDMY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_DMY.replace("{dsep}", getParent().getInternational().getDateSep()),
						ztdate);
			} else if (getParent().getInternational().isDateMDY()) {
				return String.format(
						Strings.FORMAT_DATEONLY_MDY.replace("{dsep}", getParent().getInternational().getDateSep()),
						ztdate);
			} else if (getParent().getInternational().isDateYMD()) {
				return String.format(
						Strings.FORMAT_DATEONLY_YMD.replace("{dsep}", getParent().getInternational().getDateSep()),
						ztdate);
			} else {
				// TODO throw exception
				return null;
			}
		} else if (type.equals(Type.TIMEONLY)) {
			if (getParent().getInternational().getAMString() != null)
				return String.format(
						Strings.FORMAT_TIMEONLY_AM.replace("{tsep}", getParent().getInternational().getTimeSep())
								.replace("{ampm}",
										(ztdate.get(Calendar.HOUR_OF_DAY) > 12)
												? getParent().getInternational().getPMString()
												: getParent().getInternational().getAMString()),
						ztdate);
			else
				return String.format(
						Strings.FORMAT_TIMEONLY_NOAM.replace("{tsep}", getParent().getInternational().getTimeSep()),
						ztdate);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#isDST()
	 */
	@Override
	public boolean isDST() throws NotesException {
		// TODO Auto-generated method stub
		if (null != ztdate)
			return ztdate.getTimeZone().useDaylightTime();
		return date.getTimeZone().useDaylightTime();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setAnyDate()
	 */
	@Override
	public void setAnyDate() throws NotesException {
		if (type.equals(Type.DATEONLY))
			throw new OpenNTFNotesException("Can not set any date for a DATEONLY type of DateTime.");
		type = Type.TIMEONLY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setAnyTime()
	 */
	@Override
	public void setAnyTime() throws NotesException {
		if (type.equals(Type.TIMEONLY))
			throw new OpenNTFNotesException("Can not set any time for a TIMEONLY type of DateTime.");
		type = Type.DATEONLY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalDate(int, int, int)
	 */
	@Override
	public void setLocalDate(int year, int month, int day) throws NotesException {
		adjustYear(year - date.get(Calendar.YEAR));
		adjustMonth(month - date.get(Calendar.MONTH));
		adjustYear(day - date.get(Calendar.DAY_OF_MONTH));
		// if (null != ztdate) ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalDate(int, int, int, boolean)
	 */
	@Override
	public void setLocalDate(int year, int month, int day, boolean preserveLocalTime) throws NotesException {
		adjustYear(year - date.get(Calendar.YEAR), preserveLocalTime);
		adjustMonth(month - date.get(Calendar.MONTH), preserveLocalTime);
		adjustYear(day - date.get(Calendar.DAY_OF_MONTH), preserveLocalTime);
		// if (null != ztdate) ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.util.Date)
	 */
	@Override
	public void setLocalTime(Date dt) throws NotesException {
		date.setTime(dt);
		if (null != ztdate)
			ztdate.setTime(dt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.util.Calendar)
	 */
	@Override
	public void setLocalTime(final Calendar dt) throws NotesException {
		date = (Calendar) dt.clone();
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(java.lang.String)
	 */
	@Override
	public void setLocalTime(String dt) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setLocalTime(int, int, int, int)
	 */
	@Override
	public void setLocalTime(int hour, int minute, int second, int hundredth) throws NotesException {
		date.set(Calendar.HOUR_OF_DAY, hour);
		date.set(Calendar.MINUTE, minute);
		date.set(Calendar.SECOND, second);
		date.set(Calendar.MILLISECOND, hundredth * 10);
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#setNow()
	 */
	@Override
	public void setNow() throws NotesException {
		date = Calendar.getInstance(TimeZone.getTimeZone(tz.getArea()));
		if (null != ztdate)
			ztdate.setTime(date.getTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#timeDifference(lotus.domino.DateTime)
	 */
	@Override
	public int timeDifference(lotus.domino.DateTime dt) throws NotesException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt.toJavaDate());
		return date.compareTo(cal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#timeDifferenceDouble(lotus.domino.DateTime)
	 */
	@Override
	public double timeDifferenceDouble(lotus.domino.DateTime dt) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DateTime#toJavaDate()
	 */
	@Override
	public Date toJavaDate() throws NotesException {
		return date.getTime();
	}

	protected void setType(Type _type) {
		type = _type;
	}

	public Calendar getAsCal() {
		if (null != ztdate)
			return ztdate;
		return date;
	}

	public int getTZIdx() {
		return tz.getIndex();
	}

	public boolean isDateOnly() {
		return type.equals(Type.DATEONLY);
	}

	public boolean isTimeOnly() {
		return type.equals(Type.TIMEONLY);
	}
	
	protected void castFromStorage(String value) {
		String[] values = value.split("-");
		if (values.length != 7) {
			// TODO throw exception
			return;
		}
		date.set(Calendar.YEAR, Integer.parseInt(values[0]));
		date.set(Calendar.MONTH, Integer.parseInt(values[1]));
		date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(values[2]));
		date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(values[3]));
		date.set(Calendar.MINUTE, Integer.parseInt(values[4]));
		date.set(Calendar.SECOND, Integer.parseInt(values[5]));
		date.set(Calendar.MILLISECOND, Integer.parseInt(values[6]));
	}

	@Override
	public org.openntf.redomino.couch.Session getAncestorSession() {
		// TODO Auto-generated method stub
		return parent;
	}

}
