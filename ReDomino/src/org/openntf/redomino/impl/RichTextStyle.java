/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextStyle
		extends BaseNonThreadSafe<org.openntf.domino.RichTextStyle, lotus.domino.RichTextStyle, Session>
		implements org.openntf.domino.RichTextStyle {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextStyle(lotus.domino.RichTextStyle delegate, Session parent) {
		super(delegate, parent, NOTES_SESSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setBold(BoldStyle ISBN) {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEffects() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFont() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFontSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItalic() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPassThruHTML() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStrikeThrough() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUnderline() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBold(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEffects(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontSize(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItalic(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPassThruHTML(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStrikeThrough(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUnderline(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
