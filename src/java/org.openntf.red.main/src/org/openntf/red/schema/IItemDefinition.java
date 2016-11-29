package org.openntf.red.schema;

import java.io.Externalizable;
import java.util.Set;

import org.openntf.red.Document;
import org.openntf.red.Item;
import org.openntf.red.Item.Flags;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author Nathan T. Freeman
 * 
 */
public interface IItemDefinition extends Externalizable {
	public void setParent(IDatabaseSchema parent);

	public IDatabaseSchema getParent();

	public String getName();

	public String getShortName();

	public void setName(String name);

	public String getDefaultLabel();

	public void setDefaultLabel(String defaultLabel);

	public Class<? extends IDominoType> getType();

	public void setType(Class<? extends IDominoType> type);

	public Set<Flags> getFlags();

	public void setFlags(Set<Flags> flags);

	public void addFlag(Flags flag);

	public void removeFlag(Flags flag);

	public Object getDefaultValue();

	public void setDefaultValue(Object defaultValue);

	public IItemValidation getValidator();

	public void setValidator(IItemValidation validator);

	public Set<IItemListener> getItemListeners();

	public void addItemListener(IItemListener listener);

	public Item createDefaultItem(Document result, IDocumentDefinition def);
}
