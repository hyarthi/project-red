/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Directory;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class DirectoryNavigator
		extends BaseNonThreadSafe<org.openntf.domino.DirectoryNavigator, lotus.domino.DirectoryNavigator, Directory>
		implements org.openntf.domino.DirectoryNavigator {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DirectoryNavigator(lotus.domino.DirectoryNavigator delegate, Directory parent) {
		super(delegate, parent, NOTES_DIRNAVIGATOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findFirstMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long findFirstName() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findNextMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long findNextName() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findNthMatch(long n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long findNthName(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrentItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCurrentMatch() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCurrentMatches() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrentName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getFirstItemValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getNextItemValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getNthItemValue(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Directory getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMatchLocated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNameLocated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
