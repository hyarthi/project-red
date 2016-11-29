package org.openntf.red.design;

import java.util.Map;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author Roland Praml
 * 
 */
public interface ScriptLibraryJava extends ScriptLibrary {
	public Map<String, byte[]> getClassData();

	public Map<String, String> getClassSource();

}
