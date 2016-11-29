package org.openntf.red;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import lotus.domino.XSLTResultTarget;

import org.openntf.red.types.DocumentDescendant;
import org.xml.sax.InputSource;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface EmbeddedObject.
 */
public interface EmbeddedObject extends Base, lotus.domino.EmbeddedObject, DocumentDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#activate(boolean)
	 */
	@Override
	public int activate(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#doVerb(java.lang.String)
	 */
	@Override
	public void doVerb(final String verb);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#extractFile(java.lang.String)
	 */
	@Override
	public void extractFile(final String path);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getClassName()
	 */
	@Override
	public String getClassName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getFileSize()
	 */
	@Override
	public int getFileSize();

	@Override
	public DateTime getFileCreated();

	@Override
	public DateTime getFileModified();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getInputSource()
	 */
	@Override
	public InputSource getInputSource();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getInputStream()
	 */
	@Override
	public InputStream getInputStream();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getName()
	 */
	@Override
	public String getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getObject()
	 */
	@Override
	public int getObject();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getParent()
	 */
	@Override
	public RichTextItem getParent();

	/**
	 * Gets the parent document.
	 * 
	 * @return the parent document
	 */
	public Document getParentDocument();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getReader()
	 */
	@Override
	public Reader getReader();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getSource()
	 */
	@Override
	public String getSource();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getType()
	 */
	@Override
	public int getType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#getVerbs()
	 */
	@Override
	public Vector<String> getVerbs();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#parseXML(boolean)
	 */
	@Override
	public org.w3c.dom.Document parseXML(final boolean validate) throws IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.EmbeddedObject#transformXML(java.lang.Object,
	 * lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void transformXML(final Object style, final XSLTResultTarget result);

	/**
	 * Sets the underlying document dirty.
	 */
	public void markDirty();

}
