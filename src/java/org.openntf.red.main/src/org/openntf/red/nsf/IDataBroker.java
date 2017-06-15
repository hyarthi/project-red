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
 * Interface representing an abstract data broker.
 * <p>
 * Data broker is the single entry point for back-end data manipulation.
 * <p>
 * Implementations may vary, but this is the interface all code should work
 * with.
 * 
 * @author Vladimir Kornienko
 * @see IREDService
 * @since 0.4.0
 */
public interface IDataBroker extends IREDService {

	/**
	 * Registers an endpoint factory with the data broker service.
	 * <p>
	 * An endpoint factory corresponds to a specific endpoint type. If the
	 * server utilizes several endpoints that have the same type, it needs to
	 * have just 1 endpoint factory registered.
	 * <p>
	 * Also instantiates and initializes the newly registered endpoint factory.
	 * <p>
	 * If an endpoint factory is already registered under a specific name, it
	 * will be overwritten by the new value.
	 * 
	 * @see EndpointFactory
	 * @param name
	 *            Symbolic name of the endpoint factory.
	 * @param type
	 *            Class implementing the endpoint factory.
	 * @since 0.4.0
	 */
	public <F extends EndpointFactory> void registerEndpointFactory(String name, Class<F> type);

	/**
	 * Deregisters an endpoint factory that was registered under a specified
	 * name.
	 * <p>
	 * Also destroys and cleans up the deregistered factory.
	 * 
	 * @param name
	 *            Symbolic name of the factory to deregister.
	 * @see EndpointFactory
	 * @since 0.4.0
	 */
	public void deregisterEndpointFactory(String name);

	/**
	 * Returns a registered endpoint factory given it's symbolic name.
	 * 
	 * @param name
	 *            Symbolic name of the factory to return.
	 * @return The endpoint factory registered under a specified symbolic name.
	 * @see EndpointFactory
	 * @since 0.4.0
	 */
	public EndpointFactory getEndpointFactory(String name);

	/**
	 * Returns the endpoint associated with a specific server name.
	 * <p>
	 * Server names have to follow the canonical directory notation
	 * (<code>CN=.../OU=.../O=...</code>), but may also be in abbreviated form
	 * (<code>.../.../...</code>) or even be a common name (if it's unique).
	 * <p>
	 * A <code>NULL</code> or empty string is interpreted as the current server.
	 * <p>
	 * If working with a local endpoint on a server with multiple local
	 * endpoints, the first registered local endpoint is returned.
	 * 
	 * @param server
	 *            Server name
	 * @return Local or remote endpoint
	 * @see Endpoint
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(String server);

	/**
	 * Returns the first registered local server endpoint.
	 * 
	 * @return First registered local server endpoint.
	 * @see Endpoint
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint();

	/**
	 * Returns a collection of names of all registered local endpoints.
	 * 
	 * @return A set of names of all registered local endpoints.
	 * @see Endpoint
	 * @since 0.4.0
	 */
	public Set<String> getLocalEndpoints();

	/**
	 * Returns a local endpoint given it's symbolic name.
	 * 
	 * @param name
	 *            Symbolic name of the local endpoint to return.
	 * @return Local endpoint.
	 * @see {@link Endpoint}, {@link #getLocalEndpoints()}
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Endpoint getLocalEndpoint(String name);

	/**
	 * Returns the config of an endpoint given it's symbolic name.
	 * 
	 * @param name
	 *            Symbolic name of the endpoint.
	 * @return Config for the endpoint.
	 * @see {@link EndpointConfig}, {@link #getLocalEndpoints()}
	 * @since 0.4.0
	 */
	public EndpointConfig getEndpointConfig(String name);

	/**
	 * Returns the config of the first registered endpoint.
	 * 
	 * @return Config of the first registered endpoint.
	 * @see {@link EndpointConfig}, {@link #getLocalEndpoints()}
	 * @since 0.4.0
	 */
	public EndpointConfig getDefaultEndpointConfig();
}
