/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import org.openntf.red.nsf.exceptions.ConverterException;

/**
 * @author Vladimir Kornienko
 *
 */
public abstract class RawDataConverter {
	private int type;

	/**
	 * 
	 */
	public RawDataConverter(int type) {
		this.type = type;
	}
	
	public final int getType() {
		return type;
	}
	
	public abstract Object parseReadData(Object raw) throws ConverterException;
	public abstract Object parseWriteData(Object data) throws ConverterException;
}
