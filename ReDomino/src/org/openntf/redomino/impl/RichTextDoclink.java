/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.RichTextItem;
import org.openntf.domino.RichTextStyle;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class RichTextDoclink
		extends BaseNonThreadSafe<org.openntf.domino.RichTextDoclink, lotus.domino.RichTextDoclink, RichTextItem>
		implements org.openntf.domino.RichTextDoclink {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected RichTextDoclink(lotus.domino.RichTextDoclink delegate, RichTextItem parent) {
		super(delegate, parent, NOTES_RTDOCLNK);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getView() {
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
	public String getDBReplicaID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocUnID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHotSpotText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RichTextStyle getHotSpotTextStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerHint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getViewUnID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDBReplicaID(String replicaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayComment(String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocUnID(String unid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHotSpotText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHotSpotTextStyle(lotus.domino.RichTextStyle rtstyle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerHint(String server) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViewUnID(String unid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
