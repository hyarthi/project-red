package org.openntf.redomino.session;

//import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.redomino.impl.WrapperFactory;
//import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.session.AbstractSessionFactory;
import org.openntf.domino.session.INamedSessionFactory;
import org.openntf.redomino.utils.Factory;

public class CouchSessionFactory extends AbstractSessionFactory implements INamedSessionFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CouchSessionFactory(String apiPath) {
		super(apiPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session createSession() {
		org.openntf.redomino.couch.Session raw = new org.openntf.redomino.couch.Session();
		return wrapSession(raw, true);
	}

	@Override
	public Session createSession(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session wrapSession(final lotus.domino.Session raw, final boolean selfCreated) {
		WrapperFactory wf = (WrapperFactory) Factory.getWrapperFactory();
		org.openntf.domino.Session sess = wf.fromCouch(raw, Session.SCHEMA, wf);
		sess.setNoRecycle(!selfCreated);

		sess.setConvertMIME(false);
//		if (selfCreated && currentApiPath_ != null) {
//			Database db = sess.getCurrentDatabase();
//			if (db == null) {
//				db = sess.getDatabase(currentApiPath_);
//				setCurrentDatabase(sess, db);
//			}
//		}
		return sess;
	}
}
