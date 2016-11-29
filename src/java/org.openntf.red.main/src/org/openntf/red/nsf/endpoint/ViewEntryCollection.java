/**
 * 
 */
package org.openntf.red.nsf.endpoint;

/**
 * @author Vladimir Kornienko
 *
 */
public interface ViewEntryCollection<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends View<?, ?, ?>>
		extends HasProperties, ViewDescendant, Base<TE, TEF, TEP> {
	@SuppressWarnings("rawtypes")
	public ViewEntry getFirstEntry();
	@SuppressWarnings("rawtypes")
	public ViewEntry getNextEntry(ViewEntry entry);
	@SuppressWarnings("rawtypes")
	public ViewEntry getPrevEntry(ViewEntry entry);
	@SuppressWarnings("rawtypes")
	public ViewEntry getLastEntry();
	@SuppressWarnings("rawtypes")
	public ViewEntry getNthEntry(long n);
}
