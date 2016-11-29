package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.DatabaseDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface ACLEntry.
 */
public interface ACLEntry extends Base, lotus.domino.ACLEntry, DatabaseDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#disableRole(java.lang.String)
	 */
	@Override
	public void disableRole(final String role);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#enableRole(java.lang.String)
	 */
	@Override
	public void enableRole(final String role);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getLevel()
	 */
	@Override
	public int getLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getNameObject()
	 */
	@Override
	public Name getNameObject();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getParent()
	 */
	@Override
	public ACL getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getRoles()
	 */
	@Override
	public Vector<String> getRoles();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#getUserType()
	 */
	@Override
	public int getUserType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isAdminReaderAuthor()
	 */
	@Override
	public boolean isAdminReaderAuthor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isAdminServer()
	 */
	@Override
	public boolean isAdminServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanCreateDocuments()
	 */
	@Override
	public boolean isCanCreateDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanCreateLSOrJavaAgent()
	 */
	@Override
	public boolean isCanCreateLSOrJavaAgent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanCreatePersonalAgent()
	 */
	@Override
	public boolean isCanCreatePersonalAgent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanCreatePersonalFolder()
	 */
	@Override
	public boolean isCanCreatePersonalFolder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanCreateSharedFolder()
	 */
	@Override
	public boolean isCanCreateSharedFolder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanDeleteDocuments()
	 */
	@Override
	public boolean isCanDeleteDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isCanReplicateOrCopyDocuments()
	 */
	@Override
	public boolean isCanReplicateOrCopyDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isGroup()
	 */
	@Override
	public boolean isGroup();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isPerson()
	 */
	@Override
	public boolean isPerson();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isPublicReader()
	 */
	@Override
	public boolean isPublicReader();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isPublicWriter()
	 */
	@Override
	public boolean isPublicWriter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isRoleEnabled(java.lang.String)
	 */
	@Override
	public boolean isRoleEnabled(final String role);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#isServer()
	 */
	@Override
	public boolean isServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setAdminReaderAuthor(boolean)
	 */
	@Override
	public void setAdminReaderAuthor(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setAdminServer(boolean)
	 */
	@Override
	public void setAdminServer(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanCreateDocuments(boolean)
	 */
	@Override
	public void setCanCreateDocuments(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanCreateLSOrJavaAgent(boolean)
	 */
	@Override
	public void setCanCreateLSOrJavaAgent(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanCreatePersonalAgent(boolean)
	 */
	@Override
	public void setCanCreatePersonalAgent(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanCreatePersonalFolder(boolean)
	 */
	@Override
	public void setCanCreatePersonalFolder(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanCreateSharedFolder(boolean)
	 */
	@Override
	public void setCanCreateSharedFolder(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanDeleteDocuments(boolean)
	 */
	@Override
	public void setCanDeleteDocuments(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setCanReplicateOrCopyDocuments(boolean)
	 */
	@Override
	public void setCanReplicateOrCopyDocuments(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setGroup(boolean)
	 */
	@Override
	public void setGroup(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setLevel(int)
	 */
	@Override
	public void setLevel(final int level);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setName(lotus.domino.Name)
	 */
	@Override
	public void setName(final lotus.domino.Name name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setName(java.lang.String)
	 */
	@Override
	public void setName(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setPerson(boolean)
	 */
	@Override
	public void setPerson(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setPublicReader(boolean)
	 */
	@Override
	public void setPublicReader(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setPublicWriter(boolean)
	 */
	@Override
	public void setPublicWriter(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setServer(boolean)
	 */
	@Override
	public void setServer(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ACLEntry#setUserType(int)
	 */
	@Override
	public void setUserType(final int type);

	/**
	 * Set ACLEntry Level to an ACL.Level. Options are:
	 * <ol>
	 * <li>NOACCESS(ACL.LEVEL_NOACCESS)</li>
	 * <li>DESPOSITOR(ACL.LEVEL_DEPOSITOR)</li>
	 * <li>READER(ACL.LEVEL_READER)</li>
	 * <li>AUTHOR(ACL.LEVEL_AUTHOR)</li>
	 * <li>EDITOR(ACL.LEVEL_EDITOR)</li>
	 * <li>DESIGNER(ACL.LEVEL_DESIGNER)</li>
	 * <li>MANAGER(ACL.LEVEL_MANAGER)</li>
	 * </ol>
	 * 
	 * @param level
	 *            ACL.Level to set to
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public void setLevel(final ACL.Level level);

}
