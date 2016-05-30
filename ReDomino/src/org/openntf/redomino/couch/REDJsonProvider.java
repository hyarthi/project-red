/**
 * 
 */
package org.openntf.redomino.couch;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.ibm.commons.util.io.json.JsonException;
import com.ibm.commons.util.io.json.JsonJavaFactory;
import com.ibm.commons.util.io.json.JsonJavaObject;
import com.ibm.commons.util.io.json.JsonParser;

/**
 * @author Vladimir Kornienko
 *
 */
@Provider
@Consumes({MediaType.APPLICATION_JSON, "text/json", "application/*+json"})
@Produces({MediaType.APPLICATION_JSON, "text/json", "application/*+json"})
public class REDJsonProvider implements MessageBodyReader<JsonJavaObject>, MessageBodyWriter<JsonJavaObject> {

	private JsonJavaFactory factory;
	/**
	 * 
	 */
	public REDJsonProvider() {
		factory = new JsonJavaFactory();
	}

	@Override
	public long getSize(JsonJavaObject json, Class<?> cls, Type type, Annotation[] annotation, MediaType mtype) {
		// TODO Auto-generated method stub
		return 0;//json.toString().length();
	}

	@Override
	public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotation, MediaType mtype) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void writeTo(JsonJavaObject json, Class<?> cls, Type type, Annotation[] annotation, MediaType mtype,
			MultivaluedMap<String, Object> headers, OutputStream stream) throws IOException, WebApplicationException {
		OutputStreamWriter writer = new OutputStreamWriter(stream);
		String jsonstr = json.toString();
		writer.write(jsonstr);
		writer.flush();
	}

	@Override
	public boolean isReadable(Class<?> cls, Type type, Annotation[] annotation, MediaType mtype) {
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JsonJavaObject readFrom(Class<JsonJavaObject> cls, Type type, Annotation[] annotation, MediaType mtype,
			MultivaluedMap<String, String> values, InputStream stream) throws IOException, WebApplicationException {
		JsonJavaObject result = new JsonJavaObject();
		Map map;
		InputStreamReader reader = new InputStreamReader(stream);
		try {
			map = (HashMap) JsonParser.fromJson(factory, reader);
		} catch (JsonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		for (Object key : map.keySet()) {
			result.put((String)key, map.get(key));
		}
		
		return result;
	}

}
