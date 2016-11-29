package org.openntf.red;

import org.openntf.red.types.DocumentDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextRange.
 */
public interface RichTextRange extends Base, lotus.domino.RichTextRange, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#Clone()
	 */
	@Override
	public lotus.domino.RichTextRange Clone();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#findandReplace(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int findandReplace(final String target, final String replacement);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#findandReplace(java.lang.String,
	 * java.lang.String, long)
	 */
	@Override
	public int findandReplace(final String target, final String replacement, final long options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#getNavigator()
	 */
	@Override
	public RichTextNavigator getNavigator();

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public RichTextItem getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#getStyle()
	 */
	@Override
	public RichTextStyle getStyle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#getTextParagraph()
	 */
	@Override
	public String getTextParagraph();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#getTextRun()
	 */
	@Override
	public String getTextRun();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#getType()
	 */
	@Override
	public int getType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#reset(boolean, boolean)
	 */
	@Override
	public void reset(final boolean begin, final boolean end);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#setBegin(lotus.domino.Base)
	 */
	@Override
	public void setBegin(final lotus.domino.Base element);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#setEnd(lotus.domino.Base)
	 */
	@Override
	public void setEnd(final lotus.domino.Base element);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextRange#setStyle(lotus.domino.RichTextStyle)
	 */
	@Override
	public void setStyle(final lotus.domino.RichTextStyle style);

}
