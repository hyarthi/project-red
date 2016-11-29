package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.DocumentDescendant;

/**
 * The Interface RichTextTable.
 */
public interface RichTextTable extends Base, lotus.domino.RichTextTable, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#addRow()
	 */
	@Override
	public void addRow();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#addRow(int)
	 */
	@Override
	public void addRow(final int count);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#addRow(int, int)
	 */
	@Override
	public void addRow(final int count, final int targetRow);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getAlternateColor()
	 */
	@Override
	public ColorObject getAlternateColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getColor()
	 */
	@Override
	public ColorObject getColor();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getColumnCount()
	 */
	@Override
	public int getColumnCount();

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public RichTextItem getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getRowCount()
	 */
	@Override
	public int getRowCount();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getRowLabels()
	 */
	@Override
	public Vector<String> getRowLabels();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#getStyle()
	 */
	@Override
	public int getStyle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#isRightToLeft()
	 */
	@Override
	public boolean isRightToLeft();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#removeRow()
	 */
	@Override
	public void removeRow();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#removeRow(int)
	 */
	@Override
	public void removeRow(final int count);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#removeRow(int, int)
	 */
	@Override
	public void removeRow(final int count, final int targetRow);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lotus.domino.RichTextTable#setAlternateColor(lotus.domino.ColorObject)
	 */
	@Override
	public void setAlternateColor(final lotus.domino.ColorObject color);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#setColor(lotus.domino.ColorObject)
	 */
	@Override
	public void setColor(final lotus.domino.ColorObject color);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#setRightToLeft(boolean)
	 */
	@Override
	public void setRightToLeft(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#setRowLabels(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setRowLabels(final Vector labels);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextTable#setStyle(int)
	 */
	@Override
	public void setStyle(final int tableStyle);
}
