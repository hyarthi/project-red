/**
 * 
 */
package org.openntf.red.nsf.impl.notes;

import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;
import org.openntf.red.nsf.endpoint.RawDataConverter;

/**
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NotesEndpointFactory implements EndpointFactory {

	/**
	 * 
	 */
	public NotesEndpointFactory() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint(String server, EndpointConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint(EndpointConfig config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerConverter(RawDataConverter converter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deregisterConverter(int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object parseReadData(Object raw, int fromType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseWriteData(Object data, int toType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBreakOnCustomConverterExceptions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBreakOnCustomConverterExceptions(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public int closestTypeMatch(Object data, int recursion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
