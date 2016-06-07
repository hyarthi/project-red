/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import lotus.domino.NotesException;

/**
 * @author IBM_ADMIN
 *
 */
public class NoteCollection implements lotus.domino.NoteCollection, CouchBase {

	/**
	 * 
	 */
	public NoteCollection() {
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
	 * @see lotus.domino.NoteCollection#add(java.lang.String)
	 */
	@Override
	public void add(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(int)
	 */
	@Override
	public void add(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(int[])
	 */
	@Override
	public void add(int[] arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.Document)
	 */
	@Override
	public void add(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.DocumentCollection)
	 */
	@Override
	public void add(lotus.domino.DocumentCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.NoteCollection)
	 */
	@Override
	public void add(lotus.domino.NoteCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.Form)
	 */
	@Override
	public void add(lotus.domino.Form arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.Agent)
	 */
	@Override
	public void add(lotus.domino.Agent arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#add(lotus.domino.View)
	 */
	@Override
	public void add(lotus.domino.View arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#buildCollection()
	 */
	@Override
	public void buildCollection() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#clearCollection()
	 */
	@Override
	public void clearCollection() throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getCount()
	 */
	@Override
	public int getCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getFirstNoteID()
	 */
	@Override
	public String getFirstNoteID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getLastBuildTime()
	 */
	@Override
	public DateTime getLastBuildTime() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getLastNoteID()
	 */
	@Override
	public String getLastNoteID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getNextNoteID(java.lang.String)
	 */
	@Override
	public String getNextNoteID(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getNoteIDs()
	 */
	@Override
	public int[] getNoteIDs() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getParent()
	 */
	@Override
	public Database getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getPrevNoteID(java.lang.String)
	 */
	@Override
	public String getPrevNoteID(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectAcl()
	 */
	@Override
	public boolean getSelectAcl() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectActions()
	 */
	@Override
	public boolean getSelectActions() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectAgents()
	 */
	@Override
	public boolean getSelectAgents() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectDataConnections()
	 */
	@Override
	public boolean getSelectDataConnections() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectDatabaseScript()
	 */
	@Override
	public boolean getSelectDatabaseScript() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectDocuments()
	 */
	@Override
	public boolean getSelectDocuments() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectFolders()
	 */
	@Override
	public boolean getSelectFolders() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectForms()
	 */
	@Override
	public boolean getSelectForms() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectFramesets()
	 */
	@Override
	public boolean getSelectFramesets() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectHelpAbout()
	 */
	@Override
	public boolean getSelectHelpAbout() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectHelpIndex()
	 */
	@Override
	public boolean getSelectHelpIndex() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectHelpUsing()
	 */
	@Override
	public boolean getSelectHelpUsing() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectIcon()
	 */
	@Override
	public boolean getSelectIcon() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectImageResources()
	 */
	@Override
	public boolean getSelectImageResources() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectJavaResources()
	 */
	@Override
	public boolean getSelectJavaResources() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectMiscCodeElements()
	 */
	@Override
	public boolean getSelectMiscCodeElements() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectMiscFormatElements()
	 */
	@Override
	public boolean getSelectMiscFormatElements() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectMiscIndexElements()
	 */
	@Override
	public boolean getSelectMiscIndexElements() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectNavigators()
	 */
	@Override
	public boolean getSelectNavigators() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectOutlines()
	 */
	@Override
	public boolean getSelectOutlines() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectPages()
	 */
	@Override
	public boolean getSelectPages() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectProfiles()
	 */
	@Override
	public boolean getSelectProfiles() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectReplicationFormulas()
	 */
	@Override
	public boolean getSelectReplicationFormulas() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectScriptLibraries()
	 */
	@Override
	public boolean getSelectScriptLibraries() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectSharedFields()
	 */
	@Override
	public boolean getSelectSharedFields() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectStylesheetResources()
	 */
	@Override
	public boolean getSelectStylesheetResources() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectSubforms()
	 */
	@Override
	public boolean getSelectSubforms() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectViews()
	 */
	@Override
	public boolean getSelectViews() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSelectionFormula()
	 */
	@Override
	public String getSelectionFormula() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getSinceTime()
	 */
	@Override
	public DateTime getSinceTime() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getUNID(java.lang.String)
	 */
	@Override
	public String getUNID(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#getUntilTime()
	 */
	@Override
	public DateTime getUntilTime() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(java.lang.String)
	 */
	@Override
	public void intersect(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(int)
	 */
	@Override
	public void intersect(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.Document)
	 */
	@Override
	public void intersect(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.DocumentCollection)
	 */
	@Override
	public void intersect(lotus.domino.DocumentCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.NoteCollection)
	 */
	@Override
	public void intersect(lotus.domino.NoteCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.Form)
	 */
	@Override
	public void intersect(lotus.domino.Form arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.Agent)
	 */
	@Override
	public void intersect(lotus.domino.Agent arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#intersect(lotus.domino.View)
	 */
	@Override
	public void intersect(lotus.domino.View arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(java.lang.String)
	 */
	@Override
	public void remove(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(int)
	 */
	@Override
	public void remove(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.Document)
	 */
	@Override
	public void remove(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.DocumentCollection)
	 */
	@Override
	public void remove(lotus.domino.DocumentCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.NoteCollection)
	 */
	@Override
	public void remove(lotus.domino.NoteCollection arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.Form)
	 */
	@Override
	public void remove(lotus.domino.Form arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.Agent)
	 */
	@Override
	public void remove(lotus.domino.Agent arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#remove(lotus.domino.View)
	 */
	@Override
	public void remove(lotus.domino.View arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllAdminNotes(boolean)
	 */
	@Override
	public void selectAllAdminNotes(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllCodeElements(boolean)
	 */
	@Override
	public void selectAllCodeElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllDataNotes(boolean)
	 */
	@Override
	public void selectAllDataNotes(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllDesignElements(boolean)
	 */
	@Override
	public void selectAllDesignElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllFormatElements(boolean)
	 */
	@Override
	public void selectAllFormatElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllIndexElements(boolean)
	 */
	@Override
	public void selectAllIndexElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#selectAllNotes(boolean)
	 */
	@Override
	public void selectAllNotes(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectAcl(boolean)
	 */
	@Override
	public void setSelectAcl(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectActions(boolean)
	 */
	@Override
	public void setSelectActions(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectAgents(boolean)
	 */
	@Override
	public void setSelectAgents(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectDataConnections(boolean)
	 */
	@Override
	public void setSelectDataConnections(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectDatabaseScript(boolean)
	 */
	@Override
	public void setSelectDatabaseScript(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectDocuments(boolean)
	 */
	@Override
	public void setSelectDocuments(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectFolders(boolean)
	 */
	@Override
	public void setSelectFolders(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectForms(boolean)
	 */
	@Override
	public void setSelectForms(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectFramesets(boolean)
	 */
	@Override
	public void setSelectFramesets(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectHelpAbout(boolean)
	 */
	@Override
	public void setSelectHelpAbout(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectHelpIndex(boolean)
	 */
	@Override
	public void setSelectHelpIndex(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectHelpUsing(boolean)
	 */
	@Override
	public void setSelectHelpUsing(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectIcon(boolean)
	 */
	@Override
	public void setSelectIcon(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectImageResources(boolean)
	 */
	@Override
	public void setSelectImageResources(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectJavaResources(boolean)
	 */
	@Override
	public void setSelectJavaResources(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectMiscCodeElements(boolean)
	 */
	@Override
	public void setSelectMiscCodeElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectMiscFormatElements(boolean)
	 */
	@Override
	public void setSelectMiscFormatElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectMiscIndexElements(boolean)
	 */
	@Override
	public void setSelectMiscIndexElements(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectNavigators(boolean)
	 */
	@Override
	public void setSelectNavigators(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectOutlines(boolean)
	 */
	@Override
	public void setSelectOutlines(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectPages(boolean)
	 */
	@Override
	public void setSelectPages(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectProfiles(boolean)
	 */
	@Override
	public void setSelectProfiles(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectReplicationFormulas(boolean)
	 */
	@Override
	public void setSelectReplicationFormulas(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectScriptLibraries(boolean)
	 */
	@Override
	public void setSelectScriptLibraries(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectSharedFields(boolean)
	 */
	@Override
	public void setSelectSharedFields(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectStylesheetResources(boolean)
	 */
	@Override
	public void setSelectStylesheetResources(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectSubforms(boolean)
	 */
	@Override
	public void setSelectSubforms(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectViews(boolean)
	 */
	@Override
	public void setSelectViews(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectionFormula(java.lang.String)
	 */
	@Override
	public void setSelectionFormula(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSinceTime(lotus.domino.DateTime)
	 */
	@Override
	public void setSinceTime(lotus.domino.DateTime arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
