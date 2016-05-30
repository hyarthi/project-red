/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.PropertyBroker;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class NotesProperty
		extends BaseNonThreadSafe<org.openntf.domino.NotesProperty, lotus.domino.NotesProperty, PropertyBroker>
		implements org.openntf.domino.NotesProperty {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected NotesProperty(lotus.domino.NotesProperty delegate, PropertyBroker parent) {
		super(delegate, parent, NOTES_OUTLINE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValueString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInput() {
		// TODO Auto-generated method stub
		return false;
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
