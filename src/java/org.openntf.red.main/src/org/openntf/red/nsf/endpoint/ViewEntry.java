/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;

/**
 * Entity representing a view entry.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface ViewEntry<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends ViewEntryCollection<?, ?, ?>>
		extends HasProperties, ViewDescendant, Base<TE, TEF, TEP> {
	/**
	 * Returns the value of the column with a specified index.
	 * 
	 * @param idx
	 *            Column index.
	 * @return Column value. May be multi-value.
	 * @since 0.4.0
	 */
	public Object getColumnValue(int idx);

	/**
	 * Returns the value of the column with a specified symbolic name.
	 * 
	 * @param name
	 *            Column symbolic name.
	 * @return Column value. May be multi-value.
	 * @since 0.4.0
	 */
	public Object getColumnValue(String name);

	/**
	 * Returns all column values of the entry.
	 * 
	 * @return All column values.
	 * @since 0.4.0
	 */
	public List<Object> getColumnValues();

	/**
	 * Returns the entry index (in the view).
	 * 
	 * @return Entry index.
	 * @since 0.4.0
	 */
	public long getIndex();

	/**
	 * Returns the unique identifier of the document that this view entry
	 * represents.
	 * 
	 * @return Unique identifier of the document.
	 * @since 0.4.0
	 */
	public String getDocumentUNID();
}
