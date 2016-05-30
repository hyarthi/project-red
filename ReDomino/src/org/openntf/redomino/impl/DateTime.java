/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;
import org.openntf.redomino.utils.Factory;
import org.openntf.redomino.utils.Factory.SessionType;
import org.openntf.domino.utils.DominoUtils;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class DateTime extends BaseNonThreadSafe<org.openntf.domino.DateTime, lotus.domino.DateTime, Session>
		implements org.openntf.domino.DateTime {
	private static final Logger log_ = Logger.getLogger(DateTime.class.getName());
	private static final long serialVersionUID = 1L;

	static {
		Factory.addTerminateHook(new Runnable() {
			@Override
			public void run() {
				Base.s_recycle(lotusWorker.get());
				lotusWorker.set(null);
				calendar.set(null);
			}
		}, true);
	}

	/** The calendar */
	private static ThreadLocal<Calendar> calendar = new ThreadLocal<Calendar>() {
		@Override
		public Calendar get() {
			if (super.get() == null) {
				set(GregorianCalendar.getInstance());
			}
			return super.get();
		};
	};

	private Date date_;

	/** The dst_. */
	private boolean dst_;

	/** The is date only_. */
	private boolean isDateOnly_;

	/** The is time only_. */
	private boolean isTimeOnly_;

	/** The notes zone_. */
	private int notesZone_ = Integer.MIN_VALUE;

	private static final ThreadLocal<lotus.domino.DateTime> lotusWorker = new ThreadLocal<lotus.domino.DateTime>();

	private static lotus.domino.DateTime generateWorker() {
		try {
			lotus.domino.Session rawsession = toLotus(Factory.getSession(SessionType.CURRENT));
			return rawsession.createDateTime(new Date());
		} catch (Exception e) {
			log_.log(Level.SEVERE,
					"Could not create the DateTime worker object. DateTime functions may not work as expected", e);
			return null;
		}

	};

	private lotus.domino.DateTime getWorker() throws NotesException {
		lotus.domino.DateTime ret = lotusWorker.get();

		if (ret == null || Base.isDead(ret)) {
			ret = generateWorker();
			lotusWorker.set(ret);
		}
		if (date_ != null)
			initWorker(ret);
		return ret;
	}

	private void initWorker(final lotus.domino.DateTime worker) throws NotesException {
		if (date_ == null)
			return;
		worker.setLocalTime(date_);
		if (!isTimeOnly_ && !isDateOnly_)
			worker.convertToZone(notesZone_, dst_);
		if (isTimeOnly_)
			worker.setAnyDate();
		if (isDateOnly_)
			worker.setAnyTime();
	}

	private void workDone(final lotus.domino.DateTime worker, final boolean reInit) {
		if (reInit)
			this.initialize(worker);
	}

	/**
	 * @param orig
	 * @param sess
	 */
	protected DateTime(final lotus.domino.DateTime delegate, final Session parent) {
		super(delegate, parent, NOTES_TIME);
		initialize(delegate);

		Base.s_recycle(delegate);
	}

	/**
	 * @param orig
	 * @param sess
	 */
	protected DateTime(final DateTime orig, final Session sess) {
		super(null, sess, NOTES_TIME);
		dst_ = orig.dst_;
		isDateOnly_ = orig.isDateOnly_;
		isTimeOnly_ = orig.isTimeOnly_;
		notesZone_ = orig.notesZone_;
		if (notesZone_ == -18000000) {
			Throwable t = new Throwable();
			t.printStackTrace();
		}
		if (orig.date_ != null) {
			date_ = new Date(orig.date_.getTime());
		}
		// TODO Auto-generated constructor stub
	}

	public DateTime(Session parent) {
		super(null, parent, NOTES_TIME);
	}

	private void initialize(final lotus.domino.DateTime delegate) {
		try {
			dst_ = delegate.isDST();
			notesZone_ = delegate.getTimeZone();
			if (notesZone_ == -18000000) {
				Throwable t = new Throwable();
				t.printStackTrace();
			}
			String s = delegate.getDateOnly();
			isTimeOnly_ = (s == null || s.length() == 0);
			s = delegate.getTimeOnly();
			isDateOnly_ = (s == null || s.length() == 0);
			try {
				if (isTimeOnly_ && isDateOnly_) {
					date_ = null;
				} else {
					date_ = delegate.toJavaDate();
				}
			} catch (NotesException e1) {
				// System.out.println("Error attempting to initialize a
				// DateTime: " + delegate.getGMTTime());
				throw new RuntimeException(e1);
			}

		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public boolean isAnyDate() {
		return isTimeOnly_;
	}

	@Override
	public boolean isAnyTime() {
		return isDateOnly_;
	}

	@Override
	public void setLocalTime(String time, boolean parseLenient) {
		setLocalTime(time);
	}

	@Override
	public int timeDifference(org.openntf.formula.DateTime dt) {
		if (dt instanceof lotus.domino.DateTime)
			return timeDifference((lotus.domino.DateTime) dt);
		return (int) timeDifferenceDouble(dt);
	}

	@Override
	public double timeDifferenceDouble(org.openntf.formula.DateTime dt) {
		if (dt instanceof lotus.domino.DateTime)
			return timeDifferenceDouble((lotus.domino.DateTime) dt);
		Calendar thisCal = this.toJavaCal();
		Calendar thatCal = dt.toJavaCal();
		return (thisCal.getTimeInMillis() - thatCal.getTimeInMillis()) * 1000;
	}

	@Override
	public Calendar toJavaCal() {
		Calendar result = GregorianCalendar.getInstance();
		result.setTime(date_);
		return result;
	}

	@Override
	public int compare(org.openntf.formula.DateTime sdt1, org.openntf.formula.DateTime sdt2) {
		if (sdt1 instanceof DateTime && sdt2 instanceof DateTime)
			return ((DateTime) sdt1).compareTo((DateTime) sdt2);
		if (sdt1 instanceof DateTime)
			return sdt2.compare(sdt2, sdt1);
		return sdt1.compare(sdt1, sdt2);
	}

	@Override
	public boolean equals(org.openntf.domino.DateTime compareDate) {
		return date_.equals(compareDate.toJavaDate());
	}

	@Override
	public boolean equalsIgnoreDate(org.openntf.domino.DateTime compareDate) {
		Calendar cal = calendar.get();
		cal.setTime(date_);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2000);
		Date d1 = cal.getTime();
		cal.setTime(compareDate.toJavaDate());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2000);
		Date d2 = cal.getTime();
		return d1.equals(d2);
	}

	@Override
	public boolean equalsIgnoreTime(org.openntf.domino.DateTime compareDate) {
		Calendar cal = calendar.get();
		cal.setTime(date_);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date d1 = cal.getTime();
		cal.setTime(compareDate.toJavaDate());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date d2 = cal.getTime();
		return d1.equals(d2);
	}

	@Override
	public boolean isAfter(org.openntf.domino.DateTime compareDate) {
		return date_.after(compareDate.toJavaDate());
	}

	@Override
	public boolean isBefore(org.openntf.domino.DateTime compareDate) {
		return date_.before(compareDate.toJavaDate());
	}

	@Override
	public void setLocalTime(Calendar calendar) {
		date_ = calendar.getTime();
		//FIXME NTF this is incorrect. The notesZone_ is the timezone according to the legacy Notes API. The Java calendar API cannot replace it.
		//		TimeZone localTimeZone = calendar.getTimeZone();
		//		notesZone_ = calendar.get(Calendar.ZONE_OFFSET);
		//		if (localTimeZone.useDaylightTime() == true) {
		//			dst_ = localTimeZone.inDaylightTime(date_);
		//		} else {
		//			dst_ = false;
		//		}
		isDateOnly_ = false;
		isTimeOnly_ = false;
	}

	@Override
	public int compareTo(org.openntf.domino.DateTime arg0) {
		return date_.compareTo(arg0.toJavaDate());
	}

	@Override
	public Session getAncestorSession() {
		return parent;
	}

	@Override
	public void adjustDay(int n) {
		adjustDay(n, false);
	}

	@Override
	public void adjustDay(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustDay(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustDay(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void adjustHour(int n) {
		adjustHour(n, false);
	}

	@Override
	public void adjustHour(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustHour(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustHour(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void adjustMinute(int n) {
		adjustMinute(n, false);
	}

	@Override
	public void adjustMinute(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustMinute(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustMinute(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void adjustMonth(int n) {
		adjustMonth(n, false);
	}

	@Override
	public void adjustMonth(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustMonth(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustMonth(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void adjustSecond(int n) {
		adjustSecond(n, false);
	}

	@Override
	public void adjustSecond(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustSecond(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustSecond(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void adjustYear(int n) {
		adjustYear(n, false);
	}

	@Override
	public void adjustYear(int n, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).adjustYear(n, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.adjustYear(n, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void convertToZone(int zone, boolean isDST) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).convertToZone(zone, isDST);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.convertToZone(zone, isDST);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public String getDateOnly() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch object
				ret = ((org.openntf.redomino.couch.DateTime) beObject).getDateOnly();
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return ret;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.getDateOnly();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}

	@Override
	public String getGMTTime() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch object
				return ((org.openntf.redomino.couch.DateTime) beObject).getGMTTime();
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.getGMTTime();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}

	@Override
	public String getLocalTime() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch jbject
				return ((org.openntf.redomino.couch.DateTime) beObject).getLocalTime();
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.getLocalTime();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}

	@Override
	public Session getParent() {
		return parent;
	}

	@Override
	public String getTimeOnly() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch jbject
				return ((org.openntf.redomino.couch.DateTime) beObject).getTimeOnly();
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.getTimeOnly();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}

	@Override
	public int getTimeZone() {
		return notesZone_;
	}

	@Override
	public String getZoneTime() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch jbject
				return ((org.openntf.redomino.couch.DateTime) beObject).getZoneTime();
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.getZoneTime();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}

	@Override
	public boolean isDST() {
		return dst_;
	}

	@Override
	public void setAnyDate() {
		isTimeOnly_ = true;
	}

	@Override
	public void setAnyTime() {
		isDateOnly_ = true;
	}

	@Override
	public void setLocalDate(int year, int month, int day) {
		setLocalDate(year, month, day, false);
	}

	@Override
	public void setLocalDate(int year, int month, int day, boolean preserveLocalTime) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).setLocalDate(year, month, day, preserveLocalTime);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.setLocalDate(year, month, day, preserveLocalTime);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void setLocalTime(java.util.Calendar calendar) {
		date_ = calendar.getTime();
		//FIXME NTF this is incorrect. The notesZone_ is the timezone according to the legacy Notes API. The Java calendar API cannot replace it.
		//		java.util.TimeZone localTimeZone = calendar.getTimeZone();
		//		notesZone_ = calendar.get(Calendar.ZONE_OFFSET);
		//		if (localTimeZone.useDaylightTime() == true) {
		//			dst_ = localTimeZone.inDaylightTime(date_);
		//		} else {
		//			dst_ = false;
		//		}
		isDateOnly_ = false;
		isTimeOnly_ = false;
		//setLocalTime(calendar.getTime());
	}

	@Override
	public void setLocalTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		setLocalTime(cal);
		//		try {
		//			lotus.domino.DateTime worker = getWorker();
		//			worker.setLocalTime(date);
		//			workDone(worker, true);
		//		} catch (NotesException ne) {
		//			DominoUtils.handleException(ne);
		//		}
	}

	@Override
	public void setLocalTime(int hour, int minute, int second, int hundredth) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).setLocalTime(hour, minute, second, hundredth);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.setLocalTime(hour, minute, second, hundredth);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void setLocalTime(String time) {
		try {
			if (null != beObject) {
				// Couch object
				((org.openntf.redomino.couch.DateTime) beObject).setLocalTime(time);
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			worker.setLocalTime(time);
			workDone(worker, true);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
	}

	@Override
	public void setNow() {
		setLocalTime(new Date());
	}

	@Override
	public int timeDifference(lotus.domino.DateTime dt) {
		Integer[] res = new Integer[1];
		res[0] = new Integer(0);
		timeDifferenceCommon(dt, res);
		return (res[0]);
	}

	@Override
	public double timeDifferenceDouble(lotus.domino.DateTime dt) {
		Double[] res = new Double[1];
		res[0] = new Double(0);
		timeDifferenceCommon(dt, res);
		return (res[0]);
	}
	
	private void timeDifferenceCommon(final lotus.domino.DateTime dt, final Object[] res) {
		lotus.domino.DateTime dtLocal = dt;
		lotus.domino.DateTime lotusDTTmp = null;
		try {
			if (dtLocal instanceof org.openntf.redomino.impl.DateTime) {
				lotusDTTmp = ((org.openntf.redomino.impl.DateTime) dtLocal).getDelegate();
				dtLocal = lotusDTTmp;
			}
			lotus.domino.DateTime worker = getWorker();
			if (res[0] instanceof Integer) {
				res[0] = worker.timeDifference(dtLocal);
			} else if (res[0] instanceof Double) {
				res[0] = worker.timeDifferenceDouble(dtLocal);
			}
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		} finally {
			if (lotusDTTmp != null)
				s_recycle(lotusDTTmp);
		}
	}

	@Override
	public Date toJavaDate() {
		return new Date(date_.getTime());
	}

	@Override
	public org.openntf.domino.DateTime clone() {
		return new DateTime(this, getAncestorSession());
	}

	@Override
	protected WrapperFactory getFactory() {
		return parent.getFactory();
	}

	@Override
	protected lotus.domino.DateTime getDelegate() {
		if (null != beObject) // Couch object
			return (org.openntf.redomino.couch.DateTime) beObject;
		// Lotus object - follow ODA
		try {
			lotus.domino.Session rawsession = toLotus(parent);
			lotus.domino.DateTime delegate = rawsession.createDateTime(date_);
			if (notesZone_ != Integer.MIN_VALUE) {
				try {
					delegate.convertToZone(notesZone_, dst_);
				} catch (Throwable t) {
					log_.log(Level.WARNING, "Failed to convert a DateTime to zone " + notesZone_ + " with a dst of "
							+ String.valueOf(dst_));
				}
			}
			if (isAnyTime()) {
				delegate.setAnyTime();
			}
			if (isAnyDate()) {
				delegate.setAnyDate();
			}
			return delegate;
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
			return null;
		}
	}
	
	@Override
	public String toString() {
		String ret = null;
		try {
			if (null != beObject) {
				// Couch object
				ret = ((org.openntf.redomino.couch.DateTime) beObject).toString();
				workDone((org.openntf.redomino.couch.DateTime)beObject, true);
				return ret;
			}
			// Lotus object - follow ODA
			lotus.domino.DateTime worker = getWorker();
			ret = worker.toString();
			workDone(worker, false);
		} catch (NotesException ne) {
			DominoUtils.handleException(ne);
		}
		return ret;
	}
	
	@Override
	public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
		dst_ = in.readBoolean();
		isDateOnly_ = in.readBoolean();
		isTimeOnly_ = in.readBoolean();
		notesZone_ = in.readInt();
		date_ = new Date(in.readLong());
	}
	
	@Override
	public void writeExternal(final ObjectOutput out) throws IOException {
		out.writeBoolean(dst_);
		out.writeBoolean(isDateOnly_);
		out.writeBoolean(isTimeOnly_);
		out.writeInt(notesZone_);
		out.writeLong(date_.getTime());
	}

}
