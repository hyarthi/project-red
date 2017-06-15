/**
 * 
 */
package org.openntf.red.security.authorization;

import org.openntf.red.Base;
import org.openntf.red.Session;

/**
 * Entity representing an abstract Authorization Manager service.<br>
 * (Under construction)
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface IAuthorizationManager {

	/**
	 * Checks whether the user has access to the specified entity.
	 * 
	 * @param session
	 *            User session.
	 * @param entity
	 *            Entity accessed.
	 * @return Whether the user is authorized to perform the operation.
	 * @since 0.4.0
	 */
	public boolean canAccess(Session session, Base entity);

	/**
	 * Checks whether the user can perform a specified action on the runtime
	 * entity.
	 * 
	 * @param session
	 *            User session.
	 * @param object
	 *            Entity accessed.
	 * @param action
	 *            Operation code.
	 * @return Whether the user is authorized to perform the operation.
	 * @since 0.4.0
	 * @see Action
	 */
	public boolean canExecute(Session session, Base object, int action);

	/**
	 * Operation list.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static enum Action {
		/** Open/access entity. */
		OPEN(0),
		/** Read from the entity. */
		READ(1),
		/** Write to/Update the entity. */
		WRITE(2),
		/** Remove the entity. */
		DELETE(3),
		/** Run/Execute code of the entity. */
		RUN(4),
		/** Create the entity. */
		CREATE(5);

		/** Operation code. */
		private int code;

		/**
		 * Default cosntructor.
		 * 
		 * @param _code
		 *            Operation code.
		 * @since 0.4.0
		 */
		private Action(int _code) {
			code = _code;
		}
	}
}
