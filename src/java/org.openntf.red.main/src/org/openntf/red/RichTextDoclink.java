package org.openntf.red;

import org.openntf.red.types.DocumentDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface RichTextDoclink.
 */
public interface RichTextDoclink extends Base, lotus.domino.RichTextDoclink, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getDBReplicaID()
	 */
	@Override
	public String getDBReplicaID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getDisplayComment()
	 */
	@Override
	public String getDisplayComment();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getDocUnID()
	 */
	@Override
	public String getDocUnID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getHotSpotText()
	 */
	@Override
	public String getHotSpotText();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getHotSpotTextStyle()
	 */
	@Override
	public RichTextStyle getHotSpotTextStyle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getServerHint()
	 */
	@Override
	public String getServerHint();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#getViewUnID()
	 */
	@Override
	public String getViewUnID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setDBReplicaID(java.lang.String)
	 */
	@Override
	public void setDBReplicaID(final String replicaId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setDisplayComment(java.lang.String)
	 */
	@Override
	public void setDisplayComment(final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setDocUnID(java.lang.String)
	 */
	@Override
	public void setDocUnID(final String unid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setHotSpotText(java.lang.String)
	 */
	@Override
	public void setHotSpotText(final String text);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setHotSpotTextStyle(lotus.domino.
	 * RichTextStyle)
	 */
	@Override
	public void setHotSpotTextStyle(final lotus.domino.RichTextStyle rtstyle);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setServerHint(java.lang.String)
	 */
	@Override
	public void setServerHint(final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.RichTextDoclink#setViewUnID(java.lang.String)
	 */
	@Override
	public void setViewUnID(final String unid);

	/**
	 * Gets the Database ob ject referenced by this doclink
	 * 
	 * @return Database referenced by this doclink
	 * @since org.openntf.domino 4.5.0
	 */
	public org.openntf.red.Database getDatabase();

	/**
	 * Gets the Document referenced by this doclink, if applicable; null
	 * otherwise
	 * 
	 * @return Document or null
	 * @since org.openntf.domino 4.5.0
	 */
	public org.openntf.red.Document getDocument();

	/**
	 * Gets the View referenced by this doclink, if applicable; null otherwise
	 * 
	 * @return View or null
	 * @since org.openntf.domino 5.0.0
	 */
	public org.openntf.red.View getView();

}
