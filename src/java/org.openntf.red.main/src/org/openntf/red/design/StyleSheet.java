package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface StyleSheet extends DesignBaseNamed {
	/**
	 * @return the content of the style sheet
	 */
	public String getContent();

	/**
	 * @param content
	 *            the new content of the style sheet
	 */
	public void setContent(String content);
}
