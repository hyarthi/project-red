package org.openntf.redomino.utils;

/*
 * Copyright 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;

import lotus.domino.NotesException;
import lotus.notes.NotesThread;

//import org.openntf.domino.AutoMime;
import org.openntf.domino.Base;
import org.openntf.domino.Database;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Session;
import org.openntf.domino.Session.RunContext;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.exceptions.DataNotCompatibleException;
import org.openntf.domino.exceptions.OpenNTFNotesException;
import org.openntf.domino.exceptions.UndefinedDelegateTypeException;
//import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.graph.DominoGraph;
//import org.openntf.domino.logging.Logging;
import org.openntf.domino.session.INamedSessionFactory;
import org.openntf.domino.session.ISessionFactory;
import org.openntf.domino.session.NamedSessionFactory;
import org.openntf.domino.session.NativeSessionFactory;
import org.openntf.domino.session.SessionFullAccessFactory;
import org.openntf.domino.session.TrustedSessionFactory;
import org.openntf.domino.types.FactorySchema;
import org.openntf.domino.types.SessionDescendant;
import org.openntf.service.IServiceLocator;
import org.openntf.service.ServiceLocatorFinder;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Strings;
//import org.openntf.domino.xsp.ODAPlatform;
//import org.openntf.domino.utils.Factory.SessionType;
import org.openntf.redomino.session.CouchSessionFactory;
import org.openntf.domino.utils.ODAPincher;

/**
 * The Enum Factory. Does the Mapping lotusObject <=> OpenNTF-Object
 */
public enum Factory {
	;

	/**
	 * Printer class (will be modified by XSP-environment), so that the Factory
	 * prints directly to Console (so no "HTTP JVM" Prefix is there)
	 * 
	 * @author Roland Praml, FOCONIS AG
	 * 
	 */
	public static class Printer {
		public void println(final String s) {
			System.out.println(s);
		}
	}

	public static Printer printer = new Printer();

	/**
	 * An identifier for the different session types the factory can create.
	 * 
	 * @author Roland Praml, FOCONIS AG
	 * 
	 */
	public enum SessionType {
		/**
		 * The current session. This means:
		 * 
		 * <ul>
		 * <li>The current XPage session, if you are IN a XPage-Thread. This is
		 * equivalent to the "session" SSJS variable</li>
		 * <li>The current XOTS session, if you are IN a XOTS-Thread. <br>
		 * This is either the session that
		 * {@link XotsTasklet.Interface#getSessionFactory()} can create (if the
		 * Runnable implements that interface and provide a Factory)<br>
		 * or the session, you specified for that runnable with the
		 * {@link XotsTasklet#session()} annotation. See {@link XotsSessionType}
		 * for available types.
		 * </ul>
		 * <b>The Method will fail, if you are running in a wrongly set up
		 * Thread</b><br>
		 * (But there should be only XPage-Threads or XOTS-Threads. TODO RPr:
		 * and maybe DominoTheads)
		 */
		CURRENT(0, "CURRENT"),

		/**
		 * Returns a session with full access. This is a named session (name is
		 * equal to {@link #CURRENT}s session name) but with full access rights.
		 * {@link #FULL_ACCESS} may provide the same session as {@link #CURRENT}
		 * if the Runnable was annotated with a *_FULL_ACCESS
		 * {@link XotsSessionType}
		 */
		CURRENT_FULL_ACCESS(1, "CURRENT_FULL_ACCESS"),

		/**
		 * Returns a named session as signer. The code-signer is either the
		 * server (if the runnable is not inside an NSF) or the signer of that
		 * runnable. <br>
		 * <b>Note 1:</b> This session becomes invalid, if you the classloader
		 * gets tainted by loading classes that are signed by different users!
		 * <br/>
		 * <b>Note 2:</b> Due a bug, we return always SessionAsSigner (@see
		 * http://www.mydominolab.com/2011/10/xpages-sessionassigner.html)
		 */
		SIGNER(2, "SIGNER"),

		/**
		 * This is currently the SAME session as {@link #SIGNER} due a Bug in
		 * XPages.
		 */
		SIGNER_FULL_ACCESS(3, "SIGNER_FULL_ACCESS"),

		/**
		 * Returns a NATIVE session
		 */
		NATIVE(4, "NATIVE"),

		/**
		 * Returns a TRUSTED session (This does not yet work!)
		 */
		TRUSTED(5, "TRUSTED"),

		/**
		 * Returns a Session with full access.
		 */
		FULL_ACCESS(6, "FULL_ACCESS"),

		/**
		 * Returns a Session with full access.
		 */
		PASSWORD(7, "PASSWORD"),

		/**
		 * for internal use only!
		 */
		_NAMED_internal(-1, "NAMED"),

		/**
		 * for internal use only!
		 */
		_NAMED_FULL_ACCESS_internal(-1, "NAMED_FULL_ACCESS"),

		/*
		 * EXTENSION
		 */
		COUCH(8, "COUCH"),;

		public Session get() {
			return Factory.getSession(this);
		}

		static int SIZE = 9;
		int index;
		String alias;

		SessionType(final int index, final String alias) {
			this.index = index;
			this.alias = alias;
		}
		
		private static Map<String, String> ENVIRONMENT;

		/*
		 * EXTENSION
		 */

		public static boolean isCouchSession(final SessionType mode) {
			return mode.index == SessionType.COUCH.index;
		}
		
		public static boolean isCouchSession(final org.openntf.domino.Session session) {
			if (session instanceof org.openntf.redomino.impl.Session) {
				return ((org.openntf.redomino.impl.Session) session).isCouch();
			}
			return false;
		}

		public static org.openntf.domino.utils.Factory.SessionType getAsODASessionType(final SessionType mode) {
			if (mode.alias.equals("CURRENT_FULL_ACCESS"))
				return org.openntf.domino.utils.Factory.SessionType.CURRENT_FULL_ACCESS;
			if (mode.alias.equals("SIGNER"))
				return org.openntf.domino.utils.Factory.SessionType.SIGNER;
			if (mode.alias.equals("SIGNER_FULL_ACCESS"))
				return org.openntf.domino.utils.Factory.SessionType.SIGNER_FULL_ACCESS;
			if (mode.alias.equals("NATIVE"))
				return org.openntf.domino.utils.Factory.SessionType.NATIVE;
			if (mode.alias.equals("TRUSTED"))
				return org.openntf.domino.utils.Factory.SessionType.TRUSTED;
			if (mode.alias.equals("FULL_ACCESS"))
				return org.openntf.domino.utils.Factory.SessionType.FULL_ACCESS;
			if (mode.alias.equals("PASSWORD"))
				return org.openntf.domino.utils.Factory.SessionType.PASSWORD;
			if (mode.alias.equals("NAMED"))
				return org.openntf.domino.utils.Factory.SessionType._NAMED_internal;
			if (mode.alias.equals("NAMED_FULL_ACCESS"))
				return org.openntf.domino.utils.Factory.SessionType._NAMED_FULL_ACCESS_internal;
			if (mode.alias.equals("CURRENT"))
				return org.openntf.domino.utils.Factory.SessionType.CURRENT;
			// failover (temporary)
			return org.openntf.domino.utils.Factory.SessionType.CURRENT;
		}

