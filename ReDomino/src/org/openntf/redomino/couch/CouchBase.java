/**
 * 
 */
package org.openntf.redomino.couch;

/**
 * Used to identify Couch objects
 * 
 * @author Vladimir Kornienko
 *
 */
public interface CouchBase {
	abstract Session getAncestorSession();
}
