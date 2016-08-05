/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchEndpointFactory implements EndpointFactory {
	private boolean _started = false;
	private static Logger log = Logger.getLogger(CouchEndpointFactory.class.getName());
	
	/**
	 * 
	 */
	public CouchEndpointFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.EndpointFactory#createEndpoint(java.lang.String, java.lang.String)
	 */
	@Override
	public Endpoint getEndpoint(String server, EndpointConfig config) {
		//CouchEndpoint endpoint = new CouchEndpoint(server);
		// TODO code here
		
		//return endpoint;
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
		return _started;
	}

}
