/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Iterator;
import java.util.Map;

import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.ViewEntry;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntryCollection
		extends BaseNonThreadSafe<org.openntf.domino.ViewEntryCollection, lotus.domino.ViewEntryCollection, View>
		implements org.openntf.domino.ViewEntryCollection {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewEntryCollection(lotus.domino.ViewEntryCollection delegate, View parent) {
		super(delegate, parent, NOTES_VECOLL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stampAll(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<ViewEntry> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntry(Object obh) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(Object obj, boolean checkDups) {
		// TODO Auto-generated method stub

	}

	@Override
	public org.openntf.domino.ViewEntryCollection cloneCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Base obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(int noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ViewEntry getEntry(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getFirstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNthEntry(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevEntry(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void intersect(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(String noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllRead() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllRead(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread() {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(String noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String folderName, boolean createOnFail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll(boolean force) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllFromFolder(String folderName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stampAll(String itemName, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(Base obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(int noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(String noteid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
