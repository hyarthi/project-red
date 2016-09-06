package org.openntf.red.launcher;

import java.util.logging.Logger;

import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.thread.ThreadManager;
import org.openntf.red.nsf.NSFBroker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static Logger log = Logger.getLogger(Activator.class.getName());

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		log.info("RED Server: starting...");
		ConfigManager.startup();
		ThreadManager.startup();
		NSFBroker.getInstance().startup();
		log.info("RED Server: started.");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		log.info("RED Server: shutting down...");
		NSFBroker.getInstance().shutdown();
		ThreadManager.shutdown();
		ConfigManager.shutdown();
		log.info("RED Server: shut down.");
	}

}
