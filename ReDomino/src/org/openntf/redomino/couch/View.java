/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class View implements lotus.domino.View, CouchBase {

	private Database parent;
	private WebTarget target;
	private String name;
	private JsonJavaObject raw;
	// private ArrayList<JsonJavaObject> columns;
	private ArrayList<String> keys_, categories_;

	View(WebTarget _target, Database _parent, String _name, JsonJavaObject _raw) {
		parent = _parent;
		target = _target;
		name = _name;
		raw = _raw;
		initColumns();
	}

	private void initColumns() {
		JsonJavaObject jobject = raw.getAsObject(FieldNames.VIEW_COLUMNS);
		keys_ = new ArrayList<String>(0);
		categories_ = new ArrayList<String>(0);
		// columns = new ArrayList<JsonJavaObject>(jarray.size());
		// for (int i = 0; i < jarray.size(); i++) {
		// columns.add(jarray.getAsObject(i).getAsInt(FieldNames.VIEW_COLUMN_INDEX),
		// jarray.getAsObject(i));
		// }
		for (int i = 0; i < jobject.keySet().size(); i++) {
			if (jobject.getAsObject(String.valueOf(i)).getAsBoolean(FieldNames.VIEW_COLUMN_KEY))
				keys_.add(String.valueOf(i));
			if (jobject.getAsObject(String.valueOf(i)).getAsBoolean(FieldNames.VIEW_COLUMN_CATEGORY))
				categories_.add(String.valueOf(i));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
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
	 * @see lotus.domino.View#FTSearch(java.lang.String)
	 */
	@Override
	public int FTSearch(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearch(java.lang.String, int)
	 */
	@Override
	public int FTSearch(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String, int)
	 */
	@Override
	public int FTSearchSorted(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector, int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String, int,
	 * java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String arg0, int arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String, int, int)
	 */
	@Override
	public int FTSearchSorted(String arg0, int arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector, int,
	 * java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0, int arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector, int, int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0, int arg1, int arg2) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String, int,
	 * java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String arg0, int arg1, String arg2, boolean arg3, boolean arg4, boolean arg5,
			boolean arg6) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.lang.String, int, int,
	 * boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String arg0, int arg1, int arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6)
			throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector, int,
	 * java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0, int arg1, String arg2, boolean arg3, boolean arg4, boolean arg5,
			boolean arg6) throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#FTSearchSorted(java.util.Vector, int, int,
	 * boolean, boolean, boolean, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int FTSearchSorted(Vector arg0, int arg1, int arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6)
			throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#clear()
	 */
	@Override
	public void clear() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(int)
	 */
	@Override
	public ViewColumn copyColumn(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(java.lang.String)
	 */
	@Override
	public ViewColumn copyColumn(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(lotus.domino.ViewColumn)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(int, int)
	 */
	@Override
	public ViewColumn copyColumn(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(java.lang.String, int)
	 */
	@Override
	public ViewColumn copyColumn(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#copyColumn(lotus.domino.ViewColumn, int)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createColumn()
	 */
	@Override
	public ViewColumn createColumn() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createColumn(int)
	 */
	@Override
	public ViewColumn createColumn(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createColumn(int, java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int arg0, String arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createColumn(int, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int arg0, String arg1, String arg2) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewEntryCollection()
	 */
	@Override
	public ViewEntryCollection createViewEntryCollection() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNav()
	 */
	@Override
	public ViewNavigator createViewNav() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNav(int)
	 */
	@Override
	public ViewNavigator createViewNav(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFrom(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFrom(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromAllUnread()
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromAllUnread(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromCategory(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromCategory(java.lang.String, int)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromChildren(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromChildren(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromDescendants(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavFromDescendants(java.lang.Object,
	 * int)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavMaxLevel(int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#createViewNavMaxLevel(int, int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int arg0, int arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAliases()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getAliases() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllDocumentsByKey(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllDocumentsByKey(java.lang.Object)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllDocumentsByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllDocumentsByKey(java.lang.Object, boolean)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllEntries()
	 */
	@Override
	public ViewEntryCollection getAllEntries() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllEntriesByKey(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) throws NotesException {
		return getAllEntriesByKey((Object) keys, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllEntriesByKey(java.lang.Object)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) throws NotesException {
		return getAllEntriesByKey(key, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllEntriesByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) throws NotesException {
		return getAllEntriesByKey((Object) keys, exact);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllEntriesByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) throws NotesException {
		JsonJavaArray keyset = objectToKeySet(key);

		WebTarget vectarget = target.path(FieldNames.VIEW_DATA).path(name);

		if (!exact) {
			JsonJavaArray keysetend = (JsonJavaArray) keyset.clone();
			keysetend.add(new JsonJavaObject());
			vectarget = vectarget
					.queryParam(FieldNames.VIEW_STARTKEY, UriBuilder.fromPath("{arg1}").build(keyset.toString()))
					.queryParam(FieldNames.VIEW_ENDKEY, UriBuilder.fromPath("{arg1}").build(keysetend.toString()));
		}
		if (categories_.size() > 0) {
			vectarget = vectarget.queryParam(FieldNames.VIEW_GROUP, true);
		}

		//System.out.println("<><><> target is: " + vectarget);
		
		Response response;
		if (exact)
			response = vectarget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(keyset, MediaType.APPLICATION_JSON_TYPE));
		else
			response = vectarget.request(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			// document not there
			response.close();
			return null;
		}
		JsonJavaObject body = response.readEntity(JsonJavaObject.class);
		//System.out.println("<><><> response body is: " + body.toString());
		response.close();
		//System.out.println("<><><> response body is: " + body.toString());

		return new ViewEntryCollection(this, body.getAsArray(FieldNames.VIEW_DATA_ROWS), raw.getAsObject(FieldNames.VIEW_COLUMNS));
	}

	@SuppressWarnings("rawtypes")
	protected JsonJavaArray objectToKeySet(Object key) {

		if (keys_.size() == 0)
			return null;

		JsonJavaArray jarray = new JsonJavaArray(0);

		if (key instanceof Vector) {
			JsonJavaArray jarray2 = formatKeyVector((Vector) key, true);
			if (null == jarray2)
				return null;
			jarray.addAll(jarray2);
			return jarray;
		} else if (key instanceof String) {
			int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
					.getAsInt(FieldNames.ITEM_TYPE);
			if (type == Item.Type.TEXT) {
				jarray.add((String) key);
				return jarray;
			}
			// TODO add other data types, maybe?
			return null;
		} else if (key instanceof Double) {
			int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
					.getAsInt(FieldNames.ITEM_TYPE);
			if (type == Item.Type.NUMBERS) {
				jarray.add((String) key);
				return jarray;
			}

			return null;
		} else if (key instanceof lotus.domino.DateTime) {
			int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
					.getAsInt(FieldNames.ITEM_TYPE);
			if (type == Item.Type.DATETIMES) {
				if (key instanceof CouchBase) {
					jarray.add(((DateTime) key).toUTCStorageString());
					return jarray;
				}
				// FIXME classic data types blocked for now
				throw new IllegalArgumentException("Argument of type " + key.getClass().getName()
						+ " is not applicable for key of type org.openntf.redomino.couch.DateTime.");
			}
			return null;
		} else
			throw new IllegalArgumentException(
					"No argument of type " + key.getClass().getName() + " is allowed for use in View selection keys.");
	}

	@SuppressWarnings("rawtypes")
	protected JsonJavaArray formatKeyVector(Vector keys, boolean noresume) {
		if (keys.size() > keys_.size())
			return null;

		JsonJavaArray jarray = new JsonJavaArray(0);
		Object key;

		for (int i = 0; i < keys.size(); i++) {
			key = keys.get(i);
			if (key instanceof Vector) {
				if (!noresume)
					throw new IllegalArgumentException("Argument of type " + key.getClass().getName()
							+ " is not allowed to be inlaid more than once into selection keys.");
				jarray.addAll(formatKeyVector((Vector) key, false));
			} else if (key instanceof String) {
				int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
						.getAsInt(FieldNames.ITEM_TYPE);
				if (type == Item.Type.TEXT) {
					jarray.add((String) key);
				} else
					// TODO add other data types, maybe?
					return null;
			} else if (key instanceof Double) {
				int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
						.getAsInt(FieldNames.ITEM_TYPE);
				if (type == Item.Type.NUMBERS) {
					jarray.add((String) key);
				} else
					return null;
			} else if (key instanceof lotus.domino.DateTime) {
				int type = raw.getAsObject(FieldNames.VIEW_COLUMNS).getAsObject(keys_.get(0))
						.getAsInt(FieldNames.ITEM_TYPE);
				if (type == Item.Type.DATETIMES) {
					if (key instanceof CouchBase) {
						jarray.add(((DateTime) key).toUTCStorageString());
					}
					// FIXME classic data types blocked for now
					throw new IllegalArgumentException("Argument of type " + key.getClass().getName()
							+ " is not applicable for key of type org.openntf.redomino.couch.DateTime.");
				} else
					return null;
			} else
				throw new IllegalArgumentException("No argument of type " + key.getClass().getName()
						+ " is allowed for use in View selection keys.");
		}

		return jarray;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllReadEntries()
	 */
	@Override
	public ViewEntryCollection getAllReadEntries() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllReadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllReadEntries(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllUnreadEntries()
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getAllUnreadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getBackgroundColor()
	 */
	@Override
	public int getBackgroundColor() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getChild(lotus.domino.Document)
	 */
	@Override
	public Document getChild(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getColumn(int)
	 */
	@Override
	public ViewColumn getColumn(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getColumnCount()
	 */
	@Override
	public int getColumnCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getColumnNames()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getColumnNames() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getColumnValues(int)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getColumnValues(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getColumns()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getColumns() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getCreated()
	 */
	@Override
	public DateTime getCreated() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getDocumentByKey(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getDocumentByKey(java.lang.Object)
	 */
	@Override
	public Document getDocumentByKey(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getDocumentByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Document getDocumentByKey(Vector arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getDocumentByKey(java.lang.Object, boolean)
	 */
	@Override
	public Document getDocumentByKey(Object arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getEntryByKey(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getEntryByKey(java.lang.Object)
	 */
	@Override
	public ViewEntry getEntryByKey(Object arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getEntryByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getEntryByKey(Vector arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getEntryByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntry getEntryByKey(Object arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getEntryCount()
	 */
	@Override
	public int getEntryCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getFirstDocument()
	 */
	@Override
	public Document getFirstDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getHeaderLines()
	 */
	@Override
	public int getHeaderLines() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getHttpURL()
	 */
	@Override
	public String getHttpURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getLastDocument()
	 */
	@Override
	public Document getLastDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getLastModified()
	 */
	@Override
	public DateTime getLastModified() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getLockHolders()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getLockHolders() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getName()
	 */
	@Override
	public String getName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getNextDocument(lotus.domino.Document)
	 */
	@Override
	public Document getNextDocument(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getNextSibling(lotus.domino.Document)
	 */
	@Override
	public Document getNextSibling(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getNotesURL()
	 */
	@Override
	public String getNotesURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getNthDocument(int)
	 */
	@Override
	public Document getNthDocument(int arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getParent()
	 */
	@Override
	public Database getParent() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getParentDocument(lotus.domino.Document)
	 */
	@Override
	public Document getParentDocument(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getPrevDocument(lotus.domino.Document)
	 */
	@Override
	public Document getPrevDocument(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getPrevSibling(lotus.domino.Document)
	 */
	@Override
	public Document getPrevSibling(lotus.domino.Document arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getReaders()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Vector getReaders() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getRowLines()
	 */
	@Override
	public int getRowLines() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getSelectionFormula()
	 */
	@Override
	public String getSelectionFormula() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getSelectionQuery()
	 */
	@Override
	public String getSelectionQuery() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getSpacing()
	 */
	@Override
	public int getSpacing() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getTopLevelEntryCount()
	 */
	@Override
	public int getTopLevelEntryCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getURL()
	 */
	@Override
	public String getURL() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getUniversalID()
	 */
	@Override
	public String getUniversalID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#getViewInheritedName()
	 */
	@Override
	public String getViewInheritedName() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isAutoUpdate()
	 */
	@Override
	public boolean isAutoUpdate() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isCalendar()
	 */
	@Override
	public boolean isCalendar() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isCategorized()
	 */
	@Override
	public boolean isCategorized() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isConflict()
	 */
	@Override
	public boolean isConflict() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isDefaultView()
	 */
	@Override
	public boolean isDefaultView() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isEnableNoteIDsForCategories()
	 */
	@Override
	public boolean isEnableNoteIDsForCategories() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isFolder()
	 */
	@Override
	public boolean isFolder() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isHierarchical()
	 */
	@Override
	public boolean isHierarchical() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isModified()
	 */
	@Override
	public boolean isModified() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isPrivate()
	 */
	@Override
	public boolean isPrivate() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isProhibitDesignRefresh()
	 */
	@Override
	public boolean isProhibitDesignRefresh() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isProtectReaders()
	 */
	@Override
	public boolean isProtectReaders() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#isQueryView()
	 */
	@Override
	public boolean isQueryView() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock()
	 */
	@Override
	public boolean lock() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock(boolean)
	 */
	@Override
	public boolean lock(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock(java.lang.String)
	 */
	@Override
	public boolean lock(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lockProvisional()
	 */
	@Override
	public boolean lockProvisional() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean lockProvisional(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#markAllRead()
	 */
	@Override
	public void markAllRead() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#markAllUnread()
	 */
	@Override
	public void markAllUnread() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#refresh()
	 */
	@Override
	public void refresh() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#remove()
	 */
	@Override
	public void remove() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#removeColumn()
	 */
	@Override
	public void removeColumn() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#removeColumn(int)
	 */
	@Override
	public void removeColumn(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#removeColumn(java.lang.String)
	 */
	@Override
	public void removeColumn(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#resortView()
	 */
	@Override
	public void resortView() throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#resortView(java.lang.String)
	 */
	@Override
	public void resortView(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#resortView(java.lang.String, boolean)
	 */
	@Override
	public void resortView(String arg0, boolean arg1) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setAliases(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setAliases(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setAliases(java.lang.String)
	 */
	@Override
	public void setAliases(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setAutoUpdate(boolean)
	 */
	@Override
	public void setAutoUpdate(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setBackgroundColor(int)
	 */
	@Override
	public void setBackgroundColor(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setDefaultView(boolean)
	 */
	@Override
	public void setDefaultView(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setEnableNoteIDsForCategories(boolean)
	 */
	@Override
	public void setEnableNoteIDsForCategories(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setName(java.lang.String)
	 */
	@Override
	public void setName(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setProhibitDesignRefresh(boolean)
	 */
	@Override
	public void setProhibitDesignRefresh(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setProtectReaders(boolean)
	 */
	@Override
	public void setProtectReaders(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setReaders(java.util.Vector)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setReaders(Vector arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setSelectionFormula(java.lang.String)
	 */
	@Override
	public void setSelectionFormula(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setSelectionQuery(java.lang.String)
	 */
	@Override
	public void setSelectionQuery(String arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#setSpacing(int)
	 */
	@Override
	public void setSpacing(int arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.View#unlock()
	 */
	@Override
	public void unlock() throws NotesException {
		// TODO Auto-generated method stub

	}

	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

}
