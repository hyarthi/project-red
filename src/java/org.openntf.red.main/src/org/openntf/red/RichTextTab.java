package org.openntf.red;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextTab.
 */
public interface RichTextTab extends Base, lotus.domino.RichTextTab, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTab#clear()
	 */
	@Override
	public void clear();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTab#getPosition()
	 */
	@Override
	public int getPosition();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTab#getType()
	 */
	@Override
	public int getType();

}
