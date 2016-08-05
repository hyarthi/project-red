/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Korniekno
 *
 */
public interface EndpointFactory {
	public Endpoint getEndpoint(String server, EndpointConfig config);
	public void startup();
	public void shutdown();
	public boolean isStarted();
}
