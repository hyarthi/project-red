/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface View extends HasProperties {
	/**
	 * 
	 * @return
	 */
	public ViewEntry getFirstEntry();
	/**
	 * 
	 * @return
	 */
	public ViewEntry getLastEntry();
	/**
	 * 
	 * @return
	 */
	public ViewEntry getNthEntry();
	/**
	 * 
	 * @param position
	 * @return
	 */
	public ViewEntry removeEntry(long position);
	/**
	 * 
	 * @param entry
	 * @param position
	 */
	public void setEntry(ViewEntry entry, long position);
	/**
	 * 
	 * @param entry
	 */
	public void addEntry(ViewEntry entry);
}
