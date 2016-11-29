/**
 * 
 */
package org.openntf.red.security.exceptions;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public NotAuthorizedException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public NotAuthorizedException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public NotAuthorizedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public NotAuthorizedException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public NotAuthorizedException(String msg, Throwable cause, boolean arg2, boolean arg3) {
		super(msg, cause, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
