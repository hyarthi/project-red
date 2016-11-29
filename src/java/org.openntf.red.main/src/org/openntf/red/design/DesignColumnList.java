package org.openntf.red.design;

import java.util.List;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignColumnList extends List<DesignColumn> {
	public void swap(final int a, final int b);
}
