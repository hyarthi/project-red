/**
 * 
 */
package org.openntf.red.network.exceptions;

/**
 * Exception thrown by RED Server (RRPC protocol).
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class REDServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Server state to be returned (largely based on HTTP states). */
	private final int status;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public REDServerException() {
		status = 500;
	}

	/**
	 * Default constructor with server state.
	 * 
	 * @param _status
	 *            Server state.
	 * @since 0.4.0
	 */
	public REDServerException(int _status) {
		status = _status;
	}

	/**
	 * Default constructor with message text.
	 * 
	 * @param msg
	 *            Message text.
	 * @since 0.4.0
	 */
	public REDServerException(String msg) {
		super(msg);
		status = 500;
	}

	/**
	 * Default constructor with message text and server state.
	 * 
	 * @param msg
	 *            Message text.
	 * @param _status
	 *            Server state.
	 * @since 0.4.0
	 */
	public REDServerException(String msg, int _status) {
		super(msg);
		status = _status;
	}

	/**
	 * Default constructor with cause of error.
	 * 
	 * @param cause
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public REDServerException(Throwable cause) {
		super(cause);
		status = 500;
	}

	/**
	 * Default constructor with cause of error and server state.
	 * 
	 * @param cause
	 *            Cause of error.
	 * @param _status
	 *            Server state
	 * @since 0.4.0
	 */
	public REDServerException(Throwable cause, int _status) {
		super(cause);
		status = _status;
	}

	/**
	 * Default constructor with message text and cause of error.
	 * 
	 * @param msg
	 *            Message text.
	 * @param cause
	 *            Cause of error.
	 * @since 0.4.0
	 */
	public REDServerException(String msg, Throwable cause) {
		super(msg, cause);
		status = 500;
	}

	/**
	 * Default constructor with message text, cause of error, and server state.
	 * 
	 * @param msg
	 *            Message text.
	 * @param cause
	 *            Cause of error.
	 * @param _status
	 *            Server state.
	 * @since 0.4.0
	 */
	public REDServerException(String msg, Throwable cause, int _status) {
		super(msg, cause);
		status = _status;
	}

	/**
	 * Default constructor with message text, cause of error, and flags -
	 * suppression enabled and writable stack trace.
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
	public REDServerException(String msg, Throwable cause, boolean suppression, boolean writest) {
		super(msg, cause, suppression, writest);
		status = 500;
	}

	/**
	 * Default constructor with message text, cause of error, server state, and
	 * flags - suppression enabled and writable stack trace.
	 * 
	 * @param msg
	 *            Message text.
	 * @param cause
	 *            Cause of error.
	 * @param suppression
	 *            Flag - suppression enabled.
	 * @param writest
	 *            Flag - writable stack trace.
	 * @param _status
	 *            Server state.
	 * @since 0.4.0
	 */
	public REDServerException(String msg, Throwable cause, boolean suppression, boolean writest, int _status) {
		super(msg, cause, suppression, writest);
		status = _status;
	}

	/**
	 * Returns the server state.
	 * 
	 * @return Server state.
	 * @since 0.4.0
	 */
	public int getStatus() {
		return status;
	}

}
