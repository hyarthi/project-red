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
public class ACLEntry implements lotus.domino.ACLEntry, CouchBase {

	/**
	 * 
	 */
	public ACLEntry() {
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
	 * @see lotus.domino.ACLEntry#disableRole(java.lang.String)
	 */
	@Override
	public void disableRole(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#enableRole(java.lang.String)
	 */
	@Override
	public void enableRole(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getLevel()
	 */
	@Override
	public int getLevel() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getName()
	 */
	@Override
	public String getName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getNameObject()
	 */
	@Override
	public Name getNameObject() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getParent()
	 */
	@Override
	public ACL getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getRoles()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getRoles() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#getUserType()
	 */
	@Override
	public int getUserType() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isAdminReaderAuthor()
	 */
	@Override
	public boolean isAdminReaderAuthor() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isAdminServer()
	 */
	@Override
	public boolean isAdminServer() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanCreateDocuments()
	 */
	@Override
	public boolean isCanCreateDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanCreateLSOrJavaAgent()
	 */
	@Override
	public boolean isCanCreateLSOrJavaAgent() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanCreatePersonalAgent()
	 */
	@Override
	public boolean isCanCreatePersonalAgent() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanCreatePersonalFolder()
	 */
	@Override
	public boolean isCanCreatePersonalFolder() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanCreateSharedFolder()
	 */
	@Override
	public boolean isCanCreateSharedFolder() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanDeleteDocuments()
	 */
	@Override
	public boolean isCanDeleteDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isCanReplicateOrCopyDocuments()
	 */
	@Override
	public boolean isCanReplicateOrCopyDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isGroup()
	 */
	@Override
	public boolean isGroup() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isPerson()
	 */
	@Override
	public boolean isPerson() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isPublicReader()
	 */
	@Override
	public boolean isPublicReader() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isPublicWriter()
	 */
	@Override
	public boolean isPublicWriter() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isRoleEnabled(java.lang.String)
	 */
	@Override
	public boolean isRoleEnabled(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#isServer()
	 */
	@Override
	public boolean isServer() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setAdminReaderAuthor(boolean)
	 */
	@Override
	public void setAdminReaderAuthor(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setAdminServer(boolean)
	 */
	@Override
	public void setAdminServer(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanCreateDocuments(boolean)
	 */
	@Override
	public void setCanCreateDocuments(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanCreateLSOrJavaAgent(boolean)
	 */
	@Override
	public void setCanCreateLSOrJavaAgent(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanCreatePersonalAgent(boolean)
	 */
	@Override
	public void setCanCreatePersonalAgent(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanCreatePersonalFolder(boolean)
	 */
	@Override
	public void setCanCreatePersonalFolder(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanCreateSharedFolder(boolean)
	 */
	@Override
	public void setCanCreateSharedFolder(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanDeleteDocuments(boolean)
	 */
	@Override
	public void setCanDeleteDocuments(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setCanReplicateOrCopyDocuments(boolean)
	 */
	@Override
	public void setCanReplicateOrCopyDocuments(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setGroup(boolean)
	 */
	@Override
	public void setGroup(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setLevel(int)
	 */
	@Override
	public void setLevel(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setName(java.lang.String)
	 */
	@Override
	public void setName(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setName(lotus.domino.Name)
	 */
	@Override
	public void setName(lotus.domino.Name arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setPerson(boolean)
	 */
	@Override
	public void setPerson(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setPublicReader(boolean)
	 */
	@Override
	public void setPublicReader(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setPublicWriter(boolean)
	 */
	@Override
	public void setPublicWriter(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setServer(boolean)
	 */
	@Override
	public void setServer(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.ACLEntry#setUserType(int)
	 */
	@Override
	public void setUserType(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
