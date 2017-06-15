/**
 * 
 */
package org.openntf.red.core.modules;

/**
 * Exception thrown by the Module Manager.
 * 
 * @author Vladimir Kornienko
 * @see ModuleManager
 * @since 0.4.0
 */
public class ModuleManagerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	public ModuleManagerException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Default constructor with message text
	 * 
	 * @param msg
	 *            Message text
	 * @since 0.4.0
	 */
	public ModuleManagerException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Default constructor with cause of error.
	 * 
	 * @param e
	 *            Cause of error
	 * @since 0.4.0
	 */
	public ModuleManagerException(Throwable e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Default constructor with message text & cause of error.
	 * 
	 * @param msf
	 *            Message text
	 * @param e
	 *            Cause of error
	 * @since 0.4.0
	 */
	public ModuleManagerException(String msg, Throwable e) {
		super(msg, e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Default constructor with message text, cause of error, and flags:
	 * suppression enabled and writable stack trace.
	 * 
	 * @param msg
	 *            Message text
	 * @param e
	 *            Cause of error
	 * @param suppression
	 *            Flag - suppression enabled
	 * @param writest
	 *            Flag - writable stack trace
	 * @since 0.4.0
	 */
	public ModuleManagerException(String msg, Throwable e, boolean suppression, boolean writest) {
		super(msg, e, suppression, writest);
		// TODO Auto-generated constructor stub
	}

}
