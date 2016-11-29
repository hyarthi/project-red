/**
 * 
 */
package org.openntf.red.network;

import java.net.InetAddress;
import java.net.ServerSocket;

import org.openntf.red.core.IREDService;
import org.openntf.red.core.thread.IServerTask;

/**
 * @author Vladimir Kornienko
 *
 */
public interface INetworkManager extends IREDService {
	public ServerSocket claimPort(IServerTask task, int port);
	public ServerSocket claimPort(IServerTask task, int port, int backlog);
	public ServerSocket claimPort(IServerTask task, int port, int backlog, InetAddress addr);
	public void releasePort(ServerSocket socket);
	public void releasePort(int port);
	public boolean isPortFree(int port);
	public boolean isPortUnclaimed(int port);
	public boolean isPortAvailable(int port);
	
	public static class Defaults {
		// port numbers
		public static final int DEFAULT_PORT_HTTP = 80;
		public static final int DEFAULT_PORT_HTTPS = 443;
		public static final int DEFAULT_PORT_NRPC = 1352;
		public static final int DEFAULT_PORT_RRPC = 1353;
	}
}
