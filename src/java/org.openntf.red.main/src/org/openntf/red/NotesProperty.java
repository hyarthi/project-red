package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.SessionDescendant;

/**
 * Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface NotesProperty.
 */
public interface NotesProperty extends Base, lotus.domino.NotesProperty, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#clear()
	 */
	@Override
	public void clear();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getDescription()
	 */
	@Override
	public String getDescription();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getNamespace()
	 */
	@Override
	public String getNamespace();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getTitle()
	 */
	@Override
	public String getTitle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getTypeName()
	 */
	@Override
	public String getTypeName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getValues()
	 */
	@Override
	public Vector<Object> getValues();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#getValueString()
	 */
	@Override
	public String getValueString();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#isInput()
	 */
	@Override
	public boolean isInput();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.NotesProperty#publish()
	 */
	@Override
	public void publish();

}
