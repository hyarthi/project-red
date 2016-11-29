package org.openntf.red;

import java.util.Collection;

import org.openntf.red.types.DatabaseDescendant;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface ReplicationEntry.
 */
public interface ReplicationEntry extends Base, lotus.domino.ReplicationEntry, DatabaseDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#getDestination()
	 */
	@Override
	public String getDestination();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#getFormula()
	 */
	@Override
	public String getFormula();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#getSource()
	 */
	@Override
	public String getSource();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#getViews()
	 */
	@Override
	public String getViews();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#isIncludeACL()
	 */
	@Override
	public boolean isIncludeACL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#isIncludeAgents()
	 */
	@Override
	public boolean isIncludeAgents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#isIncludeDocuments()
	 */
	@Override
	public boolean isIncludeDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#isIncludeForms()
	 */
	@Override
	public boolean isIncludeForms();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#isIncludeFormulas()
	 */
	@Override
	public boolean isIncludeFormulas();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#remove()
	 */
	@Override
	public int remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#save()
	 */
	@Override
	public int save();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setFormula(java.lang.String)
	 */
	@Override
	public void setFormula(final String formula);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setIncludeACL(boolean)
	 */
	@Override
	public void setIncludeACL(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setIncludeAgents(boolean)
	 */
	@Override
	public void setIncludeAgents(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setIncludeDocuments(boolean)
	 */
	@Override
	public void setIncludeDocuments(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setIncludeForms(boolean)
	 */
	@Override
	public void setIncludeForms(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setIncludeFormulas(boolean)
	 */
	@Override
	public void setIncludeFormulas(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ReplicationEntry#setViews(java.lang.String)
	 */
	@Override
	public void setViews(final String views);

	/**
	 * Sets the views.
	 * 
	 * @param views
	 *            the new views
	 */
	public void setViews(final Collection<String> views);

	/**
	 * Gets the parent Replication object of the entry
	 * 
	 * @return Replication parent
	 * @since org.openntf.domino 1.0.0
	 */
	public Replication getParent();

}
