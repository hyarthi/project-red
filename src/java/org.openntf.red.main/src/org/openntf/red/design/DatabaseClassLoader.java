package org.openntf.red.design;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 *
 */
public abstract class DatabaseClassLoader extends ClassLoader {
	public DatabaseClassLoader(final ClassLoader parent) {
		super(parent);
	}

	public abstract Set<Class<?>> getClassesWithAnnotation(Class<? extends Annotation> annotationClass);

	public abstract <T> Set<Class<? extends T>> getClassesExtending(final Class<T> superClass);

	public abstract DatabaseDesign getParentDesign();

}
