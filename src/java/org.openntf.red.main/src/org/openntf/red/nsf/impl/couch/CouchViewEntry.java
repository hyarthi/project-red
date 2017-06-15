/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.util.List;
import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.endpoint.ViewEntry;
import org.openntf.red.nsf.impl.couch.CouchView.Defaults;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * View entry implementation for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see ViewEntry
 */
public class CouchViewEntry implements ViewEntry<CouchEndpoint, CouchEndpointFactory, CouchViewEntryCollection> {

	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchViewEntry.class.getName());
	/** Raw entry representation (JSON wrapped in Jackson). */
	private ObjectNode rawentry;
	/** View entry index (within the collection). */
	private long idx;
	/** Parent view entry collection. */
	private CouchViewEntryCollection parent;

	/**
	 * Default constructor.
	 * 
	 * @param _rawentry
	 *            Raw representation of the entry.
	 * @param index
	 *            View entry index.
	 * @param _parent
	 *            Parent view entry collection.
	 * @since 0.4.0
	 */
	CouchViewEntry(ObjectNode _rawentry, long index, CouchViewEntryCollection _parent) {
		rawentry = _rawentry;
		idx = index;
		parent = _parent;
	}

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
	public Object getColumnValue(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

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
