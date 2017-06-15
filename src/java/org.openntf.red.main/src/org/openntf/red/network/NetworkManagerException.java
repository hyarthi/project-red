/**
 * 
 */
package org.openntf.red.network;

/**
 * Exception produced by Network Manager.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class NetworkManagerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public NetworkManagerException() {
	}

	/**
	 * Default constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public NetworkManagerException(String msg) {
		super(msg);
	}

	/**
	 * Default constructor with cause of error.
	 * 
	 * @param e
	 *            cause of error.
	 * @since 0.4.0
	 */
	public NetworkManagerException(Throwable e) {
		super(e);
	}

	/**
	 * Default constructor with message text and cause of error.
	 * 
	 * @param msg
	 *            Message text.
	 * @param e
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public NetworkManagerException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * Default constructor with message text, cause of error, and flags:
	 * suppression enabled and writable stack trace.
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
	public NetworkManagerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
	}

}
