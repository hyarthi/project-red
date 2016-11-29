package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.DatabaseDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Replication.
 */
public interface Replication extends Base, lotus.domino.Replication, DatabaseDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#clearHistory()
	 */
	@Override
	public int clearHistory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getCutoffDate()
	 */
	@Override
	public DateTime getCutoffDate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getCutoffInterval()
	 */
	@Override
	public long getCutoffInterval();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getDontSendLocalSecurityUpdates()
	 */
	@Override
	public boolean getDontSendLocalSecurityUpdates();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getEntries()
	 */
	@Override
	public Vector<ReplicationEntry> getEntries();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getEntry(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ReplicationEntry getEntry(final String source, final String destination);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getEntry(java.lang.String,
	 * java.lang.String, boolean)
	 */
	@Override
	public ReplicationEntry getEntry(final String source, final String destination, final boolean createFlag);

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Database getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#getPriority()
	 */
	@Override
	public int getPriority();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#isAbstract()
	 */
	@Override
	public boolean isAbstract();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#isCutoffDelete()
	 */
	@Override
	public boolean isCutoffDelete();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#isDisabled()
	 */
	@Override
	public boolean isDisabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#isIgnoreDeletes()
	 */
	@Override
	public boolean isIgnoreDeletes();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#isIgnoreDestDeletes()
	 */
	@Override
	public boolean isIgnoreDestDeletes();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#reset()
	 */
	@Override
	public int reset();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#save()
	 */
	@Override
	public int save();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setAbstract(boolean)
	 */
	@Override
	public void setAbstract(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setCutoffDelete(boolean)
	 */
	@Override
	public void setCutoffDelete(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setCutoffInterval(long)
	 */
	@Override
	public void setCutoffInterval(final long interval);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setDisabled(boolean)
	 */
	@Override
	public void setDisabled(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setDontSendLocalSecurityUpdates(boolean)
	 */
	@Override
	public void setDontSendLocalSecurityUpdates(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setIgnoreDeletes(boolean)
	 */
	@Override
	public void setIgnoreDeletes(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setIgnoreDestDeletes(boolean)
	 */
	@Override
	public void setIgnoreDestDeletes(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Replication#setPriority(int)
	 */
	@Override
	public void setPriority(final int priority);

}
