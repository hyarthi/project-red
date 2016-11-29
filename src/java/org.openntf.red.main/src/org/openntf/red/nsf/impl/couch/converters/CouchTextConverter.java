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
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
//import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastTable;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchTextConverter extends RawDataConverter {
	
	private static Logger log = Logger.getLogger(CouchTextConverter.class.getName());

	/**
	 * @param type
	 */
	public CouchTextConverter(int type) {
		super(type);
	}

	@Override
	public Object parseReadData(Object raw) throws ConverterException {
		// only accept JsonNode types
		if (!(raw instanceof JsonNode))
			throw new ConverterException("Couch Text Converter: Unsupported data type - " + raw.getClass().getName() + ".");
		JsonNode node = (JsonNode) raw;
		if (node.isNull()) {
			return "";
		} else {
			if (node.isTextual()) {
				return node.asText();
			} else if (node.isArray()) {
				FastTable<String> result = new FastTable<String>();
				ArrayNode arr = (ArrayNode) node;//((ObjectNode) node).arrayNode();
				for (JsonNode item : arr) {
					if (item.isTextual())
						result.add(item.asText());
					else
						throw new ConverterException("Couch Text Converter: Unsupported data type - " + item.getClass().getName() + ".");
				}
				return result;
			} else
				throw new ConverterException("Couch Text Converter: Unsupported data type - " + node.getNodeType().toString() + ".");
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object parseWriteData(Object data) throws ConverterException {
		JsonNodeFactory factory = new JsonNodeFactory(true);
		//ObjectMapper mapper = new ObjectMapper();
		if (null == data)
			return factory.nullNode();
			//return mapper.createObjectNode().textNode("");
		if (data instanceof String) {
			return factory.textNode((String) data);
			//return mapper.createObjectNode().textNode((String) data);
		}
		if (data instanceof FastTable) {
			FastTable coll = (FastTable) data;
			if (coll.isEmpty()) {
				return factory.nullNode();
				//return mapper.createObjectNode().textNode("");
			}
			if (coll.size() == 1) {
				Object o = coll.get(0);
				if (o instanceof String)
					return factory.textNode((String) o);
					//return mapper.createObjectNode().textNode((String) o);
				else
					throw new ConverterException("Couch Text Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			ArrayNode result = factory.arrayNode();//mapper.createArrayNode();
			for (int i = 0; i < coll.size(); i++) {
				if (coll.get(i) instanceof String)
					result.add((String) coll.get(i));
				else
					throw new ConverterException("Couch Text Converter: Unsupported data type - " + coll.get(i).getClass().getName() + ".");
			}
			return result;
		}
		if (data instanceof Collection) {
			Collection coll = (Collection) data;
			if (coll.isEmpty())
				return factory.nullNode();
				//return mapper.createObjectNode().textNode("");
			if (coll.size() == 1) {
				Object o = coll.iterator().next();
				if (o instanceof String)
					return factory.textNode((String) o);
					//return mapper.createObjectNode().textNode((String) o);
				else 
					throw new ConverterException("Couch Text Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			ArrayNode result = factory.arrayNode();//mapper.createArrayNode();
			Iterator iterator = coll.iterator();
			while (iterator.hasNext()) {
				Object o = iterator.next();
				if (o instanceof String)
					result.add((String) o);
				else
					throw new ConverterException("Couch Text Converter: Unsupported data type - " + o.getClass().getName() + ".");
			}
			return result;
		}
		
		throw new ConverterException("Couch Text Converter: Unsupported data type - " + data.getClass().getName() + ".");
	}

}
