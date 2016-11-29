package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface AnyFolderOrView extends DesignBaseNamed {
	public DesignColumn addColumn();

	public DesignColumnList getColumns();

	public void swapColumns(int a, int b);

	public org.openntf.red.View getView();
}
