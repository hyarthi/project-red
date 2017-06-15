/**
 * 
 */
package org.openntf.red.nsf.endpoint;

import java.util.Set;

import javolution.util.FastTable;

/**
 * Entity representing a note field.
 * 
 * @author Vladimir Kornienko
 * @since 0.4.0
 */
public interface Field<TE extends Endpoint<?, ?, ?>, TEF extends EndpointFactory, TEP extends Note<?, ?, ?>>
		extends HasProperties, Base<TE, TEF, TEP> {
	/**
	 * Returns a list of values of the field.
	 * 
	 * @return List of field values.
	 * @since 0.4.0
	 */
	public FastTable<Object> getValue();

	/**
	 * Sets the field value (a collection of values for multi-value field).
	 * 
	 * @param value
	 *            New field value.
	 * @since 0.4.0
	 */
	public void setValue(Object value);

	/**
	 * Sets the field value (a collection of values for multi-value field).
	 * 
	 * @param value
	 *            New field value.
	 * @param changeType
	 *            Whether the field type should be changed according to value
	 *            type, or if the value should be converted to the current field
	 *            type.
	 * @since 0.4.0
	 */
	public void setValue(Object value, boolean changeType);

	/**
	 * Returns the current field data type.
	 * 
	 * @return Field data type.
	 * @see Type
	 * @since 0.4.0
	 */
	public int getType();

	/**
	 * Sets the current field type.
	 * 
	 * @param type
	 *            Field data type.
	 * @see Type
	 * @since 0.4.0
	 */
	public void setType(int type);

	/**
	 * Returns the field name.
	 * 
	 * @return Field name.
	 * @since 0.4.0
	 */
	public String getName();

	/**
	 * Returns the field flags.
	 * 
	 * @return Field flags.
	 * @since 0.4.0
	 * @see Flags
	 */
	public Set<Flags> getFlags();

	/**
	 * Default field data types.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public static class Type {
		/** Action object. */
		public static final int ACTIONCD = 16;
		/** Assistant info object. */
		public static final int ASSISTANTINFO = 17;
		/** Attachment (file). */
		public static final int ATTACHMENT = 1084;
		/** Authors field. */
		public static final int AUTHORS = 1076;
		/** Collation object */
		public static final int COLLATION = 2;
		/** Date-Time object (including date-time ranges). */
		public static final int DATETIMES = 1024;
		/** Embedded object (attachment, OLE). */
		public static final int EMBEDDEDOBJECT = 1090;
		/** Error item object. */
		public static final int ERRORITEM = 256;
		/** Formula object. */
		public static final int FORMULA = 1536;
		/** HTML */
		public static final int HTML = 21;
		/** Icon object (picture). */
		public static final int ICON = 6;
		/** LotusScript object (compiled). */
		public static final int LSOBJECT = 20;
		/** MIME part field (compound). */
		public static final int MIME_PART = 25;
		/** Names (formatted text). */
		public static final int NAMES = 1074;
		/** Notes links. */
		public static final int NOTELINKS = 7;
		/** Note reference object. */
		public static final int NOTEREFS = 4;
		/** Numbers. */
		public static final int NUMBERS = 768;
		/** Other data object (non-custom). */
		public static final int OTHEROBJECT = 1085;
		/** Query object. */
		public static final int QUERYCD = 15;
		/** Readers field. */
		public static final int READERS = 1075;
		/** RFC 822 formatted text. */
		public static final int RFC822TEXT = 1282;
		/** Notes rich text object. */
		public static final int RICHTEXT = 1;
		/** Signature object. */
		public static final int SIGNATURE = 8;
		/** Text. */
		public static final int TEXT = 1280;
		/** Data type unavailable. */
		public static final int UNAVAILABLE = 512;
		/** Data type unknown. */
		public static final int UNKNOWN = 0;
		/** User data object. */
		public static final int USERDATA = 14;
		/** User id. */
		public static final int USERID = 1792;
		/** View index data. */
		public static final int VIEWMAPDATA = 18;
		/** View index design. */
		public static final int VIEWMAPLAYOUT = 19;
	}

	/**
	 * Set of flags that may be assigned to the field.
	 * 
	 * @author Vladimir Kornienko
	 * @since 0.4.0
	 */
	public enum Flags {
		ITEM_SIGN(0x0001),			// part of a signature
		ITEM_SEAL(0x0002),			//
		ITEM_SUMMARY(0x0004),		// summary field (may be included into views)
		ITEM_READWRITERS(0x0020),	// readers/writers field
		ITEM_NAMES(0x0040),			// contains a name
		ITEM_PLACEHOLDER(0x0100),	//
		ITEM_PROTECTED(0x0200),		//
		ITEM_READERS(0x0400),		// readers field
		ITEM_UNCHANGED(0x1000);		//
		
		/** Numeric code */
		private int code;

		/**
		 * Default constructor.
		 * @param _code Numeric code.
		 */
		private Flags(int _code) {
			code = _code;
		}

		/**
		 * Returns numeric code.
		 * @return Numeric code.
		 */
		public int code() {
			return code;
		}
	}
}
