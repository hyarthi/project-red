/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Iterator;
import java.util.Vector;

import org.openntf.domino.ACLEntry;
import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class ACL extends BaseNonThreadSafe<org.openntf.domino.ACL, lotus.domino.ACL, Database> implements org.openntf.domino.ACL {

	protected ACL(lotus.domino.ACL delegate, Database parent) {
		super(delegate, parent, NOTES_ACL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ACLEntry createACLEntry(String name, Level level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInternetLevel(Level level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<ACLEntry> iterator() {
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
	public void addRole(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ACLEntry createACLEntry(String name, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAdministrationServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ACLEntry getEntry(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ACLEntry getFirstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInternetLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ACLEntry getNextEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ACLEntry getNextEntry(lotus.domino.ACLEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdminNames() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdminReaderAuthor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExtendedAccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUniformAccess() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeACLEntry(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renameRole(String oldName, String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdministrationServer(String server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdminNames(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdminReaderAuthor(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExtendedAccess(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInternetLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUniformAccess(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
