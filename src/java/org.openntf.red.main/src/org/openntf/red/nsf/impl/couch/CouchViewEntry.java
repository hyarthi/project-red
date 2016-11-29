/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.util.List;
import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.Note;
import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.endpoint.ViewEntry;
import org.openntf.red.nsf.impl.couch.CouchField.SysNames;
import org.openntf.red.nsf.impl.couch.CouchView.Defaults;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastTable;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchViewEntry implements ViewEntry<CouchEndpoint, CouchEndpointFactory, CouchViewEntryCollection> {
	
	private static Logger log = Logger.getLogger(CouchViewEntry.class.getName());
	
	private ObjectNode rawentry;
	private long idx;
	private CouchViewEntryCollection parent;

	/**
	 * 
	 */
	CouchViewEntry(ObjectNode _rawentry, long index, CouchViewEntryCollection _parent) {
		rawentry = _rawentry;
		idx = index;
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
	 * @see org.openntf.red.nsf.endpoint.ViewEntry#getColumn(int)
	 */
	@Override
	public Object getColumnValue(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.ViewEntry#getColumn(java.lang.String)
	 */
	@Override
	public Object getColumnValue(String name) {
		if (!rawentry.has(name))
			return null;
		
		int type = getAncestorView().getColumnDataType(name);
		JsonNode node = rawentry.get(name);
		if (type < 0) {
			type = getAncestorFactory().closestTypeMatch(node, 0);
			if (type < 0)
				return null;
		}
		Object result = getAncestorFactory().parseReadData(node, type);
		return result;
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
	public CouchViewEntryCollection getParent() {
		return parent;
	}

	@Override
	public long getIndex() {
		return idx;
	}

	@Override
	public List<Object> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getAncestorView() {
		return parent.getAncestorView();
	}

	@Override
	public String getDocumentUNID() {
		return (String) getColumnValue(Defaults.COLUMN_NAME_UNID);
	}

}
