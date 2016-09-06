/**
 * 
 */
package org.openntf.red.nsf.couch;

import java.util.logging.Logger;

import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.endpoint.ViewEntry;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchView implements View<CouchEndpoint, CouchEndpointFactory, CouchDatabase> {
	
	private static Logger log = Logger.getLogger(CouchView.class.getName());

	/**
	 * 
	 */
	public CouchView() {
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
	 * @see org.openntf.red.nsf.endpoint.View#getFirstEntry()
	 */
	@Override
	public ViewEntry getFirstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.View#getLastEntry()
	 */
	@Override
	public ViewEntry getLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.View#getNthEntry()
	 */
	@Override
	public ViewEntry getNthEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.red.nsf.endpoint.View#removeEntry(long)
	 */
	@Override
	public ViewEntry removeEntry(long position) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.View#setEntry(org.openntf.red.nsf.endpoint.
	 * ViewEntry, long)
	 */
	@Override
	public void setEntry(ViewEntry entry, long position) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openntf.red.nsf.endpoint.View#addEntry(org.openntf.red.nsf.endpoint.
	 * ViewEntry)
	 */
	@Override
	public void addEntry(ViewEntry entry) {
		// TODO Auto-generated method stub

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
	public CouchDatabase getParent() {
		// TODO Auto-generated method stub
		return null;
	}

}
