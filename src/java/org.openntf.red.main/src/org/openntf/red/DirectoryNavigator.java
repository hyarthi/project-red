package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface DirectoryNavigator.
 */
public interface DirectoryNavigator extends Base, lotus.domino.DirectoryNavigator, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findFirstMatch()
	 */
	@Override
	public boolean findFirstMatch();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findFirstName()
	 */
	@Override
	public long findFirstName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findNextMatch()
	 */
	@Override
	public boolean findNextMatch();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findNextName()
	 */
	@Override
	public long findNextName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findNthMatch(long)
	 */
	@Override
	public boolean findNthMatch(final long n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#findNthName(int)
	 */
	@Override
	public long findNthName(final int n);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getCurrentItem()
	 */
	@Override
	public String getCurrentItem();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getCurrentMatch()
	 */
	@Override
	public long getCurrentMatch();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getCurrentMatches()
	 */
	@Override
	public long getCurrentMatches();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getCurrentName()
	 */
	@Override
	public String getCurrentName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getCurrentView()
	 */
	@Override
	public String getCurrentView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getFirstItemValue()
	 */
	@Override
	public Vector<Object> getFirstItemValue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getNextItemValue()
	 */
	@Override
	public Vector<Object> getNextItemValue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#getNthItemValue(int)
	 */
	@Override
	public Vector<Object> getNthItemValue(final int n);

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Directory getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#isMatchLocated()
	 */
	@Override
	public boolean isMatchLocated();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DirectoryNavigator#isNameLocated()
	 */
	@Override
	public boolean isNameLocated();

}
