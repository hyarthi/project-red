/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import org.openntf.red.nsf.exceptions.EndpointException;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Endpoint<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends EndpointFactory> extends Base<TE, TEF, TEP> {
	/**
	 * Get
	 * 
	 * @param session
	 * @param dbpath
	 * @param createOnFail
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Database getDatabase(String dbpath, boolean createOnFail) throws EndpointException;
	/**
	 * 
	 * @param db
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean openDatabase(Database db) throws EndpointException;
	/**
	 * 
	 * @param session
	 * @param server
	 * @param dbpath
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Database createDatabase(String server, String dbpath) throws EndpointException;
	/**
	 * 
	 * @param session
	 * @param server
	 * @param dbpath
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Database createDatabase(DbOptions options) throws EndpointException;
	/**
	 * 
	 * @param db
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean updateDatabase(Database db, DbOptions options) throws EndpointException;
	/**
	 * 
	 * @param db
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean removeDatabase(Database db) throws EndpointException;
	/**
	 * 
	 * @param unid
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Note getNote(Database db, String unid) throws EndpointException;
	/**
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean createNote(Note note) throws EndpointException;
	/**
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean updateNote(Note note) throws EndpointException;
	/**
	 * 
	 * @param note
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean removeNote(Note note) throws EndpointException;
	/**
	 * 
	 * @param unid
	 * @return
	 */
	public boolean removeNote(String unid) throws EndpointException;
	
	public void recycle();
	
}
