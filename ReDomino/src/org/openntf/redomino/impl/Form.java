/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Date;
import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.NoteCollection;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Form extends BaseNonThreadSafe<org.openntf.domino.Form, lotus.domino.Form, Database> implements org.openntf.domino.Form {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Form(lotus.domino.Form delegate, Database parent) {
		super(delegate, parent, NOTES_FORM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getModifiedNoteCount(Date since) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getXPageAlt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getXPageAltClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectionFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteCollection getNoteCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
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
	public Vector<String> getAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFieldType(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getFormUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getLockHolders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getReaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProtectReaders() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtectUsers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSubForm() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector names) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFormUsers(Vector names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProtectReaders(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProtectUsers(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReaders(Vector names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
