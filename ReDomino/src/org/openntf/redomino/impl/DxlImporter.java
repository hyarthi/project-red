/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Database;
import lotus.domino.RichTextItem;
import lotus.domino.Stream;

/**
 * @author Vladimir Kornienko
 *
 */
public class DxlImporter extends BaseNonThreadSafe<org.openntf.domino.DxlImporter, lotus.domino.DxlImporter, Session>
		implements org.openntf.domino.DxlImporter {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DxlImporter(lotus.domino.DxlImporter delegate, Session parent) {
		super(delegate, parent, NOTES_DXLIMPORTER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAclImportOption(AclImportOption option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDesignImportOption(DesignImportOption option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentImportOption(DocumentImportOption option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInputValidationOption(InputValidationOption option) {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAclImportOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getCompileLotusScript() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCreateFTIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDesignImportOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDocumentImportOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getExitOnFirstFatalError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFirstImportedNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getImportedNoteCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInputValidationOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNextImportedNoteID(String noteid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getReplaceDbProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getReplicaRequiredForReplaceOrUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUnknownTokenLogOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void importDxl(RichTextItem rtitem, Database database) {
		// TODO Auto-generated method stub

	}

	@Override
	public void importDxl(Stream stream, Database database) {
		// TODO Auto-generated method stub

	}

	@Override
	public void importDxl(String dxl, Database database) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAclImportOption(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCompileLotusScript(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateFTIndex(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDesignImportOption(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentImportOption(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setExitOnFirstFatalError(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInputValidationOption(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLogComment(String comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReplaceDbProperties(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReplicaRequiredForReplaceOrUpdate(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUnknownTokenLogOption(int option) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
