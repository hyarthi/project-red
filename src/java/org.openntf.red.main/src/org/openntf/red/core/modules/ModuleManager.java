/**
 * 
 */
package org.openntf.red.core.modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.config.ConfigManager.Modules;
import org.openntf.red.core.thread.IServerTask;
import org.openntf.red.core.thread.ThreadManager;
import org.openntf.red.network.INetworkManager;
import org.openntf.red.nsf.IDataBroker;
import org.openntf.red.security.ISecurityManager;

import javolution.util.FastMap;

/**
 * Service that manages all non-core modules (services, tasks). Launched 3rd
 * (after {@link ConfigManager} and {@link ThreadManager}).
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see {@link org.openntf.red.core.IREDService}, {@link IServerTask}
 */
public enum ModuleManager {
	;
	/** Logger object */
	private static final Logger log = Logger.getLogger(ModuleManager.class.getName());
	/** Data Broker service reference. */
	private static IDataBroker dataBroker = null;
	/** Security Manager service reference. */
	private static ISecurityManager securityManager = null;
	/** Network Manager service reference. */
	private static INetworkManager networkManager = null;
	/**
	 * List of server tasks running on the server sorted by their code names.
	 */
	private static FastMap<String, IServerTask> tasks = null;

	/**
	 * Starts services. Services should be up and running before starting tasks
	 * that depend on them.
	 * 
	 * @see {@link org.openntf.red.core.IREDService}
	 * @since 0.4.0
	 */
	public static void startServices() {
		String className;
		Class<?> classInst;
		Method inst;
		int modifiers, cmodifiers;
		Constructor<?> constr;

		log.info("Module Manager: Starting RED Services...");
		log.finer("Module Manager: Instantiating Data Broker...");
		// Data Broker
		className = ConfigManager.getModuleClassName(Modules.MODULE_NSF_SERVICE, true);
		log.info("Module Manager: Class used for Data Broker: " + className + ".");
		log.finer("Module Manager: Class used for Data Broker: " + className + ".");
		log.finest("Module Manager: Getting class instance...");
		try {
			classInst = Class.forName(className);
		} catch (ClassNotFoundException cnfe) {
			log.throwing(ModuleManager.class.getName(), "startServices()", cnfe);
			throw new ModuleManagerException("No class found for Data Broker.", cnfe);
		}
		log.finest("Module Manager: Looking for getInstance() method...");
		// check for public static <IDataBroker> getInstance()
		try {
			inst = classInst.getDeclaredMethod(Methods.GET_INSTANCE);
		} catch (NoSuchMethodException nme) {
			inst = null;
		}
		modifiers = inst.getModifiers();
		if (inst != null && (modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.STATIC) > 0
				&& (IDataBroker.class.isAssignableFrom(inst.getReturnType()))) {
			log.finest("Module Manager: Instantiating Data Broker via getInstance() method.");
			try {
				dataBroker = (IDataBroker) inst.invoke(null);
			} catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException ite) {
				log.throwing(ModuleManager.class.getName(), "startServices()", ite);
				throw new ModuleManagerException("Failed to run instantiation static method for Data Broker.", ite);
			}
		} else {
			log.finest(
					"Module Manager: No getInstance() method found. Trying to instantiate via public Constructor().");
			// none present, check the class itself
			if (!IDataBroker.class.isAssignableFrom(classInst)) {
				log.severe(
						"Module Manager: Exception - Class declared for Data Broker is incompatible with the runtime.");
				throw new ModuleManagerException("Incompatible object type for Data Broker.",
						new IllegalArgumentException("Can not convert from " + classInst.getName() + " to "
								+ IDataBroker.class.getName() + "."));
			}
			// check Constructor()
			try {
				constr = classInst.getConstructor();
			} catch (NoSuchMethodException nsme) {
				log.throwing(ModuleManager.class.getName(), "startServices()", nsme);
				throw new ModuleManagerException("No suitable constructor for Data Broker.", nsme);
			}
			cmodifiers = classInst.getModifiers();
			modifiers = constr.getModifiers();
			if ((modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.ABSTRACT) == 0
					&& (cmodifiers & Modifier.ABSTRACT) == 0 && (cmodifiers & Modifier.INTERFACE) == 0
					&& (cmodifiers & Modifier.PUBLIC) > 0) {
				log.finest("Module Manager: Trying to instantiate Data Broker using public Constructor().");
				try {
					dataBroker = (IDataBroker) classInst.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					throw new ModuleManagerException("ModuleManager: Failed to instantiate object for Data Broker.", e);
				}
			} else {
				log.severe("Module Manager: Exception - No suitable constroctor found for Data Broker.");
				throw new ModuleManagerException("No suitable constructor for Data Broker.");
			}
		}
		log.fine("Module Manager: Launching Data Broker.");
		dataBroker.startup();

