/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.ColorObject;
import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextTable
		extends BaseNonThreadSafe<org.openntf.domino.RichTextTable, lotus.domino.RichTextTable, RichTextItem>
		implements org.openntf.domino.RichTextTable {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextTable(lotus.domino.RichTextTable delegate, RichTextItem parent) {
		super(delegate, parent, NOTES_RTTABLE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Document getAncestorDocument() {
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
	public void addRow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(int count, int targetRow) {
		// TODO Auto-generated method stub

	}

	@Override
	public ColorObject getAlternateColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColorObject getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RichTextItem getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getRowLabels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRightToLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow(int count) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow(int count, int targetRow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlternateColor(lotus.domino.ColorObject color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(lotus.domino.ColorObject color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRightToLeft(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRowLabels(Vector labels) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStyle(int tableStyle) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
