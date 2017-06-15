/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import javax.ws.rs.core.Response;

/**
 * CouchDB utility functions.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
enum CouchUtil {
	;
	/**
	 * Checks if the submit to the server was successful by checking the return
	 * code.
	 * 
	 * @param status
	 *            Return code.
	 * @return Operation successful.
	 * @since 0.4.0
	 */
	protected static boolean isStatusSuccess(int status) {
		if (status == Response.Status.OK.getStatusCode())
			return true;
		if (status == Response.Status.CREATED.getStatusCode())
			return true;
		if (status == Response.Status.ACCEPTED.getStatusCode())
			return true;
		return false;
	}
}
