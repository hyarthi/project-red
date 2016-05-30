/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Collection;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Name;

/**
 * @author Vladimir Kornienko
 *
 */
public class NameODA extends BaseNonThreadSafe<org.openntf.domino.Name, lotus.domino.Name, Session> implements org.openntf.domino.Name,
Comparable<org.openntf.domino.Name>, Cloneable {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected NameODA(Name delegate, Session parent) {
		super(delegate, parent, NOTES_NAME);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sess
	 * @param name
	 * @param lang
	 */
	protected NameODA(Session sess, String name, String lang) {
		super(null, sess, NOTES_NAME);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<String> getGroups(String serverName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRFC82xInternetAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.Name clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIDprefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamePart(NamePartKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NameFormat getNameFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NameError getNameError() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(org.openntf.domino.Name o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAbbreviated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr821() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr822Comment1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr822Comment2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr822Comment3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr822LocalPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddr822Phrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getADMD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCanonical() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGiven() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInitials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrganization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgUnit1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgUnit2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgUnit3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgUnit4() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPRMD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHierarchical() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
