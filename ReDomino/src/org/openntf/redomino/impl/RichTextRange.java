/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.RichTextNavigator;
import org.openntf.domino.RichTextStyle;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextRange
		extends BaseNonThreadSafe<org.openntf.domino.RichTextRange, lotus.domino.RichTextRange, RichTextItem>
		implements org.openntf.domino.RichTextRange {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextRange(lotus.domino.RichTextRange delegate, RichTextItem parent) {
		super(delegate, parent, NOTES_RTRANGE);
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
	public lotus.domino.RichTextRange Clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findandReplace(String target, String replacement) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findandReplace(String target, String replacement, long options) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RichTextNavigator getNavigator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextItem getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextStyle getStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextParagraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextRun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(boolean begin, boolean end) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBegin(Base element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnd(Base element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStyle(lotus.domino.RichTextStyle style) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
