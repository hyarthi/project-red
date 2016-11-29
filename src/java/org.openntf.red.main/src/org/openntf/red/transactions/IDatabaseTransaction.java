package org.openntf.red.transactions;

import org.openntf.red.types.DatabaseDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 *
 */
public interface IDatabaseTransaction {

	public int getUpdateSize();

	public int getRemoveSize();

	//Queue<DatabaseDescendant> getUpdateQueue();

	//Queue<DatabaseDescendant> getRemoveQueue();

	public void queueUpdate(final DatabaseDescendant base);

	public void queueRemove(final DatabaseDescendant base);

	public void commit();

	public void rollback();

}
