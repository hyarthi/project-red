/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class Stream extends BaseNonThreadSafe<org.openntf.domino.Stream, lotus.domino.Stream, Session>
		implements org.openntf.domino.Stream {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected Stream(lotus.domino.Stream delegate, Session parent) {
		super(delegate, parent, NOTES_SESSTRM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getContents(OutputStream stream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContents(Writer writer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEOS() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean open(String pathName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean open(String pathName, String charSet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] read(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText(int length, int eolType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(InputStream stream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContents(Reader reader) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(int position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void truncate() {
		// TODO Auto-generated method stub

	}

	@Override
	public int write(byte[] buffer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeText(String text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeText(String text, int eolType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
