/**
 * 
 */
package org.openntf.red.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoListener;
//import org.openntf.red.nsf.endpoint.Endpoint;

import javolution.util.FastMap;
import javolution.util.FastTable;
import lotus.domino.NotesException;

/**
 * <i>Parts of code borrowed from OpenNTF Domino API.</i><br>
 * Base object of the Entity API. Extensions used to manipulate data objects in
 * memory.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 * @see org.openntf.red.Base
 */
public abstract class Base<P extends org.openntf.red.Base> implements org.openntf.red.Base {

	public static final int SOLO_NOTES_NAMES = 1000;
	public static final int NOTES_SESSION = 1;
	public static final int NOTES_DATABASE = 2;
	public static final int NOTES_VIEW = 3;
	public static final int NOTES_NOTE = 4;
	public static final int NOTES_ITEM = 5;
	public static final int NOTES_RTITEM = 6;
	public static final int NOTES_REPORT = 7;
	public static final int NOTES_TIME = 8;
	public static final int NOTES_MACRO = 9;
	public static final int NOTES_SERVER = 10;
	public static final int NOTES_DOCCOLL = 11;
	public static final int NOTES_AGENTLOG = 12;
	public static final int NOTES_ACL = 13;
	public static final int NOTES_ACLENTRY = 14;
	public static final int NOTES_VIEWCOLUMN = 15;
	public static final int NOTES_EMBEDOBJ = 16;
	public static final int NOTES_REGISTRATION = 17;
	public static final int NOTES_TIMER = 18;
	public static final int NOTES_NAME = 19;
	public static final int NOTES_FORM = 20;
	public static final int NOTES_INTL = 21;
	public static final int NOTES_DATERNG = 22;
	public static final int NOTES_AGENTCTX = 25;
	public static final int NOTES_RTSTYLE = 26;
	public static final int NOTES_VIEWENTRY = 27;
	public static final int NOTES_VECOLL = 28;
	public static final int NOTES_RTPSTYLE = 29;
	public static final int NOTES_RTTAB = 30;
	public static final int NOTES_REPLICATION = 43;
	public static final int NOTES_VIEWNAV = 44;
	public static final int NOTES_OUTLINEENTRY = 48;
	public static final int NOTES_OUTLINE = 49;
	public static final int NOTES_MIMEENTITY = 50;
	public static final int NOTES_RTTABLE = 51;
	public static final int NOTES_RTNAVIGATOR = 52;
	public static final int NOTES_RTRANGE = 53;
	public static final int NOTES_NOTECOLLECTION = 54;
	public static final int NOTES_DXLEXPORTER = 55;
	public static final int NOTES_DXLIMPORTER = 56;
	public static final int NOTES_MIMEHDR = 78;
	public static final int NOTES_SESSTRM = 79;
	public static final int NOTES_ADMINP = 80;
	public static final int NOTES_RTDOCLNK = 81;
	public static final int NOTES_COLOR = 82;
	public static final int NOTES_RTSECTION = 83;
	public static final int NOTES_REPLENT = 84;
	public static final int NOTES_XMLREFORMATTER = 85;
	public static final int NOTES_DOMDOCUMENTFRAGMENTNODE = 86;
	public static final int NOTES_DOMNOTATIONNODE = 87;
	public static final int NOTES_DOMCHARACTERDATANODE = 88;
	public static final int NOTES_PROPERTYBROKER = 89;
	public static final int NOTES_NOTESPROPERTY = 90;
	public static final int NOTES_DIRECTORY = 91;
	public static final int NOTES_DIRNAVIGATOR = 92;
	public static final int NOTES_DIRENTRY = 93;
	public static final int NOTES_DIRENTRYCOLLECTION = 94;
	public static final int NOTES_DOMAIN = 95;
	public static final int NOTES_CALENDAR = 96;
	public static final int NOTES_CALENDARENTRY = 97;
	public static final int NOTES_CALENDARNOTICE = 98;

	/** The Constant log_. */
	private static final Logger log_ = Logger.getLogger(Base.class.getName());
	/** the class id of this object type (implemented as precaution) **/
	final int clsid;
	/** The parent/ancestor. */
	protected P parent;
	/**
	 * List of children (for recycling). Under consideration. Currently
	 * inactive.
	 */
	protected FastTable<Base<?>> children = null;
	/** Event listeners. Not implemented yet. */
	private List<IDominoListener> listeners_;
	/** Event listener cache. Not implemented yet. */
	private transient Map<EnumEvent, List<IDominoListener>> listenerCache_;

	/**
	 * Default constructor.
	 * 
	 * @since 0.4.0
	 */
	protected Base(final P prnt, final int classId) {
		clsid = classId;
		parent = prnt;
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for no arg child objects (deserialzation) <br>
	 * Currently unused.
	 */
	protected Base(final int classId) {
		clsid = classId;
	}

	/**
	 * Gets the ancestor session of the object. Not implemented yet. Not sure if
	 * needed.
	 * 
	 * @param base
	 * @return
	 */
	protected static lotus.domino.Session getSession(final lotus.domino.Base base) {
		return null;
	}

	/**
	 * Recycles object. Under consideration.
	 * 
	 * @since 0.4.0
	 */
	@Override
	public void recycle() throws NotesException {
		/*
		 * if (null != children) { for (Base<?> child : children) { if (null !=
		 * child) { child.recycle(); } } }
		 */
	}

	/**
	 * Recycles a list of objects. Under consideration.
	 * 
	 * @since 0.4.0
	 */
	@SuppressWarnings("rawtypes")
	public void recycle(final Vector objects) throws NotesException {
		/*
		 * for (Object member : objects) { if (null != member) if (member
		 * instanceof Base<?>) { ((Base<?>)member).recycle(); } }
		 */
	}

	/**
	 * Under consideration. Not sure if needed.
	 */
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Whether there are any listeners attached to this object. Under
	 * consideration.
	 */
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
