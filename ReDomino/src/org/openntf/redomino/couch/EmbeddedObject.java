/**
 * 
 */
package org.openntf.redomino.couch;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class EmbeddedObject implements lotus.domino.EmbeddedObject, CouchBase {

	/**
	 * 
	 */
	public EmbeddedObject() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#activate(boolean)
	 */
	@Override
	public int activate(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#doVerb(java.lang.String)
	 */
	@Override
	public void doVerb(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#extractFile(java.lang.String)
	 */
	@Override
	public void extractFile(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getClassName()
	 */
	@Override
	public String getClassName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getFileCreated()
	 */
	@Override
	public DateTime getFileCreated() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getFileModified()
	 */
	@Override
	public DateTime getFileModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getFileSize()
	 */
	@Override
	public int getFileSize() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getInputSource()
	 */
	@Override
	public InputSource getInputSource() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getName()
	 */
	@Override
	public String getName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getObject()
	 */
	@Override
	public int getObject() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getParent()
	 */
	@Override
	public RichTextItem getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getReader()
	 */
	@Override
	public Reader getReader() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getSource()
	 */
	@Override
	public String getSource() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getType()
	 */
	@Override
	public int getType() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getVerbs()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getVerbs() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#parseXML(boolean)
	 */
	@Override
	public Document parseXML(boolean arg0) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#transformXML(java.lang.Object, lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void transformXML(Object arg0, XSLTResultTarget arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

}
