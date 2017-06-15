/**
 * 
 */
package org.openntf.red.nsf;

/**
 * Exception produced by the Data Broker.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class DataBrokerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public DataBrokerException() {
	}

	/**
	 * Default constructor with message text
	 * @param msg Message text
	 * @since 0.4.0
	 */
	public DataBrokerException(String msg) {
		super(msg);
	}

	/**
	 * Default constructor with error cause.
	 * @param e Error cause
	 * @since 0.4.0
	 */
	public DataBrokerException(Throwable e) {
		super(e);
	}

	/**
	 * Default constructor with message text & error cause.
	 * @param msg Message text
	 * @param e Error cause
	 * @since 0.4.0
	 */
	public DataBrokerException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * Default constructor with message text, error cause, and flags: enable suppression and writable stack trace.
	 * @param msg Message text
	 * @param e Error cause
	 * @param suppression Flag - enable suppression
	 * @param writest Flag - writable stack trace
	 * @since 0.4.0
	 */
	public DataBrokerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
