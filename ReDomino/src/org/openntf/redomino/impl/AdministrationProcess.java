/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.DateTime;
import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class AdministrationProcess extends
BaseNonThreadSafe<org.openntf.domino.AdministrationProcess, lotus.domino.AdministrationProcess, Session> implements
org.openntf.domino.AdministrationProcess {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected AdministrationProcess(lotus.domino.AdministrationProcess delegate, Session parent) {
		super(delegate, parent, NOTES_ACLENTRY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String delegateMailFile(String arg0, Vector arg1, Vector arg2, Vector arg3, Vector arg4, Vector arg5,
			Vector arg6, Vector arg7, String arg8, String arg9) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setEnableOutlookSupport(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addGroupMembers(String group, Vector members) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addInternetCertificateToUser(String user, String keyringFile, String keyringPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addInternetCertificateToUser(String user, String keyringFile, String keyringPassword,
			DateTime expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addServerToCluster(String server, String cluster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDeletePersonInDirectory(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDeleteServerInDirectory(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDesignElementDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveHostedOrgStorageDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveMailFileDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveMovedReplicaDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveNameChangeRetraction(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveRenamePersonInDirectory(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveRenameServerInDirectory(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveReplicaDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveResourceDeletion(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeHTTPPassword(String userName, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String configureMailAgent(String userName, String agentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String configureMailAgent(String userName, String agentName, boolean activatable, boolean enable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReplica(String sourceServer, String sourceDBFile, String destServer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReplica(String sourceServer, String sourceDBFile, String destServer, String destDBFile,
			boolean copyACL, boolean createFTIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGroup(String groupName, boolean immediate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGroup(String groupName, boolean immediate, boolean deleteWindowsGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteReplicas(String serverName, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteServer(String serverName, boolean immediate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup,
			boolean deleteWindowsUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findGroupInDomain(String group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findServerInDomain(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserInDomain(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertificateAuthorityOrg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DateTime getCertificateExpiration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertifierFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertifierPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCertificateAuthorityAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUseCertificateAuthority() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath, boolean useSCOS,
			Vector newClusterReplicas, boolean deleteOldClusterReplicas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveReplica(String sourceServer, String sourceDBFile, String destServer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveReplica(String sourceServer, String sourceDBFile, String destServer, String destDBFile,
			boolean copyACL, boolean createFTIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveRoamingUser(String userName, String destServer, String destServerPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyComplete(String requestNoteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyComplete(String requestNoteid, String lastName, String firstName,
			String middleInitial, String orgUnit, String altCommonName, String altOrgUnit, String altLanguage,
			boolean renameWindowsUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyRequest(String userName, String targetCertifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyRequest(String userName, String targetCertifier, boolean allowPrimaryNameChange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recertifyServer(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recertifyUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeServerFromCluster(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameGroup(String group, String newGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameNotesUser(String userName, String lastName, String firstName, String middleInitial,
			String orgUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameNotesUser(String userName, String lastName, String firstName, String middleInitial,
			String orgUnit, String altCommonName, String altOrgUnit, String altLanguage, boolean renameWindowsUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameWebUser(String userName, String newFullName, String newLastName, String newFirstName,
			String newMiddleInitial, String newShortName, String newInternetAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCertificateAuthorityOrg(String org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCertificateExpiration(DateTime expiration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCertifierFile(String fileSpec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCertifierPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String setServerDirectoryAssistanceSettings(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUseCertificateAuthority(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String setUserPasswordSettings(String userName, Integer notesPasswordCheckSetting,
			Integer notesPasswordChangeInterval, Integer notesPasswordGracePeriod,
			Boolean internetPasswordForceChange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signDatabaseWithServerID(String server, String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signDatabaseWithServerID(String server, String dbFile, boolean updateOnly) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upgradeUserToHierarchical(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upgradeUserToHierarchical(String userName, String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
