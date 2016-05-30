/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.ACL;
import org.openntf.domino.ACL.Level;
import org.openntf.domino.Database;
import org.openntf.domino.Name;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class ACLEntry extends BaseNonThreadSafe<org.openntf.domino.ACLEntry, lotus.domino.ACLEntry, org.openntf.domino.ACL> implements
org.openntf.domino.ACLEntry {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ACLEntry(lotus.domino.ACLEntry delegate, ACL parent) {
		super(delegate, parent, NOTES_ACLENTRY);
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
	public void disableRole(String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableRole(String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Name getNameObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ACL getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAdminReaderAuthor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdminServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanCreateDocuments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanCreateLSOrJavaAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanCreatePersonalAgent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanCreatePersonalFolder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanCreateSharedFolder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanDeleteDocuments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCanReplicateOrCopyDocuments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGroup() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPerson() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPublicReader() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPublicWriter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoleEnabled(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdminReaderAuthor(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdminServer(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanCreateDocuments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanCreateLSOrJavaAgent(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanCreatePersonalAgent(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanCreatePersonalFolder(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanCreateSharedFolder(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanDeleteDocuments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCanReplicateOrCopyDocuments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGroup(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevel(Level level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(lotus.domino.Name name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPerson(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPublicReader(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPublicWriter(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServer(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserType(int type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
