package org.openntf.red;

import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import org.openntf.red.types.DatabaseDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface ViewEntry.
 */
public interface ViewEntry extends lotus.domino.ViewEntry, Base, DatabaseDescendant, Map<String, Object> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getChildCount()
	 */
	@Override
	public int getChildCount();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getColumnIndentLevel()
	 */
	@Override
	public int getColumnIndentLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getColumnValues()
	 */
	@Override
	public Vector<Object> getColumnValues();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getDescendantCount()
	 */
	@Override
	public int getDescendantCount();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getDocument()
	 */
	@Override
	public Document getDocument();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getIndentLevel()
	 */
	@Override
	public int getIndentLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getNoteID()
	 */
	@Override
	public String getNoteID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getNoteIDAsInt()
	 */
	@Override
	public int getNoteIDAsInt();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getParent()
	 */
	@Override
	public Base getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getPosition(char)
	 */
	@Override
	public String getPosition(final char separator);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getRead()
	 */
	@Override
	public boolean getRead();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(final String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getSiblingCount()
	 */
	@Override
	public int getSiblingCount();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getUniversalID()
	 */
	@Override
	public String getUniversalID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isCategory()
	 */
	@Override
	public boolean isCategory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isConflict()
	 */
	@Override
	public boolean isConflict();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isDocument()
	 */
	@Override
	public boolean isDocument();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isTotal()
	 */
	@Override
	public boolean isTotal();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isValid()
	 */
	@Override
	public boolean isValid();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(final boolean flag);

	/**
	 * Gets the View the ViewEntry is a child of
	 * 
	 * @return View parent
	 * @since org.openntf.domino 4.5.0
	 */
	public org.openntf.red.View getParentView();

	/**
	 * Gets a specific column's value, preferable to using getColumnValues()
	 * 
	 * @param columnName
	 *            String programmatic name of the column, found on the Advanced
	 *            tab (beanie image)
	 * @return Object representing the value for that column
	 * @since org.openntf.domino 3.0.0
	 */
	public Object getColumnValue(final String columnName);

	/**
	 * Gets a Map of column values, where the key is the programmatic name of
	 * the column, the value is the relevant column values for the ViewEntry
	 * 
	 * @return Map<String, Object>
	 * @since org.openntf.domino 3.0.0
	 */
	public Map<String, Object> getColumnValuesMap();

	/**
	 * Gets the column values as an unmodifiable collection, useful for caching
	 * 
	 * @return Collection<Object> of column values
	 * @since org.openntf.domino 3.0.0
	 */
	public Collection<Object> getColumnValuesEx();

	/**
	 * Gets a column value by programmatic column name, casting the return value
	 * to a specific Java class, e.g. <code>
	 * String nameColValue = ent.getColumnValue("name", String.class);
	 * </code>
	 * 
	 * @param columnName
	 *            String programmatic column name
	 * @param T
	 *            Class to cast the return value to
	 * @return Column value, cast to the specific class
	 * @since org.openntf.domino 5.0.0
	 */
	public <T> T getColumnValue(String columnName, Class<T> type);

	/**
	 * Gets the position of the entry with each level of the hierarchy separated
	 * by a '.'
	 * 
	 * <p>
	 * The position is relative to all entries and does not respect Readers
	 * fields (so if a non-categorized view contains 140 entries and you only
	 * have access to see 100, getPosition() on the last entry will return
	 * "140")
	 * <p/>
	 * 
	 * @return String position e.g. 3.4.2.7
	 * @since org.openntf.domino 5.0.0
	 */
	public String getPosition();

	public String getMetaversalID();

	public Object getCategoryValue();

}
