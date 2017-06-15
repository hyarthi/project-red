/**
 * 
 */
package org.openntf.red.core.config;

import java.util.logging.Logger;

import org.openntf.red.core.thread.IServerTask;

/**
 * Server task running every 10 minutes that dumps any unsaved changes into
 * <code>notes.ini</code> and re-reads the config into memory.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see {@link IServerTask}, {@link Runnable}
 */
public class ConfigUpdater implements IServerTask {
	// protected boolean _running;
	/** Logger object */
	private static final Logger log = Logger.getLogger(ConfigUpdater.class.getName());

	/**
	 * Default Constructor.
	 * 
	 * @since 0.4.0
	 */
	public ConfigUpdater() {
		// _running = false;
	}

	/**
	 * Main executable function. Inherited from {@link Runnable}.
	 * 
	 * @since 0.4.0
	 */
	@Override
	public void run() {
		// _running = true;
		// while (ConfigManager.isStarted()) {
		/*
		 * try { Thread.sleep(60000); } catch (InterruptedException e) { log.
		 * severe("Config Manager: Config Updater task has been interrupted (shutting down)."
		 * ); e.printStackTrace(); break; }
		 */
		log.info("Config Manager: Config Updater task looking for unsaved changes.");
		if (ConfigManager.hasUnsavedChanges())
			ConfigManager.applyChanges();
		// }
		// _running = false;
	}

	/**
	 * Returns the status of the task. Currently unused, since the run time is
	 * too short for this task.
	 * 
	 * @see IServerTask.Status
	 * @since 0.4.0
	 */
	@Override
	public Status status() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Resets the task. Currently unused, since the run time is too short for
	 * this task.
	 * 
	 * @since 0.4.0
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	/**
	 * Terminates the task. Currently unused, since the run time is too short
	 * for this task.
	 * 
	 * @since 0.4.0
	 */
	@Override
	public void terminate() {
		// TODO Auto-generated method stub

	}

}
