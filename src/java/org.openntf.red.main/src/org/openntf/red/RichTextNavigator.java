package org.openntf.red;

import org.openntf.red.types.DocumentDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextNavigator.
 */
public interface RichTextNavigator extends Base, lotus.domino.RichTextNavigator, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#Clone()
	 */
	@Override
	public RichTextNavigator Clone();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findFirstElement(int)
	 */
	@Override
	public boolean findFirstElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findFirstString(java.lang.String)
	 */
	@Override
	public boolean findFirstString(final String target);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findFirstString(java.lang.String,
	 * int)
	 */
	@Override
	public boolean findFirstString(final String target, final int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findLastElement(int)
	 */
	@Override
	public boolean findLastElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNextElement()
	 */
	@Override
	public boolean findNextElement();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNextElement(int)
	 */
	@Override
	public boolean findNextElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNextElement(int, int)
	 */
	@Override
	public boolean findNextElement(final int type, final int occurrence);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNextString(java.lang.String)
	 */
	@Override
	public boolean findNextString(final String target);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNextString(java.lang.String, int)
	 */
	@Override
	public boolean findNextString(final String target, final int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#findNthElement(int, int)
	 */
	@Override
	public boolean findNthElement(final int type, final int occurrence);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getElement()
	 */
	@Override
	public Base getElement();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getFirstElement(int)
	 */
	@Override
	public Base getFirstElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getLastElement(int)
	 */
	@Override
	public Base getLastElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getNextElement()
	 */
	@Override
	public Base getNextElement();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getNextElement(int)
	 */
	@Override
	public Base getNextElement(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getNextElement(int, int)
	 */
	@Override
	public Base getNextElement(final int type, final int occurrence);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#getNthElement(int, int)
	 */
	@Override
	public Base getNthElement(final int type, final int occurrence);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#setCharOffset(int)
	 */
	@Override
	public void setCharOffset(final int offset);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#setPosition(lotus.domino.Base)
	 */
	@Override
	public void setPosition(final lotus.domino.Base element);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextNavigator#setPositionAtEnd(lotus.domino.Base)
	 */
	@Override
	public void setPositionAtEnd(final lotus.domino.Base element);

}
