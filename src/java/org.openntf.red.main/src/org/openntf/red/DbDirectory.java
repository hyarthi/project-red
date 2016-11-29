package org.openntf.red;

import java.util.Collection;
import java.util.Date;

import org.openntf.red.annotations.Legacy;
import org.openntf.red.types.SessionDescendant;
import org.openntf.red.util.DbDirectoryTree;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface DbDirectory.
 */
public interface DbDirectory
		extends Base, lotus.domino.DbDirectory, Collection<org.openntf.red.Database>, SessionDescendant {

	/**
	 * Enum to allow easy access to database types, e.g. Database, Template
	 * Candidate
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public static enum Type {

		/** The database. */
		DATABASE(DbDirectory.DATABASE),
		/** The template. */
		TEMPLATE(DbDirectory.TEMPLATE),
		/** The replica candidate. */
		REPLICA_CANDIDATE(DbDirectory.REPLICA_CANDIDATE),
		/** The template candidate. */
		TEMPLATE_CANDIDATE(DbDirectory.TEMPLATE_CANDIDATE);

		/**
		 * @Deprecated better use valueOf
		 */
		@Deprecated
		public static Type getType(final int value) {
			return valueOf(value);
		}

		/**
		 * Return the {@link DbDirectory.Type} of a numeric value
		 * 
		 * @param value
		 *            the numeric value
		 * @return a {@link DbDirectory.Type} Object
		 */
		public static Type valueOf(final int value) {
			for (Type type : Type.values()) {
				if (type.getValue() == value) {
					return type;
				}
			}
			return null;
		}

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new type.
		 * 
		 * @param value
		 *            the value
		 */
		private Type(final int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#createDatabase(java.lang.String)
	 */
	@Override
	public Database createDatabase(final String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#createDatabase(java.lang.String, boolean)
	 */
	@Override
	public Database createDatabase(final String dbFile, final boolean open);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getClusterName()
	 */
	@Override
	public String getClusterName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getClusterName(java.lang.String)
	 */
	@Override
	public String getClusterName(final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getFirstDatabase(int)
	 */
	@Override
	@Deprecated
	@Legacy(Legacy.ITERATION_WARNING)
	public Database getFirstDatabase(final int type);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getNextDatabase()
	 */
	@Override
	@Deprecated
	@Legacy(Legacy.ITERATION_WARNING)
	public Database getNextDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#isHonorShowInOpenDatabaseDialog()
	 */
	@Override
	public boolean isHonorShowInOpenDatabaseDialog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#openDatabase(java.lang.String)
	 */
	@Override
	public Database openDatabase(final String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#openDatabase(java.lang.String, boolean)
	 */
	@Override
	public Database openDatabase(final String dbFile, final boolean failover);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#openDatabaseByReplicaID(java.lang.String)
	 */
	@Override
	public Database openDatabaseByReplicaID(final String replicaId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#openDatabaseIfModified(java.lang.String,
	 * lotus.domino.DateTime)
	 */
	@Override
	public Database openDatabaseIfModified(final String dbFile, final lotus.domino.DateTime date);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#openMailDatabase()
	 */
	@Override
	public Database openMailDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.DbDirectory#setHonorShowInOpenDatabaseDialog(boolean)
	 */
	@Override
	public void setHonorShowInOpenDatabaseDialog(final boolean flag);

	Database openDatabaseIfModified(String dbFile, Date date);

	/**
	 * Deprecated, use {@link org.openntf.domino.DbDirectory#iterator()} instead
	 * to loop through databases in the Directory
	 * 
	 * @param type
	 *            Type database type, e.g. Database, Template,
	 *            Template_Candidate etc
	 * @return Database of type passed in
	 * @since org.openntf.domino 1.0.0
	 */
	@Deprecated
	@Legacy(Legacy.ITERATION_WARNING)
	public Database getFirstDatabase(final Type type);

	/**
	 * Whether or not the DbDirectory is sorted by Last Modified. Use
	 * {@link org.openntf.domino.DbDirectory#setSortByLastModified(boolean)} to
	 * sort the DbDirectory by last modified date
	 * 
	 * @return boolean, if sorted on last modified
	 * @since org.openntf.domino 4.5.0
	 */
	public boolean isSortByLastModified();

	/**
	 * Re-sorts the DbDirectory by Last Modified date or clears that sorting
	 * 
	 * @param value
	 *            boolean whether to sort on Last Modified date or not
	 * @since org.openntf.domino 4.5.0
	 */
	public void setSortByLastModified(final boolean value);

	/**
	 * Type of database the DbDirectory is, using
	 * {@link org.openntf.domino.DbDirectory.Type} enum. The default is
	 * TEMPLATE_CANDIDATE
	 * 
	 * @return org.openntf.domino.DbDirectory.Type of the database
	 * @since org.openntf.domino 4.5.0
	 */
	public Type getDirectoryType();

	/**
	 * Sets the type of database the DbDirectory is, using
	 * {@link org.openntf.domino.DbDirectory.Type} enum. The default is
	 * TEMPLATE_CANDIDATE
	 * 
	 * @param type
	 *            org.openntf.domino.DbDirectory.Type enum instance
	 * @since org.openntf.domino 4.5.0
	 */
	public void setDirectoryType(final Type type);

	/**
	 * Returns a tree datastructure, so that you easily can navigate through
	 * several directories
	 * 
	 * @return a DbDirectoryTree
	 */
	public DbDirectoryTree getTree();

	/**
	 * Returns a tree datastructure for a certain type, so that you easily can
	 * navigate through several directories
	 * 
	 * @param type
	 *            the type
	 * @return a DbDirectoryTree
	 */
	public DbDirectoryTree getTree(final Type type);

}
