/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;

import lotus.domino.Base;

/**
 * @author Vladimir Kornienko
 *
 */
public class DocumentCollection extends BaseNonThreadSafe<org.openntf.domino.DocumentCollection, lotus.domino.DocumentCollection, Database>
implements org.openntf.domino.DocumentCollection {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected DocumentCollection(lotus.domino.DocumentCollection delegate, Database parent) {
		super(delegate, parent, NOTES_DOCCOLL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stampAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParentView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public org.openntf.domino.DocumentCollection filter(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DocumentCollection filter(Object value, String[] itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DocumentCollection filter(Object value, Collection<String> itemnames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.DocumentCollection filter(Map<String, Object> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Document e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Document> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Document> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
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
	public <T> T[] toArray(T[] a) {
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
	public void addDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDocument(lotus.domino.Document doc, boolean checkDups) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public org.openntf.domino.DocumentCollection cloneCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(int noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Base doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String noteid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteDocument(lotus.domino.Document doc) {
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
	public Document getDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getFirstDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getLastDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNextDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getNthDocument(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getPrevDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getUntilTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void intersect(int noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intersect(Base doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intersect(String noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSorted() {
		// TODO Auto-generated method stub
		return false;
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
	public void merge(int noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Base doc) {
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
	public void subtract(int noteid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subtract(Base doc) {
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
