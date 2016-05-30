/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.Vector;

import org.openntf.domino.Document;
import org.openntf.domino.EmbeddedObject;
import org.openntf.domino.RichTextNavigator;
import org.openntf.domino.RichTextRange;

import lotus.domino.Base;
import lotus.domino.ColorObject;
import lotus.domino.Database;
import lotus.domino.RichTextParagraphStyle;
import lotus.domino.RichTextStyle;
import lotus.domino.View;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextItem extends Item implements org.openntf.domino.RichTextItem {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextItem(lotus.domino.RichTextItem delegate, Document parent) {
		super(delegate, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addNewLine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewLine(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewLine(int count, boolean newParagraph) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPageBreak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPageBreak(RichTextParagraphStyle pstyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTab() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTab(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(Database db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(Database db, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(Database db, String comment, String hotspotText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(lotus.domino.Document doc, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(lotus.domino.Document doc, String comment, String hotspotText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(View view, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendDocLink(View view, String comment, String hotspotText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendParagraphStyle(RichTextParagraphStyle pstyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendRTItem(lotus.domino.RichTextItem rtitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendStyle(RichTextStyle rstyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendTable(int rows, int columns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendTable(int rows, int columns, Vector labels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendTable(int rows, int columns, Vector labels, int leftMargin, Vector pstyles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginInsert(Base element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginInsert(Base element, boolean after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginSection(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginSection(String title, RichTextStyle titleStyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginSection(String title, RichTextStyle titleStyle, ColorObject barColor, boolean expand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void compact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RichTextNavigator createNavigator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextRange createRange() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmbeddedObject embedObject(int type, String className, String source, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endSection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmbeddedObject getEmbeddedObject(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<EmbeddedObject> getEmbeddedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormattedText(boolean tabStrip, int lineLen, int maxLen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotesFont(String faceName, boolean addOnFail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUnformattedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
