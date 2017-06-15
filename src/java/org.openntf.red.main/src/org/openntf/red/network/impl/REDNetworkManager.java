/**
 * 
 */
package org.openntf.red.network.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Logger;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

import org.openntf.red.core.thread.IServerTask;
import org.openntf.red.network.INetworkManager;
import org.openntf.red.network.NetworkManagerException;

import javolution.util.FastMap;

/**
 * Default implementation of the Network Manager.
 * 
 * @author Vladimir Kornienko
 * @see INetworkManager
 * @since 0.4.0
 */
public class REDNetworkManager implements INetworkManager {

	/** Logger object. */
	private static final Logger log = Logger.getLogger(REDNetworkManager.class.getName());
	/**
	 * Instance of this Network Manager (only one such object should exist in a
	 * runtime).
	 */
	private static REDNetworkManager _instance = null;
	/** Server socket factory. */
	private ServerSocketFactory sofactory;// , sslsofactory;
	/** SSL server socket factory */
	private SSLServerSocketFactory sslsofactory;
	/** A map of occupied network ports and tasks that are bound to them. */
	private FastMap<Integer, IServerTask> claimedPorts;
	/**
	 * A map of occupied network ports and server sockets that are listening to
	 * them.
	 */
	private FastMap<Integer, ServerSocket> openSockets;
	/** Indicator whether the service is running. */
	private boolean _started;

	/**
	 * Default function to create a Network Manager instance.
	 * 
	 * @return Instance of a Network Manager.
	 * @since 0.4.0
	 */
	public static REDNetworkManager getInstance() {
		synchronized (REDNetworkManager.class) {
			if (null == _instance) {
				_instance = new REDNetworkManager();
			}
		}
		return _instance;
	}

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	private REDNetworkManager() {
		// TODO Auto-generated constructor stub
		_started = false;
	}

	@Override
	public void startup() {
		log.info("Network Manager: Starting...");
		// TODO Auto-generated method stub
		if (_started)
			throw new NetworkManagerException("Network Manager is already running.");
		// TODO make factories configurable?
		sofactory = ServerSocketFactory.getDefault();
		sslsofactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		claimedPorts = new FastMap<Integer, IServerTask>().atomic();
		openSockets = new FastMap<Integer, ServerSocket>().atomic();
		_started = true;
		log.info("Network Manager: Started.");
	}

	@Override
	public void shutdown() {
		log.info("Network Manager: Stopping...");
		// TODO Auto-generated method stub
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running");
		claimedPorts.clear();
		// TODO close all server sockets
		_started = false;
		log.info("Network Manager: Stopped.");
	}

	@Override
	public boolean isStarted() {
		return _started;
	}

	@Override
	public ServerSocket claimPort(IServerTask task, int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		Integer oport = Integer.valueOf(port);
		if (claimedPorts.containsKey(oport))
			return null; // TODO maybe exception?
		claimedPorts.put(oport, task);
		ServerSocket socket = null;
		log.finer("Network Manager: Reserving port number " + port + " for task: " + task.getClass().getName());
		try {
			socket = sofactory.createServerSocket(port);
			// socket = new ServerSocket(port);
			openSockets.put(oport, socket);
		} catch (IOException e) {
			log.throwing(REDNetworkManager.class.getName(), "claimPort(IServerTask, int)", e);
		}
		log.finer("Network Manager: Reserved port number " + port + " for task: " + task.getClass().getName());

		return socket;
	}

	@Override
	public ServerSocket claimPort(IServerTask task, int port, int backlog) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerSocket claimPort(IServerTask task, int port, int backlog, InetAddress addr) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releasePort(ServerSocket socket) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub

	}

	@Override
	public void releasePort(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		Integer oport = Integer.valueOf(port);
		claimedPorts.remove(oport);
		ServerSocket socket = openSockets.get(oport);
		if (null != socket) {
			log.fine("Network Manager: Releasing port " + port + ".");
			if (!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					// TODO handle this
				}
		}
		openSockets.remove(oport);
	}

	/**
	 * Not implemented yet.
	 */
	@Override
	public boolean isPortFree(int port) {
		// TODO Auto-generated method stub
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return true;
	}

	@Override
	public boolean isPortUnclaimed(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return !claimedPorts.containsKey(Integer.valueOf(port));
	}

	@Override
	public boolean isPortAvailable(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return isPortFree(port) && isPortUnclaimed(port);
	}

}
