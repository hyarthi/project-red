/**
 * 
 */
package org.openntf.red.nsf.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javolution.util.FastMap;

import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;
import org.openntf.red.nsf.IDataBroker;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;
import org.openntf.red.nsf.impl.couch.CouchEndpointFactory;
import org.openntf.red.nsf.DataBrokerException;
import org.openntf.red.nsf.impl.notes.NotesEndpointFactory;
import org.openntf.red.nsf.impl.notes.remote.NotesRemoteEndpointFactory;

/**
 * Default data broker implementation.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see IDataBroker
 */
public class NSFBroker implements IDataBroker {
	/** Flag indicating that NSFBroker is initialized. */
	private boolean _started;
	/** Logger object. */
	private static Logger log = Logger.getLogger(NSFBroker.class.getName());
	/**
	 * Object instance reference. Only 1 NSFBroker should exist in the runtime.
	 */
	private static NSFBroker _instance = null;
	/** Registered endpoint factory map. */
	private FastMap<String, EndpointFactory> factories = null;
	/** Map of endpoint configs specified on the server. */
	private FastMap<String, EndpointConfig> endpoints = null;
	/** Endpoint cache. */
	@SuppressWarnings("rawtypes")
	private FastMap<String, Endpoint> epcache = null;
	/**
	 * Cache controllers (used to find out expired endpoints and candidates for
	 * throwing out).
	 */
	private FastMap<String, Date> epcChrono = null;
	/** Cache expiration period (ms). */
	private long epcExpiration = -1;
	/** Default endpoint name. */
	private String defaultEndpoint = null;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	private NSFBroker() {// TODO more logs everywhere... and comments too.
		_started = false;
	}

