/**
 * 
 */
package org.openntf.red.security.exceptions;

/**
 * Exception thrown by Authorization Manager to designate that the user is not
 * authorized to perform an operation.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.security.authorization.IAuthorizationManager
 */
public class NotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public NotAuthorizedException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public NotAuthorizedException(String msg) {
		super(msg);
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param cause
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public NotAuthorizedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with message text and cause of error.
	 * 
	 * @param msg
	 *            Message text.
	 * @param cause
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public NotAuthorizedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Constructor with message text, cause of error, and flags - suppression
	 * enabled and writable stack trace.
	 * 
	 * @param msg
	 *            Message text.
	 * @param cause
	 *            Cause of error.
	 * @param suppression
	 *            Flag - suppression enabled.
	 * @param writest
	 *            Flag - writable stack trace.
	 * @since 0.4.0
	 */
	public NotAuthorizedException(String msg, Throwable cause, boolean suppression, boolean writest) {
		super(msg, cause, suppression, writest);
	}

}
