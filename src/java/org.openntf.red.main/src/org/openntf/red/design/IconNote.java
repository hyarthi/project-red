package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface IconNote extends DesignBase {
	public static enum DASMode {
		NONE, VIEWS, VIEWSANDDOCUMENTS;
	}

	/**
	 * Sets the Domino Data Access Service mode for the database.
	 * 
	 * @param mode
	 */
	void setDASMode(final DASMode mode);

	/**
	 * @return The Domino Data Access Service mode for the database.
	 */
	DASMode getDASMode();

	String[] getXotsClassNames();
}
