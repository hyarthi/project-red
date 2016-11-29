package org.openntf.red.types;

/**
 * <i>Initial code borrowed from OpenNTF Domino API</i><br>
* The Interface Design.
*/
public interface Design {

	/**
	 * Gets the note id.
	 * 
	 * @return the note id
	 */
	public String getNoteID();

	/**
	 * Gets the universal id.
	 * 
	 * @return the universal id
	 */
	public String getUniversalID();

	/**
	 * Gets the document.
	 * 
	 * @return the document
	 */
	public org.openntf.red.Document getDocument();
}