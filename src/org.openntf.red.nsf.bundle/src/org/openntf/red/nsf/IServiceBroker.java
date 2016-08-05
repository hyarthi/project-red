/**
 * 
 */
package org.openntf.red.nsf;

import java.util.Set;

import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public interface IServiceBroker {
	public <F extends EndpointFactory> void registerEndpointFactory(String name, Class<F> type);
	public void deregisterEndpointFactory(String name);
	public EndpointFactory getEndpointFactory(String name);
	public Endpoint getEndpoint(String server);
	public Endpoint getEndpoint();
	public Set<String> getLocalEndpoints();
	public Endpoint getLocalEndpoint(String name);
	public EndpointConfig getEndpointConfig(String name);
	public EndpointConfig getDefaultEndpointConfig();
}
