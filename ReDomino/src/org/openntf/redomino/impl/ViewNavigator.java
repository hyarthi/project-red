/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Iterator;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.ViewEntry;
import org.openntf.domino.WrapperFactory;

import lotus.domino.NoteCollection;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewNavigator extends BaseThreadSafe<org.openntf.domino.ViewNavigator, lotus.domino.ViewNavigator, View>
		implements org.openntf.domino.ViewNavigator {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewNavigator(lotus.domino.ViewNavigator delegate, View parent) {
		super(delegate, parent, NOTES_VIEWNAV);
		// TODO Auto-generated constructor stub
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
	public int getBufferMaxEntries() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ViewEntry getChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getChild(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ViewEntry getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntryOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ViewEntry getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getFirstDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getLastDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ViewEntry getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNext(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNextSibling(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getNth(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getParent(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getParentView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPos(String pos, char separator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrev(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewEntry getPrevSibling(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean gotoChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoChild(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoEntry(Object entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoEntry(Document document) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoEntry(ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoFirstDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoLastDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNext(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNextCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNextDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNextSibling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNextSibling(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoParent(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPos(String pos, char separator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrev() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrev(lotus.domino.ViewEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrevCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrevDocument() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrevSibling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrevSibling(lotus.domino.ViewEntry entry) {
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
	public void setAutoExpandGuidance(int maxEntries, int[] collapsedNoteIds, int[] expandedNoteIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAutoExpandGuidance(int maxEntries, NoteCollection collapsedNoteIds, NoteCollection expandedNoteIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBufferMaxEntries(int entryCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCacheGuidance(int maxEntries) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCacheGuidance(int maxEntries, int readMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCacheSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEntryOptions(int options) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxLevel(int maxLevel) {
		// TODO Auto-generated method stub

	}

	@Override
	public int skip(int count) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void resurrect() {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
