/**
 * 
 */
package org.openntf.red.nsf.impl.couch.converters;

import org.openntf.red.nsf.endpoint.RawDataConverter;
import org.openntf.red.nsf.exceptions.ConverterException;

/**
 * Unknown object converter for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see RawDataConverter
 */
public class CouchUnknownConverter extends RawDataConverter {

	/**
	 * Default constructor.
	 * 
	 * @param type
	 *            Data type code.
	 * @since 0.4.0
	 */
	public CouchUnknownConverter(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * (Under construction)
	 */
	@Override
	public Object parseReadData(Object raw) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (Under construction)
	 */
	@Override
	public Object parseWriteData(Object data) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
