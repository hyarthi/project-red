package org.openntf.red.schema;

import java.io.Externalizable;
import java.util.Map;
import java.util.Set;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author Nathan T. Freeman
 * 
 */
public interface IDocumentDefinition extends Externalizable {
	public void setParent(final IDatabaseSchema parent);

	public String getName();

	public void setName(final String name);

	public boolean isDefaultSummary();

	public void setDefaultSummary(final boolean defaultSummary);

	public Set<String> getItemDefinitionKeys();

	//	public void setItemDefinitionKeys(final Set<String> itemDefinitionKeys);
	//
	//	public void addItemDefinitionKey(final String key);

	public Map<String, IItemDefinition> getItemDefinitions();

	public void addItemDefinition(final IItemDefinition itemDef);

	public Map<String, String> getOverrideLabels();

	public IDatabaseSchema getParent();

}
