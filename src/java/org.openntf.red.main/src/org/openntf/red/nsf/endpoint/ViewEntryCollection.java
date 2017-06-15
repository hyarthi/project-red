/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Entity representing the view entry collection.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface ViewEntryCollection<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends View<?, ?, ?>>
		extends HasProperties, ViewDescendant, Base<TE, TEF, TEP> {
	/**
	 * Returns the first entry in the collection.
	 * 
	 * @return First entry in the collection. <code>NULL</code> if collection is
	 *         empty.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry getFirstEntry();

	/**
	 * Returns the entry following the given entry in the collection.
	 * 
	 * @param entry
	 *            Current entry.
	 * @return Next entry. <code>NULL</code> if the end of the collection has
	 *         been reached.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry getNextEntry(ViewEntry entry);

	/**
	 * Returns the entry before the current entry in the collection.
	 * 
	 * @param entry
	 *            Current entry.
	 * @return Previous entry. <code>NULL</code> if the beginning of the
	 *         collection has been reached.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry getPrevEntry(ViewEntry entry);

	/**
	 * Returns the last entry in the collection.
	 * 
	 * @return Last entry of the collection. <code>NULL</code> if the collection
	 *         is empty.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry getLastEntry();

	/**
	 * Returns the entry that is listed Nth in the collection.
	 * 
	 * @param n
	 *            Entry index.
	 * @return Entry. <code>NULL</code> if the collection is empty or the index
	 *         is out of bounds.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public ViewEntry getNthEntry(long n);
}
