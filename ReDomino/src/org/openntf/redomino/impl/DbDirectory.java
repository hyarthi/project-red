/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;
import org.openntf.domino.helpers.DbDirectoryTree;
import org.openntf.domino.types.Encapsulated;

import lotus.domino.DateTime;

/**
 * @author Vladimir Kornienko
 *
 */
public class DbDirectory extends BaseNonThreadSafe<org.openntf.domino.DbDirectory, lotus.domino.DbDirectory, Session> implements
org.openntf.domino.DbDirectory, Encapsulated {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DbDirectory(lotus.domino.DbDirectory delegate, Session parent) {
		super(delegate, parent, NOTES_SERVER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSortByLastModified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSortByLastModified(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Type getDirectoryType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDirectoryType(Type type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbDirectoryTree getTree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbDirectoryTree getTree(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Database arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Database> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Database> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database createDatabase(String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database createDatabase(String dbFile, boolean open) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClusterName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClusterName(String server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getFirstDatabase(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getFirstDatabase(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getNextDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHonorShowInOpenDatabaseDialog() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Database openDatabase(String dbFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database openDatabase(String dbFile, boolean failover) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database openDatabaseByReplicaID(String replicaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database openDatabaseIfModified(String dbFile, DateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database openMailDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHonorShowInOpenDatabaseDialog(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Database openDatabaseIfModified(String dbFile, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
