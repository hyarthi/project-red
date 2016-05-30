/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;
import org.xml.sax.InputSource;

import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class EmbeddedObject extends BaseNonThreadSafe<org.openntf.domino.EmbeddedObject, lotus.domino.EmbeddedObject, Document> implements
org.openntf.domino.EmbeddedObject {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected EmbeddedObject(lotus.domino.EmbeddedObject delegate, Document parent) {
		super(delegate, parent, NOTES_EMBEDOBJ);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
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
	public int activate(boolean flag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doVerb(String verb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extractFile(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFileSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DateTime getFileCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateTime getFileModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputSource getInputSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getObject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RichTextItem getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getParentDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<String> getVerbs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.w3c.dom.Document parseXML(boolean validate) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformXML(Object style, XSLTResultTarget result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
