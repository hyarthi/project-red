/**
 * 
 */
package org.openntf.red.nsf.impl.couch.converters;

import org.openntf.red.nsf.endpoint.RawDataConverter;
import org.openntf.red.nsf.exceptions.ConverterException;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchFormulaConverter extends RawDataConverter {

	/**
	 * @param type
	 */
	public CouchFormulaConverter(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.RawDataConverter#parseReadData(java.lang.Object)
	 */
	@Override
	public Object parseReadData(Object raw) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.RawDataConverter#parseWriteData(java.lang.Object)
	 */
	@Override
	public Object parseWriteData(Object data) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
