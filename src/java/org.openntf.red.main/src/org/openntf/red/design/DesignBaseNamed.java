package org.openntf.red.design;

import java.util.List;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignBaseNamed extends DesignBase {
	/**
	 * @return the design element's name
	 */
	public String getName();

	/**
	 * @param name
	 *            The new name for the design element; any |-delimited values will be appended to the aliases
	 */
	public void setName(final String name);

	/**
	 * @return a List of the design element's aliases
	 */
	public List<String> getAliases();

	/**
	 * @return the design element's aliases, |-delimited
	 */
	public String getAlias();

	/**
	 * 
	 * @param alias
	 *            The new alias(es) for the design element, |-delimited
	 */
	public void setAlias(final String alias);

	/**
	 * 
	 * @param aliases
	 *            The new aliases for the design element; any |-delimited values will be exploded into the final list
	 */
	public void setAliases(final Iterable<String> aliases);

	/**
	 * @return The design-element-specific template name.
	 */
	public String getDesignTemplateName();

	/**
	 * 
	 * @param designTemplateName
	 *            The new design template to assign to this specific design element.
	 */
	public void setDesignTemplateName(String designTemplateName);
}
