package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Directory.
 */
public interface Directory extends Base, lotus.domino.Directory, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#createNavigator()
	 */
	@Override
	public DirectoryNavigator createNavigator();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#freeLookupBuffer()
	 */
	@Override
	public void freeLookupBuffer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getAvailableItems()
	 */
	@Override
	public Vector<String> getAvailableItems();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getAvailableNames()
	 */
	@Override
	public Vector<String> getAvailableNames();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getAvailableView()
	 */
	@Override
	public String getAvailableView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getMailInfo(java.lang.String)
	 */
	@Override
	public Vector<String> getMailInfo(final String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getMailInfo(java.lang.String, boolean,
	 * boolean)
	 */
	@Override
	public Vector<String> getMailInfo(final String userName, final boolean getVersion,
			final boolean errorOnMultipleMatches);

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#getServer()
	 */
	@Override
	public String getServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isGroupAuthorizationOnly()
	 */
	@Override
	public boolean isGroupAuthorizationOnly();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isLimitMatches()
	 */
	@Override
	public boolean isLimitMatches();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isPartialMatches()
	 */
	@Override
	public boolean isPartialMatches();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isSearchAllDirectories()
	 */
	@Override
	public boolean isSearchAllDirectories();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isTrustedOnly()
	 */
	@Override
	public boolean isTrustedOnly();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#isUseContextServer()
	 */
	@Override
	public boolean isUseContextServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#lookupAllNames(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public DirectoryNavigator lookupAllNames(final String view, final String item);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#lookupAllNames(java.lang.String,
	 * java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DirectoryNavigator lookupAllNames(final String view, final Vector items);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#lookupNames(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public DirectoryNavigator lookupNames(final String view, final String name, final String item);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#lookupNames(java.lang.String,
	 * java.util.Vector, java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DirectoryNavigator lookupNames(final String view, final Vector names, final Vector items,
			final boolean partialMatches);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#setGroupAuthorizationOnly(boolean)
	 */
	@Override
	public void setGroupAuthorizationOnly(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#setLimitMatches(boolean)
	 */
	@Override
	public void setLimitMatches(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#setSearchAllDirectories(boolean)
	 */
	@Override
	public void setSearchAllDirectories(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#setTrustedOnly(boolean)
	 */
	@Override
	public void setTrustedOnly(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Directory#setUseContextServer(boolean)
	 */
	@Override
	public void setUseContextServer(final boolean flag);

}
