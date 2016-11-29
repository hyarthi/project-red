package org.openntf.red.schema;

import java.util.Map;

import org.openntf.red.Database;
import org.openntf.red.Document;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author Nathan T. Freeman
 * 
 */
public interface IDatabaseSchema {

	public Map<String, IDocumentDefinition> getDocumentDefinitions();

	public Map<String, IItemDefinition> getItemDefinitions();

	public IItemDefinition createItemDefinition(String itemKey, Class<?> type);

	public Map<Class<? extends IDominoType>, IDominoType> getTypeDefinitions();

	public IDominoType getTypeDefinition(final Class<? extends IDominoType> type);

	public Document createDocument(final Database db, final String doctype);

	public boolean validateDocument(final Document doc);

}
