package org.openntf.red;

import org.openntf.red.types.DocumentDescendant;

/**
 * <i> Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface MIMEHeader.
 */
public interface MIMEHeader extends Base, lotus.domino.MIMEHeader, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#addValText(java.lang.String)
	 */
	@Override
	public boolean addValText(final String valueText);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#addValText(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean addValText(final String valueText, final String charSet);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderName()
	 */
	@Override
	public String getHeaderName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderVal()
	 */
	@Override
	public String getHeaderVal();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderVal(boolean)
	 */
	@Override
	public String getHeaderVal(final boolean folded);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderVal(boolean, boolean)
	 */
	@Override
	public String getHeaderVal(final boolean folded, final boolean decoded);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderValAndParams()
	 */
	@Override
	public String getHeaderValAndParams();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderValAndParams(boolean)
	 */
	@Override
	public String getHeaderValAndParams(final boolean folded);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getHeaderValAndParams(boolean, boolean)
	 */
	@Override
	public String getHeaderValAndParams(final boolean folded, final boolean decoded);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getParamVal(java.lang.String)
	 */
	@Override
	public String getParamVal(final String paramName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#getParamVal(java.lang.String, boolean)
	 */
	@Override
	public String getParamVal(final String paramName, final boolean folded);

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public MIMEEntity getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#setHeaderVal(java.lang.String)
	 */
	@Override
	public boolean setHeaderVal(final String headerValue);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#setHeaderValAndParams(java.lang.String)
	 */
	@Override
	public boolean setHeaderValAndParams(final String headerParamValue);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.MIMEHeader#setParamVal(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean setParamVal(final String parameterName, final String parameterValue);

}
