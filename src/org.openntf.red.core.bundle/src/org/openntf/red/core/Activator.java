package org.openntf.red.core;

import java.util.logging.Logger;

import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.thread.ThreadManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static Logger log = Logger.getLogger(Activator.class.getName());
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		/*log.info("RED Server: starting...");
		ConfigManager.startup();
		ThreadManager.startup();
		log.info("RED Server: started.");*/
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		/*log.info("RED Server: shutting down...");
		ThreadManager.shutdown();
		ConfigManager.shutdown();
		log.info("RED Server: shut down.");*/
	}

}
