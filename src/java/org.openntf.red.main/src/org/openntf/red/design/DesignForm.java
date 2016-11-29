package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignForm extends AnyFormOrSubform {

	public String getXPageAlt();

	public void setXPageAlt(String xpageAlt);

	public String getXPageAltClient();

	public void setXPageAltClient(String xpageAltClient);

}
