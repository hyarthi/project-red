/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;

/**
 * Entity representing a database view.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface View<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Database<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {

	/**
	 * (Under consideration)
	 * 
	 * @param position
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry removeEntry(long position);

	/**
	 * (Under consideration)
	 * 
	 * @param entry
	 * @param position
	 */
	@SuppressWarnings("rawtypes")
	public void setEntry(ViewEntry entry, long position);

	/**
	 * (Under consideration)
	 * 
	 * @param entry
	 */
	@SuppressWarnings("rawtypes")
	public void addEntry(ViewEntry entry);

	/**
	 * Returns a collection of all entries within the view.
	 * 
	 * @return Collection of all view entries.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntries();

	/**
	 * Gets a list of view entries that correspond to a specific key.
	 * <p>
	 * A key may be multi-value.
	 * <p>
	 * First key is looked up in the 1st explicitly sorted column, second key -
	 * in the 2nd, etc.
	 * <p>
	 * A <code>null</code> key will result in the filter skipping the mentioned
	 * column.
	 * 
	 * @param key
	 *            Key object.
	 * @param exact
	 *            Whether the keys should be an exact match. Partial lookup done
	 *            otherwise.
	 * @return View entry collection. May be empty if no entries satisfy the
	 *         query.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact);

	/**
	 * Gets a list of view entries that correspond to a specific key.
	 * <p>
	 * A key may be multi-value.
	 * <p>
	 * First key is looked up in the 1st explicitly sorted column, second key -
	 * in the 2nd, etc.
	 * <p>
	 * A <code>null</code> key will result in the filter skipping the mentioned
	 * column.
	 * 
	 * @param key
	 *            Key object.
	 * @param exact
	 *            Whether the keys should be an exact match. Partial lookup done
	 *            otherwise.
	 * @return View entry collection. May be empty if no entries satisfy the
	 *         query.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntryCollection getAllEntriesByKey(List keys, boolean exact);

	/**
	 * Whether a column is a system column (i.e. not defined by view design).
	 * 
	 * @param name
	 *            Column name.
	 * @return Whether the column with a specific name is a system column.
	 * @since 0.4.0
	 */
	public boolean isSystemColumn(String name);

	/**
	 * Data type of a column.
	 * 
	 * @param name
	 *            Column name.
	 * @return Column data type.
	 * @since 0.4.0
	 */
	public int getColumnDataType(String name);

	/*
	 * @SuppressWarnings("rawtypes") public ViewEntry getFirstEntryByKey(String
	 * key, boolean exact);
	 * 
	 * @SuppressWarnings("rawtypes") public ViewEntry getFirstEntryByKey(List
	 * keys, boolean exact);
	 */
}
