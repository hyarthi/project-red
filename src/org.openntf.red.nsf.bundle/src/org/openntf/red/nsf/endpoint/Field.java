/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import javolution.util.FastTable;

/**
 * @author Vladimir Kornienko
 *
 */
public interface Field<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Note<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {
	/**
	 * 
	 * @return
	 */
	public FastTable<Object> getValue();

	/**
	 * 
	 * @param value
	 */
	public void setValue(Object value);
	
	public void setValue(Object value, boolean changeType);
	public int getType();
	public void setType(int type);
	
	public static class Type {
		public static final int ACTIONCD = 16;
		public static final int ASSISTANTINFO = 17;
		public static final int ATTACHMENT = 1084;
		public static final int AUTHORS = 1076;
		public static final int COLLATION = 2;
		public static final int DATETIMES = 1024;
		public static final int EMBEDDEDOBJECT = 1090;
		public static final int ERRORITEM = 256;
		public static final int FORMULA = 1536;
		public static final int HTML = 21;
		public static final int ICON = 6;
		public static final int LSOBJECT = 20;
		public static final int MIME_PART = 25;
		public static final int NAMES = 1074;
		public static final int NOTELINKS = 7;
		public static final int NOTEREFS = 4;
		public static final int NUMBERS = 768;
		public static final int OTHEROBJECT = 1085;
		public static final int QUERYCD = 15;
		public static final int READERS = 1075;
		public static final int RFC822TEXT = 1282;
		public static final int RICHTEXT = 1;
		public static final int SIGNATURE = 8;
		public static final int TEXT = 1280;
		public static final int UNAVAILABLE = 512;
		public static final int UNKNOWN = 0;
		public static final int USERDATA = 14;
		public static final int USERID = 1792;
		public static final int VIEWMAPDATA = 18;
		public static final int VIEWMAPLAYOUT = 19;
	}
}
