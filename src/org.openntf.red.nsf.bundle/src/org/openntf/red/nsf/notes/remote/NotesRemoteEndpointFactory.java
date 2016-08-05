/**
 * 
 */
package org.openntf.red.nsf.notes.remote;

import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotesRemoteEndpointFactory implements EndpointFactory {

	/**
	 * 
	 */
	public NotesRemoteEndpointFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.EndpointFactory#createEndpoint(java.lang.String, java.lang.String)
	 */
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

}
