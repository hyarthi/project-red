/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.RichTextTab;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextParagraphStyle extends
		BaseNonThreadSafe<org.openntf.domino.RichTextParagraphStyle, lotus.domino.RichTextParagraphStyle, Session>
		implements org.openntf.domino.RichTextParagraphStyle {

	/**
	 * @param delegate
	 * @param parent
	 * @param wf
	 * @param cppId
	 */
	protected RichTextParagraphStyle(lotus.domino.RichTextParagraphStyle delegate, Session parent, WrapperFactory wf,
			long cppId) {
		super(delegate, parent, NOTES_RTPSTYLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAllTabs() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAlignment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFirstLineLeftMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInterLineSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeftMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPagination() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRightMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpacingAbove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpacingBelow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<RichTextTab> getTabs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAlignment(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignment(Align value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFirstLineLeftMargin(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInterLineSpacing(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLeftMargin(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPagination(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRightMargin(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpacingAbove(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpacingBelow(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTab(int position, int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTabs(int count, int startPos, int interval) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTabs(int count, int startPos, int interval, int type) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
