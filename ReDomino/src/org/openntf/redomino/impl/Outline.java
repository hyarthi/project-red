/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

import lotus.domino.OutlineEntry;

/**
 * @author Vladimir Kornienko
 *
 */
public class Outline extends BaseNonThreadSafe<org.openntf.domino.Outline, lotus.domino.Outline, Database>
		implements org.openntf.domino.Outline {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Outline(lotus.domino.Outline delegate, Database parent) {
		super(delegate, parent, NOTES_OUTLINE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
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
	public void addEntry(OutlineEntry entry, OutlineEntry referenceEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(OutlineEntry entry, OutlineEntry referenceEntry, boolean after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(OutlineEntry entry, OutlineEntry referenceEntry, boolean after, boolean asChild) {
		// TODO Auto-generated method stub

	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(OutlineEntry fromEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(OutlineEntry fromEntry, OutlineEntry referenceEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(OutlineEntry fromEntry, OutlineEntry referenceEntry,
			boolean after) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(OutlineEntry fromEntry, OutlineEntry referenceEntry,
			boolean after, boolean asChild) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(String entryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(String entryName, OutlineEntry referenceEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(String entryName, OutlineEntry referenceEntry, boolean after) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry createEntry(String entryName, OutlineEntry referenceEntry, boolean after,
			boolean asChild) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getChild(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getNext(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getNextSibling(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getParent(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getParentDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getPrev(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.OutlineEntry getPrevSibling(OutlineEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveEntry(OutlineEntry entry, OutlineEntry referenceEntry) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEntry(OutlineEntry entry, OutlineEntry referenceEntry, boolean after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEntry(OutlineEntry entry, OutlineEntry referenceEntry, boolean after, boolean asChild) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEntry(OutlineEntry entry) {
		// TODO Auto-generated method stub

	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlias(String alias) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setComment(String comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
