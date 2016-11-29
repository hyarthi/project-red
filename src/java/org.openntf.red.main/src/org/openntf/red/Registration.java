package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Registration.
 */
public interface Registration extends Base, lotus.domino.Registration, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Registration#addCertifierToAddressBook(java.lang.String)
	 */
	@Override
	public boolean addCertifierToAddressBook(final String idFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Registration#addCertifierToAddressBook(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean addCertifierToAddressBook(final String idFile, final String password);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.Registration#addCertifierToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addCertifierToAddressBook(final String idFile, final String password, final String location,
			final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addServerToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addServerToAddressBook(final String idFile, final String server, final String domain);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addServerToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addServerToAddressBook(final String idFile, final String server, final String domain,
			final String userPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addServerToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addServerToAddressBook(final String idFile, final String server, final String domain,
			final String userPassword, final String network, final String adminName, final String title,
			final String location, final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addUserProfile(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void addUserProfile(final String userName, final String profile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addUserToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addUserToAddressBook(final String idFile, final String fullName, final String lastName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addUserToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addUserToAddressBook(final String idFile, final String fullName, final String lastName,
			final String userPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#addUserToAddressBook(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addUserToAddressBook(final String idFile, final String fullName, final String lastName,
			final String userPassword, final String firstName, final String middleName, final String mailServer,
			final String mailFilePath, final String forwardingAddress, final String location, final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#crossCertify(java.lang.String)
	 */
	@Override
	public boolean crossCertify(final String idFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#crossCertify(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean crossCertify(final String idFile, final String certPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#crossCertify(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean crossCertify(final String idFile, final String certPassword, final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#deleteIDOnServer(java.lang.String,
	 * boolean)
	 */
	@Override
	public void deleteIDOnServer(final String userName, final boolean isServerID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getAltOrgUnit()
	 */
	@Override
	public Vector<String> getAltOrgUnit();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getAltOrgUnitLang()
	 */
	@Override
	public Vector<String> getAltOrgUnitLang();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getCertifierIDFile()
	 */
	@Override
	public String getCertifierIDFile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getCertifierName()
	 */
	@Override
	public String getCertifierName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getCreateMailDb()
	 */
	@Override
	public boolean getCreateMailDb();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getExpiration()
	 */
	@Override
	public DateTime getExpiration();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getForeignDN()
	 */
	@Override
	public String getForeignDN();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getGroupList()
	 */
	@Override
	public Vector<String> getGroupList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getIDFromServer(java.lang.String,
	 * java.lang.String, boolean)
	 */
	@Override
	public void getIDFromServer(final String userName, final String filePath, final boolean isServerID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getIDType()
	 */
	@Override
	public int getIDType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailACLManager()
	 */
	@Override
	public String getMailACLManager();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailInternetAddress()
	 */
	@Override
	public String getMailInternetAddress();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailOwnerAccess()
	 */
	@Override
	public int getMailOwnerAccess();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailQuotaSizeLimit()
	 */
	@Override
	public int getMailQuotaSizeLimit();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailQuotaWarningThreshold()
	 */
	@Override
	public int getMailQuotaWarningThreshold();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailReplicaServers()
	 */
	@Override
	public Vector<String> getMailReplicaServers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailSystem()
	 */
	@Override
	public int getMailSystem();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMailTemplateName()
	 */
	@Override
	public String getMailTemplateName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getMinPasswordLength()
	 */
	@Override
	public int getMinPasswordLength();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getOrgUnit()
	 */
	@Override
	public String getOrgUnit();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getPolicyName()
	 */
	@Override
	public String getPolicyName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getPublicKeySize()
	 */
	@Override
	public int getPublicKeySize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRegistrationLog()
	 */
	@Override
	public String getRegistrationLog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRegistrationServer()
	 */
	@Override
	public String getRegistrationServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRoamingCleanupPeriod()
	 */
	@Override
	public int getRoamingCleanupPeriod();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRoamingCleanupSetting()
	 */
	@Override
	public int getRoamingCleanupSetting();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRoamingServer()
	 */
	@Override
	public String getRoamingServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getRoamingSubdir()
	 */
	@Override
	public String getRoamingSubdir();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getShortName()
	 */
	@Override
	public String getShortName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getStoreIDInAddressBook()
	 */
	@Override
	public boolean getStoreIDInAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getUpdateAddressBook()
	 */
	@Override
	public boolean getUpdateAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#getUserInfo(java.lang.String,
	 * java.lang.StringBuffer, java.lang.StringBuffer, java.lang.StringBuffer,
	 * java.lang.StringBuffer, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void getUserInfo(final String userName, final StringBuffer mailServer, final StringBuffer mailFile,
			final StringBuffer mailDomain, final StringBuffer mailSystem, final Vector profile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isEnforceUniqueShortName()
	 */
	@Override
	public boolean isEnforceUniqueShortName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isMailCreateFTIndex()
	 */
	@Override
	public boolean isMailCreateFTIndex();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isNoIDFile()
	 */
	@Override
	public boolean isNoIDFile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isNorthAmerican()
	 */
	@Override
	public boolean isNorthAmerican();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isRoamingUser()
	 */
	@Override
	public boolean isRoamingUser();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isStoreIDInMailfile()
	 */
	@Override
	public boolean isStoreIDInMailfile();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isSynchInternetPassword()
	 */
	@Override
	public boolean isSynchInternetPassword();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#isUseCertificateAuthority()
	 */
	@Override
	public boolean isUseCertificateAuthority();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#recertify(java.lang.String)
	 */
	@Override
	public boolean recertify(final String idFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#recertify(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean recertify(final String idFile, final String certPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#recertify(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean recertify(final String idFile, final String certPassword, final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewCertifier(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewCertifier(final String org, final String idFile, final String certPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewCertifier(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewCertifier(final String org, final String idFile, final String certPassword,
			final String country);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewServer(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewServer(final String server, final String idFile, final String domain,
			final String password);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewServer(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewServer(final String server, final String idFile, final String domain,
			final String serverPassword, final String certPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewServer(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean registerNewServer(final String server, final String idFile, final String domain,
			final String serverPassword, final String certPassword, final String location, final String comment,
			final String network, final String adminName, final String title);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewUser(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewUser(final String lastName, final String idFile, final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean registerNewUser(final String lastName, final String idFile, final String server,
			final String firstName, final String middleName, final String certPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewUser(final String lastName, final String idFile, final String server,
			final String firstName, final String middleName, final String certPassword, final String location,
			final String comment, final String mailDBPath, final String forward, final String userPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#registerNewUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerNewUser(final String lastName, final String idFile, final String server,
			final String firstName, final String middleName, final String certPassword, final String location,
			final String comment, final String mailDBPath, final String forward, final String userPassword,
			final String altName, final String altNameLang);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setAltOrgUnit(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setAltOrgUnit(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setAltOrgUnitLang(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setAltOrgUnitLang(final Vector languages);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setCertifierIDFile(java.lang.String)
	 */
	@Override
	public void setCertifierIDFile(final String idFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setCertifierName(java.lang.String)
	 */
	@Override
	public void setCertifierName(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setCreateMailDb(boolean)
	 */
	@Override
	public void setCreateMailDb(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setEnforceUniqueShortName(boolean)
	 */
	@Override
	public void setEnforceUniqueShortName(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setExpiration(lotus.domino.DateTime)
	 */
	@Override
	public void setExpiration(final lotus.domino.DateTime expiration);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setForeignDN(java.lang.String)
	 */
	@Override
	public void setForeignDN(final String dn);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setGroupList(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setGroupList(final Vector groups);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setIDType(int)
	 */
	@Override
	public void setIDType(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailACLManager(java.lang.String)
	 */
	@Override
	public void setMailACLManager(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailCreateFTIndex(boolean)
	 */
	@Override
	public void setMailCreateFTIndex(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailInternetAddress(java.lang.String)
	 */
	@Override
	public void setMailInternetAddress(final String address);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailOwnerAccess(int)
	 */
	@Override
	public void setMailOwnerAccess(final int access);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailQuotaSizeLimit(int)
	 */
	@Override
	public void setMailQuotaSizeLimit(final int limit);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailQuotaWarningThreshold(int)
	 */
	@Override
	public void setMailQuotaWarningThreshold(final int threshold);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailReplicaServers(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setMailReplicaServers(final Vector servers);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailSystem(int)
	 */
	@Override
	public void setMailSystem(final int system);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMailTemplateName(java.lang.String)
	 */
	@Override
	public void setMailTemplateName(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setMinPasswordLength(int)
	 */
	@Override
	public void setMinPasswordLength(final int length);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setNoIDFile(boolean)
	 */
	@Override
	public void setNoIDFile(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setNorthAmerican(boolean)
	 */
	@Override
	public void setNorthAmerican(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setOrgUnit(java.lang.String)
	 */
	@Override
	public void setOrgUnit(final String unit);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setPolicyName(java.lang.String)
	 */
	@Override
	public void setPolicyName(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setPublicKeySize(int)
	 */
	@Override
	public void setPublicKeySize(final int size);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRegistrationLog(java.lang.String)
	 */
	@Override
	public void setRegistrationLog(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRegistrationServer(java.lang.String)
	 */
	@Override
	public void setRegistrationServer(final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRoamingCleanupPeriod(int)
	 */
	@Override
	public void setRoamingCleanupPeriod(final int period);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRoamingCleanupSetting(int)
	 */
	@Override
	public void setRoamingCleanupSetting(final int setting);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRoamingServer(java.lang.String)
	 */
	@Override
	public void setRoamingServer(final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRoamingSubdir(java.lang.String)
	 */
	@Override
	public void setRoamingSubdir(final String dirPath);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setRoamingUser(boolean)
	 */
	@Override
	public void setRoamingUser(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setShortName(java.lang.String)
	 */
	@Override
	public void setShortName(final String shortName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setStoreIDInAddressBook(boolean)
	 */
	@Override
	public void setStoreIDInAddressBook(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setStoreIDInMailfile(boolean)
	 */
	@Override
	public void setStoreIDInMailfile(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setSynchInternetPassword(boolean)
	 */
	@Override
	public void setSynchInternetPassword(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setUpdateAddressBook(boolean)
	 */
	@Override
	public void setUpdateAddressBook(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#setUseCertificateAuthority(boolean)
	 */
	@Override
	public void setUseCertificateAuthority(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Registration#switchToID(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String switchToID(final String idFile, final String userPassword);
}
