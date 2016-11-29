package org.openntf.red;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Newsletter.
 */
public interface Newsletter extends Base, lotus.domino.Newsletter, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#formatDocument(lotus.domino.Database, int)
	 */
	@Override
	public lotus.domino.Document formatDocument(final lotus.domino.Database database, final int index);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#formatMsgWithDoclinks(lotus.domino.Database)
	 */
	@Override
	public lotus.domino.Document formatMsgWithDoclinks(final lotus.domino.Database database);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#getSubjectItemName()
	 */
	@Override
	public String getSubjectItemName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#isDoScore()
	 */
	@Override
	public boolean isDoScore();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#isDoSubject()
	 */
	@Override
	public boolean isDoSubject();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#setDoScore(boolean)
	 */
	@Override
	public void setDoScore(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#setDoSubject(boolean)
	 */
	@Override
	public void setDoSubject(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Newsletter#setSubjectItemName(java.lang.String)
	 */
	@Override
	public void setSubjectItemName(final String name);

}
