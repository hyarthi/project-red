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
 * Thread service of the RED Server. Manages all threads on the server. Provides
 * a thread pool. Should be started second when server starts (between
 * {@link org.openntf.red.core.config.ConfigManager} and
 * {@link org.openntf.red.core.modules.ModuleManager}).
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see ScheduledThreadPoolExecutor
 */
public enum ThreadManager {
	;
	/** Thread factory. */
	private static ManagedThreadFactory factory;
	/** Thread manager. */
	private static ScheduledThreadPoolExecutor manager;
	/** Logger object. */
	private static final Logger log = Logger.getLogger(ThreadManager.class.getName());
	/** Flag indicating that the service is running. */
	private static boolean _started = false;

	/**
	 * Initializes the service.
	 * 
	 * @since 0.4.0
	 */
	public static void startup() {
		if (_started) // something's wrong
			throw new ThreadManagerException("Thread Manager is already running.");
		try {
			factory = (ManagedThreadFactory) new InitialContext().lookup("REDThreadFactory");
		} catch (NamingException e) {
			throw new ThreadManagerException("Thread Manager: Failed to init: Could not locate thread factory (JNDI).",
					e);
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

	/**
	 * Initiates service shutdown.
	 * 
	 * @since 0.4.0
	 */
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

	/**
	 * Registers and launches a server task.
	 * 
	 * @param task
	 *            Server task to run
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void runTask(IServerTask task) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		log.fine("Thread Manager: Running task " + task.getClass().getName() + ".");
		manager.execute(task);
	}

	/**
	 * Registers and runs an abstract thread.
	 * 
	 * @param thread
	 *            Executable to run.
	 * @since 0.4.0
	 * @see Runnable
	 */
	public static void runThread(Runnable thread) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		log.finest("Thread Manager: Running thread " + thread.hashCode() + " (" + thread.getClass().getName() + ").");
		manager.execute(thread);
	}

	/**
	 * <i>Inactive yet.</i><br>
	 * Registers a server task to run after a certain period of time.
	 * 
	 * @param task
	 *            Server task to run
	 * @param period
	 *            Timeout period
	 * @param unit
	 *            Timeout unit (hours, minutes, ...)
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void registerDelayedTask(IServerTask task, long period, TimeUnit unit) {
		// TODO code here
	}

	/**
	 * <i>Inactive yet.</i><br>
	 * Registers a task to run at a specified moment in time.
	 * 
	 * @param task
	 *            Server task to run.
	 * @param when
	 *            Moment when to run the task.
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void registerScheduledTask(IServerTask task, Date when) {
		// TODO code here
	}

	/**
	 * Registers a task to run now and later repeat it at a certain interval.
	 * 
	 * @param task
	 *            Server task to run.
	 * @param period
	 *            Repeat time period.
	 * @param unit
	 *            Repeat time unit (hours, minutes, ...).
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void registerRepeatingTask(IServerTask task, long period, TimeUnit unit) {
		registerDelayedRepeatingTask(task, 0, period, unit);
	}

	/**
	 * Registers a task to run with a specific delay and later repeat at a
	 * certain interval.
	 * 
	 * @param task
	 *            Server task to run.
	 * @param delay
	 *            Delay timer.
	 * @param period
	 *            Repeat time period.
	 * @param unit
	 *            Delay and repeat time unit (hours, minutes, ...).
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void registerDelayedRepeatingTask(IServerTask task, long delay, long period, TimeUnit unit) {
		if (!_started)
			throw new ThreadManagerException("Thread Manager is not started.");
		manager.scheduleAtFixedRate(task, delay, period, unit);
	}

	/**
	 * <i>Inactive yet.</i><br>
	 * Registers a task to run at a certain point in time and later repeat at a
	 * certain interval.
	 * 
	 * @param task
	 *            Server task to run.
	 * @param start
	 *            Start moment.
	 * @param period
	 *            Repeat time period.
	 * @param unit
	 *            Repeat time unit (hours, minutes, ...).
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void registerScheduledRepeatingTask(IServerTask task, Date start, long period, TimeUnit unit) {
		// TODO code here
	}

	/**
	 * <i>Inactive yet.</i><br>
	 * Cancels a task execution, shuts it down, and removes it from the
	 * scheduled task list.
	 * 
	 * @param task
	 *            Server task to shut down.
	 * @see IServerTask
	 * @since 0.4.0
	 */
	public static void cancelTask(IServerTask task) {
		// TODO code here
	}

	/**
	 * Launches core server tasks.
	 * 
	 * @since 0.4.0
	 */
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

	/**
	 * List of core server tasks.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 *
	 */
	private enum CoreTasks {
		/** Config Updater task. */
		CONFIG_UPDATER("Config Updater", ConfigUpdater.class.getName(), 10, 10, TimeUnit.MINUTES),;

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
