/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import org.openntf.red.nsf.exceptions.ConverterException;

/**
 * Abstract raw data converter definition. All data converters should extend
 * this type.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public abstract class RawDataConverter {
	/** Data type code serviced by this converter. */
	private int type;

	/**
	 * Default constructor.
	 * 
	 * @param type
	 *            Data type code serviced by this converter.
	 * @since 0.4.0
	 */
	public RawDataConverter(int type) {
		this.type = type;
	}

	/**
	 * Returns the data type code service by this converter.
	 * 
	 * @return Data type code service by this converter.
	 * @since 0.4.0
	 */
	public final int getType() {
		return type;
	}

	/**
	 * Parses data for read operation. Converts raw data into runtime-acceptable
	 * form.
	 * 
	 * @param raw
	 *            Raw data.
	 * @return Runtime-acceptable form of data.
	 * @throws ConverterException
	 *             If any errors occur.
	 * @since 0.4.0
	 */
	public abstract Object parseReadData(Object raw) throws ConverterException;

	/**
	 * Parses data for write operation. Converts data from runtime-acceptable
	 * form into raw form stored in the back-end.
	 * 
	 * @param data
	 *            Runtime-acceptable form.
	 * @return Raw form.
	 * @throws ConverterException
	 *             If any errors occur.
	 * @since 0.4.0
	 */
	public abstract Object parseWriteData(Object data) throws ConverterException;
}
