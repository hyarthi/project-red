/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Set;
import java.util.Vector;

import org.openntf.redomino.couch.Item.Separators;
import org.openntf.redomino.couch.Item.Type;
import org.openntf.redomino.utils.Strings;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

/**
 * @author Vladimir Kornienko
 *
 */
public enum TypeCaster {
	;
	public static String objectToString(Object value, final int itemType, final Separators viewSep) {
		if (itemType == Item.Type.TEXT) {
			if (value instanceof String)
				return (String) value;
			if (value instanceof JsonJavaArray) {
				JsonJavaArray jarray = (JsonJavaArray) value;
				// check if format is correct
				if (jarray.size() == 0)
					return null;
				String result = "";
				String sep = "";
				if (null == viewSep)
					sep = Separators.COMMA.getValue();
				else
					sep = viewSep.getValue();
				for (int i = 0; i < jarray.size(); i++) {
					if (!(jarray.get(i) instanceof String)) {
						// TODO throw exception here - the data formats are
						// wrong
					}
					if (i != 0)
						result += sep;
					result += jarray.getAsString(i);
				}
				return result;
			}
		}
		return null;
	}

	public static JsonJavaArray objectToArray(Object value, final int itemType, final Set<Separators> separators) {
		JsonJavaArray jarray = new JsonJavaArray(0);
		if (itemType == Item.Type.TEXT)
			if (value instanceof String) {
				if (null != separators && !separators.isEmpty()) {
					// TODO check this
					String reg = "[";
					if (separators.contains(Separators.COMMA))
						reg += ",";
					if (separators.contains(Separators.SEMICOLON))
						reg += ";";
					if (separators.contains(Separators.SPACE))
						reg += " ";
					if (separators.contains(Separators.NEWLINE) && separators.contains(Separators.BLANKLINE))
						reg += "(\\n|\\n\\n)";
					else if (separators.contains(Separators.NEWLINE))
						reg += "\\n";
					else if (separators.contains(Separators.BLANKLINE))
						reg += "(\\n\\n)";
					reg += "]";
					String[] values = ((String) value).split(reg);
					for (int i = 0; i < values.length; i++)
						jarray.putString(jarray.size(), values[i]);
					return jarray;
				} else {
					jarray.putString(jarray.size(), (String) value);
					return jarray;
				}
			}
		return null;
	}

	public static JsonJavaArray dateTimeToArray(Object dt) {
		JsonJavaArray jarray = new JsonJavaArray(0);
		JsonJavaObject jobject;
		if (dt instanceof lotus.domino.DateTime) {
			jobject = dateTimeToObject((lotus.domino.DateTime) dt);
			jarray.add(jobject);
		}
		// TODO alternate data types
		return jarray;
	}

	protected static JsonJavaObject dateTimeToObject(lotus.domino.DateTime dt) {
		JsonJavaObject jobject = new JsonJavaObject();

		if (dt instanceof CouchBase) {
			org.openntf.redomino.couch.DateTime date = (org.openntf.redomino.couch.DateTime) dt;
			jobject.putString(FieldNames.ITEM_VALUE, String.format(Strings.FORMAT_DATETIME_STORAGE, date.getAsCal()));
			jobject.putInt(FieldNames.ITEM_DATETIME_TZ, date.getTZIdx());
			jobject.putBoolean(FieldNames.ITEM_DATETIME_DATEONLY, date.isDateOnly());
			jobject.putBoolean(FieldNames.ITEM_DATETIME_TIMEONLY, date.isTimeOnly());
			jobject.putBoolean(FieldNames.ITEM_DATETIME_DATERANGE, false);
			return jobject;
		}

		return null;
	}
	
	protected static Object objectToValue(JsonJavaObject jobject, Session sess, CouchBase parent) {
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static void vectorToObject(final Vector values, JsonJavaObject raw) {
		Class<?> type = null;
		// figure out initial data type
		for (Object value : values) {
			if (null == type)
				type = value.getClass();
			else {
				if (value instanceof String || type.equals(String.class)) 
					type = String.class;	// String overrides all since anything can be converted to String
				else {
					if (!value.getClass().equals(type)) {
						// else throw exception
						return;
					}
				}
			}
		}
		if (type.equals(String.class)) {
			// convert strings
			raw.putInt(FieldNames.ITEM_TYPE, Type.TEXT);
			JsonJavaArray jarray = new JsonJavaArray(0);
			for (Object value : values)
				jarray.add(value.toString());
			raw.putArray(FieldNames.ITEM_VALUE, jarray);
		} else if (type.equals(DateTime.class)) {
			raw.putInt(FieldNames.ITEM_TYPE, Type.DATETIMES);
			JsonJavaArray jarray = new JsonJavaArray(0);
			for (Object value : values)
				jarray.add(dateTimeToObject((DateTime)value));
			raw.putArray(FieldNames.ITEM_VALUE, jarray);
			// TODO check if any of the flags would be needed
			raw.remove(FieldNames.ITEM_FLAGS);
		}
		// TODO more data types
		// multivalue
		if (values.size() > 1) 
			raw.putBoolean(FieldNames.ITEM_MULTIVALUE, true);
		else 
			raw.putBoolean(FieldNames.ITEM_MULTIVALUE, false);
		
	}
	
	@SuppressWarnings("rawtypes")
	public static JsonJavaObject vectorToObject(final Vector values) {
		JsonJavaObject jobject = new JsonJavaObject();
		vectorToObject(values, jobject);
		return jobject;
	}
}
