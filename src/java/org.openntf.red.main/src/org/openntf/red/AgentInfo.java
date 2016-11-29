package org.openntf.red;

/**
 * 
 * @author Vladimir Kornienko
 *
 */
public interface AgentInfo {
	// TODO link this with AMgr implementation (once it is in place)
	// For now this interface and implementation are not needed.

	//java.lang.String getAgentName(); // probably needed only in impl
	//java.lang.Class getAgentClass(); // probably needed only in impl
	//long getTimeout(); // probably needed only in impl
	//int getRunContext(); // probably needed only in impl
	//boolean isRestricted(); // probably needed only in impl
	//long getDocID(); // probably needed only in impl
	//boolean redirectAgentOutput(); // probably needed only in impl
	//lotus.notes.AgentSecurityContext getSecurityContext(); // probably needed only in impl
	//void newSecurityContext(java.lang.ThreadGroup arg0); // probably needed only in impl
	//java.lang.Object newInstance() throws java.lang.InstantiationException, java.lang.IllegalAccessException; // probably needed only in impl
	//void setSession(lotus.domino.Session arg0);  // probably needed only in impl
	//lotus.domino.Session getSession(); // probably needed only in impl
	public boolean checkECL(int arg0, int arg1, java.lang.String arg2);
	//int getHttpTID(); // probably needed only in impl
	//java.lang.ClassLoader getClassLoader(); // probably needed only in impl
	//void setHttpStatusCode(int arg0); // probably needed only in impl
	//java.lang.Object getServiceContext(); // probably needed only in impl
	
}
