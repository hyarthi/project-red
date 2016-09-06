/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ViewEntry<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends View<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {
	public Object getColumn(int idx);

	public Object getColumn(String name);
}
