package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface AnyFormOrSubform extends DesignBaseNamed {
	public FormField addField();

	public FormFieldList getFields();

	public void swapFields(final int a, final int b);
}
