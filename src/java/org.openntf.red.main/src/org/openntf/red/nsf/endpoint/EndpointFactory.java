/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Korniekno
 *
 */
public interface EndpointFactory {
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(String server, EndpointConfig config);
	@SuppressWarnings("rawtypes")
	public Endpoint getEndpoint(EndpointConfig config);
	public void startup();
	public void shutdown();
	public boolean isStarted();
	public void registerConverter(RawDataConverter converter);
	public void deregisterConverter(int type);
	public Object parseReadData(Object raw, int fromType);
	public Object parseWriteData(Object data, int toType);
	public int closestTypeMatch(Object data, int recursion);
	public boolean isBreakOnCustomConverterExceptions();
	public void setBreakOnCustomConverterExceptions(boolean flag);
}
