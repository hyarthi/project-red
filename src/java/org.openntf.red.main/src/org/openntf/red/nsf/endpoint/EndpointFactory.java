/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * Entity representing the endpoint factory. Endpoint factories are used to
 * create endpoints that are then used to access the data stored within a
 * specific endpoint.
 * <p>
 * This should be the point of entry to the data.
 * <p>
 * A single endpoint factory may support multiple endpoints.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface EndpointFactory {
	/**
	 * Returns an endpoint given a server name and endpoint options. If no
	 * object found in cache, a new object is created.
	 * 
	 * @param server
	 *            Server name.
	 * @param config
	 *            Endpoint config.
	 * @return Endpoint object.
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(String server, EndpointConfig config);

	/**
	 * Returns a local endpoint given it's config. If no object found in cache,
	 * a new object is created.
	 * 
	 * @param config
	 *            Endpoint config.
	 * @return Endpoint object
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(EndpointConfig config);

	/**
	 * Initializes the endpoint factory. Should be done before any operations
	 * are performed with it.
	 * 
	 * @since 0.4.0
	 */
	public void startup();

	/**
	 * Destroys and cleans up the factory.
	 * 
	 * @since 0.4.0
	 */
	public void shutdown();

	/**
	 * Checks whether the factory is initialized and ready to go.
	 * 
	 * @return Whether the factory is initialized.
	 * @since 0.4.0
	 */
	public boolean isStarted();

	/**
	 * Registers a converter with the endpoint factory. An endpoint factory
	 * posesses a default converter for each of the default data types.
	 * <p>
	 * If a custom converter is registered for an existing data type, it
	 * overrides the default converter (up to the point, when it gets
	 * deregistered).
	 * <p>
	 * If a converter is registered for a custom data type, it will be invoked
	 * if a data type with a specific code is discovered.
	 * 
	 * @param converter
	 *            Data converter to register.
	 * @since 0.4.0
	 */
	public void registerConverter(RawDataConverter converter);

	/**
	 * Deregisters a converter given the data type code.
	 * <p>
	 * Default data converters can not be deregistered, but can be overridden.
	 * 
	 * @param type
	 *            Data type code.
	 * @since 0.4.0
	 */
	public void deregisterConverter(int type);

	/**
	 * Parses data from the endpoint into the runtime-acceptable format.
	 * <p>
	 * Uses data converters to process raw data procured from the endpoint.
	 * <p>
	 * If an unrecognized data type is read, the
	 * {@link #closestTypeMatch(Object, int)} function should be run to attempt
	 * to find the next-best data type option. If no match is found, an
	 * exception should be thrown.
	 * 
	 * @param raw
	 *            Raw data read from the endpoint.
	 * @param fromType
	 *            Data type of the raw data.
	 * @return Runtime-acceptable form of data.
	 * @since 0.4.0
	 */
	public Object parseReadData(Object raw, int fromType);

	/**
	 * Parses data from runtime-acceptable format to endpoint-specific format.
	 * <p>
	 * Uses data converters to process raw data procured from the endpoint.
	 * 
	 * @param data
	 *            Runtime-acceptable form of data.
	 * @param toType
	 *            Data type.
	 * @return Endpoint-specific form of data.
	 * @since 0.4.0
	 */
	public Object parseWriteData(Object data, int toType);

	/**
	 * Determines the next-best option for data type, if the original data type
	 * can not be determined.
	 * 
	 * @param data
	 *            Raw data to process.
	 * @param recursion
	 *            Recursion step (no deeper than 5).
	 * @return Data type code.
	 * @since 0.4.0
	 */
	public int closestTypeMatch(Object data, int recursion);

	/**
	 * Returns whether the endpoint factory will fall back to default data
	 * converter if a custom data converter throws an exception.
	 * 
	 * @return <code>true</code> - endpoint factory will stop and throw the
	 *         original exception, <code>false</code> - endpoint factory will
	 *         fall back to default data converter (if available) on exception.
	 * @since 0.4.0
	 */
	public boolean isBreakOnCustomConverterExceptions();

	/**
	 * Sets whether the endpoint factory should stop on custom converter
	 * exception, or attempt to fall back to default data converter (if
	 * available).
	 * 
	 * @param flag
	 *            <code>true</code> - endpoint factory will stop and throw the
	 *            original exception, <code>false</code> - endpoint factory will
	 *            fall back to default data converter (if available) on
	 *            exception.
	 * @since 0.4.0
	 */
	public void setBreakOnCustomConverterExceptions(boolean flag);
}
