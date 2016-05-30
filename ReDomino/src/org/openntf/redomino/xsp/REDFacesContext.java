/**
 * 
 */
package org.openntf.redomino.xsp;

import javax.faces.context.FacesContext;
import org.openntf.domino.xsp.adapter.ODAFacesContext;

/**
 * @author IBM_ADMIN
 *
 */
public class REDFacesContext extends ODAFacesContext {
	public boolean implicitsDone_ = false;

	public REDFacesContext(final FacesContext paramFacesContext) {
		super(paramFacesContext);
		//		System.out.println("DEBUG: Creating new ODAFacesContext " + System.identityHashCode(this));
	}

	@Override
	public void createImplicitObjects() {
		if (!implicitsDone_) {
			super.createImplicitObjects();
			implicitsDone_ = true;
		}
	}

	@Override
	public Object getDynamicImplicitObject(final String objectName) {
		return super.getDynamicImplicitObject(objectName);
	}

}
