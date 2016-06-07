/**
 * 
 */
package org.openntf.redomino.xsp;

import org.openntf.redomino.utils.Factory;
import org.openntf.redomino.utils.Factory.ThreadConfig;
//import org.openntf.domino.xsp.ODAPlatform;
import org.openntf.domino.xsp.session.XPageNamedSessionFactory;
import com.ibm.designer.runtime.Application;

/**
 * @author Vladimir Kornienko
 *
 */
public enum REDExtension {
	;
	public static boolean isStarted_ = false;
	
	public synchronized static boolean isStarted() {
		return isStarted_;
	}

	public synchronized static void start() {
		if (!isStarted()) {
			isStarted_ = true;
			Factory.startup();
			// Setup the named factories 4 XPages
			Factory.setNamedFactories4XPages(new XPageNamedSessionFactory(false), new XPageNamedSessionFactory(true));
		} else {
			System.out.println("<><><> RED Extension already started!");
		}
	}
	
	public synchronized static void stop() {
		if (isStarted()) {
			Factory.shutdown();
			isStarted_ = false;
		}
	}
	
	public static ThreadConfig getAppThreadConfig(final Application app) {
		return new ThreadConfig();
	}
}
