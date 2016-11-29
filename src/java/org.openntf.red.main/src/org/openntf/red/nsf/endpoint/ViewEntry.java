/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ViewEntry<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends ViewEntryCollection<?, ?, ?>>
		extends HasProperties, ViewDescendant, Base<TE, TEF, TEP> {
	public Object getColumnValue(int idx);

	public Object getColumnValue(String name);
	
	public List<Object> getColumnValues();
	
	public long getIndex();
	
	public String getDocumentUNID();
}
