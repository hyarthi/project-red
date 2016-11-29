package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface PropertyBroker.
 */
public interface PropertyBroker extends Base, lotus.domino.PropertyBroker, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#clearProperty(java.lang.String)
	 */
	@Override
	public void clearProperty(final String propertyName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#getInputPropertyContext()
	 */
	@Override
	public Vector<NotesProperty> getInputPropertyContext();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#getProperty(java.lang.String)
	 */
	@Override
	public NotesProperty getProperty(final String propertyName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#getPropertyValue(java.lang.String)
	 */
	@Override
	public Vector<Object> getPropertyValue(final String propertyName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#getPropertyValueString(java.lang.String)
	 */
	@Override
	public String getPropertyValueString(final String propertyName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#hasProperty(java.lang.String)
	 */
	@Override
	public boolean hasProperty(final String propertyName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#setPropertyValue(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public NotesProperty setPropertyValue(final String propertyName, final Object propertyValue);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.PropertyBroker#publish()
	 */
	@Override
	public void publish();
}
