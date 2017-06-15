/**
 * 
 */
package org.openntf.red.security.exceptions;

/**
 * Exception thrown by the Session Manager.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.security.session.ISessionManager
 */
public class SessionManagerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public SessionManagerException() {
	}

	/**
	 * Cosntructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public SessionManagerException(String msg) {
		super(msg);
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public SessionManagerException(Throwable e) {
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
	public SessionManagerException(String msg, Throwable e) {
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
	public SessionManagerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
