/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ACL implements lotus.domino.ACL, CouchBase {

	/**
	 * 
	 */
	public ACL() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#addRole(java.lang.String)
	 */
	@Override
	public void addRole(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#createACLEntry(java.lang.String, int)
	 */
	@Override
	public ACLEntry createACLEntry(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#deleteRole(java.lang.String)
	 */
	@Override
	public void deleteRole(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getAdministrationServer()
	 */
	@Override
	public String getAdministrationServer() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getEntry(java.lang.String)
	 */
	@Override
	public ACLEntry getEntry(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getFirstEntry()
	 */
	@Override
	public ACLEntry getFirstEntry() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getInternetLevel()
	 */
	@Override
	public int getInternetLevel() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getNextEntry()
	 */
	@Override
	public ACLEntry getNextEntry() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getNextEntry(lotus.domino.ACLEntry)
	 */
	@Override
	public ACLEntry getNextEntry(lotus.domino.ACLEntry arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getParent()
	 */
	@Override
	public Database getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#getRoles()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getRoles() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#isAdminNames()
	 */
	@Override
	public boolean isAdminNames() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#isAdminReaderAuthor()
	 */
	@Override
	public boolean isAdminReaderAuthor() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#isExtendedAccess()
	 */
	@Override
	public boolean isExtendedAccess() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#isUniformAccess()
	 */
	@Override
	public boolean isUniformAccess() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#removeACLEntry(java.lang.String)
	 */
	@Override
	public void removeACLEntry(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#renameRole(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameRole(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#save()
	 */
	@Override
	public void save() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setAdminNames(boolean)
	 */
	@Override
	public void setAdminNames(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setAdminReaderAuthor(boolean)
	 */
	@Override
	public void setAdminReaderAuthor(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setAdministrationServer(java.lang.String)
	 */
	@Override
	public void setAdministrationServer(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setExtendedAccess(boolean)
	 */
	@Override
	public void setExtendedAccess(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setInternetLevel(int)
	 */
	@Override
	public void setInternetLevel(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACL#setUniformAccess(boolean)
	 */
	@Override
	public void setUniformAccess(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
