package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignCollection<E extends DesignBase> extends Iterable<E> {
	public int getCount();
}
