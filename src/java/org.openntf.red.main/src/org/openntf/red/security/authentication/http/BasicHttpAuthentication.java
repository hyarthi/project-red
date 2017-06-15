/**
 * 
 */
package org.openntf.red.security.authentication.http;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

/**
 * Basic HTTP authentication implementaion.<br>
 * (Needs improvement)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see {@link ClientRequestFilter}, {@link ClientResponseFilter}
 */
public class BasicHttpAuthentication implements ClientRequestFilter, ClientResponseFilter {

	/** User name. */
	private String user;
	/** User password. */
	private String password;

	/**
	 * Default cosntructor.
	 * 
	 * @param _user
	 *            User name.
	 * @param _password
	 *            User password.
	 * @since 0.4.0
	 */
	public BasicHttpAuthentication(String _user, String _password) {
		user = _user;
		password = _password;
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		// TODO Check if this is needed (perhaps needs a separate implementation
		// for server functionality)
	}

	@Override
	public void filter(ClientRequestContext context) throws IOException {
		// TODO Auto-generated method stub
		MultivaluedMap<String, Object> headers = context.getHeaders();
		String token = user + ":" + password;
		final String auth = "Basic " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
		headers.add("Authorization", auth);
	}

}
