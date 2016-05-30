/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.NotesProperty;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class PropertyBroker
		extends BaseNonThreadSafe<org.openntf.domino.PropertyBroker, lotus.domino.PropertyBroker, Session>
		implements org.openntf.domino.PropertyBroker {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected PropertyBroker(lotus.domino.PropertyBroker delegate, Session parent) {
		super(delegate, parent, NOTES_PROPERTYBROKER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearProperty(String propertyName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<NotesProperty> getInputPropertyContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesProperty getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getPropertyValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyValueString(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasProperty(String propertyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesProperty setPropertyValue(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void publish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
