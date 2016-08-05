/**
 * 
 */
package org.openntf.red.core.config;

import java.util.logging.Logger;

/**
 * @author Vladimir Kornienko
 *
 */
public class ConfigUpdater implements Runnable {
	//protected boolean _running;
	private static Logger log = Logger.getLogger(ConfigUpdater.class.getName());
	/**
	 * 
	 */
	public ConfigUpdater() {
		//_running = false;
	}

	@Override
	public void run() {
		//_running = true;
		//while (ConfigManager.isStarted()) {
			/*try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				log.severe("Config Manager: Config Updater task has been interrupted (shutting down).");
				e.printStackTrace();
				break;
			}*/
			log.info("Config Manager: Config Updater task looking for unsaved changes.");
			if (ConfigManager.hasUnsavedChanges())
				ConfigManager.applyChanges();
		//}
		//_running = false;
	}

}
