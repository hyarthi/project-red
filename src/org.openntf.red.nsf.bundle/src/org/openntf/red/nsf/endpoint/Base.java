/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Base<TE extends Endpoint, TEF extends EndpointFactory, TEP extends Object> {
	public TEF getAncestorFactory();
	public TE getAncestorEndpoint();
	public TEP getParent();
}
