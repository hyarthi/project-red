package org.openntf.redomino.impl;

import java.util.logging.Logger;

import org.openntf.domino.types.Resurrectable;
import org.openntf.redomino.impl.Base;

public abstract class BaseThreadSafe<T extends org.openntf.domino.Base<D>, D extends lotus.domino.Base, P extends org.openntf.domino.Base<?>>
		extends Base<T, D, P> implements Resurrectable {
	
	/** The Constant log_. */
	@SuppressWarnings("unused")
	private static final Logger log_ = Logger.getLogger(BaseThreadSafe.class.getName());

	/** The delegate, here ThreadLocal */
	private transient ThreadLocal<D> _delegateLocal;

	/**
	 * Instantiates a new base.
	 * 
	 * @param delegate
	 *            the delegate
	 * @param parent
	 *            the parent (may be null)
	 * @param wf
	 *            the wrapperFactory
	 * @param cppId
	 *            the cpp-id
	 * @param classId
	 *            the class id
	 */
	protected BaseThreadSafe(final D delegate, final P parent, final int classId) {
		super(delegate, parent, classId);
	}

	/**
	 * constructor for no arg child objects
	 */
	protected BaseThreadSafe(final int classId) {
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
	final protected void setDelegate(final D delegate, final boolean fromResurrect) {
		if (_delegateLocal == null)
			_delegateLocal = new ThreadLocal<D>();
		_delegateLocal.set(delegate);
		if (fromResurrect)
			getFactory().recacheLotusObject(delegate, this, parent);
	}

	/**
	 * Gets the delegate without Resurrect
	 * 
	 * @return the delegate
	 */

	@Override
	protected D getDelegate_unchecked() {
		if (_delegateLocal == null)
			return null;
		return _delegateLocal.get();
	}

	@Override
	protected abstract void resurrect();

}
