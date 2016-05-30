/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Date;

import org.openntf.domino.DateTime;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class DateRange extends BaseNonThreadSafe<org.openntf.domino.DateRange, lotus.domino.DateRange, Session> implements
org.openntf.domino.DateRange, lotus.domino.DateRange, Cloneable {

	/**
	 * @param parent
	 */
	protected DateRange(Session parent) {
		super(null, parent, NOTES_DATERNG);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DateRange(lotus.domino.DateRange delegate, Session parent) {
		super(delegate, parent, NOTES_DATERNG);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param start
	 * @param end
	 * @param parent
	 */
	protected DateRange(DateTime start, DateTime end, Session parent) {
		super(null, parent, NOTES_DATERNG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean contains(DateTime dt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public org.openntf.domino.DateRange clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getEndDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getStartDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEndDateTime(lotus.domino.DateTime end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartDateTime(lotus.domino.DateTime start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
