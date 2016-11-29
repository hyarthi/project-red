package org.openntf.red;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.openntf.red.types.SessionDescendant;

/**
 * <i> Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Stream.
 */
public interface Stream extends Base, lotus.domino.Stream, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#close()
	 */
	@Override
	public void close();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#getBytes()
	 */
	@Override
	public int getBytes();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#getCharset()
	 */
	@Override
	public String getCharset();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#getContents(java.io.OutputStream)
	 */
	@Override
	public void getContents(final OutputStream stream);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#getContents(java.io.Writer)
	 */
	@Override
	public void getContents(final Writer writer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#getPosition()
	 */
	@Override
	public int getPosition();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#isEOS()
	 */
	@Override
	public boolean isEOS();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#isReadOnly()
	 */
	@Override
	public boolean isReadOnly();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#open(java.lang.String)
	 */
	@Override
	public boolean open(final String pathName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#open(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean open(final String pathName, final String charSet);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#read()
	 */
	@Override
	public byte[] read();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#read(int)
	 */
	@Override
	public byte[] read(final int length);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#readText()
	 */
	@Override
	public String readText();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#readText(int)
	 */
	@Override
	public String readText(final int length);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#readText(int, int)
	 */
	@Override
	public String readText(final int length, final int eolType);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#setContents(java.io.InputStream)
	 */
	@Override
	public void setContents(final InputStream stream);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#setContents(java.io.Reader)
	 */
	@Override
	public void setContents(final Reader reader);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#setPosition(int)
	 */
	@Override
	public void setPosition(final int position);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#truncate()
	 */
	@Override
	public void truncate();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#write(byte[])
	 */
	@Override
	public int write(final byte[] buffer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#writeText(java.lang.String)
	 */
	@Override
	public int writeText(final String text);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Stream#writeText(java.lang.String, int)
	 */
	@Override
	public int writeText(final String text, final int eolType);
	
	/**
	 * Gets the Session that is the parent of the Stream
	 * 
	 * @return parent Session
	 * @since org.openntf.domino 1.0.0
	 */
	public Session getParent();
	
}
