/**
 * 
 */
package org.openntf.red.core.thread;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.openntf.red.core.config.ConfigUpdater;

/**
 * @author Vladimir Kornienko
 *
 */
public enum ThreadManager {
	;

	private static ManagedThreadFactory factory;
	private static ScheduledThreadPoolExecutor manager;
	private static Logger log = Logger.getLogger(ThreadManager.class.getName());
	private static boolean _started = false;

	public static void startup() {
		if (_started) // something's wrong
			throw new ThreadManagerException("Thread Manager is already running.");
		try {
			factory = (ManagedThreadFactory) new InitialContext().lookup("REDThreadFactory");
		} catch (NamingException e) {
			throw new ThreadManagerException("Thread Manager: Failed to init: Could not locate thread factory (JNDI).", e);
		}
		log.info("Thread Manager: starting...");
		manager = new ScheduledThreadPoolExecutor(20, factory);
		manager.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
		manager.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
		manager.setRemoveOnCancelPolicy(true);
		_started = true;
		log.info("Thread Manager: started.");
		log.info("Thread Manager: Initializing core tasks...");
		initCoreTasks();
		log.info("Thread Manager: Core tasks initialized.");
	}

	public static void shutdown() {
		log.info("Thread Manager: shutting down...");
		if (!_started) {
			log.severe("Thread Manager: Thread Manager is not running.");
		} else if (null != manager) {
			manager.shutdown();
			try {
				manager.awaitTermination(30, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				log.severe("Thread Manager: Error: Termination thread was interrupted.");
				e.printStackTrace();
			}
			if (manager.isTerminating())
				manager.shutdownNow();
		} else {
			log.severe("Thread Manager: Manager object not initialied.");
		}
		_started = false;
		log.info("Thread Manager: shut down.");
	}

	public static void runTask(IServerTask task) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		log.fine("Thread Manager: Running task " + task.getClass().getName() + ".");
		manager.execute(task);
	}
	
	public static void runThread(Runnable thread) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		log.finest("Thread Manager: Running thread " + thread.hashCode() + " (" + thread.getClass().getName() + ").");
		manager.execute(thread);
	}

	public static void registerDelayedTask(IServerTask task, long period, TimeUnit unit) {
		// TODO code here
	}

	public static void registerScheduledTask(IServerTask task, Date when) {
		// TODO code here
	}

	public static void registerRepeatingTask(IServerTask task, long period, TimeUnit unit) {
		registerDelayedRepeatingTask(task, 0, period, unit);
	}

	public static void registerDelayedRepeatingTask(IServerTask task, long delay, long period, TimeUnit unit) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		manager.scheduleAtFixedRate(task, delay, period, unit);
	}

	public static void registerScheduledRepeatingTask(IServerTask task, Date start, long period, TimeUnit unit) {
		// TODO code here
	}

	public static void cancelTask(IServerTask task) {
		// TODO code here
	}

	private static void initCoreTasks() {
		IServerTask run;
		for (CoreTasks task : CoreTasks.values()) {
			try {
				run = (IServerTask) Class.forName(task.className).newInstance();
				manager.scheduleAtFixedRate(run, task.delay, task.period, task.unit);
				log.info(task.name + ": Started.");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				log.severe("Thread Manager: Failed to start task - " + task.name + ". Reason: ("
						+ e.getClass().getName() + ") " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private enum CoreTasks {
		CONFIG_UPDATER("Config Updater", ConfigUpdater.class.getName(), 10, 10, TimeUnit.MINUTES),
		;
		
		protected String name;
		protected String className;
		protected long delay;
		protected long period;
		protected TimeUnit unit;

		CoreTasks(String _name, String _className, long _delay, long _period, TimeUnit _unit) {
			name = _name;
			className = _className;
			delay = _delay;
			period = _period;
			unit = _unit;
		}
	}
}
