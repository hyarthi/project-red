/**
 * 
 */
package org.openntf.redomino.couch;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class Stream implements lotus.domino.Stream, CouchBase {

	/**
	 * 
	 */
	public Stream() {
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
	 * @see lotus.domino.Stream#close()
	 */
	@Override
	public void close() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#getBytes()
	 */
	@Override
	public int getBytes() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#getCharset()
	 */
	@Override
	public String getCharset() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#getContents(java.io.Writer)
	 */
	@Override
	public void getContents(Writer arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#getContents(java.io.OutputStream)
	 */
	@Override
	public void getContents(OutputStream arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#getPosition()
	 */
	@Override
	public int getPosition() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#isEOS()
	 */
	@Override
	public boolean isEOS() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#open(java.lang.String)
	 */
	@Override
	public boolean open(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#open(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean open(String arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#read()
	 */
	@Override
	public byte[] read() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#read(int)
	 */
	@Override
	public byte[] read(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#readText()
	 */
	@Override
	public String readText() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#readText(int)
	 */
	@Override
	public String readText(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#readText(int, int)
	 */
	@Override
	public String readText(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#setContents(java.io.Reader)
	 */
	@Override
	public void setContents(Reader arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#setContents(java.io.InputStream)
	 */
	@Override
	public void setContents(InputStream arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#setPosition(int)
	 */
	@Override
	public void setPosition(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#truncate()
	 */
	@Override
	public void truncate() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#write(byte[])
	 */
	@Override
	public int write(byte[] arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#writeText(java.lang.String)
	 */
	@Override
	public int writeText(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.Stream#writeText(java.lang.String, int)
	 */
	@Override
	public int writeText(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

}
