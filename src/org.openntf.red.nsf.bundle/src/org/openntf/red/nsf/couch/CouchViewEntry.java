/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.ViewEntry;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchViewEntry implements ViewEntry<CouchEndpoint, CouchEndpointFactory, CouchView> {
	
	private static Logger log = Logger.getLogger(CouchViewEntry.class.getName());

	/**
	 * 
	 */
	public CouchViewEntry() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.HasProperties#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.HasProperties#setProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.HasProperties#removeProperty(java.lang.
	 * String)
	 */
	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.ViewEntry#getColumn(int)
	 */
	@Override
	public Object getColumn(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.ViewEntry#getColumn(java.lang.String)
	 */
	@Override
	public Object getColumn(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouchEndpointFactory getAncestorFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouchEndpoint getAncestorEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouchView getParent() {
		// TODO Auto-generated method stub
		return null;
	}

}
