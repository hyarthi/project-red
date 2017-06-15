/**
 * 
 */
package org.openntf.red.security.exceptions;

/**
 * Exception thrown by Security Manager.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.security.ISecurityManager
 */
public class SecurityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public SecurityException() {
	}

	/**
	 * Constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public SecurityException(String msg) {
		super(msg);
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public SecurityException(Throwable e) {
		super(e);
	}

	/**
	 * Constructor with message text and cause of error.
	 * 
	 * @param msg
	 *            Message text.
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public SecurityException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * Constructor with message text, cause of error, and flags - suppression
	 * enabled and writable stack trace.
	 * 
	 * @param msg
	 *            Message text.
	 * @param e
	 *            Cuase of error.
	 * @param suppression
	 *            Flag - suppression enabled.
	 * @param writest
	 *            Flag - writable stack trace.
	 * @since 0.4.0
	 */
	public SecurityException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
