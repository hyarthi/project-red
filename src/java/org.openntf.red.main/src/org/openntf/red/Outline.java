package org.openntf.red;

import org.openntf.red.types.DatabaseDescendant;
import org.openntf.red.types.Design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Outline.
 */
public interface Outline extends Base, lotus.domino.Outline, Design, DatabaseDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#addEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry)
	 */
	@Override
	@Deprecated
	public void addEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#addEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean)
	 */
	@Override
	@Deprecated
	public void addEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#addEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean, boolean)
	 */
	@Override
	@Deprecated
	public void addEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after, final boolean asChild);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry createEntry(final lotus.domino.OutlineEntry fromEntry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry createEntry(final lotus.domino.OutlineEntry fromEntry,
			final lotus.domino.OutlineEntry referenceEntry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean)
	 */
	@Override
	public OutlineEntry createEntry(final lotus.domino.OutlineEntry fromEntry,
			final lotus.domino.OutlineEntry referenceEntry, final boolean after);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean, boolean)
	 */
	@Override
	public OutlineEntry createEntry(final lotus.domino.OutlineEntry fromEntry,
			final lotus.domino.OutlineEntry referenceEntry, final boolean after, final boolean asChild);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(java.lang.String)
	 */
	@Override
	public OutlineEntry createEntry(final String entryName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(java.lang.String,
	 * lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry createEntry(final String entryName, final lotus.domino.OutlineEntry referenceEntry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(java.lang.String,
	 * lotus.domino.OutlineEntry, boolean)
	 */
	@Override
	public OutlineEntry createEntry(final String entryName, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#createEntry(java.lang.String,
	 * lotus.domino.OutlineEntry, boolean, boolean)
	 */
	@Override
	public OutlineEntry createEntry(final String entryName, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after, final boolean asChild);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getAlias()
	 */
	@Override
	public String getAlias();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getChild(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getChild(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getComment()
	 */
	@Override
	public String getComment();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getFirst()
	 */
	@Override
	public OutlineEntry getFirst();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getLast()
	 */
	@Override
	public OutlineEntry getLast();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getNext(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getNext(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getNextSibling(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getNextSibling(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getParent(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getParent(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getParentDatabase()
	 */
	@Override
	public Database getParentDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getPrev(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getPrev(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#getPrevSibling(lotus.domino.OutlineEntry)
	 */
	@Override
	public OutlineEntry getPrevSibling(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#moveEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry)
	 */
	@Override
	public void moveEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#moveEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean)
	 */
	@Override
	public void moveEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#moveEntry(lotus.domino.OutlineEntry,
	 * lotus.domino.OutlineEntry, boolean, boolean)
	 */
	@Override
	public void moveEntry(final lotus.domino.OutlineEntry entry, final lotus.domino.OutlineEntry referenceEntry,
			final boolean after, final boolean asChild);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#removeEntry(lotus.domino.OutlineEntry)
	 */
	@Override
	public void removeEntry(final lotus.domino.OutlineEntry entry);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#save()
	 */
	@Override
	public int save();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#setAlias(java.lang.String)
	 */
	@Override
	public void setAlias(final String alias);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#setComment(java.lang.String)
	 */
	@Override
	public void setComment(final String comment);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Outline#setName(java.lang.String)
	 */
	@Override
	public void setName(final String name);

}
