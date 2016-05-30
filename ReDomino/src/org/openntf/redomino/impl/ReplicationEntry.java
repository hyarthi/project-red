/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Collection;

import org.openntf.domino.Database;
import org.openntf.domino.Replication;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class ReplicationEntry
		extends BaseNonThreadSafe<org.openntf.domino.ReplicationEntry, lotus.domino.ReplicationEntry, Replication>
		implements org.openntf.domino.ReplicationEntry {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ReplicationEntry(lotus.domino.ReplicationEntry delegate, Replication parent) {
		super(delegate, parent, NOTES_REPLENT);
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
	public String getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Replication getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIncludeACL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncludeAgents() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncludeDocuments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncludeForms() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIncludeFormulas() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFormula(String formula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeACL(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeAgents(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeDocuments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeForms(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeFormulas(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViews(String views) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViews(Collection<String> views) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
