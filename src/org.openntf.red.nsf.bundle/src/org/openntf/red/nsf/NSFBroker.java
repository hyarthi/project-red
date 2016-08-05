/**
 * 
 */
package org.openntf.red.nsf;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javolution.util.FastMap;

import org.openntf.red.core.config.ConfigManager;
import org.openntf.red.core.config.ConfigManager.ConfigProperties;
import org.openntf.red.nsf.couch.CouchEndpointFactory;
import org.openntf.red.nsf.endpoint.Endpoint;
import org.openntf.red.nsf.endpoint.EndpointConfig;
import org.openntf.red.nsf.endpoint.EndpointFactory;
import org.openntf.red.nsf.notes.NotesEndpointFactory;
import org.openntf.red.nsf.notes.remote.NotesRemoteEndpointFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class NSFBroker implements IServiceBroker {
	private boolean _started;
	private static Logger log = Logger.getLogger(NSFBroker.class.getName());
	private static NSFBroker _instance = null;
	private FastMap<String, EndpointFactory> factories = null;
	private FastMap<String, EndpointConfig> endpoints = null;
	private String defaultEndpoint = null;

	private NSFBroker() {// TODO more logs everywhere... and comments too.
		_started = false;
	}

	public static NSFBroker getInstance() {
		synchronized (NSFBroker.class) {
			if (null == _instance) {
				_instance = new NSFBroker();
			}
		}
		return _instance;
	}

	public void startup() {
		if (_started)
			throw new NSFBrokerException("NSF Broker is already running.");
		log.info("NSF Broker: starting...");
		factories = new FastMap<String, EndpointFactory>().shared();
		endpoints = new FastMap<String, EndpointConfig>().atomic();
		log.fine("NSF Broker: Initializing core endpoint factories.");
		initCoreFactories();
		log.fine("NSF Broker: Finished initializing core endpoint factories.");
		log.fine("NSF Broker: Reading endpoint configurations from notes.ini.");
		readEndpointConfigs();
		log.fine("NSF Broker: Finished reading endpoint configurations from notes.ini.");
		_started = true;
		log.info("NSF Broker: started.");
	}

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

	public boolean isStarted() {
		return _started;
	}

	@Override
	public <F extends EndpointFactory> void registerEndpointFactory(String name, Class<F> type) {
		if (!_started)
			throw new NSFBrokerException("NSF Broker is not running.");
		log.fine("NSF Broker: Registering factory " + name + " of type " + type.getName() + ".");
		try {
			EndpointFactory factory = (F) type.newInstance();
			factory.startup();
			factories.put(name, factory);
		} catch (InstantiationException | IllegalAccessException e) {
			log.severe("NSF Broker: Failed to register endpoint factory " + type.getName() + ": Reason: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deregisterEndpointFactory(String name) {
		if (!_started)
			throw new NSFBrokerException("NSF Broker is not running.");
		log.finest("NSF Broker: Releasing endpoint factory " + name + ".");
		if (hasEndpointFactory(name)) {
			EndpointFactory factory = factories.get(name);
			factory.shutdown();
			factories.remove(name);
		}
	}
	
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

	@Override
	public Endpoint getEndpoint(String server) {
		// TODO Auto-generated method stub
		if (!_started)
			return null;
		if (null == server || "".equals(server) || ConfigManager.getServerName().equals(server)) {
			return getLocalEndpoint(null);
		} else {
			
		}
		return null;
	}
	
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
	
	@Override
	public Endpoint getLocalEndpoint(String name) {
		if (!_started || null == defaultEndpoint)
			return null;
		EndpointConfig epcfg;
		if (null == name)
			epcfg = endpoints.get(defaultEndpoint);
		else
			epcfg = endpoints.get(name);
		// maybe just log a severe and return null here?
		if (!factories.containsKey(epcfg.type()))
			throw new NSFBrokerException("Unable to create endpoint: No endpoint factory of type " + epcfg.type() + " registered.");
		EndpointFactory factory = factories.get(epcfg.type());
		return factory.getEndpoint(null, epcfg);
	}

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

	private void readEndpointConfigs() {
		log.finest("NSF Broker: Getting list of endpoints registered locally.");
		// get a list of available endpoints
		String[] endpts = ConfigManager
				.getPropertyAsString(
						ConfigProperties.SECTION_REPOSITORIES + "." + ConfigProperties.LOCAL_REPOSITORY_LIST)
				.split(",");
		Map<String, String> options = null;
		for (String endpoint : endpts) {
			log.finest("NSF Broker: Registering endpoint " + endpoint + ".");
			// read options mentioned in notes.ini. NEEDS to have RepositoryType option
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
		defaultEndpoint = ConfigManager.getPropertyAsString(ConfigProperties.SECTION_REPOSITORIES + "." + ConfigProperties.DEFAULT_LOCAL_REPOSITORY);
		// mandatory to have default endpoint
		if (null == defaultEndpoint || "".equals(defaultEndpoint))
			throw new NSFBrokerException("No default endpoint set.");
		log.fine("NSF Broker: Default local endpoint is " + defaultEndpoint + ".");
	}

	// FIXME Are these 2 needed?
	@Override
	public EndpointConfig getEndpointConfig(String name) {
		return endpoints.get(name);
	}
	
	@Override
	public EndpointConfig getDefaultEndpointConfig() {
		if (null == defaultEndpoint || "".equals(defaultEndpoint))
			throw new NSFBrokerException("No default endpoint set.");
		return getEndpointConfig(defaultEndpoint);
	}
}
