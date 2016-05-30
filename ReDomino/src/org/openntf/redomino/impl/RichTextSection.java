/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.ColorObject;
import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextNavigator;
import org.openntf.domino.RichTextStyle;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextSection
		extends BaseNonThreadSafe<org.openntf.domino.RichTextSection, lotus.domino.RichTextSection, RichTextNavigator>
		implements org.openntf.domino.RichTextSection {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextSection(lotus.domino.RichTextSection delegate, RichTextNavigator parent) {
		super(delegate, parent, NOTES_COLOR);
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
	public ColorObject getBarColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextNavigator getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextStyle getTitleStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExpanded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBarColor(lotus.domino.ColorObject color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExpanded(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitleStyle(lotus.domino.RichTextStyle style) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
