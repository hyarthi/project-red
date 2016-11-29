package org.openntf.red;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface ColorObject.
 */
public interface ColorObject extends Base, lotus.domino.ColorObject, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getBlue()
	 */
	@Override
	public int getBlue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getGreen()
	 */
	@Override
	public int getGreen();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getHue()
	 */
	@Override
	public int getHue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getLuminance()
	 */
	@Override
	public int getLuminance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getNotesColor()
	 */
	@Override
	public int getNotesColor();

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getRed()
	 */
	@Override
	public int getRed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#getSaturation()
	 */
	@Override
	public int getSaturation();

	/**
	 * Sets the color.
	 * 
	 * @param color
	 *            the new color
	 */
	public void setColor(final java.awt.Color color);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#setHSL(int, int, int)
	 */
	@Override
	public int setHSL(final int hue, final int saturation, final int luminance);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#setNotesColor(int)
	 */
	@Override
	public void setNotesColor(final int notesColor);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ColorObject#setRGB(int, int, int)
	 */
	@Override
	public int setRGB(final int red, final int green, final int blue);

	/**
	 * Gets the ColorObject's color as a hex value, standard for web
	 * development.
	 * 
	 * @return String corresponding to the hex value for the color, following
	 *         RGB format, e.g.
	 *         <ul>
	 *         <li>000000 for black</li>
	 *         <li>FFFFFF for white
	 *         <li>
	 *         <li>FF0000 for red</li>
	 *         <li>0000FF for blue</li>
	 *         </ul>
	 * @since org.openntf.domino 1.0.0
	 */
	public String getHex();

	/**
	 * Sets a ColorObject to a specific color using hex format, standard for web
	 * development.
	 * 
	 * @param hex
	 *            String corresponding to the hex value for the color, following
	 *            RGB format, e.g.
	 *            <ul>
	 *            <li>000000 for black</li>
	 *            <li>FFFFFF for white
	 *            <li>
	 *            <li>FF0000 for red</li>
	 *            <li>0000FF for blue</li>
	 *            </ul>
	 * @since org.openntf.domino 1.0.0
	 */
	public void setHex(final String hex);

}
