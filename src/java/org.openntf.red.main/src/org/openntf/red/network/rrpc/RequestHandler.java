/**
 * 
 */
package org.openntf.red.network.rrpc;

import org.openntf.red.network.exceptions.REDServerException;
import org.openntf.red.network.rrpc.REDServer.Connection;
import org.openntf.red.network.rrpc.messages.Base.Request;
import org.openntf.red.network.rrpc.messages.Base.Response;

/**
 * Abstract RRPC request handler. All request handlers should extend it.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public abstract class RequestHandler<TH extends com.google.protobuf.AbstractMessage, TP extends com.google.protobuf.AbstractMessage> {
	/** Class of Request payload handled. */
	private final Class<TH> htype;
	/** Class of Response payload produced. */
	private final Class<TP> ptype;
	/** Code of payload type handled. */
	private final int msgtype;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	protected RequestHandler(Class<TH> _htype, Class<TP> _ptype, int _msgtype) {
		htype = _htype;
		ptype = _ptype;
		msgtype = _msgtype;
	}

	/**
	 * Returns what data type does this request handler take in.
	 * 
	 * @return Data type handled.
	 * @since 0.4.0
	 */
	public final Class<TH> consumesType() {
		return htype;
	}

	/**
	 * Returns what data type does this request handler produce.
	 * 
	 * @return Data type produced
	 * @since 0.4.0
	 */
	public final Class<TP> producesType() {
		return ptype;
	}

	/**
	 * Returns what payload code does this request handler correspond to.
	 * 
	 * @return Payload code.
	 * @since 0.4.0
	 */
	public final long handlesType() {
		return msgtype;
	}

	/**
	 * Processes the request and produces the response.
	 * 
	 * @param request
	 *            RRPC request object.
	 * @param connection
	 *            Connection that invoked this request handler.
	 * @param builder
	 *            Builder for the RRPC response.
	 * @throws REDServerException
	 *             If any processing errors happen. This is one of the ways to
	 *             communicate to the RED Server that the request could not be
	 *             processed. RED Server intercepts these exceptions and records
	 *             the necessary RRPC response.
	 * @since 0.4.0
	 */
	public abstract void processRequest(Request request, Connection connection, Response.Builder builder)
			throws REDServerException;
}
