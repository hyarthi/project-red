/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Agent extends BaseThreadSafe<org.openntf.domino.Agent, lotus.domino.Agent, Database> implements org.openntf.domino.Agent {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Agent(lotus.domino.Agent delegate, Database parent) {
		super(delegate, parent, NOTES_MACRO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
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
	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommonOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getLastRun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOnBehalfOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParameterDocID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTarget() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTrigger() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActivatable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNotesAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProhibitDesignUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPublic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWebAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(String noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int runOnServer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int runOnServer(String noteid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void runWithDocumentContext(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runWithDocumentContext(lotus.domino.Document doc, String noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProhibitDesignUpdate(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerName(String server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resurrect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
