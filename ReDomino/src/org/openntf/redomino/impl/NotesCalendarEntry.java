/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Document;
import org.openntf.domino.NotesCalendar;
import org.openntf.domino.NotesCalendarNotice;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.DateTime;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotesCalendarEntry
		extends BaseNonThreadSafe<org.openntf.domino.NotesCalendarEntry, lotus.domino.NotesCalendarEntry, NotesCalendar>
		implements org.openntf.domino.NotesCalendarEntry {

	/**
	 * @param delegate
	 * @param parent
	 * @param wf
	 * @param cppId
	 */
	protected NotesCalendarEntry(lotus.domino.NotesCalendarEntry delegate, NotesCalendar parent, WrapperFactory wf,
			long cppId) {
		super(delegate, parent, NOTES_CALENDARENTRY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInvitees(Vector arg0, Vector arg1, Vector arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInvitees(Vector arg0, Vector arg1, Vector arg2, String arg3) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInvitees(Vector arg0, Vector arg1, Vector arg2, String arg3, int arg4) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInvitees(Vector arg0, Vector arg1, Vector arg2, String arg3, int arg4, int arg5, String arg6)
			throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyInvitees(Vector arg0, Vector arg1, Vector arg2, Vector arg3) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyInvitees(Vector arg0, Vector arg1, Vector arg2, Vector arg3, String arg4) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyInvitees(Vector arg0, Vector arg1, Vector arg2, Vector arg3, String arg4, int arg5)
			throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyInvitees(Vector arg0, Vector arg1, Vector arg2, Vector arg3, String arg4, int arg5, int arg6,
			String arg7) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInvitees(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInvitees(Vector arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInvitees(Vector arg0, String arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInvitees(Vector arg0, String arg1, int arg2, int arg3, String arg4) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInfo(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(String comments, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(String comments, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void counter(String comments, DateTime start, DateTime end) {
		// TODO Auto-generated method stub

	}

	@Override
	public void counter(String comments, DateTime start, DateTime end, boolean keepPlaceholder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void counter(String comments, DateTime start, DateTime end, boolean keepPlaceholder, int scope,
			String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void counter(String comments, DateTime start, DateTime end, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decline(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decline(String comments, boolean keepInformed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decline(String comments, boolean keepInformed, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delegate(String commentsToOrganizer, String delegateTo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delegate(String commentsToOrganizer, String delegateTo, boolean keepInformed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delegate(String commentsToOrganizer, String delegateTo, boolean keepInformed, int scope,
			String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delegate(String commentsToOrganizer, String delegateTo, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Document getAsDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getAsDocument(int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getAsDocument(int flags, String recurrenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendar getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotesCalendarNotice> getNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String recurrenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInfo(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tentativelyAccept(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tentativelyAccept(String comments, int scope, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String iCalEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String iCalEntry, String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String iCalEntry, String comments, long flags) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String iCalEntry, String comments, long flags, String recurrenceId) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
