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
 * @author Vladimir Kornienko
 *
 */
public class BasicHttpAuthentication implements ClientRequestFilter, ClientResponseFilter {
	
	private String user;
	private String password;

	/**
	 * 
	 */
	public BasicHttpAuthentication(String _user, String _password) {
		user = _user;
		password = _password;
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.client.ClientResponseFilter#filter(javax.ws.rs.client.ClientRequestContext, javax.ws.rs.client.ClientResponseContext)
	 */
	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		// TODO Check if this is needed (perhaps needs a separate implementation for server functionality)
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.client.ClientRequestFilter#filter(javax.ws.rs.client.ClientRequestContext)
	 */
	@Override
	public void filter(ClientRequestContext context) throws IOException {
		// TODO Auto-generated method stub
		MultivaluedMap<String, Object> headers = context.getHeaders();
		String token = user + ":" + password;
		final String auth = "Basic " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
		headers.add("Authorization", auth);
	}

}
