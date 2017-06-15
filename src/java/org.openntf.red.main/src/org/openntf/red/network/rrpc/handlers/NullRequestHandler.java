/**
 * 
 */
package org.openntf.red.network.rrpc.handlers;

import org.openntf.red.network.exceptions.REDServerException;
import org.openntf.red.network.rrpc.RequestHandler;
import org.openntf.red.network.rrpc.REDServer.Connection;
import org.openntf.red.network.rrpc.REDServer.Payloads;
import org.openntf.red.network.rrpc.REDServer.ServerStates;
import org.openntf.red.network.rrpc.messages.Base.Request;
import org.openntf.red.network.rrpc.messages.Base.Response;

import com.google.protobuf.AbstractMessage;

/**
 * Handles Requests with payload not set.<br>
 * Not implemented yet.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NullRequestHandler extends RequestHandler<AbstractMessage, AbstractMessage> {

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public NullRequestHandler() {
		super(AbstractMessage.class, AbstractMessage.class, Payloads.PAYLOAD_NOT_SET);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processRequest(Request request, Connection connection, Response.Builder builder)
			throws REDServerException {
		// TODO Auto-generated method stub
		throw new REDServerException("Not implemented.", ServerStates.NOT_IMPLEMENTED);
	}

}
