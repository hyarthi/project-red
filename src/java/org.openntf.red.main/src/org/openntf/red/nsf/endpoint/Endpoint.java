/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import org.openntf.red.nsf.exceptions.EndpointException;

/**
 * Entity representing an endpoint for data query.
 * <p>
 * An endpoint represents a specific data source (DBMS) that the current server
 * may access for data. An endpoint may contain one or more databases.
 * <p>
 * Endpoints may be local and remote. Remote endpoints (other RED/Domino
 * servers) may be accessed via NRPC/RRPC, while local endpoints may be accessed
 * in varying manner.
 * <p>
 * An endpoint is considered local if the server accesses the DBMS directly,
 * while a remote endpoint implies that we're accessing a RED/Domino server to
 * get the data.
 * <p>
 * A server may have multiple local endpoints registered. The multiple-endpoint
 * management mechanism is being worked on.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface Endpoint<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends EndpointFactory>
		extends Base<TE, TEF, TEP> {
	/**
	 * Returns the database from this endpoint given it's path (or unique
	 * identifier - e.g. replica id).
	 * <p>
	 * May create a database if no database was found.
	 * 
	 * @param dbpath
	 *            Database path (or unique identifier)
	 * @param createOnFail
	 *            Whether the database should be created if no such database is
	 *            found within the endpoint.
	 * @return Database object
	 * @throws EndpointException
	 *             If no database is found and we're not creating one, or if any
	 *             other error happens.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Database getDatabase(String dbpath, boolean createOnFail) throws EndpointException;

	/**
	 * Tries to re-establish connection to the database and re-open it.
	 * 
	 * @param db
	 *            The database to reconnect to.
	 * @return Database object
	 * @throws EndpointException
	 *             If the database could not be accessed for any reason.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public boolean openDatabase(Database db) throws EndpointException;

	/**
	 * Creates a database within an endpoint.
	 * 
	 * @param server
	 *            Server name to create a database on (ignored for local
	 *            endpoints)
	 * @param dbpath
	 *            Database path
	 * @return Database object
	 * @throws EndpointException
	 *             If any error occurs.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Database createDatabase(String server, String dbpath) throws EndpointException;

	/**
	 * Creates a database within an endpoint.
	 * 
	 * @param options
	 *            Options to create the database with.
	 * @return Database object
	 * @since 0.4.0
	 * @see DbOptions
	 * @throws EndpointException
	 *             If any error occurs.
	 */
	@SuppressWarnings("rawtypes")
	public Database createDatabase(DbOptions options) throws EndpointException;

	/**
	 * Updates the properties of the database.
	 * 
	 * @param db
	 *            Database object
	 * @param options
	 *            Database options to update.
	 * @return Whether the update was successful.
	 * @since 0.4.0
	 * @throws EndpointException
	 *             If any error occurs.
	 */
	@SuppressWarnings("rawtypes")
	public boolean updateDatabase(Database db, DbOptions options) throws EndpointException;

	/**
	 * Deletes a database within an endpoint.
	 * 
	 * @param db
	 *            Database object.
	 * @return Whether the operation was successful.
	 * @throws EndpointException
	 *             If any error occurs.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public boolean removeDatabase(Database db) throws EndpointException;

	/**
	 * (Deprecated)
	 * 
	 * @param unid
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Note getNote(Database db, String unid) throws EndpointException;

	/**
	 * (Deprecated)
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean createNote(Note note) throws EndpointException;

	/**
	 * (Deprecated)
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean updateNote(Note note) throws EndpointException;

	/**
	 * (Deprecated)
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean removeNote(Note note) throws EndpointException;

	/**
	 * (Deprecated)
	 * 
	 * @param unid
	 * @return
	 */
	public boolean removeNote(String unid) throws EndpointException;

	/**
	 * Generates a unique identifier for a note.
	 * 
	 * @return Unique identifier.
	 * @since 0.4.0
	 */
	public String generateUniversalID();

	/**
	 * (Under consideration)
	 */
	public void recycle();

}
