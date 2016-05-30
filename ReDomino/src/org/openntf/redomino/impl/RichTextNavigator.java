/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Base;
import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextNavigator
		extends BaseNonThreadSafe<org.openntf.domino.RichTextNavigator, lotus.domino.RichTextNavigator, RichTextItem>
		implements org.openntf.domino.RichTextNavigator {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextNavigator(lotus.domino.RichTextNavigator delegate, RichTextItem parent) {
		super(delegate, parent, NOTES_RTNAVIGATOR);
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
	public org.openntf.domino.RichTextNavigator Clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findFirstElement(int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findFirstString(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findFirstString(String target, int options) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findLastElement(int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextElement(int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextElement(int type, int occurrence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextString(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextString(String target, int options) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNthElement(int type, int occurrence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Base<?> getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getFirstElement(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getLastElement(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getNextElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getNextElement(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getNextElement(int type, int occurrence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<?> getNthElement(int type, int occurrence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharOffset(int offset) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(lotus.domino.Base element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPositionAtEnd(lotus.domino.Base element) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
