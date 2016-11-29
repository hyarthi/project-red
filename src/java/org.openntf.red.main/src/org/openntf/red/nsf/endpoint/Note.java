/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Note<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Database<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {
	/**
	 * 
	 * @param type
	 * @return
	 */
	public <T extends lotus.domino.Base> T castTo(Class<T> type) throws ClassCastException;

	/**
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Field getField(String name);

	/**
	 * 
	 * @param name
	 * @param value
	 */
	@SuppressWarnings("rawtypes")
	public void setField(String name, Field value);

	/**
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Field removeField(String name);
	
	public String getUniversalID();
	
	public List<String> getAllFieldNames();
	
	@SuppressWarnings("rawtypes")
	public Map<String, Field> getFieldsAsMap();
	
	public Set<String> keySet();
}
