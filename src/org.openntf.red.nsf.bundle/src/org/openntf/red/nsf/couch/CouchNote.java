/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.util.logging.Logger;

import org.openntf.red.nsf.couch.CouchField.SysNames;
import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.endpoint.Note;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchNote implements Note<CouchEndpoint, CouchEndpointFactory, CouchDatabase> {
	private ObjectNode raw;
	private CouchDatabase parent;
	private static Logger log = Logger.getLogger(CouchNote.class.getName());

	/**
	 * 
	 */
	CouchNote(ObjectNode _raw, CouchDatabase _parent) {
		raw = _raw;
		parent = _parent;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#setProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#removeProperty(java.lang.String)
	 */
	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#castTo(java.lang.Class)
	 */
	@Override
	public <T extends Base> T castTo(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#getField(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Field getField(String name) {
		if (raw.has(name)) {
			// FIXME also account for system fields (simpler)
			CouchField field = new CouchField((ObjectNode)raw.get(name), this);
			return field;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#setField(java.lang.String, org.openntf.red.nsf.endpoint.Field)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setField(String name, Field value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
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

}
