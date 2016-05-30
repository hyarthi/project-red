/**
 * 
 */
package org.openntf.redomino.xsp;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import org.openntf.redomino.utils.Factory;

import com.ibm.commons.Platform;
import com.ibm.designer.runtime.domino.adapter.ComponentModule;
import com.ibm.designer.runtime.domino.adapter.HttpService;
import com.ibm.designer.runtime.domino.adapter.LCDEnvironment;
import com.ibm.designer.runtime.domino.bootstrap.adapter.HttpServletRequestAdapter;
import com.ibm.designer.runtime.domino.bootstrap.adapter.HttpServletResponseAdapter;
import com.ibm.designer.runtime.domino.bootstrap.adapter.HttpSessionAdapter;
import com.ibm.domino.xsp.module.nsf.NSFService;

/**
 * @author Vladimir Kornienko
 *
 */
public class REDHttpService extends HttpService {
	private static final Logger log_ = Logger.getLogger(REDHttpService.class.getName());
	private static REDHttpService INSTANCE;
	private static boolean IS_SERVER = Platform.getInstance().isPlatform("Domino");

	public static REDHttpService getCurrentInstance() {
		return INSTANCE;
	}

	public REDHttpService(final LCDEnvironment lcdEnv) {
		super(lcdEnv);

		// TODO: better recognition if we run on server or not
		if (IS_SERVER && System.getSecurityManager() instanceof lotus.notes.AgentSecurityManager) {
			try {
				Factory.printer = new Factory.Printer() {
					@Override
					public void println(final String s) {
						com.ibm.domino.xsp.bridge.http.engine.XspCmdEnvironment.console(s);
					}
				};
			} catch (Exception e) {
				log_.warning("Could not set up console printer");
			}
		}
		System.out.println("<><><><> RED Service loaded");
		try {
			//this.services = lcdEnv.getServices();
			if (INSTANCE != null) {
				log_.severe("There is more than one OpenntfHttpService instance active. This may cause problems.");
			}
			INSTANCE = this;
			// here is the right place to initialize things on server start
			REDExtension.start();
			System.out.println("<><><> Started RED Extension!");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@Override
	public void destroyService() {
		// XotsDaemon.getInstance().stop();
		REDExtension.stop();
		super.destroyService();
		INSTANCE = null;
	}

	private NSFService nsfservice_;

	/**
	 * Method to find the active NSFService
	 * 
	 * @return the NSFService
	 */
	private NSFService getNsfService() {
		if (nsfservice_ == null) {
			for (HttpService service : getEnvironment().getServices()) {
				if (service instanceof NSFService) {
					nsfservice_ = (NSFService) service;
					break;
				}
			}
		}
		return nsfservice_;
	}

	public static NSFService sGetNsfService() {
		return INSTANCE.getNsfService();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.designer.runtime.domino.adapter.HttpService#doService(java.lang.String, java.lang.String,
	 * com.ibm.designer.runtime.domino.bootstrap.adapter.HttpSessionAdapter,
	 * com.ibm.designer.runtime.domino.bootstrap.adapter.HttpServletRequestAdapter,
	 * com.ibm.designer.runtime.domino.bootstrap.adapter.HttpServletResponseAdapter)
	 */
	@Override
	public boolean doService(final String contextPath, final String path, final HttpSessionAdapter httpSession,
			final HttpServletRequestAdapter httpRequest, final HttpServletResponseAdapter httpResponse) throws ServletException,
			IOException {
		Factory.println(this, "DEBUG: The OpenntfHttpService has received an HttpRequest!");
		return false;
	}

	@Override
	public int getPriority() {
		return 1000; // the higher the later this service will queried 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.designer.runtime.domino.adapter.HttpService#getModules(java.util.List)
	 */
	@Override
	public void getModules(final List<ComponentModule> paramList) {

	}

}
