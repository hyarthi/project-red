/**
 * 
 */
package org.openntf.red.nsf.couch;

import org.openntf.red.nsf.endpoint.Field;
import org.openntf.red.nsf.endpoint.Note;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchNote implements Note {

	/**
	 * 
	 */
	public CouchNote() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#setProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.HasProperties#removeProperty(java.lang.String)
	 */
	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#castTo(java.lang.Class)
	 */
	@Override
	public <T extends Base> T castTo(Class<T> type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#getField(java.lang.String)
	 */
	@Override
	public Field getField(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#setField(java.lang.String, org.openntf.red.nsf.endpoint.Field)
	 */
	@Override
	public void setField(String name, Field value) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.red.nsf.endpoint.Note#removeField(java.lang.String)
	 */
	@Override
	public Field removeField(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
