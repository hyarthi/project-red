/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openntf.red.nsf.endpoint.Field.Flags;

/**
 * Entity representing a note in the database.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface Note<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Database<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {
	/**
	 * (Under consideration)
	 * 
	 * @param type
	 * @return
	 */
	public <T extends lotus.domino.Base> T castTo(Class<T> type) throws ClassCastException;

	/**
	 * Returns a field given it's name.
	 * 
	 * @param name
	 *            Field name.
	 * @return Field with a specified name. <code>NULL</code> if the field does
	 *         not exist.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field getField(String name);

	/**
	 * Creates/Replaces a field of the specified name.
	 * 
	 * @param name
	 *            Field name.
	 * @param value
	 *            New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public void setField(String name, Field value);

	/**
	 * Removes a field from the note.
	 * 
	 * @param name
	 *            Field name.
	 * @return Field object that was removed (if any).
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field removeField(String name);

	/**
	 * Return the note's unique identifier.
	 * 
	 * @return Note's unique identifier.
	 * @since 0.4.0
	 */
	public String getUniversalID();

	/**
	 * Sets the note's unique identifier.
	 * <p>
	 * Does NOT create a new note.
	 * <p>
	 * Restricted operation.
	 * 
	 * @param unid
	 *            New unique identifier of the note.
	 * @since 0.4.0
	 */
	public void setUniversalID(String unid);

	/**
	 * Returns a list of all field names that are present within the note.
	 * 
	 * @return List of all field names.
	 * @since 0.4.0
	 */
	public List<String> getAllFieldNames();

	/**
	 * Returns all fields and respective field objects in the form of a Map.
	 * 
	 * @return Map with all field names and values.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Field> getFieldsAsMap();

	/**
	 * Returns the names of all field names of a note. Intend to implement Map
	 * interface.
	 * 
	 * @return list of all field names.
	 * @since 0.4.0
	 */
	public Set<String> keySet();

	/**
	 * Sets the value of a field without changing it's type.
	 * 
	 * @param name
	 *            Field name to set.
	 * @param value
	 *            New field value.
	 * @since 0.4.0
	 */
	public void setFieldValue(String name, Object value);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists.
	 * 
	 * @param name
	 *            New field name.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists.
	 * 
	 * @param name
	 *            New field name.
	 * @param type
	 *            New field type
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, int type);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists.
	 * 
	 * @param name
	 *            New field name.
	 * @param type
	 *            New field type
	 * @param flags
	 *            New field flags.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, int type, List<Flags> flags);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists. Then sets the field value.
	 * 
	 * @param name
	 *            New field name.
	 * @param type
	 *            New field type
	 * @param flags
	 *            New field flags.
	 * @param value
	 *            New field value.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, int type, List<Flags> flags, Object value);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists. Then sets the field value.
	 * 
	 * @param name
	 *            New field name.
	 * @param type
	 *            New field type
	 * @param flags
	 *            New field flags.
	 * @param value
	 *            New field value.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, int type, long flags, Object value);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists.
	 * 
	 * @param name
	 *            New field name.
	 * @param type
	 *            New field type
	 * @param flags
	 *            New field flags.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, int type, Object value);

	/**
	 * Creates a field with a specified name. Removes the old field if it
	 * exists. Then sets the field value. The field type is inferred from the
	 * value type.
	 * 
	 * @param name
	 *            New field name.
	 * @param value
	 *            New field value.
	 * @return New field object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Field createField(String name, Object value);

	/**
	 * Updates the note in the back-end database.
	 * 
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean updateNote();

	/**
	 * Updates the note in the back-end database.
	 * 
	 * @param forceUpdate
	 *            Whether the update should be forced (ignore conflicts).
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean updateNote(boolean forceUpdate);

	/**
	 * Deletes a note in the back-end database.
	 * 
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean deleteNote();

	/**
	 * Deletes a note in the back-end database.
	 * 
	 * @param hardDelete
	 *            Whether to perform a hard delete (<code>true</code>) or soft
	 *            delete (<code>false</code>).
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean deleteNote(boolean hardDelete);

	/**
	 * Refresh the note data from the database.
	 * 
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean reloadNote();

	/**
	 * Refresh the note data from the database.
	 * 
	 * @param discardChanges
	 *            Whether the unsaved changes made by user should be discarded
	 *            (<code>true</code>) or re-applied to the note
	 *            (<code>false</code>).
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	public boolean reloadNote(boolean discardChanges);

	/**
	 * (Under consideration)
	 * 
	 * @return
	 */
	// TODO not sure if this is needed
	public boolean isNewNote();

	/**
	 * (Under consideration)
	 * 
	 * @return
	 */
	// TODO not sure if this is needed
	public boolean isDesignNote();

	/**
	 * Get Note ID of the document (required for backward-compatibility with
	 * Notes/Domino).
	 * 
	 * @return Note ID of the document.
	 * @since 0.4.0
	 */
	public long getNoteID();

	/**
	 * Set Note ID of the document (required for backward-compatibility with
	 * Notes/Domino).
	 * <p>
	 * Restricted operation.
	 * 
	 * @param id
	 *            New Note ID of the document.
	 * @since 0.4.0
	 */
	public void setNoteID(long id);

	/**
	 * Get the sequence number of the document (required for
	 * backward-compatibility with Notes/Domino).
	 * 
	 * @return Sequence number of the document.
	 * @since 0.4.0
	 */
	public String getSequenceNum();

	/**
	 * Set the sequence numbet of the document (required for
	 * backward-compatibility with Notes/Domino).
	 * <p>
	 * Restricted operation.
	 * 
	 * @param seqNum
	 *            New sequence number of the document.
	 * @since 0.4.0
	 */
	public void setSequenceNum(String seqNum);

	/**
	 * (Under consideration)
	 */
	public void recycle();
}
