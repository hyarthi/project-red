/**
 * 
 */
package org.openntf.redomino.impl;

import java.awt.Color;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class ColorObject extends BaseNonThreadSafe<org.openntf.domino.ColorObject, lotus.domino.ColorObject, Session> implements
org.openntf.domino.ColorObject {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ColorObject(lotus.domino.ColorObject delegate, Session parent) {
		super(delegate, parent, NOTES_COLOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHex(String hex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBlue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGreen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLuminance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotesColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSaturation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int setHSL(int hue, int saturation, int luminance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNotesColor(int notesColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int setRGB(int red, int green, int blue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
