package org.openntf.red.design;

import java.util.Collection;
import java.util.Map;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author Roland Praml
 * 
 */
public interface XspResource extends DesignBaseNamed {
	public Collection<String> getClassNames();

	public Map<String, byte[]> getClassData();

	public void setClassData(Map<String, byte[]> classData);
}
