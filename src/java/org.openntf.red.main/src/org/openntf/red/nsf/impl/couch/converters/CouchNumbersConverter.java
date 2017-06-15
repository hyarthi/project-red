/**
 * 
 */
package org.openntf.red.nsf.impl.couch.converters;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.RawDataConverter;
import org.openntf.red.nsf.exceptions.ConverterException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import javolution.util.FastTable;

/**
 * Numbers converter for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see RawDataConverter
 */
public class CouchNumbersConverter extends RawDataConverter {

	/** Logger object. */
	private static Logger log = Logger.getLogger(CouchNumbersConverter.class.getName());
	/** JSON node factory (for JSON manipulation). */
	private JsonNodeFactory factory;

	/**
	 * Default constructor.
	 * 
	 * @param type
	 *            Data type code.
	 * @since 0.4.0
	 */
	public CouchNumbersConverter(int type) {
		super(type);
		factory = new JsonNodeFactory(true);
	}

	@Override
	public Object parseReadData(Object raw) throws ConverterException {
		// only accept JsonNode types
		if (!(raw instanceof JsonNode))
			throw new ConverterException(
					"Couch Number Converter: Unsupported data type - " + raw.getClass().getName() + ".");
		JsonNode node = (JsonNode) raw;
		if (node.isNull()) {
			return Integer.valueOf(0);
		} else {
			if (node.isNumber()) {
				// parse numbers
				Number n = toNumber(node);
				if (null == n)
					throw new ConverterException(
							"Couch Number Converter: Unsupported data type - " + node.getNodeType().toString() + ".");
				return n;
			} else if (node.isArray()) {
				// parse number arrays
				FastTable<Number> result = new FastTable<Number>();
				ArrayNode arr = (ArrayNode) node;
				Number n;
				for (JsonNode item : arr) {
					if (item.isNumber()) {
						n = toNumber(item);
						if (null == n)
							throw new ConverterException("Couch Number Converter: Unsupported data type - "
									+ item.getNodeType().toString() + ".");
						result.add(n);
					} else
						new ConverterException("Couch Number Converter: Unsupported data type - "
								+ item.getNodeType().toString() + ".");
				}
				return result;
			} else
				throw new ConverterException(
						"Couch Number Converter: Unsupported data type - " + node.getNodeType().toString() + ".");
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object parseWriteData(Object data) throws ConverterException {
		if (null == data)
			return factory.nullNode();
		if (data instanceof Number) {
			JsonNode node = toNode((Number) data);
			if (null == node)
				throw new ConverterException(
						"Couch Number Converter: Unsupported data type - " + data.getClass().getName() + ".");
			return node;
		}
		if (data instanceof FastTable) {
			FastTable coll = (FastTable) data;
			if (coll.isEmpty()) {
				return factory.nullNode();
			}
			if (coll.size() == 1) {
				Object o = coll.get(0);
				if (o instanceof Number) {
					JsonNode node = toNode((Number) o);
					if (null == node)
						throw new ConverterException(
								"Couch Number Converter: Unsupported data type - " + o.getClass().getName() + ".");
					return node;
				} else
					throw new ConverterException(
							"Couch Number Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			ArrayNode result = factory.arrayNode();
			JsonNode node;
			for (int i = 0; i < coll.size(); i++) {
				node = toNode((Number) coll.get(i));
				if (null == node)
					throw new ConverterException(
							"Couch Text Converter: Unsupported data type - " + coll.get(i).getClass().getName() + ".");
				result.add(node);
			}
			return result;
		}
		if (data instanceof Collection) {
			Collection coll = (Collection) data;
			if (coll.isEmpty())
				factory.nullNode();
			if (coll.size() == 1) {
				Object o = coll.iterator().next();
				if (o instanceof Number) {
					JsonNode node = toNode((Number) o);
					if (null == node)
						throw new ConverterException(
								"Couch Number Converter: Unsupported data type - " + o.getClass().getName() + ".");
					return node;
				} else
					throw new ConverterException(
							"Couch Text Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			ArrayNode result = factory.arrayNode();
			Iterator iterator = coll.iterator();
			JsonNode node;
			while (iterator.hasNext()) {
				Object o = iterator.next();
				if (o instanceof Number) {
					node = toNode((Number) o);
					if (null == node)
						throw new ConverterException(
								"Couch Number Converter: Unsupported data type - " + o.getClass().getName() + ".");
					result.add(node);
				} else
					throw new ConverterException(
							"Couch Text Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			return result;
		}

		throw new ConverterException(
				"Couch Text Converter: Unsupported data type - " + data.getClass().getName() + ".");
	}

	/**
	 * Casts JSON node to number.
	 * 
	 * @param node
	 *            JSON node to cast.
	 * @return Parsed data.
	 * @since 0.4.0
	 */
	private Number toNumber(JsonNode node) {
		if (node.isInt())
			return Integer.valueOf(node.asInt());
		if (node.isLong())
			return Long.valueOf(node.asLong());
		if (node.isFloat())
			return Float.valueOf(node.floatValue());
		if (node.isDouble())
			return Double.valueOf(node.asDouble());
		// TODO maybe add more value types?
		return null;
	}

	/**
	 * Casts a number to JSON node.
	 * 
	 * @param n
	 *            Number to cast.
	 * @return Resulting JSON node.
	 * @since 0.4.0
	 */
	private JsonNode toNode(Number n) {
		if (n instanceof Integer)
			return factory.numberNode((Integer) n);
		if (n instanceof Long)
			return factory.numberNode((Long) n);
		if (n instanceof Float)
			return factory.numberNode((Float) n);
		if (n instanceof Double)
			return factory.numberNode((Double) n);
		// TODO maybe add more value types?
		return null;
	}

}
