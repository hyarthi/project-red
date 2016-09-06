/**
 * 
 */
package org.openntf.red.nsf;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Vladimir Kornienko
 *
 */
public class Activator implements BundleActivator {
	private static Logger log = Logger.getLogger(Activator.class.getName());

	@Override
	public void start(BundleContext context) throws Exception {
		//NSFBroker.getInstance().startup();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		//NSFBroker.getInstance().shutdown();
	}

}
