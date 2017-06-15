/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Entity representing a database within an endpoint.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface Database<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Endpoint<?, ?, ?>>
		extends Base<TE, TEF, TEP> {
	/**
	 * Returns a note from a database given it's UNID.
	 * 
	 * @param unid
	 *            Note's unique identifier.
	 * @return Note object. <code>NULL</code> if the note does not exist.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Note getNoteByUNID(String unid);

	/**
	 * Returns a view object from a database given it's symbolic name.
	 * 
	 * @param name
	 *            View's symbolic name.
	 * @return View object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public View getView(String name);

	/**
	 * Returns a special view representing an ID table equivalent of
	 * Notes/Domino from a database.
	 * 
	 * @return View representing the ID table.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public View getIDTableView();

	/**
	 * Creates a note object within a database and returns a handle to it.
	 * <p>
	 * The object is written into the back-end only when a save operation is
	 * invoked on it.
	 * 
	 * @return The newly created note object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Note createNote();

	/**
	 * Creates a note object within a database and returns a handle to it.
	 * <p>
	 * The object is written into the back-end only when a save operation is
	 * invoked on it.
	 * 
	 * @param isDesign
	 *            whether the note creates should be a design document or a data
	 *            document.
	 * @return The newly created note object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Note createNote(boolean isDesign);
}
