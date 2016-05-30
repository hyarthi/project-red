/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.NotesCalendarEntry;
import org.openntf.domino.NotesCalendarNotice;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.DateTime;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotesCalendar
		extends BaseNonThreadSafe<org.openntf.domino.NotesCalendar, lotus.domino.NotesCalendar, Session>
		implements org.openntf.domino.NotesCalendar {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected NotesCalendar(lotus.domino.NotesCalendar delegate, Session parent) {
		super(delegate, parent, NOTES_OUTLINE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApptunidFromUID(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendarEntry createEntry(String iCalEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendarEntry createEntry(String iCalEntry, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAutoSendNotices() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<NotesCalendarEntry> getEntries(DateTime start, DateTime end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotesCalendarEntry> getEntries(DateTime start, DateTime end, int skipCount, int maxReturn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntriesProcessed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesCalendarEntry getEntry(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendarEntry getEntryByNoteID(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendarEntry getEntryByUNID(String unid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotesCalendarNotice> getNewInvitations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotesCalendarNotice> getNewInvitations(DateTime start, DateTime since) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendarNotice getNoticeByUNID(String unid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getReadRangeMask1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReadRangeMask2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReadXLotusPropsOutputLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public org.openntf.domino.DateTime getUntilTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readRange(DateTime start, DateTime end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readRange(DateTime start, DateTime end, int skipCount, int maxRead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAutoSendNotices(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReadRangeMask1(int mask) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReadRangeMask2(int mask) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReadXLotusPropsOutputLevel(int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getApptunidFromUID(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
