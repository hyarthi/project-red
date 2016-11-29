/**
 * 
 */
package org.openntf.red.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openntf.red.Base;
import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoListener;

import javolution.util.FastMap;
import javolution.util.FastTable;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * Common class for ODA extension where no lotus wrapper exists (WrapperFactory, DocumentList)
 * 
 * @author Roland Praml, FOCONIS AG; modified by Vladimir Kornienko
 * 
 */
public abstract class BaseImpl implements Base {

	private List<IDominoListener> listeners_;
	private transient Map<EnumEvent, List<IDominoListener>> listenerCache_;
	
	@Override
	public final boolean hasListeners() {
		return listeners_ != null && !listeners_.isEmpty();
	}

	@Override
	public final List<IDominoListener> getListeners() {
		if (listeners_ == null) {
			listeners_ = new FastTable<IDominoListener>().atomic();
		}
		return listeners_;
	}

	@Override
	public final void addListener(final IDominoListener listener) {
		listenerCache_ = null;
		getListeners().add(listener);
	}

	@Override
	public final void removeListener(final IDominoListener listener) {
		listenerCache_ = null;
		getListeners().remove(listener);
	}

	@Override
	public final List<IDominoListener> getListeners(final EnumEvent event) {
		if (!hasListeners())
			return Collections.emptyList();

		if (listenerCache_ == null)
			listenerCache_ = new FastMap<EnumEvent, List<IDominoListener>>().atomic();

		List<IDominoListener> result = listenerCache_.get(event);
		if (result == null) {
			result = new ArrayList<IDominoListener>();
			for (IDominoListener listener : getListeners()) {
				for (EnumEvent curEvent : listener.getEventTypes()) {
					if (curEvent.equals(event)) {
						result.add(listener);
						break;
					}
				}
			}
			listenerCache_.put(event, result);
		}
		return result;
	}

	@Override
	public final boolean fireListener(final IDominoEvent event) {
		boolean result = true;
		if (!hasListeners())
			return true;
		List<IDominoListener> listeners = getListeners(event.getEvent());
		if (listeners == null || listeners.isEmpty())
			return true;
		for (IDominoListener listener : listeners) {
			try {
				if (!listener.eventHappened(event)) {
					result = false;
					break;
				}
			} catch (Throwable t) {
				// FIXME handle error
			}
		}
		return result;
	}
	
}
