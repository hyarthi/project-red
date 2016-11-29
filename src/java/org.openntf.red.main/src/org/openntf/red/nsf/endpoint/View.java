/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;

/**
 * @author Vladimir Kornienko
 *
 */
public interface View<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Database<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {

	/**
	 * 
	 * @param position
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry removeEntry(long position);

	/**
	 * 
	 * @param entry
	 * @param position
	 */
	@SuppressWarnings("rawtypes")
	public void setEntry(ViewEntry entry, long position);

	/**
	 * 
	 * @param entry
	 */
	@SuppressWarnings("rawtypes")
	public void addEntry(ViewEntry entry);
	
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntries();
	
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact);
	
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntriesByKey(List keys, boolean exact);
	
	public boolean isSystemColumn(String name);
	
	public int getColumnDataType(String name);
	
	/*@SuppressWarnings("rawtypes")
	public ViewEntry getFirstEntryByKey(String key, boolean exact);
	
	@SuppressWarnings("rawtypes")
	public ViewEntry getFirstEntryByKey(List keys, boolean exact);*/
}
