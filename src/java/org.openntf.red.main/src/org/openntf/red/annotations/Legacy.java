package org.openntf.red.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Legacy.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE })
public @interface Legacy {

	/**
	 * Value.
	 * 
	 * @return the string[]
	 */
	String[] value() default { "Generics are best practice" };

	/** The Constant INTERFACES_WARNING. */
	public static final String INTERFACES_WARNING = "Methods should return interfaces instead of classes";

	/** The Constant GENERICS_WARNING. */
	public static final String GENERICS_WARNING = "Use generics";

	/** The Constant DATETIME_WARNING. */
	public static final String DATETIME_WARNING = "Lotus DateTimes are toxic. Don't use them. Switch to Java Dates or Calendars whereever possible";

	/** The Constant ITERATION_WARNING. */
	public static final String ITERATION_WARNING = "Use for (member : collection) syntax to ensure collection members are automatically recycled";

	/** The Constant IBM_DEP_WARNING. */
	public static final String IBM_DEP_WARNING = "IBM help documentation indicates that this is depreciated and should not be used.";
}