		log.finer("Module Manager: Instantiating Security Manager...");
		// Security Manager
		className = ConfigManager.getModuleClassName(Modules.MODULE_SECURITY_SERVICE, true);
		log.finer("Module Manager: Class used for Security Manager: " + className + ".");
		log.finest("Module Manager: Getting class instance...");
		try {
			classInst = Class.forName(className);
		} catch (ClassNotFoundException cnfe) {
			log.throwing(ModuleManager.class.getName(), "startServices()", cnfe);
			throw new ModuleManagerException("Module Manager: No class found for Security Manager.", cnfe);
		}
		log.finest("Module Manager: Looking for getInstance() method...");
		// check for public static <ISecurityManager> getInstance()
		try {
			inst = classInst.getDeclaredMethod(Methods.GET_INSTANCE);
		} catch (NoSuchMethodException nme) {
			inst = null;
		}
		modifiers = inst.getModifiers();
		if (inst != null && (modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.STATIC) > 0
				&& (ISecurityManager.class.isAssignableFrom(inst.getReturnType()))) {
			log.finest("Module Manager: Instantiating Security Manager via getInstance() method.");
			try {
				securityManager = (ISecurityManager) inst.invoke(null);
			} catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException ite) {
				log.throwing(ModuleManager.class.getName(), "startService()", ite);
				throw new ModuleManagerException(
						"Module Manager: Failed to run instantiation static method for Security Manager.", ite);
			}
		} else {
			log.finest(
					"Module Manager: No getInstance() method found. Trying to instantiate using a public Constructor().");
			// none present, check the class itself
			if (ISecurityManager.class.isAssignableFrom(classInst)) {
				log.severe(
						"Module Manager: Exception - Class declared for Security Manager is not compatible with the runtime.");
				throw new ModuleManagerException("Module Manager: Incompatible object type for Security Manager.",
						new IllegalArgumentException("Can not convert from " + classInst.getName() + " to "
								+ ISecurityManager.class.getName() + "."));
			}
			// check Constructor()
			try {
				constr = classInst.getConstructor();
			} catch (NoSuchMethodException nsme) {
				log.throwing(ModuleManager.class.getName(), "startServices()", nsme);
				throw new ModuleManagerException("Module Manager: No suitable constructor for Security Manager.", nsme);
			}
			cmodifiers = classInst.getModifiers();
			modifiers = classInst.getModifiers();
			if ((modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.ABSTRACT) == 0
					&& (cmodifiers & Modifier.ABSTRACT) == 0 && (cmodifiers & Modifier.INTERFACE) == 0
					&& (cmodifiers & Modifier.PUBLIC) > 0) {
				log.finest("Module Manager: Trying to instantiate Security Manager using the public Constructor().");
				try {
					securityManager = (ISecurityManager) classInst.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					log.throwing(ModuleManager.class.getName(), "startServices()", e);
					throw new ModuleManagerException(
							"Module Manager: Failed to instantiate object for Security Manager.", e);
				}
			} else {
				log.severe("Module Manager: Could not find suitable constructor for Security Manager.");
				throw new ModuleManagerException("Module Manager: No suitable constructor for Security Manager.");
			}
		}
		log.fine("Module Manager: Launching Security Manager.");
		securityManager.startup();

		log.finer("Module Manager: Instantiating Network Manager...");
		// Network Manager
		className = ConfigManager.getModuleClassName(Modules.MODULE_NETWORK_SERVICE, true);
		log.finer("Module Manager: Class used for Network Manager: " + className + ".");
		log.finest("Module Manager: Getting class instance...");
		try {
			classInst = Class.forName(className);
		} catch (ClassNotFoundException cnfe) {
			log.throwing(ModuleManager.class.getName(), "startServices()", cnfe);
			throw new ModuleManagerException("Module Manager: No class found for Data Broker.", cnfe);
		}
		log.finest("Module Manager: Looking for getInstance() method...");
		// check for public static <INetworkManager> getInstance()
		try {
			inst = classInst.getDeclaredMethod(Methods.GET_INSTANCE);
		} catch (NoSuchMethodException nme) {
			inst = null;
		}
		modifiers = inst.getModifiers();
		if (inst != null && (modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.STATIC) > 0
				&& (INetworkManager.class.isAssignableFrom(inst.getReturnType()))) {
			log.finest("Module Manager: Instantiating Network Manager via getInstance() method.");
			try {
				networkManager = (INetworkManager) inst.invoke(null);
			} catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException ite) {
				log.throwing(ModuleManager.class.getName(), "startService()", ite);
				throw new ModuleManagerException(
						"Module Manager: Failed to run instantiation static method for Network Manager.", ite);
			}
		} else {
			log.finest(
					"Module Manager: No getInstance() method found. Trying to instantiate using a public Constructor().");
			// none present, check the class itself
			if (INetworkManager.class.isAssignableFrom(classInst)) {
				log.severe(
						"Module Manager: Exception - Class declared for Network Manager is not compatible with the runtime.");
				throw new ModuleManagerException("Module Manager: Incompatible object type for Network Manager.",
						new IllegalArgumentException("Can not convert from " + classInst.getName() + " to "
								+ INetworkManager.class.getName() + "."));
			}
			// check Constructor()
			try {
				constr = classInst.getConstructor();
			} catch (NoSuchMethodException nsme) {
				log.throwing(ModuleManager.class.getName(), "startServices()", nsme);
				throw new ModuleManagerException("Module Manager: No suitable constructor for Network Manager.", nsme);
			}
			cmodifiers = classInst.getModifiers();
			modifiers = classInst.getModifiers();
			if ((modifiers & Modifier.PUBLIC) > 0 && (modifiers & Modifier.ABSTRACT) == 0
					&& (cmodifiers & Modifier.ABSTRACT) == 0 && (cmodifiers & Modifier.INTERFACE) == 0
					&& (cmodifiers & Modifier.PUBLIC) > 0) {
				log.finest("Module Manager: Trying to instantiate Network Manager using the public Constructor().");
				try {
					networkManager = (INetworkManager) classInst.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					log.throwing(ModuleManager.class.getName(), "startServices()", e);
					throw new ModuleManagerException(
							"Module Manager: Failed to instantiate object for Network Manager.", e);
				}
			} else {
				log.severe("Module Manager: Could not find suitable constructor for Security Manager.");
				throw new ModuleManagerException("Module Manager: No suitable constructor for Network Manager.");
			}
		}
		log.fine("Module Manager: Launching Security Manager.");
		networkManager.startup();
	}

	/**
	 * Stops server services. Services should be shut down after all the tasks
	 * that depend on them are stopped.
	 * 
	 * @since 0.4.0
	 * @see {@link org.openntf.red.core.IREDService}
	 */
	public static void stopServices() {
		log.info("Module Manager: Stopping RED Services...");
		networkManager.shutdown();
		networkManager = null;
		securityManager.shutdown();
		securityManager = null;
		dataBroker.shutdown();
		dataBroker = null;
		log.info("Module Manager: RED services stopped.");
	}

	/**
	 * Starts server tasks (core & custom).<br>
	 * <i>Custom task startup not implemented yet.</i>
	 * 
	 * @since 0.4.0
	 * @see IServerTask
	 */
	public static void startTasks() {
		tasks = new FastMap<String, IServerTask>();
		log.info("Module Manager: Launching server tasks...");
		startFixedTasks();
		log.info("Module Manager: Launching server custom tasks...");
	}

	/**
	 * Stops server tasks (core & custom).
	 * 
	 * @since 0.4.0
	 * @see IServerTask
	 */
	public static void stopTasks() {
		log.info("Module Manager: Issuing server task stop command...");
		for (String taskName : tasks.keySet()) {
			tasks.get(taskName).terminate();
		}
	}

	/**
	 * Starts core server tasks.
	 * 
	 * @since 0.4.0
	 * @see IServerTask
	 */
	private static void startFixedTasks() {
		IServerTask task;
		// RED Server task
		try {
			Class<?> redclass = Class.forName(CoreTasks.TASK_RED_SERVER_CLASS);
			Method inst = redclass.getDeclaredMethod("getInstance");
			int mod = inst.getModifiers();
			if ((mod & Modifier.STATIC) > 0 && (mod & Modifier.PUBLIC) > 0 && inst.getReturnType() == redclass) {
				task = (IServerTask) inst.invoke(null);
			} else {
				throw new NoSuchMethodException("No public static getInstance() found.");
			}
			tasks.put(CoreTasks.TASK_RED_SERVER_NAME, task);
			ThreadManager.runTask(task);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			log.severe("Failed to start RED server.");
			e.printStackTrace();
			log.throwing(ModuleManager.class.getName(), "startFixedTasks()", e);
		}
	}

	/**
	 * Returns Data Broker service instance. All modules get access to the Data
	 * Broker via this method.
	 * 
	 * @return Data Broker instance
	 * @since 0.4.0
	 * @see IDataBroker
	 */
	public static IDataBroker getDataBroker() {
		return dataBroker;
	}

	/**
	 * Returns Security Manager service instance. All modules get access to the
	 * Security Manager via this method.
	 * 
	 * @return Security Manager instance
	 * @since 0.4.0
	 * @see ISecurityManager
	 */
	public static ISecurityManager getSecurityManager() {
		return securityManager;
	}

	/**
	 * Returns Network Manager service instance. All modules get access to the
	 * Network Manager via this method.
	 * 
	 * @return Network Manager instance
	 * @since 0.4.0
	 * @see INetworkManager
	 */
	public static INetworkManager getNetworkManager() {
		return networkManager;
	}

	/**
	 * Service class. Lists methods that should be present in specific
	 * classes/interfaces.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Methods {
		public static final String GET_INSTANCE = "getInstance";
	}

	/**
	 * Service class. Lists core tasks.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 *
	 */
	private static class CoreTasks {
		public static final String TASK_RED_SERVER_NAME = "RED_SERVER";
		public static final String TASK_RED_SERVER_CLASS = "org.openntf.red.network.rrpc.REDServer";
	}
}
