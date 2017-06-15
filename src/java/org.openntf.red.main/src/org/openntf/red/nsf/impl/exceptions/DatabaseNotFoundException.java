/**
 * 
 */
package org.openntf.red.nsf.impl.exceptions;

/**
 * Exception thrown if a database could not be found/created.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class DatabaseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392352154091530448L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public DatabaseNotFoundException() {
	}

	/**
	 * Constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public DatabaseNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public DatabaseNotFoundException(Throwable e) {
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
	public DatabaseNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * Constructor with message text, cause of error, and flags - suppression
	 * enabled and writable stack trace.
	 * 
	 * @param msg
	 *            Message text.
	 * @param e
	 *            Cause of error.
	 * @param suppression
	 *            Flag - suppression enabled.
	 * @param writest
	 *            Flag - writable stack trace.
	 * @since 0.4.0
	 */
	public DatabaseNotFoundException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
