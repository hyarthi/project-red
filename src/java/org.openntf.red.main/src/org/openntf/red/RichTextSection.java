package org.openntf.red;

import org.openntf.red.types.DocumentDescendant;

/**
 * The Interface RichTextSection.
 */
public interface RichTextSection extends Base, lotus.domino.RichTextSection, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#getBarColor()
	 */
	@Override
	public ColorObject getBarColor();

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public RichTextNavigator getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#getTitle()
	 */
	@Override
	public String getTitle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#getTitleStyle()
	 */
	@Override
	public RichTextStyle getTitleStyle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#isExpanded()
	 */
	@Override
	public boolean isExpanded();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#setBarColor(lotus.domino.ColorObject)
	 */
	@Override
	public void setBarColor(final lotus.domino.ColorObject color);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#setExpanded(boolean)
	 */
	@Override
	public void setExpanded(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextSection#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(final String title);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.RichTextSection#setTitleStyle(lotus.domino.RichTextStyle)
	 */
	@Override
	public void setTitleStyle(final lotus.domino.RichTextStyle style);

}
