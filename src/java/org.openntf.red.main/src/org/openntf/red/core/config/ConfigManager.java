/**
 * 
 */
package org.openntf.red.core.config;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openntf.red.core.modules.ModuleManagerException;

import java.util.logging.Logger;

import javolution.util.FastMap;

/**
 * @author Vladimir Kornienko
 *
 */
public enum ConfigManager {
	;

	private static boolean _started = false;
	private static Map<String, Object> unsavedChanges = new FastMap<String, Object>();
	private static INIConfiguration config = null;
	private static INIConfiguration moduleConfig = null;
	private static FileBasedConfigurationBuilder<INIConfiguration> builder;
	private static FileBasedConfigurationBuilder<INIConfiguration> mbuilder;
	private static Logger log = Logger.getLogger(ConfigManager.class.getName());
	private static String server = null;
	// private static ConfigUpdater updater = null;
	// private static Thread updaterThread = null;

	public static void startup() {
		if (_started) // something's wrong
			throw new ConfigManagerException("Config Manager is already running.");
		log.info("Config Manager: starting...");

		String filename = "";
		InitialContext icontext = null;
		try {
			icontext = new InitialContext();
		} catch (NamingException ne) {
			throw new ConfigManagerException("Config Manager: Failed to init: Could not instantiate InitialContext.",
					ne);
		}
		/*
		 * if (null == icontext) throw new ConfigManagerException(
		 * "Config Manager: Failed to init: Could not instantiate InitialContext (NULL)."
		 * );
		 */
		// load notes.ini
		try {
			filename = (String) icontext.lookup("notes_ini_location");
		} catch (NamingException e) {
			throw new ConfigManagerException("Config Manager: Failed to init: Could not locate notes.ini file (JNDI).",
					e);
		}
		filename += "/notes.ini";
		Parameters param = new Parameters();
		builder = new FileBasedConfigurationBuilder<INIConfiguration>(INIConfiguration.class).configure(
				param.hierarchical().setFile(new File(filename)).setReloadingRefreshDelay(Long.valueOf(300000)));
		try {
			config = builder.getConfiguration();
			_started = true;
			log.info("Config Manager: started.");
			server = getPropertyAsString(ConfigProperties.SECTION_NOTES + "." + ConfigProperties.SERVER_NAME);
			log.fine("Config Manager: Local server name is " + server);
		} catch (ConfigurationException e) {
			throw new ConfigManagerException("Config Manager: Failed to init: Could not read notes.ini file.", e);
		}

		// load module_definitions.ini
		try {
			filename = (String) icontext.lookup("module_definition_location");
		} catch (NamingException ne) {
			throw new ModuleManagerException(
					"Config Manager: Failed to locate module definition file.");
		}
		filename += "/module_definition.ini";
		Parameters mparam = new Parameters();
		mbuilder = new FileBasedConfigurationBuilder<INIConfiguration>(INIConfiguration.class)
				.configure(mparam.hierarchical().setFile(new File(filename)));
		try {
			moduleConfig = mbuilder.getConfiguration();
		} catch (ConfigurationException e) {
			throw new ConfigManagerException("Config Manager: Could not read module definition file.", e);
		}
	}

	public static void shutdown() {
		log.info("Config Manager: shutting down...");
		if (!_started)
			log.severe("Config Manager: Config Manager is not running.");
		else if (null != config) {
			/*
			 * log.info("Config Manager: Stopping Config Updater task."); if
			 * (updater._running) { updaterThread.interrupt(); updater._running
			 * = false; } log.info(
			 * "Config Manager: Config Updater task stopped.");
			 */
			log.info("Config Manager: Committing any unsaved changes to notes.ini.");
			if (hasUnsavedChanges()) {
				applyChanges();
			}
			try {
				builder.save();
				_started = false;
				log.info("Config Manager: shut down.");
			} catch (ConfigurationException e) {
				log.severe("Config Manager: Error committing changes to notes.ini.");
			}
		} else {
			log.severe(
					"Config Manager: notes.ini manipulator is not initialized. Any unsaved changes to config will be lost.");
		}
	}

	public static boolean isStarted() {
		return _started;
	}

	protected synchronized static void applyChanges() {
		log.info("Config Manager: Committing unsaved changes to notes.ini.");
		if (null != config) {
			try {
				config = builder.getConfiguration();
			} catch (ConfigurationException e1) {
				log.severe("Config Manager: Failed to apply changes from notes.ini.");
				e1.printStackTrace();
			}
			for (String key : unsavedChanges.keySet()) {
				config.setProperty(key, unsavedChanges.get(key));
				unsavedChanges.remove(key);
			}
			try {
				builder.save();
			} catch (ConfigurationException e) {
				log.severe("Config Manager: Failed to apply changes to notes.ini.");
				e.printStackTrace();
			}
		}
	}

