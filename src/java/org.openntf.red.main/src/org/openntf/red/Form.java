package org.openntf.red;

import java.util.Vector;

import org.openntf.red.types.DatabaseDescendant;
import org.openntf.red.types.Design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Form.
 */
public interface Form extends Base, lotus.domino.Form, Design, DatabaseDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getAliases()
	 */
	@Override
	public Vector<String> getAliases();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getFields()
	 */
	@Override
	public Vector<String> getFields();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getFieldType(java.lang.String)
	 */
	@Override
	public int getFieldType(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getFormUsers()
	 */
	@Override
	public Vector<String> getFormUsers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getHttpURL()
	 */
	@Override
	public String getHttpURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getLockHolders()
	 */
	@Override
	public Vector<String> getLockHolders();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getNotesURL()
	 */
	@Override
	public String getNotesURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getParent()
	 */
	@Override
	public Database getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getReaders()
	 */
	@Override
	public Vector<String> getReaders();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#getURL()
	 */
	@Override
	public String getURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#isProtectReaders()
	 */
	@Override
	public boolean isProtectReaders();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#isProtectUsers()
	 */
	@Override
	public boolean isProtectUsers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#isSubForm()
	 */
	@Override
	public boolean isSubForm();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock()
	 */
	@Override
	public boolean lock();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock(boolean)
	 */
	@Override
	public boolean lock(final boolean provisionalOk);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock(java.lang.String)
	 */
	@Override
	public boolean lock(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(final String name, final boolean provisionalOk);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(final Vector names, final boolean provisionalOk);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lockProvisional()
	 */
	@Override
	public boolean lockProvisional();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#setFormUsers(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setFormUsers(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#setProtectReaders(boolean)
	 */
	@Override
	public void setProtectReaders(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#setProtectUsers(boolean)
	 */
	@Override
	public void setProtectUsers(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#setReaders(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setReaders(final Vector names);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Form#unlock()
	 */
	@Override
	public void unlock();

	/**
	 * Gets the number of documents that use this Form and have been modified
	 * since a given Java date
	 * 
	 * @param since
	 *            Date the method should compare against
	 * @return int number of documents using this Form modified
	 * @since org.openntf.domino 3.0.0
	 */
	public int getModifiedNoteCount(final java.util.Date since);

	/**
	 * Gets the XPage that this Form is set to launch on the web as ($XPageAlt
	 * field)
	 * 
	 * @return String XPage to Form is designed to launch with on web
	 * @since org.openntf.domino 4.5.0
	 */
	public String getXPageAlt();

	/**
	 * Gets the XPage that this Form is set to launch in the client as
	 * ($XPageAltClient field, if defined, else $XPageAlt)
	 * 
	 * @return String XPage to Form is designed to launch with on client
	 * @since org.openntf.domino 5.0.0
	 */
	public String getXPageAltClient();

	/**
	 * Generates a selection formula in format:
	 * 
	 * <code>SELECT Form = "myFormName" | Form = "myFormAlias" | Form = "myFormSecondAlias" etc.</code>
	 * 
	 * <p>
	 * Continues for as many aliases as the Form has, not including aliases if
	 * none is defined.
	 * </p>
	 * 
	 * <p>
	 * NOTE: Forms view in an NSF only displays the first alias of a design
	 * element, deisng element's properties box will shows all.
	 * </p>
	 * 
	 * @return String selection formula to access all Documents created with
	 *         that Form
	 * @since org.openntf.domino 3.0.0
	 */
	public String getSelectionFormula();

	public NoteCollection getNoteCollection();

}
