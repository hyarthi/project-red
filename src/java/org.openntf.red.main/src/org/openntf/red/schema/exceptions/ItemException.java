package org.openntf.red.schema.exceptions;

import java.util.logging.Logger;

import org.openntf.red.schema.IItemDefinition;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author nfreeman
 * 
 */
public abstract class ItemException extends SchemaException {
	@SuppressWarnings("unused")
	private static final Logger log_ = Logger.getLogger(ItemException.class.getName());
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Object value_;
	@SuppressWarnings("unused")
	private IItemDefinition itemdef_;

	public ItemException() {
	}

	/**
	 * @param message
	 *            the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
	 */
	public ItemException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 *            the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 */
	public ItemException(final Throwable cause) {
		super(cause);
	}
}
