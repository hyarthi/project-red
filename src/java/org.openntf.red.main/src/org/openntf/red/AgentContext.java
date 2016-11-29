package org.openntf.red;

import java.util.List;
import java.util.Map;

import org.openntf.red.types.SessionDescendant;

/**
 * The Interface AgentContext.
 */
public interface AgentContext extends Base, lotus.domino.AgentContext, SessionDescendant {

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getCurrentAgent()
	 */
	@Override
	public Agent getCurrentAgent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getCurrentDatabase()
	 */
	@Override
	public Database getCurrentDatabase();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getDocumentContext()
	 */
	@Override
	public Document getDocumentContext();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getEffectiveUserName()
	 */
	@Override
	public String getEffectiveUserName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getLastExitStatus()
	 */
	@Override
	public int getLastExitStatus();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getLastRun()
	 */
	@Override
	public DateTime getLastRun();

	/**
	 * Gets the parent session.
	 * 
	 * @return the parent session
	 */
	public Session getParentSession();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getSavedData()
	 */
	@Override
	public lotus.domino.Document getSavedData();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#getUnprocessedDocuments()
	 */
	@Override
	public DocumentCollection getUnprocessedDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#unprocessedFTSearch(java.lang.String, int)
	 */
	@Override
	public DocumentCollection unprocessedFTSearch(final String query, final int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#unprocessedFTSearch(java.lang.String, int,
	 * int, int)
	 */
	@Override
	public DocumentCollection unprocessedFTSearch(final String query, final int maxDocs, final int sortOpt,
			final int otherOpt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#unprocessedFTSearchRange(java.lang.String,
	 * int, int)
	 */
	@Override
	public DocumentCollection unprocessedFTSearchRange(final String query, final int maxDocs, final int sortOpt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#unprocessedFTSearchRange(java.lang.String,
	 * int, int, int, int)
	 */
	@Override
	public DocumentCollection unprocessedFTSearchRange(final String query, final int maxDocs, final int sortOpt,
			final int otherOpt, final int start);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#unprocessedSearch(java.lang.String,
	 * lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection unprocessedSearch(final String formula, final lotus.domino.DateTime limit,
			final int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.AgentContext#updateProcessedDoc(lotus.domino.Document)
	 */
	@Override
	public void updateProcessedDoc(final lotus.domino.Document doc);

	/**
	 * Gets query string parameters as a Map of String Lists
	 * 
	 * @return Map<String, List<String>> query string parameters
	 * 
	 * @since org.openntf.domino 4.0.0
	 */
	public Map<String, List<String>> getQueryStringParameters();

}
