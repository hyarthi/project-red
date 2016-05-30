/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Database;
import lotus.domino.Document;

/**
 * @author Vladimir Kornienko
 *
 */
public class Newsletter extends BaseNonThreadSafe<org.openntf.domino.Newsletter, lotus.domino.Newsletter, Session>
		implements org.openntf.domino.Newsletter {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Newsletter(lotus.domino.Newsletter delegate, Session parent) {
		super(delegate, parent, NOTES_SESSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document formatDocument(Database database, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document formatMsgWithDoclinks(Database database) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubjectItemName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDoScore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDoSubject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDoScore(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDoSubject(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubjectItemName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
