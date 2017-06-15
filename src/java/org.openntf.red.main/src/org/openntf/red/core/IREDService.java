/**
 * 
 */
package org.openntf.red.core;

/**
 * An interface that all RED Service modules should implement. It is used by
 * {@link org.openntf.red.core.modules.ModuleManager} to manage the service in
 * the runtime.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface IREDService {

	/**
	 * Service initialization function. This function is run by the Module
	 * Manager at server startup. This function should initialize all resources
	 * required for proper service functioning.
	 * 
	 * @see org.openntf.red.core.modules.ModuleManager
	 * @since 0.4.0
	 */
	public void startup();

	/**
	 * Service shutdown function. This function is run by the Module Manager at
	 * server shutdown. This function should clean up as many resources as
	 * possible.
	 * 
	 * @see org.openntf.red.core.modules.ModuleManager
	 * @since 0.4.0
	 */
	public void shutdown();

	/**
	 * Indicates whether the service is currently up and running. If a service
	 * encounters an error that it can not recover from, it should shut down and
	 * the result of this function should be <code>false</code>.
	 * 
	 * @return Whether the service is running.
	 * @since 0.4.0
	 */
	public boolean isStarted();
}
