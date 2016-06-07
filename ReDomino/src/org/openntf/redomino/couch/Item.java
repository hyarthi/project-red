/**
 * 
 */
package org.openntf.redomino.couch;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.Vector;

import org.xml.sax.InputSource;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.NotesException;
import lotus.domino.XSLTResultTarget;

/**
 * @author Vladimir Kornienko
 *
 */
public class Item implements lotus.domino.Item, CouchBase {
	/** Parent document */
	private Document parent;
	/** Item type (relates to original Notes item types) */
	private int type;
	/**
	 * Raw source object parsed from Couch response (stems from document parent)
	 */
	private JsonJavaObject raw;
	// private Object value;
	private Set<Flags> flags;
	private String name;
	private boolean multiValue;
	private Set<Separators> separators;
	private Separators viewSeparator;

	public static enum Type {
		;
		public static final int ERRORITEM = 256;
		public static final int UNAVAILABLE = 512;
		public static final int TEXT = 1280;
		public static final int NUMBERS = 768;
		public static final int DATETIMES = 1024;
		public static final int NAMES = 1074;
		public static final int READERS = 1075;
		public static final int AUTHORS = 1076;
		public static final int RICHTEXT = 1;
		public static final int USERID = 1792;
		public static final int FORMULA = 1536;
		public static final int COLLATION = 2;
		public static final int NOTEREFS = 4;
		public static final int NOTELINKS = 7;
		public static final int ATTACHMENT = 1084;
		public static final int OTHEROBJECT = 1085;
		public static final int UNKNOWN = 0;
		public static final int ICON = 6;
		public static final int SIGNATURE = 8;
		public static final int USERDATA = 14;
		public static final int EMBEDDEDOBJECT = 1090;
		public static final int QUERYCD = 15;
		public static final int ACTIONCD = 16;
		public static final int ASSISTANTINFO = 17;
		public static final int VIEWMAPDATA = 18;
		public static final int VIEWMAPLAYOUT = 19;
		public static final int LSOBJECT = 20;
		public static final int HTML = 21;
		public static final int MIME_PART = 25;
		public static final int RFC822TEXT = 1282;
	}

	public enum Flags {
		AUTHORS(1, "AUTHORS"), READERS(2, "READERS"), ENCRYPTED(4, "ENCRYPTED"), NAMES(8, "NAMES"), SIGNED(16,
				"SIGNED"), SUMMARY(32, "SUMMARY"), SAVE_TO_DISK(64, "SAVE_TO_DISK"), PROTECTED(128, "PROTECTED"),;
		private int code;
		private String name;

		Flags(int _code, String _name) {
			code = _code;
			name = _name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}

	public enum Separators {
		SPACE(1, " ", "SPACE"), COMMA(2, ",", "COMMA"), SEMICOLON(4, ";", "SEMICOLON"), NEWLINE(8, "\n",
				"NEWLINE"), BLANKLINE(16, "\n\n", "BLANKLINE");

		private String value;
		private String name;
		private int code;

		Separators(int _code, String _value, String _name) {
			value = _value;
			name = _name;
			code = _code;
		}

		public String getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public int getCode() {
			return code;
		}

		public boolean equals(Separators sep) {
			return this.getCode() == sep.getCode();
		}
	}

	/**
	 * 
	 */
	Item() {
		// TODO Auto-generated constructor stub
	}

	Item(final String _name, final Document _parent, final JsonJavaObject _value) {
		name = _name;
		parent = _parent;
		raw = _value;
		initItem();
	}

	Item(final String _name, final Document _parent, final int _type) {
		name = _name;
		parent = _parent;
		initBlankItem();
	}

	Item(final String _name, final Document _parent, final Object _value) {
		name = _name;
		parent = _parent;
		initItemWithValue(_value);
	}

	// Item(final String _name, final Document _parent, final Object _value,
	// boolean _multiValue) {
	// name = _name;
	// parent = _parent;
	// initItemWithValue(_value);
	// }
	//
	// Item(final String _name, final Document _parent, final Object _value,
	// boolean _multiValue, final Set<Separators> _separators) {
	// name = _name;
	// parent = _parent;
	// initItemWithValue(_value);
	// }
	//
	// Item(final String _name, final Document _parent, final Object _value,
	// boolean _multiValue, final Set<Separators> _separators, final Separators
	// _viewSep) {
	// name = _name;
	// parent = _parent;
	// initItemWithValue(_value);
	// }

	private void initItem() {
		type = raw.getAsInt(FieldNames.ITEM_TYPE);
		flags = EnumSet.noneOf(Flags.class);
		if (raw.containsKey(FieldNames.ITEM_FLAGS)) {
			// TODO binary comparison for flags here
		}
		if (raw.containsKey(FieldNames.ITEM_MULTIVALUE)) {
			multiValue = raw.getAsBoolean("multiValue");
			separators = EnumSet.noneOf(Separators.class);
			if (multiValue && raw.containsKey(FieldNames.ITEM_SEPARATORS)) {
				// TODO binary comparison for separators here
			} else {
				// TODO change this?
				separators.add(Separators.COMMA);
			}
		} else {
			multiValue = false;
			separators = EnumSet.noneOf(Separators.class);
		}
	}

