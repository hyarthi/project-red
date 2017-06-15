/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Basic set of functions that should be present in any data entity.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
@SuppressWarnings("rawtypes")
public interface Base<TE extends Endpoint, TEF extends EndpointFactory, TEP extends Object> {
	/**
	 * Returns the ancestor endpoint factory.
	 * 
	 * @return Ancestor endpoint factory.
	 * @since 0.4.0
	 * @see EndpointFactory
	 */
	public TEF getAncestorFactory();

	/**
	 * Returns the ancestor endpoint (endpoints return themselves).
	 * 
	 * @return Ancestor endpoint.
	 * @since 0.4.0
	 * @see Endpoint
	 */
	public TE getAncestorEndpoint();

	/**
	 * Returns the object's immediate parent.
	 * 
	 * @return Object's parent
	 * @since 0.4.0
	 */
	public TEP getParent();
}
