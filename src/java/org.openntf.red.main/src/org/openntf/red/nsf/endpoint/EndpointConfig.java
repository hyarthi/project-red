/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.io.Serializable;
import java.util.Map;

import javolution.util.FastMap;

/**
 * Entity representing the endpoint configuration options. Procured from config
 * manager. Used to initialize endpoints.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public class EndpointConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8185720382385068083L;
	/** Endpoint symbolic name. */
	private String name;
	/** Endpoint type. */
	private String type;
	/** List of options for this endpoint. */
	private FastMap<String, String> options;

	/**
	 * Default cosntructor.
	 * 
	 * @param _name
	 *            Endpoint symbolic name.
	 * @param _type
	 *            Endpoint type.
	 * @param _options
	 *            Endpoint options.
	 * @since 0.4.0
	 */
	public EndpointConfig(String _name, String _type, Map<String, String> _options) {
		name = _name;
		type = _type;
		if (_options instanceof FastMap)
			options = (FastMap<String, String>) _options;
		else {
			options = FastMap.of(_options);
		}
	}

	/**
	 * Returns the endpoint symbolic name.
	 * 
	 * @return Endpoint symbolic name.
	 * @since 0.4.0
	 */
	public String name() {
		return name;
	}

	/**
	 * Returns the endpoint type.
	 * 
	 * @return Endpoint type.
	 * @since 0.4.0
	 */
	public String type() {
		return type;
	}

	/**
	 * Returns the endpoint options list.
	 * 
	 * @return Endpoint options list.
	 * @since 0.4.0
	 */
	public Map<String, String> options() {
		return options;
	}
}