	private void initBlankItem() {
		type = Type.TEXT;
		raw = new JsonJavaObject();
		flags = EnumSet.noneOf(Flags.class);

		// init internal settings
		raw.putInt(FieldNames.ITEM_TYPE, type);
		// raw.putInt(FieldNames.ITEM_FLAGS, dumpFlags());

		// init value
		raw.putString(FieldNames.ITEM_VALUE, "");

		multiValue = false;
		separators = EnumSet.noneOf(Separators.class);
		viewSeparator = null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initItemWithValue(final Object _value) {
		initBlankItem();
		Vector values = new Vector(0);
		if (_value instanceof Vector) {
			values = (Vector)_value;
		} else if (_value instanceof Collection) {
			values.addAll((Collection)_value);
		} else {
			values.add(_value);
		}
		try {
			setValues(values);
		} catch (NotesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int dumpFlags() {
		// TODO method stub
		return 0;
	}

	protected Separators getViewSeparator() {
		return viewSeparator;
	}

	JsonJavaObject getRaw() {
		return raw;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub
		raw.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void recycle(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#abstractText(int, boolean, boolean)
	 */
	@Override
	public String abstractText(int arg0, boolean arg1, boolean arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#appendToTextList(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void appendToTextList(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#appendToTextList(java.lang.String)
	 */
	@Override
	public void appendToTextList(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#copyItemToDocument(lotus.domino.Document)
	 */
	@Override
	public lotus.domino.Item copyItemToDocument(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#copyItemToDocument(lotus.domino.Document,
	 * java.lang.String)
	 */
	@Override
	public lotus.domino.Item copyItemToDocument(lotus.domino.Document arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getDateTimeValue()
	 */
	@Override
	public DateTime getDateTimeValue() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getInputSource()
	 */
	@Override
	public InputSource getInputSource() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getLastModified()
	 */
	@Override
	public DateTime getLastModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getMIMEEntity()
	 */
	@Override
	public MIMEEntity getMIMEEntity() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getName()
	 */
	@Override
	public String getName() throws NotesException {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getParent()
	 */
	@Override
	public Document getParent() throws NotesException {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getReader()
	 */
	@Override
	public Reader getReader() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getText()
	 */
	@Override
	public String getText() throws NotesException {
		// TODO Auto-generated method stub
		if (type == Type.TEXT)
			return raw.getAsString(FieldNames.ITEM_VALUE);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getText(int)
	 */
	@Override
	public String getText(int maxlen) throws NotesException {
		String result = getText();
		if (null != result)
			return result.substring(0, maxlen);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getType()
	 */
	@Override
	public int getType() throws NotesException {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueCustomData()
	 */
	@Override
	public Object getValueCustomData() throws IOException, ClassNotFoundException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueCustomData(java.lang.String)
	 */
	@Override
	public Object getValueCustomData(String arg0) throws IOException, ClassNotFoundException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueCustomDataBytes(java.lang.String)
	 */
	@Override
	public byte[] getValueCustomDataBytes(String arg0) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueDateTimeArray()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getValueDateTimeArray() throws NotesException {
		Vector result = new Vector(0);
		DateTime dt;

		if (multiValue) {
			JsonJavaArray jarray = raw.getAsArray(FieldNames.ITEM_VALUE);
			for (Object value : jarray) {
				JsonJavaObject jobject = (JsonJavaObject) value;
				if (jobject.getAsBoolean(FieldNames.ITEM_DATETIME_DATERANGE)) {
					// TODO spawn date ranges
				} else {
					// TODO spawn date times
					dt = spawnDateTime(jobject);
					result.add(dt);
				}
			}
		} else {
			JsonJavaObject jobject = raw.getAsObject(FieldNames.ITEM_VALUE);
			if (jobject.getAsBoolean(FieldNames.ITEM_DATETIME_DATERANGE)) {
				// TODO spawn date ranges
			} else {
				// TODO spawn date times
				dt = spawnDateTime(jobject);
				result.add(dt);
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueDouble()
	 */
	@Override
	public double getValueDouble() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueInteger()
	 */
	@Override
	public int getValueInteger() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueLength()
	 */
	@Override
	public int getValueLength() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValueString()
	 */
	@Override
	public String getValueString() throws NotesException {
		// TODO Auto-generated method stub
		switch (type) {
		case Type.TEXT:
			return raw.getAsString(FieldNames.ITEM_VALUE);
		default:
			// TODO throw exception here
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#getValues()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getValues() throws NotesException {
		// TODO Auto-generated method stub
		Vector result = new Vector(0);
		if (type == Type.TEXT) {
			if (multiValue) {
				JsonJavaArray jarray = raw.getAsArray(FieldNames.ITEM_VALUE);
				for (Object value : jarray) {
					result.add(value.toString());
				}
			} else {
				result.add(raw.getAsString(FieldNames.ITEM_VALUE));
			}
			return result;
		}
		if (type == Type.DATETIMES) {
			result = getValueDateTimeArray();
		}
		return result;
	}

	private DateTime spawnDateTime(JsonJavaObject value) {
		org.openntf.redomino.couch.DateTime dt = null;
		org.openntf.redomino.couch.DateTime.Type type;

		if (value.getAsBoolean(FieldNames.ITEM_DATETIME_DATEONLY))
			type = org.openntf.redomino.couch.DateTime.Type.DATEONLY;
		else if (value.getAsBoolean(FieldNames.ITEM_DATETIME_TIMEONLY))
			type = org.openntf.redomino.couch.DateTime.Type.TIMEONLY;
		else
			type = org.openntf.redomino.couch.DateTime.Type.DATETIME;

		dt = new org.openntf.redomino.couch.DateTime(getAncestorSession(), value.getAsInt(FieldNames.ITEM_DATETIME_TZ),
				type, value.getAsString(FieldNames.ITEM_VALUE));

		return dt;
	}

	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isAuthors()
	 */
	@Override
	public boolean isAuthors() throws NotesException {
		return flags.contains(Flags.AUTHORS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isEncrypted()
	 */
	@Override
	public boolean isEncrypted() throws NotesException {
		return flags.contains(Flags.ENCRYPTED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isNames()
	 */
	@Override
	public boolean isNames() throws NotesException {
		return flags.contains(Flags.NAMES);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isProtected()
	 */
	@Override
	public boolean isProtected() throws NotesException {
		return flags.contains(Flags.PROTECTED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isReaders()
	 */
	@Override
	public boolean isReaders() throws NotesException {
		return flags.contains(Flags.READERS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isSaveToDisk()
	 */
	@Override
	public boolean isSaveToDisk() throws NotesException {
		return flags.contains(Flags.SAVE_TO_DISK);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isSigned()
	 */
	@Override
	public boolean isSigned() throws NotesException {
		return flags.contains(Flags.SIGNED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#isSummary()
	 */
	@Override
	public boolean isSummary() throws NotesException {
		return flags.contains(Flags.SUMMARY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#parseXML(boolean)
	 */
	@Override
	public org.w3c.dom.Document parseXML(boolean arg0) throws IOException, NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setAuthors(boolean)
	 */
	@Override
	public void setAuthors(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setDateTimeValue(lotus.domino.DateTime)
	 */
	@Override
	public void setDateTimeValue(lotus.domino.DateTime value) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setEncrypted(boolean)
	 */
	@Override
	public void setEncrypted(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.ENCRYPTED);
		} else {
			flags.remove(Flags.ENCRYPTED);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setNames(boolean)
	 */
	@Override
	public void setNames(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.NAMES);
		} else {
			flags.remove(Flags.NAMES);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setProtected(boolean)
	 */
	@Override
	public void setProtected(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.PROTECTED);
		} else {
			flags.remove(Flags.PROTECTED);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setReaders(boolean)
	 */
	@Override
	public void setReaders(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.READERS);
		} else {
			flags.remove(Flags.READERS);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setSaveToDisk(boolean)
	 */
	@Override
	public void setSaveToDisk(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.READERS);
		} else {
			flags.remove(Flags.READERS);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setSigned(boolean)
	 */
	@Override
	public void setSigned(boolean flag) throws NotesException {
		if (flag) {
			flags.add(Flags.SIGNED);
		} else {
			flags.remove(Flags.SIGNED);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setSummary(boolean)
	 */
	@Override
	public void setSummary(boolean flag) throws NotesException {
		// TODO Auto-generated method stub
		if (flag) {
			flags.add(Flags.SUMMARY);
		} else {
			flags.remove(Flags.SUMMARY);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueCustomData(java.lang.Object)
	 */
	@Override
	public void setValueCustomData(Object arg0) throws IOException, NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueCustomData(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setValueCustomData(String arg0, Object arg1) throws IOException, NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueCustomDataBytes(java.lang.String, byte[])
	 */
	@Override
	public void setValueCustomDataBytes(String arg0, byte[] arg1) throws IOException, NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueDouble(double)
	 */
	@Override
	public void setValueDouble(double arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueInteger(int)
	 */
	@Override
	public void setValueInteger(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValueString(java.lang.String)
	 */
	@Override
	public void setValueString(String value) throws NotesException {
		// TODO Auto-generated method stub
		switch (type) {
		case Type.TEXT:
			// this.value = value;
			raw.putString(FieldNames.ITEM_VALUE, value);
			return;
		default:
			// TODO throw exception here
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#setValues(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setValues(Vector values) throws NotesException {
		TypeCaster.vectorToObject(values, raw);
		initItem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Item#transformXML(java.lang.Object,
	 * lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void transformXML(Object arg0, XSLTResultTarget arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	JsonJavaObject forSubmit() {
		// switch (type) {
		// case Type.TEXT:
		// raw.putString(FieldNames.ITEM_VALUE, value);
		// break;
		// default:
		// // TODO throw exception here
		// break;
		// }
		raw.putInt(FieldNames.ITEM_FLAGS, dumpFlags());
		return raw;
	}
}
