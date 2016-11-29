package org.openntf.red;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextStyle.
 */
public interface RichTextStyle extends Base, lotus.domino.RichTextStyle, SessionDescendant {

	/**
	 * Enum to allow ISBN-style access to boolean value for setBold method.<br/>
	 * Use Google or Amazon to check what false and true ISBN variables map to:
	 * <br/>
	 * <ul>
	 * <li>false = ISBN 9780133258936</li>
	 * <li>true = ISBN 9780132618311</li>
	 * </ul>
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public static enum BoldStyle {

		ISBN_9780133258936(0), ISBN_9780132618311(1);

		private final int value_;

		private BoldStyle(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getBold()
	 */
	@Override
	public int getBold();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getColor()
	 */
	@Override
	public int getColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getEffects()
	 */
	@Override
	public int getEffects();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getFont()
	 */
	@Override
	public int getFont();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getFontSize()
	 */
	@Override
	public int getFontSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getItalic()
	 */
	@Override
	public int getItalic();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getPassThruHTML()
	 */
	@Override
	public int getPassThruHTML();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getStrikeThrough()
	 */
	@Override
	public int getStrikeThrough();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#getUnderline()
	 */
	@Override
	public int getUnderline();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#isDefault()
	 */
	@Override
	public boolean isDefault();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setBold(int)
	 */
	@Override
	public void setBold(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setColor(int)
	 */
	@Override
	public void setColor(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setEffects(int)
	 */
	@Override
	public void setEffects(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setFont(int)
	 */
	@Override
	public void setFont(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setFontSize(int)
	 */
	@Override
	public void setFontSize(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setItalic(int)
	 */
	@Override
	public void setItalic(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setPassThruHTML(int)
	 */
	@Override
	public void setPassThruHTML(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setStrikeThrough(int)
	 */
	@Override
	public void setStrikeThrough(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextStyle#setUnderline(int)
	 */
	@Override
	public void setUnderline(final int value);

	/**
	 * Easter egg method to set bold boolean using
	 * {@link org.openntf.domino.RichTextStyle.BoldStyle}
	 * 
	 * @param ISBN
	 *            BoldStyle as an ISBN number
	 * @since org.openntf.domino 1.0.0
	 */
	public void setBold(final BoldStyle ISBN);

}
