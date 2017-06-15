/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openntf.red.nsf.DataBrokerException;
import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.endpoint.Field.Flags;
import org.openntf.red.nsf.endpoint.Field.Type;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.exceptions.ConverterException;
import org.openntf.red.nsf.impl.couch.CouchEndpointFactory.DefaultResponseFields;
import org.openntf.red.nsf.impl.couch.CouchField.SysNames;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastMap;
import javolution.util.FastSet;
import javolution.util.FastTable;
import lotus.domino.Base;

/**
 * Note implementation for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see Note
 */
public class CouchNote implements Note<CouchEndpoint, CouchEndpointFactory, CouchDatabase> {
	/** Note raw representation (JSON wrapped in Jackson). */
	private ObjectNode raw;
	/** Parent database. */
	private CouchDatabase parent;
	/** Note web target (Java RS). */
	private WebTarget target;
	// private boolean newDoc; // TODO not sure if this is needed
	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchNote.class.getName());

	/**
	 * Default constructor.
	 * 
	 * @param _target
	 *            Note web target.
	 * @param _raw
	 *            Note raw representation.
	 * @param _parent
	 *            Parent database.
	 * @since 0.4.0
	 */
	CouchNote(WebTarget _target, ObjectNode _raw, CouchDatabase _parent) {
		target = _target;
		raw = _raw;
		parent = _parent;
		// newDoc = false;
	}

	/*
	 * CouchNote(WebTarget _target, ObjectNode _raw, CouchDatabase _parent,
	 * boolean _new) { target = _target; raw = _raw; parent = _parent; //newDoc
	 * = _new; }
	 */

	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Base> T castTo(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field getField(String name) {
		if (raw.has(name)) {
			// FIXME also account for system fields (simpler)
			CouchField field = new CouchField((ObjectNode) raw.get(name), name, this);
			return field;
		}

		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setField(String name, Field value) {
		if (isSystemField(name))
			return;
		ObjectNode rawfield = raw.putObject(name);
		Object fieldValue = value.getValue();
		int type = value.getType();
		Set<Flags> flags = value.getFlags();
		if (type < 0)
			type = getAncestorFactory().closestTypeMatch(fieldValue, 0);
		if (type < 0)
			throw new ConverterException("Unsupported data type: " + fieldValue.getClass().getName());
		rawfield.put(SysNames.SUB_TYPE, type);
		long lflags = 0;
		if (null != flags) {
			for (Flags flag : flags) {
				lflags = lflags | flag.code();
			}
		}
		rawfield.put(SysNames.SUB_FLAGS, lflags);
		rawfield.set(SysNames.SUB_VALUE, (JsonNode) getAncestorFactory().parseWriteData(fieldValue, type));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field removeField(String name) {
		if (!raw.has(name))
			return null;

		ObjectNode rawfield = (ObjectNode) raw.get(name).deepCopy();
		raw.remove(name);

		return new CouchField(rawfield, name, this);
	}

	@Override
	public CouchEndpointFactory getAncestorFactory() {
		return parent.getAncestorFactory();
	}

	@Override
	public CouchEndpoint getAncestorEndpoint() {
		return parent.getAncestorEndpoint();
	}

	@Override
	public CouchDatabase getParent() {
		return parent;
	}

	@Override
	public String getUniversalID() {
		if (raw.has(SysNames.FIELD_UNID))
			return raw.get(SysNames.FIELD_UNID).asText();
		return null;
	}

	@Override
	public List<String> getAllFieldNames() {
		Iterator<String> ifield = raw.fieldNames();
		FastTable<String> fieldList = new FastTable<String>();
		String fieldName;

		while (ifield.hasNext()) {
			fieldName = ifield.next();
			if (!isSystemField(fieldName))
				fieldList.add(fieldName);
		}

		return fieldList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Field> getFieldsAsMap() {
		FastMap<String, Field> fields = new FastMap<String, Field>();
		Iterator<String> ifield = raw.fieldNames();
		String fieldName;

		while (ifield.hasNext()) {
			fieldName = ifield.next();
			if (!isSystemField(fieldName)) {
				fields.put(fieldName, this.getField(fieldName));
			}
		}

		return fields;
	}

	/**
	 * Checks if the field specified is a system field
	 * 
	 * @param name
	 *            Field name.
	 * @return Whether the field is a system field.
	 * @since 0.4.0
	 */
	protected boolean isSystemField(String name) {
		// FIXME improve the algorithm
		if (name.equals(SysNames.FIELD_UNID) || name.equals(SysNames.FIELD_REVISION)
				|| name.equals(SysNames.FIELD_VALUE) || name.equals(SysNames.FIELD_KEY)
				|| name.equals(SysNames.FIELD_NOTEID))
			return true;
		return false;
	}

	@Override
	public Set<String> keySet() {
		FastSet<String> fieldNames = new FastSet<String>();
		Iterator<String> ifield = raw.fieldNames();

		while (ifield.hasNext()) {
			fieldNames.add(ifield.next());
		}
		fieldNames.remove(SysNames.FIELD_UNID);
		fieldNames.remove(SysNames.FIELD_REVISION);
		fieldNames.remove(SysNames.FIELD_VALUE);
		fieldNames.remove(SysNames.FIELD_KEY);
		fieldNames.remove(SysNames.FIELD_NOTEID);

		return fieldNames;
	}

	@Override
	public void setFieldValue(String name, Object value) {
		if (isSystemField(name))
			return;
		if (raw.has(name)) {
			ObjectNode rawfield = (ObjectNode) raw.get(name);
			int oldtype = -1;
			if (rawfield.has(SysNames.SUB_TYPE))
				oldtype = rawfield.get(SysNames.SUB_TYPE).asInt();
			if (oldtype < 0) {
				int type = getAncestorFactory().closestTypeMatch(value, 0);
				if (type < 0)
					throw new ConverterException("Unsupported data type: " + value.getClass().getName());
				else {
					rawfield.put(SysNames.SUB_TYPE, type);
					rawfield.set(SysNames.SUB_VALUE, (JsonNode) getAncestorFactory().parseWriteData(value, type));
				}
			} else
				rawfield.set(SysNames.SUB_VALUE, (JsonNode) getAncestorFactory().parseWriteData(value, oldtype));
		} else
			createField(name, value);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name) {
		return createField(name, Type.TEXT, null, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, int type) {
		return createField(name, type, null, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, int type, List<Flags> flags) {
		return createField(name, type, flags, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, int type, List<Flags> flags, Object value) {
		long lflags = 0;
		if (null != flags) {
			for (Flags flag : flags) {
				lflags = lflags | flag.code();
			}
		}
		return createField(name, type, lflags, value);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, int type, long flags, Object value) {
		if (isSystemField(name))
			return null; // TODO probably better to throw an exception
		ObjectNode rawfield = raw.putObject(name);
		rawfield.put(SysNames.SUB_TYPE, type);

		rawfield.put(SysNames.SUB_FLAGS, flags);
		if (null == value) {
			// TODO default null value here
			rawfield.putNull(SysNames.SUB_VALUE);
		} else {
			rawfield.set(SysNames.SUB_VALUE, (JsonNode) getAncestorFactory().parseWriteData(value, type));
		}
		return new CouchField(rawfield, name, this);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, int type, Object value) {
		return createField(name, type, null, value);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Field createField(String name, Object value) {
		int type = getAncestorFactory().closestTypeMatch(value, 0);
		if (type < 0)
			throw new ConverterException("Unsupported data type: " + value.getClass().getName());

		return createField(name, type, null, value);
	}

	@Override
	public boolean updateNote() {
		return updateNote(true);
	}

	@Override
	public boolean updateNote(boolean forceUpdate) {
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.put(Entity.entity(raw.toString(), MediaType.APPLICATION_JSON_TYPE));
		ObjectNode respTree = null;
		try {
			respTree = (ObjectNode) parent.getMapper().readTree(response.readEntity(String.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respTree = parent.getMapper().createObjectNode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respTree = parent.getMapper().createObjectNode();
		}
		log.finest("Is status success? " + CouchUtil.isStatusSuccess(response.getStatus()));
		if (!CouchUtil.isStatusSuccess(response.getStatus())) {
			// check if it's a conflict
			if (respTree.has(DefaultResponseFields.ERROR)) {
				if (respTree.get(DefaultResponseFields.ERROR).asText()
						.equals(DefaultResponseFields.ERROR_VALUE_CONFLICT)) {
					// if it's a new note - it's a unid clash -> need to get a
					// new unid to save
					if (isNewNote()) {
						String unid = getAncestorEndpoint().generateUniversalID();
						if (null == unid)
							throw new DataBrokerException("Failed to update note: Failed to generate a new UNID.");
						raw.put(SysNames.FIELD_UNID, unid);
						target = parent.getTarget().path(unid);
						// attempt to save again
						response = target.request(MediaType.APPLICATION_JSON_TYPE)
								.put(Entity.entity(raw.toString(), MediaType.APPLICATION_JSON_TYPE));
						// response =
						// parent.getTarget().request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(raw.toString(),
						// MediaType.APPLICATION_JSON_TYPE));
						try {
							respTree = (ObjectNode) parent.getMapper().readTree(response.readEntity(String.class));
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						}
						if (!CouchUtil.isStatusSuccess(response.getStatus()))
							throw new DataBrokerException("Failed to update note: Status code - " + response.getStatus()
									+ ", Response body: [" + respTree.toString() + "]");
						if (respTree.has(DefaultResponseFields.REVISION)) {
							// substitute revision value
							raw.put(SysNames.FIELD_REVISION, respTree.get(DefaultResponseFields.REVISION).asText());
							// done
							return true;
						}
					} else
					// it's a conflict -> check if we're forcing an update
					if (forceUpdate) {
						// if forcing an update -> get the current revision code
						response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
						if (response.getStatus() != Response.Status.OK.getStatusCode())
							// document has been deleted
							throw new DataBrokerException("Failed to update note: Document has been deleted. UNID: "
									+ raw.get(SysNames.FIELD_UNID).asText());
						response = target.request(MediaType.APPLICATION_JSON_TYPE)
								.post(Entity.entity(raw.toString(), MediaType.APPLICATION_JSON_TYPE));
						try {
							respTree = (ObjectNode) parent.getMapper().readTree(response.readEntity(String.class));
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						}
						if (respTree.has(SysNames.FIELD_REVISION))
							raw.put(SysNames.FIELD_REVISION, respTree.get(SysNames.FIELD_REVISION).asText());
						else
							throw new DataBrokerException(
									"Failed to update note: Failed to locate revision/sequence number.");
						// attempt to save again
						response = target.request(MediaType.APPLICATION_JSON_TYPE)
								.post(Entity.entity(raw.toString(), MediaType.APPLICATION_JSON_TYPE));
						try {
							respTree = (ObjectNode) parent.getMapper().readTree(response.readEntity(String.class));
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							respTree = parent.getMapper().createObjectNode();
						}
						if (!CouchUtil.isStatusSuccess(response.getStatus()))
							throw new DataBrokerException("Failed to update note: Status code - " + response.getStatus()
									+ ", Response body: [" + respTree.toString() + "]");
						if (respTree.has(DefaultResponseFields.REVISION)) {
							// substitute new revision value
							raw.put(SysNames.FIELD_REVISION, respTree.get(DefaultResponseFields.REVISION).asText());
							// done
							return true;
						}
					} else {
						// not forcing an update -> stop attempting
						return false;
					}
				} else
					throw new DataBrokerException("Failed to update note: Status code - " + response.getStatus()
							+ ", Response body: [" + respTree.toString() + "]");
			} else
				throw new DataBrokerException("Failed to update note: Status code - " + response.getStatus()
						+ ", Response body: [" + respTree.toString() + "]");
			// TODO handle other options?
		} else {
			// save successful
			if (respTree.has(DefaultResponseFields.REVISION)) {
				// substitute new revision value
				raw.put(SysNames.FIELD_REVISION, respTree.get(DefaultResponseFields.REVISION).asText());
				// done
				return true;
			}
		}
		// FIXME maybe roll the operation back?
		return false;
	}

	@Override
	public boolean deleteNote() {
		return deleteNote(true);
	}

	@Override
	public boolean deleteNote(boolean hardDelete) {
		if (hardDelete) {
			log.finest("Hard-deleting a document.");
			String revision = raw.get(SysNames.FIELD_REVISION).asText();
			log.finest("Deleting revision: " + revision);
			// TODO fix the hard-coded string
			Response response = target.queryParam("rev", revision).request(MediaType.APPLICATION_JSON_TYPE).delete();
			ObjectNode respTree = null;
			if (CouchUtil.isStatusSuccess(response.getStatus())) {
				return true;
			} else {
				try {
					respTree = (ObjectNode) parent.getMapper().readTree(response.readEntity(String.class));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					respTree = parent.getMapper().createObjectNode();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					respTree = parent.getMapper().createObjectNode();
				}
				throw new DataBrokerException("Failed to delete note: Status code - " + response.getStatus()
						+ ", Response body: [" + respTree.toString() + "]");
			}
		} else {
			// TODO do soft delete option
			return false;
		}
	}

	@Override
	public boolean reloadNote() {
		return reloadNote(true);
	}

	@Override
	public boolean reloadNote(boolean discardChanges) {
		// can not reload a new note - it's not saved yet
		if (isNewNote())
			return false;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNewNote() {
		// only new notes don't have the revision field
		return !raw.has(SysNames.FIELD_REVISION);
	}

	@Override
	public boolean isDesignNote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getNoteID() {
		if (raw.has(SysNames.FIELD_NOTEID))
			return raw.get(SysNames.FIELD_NOTEID).asLong();
		else
			return 0;
	}

	@Override
	public void setUniversalID(String unid) {
		raw.put(SysNames.FIELD_UNID, unid);
	}

	@Override
	public void setNoteID(long id) {
		raw.put(SysNames.FIELD_NOTEID, id);
	}

	@Override
	public String getSequenceNum() {
		if (raw.has(SysNames.FIELD_REVISION))
			return raw.get(SysNames.FIELD_REVISION).asText();
		return null;
	}

	@Override
	public void setSequenceNum(String seqNum) {
		raw.put(SysNames.FIELD_REVISION, seqNum);
	}

	@Override
	public void recycle() {
		// TODO is this needed?
		raw.removeAll();
		raw = null;
		target = null;
		parent = null;
	}
}
