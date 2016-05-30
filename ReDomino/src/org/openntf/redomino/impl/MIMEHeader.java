/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.MIMEEntity;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class MIMEHeader extends BaseNonThreadSafe<org.openntf.domino.MIMEHeader, lotus.domino.MIMEHeader, MIMEEntity>
		implements org.openntf.domino.MIMEHeader {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected MIMEHeader(lotus.domino.MIMEHeader delegate, MIMEEntity parent) {
		super(delegate, parent, NOTES_MIMEENTITY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Document getAncestorDocument() {
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
	public boolean addValText(String valueText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addValText(String valueText, String charSet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHeaderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderVal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderVal(boolean folded) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderVal(boolean folded, boolean decoded) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderValAndParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderValAndParams(boolean folded) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaderValAndParams(boolean folded, boolean decoded) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParamVal(String paramName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParamVal(String paramName, boolean folded) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MIMEEntity getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setHeaderVal(String headerValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setHeaderValAndParams(String headerParamValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setParamVal(String parameterName, String parameterValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
