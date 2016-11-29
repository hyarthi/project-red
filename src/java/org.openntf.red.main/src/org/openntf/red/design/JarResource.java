package org.openntf.red.design;

import java.util.Map;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface JarResource extends AnyFileResource {
	public Map<String, byte[]> getClassData();
}
