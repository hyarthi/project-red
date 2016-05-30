/**
 * 
 */
package org.openntf.redomino.xsp;

import java.util.logging.Logger;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;

import org.openntf.redomino.utils.Factory;
import org.openntf.redomino.utils.Factory.SessionType;
import org.openntf.redomino.xsp.REDExtension;
import org.openntf.domino.xsp.session.XPageCurrentSessionFactory;
import org.openntf.domino.xsp.session.XPageSignerSessionFactory;

import com.ibm.xsp.FacesExceptionEx;
import com.ibm.xsp.context.FacesContextEx;
import com.ibm.xsp.context.FacesContextFactoryImpl;
import com.ibm.xsp.domino.context.DominoFacesContextFactoryImpl;
import com.ibm.xsp.event.FacesContextListener;

/**
 * @author IBM_ADMIN
 *
 */
public class REDFacesContextFactory extends FacesContextFactory {
	@SuppressWarnings("unused")
	private static final Logger log_ = Logger.getLogger(REDFacesContextFactory.class.getName());
	private final FacesContextFactory _delegate;
	private ContextListener _contextListener;

	/**
	 * The contextListener terminates the factory on context-release.
	 */
	public static class ContextListener implements FacesContextListener {
		@Override
		public void beforeContextReleased(final FacesContext arg0) {
			Factory.termThread();
		}

		@Override
		public void beforeRenderingPhase(final FacesContext arg0) {

		}
	}

	public REDFacesContextFactory() {
		Object inst;
		//System.out.println("<><><> Context factory initializing...");
		try {
			@SuppressWarnings("rawtypes")
			Class delegateClass = DominoFacesContextFactoryImpl.class;
			inst = delegateClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FacesExceptionEx(e);
		}
		if (inst instanceof FacesContextFactory) {
			_delegate = (FacesContextFactory) inst;
		} else {
			_delegate = null;
		}
		System.out.println("<><><> Context factory initialized.");
	}

	public REDFacesContextFactory(final FacesContextFactory delegate) {
		if (delegate instanceof FacesContextFactoryImpl) {
			_delegate = ((FacesContextFactoryImpl) delegate).getDelegate();
		} else {
			_delegate = delegate;
		}
	}

	@Override
	public FacesContext getFacesContext(final Object context, final Object request, final Object response, final Lifecycle lifecycle)
			throws FacesException {
		//System.out.println("<><><> Getting RED faces context...");
		FacesContext ctx = _delegate.getFacesContext(context, request, response, lifecycle);

		Factory.initThread(REDExtension.getAppThreadConfig(null));
		Factory.setSessionFactory(new XPageCurrentSessionFactory(), SessionType.CURRENT);
		Factory.setSessionFactory(new XPageSignerSessionFactory(false), SessionType.SIGNER);
		Factory.setSessionFactory(new XPageSignerSessionFactory(true), SessionType.SIGNER_FULL_ACCESS);

		// TODO RPr: This is probably the wrong locale. See ViewHandler.calculateLocale
		Factory.setUserLocale(ctx.getExternalContext().getRequestLocale());
		Factory.setClassLoader(ctx.getContextClassLoader());
		//		NotesContext ntx = NotesContext.getCurrent();

		attachListener((FacesContextEx) ctx);
		//System.out.println("<><><> Got RED faces context.");
		return ctx;
	}

	private void attachListener(final FacesContextEx ctx) {
		if (_contextListener == null)
			_contextListener = new ContextListener();
		ctx.addRequestListener(_contextListener);
	}

}
