/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.DateTime;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Registration extends BaseNonThreadSafe<org.openntf.domino.Registration, lotus.domino.Registration, Session>
		implements org.openntf.domino.Registration {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Registration(lotus.domino.Registration delegate, Session parent) {
		super(delegate, parent, NOTES_VIEWCOLUMN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCertifierToAddressBook(String idFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCertifierToAddressBook(String idFile, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCertifierToAddressBook(String idFile, String password, String location, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String idFile, String server, String domain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String idFile, String server, String domain, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String idFile, String server, String domain, String userPassword,
			String network, String adminName, String title, String location, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addUserProfile(String userName, String profile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addUserToAddressBook(String idFile, String fullName, String lastName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToAddressBook(String idFile, String fullName, String lastName, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToAddressBook(String idFile, String fullName, String lastName, String userPassword,
			String firstName, String middleName, String mailServer, String mailFilePath, String forwardingAddress,
			String location, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String idFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String idFile, String certPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String idFile, String certPassword, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteIDOnServer(String userName, boolean isServerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<String> getAltOrgUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getAltOrgUnitLang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertifierIDFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertifierName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCreateMailDb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DateTime getExpiration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getForeignDN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getGroupList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getIDFromServer(String userName, String filePath, boolean isServerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIDType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMailACLManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMailInternetAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMailOwnerAccess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMailQuotaSizeLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMailQuotaWarningThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getMailReplicaServers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMailSystem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMailTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMinPasswordLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOrgUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPolicyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPublicKeySize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getRegistrationLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRegistrationServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRoamingCleanupPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoamingCleanupSetting() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getRoamingServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoamingSubdir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShortName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getStoreIDInAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUpdateAddressBook() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getUserInfo(String userName, StringBuffer mailServer, StringBuffer mailFile, StringBuffer mailDomain,
			StringBuffer mailSystem, Vector profile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnforceUniqueShortName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMailCreateFTIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNoIDFile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNorthAmerican() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoamingUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStoreIDInMailfile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSynchInternetPassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUseCertificateAuthority() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recertify(String idFile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recertify(String idFile, String certPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recertify(String idFile, String certPassword, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewCertifier(String org, String idFile, String certPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewCertifier(String org, String idFile, String certPassword, String country) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String server, String idFile, String domain, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String server, String idFile, String domain, String serverPassword,
			String certPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String server, String idFile, String domain, String serverPassword,
			String certPassword, String location, String comment, String network, String adminName, String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String lastName, String idFile, String server) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String lastName, String idFile, String server, String firstName, String middleName,
			String certPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String lastName, String idFile, String server, String firstName, String middleName,
			String certPassword, String location, String comment, String mailDBPath, String forward,
			String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String lastName, String idFile, String server, String firstName, String middleName,
			String certPassword, String location, String comment, String mailDBPath, String forward,
			String userPassword, String altName, String altNameLang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAltOrgUnit(Vector names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAltOrgUnitLang(Vector languages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCertifierIDFile(String idFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCertifierName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateMailDb(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnforceUniqueShortName(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExpiration(lotus.domino.DateTime expiration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setForeignDN(String dn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGroupList(Vector groups) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIDType(int type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailACLManager(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailCreateFTIndex(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailInternetAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailOwnerAccess(int access) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailQuotaSizeLimit(int limit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailQuotaWarningThreshold(int threshold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailReplicaServers(Vector servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailSystem(int system) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMailTemplateName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMinPasswordLength(int length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoIDFile(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNorthAmerican(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrgUnit(String unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPolicyName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPublicKeySize(int size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegistrationLog(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRegistrationServer(String server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoamingCleanupPeriod(int period) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoamingCleanupSetting(int setting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoamingServer(String server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoamingSubdir(String dirPath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoamingUser(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShortName(String shortName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStoreIDInAddressBook(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStoreIDInMailfile(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSynchInternetPassword(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateAddressBook(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseCertificateAuthority(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String switchToID(String idFile, String userPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