	/**
	 * Static function to get object reference.
	 * 
	 * @return NSFBroker instance.
	 * @since 0.4.0
	 */
	public static NSFBroker getInstance() {
		synchronized (NSFBroker.class) {
			if (null == _instance) {
				_instance = new NSFBroker();
			}
		}
		return _instance;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void startup() {
		if (_started)
			throw new DataBrokerException("NSF Broker is already running.");
		log.info("NSF Broker: starting...");
		factories = new FastMap<String, EndpointFactory>().shared();
		endpoints = new FastMap<String, EndpointConfig>().atomic();
		epcache = new FastMap<String, Endpoint>().atomic();
		epcChrono = new FastMap<String, Date>().shared();
		epcExpiration = 1800000; // EPs expire after 30 mins FIXME: make param
									// configurable in notes.ini, perhaps?
		_started = true;
		log.fine("NSF Broker: Initializing core endpoint factories.");
		initCoreFactories();
		log.fine("NSF Broker: Finished initializing core endpoint factories.");
		log.fine("NSF Broker: Reading endpoint configurations from notes.ini.");
		readEndpointConfigs();
		log.fine("NSF Broker: Finished reading endpoint configurations from notes.ini.");
		log.info("NSF Broker: started.");
	}

	@Override
	public void shutdown() {
		if (!_started) {
			log.severe("NSF Broker is not running.");
		} else if (null != factories) {
			log.info("NSF Broker: shutting down...");
			log.fine("NSF Broker: Releasing endpoint configs.");
			endpoints.clear();
			log.fine("NSF Broker: Releasing endpoint factories.");
			for (String name : factories.keySet())
				deregisterEndpointFactory(name);
			_started = false;
			log.info("NSF Broker: shut down.");
		}
	}

	/**
	 * Returns whether the NSFBroker is up and running.
	 * 
	 * @since 0.4.0
	 */
	public boolean isStarted() {
		return _started;
	}

	@Override
	public <F extends EndpointFactory> void registerEndpointFactory(String name, Class<F> type) {
		if (!_started)
			throw new DataBrokerException("NSF Broker is not running.");
		log.fine("NSF Broker: Registering factory " + name + " of type " + type.getName() + ".");
		try {
			EndpointFactory factory = (F) type.newInstance();
			factory.startup();
			factories.put(name, factory);
		} catch (InstantiationException | IllegalAccessException e) {
			log.severe("NSF Broker: Failed to register endpoint factory " + type.getName() + ": Reason: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deregisterEndpointFactory(String name) {
		if (!_started)
			throw new DataBrokerException("NSF Broker is not running.");
		log.finest("NSF Broker: Releasing endpoint factory " + name + ".");
		if (hasEndpointFactory(name)) {
			EndpointFactory factory = factories.get(name);
			factory.shutdown();
			factories.remove(name);
		}
	}

	/**
	 * (Under consideration)
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasEndpointFactory(String name) {
		if (!_started)
			return false;
		return factories.containsKey(name);
	}

	@Override
	public EndpointFactory getEndpointFactory(String name) {
		if (!_started || !hasEndpointFactory(name))
			return null;
		return factories.get(name);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint(String server) {
		if (!_started)
			return null;
		if (null == server || "".equals(server) || ConfigManager.getServerName().equals(server)) {
			log.info("Getting local endpoint.");
			return getLocalEndpoint(null);
		} else {
			return getRemoteEndpoint();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getEndpoint() {
		return null;
	}

	@Override
	public Set<String> getLocalEndpoints() {
		if (!_started)
			return null;
		return endpoints.keySet();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Endpoint getLocalEndpoint(String name) {
		if (!_started || null == defaultEndpoint)
			return null;
		EndpointConfig epcfg;
		if (null == name || "".equals(name))
			epcfg = endpoints.get(defaultEndpoint);
		else
			epcfg = endpoints.get(name);
		if (null == epcfg) {
			log.severe("Unable to create endpoint: No endpoint configuration found.");
			return null;
		}
		// maybe just log a severe and return null here?
		if (!factories.containsKey(epcfg.type()))
			throw new DataBrokerException(
					"Unable to create endpoint: No endpoint factory of type " + epcfg.type() + " registered.");
		if (!epcache.containsKey(epcfg.name())) {
			EndpointFactory factory = factories.get(epcfg.type());
			epcache.put(epcfg.name(), factory.getEndpoint(epcfg));
		}
		epcChrono.put(epcfg.name(), new Date());

		return epcache.get(epcfg.name());
	}

	/**
	 * (Under consideration)
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Endpoint getRemoteEndpoint() {
		// for now only 1 remote endpoint config (& factory) is allowed
		if (!_started || endpoints.size() == 0)
			return null;
		EndpointConfig epcfg = null;
		for (EndpointConfig cfg : endpoints.values()) {
			if (cfg.type().equals(ConfigProperties.REPOSITORY_TYPE_NSF_REMOTE)) {
				epcfg = cfg;
				break;
			}
		}
		if (null == epcfg)
			throw new DataBrokerException("Unable to create endpoint: No remote endpoint configuration exists.");
		// maybe just log a severe and return null here?
		if (!factories.containsKey(epcfg.type()))
			throw new DataBrokerException(
					"Unable to create endpoint: No endpoint factory of type " + epcfg.type() + " registered.");
		EndpointFactory factory = factories.get(epcfg.type());
		return factory.getEndpoint(null, epcfg);
	}

	/**
	 * Initializes and registers all default endpoint factories.
	 * 
	 * @since 0.4.0
	 */
	private void initCoreFactories() {
		// CouchDB endpoint factory
		log.finest("NSF Broker: Registering CouchDB endpoint factory.");
		this.registerEndpointFactory(ConfigProperties.REPOSITORY_TYPE_COUCH, CouchEndpointFactory.class);
		// local Notes endpoint factory (derived from Crossworlds)
		log.finest("NSF Broker: Registering NSF endpoint factory.");
		this.registerEndpointFactory(ConfigProperties.REPOSITORY_TYPE_NSF, NotesEndpointFactory.class);
		// remote Notes endpoint factory (NRPC calls to remote server)
		log.finest("NSF Broker: Registering remote NSF endpoint factory.");
		this.registerEndpointFactory(ConfigProperties.REPOSITORY_TYPE_NSF_REMOTE, NotesRemoteEndpointFactory.class);
	}

	/**
	 * Reads and records all endpoint configs defined on the server.
	 * 
	 * @since 0.4.0
	 */
	private void readEndpointConfigs() {
		log.finest("NSF Broker: Getting list of endpoints registered locally.");
		// get a list of available endpoints
		log.info("Endpoints: " + ConfigManager.getPropertyAsString(
				ConfigProperties.SECTION_REPOSITORIES + "." + ConfigProperties.LOCAL_REPOSITORY_LIST));
		String[] endpts = ConfigManager
				.getPropertyAsString(
						ConfigProperties.SECTION_REPOSITORIES + "." + ConfigProperties.LOCAL_REPOSITORY_LIST)
				.split(",");
		Map<String, String> options = null;
		for (String endpoint : endpts) {
			log.finest("NSF Broker: Registering endpoint " + endpoint + ".");
			// read options mentioned in notes.ini. NEEDS to have RepositoryType
			// option
			options = ConfigManager.getSectionAsStrings(ConfigProperties.SECTION_REPOSITORIES + "/" + endpoint);
			if (!options.containsKey(ConfigProperties.REPOSITORY_TYPE)) {
				log.severe("NSF Broker: Failed to register endpoint " + endpoint + ": Repository type is not defined.");
				continue;
			}
			String type = options.get(ConfigProperties.REPOSITORY_TYPE);
			// type is stored as a separate object field
			options.remove(ConfigProperties.REPOSITORY_TYPE);
			// add endpoint config to list
			endpoints.put(endpoint, new EndpointConfig(endpoint, type, options));
		}
		// get default endpoint
		log.finest("NSF Broker: Setting default endpoint.");
		defaultEndpoint = ConfigManager.getPropertyAsString(
				ConfigProperties.SECTION_REPOSITORIES + "." + ConfigProperties.DEFAULT_LOCAL_REPOSITORY);
		// mandatory to have default endpoint
		if (null == defaultEndpoint || "".equals(defaultEndpoint))
			throw new DataBrokerException("No default endpoint set.");
		log.fine("NSF Broker: Default local endpoint is " + defaultEndpoint + ".");
	}

	/**
	 * (Under consideration)
	 */
	private void cleanEPCache() {
		Date now = new Date();
		for (String key : epcChrono.keySet()) {
			if (now.getTime() - epcChrono.get(key).getTime() > epcExpiration) {
				log.finest("NSF Broker: Endpoint " + key + " has expired. Removing...");
				epcache.remove(key);
				epcChrono.remove(key);
			}
		}
	}

	/**
	 * (Under consideration)
	 */
	synchronized void update() {
		log.fine("NSF Broker: Running maintenance.");
		log.fine("NSF Broker: Cleaning endpoint cache.");
		cleanEPCache();
		log.fine("NSF Broker: Finished maintenance.");
	}

	// FIXME Are these 2 needed?
	@Override
	public EndpointConfig getEndpointConfig(String name) {
		return endpoints.get(name);
	}

	@Override
	public EndpointConfig getDefaultEndpointConfig() {
		if (null == defaultEndpoint || "".equals(defaultEndpoint))
			throw new DataBrokerException("No default endpoint set.");
		return getEndpointConfig(defaultEndpoint);
	}
}
