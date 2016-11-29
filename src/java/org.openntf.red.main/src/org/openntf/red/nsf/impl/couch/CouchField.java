/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.exceptions.EndpointException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastTable;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchField implements Field<CouchEndpoint, CouchEndpointFactory, CouchNote> {
	private ObjectNode raw;
	private CouchNote parent;
	private String name;
	private final static Logger log = Logger.getLogger(CouchField.class.getName());
	/**
	 * 
	 */
	CouchField(ObjectNode _raw, String _name, CouchNote _parent) {
		raw = _raw;
		name = _name;
		parent = _parent;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) {
		if (!raw.has(name))
			return null;
		JsonNode node = raw.get(name);
		if (node.isTextual())
			return node.asText();
		if (node.isInt())
			return node.asInt();
		if (node.isBoolean())
			return node.asBoolean();
		if (node.isBigInteger())
			return node.asLong();
		if (node.isBigDecimal() || node.isFloat() || node.isDouble())
			return node.asDouble();
		if (node.isBinary())
			try {
				return node.binaryValue();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		if (node.isArray()) {
			ArrayNode arr = ((ObjectNode) node).arrayNode();
			FastTable<Object> result = new FastTable<Object>();
			for (JsonNode nod : arr) {
				if (nod.isTextual())
					result.add(nod.asText());
				if (nod.isInt())
					result.add(nod.asInt());
				if (nod.isBoolean())
					result.add(nod.asBoolean());
				if (nod.isBigInteger())
					result.add(nod.asLong());
				if (nod.isBigDecimal() || nod.isFloat() || nod.isDouble())
					result.add(nod.asDouble());
				if (nod.isBinary())
					try {
						result.add(nod.binaryValue());
					} catch (IOException e) {
						e.printStackTrace();
						return null;
					}
			}
			return result;
		}
		if (node.isObject())
			return (ObjectNode) node;
		// FIXME consider other data types and/or parsing techniques
		return null;
	}

	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub
		if (value instanceof String) {
			raw.put(name, (String) value);
			return;
		}
		if (value instanceof Integer) {
			raw.put(name, (Integer) value);
			return;
		}
		if (value instanceof Long) {
			raw.put(name, (Long) value);
			return;
		}
		if (value instanceof Float) {
			raw.put(name, (Float) value);
			return;
		}
		if (value instanceof Double) {
			raw.put(name, (Double) value);
			return;
		}
		if (value instanceof BigDecimal) {
			raw.put(name, (BigDecimal) value);
			return;
		}
		if (value instanceof Byte) {
			raw.put(name, (Byte) value);
			return;
		}
		if (value instanceof Iterable) {
			Iterator<?> iterator = ((Iterable<?>) value).iterator();
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode arr = mapper.createArrayNode();
			Object val;
			while (iterator.hasNext()) {
				val = iterator.next();
				if (val instanceof String)
					arr.add((String) val);
				if (val instanceof Integer) 
					arr.add((Integer) val);
				if (val instanceof Long) 
					arr.add((Long) val);
				if (val instanceof Float) 
					arr.add((Float) val);
				if (val instanceof Double) 
					arr.add((Double) val);
				if (val instanceof BigDecimal) 
					arr.add((BigDecimal) val);
				if (val instanceof Byte) 
					arr.add((Byte) val);
			}
			//raw.put(name, arr);
			raw.set(name, arr);
			return;
		}
		if (value instanceof JsonNode) {
			//raw.put(name, (JsonNode) value);
			raw.set(name, (JsonNode) value);
		}
	}

	@Override
	public Object removeProperty(String name) {
		Object result = getProperty(name);
		raw.remove(name);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FastTable<Object> getValue() {
		int type = -1;
		if (raw.has(SysNames.SUB_TYPE))
			type = raw.get(SysNames.SUB_TYPE).asInt();
		if (type < 0) {
			if (raw.has(SysNames.SUB_VALUE))
				type = getAncestorFactory().closestTypeMatch(raw.get(SysNames.SUB_VALUE), 0);
			if (type < 0)
				return new FastTable<Object>();
		}
		if (raw.has(SysNames.SUB_VALUE)) {
			Object result = getAncestorFactory().parseReadData(raw.get(SysNames.SUB_VALUE), type);
			if (result instanceof FastTable)
				return (FastTable<Object>) result;
			else {
				FastTable<Object> res = new FastTable<Object>();
				res.add(result);
				return res;
			}
		} else
			return new FastTable<Object>();
	}

	@Override
	public void setValue(Object value) {
		setValue(value, true);
	}
	
	@Override
	public void setValue(Object value, boolean changeType) {
		int type = -1;
		if (!changeType)
			if (raw.has(SysNames.SUB_TYPE))
				type = raw.get(SysNames.SUB_TYPE).asInt();
		if (type < 0)
			type = getAncestorFactory().closestTypeMatch(value, 0);

		Object result = getAncestorFactory().parseWriteData(value, type);
		if (result instanceof JsonNode) {
			JsonNode node = (JsonNode) result;
			raw.put(SysNames.SUB_TYPE, type);
			raw.set(SysNames.SUB_VALUE, node);
			//raw.put(SysNames.SUB_VALUE, node);
		} else
			throw new EndpointException("Couch Endpoint Converter produced an unsupported result type - " + result.getClass().getName() + ".");
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
	public CouchNote getParent() {
		return parent;
	}
	
	@Override
	public int getType() {
		if (raw.has(SysNames.SUB_TYPE))
			return raw.get(SysNames.SUB_TYPE).asInt();
		
		return Type.UNKNOWN;
	}

	@Override
	public void setType(int type) {
		raw.put(SysNames.SUB_TYPE, type);
	}
	
	public static class SysNames {
		public static final String FIELD_UNID = "_id";
		public static final String FIELD_REVISION = "_rev";
		public static final String FIELD_VALUE = "value";
		public static final String FIELD_KEY = "key";
		public static final String FIELD_NOTEID = "RED_noteid";
		
		public static final String SUB_TYPE = "_type";
		public static final String SUB_VALUE = "_value";
	}

	@Override
	public String getName() {
		return name;
	}

}
