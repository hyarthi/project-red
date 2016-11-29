/**
 * 
 */
package org.openntf.red.nsf;

import java.util.Set;

import org.openntf.red.core.IREDService;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public interface IDataBroker extends IREDService {
	public <F extends EndpointFactory> void registerEndpointFactory(String name, Class<F> type);
	public void deregisterEndpointFactory(String name);
	public EndpointFactory getEndpointFactory(String name);
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(String server);
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint();
	public Set<String> getLocalEndpoints();
	@SuppressWarnings("rawtypes")
	public Endpoint getLocalEndpoint(String name);
	public EndpointConfig getEndpointConfig(String name);
	public EndpointConfig getDefaultEndpointConfig();
}
