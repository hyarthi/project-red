/**
 * 
 */
package org.openntf.red.core.config;

/**
 * Exception thrown by the Config Manager if it encounters an error.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class ConfigManagerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public ConfigManagerException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with message text.
	 * 
	 * @param msg
	 *            Message text
	 * @since 0.4.0
	 */
	public ConfigManagerException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with cause of error.
	 * 
	 * @param e
	 *            cause of error (exception)
	 * @since 0.4.0
	 */
	public ConfigManagerException(Throwable e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with message text and cause of error.
	 * 
	 * @param msg
	 *            Message text
	 * @param e
	 *            Cause of error
	 * @since 0.4.0
	 */
	public ConfigManagerException(String msg, Throwable e) {
		super(msg, e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with message text, cause of error, and flags: enable
	 * suppression and write stack trace.
	 * 
	 * @param msg
	 *            Message text
	 * @param e
	 *            Cause of error
	 * @param suppression
	 *            Flag - enable suppression
	 * @param writest
	 *            Flag - writable stack trace
	 * @since 0.4.0
	 */
	public ConfigManagerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
		// TODO Auto-generated constructor stub
	}

}
