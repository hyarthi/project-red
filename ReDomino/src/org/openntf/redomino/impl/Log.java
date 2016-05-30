/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Log extends BaseNonThreadSafe<org.openntf.domino.Log, lotus.domino.Log, Session> implements org.openntf.domino.Log {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Log(lotus.domino.Log delegate, Session parent) {
		super(delegate, parent, NOTES_AGENTLOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumActions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumErrors() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProgramName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogActions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLogErrors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOverwriteFile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logAction(String action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logError(int code, String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logEvent(String text, String queue, int event, int severity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openAgentLog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openFileLog(String filePath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openMailLog(Vector recipients, String subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openNotesLog(String server, String database) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogActions(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogErrors(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOverwriteFile(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProgramName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
