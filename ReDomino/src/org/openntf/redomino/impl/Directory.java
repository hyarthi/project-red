/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.DirectoryNavigator;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Directory extends BaseNonThreadSafe<org.openntf.domino.Directory, lotus.domino.Directory, Session> implements
org.openntf.domino.Directory {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Directory(lotus.domino.Directory delegate, Session parent) {
		super(delegate, parent, NOTES_DIRECTORY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryNavigator createNavigator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void freeLookupBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<String> getAvailableItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getAvailableNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvailableView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getMailInfo(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getMailInfo(String userName, boolean getVersion, boolean errorOnMultipleMatches) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGroupAuthorizationOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLimitMatches() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPartialMatches() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSearchAllDirectories() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrustedOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUseContextServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DirectoryNavigator lookupAllNames(String view, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryNavigator lookupAllNames(String view, Vector items) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryNavigator lookupNames(String view, String name, String item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectoryNavigator lookupNames(String view, Vector names, Vector items, boolean partialMatches) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGroupAuthorizationOnly(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLimitMatches(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSearchAllDirectories(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrustedOnly(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseContextServer(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
