package org.openntf.red.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;

import org.openntf.red.Database;
import org.openntf.red.Session;

/**
 * This class is for simple navigation in the directory structure of a DominoServer (and is still experimental)
 * 
 * @author Roland Praml, FOCONIS AG
 * 
 */
public class DbDirectoryTree {
	private DbDirectoryTree parent_;
	private Session session_;

	private Map<String, DbDirectoryTree> subDirs = new TreeMap<String, DbDirectoryTree>();
	private Map<String, DatabaseMetaData> files = new TreeMap<String, DatabaseMetaData>();
	private String directory_ = "";

	public DbDirectoryTree(final SortedSet<DatabaseMetaData> metaDataSet, final Session session) {
		session_ = session;

		for (DatabaseMetaData metaData : metaDataSet) {
			String fileName = metaData.getFilePath().replace('\\', '/');
			String[] components = fileName.split("/");
			add(components, metaData, 0);
		}
	}

	public DbDirectoryTree(final DbDirectoryTree parent, final Session session, final String dirName) {
		session_ = session;
		parent_ = parent;
		directory_ = dirName;
	}

	private void add(final String[] components, final DatabaseMetaData metaData, final int level) {
		if (components.length == level + 1) {
			files.put(components[level], metaData);
		} else {
			String dir = components[level];
			DbDirectoryTree subDir = subDirs.get(dir);
			if (subDir == null) {
				subDir = new DbDirectoryTree(this, session_, dir);
				subDirs.put(dir, subDir);
			}
			subDir.add(components, metaData, level + 1);
		}
	}

	/**
	 * Print Dir structure in a "tree style"
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Directory listing for: ");
		if (getParent() == null) {
			sb.append("<ROOT>\n");
		} else {
			sb.append(getDirPath());
			sb.append('\n');
		}
		toString(sb, "");

		return sb.toString();

	}

	/**
	 * Return the parent directory
	 * 
	 */
	public DbDirectoryTree getParent() {
		return parent_;
	}

	/**
	 * Return the complete dir layout of this node
	 * 
	 */
	public String getDirPath() {
		if (getParent() == null)
			return directory_;
		String parentDir = getParent().getDirPath();
		if (!parentDir.isEmpty()) {
			return parentDir + "/" + directory_;
		}
		return directory_;
	}

	private void toString(final StringBuilder sb, final String indent) {
		for (Entry<String, DbDirectoryTree> e : subDirs.entrySet()) {
			sb.append(indent);
			sb.append('[');
			sb.append(e.getKey());
			sb.append("]\n");
			e.getValue().toString(sb, indent.concat("    "));
		}
		for (Entry<String, DatabaseMetaData> e : files.entrySet()) {
			sb.append(indent);
			sb.append(e.getKey());
			sb.append('\n');
		}
	}

	/**
	 * Return a list of DatabaseMetaData in this directory and optional in this subdirectories
	 * 
	 */
	public List<DatabaseMetaData> getDatabaseMetaDatas(final boolean recursive) {
		return getDatabaseMetaDatas(null, recursive);
	}

	public List<DatabaseMetaData> getDatabaseMetaDatas(List<DatabaseMetaData> ret, final boolean recursive) {
		if (ret == null)
			ret = new ArrayList<DatabaseMetaData>();
		for (DatabaseMetaData f : files.values()) {
			ret.add(f);
		}
		if (recursive) {
			for (DbDirectoryTree subDir : subDirs.values()) {
				subDir.getDatabaseMetaDatas(ret, recursive);
			}
		}
		return ret;
	}

	/**
	 * Returns an iterarable over all databases in this directory
	 * 
	 */
	public Iterable<Database> getDatabases(final boolean recursive) {
		final Iterator<DatabaseMetaData> metaIter = getDatabaseMetaDatas(recursive).iterator();
		return new Iterable<Database>() {

			@Override
			public Iterator<Database> iterator() {
				return new Iterator<Database>() {

					@Override
					public boolean hasNext() {
						return metaIter.hasNext();
					}

					@Override
					public Database next() {
						// TODO FIX THIS!!!
						//return session_.getFactory().create(Database.SCHEMA, session_, metaIter.next());
						return null;
					}

					@Override
					public void remove() {
						metaIter.remove();
					}
				};
			}
		};
	}
}