	protected static boolean hasUnsavedChanges() {
		return !unsavedChanges.isEmpty();
	}

	public static String getPropertyAsString(String name) {
		if (null == config)
			return null;
		return config.getString(name, null);
	}

	public static Integer getPropertyAsInteger(String name) {
		if (null == config)
			return null;
		return config.getInteger(name, null);
	}

	public static Long getPropertyAsLong(String name) {
		if (null == config)
			return null;
		return config.getLong(name, null);
	}

	public static byte[] getPropertyAsBytes(String name) {
		if (null == config)
			return null;
		if (!config.containsKey(name))
			return null;
		return config.getString(name).getBytes();
	}

	public static Date getPropertyAsDate(String name) {
		if (null == config)
			return null;
		if (!config.containsKey(name))
			return null;
		try {
			return DateFormat.getDateInstance().parse(config.getString(name));
		} catch (ParseException e) {
			log.warning("Config Manager: Failed to parse notes.ini property (Date).");
			e.printStackTrace();
			return null;
		}
	}

	public static void setProperty(String name, String value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}

	public static void setProperty(String name, int value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}
	
	public static void setProperty(String name, Integer value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}

	public static void setProperty(String name, long value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}
	
	public static void setProperty(String name, Long value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}

	public static void setProperty(String name, byte[] value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		config.setProperty(name, value);
		unsavedChanges.put(name, value);
	}

	public static void setProperty(String name, Date value) {
		if (null == config)
			throw new ConfigManagerException("Config Manager: notes.ini manipulator is not initialized.");
		// FIXME probably needs String.format(...)
		config.setProperty(name, value.toString());
		unsavedChanges.put(name, value.toString());
	}

	public static Map<String, Object> getSection(String name) {
		FastMap<String, Object> result = new FastMap<String, Object>();
		if (null != config && config.getSections().contains(name)) {
			Iterator<String> iterator = config.getSection(name).getKeys();
			while (iterator.hasNext()) {
				String key = iterator.next();
				result.put(key, config.getProperty(name + "." + key));
			}
		}
		return result.unmodifiable();
	}

	public static Map<String, String> getSectionAsStrings(String name) {
		FastMap<String, String> result = new FastMap<String, String>();
		if (null != config && config.getSections().contains(name)) {
			Iterator<String> iterator = config.getSection(name).getKeys();
			while (iterator.hasNext()) {
				String key = iterator.next();
				result.put(key, config.getString(name + "." + key));
			}
		}
		return result;
	}

	public static String getServerName() {
		if (!_started)
			return "";
		return server;
	}
	
	public static String getModuleClassName(String moduleName, boolean isCoreModule) {
		if (!_started)
			return null;
		if (null == moduleConfig)
			return null;
		String lookupName;
		if (isCoreModule)
			lookupName = Modules.MODULE_TYPE_CORE + "." + moduleName;
		else
			lookupName = Modules.MODULE_TYPE_CUSTOM + "." + moduleName;
		return moduleConfig.getString(lookupName);
	}

	public static class ConfigProperties {
		// sections
		public static final String SECTION_REPOSITORIES = "Repositories";
		public static final String SECTION_NOTES = "Notes";
		// NOTES options
		public static final String SERVER_NAME = "ServerName";
		// REPOSITORIES options
		public static final String REPOSITORY_TYPE = "RepositoryType";
		public static final String REPOSITORY_URL = "RepositoryURL";
		public static final String REPOSITORY_PORT = "RepositoryPort";
		public static final String REPOSITORY_BINDING_USER = "RepositoryBindingUser";
		public static final String REPOSITORY_BINDING_PASSWORD = "RepositoryBindingPassword";
		public static final String LOCAL_REPOSITORY_LIST = "LocalRepositoryList";
		public static final String DEFAULT_LOCAL_REPOSITORY = "DefaultLocalRepository";
		// REPOSITORY types
		public static final String REPOSITORY_TYPE_COUCH = "couch";
		public static final String REPOSITORY_TYPE_NSF = "nsf";
		public static final String REPOSITORY_TYPE_NSF_REMOTE = "nsf_remote";
		// RED Server settings
		public static final String RED_SERVER_PORT = "REDServerPort";
	}
	
	public static class Modules {
		// types
		public static final String MODULE_TYPE_CORE = "Core";
		public static final String MODULE_TYPE_CUSTOM = "Custom";
		// names
		public static final String MODULE_NSF_SERVICE = "RED_NSF_SERVICE";
		public static final String MODULE_SECURITY_SERVICE = "RED_SECURITY_SERVICE";
		public static final String MODULE_NETWORK_SERVICE = "RED_NETWORK_SERVICE";
	}
}
