/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.ReplicationEntry;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Replication extends BaseNonThreadSafe<org.openntf.domino.Replication, lotus.domino.Replication, Database>
		implements org.openntf.domino.Replication {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Replication(lotus.domino.Replication delegate, Database parent) {
		super(delegate, parent, NOTES_REPLICATION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int clearHistory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DateTime getCutoffDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCutoffInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getDontSendLocalSecurityUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<ReplicationEntry> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplicationEntry getEntry(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplicationEntry getEntry(String source, String destination, boolean createFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCutoffDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgnoreDeletes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgnoreDestDeletes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int reset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAbstract(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCutoffDelete(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCutoffInterval(long interval) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisabled(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDontSendLocalSecurityUpdates(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIgnoreDeletes(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIgnoreDestDeletes(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPriority(int priority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
