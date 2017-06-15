/**
 * 
 */
package org.openntf.red.network;

import java.net.InetAddress;
import java.net.ServerSocket;

import org.openntf.red.core.IREDService;
import org.openntf.red.core.thread.IServerTask;

/**
 * Interface representing an abstract Network Manager.
 * <p>
 * Network manager is the central point of network management (ports, clients,
 * etc.).
 * <p>
 * Implementations may vary, but this is the interface all code should work
 * with.
 * 
 * @author Vladimir Kornienko
 * @see IRedService
 * @since 0.4.0
 */
public interface INetworkManager extends IREDService {
	/**
	 * Reserve a port number for a specific server task (given that it is
	 * available).
	 * 
	 * @param task
	 *            Task to reserve the port for.
	 * @param port
	 *            Port number to reserve.
	 * @return Server socket bound to a specific port number.
	 * @since 0.4.0
	 * @see IServerTask
	 */
	public ServerSocket claimPort(IServerTask task, int port);

	/**
	 * Reserve a port number for a specific server task (given that it is
	 * available).
	 * 
	 * @param task
	 *            Task to reserve the port for.
	 * @param port
	 *            Port number to reserve.
	 * @param backlog
	 *            Socket backlog size.
	 * @return Server socket bound to a specific port number.
	 * @since 0.4.0
	 * @see IServerTask
	 */
	public ServerSocket claimPort(IServerTask task, int port, int backlog);

	/**
	 * Reserve a port number for a specific server task (given that it is
	 * available).
	 * 
	 * @param task
	 *            Task to reserve the port for.
	 * @param port
	 *            Port number to reserve.
	 * @param backlog
	 *            Socket backlog size.
	 * @param addr
	 *            URI to bind the socket to.
	 * @return Server socket bound to a specific port number.
	 * @since 0.4.0
	 * @see {@link IServerTask}, {@link InetAddress}
	 */
	public ServerSocket claimPort(IServerTask task, int port, int backlog, InetAddress addr);

	/**
	 * Unbinds the server task from port & socket, then releases the socket &
	 * port.
	 * 
	 * @param socket
	 *            Server socket to clear.
	 * @since 0.4.0
	 */
	public void releasePort(ServerSocket socket);

	/**
	 * Unbinds the server task from port & socket, then releases the socket &
	 * port.
	 * 
	 * @param port
	 *            Port number to clear.
	 * @since 0.4.0
	 */
	public void releasePort(int port);

	/**
	 * Checks if the port with a specified number is free.
	 * 
	 * @param port
	 *            Port number to check.
	 * @return Whether the port is free.
	 * @since 0.4.0
	 */
	public boolean isPortFree(int port);

	/**
	 * Checks if the port with a specified number is already occupied by a
	 * server task.
	 * 
	 * @param port
	 *            Port number to check.
	 * @return Whether the port is unclaimed.
	 * @since 0.4.0
	 */
	public boolean isPortUnclaimed(int port);

	/**
	 * Checks if the port with a specified number is not claimed by a server
	 * task AND whether it's free (it may be occupied by an external
	 * application).
	 * <p>
	 * Equivalent to AND'ing results of <code>isPortFree()</code> and
	 * <code>isPortUnclaimed()</code>.
	 * 
	 * @param port
	 *            Port number to check.
	 * @return Whether the port is available.
	 * @since 0.4.0
	 */
	public boolean isPortAvailable(int port);

	/**
	 * Defaults collection for Network Manager (e.g. default port numbers).
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Defaults {
		// port numbers
		public static final int DEFAULT_PORT_HTTP = 80;
		public static final int DEFAULT_PORT_HTTPS = 443;
		public static final int DEFAULT_PORT_NRPC = 1352;
		public static final int DEFAULT_PORT_RRPC = 1353;
	}
}
