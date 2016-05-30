/**
 * 
 */
package org.openntf.redomino.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.MIMEHeader;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;
import org.xml.sax.InputSource;

import lotus.domino.Stream;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class MIMEEntity extends BaseNonThreadSafe<org.openntf.domino.MIMEEntity, lotus.domino.MIMEEntity, Document>
		implements org.openntf.domino.MIMEEntity {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected MIMEEntity(lotus.domino.MIMEEntity delegate, Document parent) {
		super(delegate, parent, NOTES_MIMEENTITY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
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
	public org.openntf.domino.MIMEEntity createChildEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity createChildEntity(lotus.domino.MIMEEntity nextSibling) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MIMEHeader createHeader(String headerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity createParentEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decodeContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void encodeContent(int encoding) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getBoundaryEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBoundaryStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getContentAsBytes(Stream stream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsBytes(Stream stream, boolean decoded) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getContentAsText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getContentAsText(Stream stream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsText(Stream stream, boolean decoded) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getContentSubType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEncoding() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getEntityAsText(Stream stream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEntityAsText(Stream stream, Vector headerFilters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEntityAsText(Stream stream, Vector headerFilters, boolean inclusive) {
		// TODO Auto-generated method stub

	}

	@Override
	public org.openntf.domino.MIMEEntity getFirstChildEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<MIMEHeader> getHeaderObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaders() {
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
	public org.openntf.domino.MIMEEntity getNextEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getNextEntity(int search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MIMEHeader getNthHeader(String headerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MIMEHeader getNthHeader(String headerName, int instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getParentEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPreamble() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getPrevEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getPrevEntity(int search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.openntf.domino.MIMEEntity getPrevSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeHeaders(Vector headerFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeHeaders(Vector headerFilters, boolean inclusive) {
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
	public void setContentFromBytes(Stream stream, String contentType, int encoding) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentFromText(Stream stream, String contentType, int encoding) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreamble(String preamble) {
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
