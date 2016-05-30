/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import lotus.domino.NoteCollection;

/**
 * @author Vladimir Kornienko
 *
 */
public class DxlExporter extends BaseNonThreadSafe<org.openntf.domino.DxlExporter, lotus.domino.DxlExporter, Session> implements
org.openntf.domino.DxlExporter {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DxlExporter(lotus.domino.DxlExporter delegate, Session parent) {
		super(delegate, parent, NOTES_DXLEXPORTER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMIMEOption(MIMEOption option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRichTextOption(RichTextOption option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(Database database) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(DocumentCollection docs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NoteCollection notes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttachmentOmittedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getConvertNotesBitmapsToGIF() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDoctypeSYSTEM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getExitOnFirstFatalError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getForceNoteFormat() {
		// TODO Auto-generated method stub
		return false;
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
	public int getMIMEOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOLEObjectOmittedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getOmitItemNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getOmitMiscFileObjects() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOmitOLEObjects() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOmitRichtextAttachments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOmitRichtextPictures() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOutputDOCTYPE() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPictureOmittedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getRestrictToItemNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRichTextOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getUncompressAttachments() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttachmentOmittedText(String replacementText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConvertNotesBitmapsToGIF(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDoctypeSYSTEM(String system) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExitOnFirstFatalError(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setForceNoteFormat(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogComment(String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMIMEOption(int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOLEObjectOmittedText(String replacementText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOmitItemNames(Vector names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOmitMiscFileObjects(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOmitOLEObjects(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOmitRichtextAttachments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOmitRichtextPictures(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOutputDOCTYPE(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPictureOmittedText(String replacementText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRestrictToItemNames(Vector names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRichTextOption(int option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUncompressAttachments(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
