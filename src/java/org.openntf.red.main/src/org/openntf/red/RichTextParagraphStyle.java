package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextParagraphStyle.
 */
public interface RichTextParagraphStyle extends Base, lotus.domino.RichTextParagraphStyle, SessionDescendant {

	/**
	 * Enum to allow easy access to RichTextParagraphStyle options
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public static enum Align {

		/** The center. */
		CENTER(RichTextParagraphStyle.ALIGN_CENTER),
		/** The full. */
		FULL(RichTextParagraphStyle.ALIGN_FULL),
		/** The left. */
		LEFT(RichTextParagraphStyle.ALIGN_LEFT),
		/** The nowrap. */
		NOWRAP(RichTextParagraphStyle.ALIGN_NOWRAP),
		/** The right. */
		RIGHT(RichTextParagraphStyle.ALIGN_RIGHT);

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new align.
		 * 
		 * @param value
		 *            the value
		 */
		private Align(final int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#clearAllTabs()
	 */
	@Override
	public void clearAllTabs();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getAlignment()
	 */
	@Override
	public int getAlignment();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getFirstLineLeftMargin()
	 */
	@Override
	public int getFirstLineLeftMargin();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getInterLineSpacing()
	 */
	@Override
	public int getInterLineSpacing();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getLeftMargin()
	 */
	@Override
	public int getLeftMargin();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getPagination()
	 */
	@Override
	public int getPagination();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getRightMargin()
	 */
	@Override
	public int getRightMargin();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getSpacingAbove()
	 */
	@Override
	public int getSpacingAbove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getSpacingBelow()
	 */
	@Override
	public int getSpacingBelow();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#getTabs()
	 */
	@Override
	public Vector<RichTextTab> getTabs();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setAlignment(int)
	 */
	@Override
	public void setAlignment(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setFirstLineLeftMargin(int)
	 */
	@Override
	public void setFirstLineLeftMargin(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setInterLineSpacing(int)
	 */
	@Override
	public void setInterLineSpacing(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setLeftMargin(int)
	 */
	@Override
	public void setLeftMargin(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setPagination(int)
	 */
	@Override
	public void setPagination(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setRightMargin(int)
	 */
	@Override
	public void setRightMargin(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setSpacingAbove(int)
	 */
	@Override
	public void setSpacingAbove(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setSpacingBelow(int)
	 */
	@Override
	public void setSpacingBelow(final int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setTab(int, int)
	 */
	@Override
	public void setTab(final int position, final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setTabs(int, int, int)
	 */
	@Override
	public void setTabs(final int count, final int startPos, final int interval);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextParagraphStyle#setTabs(int, int, int, int)
	 */
	@Override
	public void setTabs(final int count, final int startPos, final int interval, final int type);

	/**
	 * Gets the parent Session of the RichTextParagraphStyle
	 * 
	 * @return parent Session
	 * @since org.openntf.domino 1.0.0
	 */
	public Session getParent();

	/**
	 * Sets the alignment using
	 * {@link org.openntf.domino.RichTextParagraphStyle.Align}
	 * 
	 * @param value
	 *            Align alignment
	 * @since org.openntf.domino 1.0.0
	 */
	public void setAlignment(final Align value);

}
