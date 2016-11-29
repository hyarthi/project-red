/**
 * 
 */
package org.openntf.red.network.exceptions;

/**
 * @author Vladimir Kornienko
 *
 */
public class REDServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int status;

	/**
	 * 
	 */
	public REDServerException() {
		// TODO Auto-generated constructor stub
		status = 500;
	}
	
	public REDServerException(int _status) {
		status = _status;
	}

	/**
	 * @param arg0
	 */
	public REDServerException(String msg) {
		super(msg);
		status = 500;
		// TODO Auto-generated constructor stub
	}
	
	public REDServerException(String msg, int _status) {
		super(msg);
		status = _status;
	}

	/**
	 * @param arg0
	 */
	public REDServerException(Throwable cause) {
		super(cause);
		status = 500;
		// TODO Auto-generated constructor stub
	}
	
	public REDServerException(Throwable cause, int _status) {
		super(cause);
		status = _status;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public REDServerException(String msg, Throwable cause) {
		super(msg, cause);
		status = 500;
		// TODO Auto-generated constructor stub
	}
	
	public REDServerException(String msg, Throwable cause, int _status) {
		super(msg, cause);
		status = _status;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public REDServerException(String msg, Throwable cause, boolean arg2, boolean arg3) {
		super(msg, cause, arg2, arg3);
		status = 500;
		// TODO Auto-generated constructor stub
	}
	
	public REDServerException(String msg, Throwable cause, boolean arg2, boolean arg3, int _status) {
		super(msg, cause, arg2, arg3);
		status = _status;
		// TODO Auto-generated constructor stub
	}
	
	public int getStatus() {
		return status;
	}

}
