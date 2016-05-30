/**
 * 
 */
package org.openntf.redomino;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * @author Vladimir Kornienko
 *
 */
public class Activator extends Plugin {
	
	public static final String PLUGIN_ID = Activator.class.getPackage().getName();
	public static Activator instance;
	private static String version;

	/**
	 * 
	 */
	public Activator() {
		instance = this;
	}
	
	public static Activator getDefault() {
		return instance;
	}
	
	public static String getVersion() {
		if (version == null) {
			version = (String) instance.getBundle().getHeaders().get("Bundle-Version");
		}
		return version;
	}
	
	public InputStream getResourceAsStream(final String path) throws Exception {
		//BundleContext ctx = getContext();
		Bundle bundle = getBundle();
		URL url = bundle.getEntry(path);
		if (url == null) {
			return null;
		} else {
			InputStream result = url.openStream();
			return result;
		}
	}

	@Override
	public void start(final BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
	}
	
	public void stop(final BundleContext bundleContext) throws Exception {
		super.stop(bundleContext);
	}
}
