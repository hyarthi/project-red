/**
 * 
 */
package org.openntf.red.core.thread;

/**
 * Interface representing an abstract server task. All server tasks should
 * implement this interface.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see Runnable
 */
public interface IServerTask extends Runnable {

	/**
	 * List of states that the server task can be in.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static enum Status {
		/** Task is stopped. */
		STOPPED,
		/** Task is in the process of starting up. */
		STARTING,
		/** Task is running. */
		RUNNING,
		/** Task is in the process of shutting down. */
		STOPPING,
		/** Task is in an error/unresponsive state. */
		ERROR;
	}

	/**
	 * Returns the current state of the task.
	 * 
	 * @return Current task state
	 * @since 0.4.0
	 * @see Status
	 */
	public Status status();

	/**
	 * Resets (and restarts) the server task. Implementations may vary.
	 * 
	 * @since 0.4.0
	 */
	public void reset();

	/**
	 * Initiates task shutdown. Implementations may vary.
	 * 
	 * @since 0.4.0
	 */
	public void terminate();
}
