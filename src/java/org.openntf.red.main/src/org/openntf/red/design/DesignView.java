package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignView extends AnyFolderOrView {
	public String getSelectionFormula();

	public void setSelectionFormula(final String selectionFormula);
}
