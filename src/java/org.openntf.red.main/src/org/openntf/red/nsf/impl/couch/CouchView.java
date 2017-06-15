/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.WebTarget;

import org.openntf.red.nsf.endpoint.Field.Type;
import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.endpoint.ViewEntry;
import org.openntf.red.nsf.endpoint.ViewEntryCollection;
import org.openntf.red.nsf.impl.couch.CouchDatabase.DbPaths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastTable;

/**
 * View implementation for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see View
 */
public class CouchView implements View<CouchEndpoint, CouchEndpointFactory, CouchDatabase> {

	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchView.class.getName());
	/** Web target for view design note. */
	private WebTarget designTarget;
	/** Web target for view query. */
	private WebTarget viewTarget;
	/** Raw design representation of the view design note. */
	private final ObjectNode rawdesign;
	/** Parent database. */
	private final CouchDatabase parent;
	/** View designs stored within the view design note. */
	private FastTable<ObjectNode> viewFacets;
	/** Object mapper (for JSON manipulation). */
	private ObjectMapper mapper;

	/**
	 * Default constructor.
	 * 
	 * @param target
	 *            View design note web target.
	 * @param _rawdesign
	 *            Raw representation of the view design note.
	 * @param _parent
	 *            Parent database
	 * @since 0.4.0
	 */
	CouchView(WebTarget target, ObjectNode _rawdesign, CouchDatabase _parent) {
		designTarget = target;
		rawdesign = _rawdesign;
		parent = _parent;
		// load default view facets
		viewFacets = new FastTable<ObjectNode>().atomic();
		if (rawdesign.has(Defaults.SORTINGS)) {
			ArrayNode facets = (ArrayNode) rawdesign.get(Defaults.SORTINGS);
			if (null != facets) {
				for (JsonNode node : facets) {
					if (node.isObject()) {
						viewFacets.add((ObjectNode) node);
					}
				}
			}
		}
		mapper = new ObjectMapper();
		// get view target
		viewTarget = parent.getTarget().path(DbPaths.VIEW_SEARCH);
		// .path(((ObjectNode)
		// rawdesign.get(Defaults.NAME)).get(Defaults.NAME_PROGRAMMATIC).asText());
		// TODO may require an additional branch for regular views (non-Mango)
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

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry removeEntry(long position) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setEntry(ViewEntry entry, long position) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addEntry(ViewEntry entry) {
		// TODO Auto-generated method stub

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

	/**
	 * CouchDB-specific view defaults.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Defaults {
		public static final String SORTINGS = "sortings";
		public static final String NAME = "name";
		public static final String COLUMNS = "columns";
		public static final String NAME_PROGRAMMATIC = "_prog";
		public static final String SELECTOR = "selector";
		public static final String FIELDS = "fields";
		public static final String COLUMN_NAME = "_name";
		public static final String COLUMN_TYPE = "_type";
		public static final String COLUMN_SORTED = "_sorted";
		public static final String COLUMN_SYSTEM = "_system";
		public static final String COLUMN_NAME_UNID = "_id";
	}

	/**
	 * List of Mango operators
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class MangoOperators {
		public static final String AND = "$and";
		public static final String NOT = "$not";
		public static final String EQUALS = "$eq";
		public static final String GREATER_THAN = "$gt";
		public static final String LESS_THAN = "$lt";
		public static final String REGEX = "$regex";
		public static final String EXISTS = "$exists";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		List<Object> keys = new FastTable<Object>();
		keys.add(key);
		return getAllEntriesByKey(keys, exact);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(List keys, boolean exact) {
		// TODO Auto-generated method stub
		ObjectNode sorting = viewFacets.get(0).deepCopy();
		ObjectNode filter = sorting.putObject(Defaults.SELECTOR);
		// ArrayNode columns = (ArrayNode) rawdesign.get(Defaults.COLUMNS);
		ArrayNode columns = (ArrayNode) rawdesign.get(Defaults.COLUMNS);
		ObjectNode columndef;
		if (null != keys)
			for (int i = 0, j = 0; i < keys.size() && j < columns.size(); i++) {
				// lookup next "sorted" column
				columndef = null;
				for (int k = j; k < columns.size(); k++) {
					columndef = (ObjectNode) columns.get(k);
					if (columndef.get(Defaults.COLUMN_SORTED).asBoolean(false)) {
						break;
					} else {
						columndef = null;
					}
				}
				if (null != columndef) {
					if (null != keys.get(i)) {
						Object key = keys.get(i);
						switch (columndef.get(Defaults.COLUMN_TYPE).asInt(-1)) {
						case (Type.TEXT):
							if (key instanceof String) {
								String skey = (String) key;
								ObjectNode node = filter.putObject(columndef.get(Defaults.COLUMN_NAME).asText());
								node.put(MangoOperators.EQUALS, skey);
								// TODO add REGEX lookup for exact = false;
							} else {
								// key is not consistent - need to return empty
								// collection
								setNullSelector(filter,
										((ObjectNode) columns.get(0)).get(Defaults.COLUMN_NAME).asText());
							}
							break;
						case (Type.NUMBERS):
							if (key instanceof Integer || key instanceof Long || key instanceof BigDecimal
									|| key instanceof Float || key instanceof Double) {
								ObjectNode node = filter.putObject(columndef.get(Defaults.COLUMN_NAME).asText());
								if (key instanceof Integer)
									node.put(MangoOperators.EQUALS, (Integer) key);
								else if (key instanceof Long)
									node.put(MangoOperators.EQUALS, (Long) key);
								else if (key instanceof Float)
									node.put(MangoOperators.EQUALS, (Float) key);
								else if (key instanceof Double)
									node.put(MangoOperators.EQUALS, (Double) key);
								if (key instanceof BigDecimal)
									node.put(MangoOperators.EQUALS, (BigDecimal) key);
							} else {
								// key is not consistent - need to return empty
								// collection
								setNullSelector(filter,
										((ObjectNode) columns.get(0)).get(Defaults.COLUMN_NAME).asText());
							}
							break;
						// TODO other data types
						default:
							setNullSelector(filter, ((ObjectNode) columns.get(0)).get(Defaults.COLUMN_NAME).asText());
							break;
						}
					}
				}
			}
		// if no keys are matched, nothing should be returned
		if (!filter.elements().hasNext())
			setNullSelector(filter, ((ObjectNode) columns.get(0)).get(Defaults.COLUMN_NAME).asText());

		return new CouchViewEntryCollection(viewTarget, sorting, this);
	}

	/**
	 * Add selection criteria guaranteed to return 0 entries.
	 * 
	 * @param selector
	 *            Selector to insert the criteria into.
	 * @param anyColumnName
	 *            Any column of the view.
	 * @since 0.4.0
	 */
	private void setNullSelector(ObjectNode selector, String anyColumnName) {
		ArrayNode lvl1 = selector.removeAll().putArray(MangoOperators.AND);
		ObjectNode lvl2 = lvl1.addObject();
		lvl2.put(MangoOperators.EXISTS, anyColumnName);
		lvl2 = lvl1.addObject();
		ObjectNode lvl3 = lvl2.putObject(MangoOperators.NOT);
		lvl3.put(MangoOperators.EXISTS, anyColumnName);
	}

	@Override
	public boolean isSystemColumn(String name) {
		ArrayNode columns = (ArrayNode) rawdesign.get(Defaults.COLUMNS);
		ObjectNode node;
		for (JsonNode column : columns) {
			node = (ObjectNode) column;
			if (node.get(Defaults.COLUMN_NAME).asText().equals(name))
				if (node.has(Defaults.COLUMN_SYSTEM))
					return node.get(Defaults.COLUMN_SYSTEM).asBoolean();
		}
		return false;
	}

	@Override
	public int getColumnDataType(String name) {
		ArrayNode columns = (ArrayNode) rawdesign.get(Defaults.COLUMNS);
		ObjectNode node;
		for (JsonNode column : columns) {
			node = (ObjectNode) column;
			if (node.get(Defaults.COLUMN_NAME).asText().equals(name))
				if (node.has(Defaults.COLUMN_TYPE))
					return node.get(Defaults.COLUMN_TYPE).asInt();
		}
		return -1;
	}

	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Override public ViewEntry getFirstEntryByKey(String key, boolean exact)
	 * { // TODO Auto-generated method stub return null; }
	 * 
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Override public ViewEntry getFirstEntryByKey(List keys, boolean exact) {
	 * // TODO Auto-generated method stub return null; }
	 */

}
