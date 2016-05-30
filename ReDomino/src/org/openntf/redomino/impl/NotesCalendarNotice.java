/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Document;
import org.openntf.domino.NotesCalendar;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.DateTime;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotesCalendarNotice extends
		BaseNonThreadSafe<org.openntf.domino.NotesCalendarNotice, lotus.domino.NotesCalendarNotice, NotesCalendar>
		implements org.openntf.domino.NotesCalendarNotice {

	/**
	 * @param delegate
	 * @param parent
	 * @param wf
	 * @param cppId
	 */
	protected NotesCalendarNotice(lotus.domino.NotesCalendarNotice delegate, NotesCalendar parent, WrapperFactory wf,
			long cppId) {
		super(delegate, parent, NOTES_CALENDARNOTICE);
		// TODO Auto-generated constructor stub
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
	public void acceptCounter(String comments) {
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
	public void decline(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decline(String comments, boolean keepInformed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void declineCounter(String comments) {
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
	public Document getAsDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<org.openntf.domino.NotesCalendarNotice> getOutstandingInvitations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesCalendar getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUNID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOverwriteCheckEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCancelled() {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInfo(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendUpdatedInfo(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOverwriteCheckEnabled(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tentativelyAccept(String comments) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
