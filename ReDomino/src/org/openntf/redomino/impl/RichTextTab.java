/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.RichTextParagraphStyle;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextTab
		extends BaseNonThreadSafe<org.openntf.domino.RichTextTab, lotus.domino.RichTextTab, RichTextParagraphStyle>
		implements org.openntf.domino.RichTextTab {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextTab(lotus.domino.RichTextTab delegate, RichTextParagraphStyle parent) {
		super(delegate, parent, NOTES_RTTAB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
