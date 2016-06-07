/**
 * 
 */
package org.openntf.domino.impl;

import java.util.List;
import java.util.Map;

import org.openntf.domino.impl.View.DominoColumnInfo;

/**
 * @author Vladimir Kornienko
 *
 */
public enum ODAPincher {
	;
	public static Base<?, ?, ?> extractSiblingWrapper(Base<?, ?, ?> elem) {
		return elem.siblingWrapper_;
	}

	public static void linkToExisting(Base<?, ?, ?> source, Base<?, ?, ?> target) {
		source.linkToExisting(target);
	}

	public static lotus.domino.View getParentView(final lotus.domino.ViewEntry base) {
		return org.openntf.domino.impl.ViewEntry.getParentView(base);
	}

	public static lotus.domino.Session getSession(final lotus.domino.Base base) {
		return org.openntf.domino.impl.Base.getSession(base);
	}

	public static <T extends lotus.domino.Base> T toLotus(final T wrapper) {
		return org.openntf.domino.impl.Base.toLotus(wrapper);
	}

	public static void s_recycle(final Object o) {
		org.openntf.domino.impl.Base.s_recycle(o);
	}

	public static boolean s_recycle(final lotus.domino.Base base) {
		return org.openntf.domino.impl.Base.s_recycle(base);
	}
}
