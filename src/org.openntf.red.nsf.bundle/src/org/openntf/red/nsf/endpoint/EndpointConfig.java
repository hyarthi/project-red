/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.io.Serializable;
import java.util.Map;

import javolution.util.FastMap;

/**
 * @author Vladimir Kornienko
 *
 */
public class EndpointConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8185720382385068083L;
	private String name;
	private String type;
	private FastMap<String, String> options;

	/**
	 * 
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
	
	public String name() {
		return name;
	}
	
	public String type() {
		return type;
	}
	
	public Map<String, String> options() {
		return options;
	}
}
