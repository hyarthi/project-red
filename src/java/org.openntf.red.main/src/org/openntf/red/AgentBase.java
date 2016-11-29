package org.openntf.red;

/**
 * 
 * @author Vladimir Kornienko
 *
 */
public interface AgentBase {
	// TODO link this with AMgr implementation (once it is in place)
	// For now this interface and implementation are not needed.

	/*
	 * AgentBase methods
	 */
	//private static java.lang.ThreadGroup getUserThreadGroup(); // probably needed only in impl
	//private static java.lang.String getAgentName(); // probably needed only in impl
	public void startup(AgentInfo info);
	public void runNotes() throws lotus.domino.NotesException; // FIXME exception
	//private static java.lang.ClassLoader setCurrentLoader(java.lang.Thread thread, java.lang.ClassLoader loader); // probably needed only in impl
	public void NotesMain();
	public org.openntf.red.Session getSession();
	public static org.openntf.red.Session getAgentSession() {return null;}
	public boolean isRestricted();
	public java.io.PrintWriter getAgentOutput();
	public java.io.OutputStream getAgentOutputStream();
	public void setDebug(boolean debug);
	public void setTrace(boolean trace);
	public void dbgMsg(java.lang.String msg, java.io.PrintStream out);
	public void dbgMsg(java.lang.String msg, java.io.PrintWriter writer);
	public void dbgMsg(java.lang.String msg);
	//java.lang.ClassLoader getClassLoader(); // probably needed only in impl
	//void setHttpStatusCode(int arg0); // probably needed only in impl
	//java.io.OutputStream getServiceOutputStream(); // probably needed only in impl
	//java.lang.Object getServiceContext(); // probably needed only in impl
	public void DominoMain(); // could be unneeded
	
	/*
	 * NotesThread methods
	 */
	//protected int getNativeThreadID(); // probably needed only in impl
	//static lotus.notes.AgentThreadGroup getAgentThreadGroup(); // probably needed only in impl
	//private static void bumpActiveNotesThreadCount(int arg0); // probably needed only in impl
	//private static void bumpStaticActiveNotesThreadCount(int arg0); // probably needed only in impl
	//private static int getActiveNotesThreadCount(); // probably needed only in impl
	//private static int getStaticActiveNotesThreadCount(); // probably needed only in impl
	public void initThread();
	public void termThread();
	public static void sinitThread() {}
	public static void stermThread() {}
	//private static synchronized void sEnableProcessThreadTracking(); // probably needed only in impl
	//private static synchronized void sDisableProcessThreadTracking(); // probably needed only in impl
	//private static synchronized void sTrackInits(); // probably needed only in impl
	//private static synchronized void sTrackTerms(); // probably needed only in impl
	//private static synchronized int sGetProcessThreadCount(); // probably needed only in impl
	//private static java.lang.String scvtStackTraceToString(java.lang.StackTraceElement[] arg0, int arg1, int arg2); // probably needed only in impl
	//private static synchronized void sDumpInitTermStacks(java.io.PrintWriter arg0); // probably needed only in impl
	//public static synchronized void sEnablePerThreadTracking(); // probably needed only in impl
	//public static synchronized void sEnablePerThreadTracking(java.lang.Thread arg0); // probably needed only in impl
	//public static synchronized void sDisablePerThreadTracking(); // probably needed only in impl
	//public static synchronized void sDisablePerThreadTracking(java.lang.Thread arg0); // probably needed only in impl
	//public static synchronized int sGetPerThreadCount(); // probably needed only in impl
	//public static synchronized int sGetPerThreadCount(java.lang.Thread arg0); // probably needed only in impl
	//public static synchronized void sDumpPerThreadInitTermStacks(java.io.PrintWriter arg0, java.lang.Thread arg1); // probably needed only in impl
	public void run();
	public void finalize();
	//private static void load(boolean arg0) throws lotus.domino.NotesException; // probably needed only in impl
	//private static void checkLoaded(); // probably needed only in impl
	//private static synchronized lotus.domino.NotesThread.ThreadTracker getThreadTracker(java.lang.Thread arg0); // probably needed only in impl
	//static synthetic java.lang.Class class$(java.lang.String arg0); // probably needed only in impl
	//static synthetic int access$200(); // probably needed only in impl
	//static synthetic int access$300(); // probably needed only in impl
	//static synthetic boolean access$402(boolean arg0); // probably needed only in impl
	//static synthetic java.lang.String access$500(java.lang.StackTraceElement[] arg0, int arg1, int arg2); // probably needed only in impl
	//static synthetic boolean access$400(); // probably needed only in impl
	
}
