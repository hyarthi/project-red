/**
 * 
 */
package org.openntf.red.nsf.impl.exceptions;

/**
 * Exception thrown by data broker.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NSFBrokerException extends RuntimeException {
	// FIXME change to DataBrokerException

	/**
	 * 
	 */
	private static final long serialVersionUID = 4079056878785634312L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public NSFBrokerException() {
	}

	/**
	 * Constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public NSFBrokerException(String msg) {
		super(msg);
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public NSFBrokerException(Throwable e) {
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
	public NSFBrokerException(String msg, Throwable e) {
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
	public NSFBrokerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
