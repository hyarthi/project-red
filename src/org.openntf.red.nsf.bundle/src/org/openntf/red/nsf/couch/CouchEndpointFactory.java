/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import org.ektorp.http.StdHttpClient.Builder;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;
import org.openntf.red.nsf.couch.converters.*;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;
import org.openntf.red.nsf.endpoint.Field.Type;
import org.openntf.red.nsf.endpoint.RawDataConverter;
import org.openntf.red.nsf.exceptions.ConverterException;
import org.openntf.red.nsf.exceptions.EndpointException;
import org.openntf.red.nsf.exceptions.NSFBrokerException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javolution.util.FastMap;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchEndpointFactory implements EndpointFactory {
	private boolean _started = false;
	private boolean _bocce = true;
	private Builder builder = null;
	private FastMap<Integer, RawDataConverter> customConverters = null;
	private FastMap<Integer, RawDataConverter> coreConverters = null;
	private static Logger log = Logger.getLogger(CouchEndpointFactory.class.getName());

	/**
	 * 
	 */
	public CouchEndpointFactory() {}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint(EndpointConfig config) {
		if (null == config)
			throw new EndpointException("Couch Endpoint Factory: Can not create endpoint from a null configuration.");
		if (!config.type().equals(ConfigProperties.REPOSITORY_TYPE_COUCH))
			throw new EndpointException("Couch Endpoint Factory: Can not create endpoint of type " + config.type());
		CouchEndpoint endpoint = new CouchEndpoint(config, this);

		return endpoint;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint(String server, EndpointConfig config) {
		return getEndpoint(config);
	}

	@Override
	public void startup() {
		if (_started)
			throw new EndpointException("Couch Endpoint Factory: Factory is already running.");
		log.fine("Couch Endpoint Factory: starting...");
		builder = new Builder();
		initCoreConverters();
		_started = true;
		log.fine("Couch Endpoint Factory: started.");
	}

	@Override
	public void shutdown() {
		log.fine("Couch Endpoint Factory: shutting down...");
		if (!_started) {
			log.severe("Couch Endpoint Factory: Couch Endpoint Factory is not running.");
		} else {
			if (null != customConverters)
				customConverters.clear();
			coreConverters.clear();
			_started = false;
			log.fine("Couch Endpoint Factory: shut down.");
		}
	}

	@Override
	public boolean isStarted() {
		return _started;
	}

	Builder getBuilder() {
		return builder;
	}

	@Override
	public void registerConverter(RawDataConverter converter) {
		if (null == customConverters) {
			log.finest("Couch Endpoint Factory: Initializing custom converter container.");
			customConverters = new FastMap<Integer, RawDataConverter>().atomic();
		}
		log.finest("Couch Endpoint Factory: Adding a custom converter " + converter.getClass().getName() + " for type " + converter.getType() + ".");
		customConverters.put(Integer.valueOf(converter.getType()), converter);
	}

	@Override
	public void deregisterConverter(int type) {
		log.finest("Couch Endpoint Factory: Removing a custom converter for type " + type + ".");
		if (null == customConverters)
			return;
		if (customConverters.containsKey(Integer.valueOf(type)))
			customConverters.remove(Integer.valueOf(type));
	}

	@Override
	public Object parseReadData(Object raw, int fromType) {
		Object result = null;
		Integer type = Integer.valueOf(fromType);
		// try custom converters first
		if (null != customConverters) {
			if (customConverters.containsKey(type)) {
				try {
					result = customConverters.get(type).parseReadData(raw);
					return result;
				} catch (ConverterException ce) {
					if (_bocce)
						throw ce;
					// if not breaking - try to failover to standard converters
				}
			}
		}
		// try core converters
		if (null == coreConverters)
			throw new NSFBrokerException("Couch Endpoint Factory is corrupt: No converters defined.");
		if (coreConverters.containsKey(type)) {
			result = coreConverters.get(type).parseReadData(raw);
			return result;
		} else
			throw new ConverterException("Couch Endpoint Factory: Unsupported data type " + type + ".");
	}

	@Override
	public Object parseWriteData(Object data, int toType) {
		Object result = null;
		Integer type = Integer.valueOf(toType);
		// try custom converters first
		if (null != customConverters) {
			if (customConverters.containsKey(type)) {
				try {
					result = customConverters.get(type).parseWriteData(data);
					return result;
				} catch (ConverterException ce) {
					if (_bocce)
						throw ce;
					// if not breaking - try to failover to standard converters
				}
			}
		}
		// try core converters
		if (null == coreConverters)
			throw new NSFBrokerException("Couch Endpoint Factory is corrupt: No converters defined.");
		if (coreConverters.containsKey(type)) {
			result = coreConverters.get(type).parseWriteData(data);
			return result;
		} else
			throw new ConverterException("Couch Endpoint Factory: Unsupported data type " + type + ".");
	}

	@Override
	public boolean isBreakOnCustomConverterExceptions() {
		return _bocce;
	}

	@Override
	public void setBreakOnCustomConverterExceptions(boolean flag) {
		_bocce = flag;
	}
	
	private void initCoreConverters() {
		log.finest("Couch Endpoint Factory: started initializing core converters.");
		coreConverters = new FastMap<Integer, RawDataConverter>();
		// ActionCD
		coreConverters.put(Integer.valueOf(Type.ACTIONCD), new CouchActionCDConverter(Type.ACTIONCD));
		// AssistantInfo
		coreConverters.put(Integer.valueOf(Type.ASSISTANTINFO), new CouchAssistantInfoConverter(Type.ASSISTANTINFO));
		// Attachment
		coreConverters.put(Integer.valueOf(Type.ATTACHMENT), new CouchAttachmentConverter(Type.ATTACHMENT));
		// Authors
		coreConverters.put(Integer.valueOf(Type.AUTHORS), new CouchAuthorsConverter(Type.AUTHORS));
		// Collation
		coreConverters.put(Integer.valueOf(Type.COLLATION), new CouchCollationConverter(Type.COLLATION));
		// DateTimes
		coreConverters.put(Integer.valueOf(Type.DATETIMES), new CouchDateTimesConverter(Type.DATETIMES));
		// EmbeddedObject
		coreConverters.put(Integer.valueOf(Type.EMBEDDEDOBJECT), new CouchEmbeddedObjectConverter(Type.EMBEDDEDOBJECT));
		// ErrorItem
		coreConverters.put(Integer.valueOf(Type.ERRORITEM), new CouchErrorItemConverter(Type.ERRORITEM));
		// Formula
		coreConverters.put(Integer.valueOf(Type.FORMULA), new CouchFormulaConverter(Type.FORMULA));
		// HTML
		coreConverters.put(Integer.valueOf(Type.HTML), new CouchHTMLConverter(Type.HTML));
		// Icon
		coreConverters.put(Integer.valueOf(Type.ICON), new CouchIconConverter(Type.ICON));
		// LSObject
		coreConverters.put(Integer.valueOf(Type.LSOBJECT), new CouchLSObjectConverter(Type.LSOBJECT));
		// MIMEPart
		coreConverters.put(Integer.valueOf(Type.MIME_PART), new CouchMIMEPartConverter(Type.MIME_PART));
		// Names
		coreConverters.put(Integer.valueOf(Type.NAMES), new CouchNamesConverter(Type.NAMES));
		// NoteLinks
		coreConverters.put(Integer.valueOf(Type.NOTELINKS), new CouchNoteLinksConverter(Type.NOTELINKS));
		// NoteRefs
		coreConverters.put(Integer.valueOf(Type.NOTEREFS), new CouchNoteRefsConverter(Type.NOTEREFS));
		// Numbers
		coreConverters.put(Integer.valueOf(Type.NUMBERS), new CouchNumbersConverter(Type.NUMBERS));
		// OtherObject
		coreConverters.put(Integer.valueOf(Type.OTHEROBJECT), new CouchOtherObjectConverter(Type.OTHEROBJECT));
		// QueryCD
		coreConverters.put(Integer.valueOf(Type.QUERYCD), new CouchQueryCDConverter(Type.QUERYCD));
		// Readers
		coreConverters.put(Integer.valueOf(Type.READERS), new CouchReadersConverter(Type.READERS));
		// RFC822Text
		coreConverters.put(Integer.valueOf(Type.RFC822TEXT), new CouchRFC822TextConverter(Type.RFC822TEXT));
		// RichText
		coreConverters.put(Integer.valueOf(Type.RICHTEXT), new CouchRichTextConverter(Type.RICHTEXT));
		// Signature
		coreConverters.put(Integer.valueOf(Type.SIGNATURE), new CouchSignatureConverter(Type.SIGNATURE));
		// Text
		coreConverters.put(Integer.valueOf(Type.TEXT), new CouchTextConverter(Type.TEXT));
		// Unavailable
		coreConverters.put(Integer.valueOf(Type.UNAVAILABLE), new CouchUnavailableConverter(Type.UNAVAILABLE));
		// Unknown
		coreConverters.put(Integer.valueOf(Type.UNKNOWN), new CouchUnknownConverter(Type.UNKNOWN));
		// UserData
		coreConverters.put(Integer.valueOf(Type.USERDATA), new CouchUserDataConverter(Type.USERDATA));
		// UserID
		coreConverters.put(Integer.valueOf(Type.USERID), new CouchUserIDConverter(Type.USERID));
		// ViewMapData
		coreConverters.put(Integer.valueOf(Type.VIEWMAPDATA), new CouchViewMapDataConverter(Type.VIEWMAPDATA));
		// ViewMapLayout
		coreConverters.put(Integer.valueOf(Type.VIEWMAPLAYOUT), new CouchViewMapLayoutConverter(Type.VIEWMAPLAYOUT));
		// lock it
		coreConverters = coreConverters.unmodifiable();
		log.finest("Couch Endpoint Factory: finished initializing core converters.");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int closestTypeMatch(Object data, int recursion) {
		if (data instanceof String)
			return Type.TEXT;
		if (data instanceof Integer || data instanceof Long || data instanceof Float || data instanceof Double || data instanceof BigDecimal)
			return Type.NUMBERS;
		if (data instanceof Date || data instanceof Calendar)
			return Type.DATETIMES;
		if (data instanceof Collection) {
			if (recursion > 1)
				return Type.UNKNOWN;
			Collection coll = (Collection) data;
			if (coll.isEmpty())
				return Type.UNAVAILABLE;
			return closestTypeMatch(coll.iterator().next(), recursion + 1);
		}
		if (data instanceof JsonNode) {
			JsonNode node = (JsonNode) data;
			if (node.isTextual())
				return Type.TEXT;
			if (node.isNumber())
				return Type.NUMBERS;
			if (node.isArray()) {
				if (recursion > 1)
					return Type.UNKNOWN;
				ArrayNode arr = ((ObjectNode) node).arrayNode();
				if (arr.size() == 0)
					return Type.UNAVAILABLE;
				return closestTypeMatch(arr.get(0), recursion + 1);
			}
			// TODO continue
		}
		// TODO continue
		return Type.UNKNOWN;
	}
}
