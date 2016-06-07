/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextItem extends Item implements lotus.domino.RichTextItem, CouchBase {

	/**
	 * 
	 */
	public RichTextItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param _name
	 * @param _parent
	 * @param _value
	 */
	public RichTextItem(String _name, Document _parent, JsonJavaObject _value) {
		super(_name, _parent, _value);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param _name
	 * @param _parent
	 * @param _type
	 */
	public RichTextItem(String _name, Document _parent, int _type) {
		super(_name, _parent, _type);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param _name
	 * @param _parent
	 * @param _value
	 */
	public RichTextItem(String _name, Document _parent, Object _value) {
		super(_name, _parent, _value);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addNewLine()
	 */
	@Override
	public void addNewLine() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addNewLine(int)
	 */
	@Override
	public void addNewLine(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addNewLine(int, boolean)
	 */
	@Override
	public void addNewLine(int arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addPageBreak()
	 */
	@Override
	public void addPageBreak() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addPageBreak(lotus.domino.RichTextParagraphStyle)
	 */
	@Override
	public void addPageBreak(lotus.domino.RichTextParagraphStyle arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addTab()
	 */
	@Override
	public void addTab() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#addTab(int)
	 */
	@Override
	public void addTab(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Document)
	 */
	@Override
	public void appendDocLink(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Database)
	 */
	@Override
	public void appendDocLink(lotus.domino.Database arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.View)
	 */
	@Override
	public void appendDocLink(lotus.domino.View arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Document, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.Document arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Database, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.Database arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.View, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.View arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Document, java.lang.String, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.Document arg0, String arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.Database, java.lang.String, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.Database arg0, String arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendDocLink(lotus.domino.View, java.lang.String, java.lang.String)
	 */
	@Override
	public void appendDocLink(lotus.domino.View arg0, String arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendParagraphStyle(lotus.domino.RichTextParagraphStyle)
	 */
	@Override
	public void appendParagraphStyle(lotus.domino.RichTextParagraphStyle arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendRTItem(lotus.domino.RichTextItem)
	 */
	@Override
	public void appendRTItem(lotus.domino.RichTextItem arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendStyle(lotus.domino.RichTextStyle)
	 */
	@Override
	public void appendStyle(lotus.domino.RichTextStyle arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendTable(int, int)
	 */
	@Override
	public void appendTable(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendTable(int, int, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void appendTable(int arg0, int arg1, Vector arg2) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendTable(int, int, java.util.Vector, int, java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void appendTable(int arg0, int arg1, Vector arg2, int arg3, Vector arg4) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#appendText(java.lang.String)
	 */
	@Override
	public void appendText(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#beginInsert(lotus.domino.Base)
	 */
	@Override
	public void beginInsert(lotus.domino.Base arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#beginInsert(lotus.domino.Base, boolean)
	 */
	@Override
	public void beginInsert(lotus.domino.Base arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#beginSection(java.lang.String)
	 */
	@Override
	public void beginSection(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#beginSection(java.lang.String, lotus.domino.RichTextStyle)
	 */
	@Override
	public void beginSection(String arg0, lotus.domino.RichTextStyle arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#beginSection(java.lang.String, lotus.domino.RichTextStyle, lotus.domino.ColorObject, boolean)
	 */
	@Override
	public void beginSection(String arg0, lotus.domino.RichTextStyle arg1, lotus.domino.ColorObject arg2, boolean arg3) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#compact()
	 */
	@Override
	public void compact() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#createNavigator()
	 */
	@Override
	public RichTextNavigator createNavigator() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#createRange()
	 */
	@Override
	public RichTextRange createRange() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#embedObject(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public EmbeddedObject embedObject(int arg0, String arg1, String arg2, String arg3) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#endInsert()
	 */
	@Override
	public void endInsert() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#endSection()
	 */
	@Override
	public void endSection() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#getEmbeddedObject(java.lang.String)
	 */
	@Override
	public EmbeddedObject getEmbeddedObject(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#getEmbeddedObjects()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getEmbeddedObjects() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#getFormattedText(boolean, int, int)
	 */
	@Override
	public String getFormattedText(boolean arg0, int arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#getNotesFont(java.lang.String, boolean)
	 */
	@Override
	public int getNotesFont(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#getUnformattedText()
	 */
	@Override
	public String getUnformattedText() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.RichTextItem#update()
	 */
	@Override
	public void update() throws NotesException {
		// TODO Auto-generated method stub

	}

}
