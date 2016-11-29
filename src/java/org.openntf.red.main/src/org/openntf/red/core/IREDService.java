/**
 * 
 */
package org.openntf.red.core;

/**
 * @author Vladimir Kornienko
 *
 */
public interface IREDService {
	public void startup();
	public void shutdown();
	public boolean isStarted();
}