		public static SessionType getAsREDSessionType(final org.openntf.domino.utils.Factory.SessionType mode) {
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("CURRENT_FULL_ACCESS"))
				return org.openntf.redomino.utils.Factory.SessionType.CURRENT_FULL_ACCESS;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("SIGNER"))
				return org.openntf.redomino.utils.Factory.SessionType.SIGNER;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("SIGNER_FULL_ACCESS"))
				return org.openntf.redomino.utils.Factory.SessionType.SIGNER_FULL_ACCESS;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("NATIVE"))
				return org.openntf.redomino.utils.Factory.SessionType.NATIVE;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("TRUSTED"))
				return org.openntf.redomino.utils.Factory.SessionType.TRUSTED;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("FULL_ACCESS"))
				return org.openntf.redomino.utils.Factory.SessionType.FULL_ACCESS;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("PASSWORD"))
				return org.openntf.redomino.utils.Factory.SessionType.PASSWORD;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("NAMED"))
				return org.openntf.redomino.utils.Factory.SessionType._NAMED_internal;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("NAMED_FULL_ACCESS"))
				return org.openntf.redomino.utils.Factory.SessionType._NAMED_FULL_ACCESS_internal;
			if (ODAPincher.pinchSessionTypeAlias(mode).equals("CURRENT"))
				return org.openntf.redomino.utils.Factory.SessionType.CURRENT;
			// failover (temporary)
			return org.openntf.redomino.utils.Factory.SessionType.CURRENT;
		}
	}

	public static class ThreadConfig {

		public ThreadConfig() {
			super();
		}

	}

	/**
	 * We have so many threadLocals here, so that it is worth to handle them all
	 * in a container class.
	 * 
	 * @author Roland Praml, FOCONIS AG
	 * 
	 */
	private static class ThreadVariables {
		private WrapperFactory wrapperFactory;

		private ClassLoader classLoader;

		private IServiceLocator serviceLocator;

		/**
		 * Support for different Locale
		 */
		private Locale userLocale;

		/** the factories can create a new session */
		public ISessionFactory[] sessionFactories = new ISessionFactory[SessionType.SIZE];

		/** the sessions are stored in the sessionHolder */
		private Session[] sessionHolders = new Session[SessionType.SIZE];

		public INamedSessionFactory namedSessionFactory;
		public INamedSessionFactory namedSessionFullAccessFactory;

		/**
		 * These sessions will be recycled at the end of that thread. Key =
		 * UserName of session
		 */
		public Map<String, Session> ownSessions = new HashMap<String, Session>();

		private List<Runnable> terminateHooks;

		private ThreadConfig threadConfig;

		public ThreadVariables(final ThreadConfig tc) {
			threadConfig = tc;
		}

		/** clear the object */
		private void clear() {
			wrapperFactory = null;
			classLoader = null;
			serviceLocator = null;
			for (int i = 0; i < SessionType.SIZE; i++) {
				sessionHolders[i] = null;
				sessionFactories[i] = null;
			}
			userLocale = null;
			namedSessionFactory = null;
			namedSessionFullAccessFactory = null;

		}

		public void removeTerminateHook(final Runnable hook) {
			if (terminateHooks == null)
				return;
			terminateHooks.remove(hook);

		}

		public void addTerminateHook(final Runnable hook) {
			if (terminateHooks == null) {
				terminateHooks = new ArrayList<Runnable>();
			}
			terminateHooks.add(hook);
		}

		public void terminate() {
			if (terminateHooks != null) {
				for (Runnable hook : terminateHooks) {
					hook.run();
				}
				terminateHooks = null;
			}
		}
	}

	private static ISessionFactory[] defaultSessionFactories = new ISessionFactory[SessionType.SIZE];
	private static INamedSessionFactory defaultNamedSessionFactory;
	private static INamedSessionFactory defaultNamedSessionFullAccessFactory;

	/**
	 * Holder for variables that are different per thread
	 */
	private static ThreadLocal<ThreadVariables> threadVariables_ = new ThreadLocal<ThreadVariables>();

	private static List<Runnable> globalTerminateHooks = new ArrayList<Runnable>();
	private static List<Runnable> shutdownHooks = new ArrayList<Runnable>();

	private static String localServerName;

	private static ThreadVariables getThreadVariables() {
		ThreadVariables tv = threadVariables_.get();
		if (tv == null)
			throw new IllegalStateException(
					org.openntf.redomino.utils.Factory.class.getName() + " is not initialized for this thread!");
		return tv;
	}

	public static ThreadConfig getThreadConfig() {
		ThreadVariables tv = threadVariables_.get();
		if (tv == null)
			return new ThreadConfig();
		return tv.threadConfig;
	}

	// private static Map<String, String> ENVIRONMENT =
	// org.openntf.domino.utils.Factory.gete;

	// private static boolean session_init = false;
	// private static boolean jar_init = false;
	private static boolean started = false;

	public static String getEnvironment(final String key) {
		//return org.openntf.domino.utils.Factory.getEnvironment(key);
		if (null != ENVIRONMENT)
			loadEnvironment(null);
		//System.out.println("<> Getting environment string with key: " + key);
		return ENVIRONMENT.get(key);
	}

	public static String getTitle() {
		return getEnvironment("title");
	}

	public static String getUrl() {
		return getEnvironment("url");
	}

	public static String getVersion() {
		return getEnvironment("version");
	}

	public static String getDataPath() {
		return getEnvironment("directory");
	}

	public static String getProgramPath() {
		return getEnvironment("notesprogram");
	}

	public static String getHTTPJVMHeapSize() {
		return getEnvironment("httpjvmheapsize");
	}

	/** The Constant log_. */
	private static final Logger log_ = Logger.getLogger(Factory.class.getName());

	public static void enableCounters(final boolean enable, final boolean perThread) {
		org.openntf.domino.utils.Factory.enableCounters(enable, perThread);
	}

	/**
	 * Gets the lotus count.
	 * 
	 * @return the lotus count
	 */
	public static int getLotusCount() {
		return org.openntf.domino.utils.Factory.getLotusCount();
	}

	/**
	 * Count a created lotus element.
	 */
	public static void countLotus(final Class<?> c) {
		org.openntf.domino.utils.Factory.countLotus(c);
	}

	/**
	 * Gets the recycle error count.
	 * 
	 * @return the recycle error count
	 */
	public static int getRecycleErrorCount() {
		return org.openntf.domino.utils.Factory.getRecycleErrorCount();
	}

	/**
	 * Count recycle error.
	 */
	public static void countRecycleError(final Class<?> c) {
		org.openntf.domino.utils.Factory.countRecycleError(c);
	}

	/**
	 * Gets the auto recycle count.
	 * 
	 * @return the auto recycle count
	 */
	public static int getAutoRecycleCount() {
		return org.openntf.domino.utils.Factory.getAutoRecycleCount();
	}

	/**
	 * Count auto recycle.
	 * 
	 * @return the int
	 */
	public static int countAutoRecycle(final Class<?> c) {
		return org.openntf.domino.utils.Factory.countAutoRecycle(c);
	}

	/**
	 * Gets the manual recycle count.
	 * 
	 * @return the manual recycle count
	 */
	public static int getManualRecycleCount() {
		return org.openntf.domino.utils.Factory.getManualRecycleCount();
	}

	/**
	 * Count a manual recycle
	 */
	public static int countManualRecycle(final Class<?> c) {
		return org.openntf.domino.utils.Factory.countManualRecycle(c);
	}

	/**
	 * get the active object count
	 * 
	 * @return The current active object count
	 */
	public static int getActiveObjectCount() {
		return org.openntf.domino.utils.Factory.getActiveObjectCount();
	}

	/**
	 * Determine the run context where we are
	 * 
	 * @return The active RunContext
	 */
	public static RunContext getRunContext() {
		// TODO finish this implementation, which needs a lot of work.
		// - ADDIN
		// - APPLET
		// - DIIOP
		// - DOTS
		// - PLUGIN
		// - SERVLET
		// - XPAGES_NSF
		// maybe a simple way to determine => create a Throwable and look into
		// the stack trace
		RunContext result = RunContext.UNKNOWN;
		SecurityManager sm = System.getSecurityManager();
		if (sm == null)
			return RunContext.CLI;

		Object o = sm.getSecurityContext();
		if (log_.isLoggable(Level.INFO))
			log_.log(Level.INFO,
					"SecurityManager is " + sm.getClass().getName() + " and context is " + o.getClass().getName());
		if (sm instanceof lotus.notes.AgentSecurityManager) {
			lotus.notes.AgentSecurityManager asm = (lotus.notes.AgentSecurityManager) sm;
			Object xsm = asm.getExtenderSecurityContext();
			if (xsm instanceof lotus.notes.AgentSecurityContext) {
			}
			Object asc = asm.getSecurityContext();
			if (asc != null) {
				// System.out.println("Security context is " +
				// asc.getClass().getName());
			}
			// ThreadGroup tg = asm.getThreadGroup();
			// System.out.println("ThreadGroup name: " + tg.getName());

			result = RunContext.AGENT;
		}
		// com.ibm.domino.http.bootstrap.logger.RCPLoggerConfig rcplc;
		try {
			Class<?> BCLClass = Class.forName("com.ibm.domino.http.bootstrap.BootstrapClassLoader");
			if (BCLClass != null) {
				ClassLoader cl = (ClassLoader) BCLClass.getMethod("getSharedClassLoader").invoke(null);
				if ("com.ibm.domino.http.bootstrap.BootstrapOSGIClassLoader".equals(cl.getClass().getName())) {
					result = RunContext.XPAGES_OSGI;
				}
			}
		} catch (Exception e) {

		}

		return result;
	}

	private static WrapperFactory DEFAULT_WRAPPER_FACTORY = new org.openntf.redomino.impl.WrapperFactory();

	/**
	 * returns the wrapper factory for this thread
	 * 
	 * @return the thread's wrapper factory
	 */
	public static WrapperFactory getWrapperFactory() {
		ThreadVariables tv = getThreadVariables();
		WrapperFactory wf = tv.wrapperFactory;
		if (wf == null) {
			try {
				List<WrapperFactory> wfList = findApplicationServices(WrapperFactory.class);
				if (wfList.size() > 0)
					wf = wfList.get(0);
				else
					wf = DEFAULT_WRAPPER_FACTORY;
			} catch (Throwable t) {
				log_.log(Level.WARNING, "Getting default WrapperFactory", t);
				wf = DEFAULT_WRAPPER_FACTORY;
			}
			tv.wrapperFactory = wf;
		}
		return wf;
	}

	/**
	 * Returns the wrapper factory if initialized
	 * 
	 * @return The active WrapperFactory
	 */
	public static WrapperFactory getWrapperFactory_unchecked() {
		ThreadVariables tv = threadVariables_.get();
		return tv == null ? null : threadVariables_.get().wrapperFactory;
	}

	// RPr: A setter is normally not needed. The wrapperFactory should be
	// configure with an application service!
	// /**
	// * Set/changes the wrapperFactory for this thread
	// *
	// * @param wf
	// * The new WrapperFactory
	// */
	// public static void setWrapperFactory(final WrapperFactory wf) {
	// currentWrapperFactory.set(wf);
	// }

	// --- session handling

	// @SuppressWarnings("rawtypes")
	// @Deprecated
	// public static org.openntf.domino.Document fromLotusDocument(final
	// lotus.domino.Document lotus, final Base parent) {
	// return getWrapperFactory().fromLotus(lotus, Document.SCHEMA, (Database)
	// parent);
	// }

	// This should not be needed any more
	// public static void setNoRecycle(final Base<?> base, final boolean value)
	// {
	// getWrapperFactory().setNoRecycle(base, value);
	// }

	/*
	 * (non-JavaDoc)
	 * 
	 * @see org.openntf.domino.WrapperFactory#fromLotus(lotus.domino.Base,
	 * FactorySchema, Base)
	 */
	/**
	 * @deprecated Use
	 *             {@link WrapperFactory#fromLotus(lotus.domino.Base, FactorySchema, Base)}
	 *             instead.
	 */
	@Deprecated
	@SuppressWarnings("rawtypes")
	public static <T extends Base, D extends lotus.domino.Base, P extends Base> T fromLotus(final D lotus,
			final FactorySchema<T, D, P> schema, final P parent) {
		T result = getWrapperFactory().fromLotus(lotus, schema, parent);

		// if (result instanceof org.openntf.domino.Session) {
		// ThreadVariables tv = getThreadVariables();
		// org.openntf.domino.Session check =
		// tv.sessionHolders[SessionType.CURRENT.index];
		// if (check == null) {
		// // TODO RPr: I have really objections to this.
		// // Setting the first session as default session is NOT nice
		// log_.log(Level.WARNING, "WARNING! Setting the Session " + result
		// + " as CURRENT session. This means you run in a wrong initialized
		// thread", new Throwable());
		// setSession((org.openntf.domino.Session) result, SessionType.CURRENT);
		// }
		// }
		return result;
	}

	// RPr: Should be done directly to current wrapperFactory
	// public static boolean recacheLotus(final lotus.domino.Base lotus, final
	// Base<?> wrapper, final Base<?> parent) {
	// return getWrapperFactory().recacheLotusObject(lotus, wrapper, parent);
	// }

	/**
	 * From lotus wraps a given lotus collection in an org.openntf.domino
	 * collection
	 * 
	 * @param <T>
	 *            the generic org.openntf.domino type (drapper)
	 * @param <D>
	 *            the generic lotus.domino type (delegate)
	 * @param <P>
	 *            the generic org.openntf.domino type (parent)
	 * @param lotus
	 *            the object to wrap
	 * @param schema
	 *            the generic schema to ensure type safeness (may be null)
	 * @param parent
	 *            the parent
	 * @return the wrapped object
	 * @deprecated Use
	 *             {@link WrapperFactory#fromLotus(Collection, FactorySchema, Base)}
	 *             instead.
	 */
	@SuppressWarnings({ "rawtypes" })
	@Deprecated
	public static <T extends Base, D extends lotus.domino.Base, P extends Base> Collection<T> fromLotus(
			final Collection<?> lotusColl, final FactorySchema<T, D, P> schema, final P parent) {
		return getWrapperFactory().fromLotus(lotusColl, schema, parent);
	}

	/**
	 * From lotus wraps a given lotus collection in an org.openntf.domino
	 * collection
	 * 
	 * @param <T>
	 *            the generic org.openntf.domino type (wrapper)
	 * @param <D>
	 *            the generic lotus.domino type (delegate)
	 * @param <P>
	 *            the generic org.openntf.domino type (parent)
	 * @param lotus
	 *            the object to wrap
	 * @param schema
	 *            the generic schema to ensure type safeness (may be null)
	 * @param parent
	 *            the parent
	 * @return the wrapped object
	 * @deprecated Use
	 *             {@link WrapperFactory#fromLotusAsVector(Collection, FactorySchema, Base)}
	 *             instead.
	 */
	@Deprecated
	@SuppressWarnings("rawtypes")
	public static <T extends Base, D extends lotus.domino.Base, P extends Base> Vector<T> fromLotusAsVector(
			final Collection<?> lotusColl, final FactorySchema<T, D, P> schema, final P parent) {
		return getWrapperFactory().fromLotusAsVector(lotusColl, schema, parent);
	}

	// RPr: Deprecated, so I commented this out
	// /**
	// * From lotus.
	// *
	// * @deprecated Use {@link #fromLotus(lotus.domino.Base, FactorySchema,
	// Base)} instead
	// *
	// *
	// * @param <T>
	// * the generic type
	// * @param lotus
	// * the lotus
	// * @param T
	// * the t
	// * @param parent
	// * the parent
	// * @return the t
	// */
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @Deprecated
	// public static <T> T fromLotus(final lotus.domino.Base lotus, final
	// Class<? extends Base> T, final Base parent) {
	// return (T) getWrapperFactory().fromLotus(lotus, (FactorySchema) null,
	// parent);
	// }
	//
	// /**
	// * From lotus.
	// *
	// * @deprecated Use {@link #fromLotus(Collection, FactorySchema, Base)}
	// instead
	// *
	// * @param <T>
	// * the generic type
	// * @param lotusColl
	// * the lotus coll
	// * @param T
	// * the t
	// * @param parent
	// * the parent
	// * @return the collection
	// */
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// @Deprecated
	// public static <T> Collection<T> fromLotus(final Collection<?> lotusColl,
	// final Class<? extends Base> T, final Base<?> parent) {
	// return getWrapperFactory().fromLotus(lotusColl, (FactorySchema) null,
	// parent);
	// }
	//
	// /**
	// * @deprecated Use {@link #fromLotusAsVector(Collection, FactorySchema,
	// Base)}
	// */
	// @Deprecated
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// public static <T> Vector<T> fromLotusAsVector(final Collection<?>
	// lotusColl, final Class<? extends org.openntf.domino.Base> T,
	// final org.openntf.domino.Base<?> parent) {
	// return getWrapperFactory().fromLotusAsVector(lotusColl, (FactorySchema)
	// null, parent);
	// }

	/**
	 * Wrap column values, encapsulating {@link lotus.domino.DateTime}s,
	 * {@link lotus.domino.DateRange}s, and {@link lotus.domino.Name}s.
	 * 
	 * @param values
	 *            the values
	 * @return a {@link java.util.Vector} with the objects from the collection
	 *         appropriately wrapped.
	 * @deprecated Use
	 *             {@link WrapperFactory#wrapColumnValues(Collection, Session)}
	 *             instead.
	 */
	@Deprecated
	public static java.util.Vector<Object> wrapColumnValues(final Collection<?> values,
			final org.openntf.domino.Session session) {
		if (values == null) {
			log_.log(Level.WARNING, "Request to wrapColumnValues for a collection of null");
			return null;
		}
		return getWrapperFactory().wrapColumnValues(values, session);
	}

	/**
	 * Method to unwrap a object
	 * 
	 * @param the
	 *            object to unwrap
	 * @return the unwrapped object
	 * @deprecated Use
	 *             {@link WrapperFactory#fromLotus(lotus.domino.Base, FactorySchema, Base)}
	 *             instead.
	 */
	@Deprecated
	public static <T extends lotus.domino.Base> T toLotus(final T base) {
		return getWrapperFactory().toLotus(base);
	}

	/**
	 * Gets the current session. Equivalent to calling
	 * {@link #getSession(SessionType)} with {@link SessionType.CURRENT}.
	 * 
	 * @return the session
	 */
	public static org.openntf.domino.Session getSession() {
		return getSession(SessionType.CURRENT);
	}

	/**
	 * Gets the session full access.
	 * 
	 * @return the session full access
	 * @deprecated Use {@link #getSession(SessionType)} with
	 *             {@link SessionType.FULL_ACCESS} instead.
	 */
	@Deprecated
	public static org.openntf.domino.Session getSessionFullAccess() {
		return getSession(SessionType.FULL_ACCESS);
	}

	/**
	 * Gets the trusted session.
	 * 
	 * @return the trusted session
	 * @deprecated Use {@link #getSession(SessionType)} with
	 *             {@link SessionType.TRUSTED} instead.
	 */
	@Deprecated
	public static org.openntf.domino.Session getTrustedSession() {
		return getSession(SessionType.TRUSTED);
	}

	/**
	 * Gets the trusted session.
	 * 
	 * @return the trusted session
	 * @deprecated Use {@link #getSession(SessionType)} with
	 *             {@link SessionType.SIGNER} instead.
	 */
	@Deprecated
	public static org.openntf.domino.Session getSessionAsSigner() {
		return getSession(SessionType.SIGNER);
	}

	public static org.openntf.domino.Session getSession(final SessionType mode, final String paramString) {
		ThreadVariables tv = getThreadVariables();
		org.openntf.domino.Session result = tv.sessionHolders[mode.index];
		if (SessionType.isCouchSession(mode)) {
			return result;
		} else {
			return org.openntf.domino.utils.Factory.getSession(SessionType.getAsODASessionType(mode), paramString);
		}
	}

	/**
	 * 
	 * @param mode
	 *            The type of session to create
	 * @return A Session object corresponding to the given type
	 */
	public static org.openntf.domino.Session getSession(final SessionType mode) {
		//System.out.println("<><><><><> started getSession(SessionType)...");
		ThreadVariables tv = getThreadVariables();
		org.openntf.domino.Session result = tv.sessionHolders[mode.index];
		//System.out.println("<><><><><> Couch session? : " + SessionType.isCouchSession(mode));
		if (SessionType.isCouchSession(mode)) {
			//System.out.println("<><><><><> It's a couch session!");
			if (result == null || result.isDead()) {
//				System.out.println("TEMP DEBUG: No session found of type " + mode.name() + " in thread "
//						+ System.identityHashCode(Thread.currentThread()) + " from TV " + System.identityHashCode(tv));

				CouchSessionFactory sf = (CouchSessionFactory) getSessionFactory(mode);
				if (sf != null) {
					//System.out.println("<><><><><> Creating session...");
					result = sf.createSession();
					//System.out.println("<><><><><> Session type is: " + mode.alias);
					((org.openntf.redomino.impl.Session) result).setSessionType(mode);
					tv.sessionHolders[mode.index] = result;
					tv.ownSessions.put(mode.alias, result);

					// spawn CURRENT session just in case
					Session currentChk = tv.sessionHolders[SessionType.CURRENT.index];
					if (currentChk == null) {
						ISessionFactory curfactory = getSessionFactory(SessionType.CURRENT);
						Session cursession = curfactory.createSession();
						//cursession.setSessionType(SessionType.getAsODASessionType(SessionType.CURRENT));

						tv.sessionHolders[SessionType.CURRENT.index] = cursession;
						tv.ownSessions.put(SessionType.CURRENT.alias, result);
					}
//					System.out
//							.println("TEMP DEBUG: Created new session " + System.identityHashCode(result) + " of type "
//									+ mode.name() + " in thread " + System.identityHashCode(Thread.currentThread())
//									+ " from TV " + System.identityHashCode(tv));
				} //else {
//					System.out.println("<><><><><> No session factory!");
//				}
				if (result == null) {
					//System.out.println("<><><><><> No session!");
					log_.severe("Unable to get the session of type " + mode.alias
							+ ". This probably means that you are running in an unsupported configuration "
							+ "or you forgot to set up your context at the start of the operation. "
							+ "If you're running in XPages, check the xsp.properties of your database. "
							+ "If you are running in an Agent, make sure you start with a call to "
							+ "Factory.setSession() and pass in your lotus.domino.Session");
				}
			} else {
//				System.out.println("TEMP DEBUG: Found an existing session " + System.identityHashCode(result)
//						+ " of type " + mode.name() + " in thread " + System.identityHashCode(Thread.currentThread())
//						+ " from TV " + System.identityHashCode(tv));
			}
			return result;
		} else {
			return org.openntf.domino.utils.Factory.getSession(SessionType.getAsODASessionType(mode));
		}
	}

	/**
	 * Returns the current session, if available. Does never create a session
	 * 
	 * @return the session
	 */
	public static org.openntf.domino.Session getSession_unchecked(final SessionType type) {
		ThreadVariables tv = threadVariables_.get();
		return tv == null ? null : tv.sessionHolders[type.index];
	}

	/**
	 * Sets the session for a certain sessionMode
	 * 
	 */
	// public static void setSession(final lotus.domino.Session session, final
	// SessionType mode) {
	// if (session instanceof org.openntf.domino.Session) {
	// getThreadVariables().sessionHolders[mode.index] =
	// (org.openntf.domino.Session) session;
	// // throw new UnsupportedOperationException("You should not set an
	// org.openntf.domino.session as Session");
	// } else {
	// getThreadVariables().sessionHolders[mode.index] = fromLotus(session,
	// Session.SCHEMA, null);
	// }
	// }

	public static void setSessionFactory(final ISessionFactory sessionFactory, final SessionType mode) {
		getThreadVariables().sessionFactories[mode.index] = sessionFactory;
	}

	public static ISessionFactory getSessionFactory(final SessionType mode) {
		ThreadVariables tv = threadVariables_.get();
		if (tv == null || tv.sessionFactories[mode.index] == null) {
			return defaultSessionFactories[mode.index];
		}
		return tv.sessionFactories[mode.index];
	}

	/**
	 * // * Sets the current session // * // * @param session // * the lotus
	 * session //
	 */
	// public static void setSession(final lotus.domino.Session session) {
	// setSession(session, SessionType.DEFAULT);
	// }
	//
	// /**
	// * Sets the current trusted session
	// *
	// * @param session
	// * the lotus session
	// */
	// public static void setTrustedSession(final lotus.domino.Session session)
	// {
	// setSession(session, SessionType.TRUSTED);
	// }
	//
	// /**
	// * Sets the current session with full access
	// *
	// * @param session
	// * the lotus session
	// */
	// public static void setSessionFullAccess(final lotus.domino.Session
	// session) {
	// setSession(session, SessionType.FULL_ACCESS);
	// }

	// /**
	// * clears the current session
	// */
	// public static void clearSession() {
	// threadVariables.get().sessionHolder = null;
	// }

	// TODO: Determine if this is the right way to deal with Xots access to
	// faces contexts

	// RPr: use getSession_unchecked().getCurrentDatabase
	// /**
	// * Returns the session's current database if available. Does never create
	// a session.
	// *
	// * @see #getSession_unchecked()
	// * @return The session's current database
	// */
	// public static Database getDatabase_unchecked() {
	// Session sess = getSession_unchecked(SessionType.CURRENT);
	// return (sess == null) ? null : sess.getCurrentDatabase();
	// }

	// RPr: I think it is a better idea to set the currentDatabase on the
	// currentSesssion

	// TODO remove that code
	// public static void setDatabase(final Database database) {
	// setNoRecycle(database, true);
	// currentDatabaseHolder_.set(database);
	// }
	//
	// public static void clearDatabase() {
	// currentDatabaseHolder_.set(null);
	// }

	public static ClassLoader getClassLoader() {
		ThreadVariables tv = getThreadVariables();
		if (tv.classLoader == null) {
			ClassLoader loader = null;
			try {
				loader = AccessController.doPrivileged(new PrivilegedExceptionAction<ClassLoader>() {
					@Override
					public ClassLoader run() throws Exception {
						return Thread.currentThread().getContextClassLoader();
					}
				});
			} catch (AccessControlException e) {
				e.printStackTrace();
			} catch (PrivilegedActionException e) {
				e.printStackTrace();
			}
			setClassLoader(loader);
		}
		return tv.classLoader;
	}

	public static <T> List<T> findApplicationServices(final Class<T> serviceClazz) {

		ThreadVariables tv = getThreadVariables();

		if (tv.serviceLocator == null) {
			tv.serviceLocator = ServiceLocatorFinder.findServiceLocator();
		}
		if (tv.serviceLocator == null) {
			throw new IllegalStateException(
					"No service locator available so we cannot find the application services for "
							+ serviceClazz.getName());
		}

		return tv.serviceLocator.findApplicationServices(serviceClazz);
	}

	public static void setClassLoader(final ClassLoader loader) {
		getThreadVariables().classLoader = loader;
	}

	// avoid clear methods
	// public static void clearWrapperFactory() {
	// currentWrapperFactory.remove();
	// }
	//
	// public static void clearClassLoader() {
	// currentClassLoader_.remove();
	// }
	//
	// public static void clearServiceLocator() {
	// currentServiceLocator_.remove();
	// }
	//
	// public static void clearDominoGraph() {
	// DominoGraph.clearDocumentCache();
	// }
	//
	// public static void clearNoteCoordinateBuffer() {
	// NoteCoordinate.clearLocals();
	// }
	//
	// public static void clearBubbleExceptions() {
	// DominoUtils.setBubbleExceptions(null);
	// }

	/**
	 * Begin with a clear environment. Initialize this thread
	 * 
	 */
	public static void initThread(final ThreadConfig tc) { // RPr: Method was
															// deliberately
															// renamed
		System.out.println("<><><> Initializing Factory thread...");
		if (!started) {
			throw new IllegalStateException("Factory is not yet started");
		}
		if (log_.isLoggable(Level.FINER)) {
			log_.log(Level.FINER, "Factory.initThread()", new Throwable());
		}
		if (threadVariables_.get() != null) {
			log_.log(Level.SEVERE, "WARNING - Thread " + Thread.currentThread().getName()
					+ " was not correctly terminated or initialized twice", new Throwable());
		}
		// System.out.println("TEMP DEBUG: Factory thread initializing.");
		// Throwable t = new Throwable();
		// t.printStackTrace();
		threadVariables_.set(new ThreadVariables(tc));
		System.out.println("<><><> Factory thread initialized.");
		System.out.println("<><><> ThreadConfig is: " + tc.toString());
		System.out.println("<><><> ThreadVariables is: " + threadVariables_.toString());
	}

	/**
	 * terminate the current thread.
	 */
	public static void termThread() { // RPr: Method was deliberately renamed
		if (log_.isLoggable(Level.FINER)) {
			log_.log(Level.FINER, "Factory.termThread()", new Throwable());
		}
		ThreadVariables tv = threadVariables_.get();
		if (tv == null) {
			log_.log(Level.SEVERE, "WARNING - Thread " + Thread.currentThread().getName()
					+ " was not correctly initalized or terminated twice", new Throwable());
			return;
		}
		// System.out.println("TEMP DEBUG: Factory thread terminating.");
		// Throwable trace = new Throwable();
		// trace.printStackTrace();
		try {

			for (Runnable term : globalTerminateHooks) {
				term.run();
			}
			tv.terminate();
			if (tv.wrapperFactory != null) {
				tv.wrapperFactory.recycle();
			}
			// System.out.println("DEBUG: cleared " + termCount + " references
			// from the queue...");
			DominoUtils.setBubbleExceptions(null);
			DominoGraph.clearDocumentCache();
			// The last step is to recycle ALL own sessions
			for (Session sess : tv.ownSessions.values()) {
				if (sess != null) {
					sess.recycle();
				}
			}
		} catch (Throwable t) {
			log_.log(Level.SEVERE, "An error occured while terminating the factory", t);
		} finally {
			tv.clear();
			threadVariables_.set(null);
			System.gc();
		}
		// if (counters != null) {
		// System.out.println(dumpCounters(true));
		// }
	}

	public static void startup() {

		synchronized (Factory.class) {

			NotesThread.sinitThread();
			try {
				lotus.domino.Session sess = lotus.domino.NotesFactory.createSession();
				try {
					startup(sess);
				} finally {
					sess.recycle();
				}
			} catch (NotesException e) {
				e.printStackTrace();
			} finally {
				NotesThread.stermThread();
			}
		}
	}

	public static synchronized void startup(final lotus.domino.Session session) {
		if (session instanceof org.openntf.domino.Session) {
			throw new UnsupportedOperationException(
					"Initialization must be done on the raw session! How did you get that session?");
		}
		if (started) {
			Factory.println("OpenNTF ReDomino is already started. Cannot start it again");
		}
		
		File iniFile;
		try {
			org.openntf.domino.Session sess = org.openntf.domino.utils.Factory.getSession();
			localServerName = sess.getUserName();
			iniFile = new File(sess.evaluate("@ConfigFile").get(0).toString());
		} catch (Exception e) {
			Factory.println("WARNING: @ConfigFile returned " + e.getMessage() + " Using fallback to locate notes.ini");
			iniFile = getConfigFileFallback();
		}

		Factory.println("Starting the OpenNTF Domino API... Using notes.ini: " + iniFile);

		try {
			Scanner scanner = new Scanner(iniFile);
			scanner.useDelimiter("\n|\r\n");
			loadEnvironment(scanner);
			scanner.close();
		} catch (FileNotFoundException e) {
			Factory.println("Cannot read notes.ini. Giving up");
			e.printStackTrace();
		}

		/*
		 * MODIFIED
		 */
		initializeCouchServerList();

		// There is NO(!) Default SessionFactory for the current session. you
		// have to set it!
		defaultSessionFactories[SessionType.CURRENT.index] = null;

		// For CURRENT_FULL_ACCESS, we return a named session with full access =
		// true
		defaultSessionFactories[SessionType.CURRENT_FULL_ACCESS.index] = new ISessionFactory() {
			private static final long serialVersionUID = 1L;

			private String getName() {
				return Factory.getSession(SessionType.CURRENT).getEffectiveUserName();
			}

			@Override
			public Session createSession() {
				return Factory.getNamedSession(getName(), true);
			}
		};

		String defaultApiPath = null; // maybe we set this to ODA.nsf

		// In XPages environment, these factories will be replaced
		defaultNamedSessionFactory = new NamedSessionFactory(defaultApiPath);
		defaultNamedSessionFullAccessFactory = new SessionFullAccessFactory(defaultApiPath);
		defaultSessionFactories[SessionType.SIGNER.index] = new NativeSessionFactory(defaultApiPath);
		defaultSessionFactories[SessionType.SIGNER_FULL_ACCESS.index] = new SessionFullAccessFactory(defaultApiPath);

		// This will ALWAYS return the native/trusted/full access session (not
		// overridden in XPages)
		defaultSessionFactories[SessionType.NATIVE.index] = new NativeSessionFactory(defaultApiPath);
		defaultSessionFactories[SessionType.TRUSTED.index] = new TrustedSessionFactory(defaultApiPath);
		defaultSessionFactories[SessionType.FULL_ACCESS.index] = new SessionFullAccessFactory(defaultApiPath);
		/*
		 * MODIFIED
		 */
		defaultSessionFactories[SessionType.COUCH.index] = new CouchSessionFactory(defaultApiPath);

		started = true;

		Factory.println(
				"RED Extension Version " + org.openntf.redomino.utils.Factory.getEnvironment("version") + " started");

		// Start up logging
//		try {
//			AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
//				@Override
//				public Object run() throws Exception {
//					Logging.getInstance().startUp();
//					return null;
//				}
//			});
//		} catch (AccessControlException e) {
//			e.printStackTrace();
//		} catch (PrivilegedActionException e) {
//			e.printStackTrace();
//		}
	}
	
	private static File getConfigFileFallback() {
		String progpath = System.getProperty("notes.binary");
		File iniFile = new File(progpath + System.getProperty("file.separator") + "notes.ini");
		if (!iniFile.exists()) {
			//							System.out.println("Inifile not found on notes.binary path: " + progpath);
			progpath = System.getProperty("user.dir");
			iniFile = new File(progpath + System.getProperty("file.separator") + "notes.ini");
		}
		if (!iniFile.exists()) {
			//							System.out.println("Inifile not found on notes.binary path: " + progpath);
			progpath = System.getProperty("java.home");
			if (progpath.endsWith("jvm")) {
				iniFile = new File(progpath + System.getProperty("file.separator") + ".." + System.getProperty("file.separator")
						+ "notes.ini");
			} else {
				iniFile = new File(progpath + System.getProperty("file.separator") + "notes.ini");

			}
		}
		if (!iniFile.exists()) {
			progpath = System.getProperty("java.library.path"); // Otherwise the tests will not work
			iniFile = new File(progpath + System.getProperty("file.separator") + "notes.ini");
		}
		if (!iniFile.exists()) {
			//							System.out.println("Inifile still not found on user.dir path: " + progpath);
			if (progpath.contains("framework")) {
				String pp2 = progpath.replace("framework", "");
				iniFile = new File(pp2 + "notes.ini");
				//								System.out.println("Attempting to use path: " + pp2);
				if (!iniFile.exists()) {
					Factory.println("WARNING: Unable to read environment for log setup. Please look at the following properties...");
					for (Object rawName : System.getProperties().keySet()) {
						if (rawName instanceof String) {
							Factory.println((String) rawName + " = " + System.getProperty((String) rawName));
						}
					}
				}
			}
		}
		return iniFile;
	}
	
	private static Map<String, String> ENVIRONMENT;
	
	private static void loadEnvironment(final Scanner scanner) {
		if (ENVIRONMENT == null) {
			ENVIRONMENT = new HashMap<String, String>();
		}
		if (scanner != null) {
			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				int i = nextLine.indexOf('=');
				if (i > 0) {
					String key = nextLine.substring(0, i).toLowerCase();
					String value = nextLine.substring(i + 1);
					ENVIRONMENT.put(key, value);
				}
			}
		}
		try {
			AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
				@Override
				public Object run() throws Exception {
					try {
						ClassLoader cl = Factory.class.getClassLoader();
						// we MUST use the Factory-classloader to find the correct MANIFEST
						Enumeration<URL> resources = cl.getResources("META-INF/MANIFEST.MF");
						while (resources.hasMoreElements()) {

							Manifest manifest = new Manifest(resources.nextElement().openStream());
							// check that this is your manifest and do what you need or get the next one
							Attributes attrib = manifest.getMainAttributes();

							String bundleName = attrib.getValue("Bundle-SymbolicName");
							if (bundleName != null) {
								int pos;
								if ((pos = bundleName.indexOf(';')) != -1) {
									bundleName = bundleName.substring(0, pos);
								}
								if ("org.openntf.domino".equals(bundleName)) {
									ENVIRONMENT.put("version", attrib.getValue("Bundle-Version"));
									ENVIRONMENT.put("title", attrib.getValue("Implementation-Title"));
									ENVIRONMENT.put("url", attrib.getValue("Implementation-Vendor-URL"));
									return null;
								}
							}

						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			});
		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (PrivilegedActionException e) {
			e.printStackTrace();
		}
		if (!ENVIRONMENT.containsKey("version")) {
			ENVIRONMENT.put("version", "0.0.0.unknown");
		}
	}

	public static void setNamedFactories4XPages(final INamedSessionFactory normal,
			final INamedSessionFactory fullaccess) {
		defaultNamedSessionFactory = normal;
		defaultNamedSessionFullAccessFactory = fullaccess;

	}

	public static synchronized void shutdown() {
		Factory.println("Shutting down the OpenNTF Domino API... ");
		Runnable[] copy = shutdownHooks.toArray(new Runnable[shutdownHooks.size()]);
		for (Runnable term : copy) {
			try {
				term.run();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		Factory.println("OpenNTF Domino API shut down");
		started = false;
	}

	public static boolean isStarted() {
		return started;
	}

	public static boolean isInitialized() {
		return threadVariables_.get() != null;
	}

	public static void setUserLocale(final Locale loc) {
		getThreadVariables().userLocale = loc;
	}

	public static Locale getUserLocale() {
		return getThreadVariables().userLocale;
	}

	/**
	 * Returns the internal locale. The Locale is retrieved by this way:
	 * <ul>
	 * <li>If a currentDatabase is set, the DB is queried for its locale</li>
	 * <li>If there is no database.locale, the system default locale is returned
	 * </li>
	 * </ul>
	 * This locale should be used, if you write log entries in a server log for
	 * example.
	 * 
	 * @return the currentDatabase-locale or default-locale
	 */
	public static Locale getInternalLocale() {
		Locale ret = null;
		// are we in context of an NotesSession? Try to figure out the current
		// database.
		Session sess = getSession_unchecked(SessionType.CURRENT);
		Database db = (sess == null) ? null : sess.getCurrentDatabase();
		if (db != null)
			ret = db.getLocale();
		if (ret == null)
			ret = Locale.getDefault();
		return ret;
	}

	/**
	 * Returns the external locale. The Locale is retrieved by this way:
	 * <ul>
	 * <li>Return the external locale (= the browser's locale in most cases) if
	 * available</li>
	 * <li>If a currentDatabase is set, the DB is queried for its locale</li>
	 * <li>If there is no database.locale, the system default locale is returned
	 * </li>
	 * </ul>
	 * This locale should be used, if you generate messages for the current
	 * (browser)user.
	 * 
	 * @return the external-locale, currentDatabase-locale or default-locale
	 */
	public static Locale getExternalLocale() {
		Locale ret = getUserLocale();
		if (ret == null)
			ret = getInternalLocale();
		return ret;
	}

	/**
	 * Debug method to get statistics
	 * 
	 */
	public static String dumpCounters(final boolean details) {
		return org.openntf.domino.utils.Factory.dumpCounters(details);
	}

	public static INamedSessionFactory getNamedSessionFactory(final boolean fullAccess) {
		ThreadVariables tv = getThreadVariables();
		if (fullAccess) {
			return tv.namedSessionFullAccessFactory != null ? tv.namedSessionFullAccessFactory
					: defaultNamedSessionFullAccessFactory;
		} else {
			return tv.namedSessionFactory != null ? tv.namedSessionFactory : defaultNamedSessionFactory;
		}

	}

	/*
	 * MODIFIED
	 */
	public static org.openntf.domino.Session getNamedSession(final String name, final boolean fullAccess) {
		// ThreadVariables tv = getThreadVariables();
		// String key = name.toLowerCase() + (fullAccess ? ":full" : ":normal");
		// Session sess = tv.ownSessions.get(key);
		// if (sess == null || sess.isDead()) {
		// INamedSessionFactory sf = getNamedSessionFactory(fullAccess);
		// if (sf != null) {
		// sess = sf.createSession(name);
		// sess.setSessionType(
		// fullAccess ?
		// org.openntf.domino.utils.Factory.SessionType._NAMED_FULL_ACCESS_internal
		// : org.openntf.domino.utils.Factory.SessionType._NAMED_internal);
		// }
		// tv.ownSessions.put(key, sess);
		// }
		// return sess;
		return org.openntf.domino.utils.Factory.getNamedSession(name, fullAccess);
	}

	/**
	 * Gets the session.
	 * 
	 * @param base
	 *            the base
	 * @return the session
	 * @deprecated Use {@link SessionDescendant#getAncestorSession()} on the
	 *             object instead.
	 */
	@Deprecated
	public static Session getSession(final lotus.domino.Base base) {
		org.openntf.domino.Session result = null;
		if (base instanceof SessionDescendant) {
			result = ((SessionDescendant) base).getAncestorSession();
		} else if (base instanceof org.openntf.domino.Session) {
			result = (org.openntf.domino.Session) base;
		} else if (base == null) {
			throw new NullPointerException("Base object cannot be null");
		}
		if (result == null) {
			throw new UndefinedDelegateTypeException(
					"Couldn't find session for object of type " + base.getClass().getName());
		}
		return result;
	}

	/**
	 * To lotus note collection.
	 * 
	 * @param collection
	 *            the collection
	 * @return the org.openntf.domino. note collection
	 * 
	 * @deprecated this should be moved to {@link CollectionUtils}
	 */
	@Deprecated
	public static org.openntf.domino.NoteCollection toNoteCollection(final lotus.domino.DocumentCollection collection) {
		org.openntf.domino.NoteCollection result = null;
		if (collection instanceof DocumentCollection) {
			org.openntf.domino.Database db = ((DocumentCollection) collection).getParent();
			result = db.createNoteCollection(false);
			result.add(collection);
		} else {
			throw new DataNotCompatibleException("Cannot convert a non-OpenNTF DocumentCollection to a NoteCollection");
		}
		return result;
	}

	/**
	 * Add a hook that will run on the next "terminate" call
	 * 
	 * @param hook
	 *            the hook that should run on next terminate
	 * 
	 */
	public static void addTerminateHook(final Runnable hook, final boolean global) {
		if (global) {
			globalTerminateHooks.add(hook);
		} else {
			getThreadVariables().addTerminateHook(hook);
		}
	}

	public static void removeTerminateHook(final Runnable hook, final boolean global) {
		if (global) {
			globalTerminateHooks.remove(hook);
		} else {
			getThreadVariables().removeTerminateHook(hook);
		}
	}

	/**
	 * Add a hook that will run on shutdown
	 */
	public static void addShutdownHook(final Runnable hook) {
		shutdownHooks.add(hook);
	}

	/**
	 * Remove a shutdown hook
	 * 
	 * @param hook
	 *            the hook that should be removed
	 */
	public static void removeShutdownHook(final Runnable hook) {
		shutdownHooks.remove(hook);
	}

	public static String getLocalServerName() {
		return localServerName;
	}

	public static void println(String prefix, final String lines) {
		BufferedReader reader = new BufferedReader(new StringReader(lines));
		String line;
		try {
			if (Strings.isBlankString(prefix)) {
				prefix = "[ODA] ";
			} else {
				prefix = "[ODA::" + prefix + "] ";
			}
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0)
					printer.println(prefix + line);
			}
		} catch (IOException ioex) {

		}
	}

	public static void println(final Object x) {
		println(null, String.valueOf(x));
	}

	public static void println(final Object source, final Object x) {
		if (source == null) {
			println(null, String.valueOf(x));
		} else {
			String prefix;
			if (source instanceof String) {
				prefix = (String) source;
			} else if (source instanceof Class) {
				prefix = ((Class<?>) source).getSimpleName();
			} else {
				prefix = source.getClass().getSimpleName();
			}
			println(prefix, String.valueOf(x));
		}
	}

	/*
	 * Extensions
	 */
	public static final String COUCH_INI_VARIABLE = "COUCH_SERVERLIST";
	private static Map<String, String> couchServers = new HashMap<String, String>(0);

	public static String getCouchServerUrl(final String name) {
		if (null == couchServers)
			throw new OpenNTFNotesException("CouchDB server list is not initialized.");
		System.out.println("<><><><> Looking for server name: " + name);
		System.out.println("<><><><> Server List size: " + couchServers.keySet().size());
		System.out.println("<><><><> Server List: ");
		for (String server : couchServers.keySet()) {
			System.out.println("<><><><> " + server + " : " + couchServers.get(server));
		}
		if (couchServers.containsKey(name))
			return couchServers.get(name);
		return getCouchServerUrlByCN(name);
	}

	public static String getCouchServerUrlByCN(final String name) {
		if (null == couchServers)
			throw new OpenNTFNotesException("CouchDB server list is not initialized.");
		if (name.contains("/"))
			throw new OpenNTFNotesException("Server name: " + name + " is malformed.");
		for (String key : couchServers.keySet()) {
			if (key.startsWith(name))
				return couchServers.get(key);
		}
		throw new OpenNTFNotesException("Server " + name + " could not be located.");
	}

	private static void initializeCouchServerList() {
		String allstr = org.openntf.redomino.utils.Factory.getEnvironment(COUCH_INI_VARIABLE.toLowerCase());
		System.out.println("<><><><><> Couch server list string: " + allstr);
		if (null != allstr) {
			if (allstr.indexOf(";") < 0) {
				if (allstr.indexOf("!!") > 0) {
					couchServers.put(allstr.split("!!")[0], allstr.split("!!")[1]);
				} else
					throw new OpenNTFNotesException(COUCH_INI_VARIABLE + " variable in notes.ini is malformed.");
			} else {
				String[] serstrings = allstr.split(";");
				for (int i = 0; i < serstrings.length; i++) {
					if (serstrings[i].length() > 0) {
						if (serstrings[i].indexOf("!!") > 0) {
							couchServers.put(serstrings[i].split("!!")[0], serstrings[i].split("!!")[1]);
						} else
							throw new OpenNTFNotesException(
									COUCH_INI_VARIABLE + " variable in notes.ini is malformed.");
					}
				}
			}
		}
	}
}
