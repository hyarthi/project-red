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
 * @author Vladimir Kornienko
 *
 */
public class REDNetworkManager implements INetworkManager {
	
	private static Logger log = Logger.getLogger(REDNetworkManager.class.getName());
	
	private static REDNetworkManager _instance = null;

	private ServerSocketFactory sofactory;//, sslsofactory;
	private SSLServerSocketFactory sslsofactory;
	private FastMap<Integer, IServerTask> claimedPorts;
	private FastMap<Integer, ServerSocket> openSockets;
	private boolean _started;
	
	public static REDNetworkManager getInstance() {
		synchronized (REDNetworkManager.class) {
			if (null == _instance) {
				_instance = new REDNetworkManager();
			}
		}
		return _instance;
	}
	
	/**
	 * 
	 */
	private REDNetworkManager() {
		// TODO Auto-generated constructor stub
		_started = false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.core.IREDService#startup()
	 */
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

	/* (non-Javadoc)
	 * @see org.openntf.red.core.IREDService#shutdown()
	 */
	@Override
	public void shutdown() {
		log.info("Network Manager: Stopping...");
		// TODO Auto-generated method stub
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running");
		claimedPorts.clear();
		_started = false;
		log.info("Network Manager: Stopped.");
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.core.IREDService#isStarted()
	 */
	@Override
	public boolean isStarted() {
		return _started;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#claimPort(java.lang.Runnable, int)
	 */
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
			//socket = new ServerSocket(port);
			openSockets.put(oport, socket);
		} catch (IOException e) {
			log.throwing(REDNetworkManager.class.getName(), "claimPort(IServerTask, int)", e);
		}
		log.finer("Network Manager: Reserved port number " + port + " for task: " + task.getClass().getName());
		
		return socket;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#claimPort(java.lang.Runnable, int, int)
	 */
	@Override
	public ServerSocket claimPort(IServerTask task, int port, int backlog) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#claimPort(java.lang.Runnable, int, int, java.net.InetAddress)
	 */
	@Override
	public ServerSocket claimPort(IServerTask task, int port, int backlog, InetAddress addr) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#releasePort(java.net.ServerSocket)
	 */
	@Override
	public void releasePort(ServerSocket socket) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#releasePort(int)
	 */
	@Override
	public void releasePort(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		Integer oport = Integer.valueOf(port);
		claimedPorts.remove(oport);
		ServerSocket socket = openSockets.get(oport);
		if (null != socket) {
			log.fine("Network Manager: Releasing port " + port + ".");
			if(!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					// TODO handle this
				}
		}
		openSockets.remove(oport);
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#isPortFree(int)
	 */
	@Override
	public boolean isPortFree(int port) {
		// TODO Auto-generated method stub
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return true;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#isPortUnclaimed(int)
	 */
	@Override
	public boolean isPortUnclaimed(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return !claimedPorts.containsKey(Integer.valueOf(port));
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.network.INetworkManager#isPortAvailable(int)
	 */
	@Override
	public boolean isPortAvailable(int port) {
		if (!_started)
			throw new NetworkManagerException("Network Manager is not running.");
		return isPortFree(port) && isPortUnclaimed(port);
	}

}
