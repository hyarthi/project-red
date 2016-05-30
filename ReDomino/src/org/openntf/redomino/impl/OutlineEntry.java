/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Outline;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class OutlineEntry extends BaseNonThreadSafe<org.openntf.domino.OutlineEntry, lotus.domino.OutlineEntry, Outline>
		implements org.openntf.domino.OutlineEntry {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected OutlineEntry(lotus.domino.OutlineEntry delegate, Outline parent) {
		super(delegate, parent, NOTES_OUTLINEENTRY);
		// TODO Auto-generated constructor stub
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
	public String getAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntryClass() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrameText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHideFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImagesText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getKeepSelectionFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNamedElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outline getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUseHideFormula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHiddenFromNotes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHiddenFromWeb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInThisDB() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAction(String action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAlias(String alias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFrameText(String frameText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHidden(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHiddenFromNotes(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHiddenFromWeb(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHideFormula(String formula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImagesText(String imagesText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKeepSelectionFocus(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setNamedElement(lotus.domino.Database db, String elementName, int entryClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNoteLink(lotus.domino.Database db) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNoteLink(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNoteLink(lotus.domino.View view) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setURL(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUseHideFormula(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
