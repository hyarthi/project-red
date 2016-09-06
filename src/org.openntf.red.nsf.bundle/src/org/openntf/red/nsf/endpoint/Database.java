/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Database<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Endpoint<?, ?, ?>>
		extends Base<TE, TEF, TEP> {
	@SuppressWarnings("rawtypes")
	public Note getNoteByUNID(String unid);
}
