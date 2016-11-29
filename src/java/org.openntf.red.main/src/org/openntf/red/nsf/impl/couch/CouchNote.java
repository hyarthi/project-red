/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.client.WebTarget;

import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.impl.couch.CouchField.SysNames;

import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastMap;
import javolution.util.FastSet;
import javolution.util.FastTable;
import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchNote implements Note<CouchEndpoint, CouchEndpointFactory, CouchDatabase> {
	private ObjectNode raw;
	private CouchDatabase parent;
	private WebTarget target;
	private static Logger log = Logger.getLogger(CouchNote.class.getName());

	/**
	 * 
	 */
	CouchNote(WebTarget _target, ObjectNode _raw, CouchDatabase _parent) {
		target = _target;
		raw = _raw;
		parent = _parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.HasProperties#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.HasProperties#setProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.HasProperties#removeProperty(java.lang.
	 * String)
	 */
	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Note#castTo(java.lang.Class)
	 */
	@Override
	public <T extends Base> T castTo(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Note#getField(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Note#setField(java.lang.String,
	 * org.openntf.red.nsf.endpoint.Field)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setField(String name, Field value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.Note#removeField(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Field removeField(String name) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

	protected boolean isSystemField(String name) {
		if (name.equals(SysNames.FIELD_UNID) || name.equals(SysNames.FIELD_REVISION)
				|| name.equals(SysNames.FIELD_VALUE) || name.equals(SysNames.FIELD_KEY) || name.equals(SysNames.FIELD_NOTEID))
			return true;
		return false;
	}

	@Override
	public Set<String> keySet() {
		FastSet<String> fieldNames = new FastSet<String>();
		Iterator<String> ifield = raw.fieldNames();
		
		while(ifield.hasNext()) {
			fieldNames.add(ifield.next());
		}
		fieldNames.remove(SysNames.FIELD_UNID);
		fieldNames.remove(SysNames.FIELD_REVISION);
		fieldNames.remove(SysNames.FIELD_VALUE);
		fieldNames.remove(SysNames.FIELD_KEY);
		
		return fieldNames;
	}

}
