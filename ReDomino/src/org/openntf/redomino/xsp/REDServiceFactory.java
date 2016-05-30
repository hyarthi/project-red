/**
 * 
 */
package org.openntf.redomino.xsp;

import com.ibm.designer.runtime.domino.adapter.HttpService;
import com.ibm.designer.runtime.domino.adapter.LCDEnvironment;
import org.openntf.domino.xsp.adapter.OpenntfServiceFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class REDServiceFactory extends OpenntfServiceFactory {

	public REDServiceFactory() {
		//System.out.println("Openntf-Factory loaded");
	}

	@Override
	public HttpService[] getServices(final LCDEnvironment paramLCDEnvironment) {
		// We need this for proper XOTS working. But the service does NOTHING
		HttpService[] ret = new HttpService[1];
		ret[0] = new REDHttpService(paramLCDEnvironment);
		//System.out.println("<><><><> Initializzzed RED HTTP service!");
		return ret;
	}

}
