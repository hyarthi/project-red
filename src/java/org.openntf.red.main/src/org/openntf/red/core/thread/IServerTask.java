/**
 * 
 */
package org.openntf.red.core.thread;

/**
 * @author Vladimir Kornienko
 *
 */
public interface IServerTask extends Runnable {
	
	public static enum Status {
		STOPPED,
		STARTING,
		RUNNING,
		STOPPING,
		ERROR;
	}
	
	public Status status();
	public void reset();
	public void terminate();
}
