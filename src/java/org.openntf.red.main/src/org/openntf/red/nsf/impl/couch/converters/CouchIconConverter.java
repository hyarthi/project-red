/**
 * 
 */
package org.openntf.red.nsf.impl.couch.converters;

import org.openntf.red.nsf.endpoint.RawDataConverter;
import org.openntf.red.nsf.exceptions.ConverterException;

/**
 * Icon converter for CouchDB.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see RawDataConverter
 */
public class CouchIconConverter extends RawDataConverter {

	/**
	 * Default constructor.
	 * 
	 * @param type
	 *            Data type code.
	 * @since 0.4.0
	 */
	public CouchIconConverter(int type) {
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
