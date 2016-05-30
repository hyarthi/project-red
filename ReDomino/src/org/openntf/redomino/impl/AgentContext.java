/**
 * 
 */
package org.openntf.redomino.impl;

import java.util.List;
import java.util.Map;

import org.openntf.domino.Agent;
import org.openntf.domino.Database;
import org.openntf.domino.DateTime;
import org.openntf.domino.Document;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Session;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class AgentContext extends BaseNonThreadSafe<org.openntf.domino.AgentContext, lotus.domino.AgentContext, Session> implements
org.openntf.domino.AgentContext {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected AgentContext(lotus.domino.AgentContext delegate, Session parent) {
		super(delegate, parent, NOTES_AGENTCTX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, List<String>> getQueryStringParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent getCurrentAgent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getCurrentDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocumentContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectiveUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLastExitStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DateTime getLastRun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getParentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public lotus.domino.Document getSavedData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection getUnprocessedDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection unprocessedFTSearch(String query, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection unprocessedFTSearch(String query, int maxDocs, int sortOpt, int otherOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection unprocessedFTSearchRange(String query, int maxDocs, int sortOpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection unprocessedFTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt,
			int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentCollection unprocessedSearch(String formula, lotus.domino.DateTime limit, int maxDocs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProcessedDoc(lotus.domino.Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
