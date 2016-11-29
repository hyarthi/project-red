package org.openntf.red.exceptions;

import java.util.logging.Logger;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 *
 */
public class DataNotCompatibleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log_ = Logger.getLogger(DataNotCompatibleException.class.getName());

	/**
	 * @param message
	 *            the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
	 */
	public DataNotCompatibleException(final String message) {
		super(message);
	}

	public DataNotCompatibleException(final String message, final Throwable t) {
		super(message, t);
	}
}