/**
 * 
 */
package org.openntf.redomino.couch;

/**
 * @author Vladimir Kornienko
 *
 */
public enum FieldNames {
	;
	public static final String DESIGN = "_design";
	public static final String VIEW_PREFIX = "_view_";
	public static final String VIEW_COLUMNS = "columns";
	public static final String VIEW_ALIASES = "aliases";
	public static final String VIEW_COLUMN_NAME = "_name";
	public static final String VIEW_COLUMN_LABEL = "_label";
	public static final String VIEW_COLUMN_KEY = "_key";
	public static final String VIEW_COLUMN_CATEGORY = "_category";
	public static final String VIEW_COLUMN_INDEX = "_idx";
	public static final String VIEW_FUNCTION_MAP = "map";
	public static final String VIEW_FUNCTION_REDUCE = "reduce";
	public static final String VIEW_DATA = "_view";
	public static final String VIEW_GROUP = "group";
	public static final String VIEW_STARTKEY = "startkey";
	public static final String VIEW_ENDKEY = "endkey";
	public static final String VIEW_BODY_KEYS = "keys";
	public static final String VIEW_DATA_ROWS = "rows";
	public static final String VIEW_DATA_KEY = "key";
	public static final String VIEW_DATA_VALUE = "value";
	public static final String ITEM_TYPE = "_type";
	public static final String ITEM_VALUE = "_value";
	public static final String ITEM_FLAGS = "_flags";
	public static final String ITEM_MULTIVALUE = "_multiValue";
	public static final String ITEM_SEPARATORS = "_separators";
	public static final String ITEM_DATETIME_TZ = "_tz";
	public static final String ITEM_DATETIME_DATEONLY = "_dtonly";
	public static final String ITEM_DATETIME_TIMEONLY = "_tmonly";
	public static final String ITEM_DATETIME_DATERANGE = "_range";
	public static final String ITEM_DATETIME_DATERANGE_START = "_start";
	public static final String ITEM_DATETIME_DATERANGE_END = "_end";
	public static final String ID = "_id";
	public static final String ID_REPONSE = "id";
	public static final String REVISION = "_rev";
	public static final String REVISION_RESPONSE = "rev";
	public static final String NOTES_RESPONSE = "$REF";
	public static final String NOTES_CONFLICT = "$Conflict";
	public static final String CONFLICT_ID = "_conflictid";
}
