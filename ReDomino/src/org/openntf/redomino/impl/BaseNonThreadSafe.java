package org.openntf.redomino.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openntf.redomino.utils.Factory;

public abstract class BaseNonThreadSafe<T extends org.openntf.domino.Base<D>, D extends lotus.domino.Base, P extends org.openntf.domino.Base<?>>
		extends Base<T, D, P> {

	/** The Constant log_. */
	private static final Logger log_ = Logger.getLogger(BaseNonThreadSafe.class.getName());

	/** The delegate_. */
	protected transient D delegate_;

	/** The Thread, in which wrapper was generated */
	private transient Thread _myThread = Thread.currentThread();

	static {
		Factory.addTerminateHook(new Runnable() {
			@Override
			public void run() {
				setAllowAccessAcrossThreads(false);
			}
		}, true);
	}

	/**
	 * Instantiates a new base.
	 * 
	 * @param delegate
	 *            the delegate
	 * @param parent
	 *            the parent (may be null)
	 * @param classId
	 *            the class id
	 */
	protected BaseNonThreadSafe(final D delegate, final P parent, final int classId) {
		super(delegate, parent, classId);
	}

	/**
	 * Constructor for deserialization
	 * 
	 * @param classId
	 */
	protected BaseNonThreadSafe(final int classId) {
		super(classId);
	}

	/**
	 * Sets the delegate on init or if resurrect occurred
	 * 
	 * @param delegate
	 *            the delegate
	 * @param cppId
	 *            the cpp-id
	 */
	@Override
	protected final void setDelegate(final D delegate, final boolean fromResurrect) {
		delegate_ = delegate;

		if (fromResurrect) {
			// an other object is set now, so we must recache that object
			getFactory().recacheLotusObject(delegate, this, parent);
			if (log_.isLoggable(Level.FINEST)) {
				log_.log(Level.FINE,
						"Object of class " + this.getClass().getName() + " was recached. Changes may be lost",
						new Throwable());
			}
		}
	}

	private static Set<Thread> _allowDirtyAccess4ThreadList = null;

	/**
	 * Enables Thread support (sharing Notes-objects across threads). But you
	 * _SHOULD_ really avoid this! <br/>
	 * <br/>
	 * 
	 * <b>NOTE:</b> Sharing Notes-objects across threads is supported for
	 * objects of class {@link BaseThreadSafe}, and there are no problems to be
	 * expected. <br/>
	 * <br/>
	 * 
	 * To share objects not extending BaseThreadSafe, you have to explicitly
	 * allow it by calling setAllowAccessAcrossThreads(true), which allows
	 * objects wrapped in the current thread being accessed in other threads.
	 * But it not recommended to do so. Or rather it is strongly recommended NOT
	 * to do so. Neither the ODA is tested, nor IBM recommend this. You should
	 * also read the paragraph <a href=
	 * "http://www-01.ibm.com/support/knowledgecenter/SSVRGU_8.5.3/com.ibm.designer.domino.main.doc/H_NOTESTHREAD_CLASS_JAVA.html"
	 * >Multithreading issues</a> before using it.
	 * 
	 * @param allow
	 *            enables thread support (and thread problems)
	 */
	protected static void setAllowAccessAcrossThreads(final boolean allow) {
		if (!allow && _allowDirtyAccess4ThreadList == null)
			return;
		Thread curr = Thread.currentThread();
		synchronized (BaseNonThreadSafe.class) {
			if (allow) {
				if (_allowDirtyAccess4ThreadList == null)
					_allowDirtyAccess4ThreadList = new HashSet<Thread>();
				_allowDirtyAccess4ThreadList.add(curr);
			} else {
				_allowDirtyAccess4ThreadList.remove(curr);
				if (_allowDirtyAccess4ThreadList.isEmpty())
					_allowDirtyAccess4ThreadList = null;
			}
		}
	}

	/**
	 * @param t
	 *            the Thread in which the Notes object was wrapped
	 * @return true if it is allowed
	 */
	protected static boolean isAllowAccessAcrossThreads(final Thread t) {
		return _allowDirtyAccess4ThreadList != null && _allowDirtyAccess4ThreadList.contains(t);
	}

	/**
	 * Gets the delegate without Resurrect
	 * 
	 * @return the delegate
	 */
	@Override
	protected D getDelegate_unchecked() {
		if (_myThread != Thread.currentThread() && !isAllowAccessAcrossThreads(_myThread))
			throw new IllegalStateException(
					"Notes-Object of type " + this.getClass().getName() + " is used across threads! This Thread: "
							+ Thread.currentThread() + " correct Thread: " + _myThread);
		return delegate_;
	}

}
