/**
 * 
 */
package org.openntf.redomino.couch;

import java.util.Vector;

import org.openntf.domino.exceptions.OpenNTFNotesException;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

import lotus.domino.NotesException;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewEntry implements lotus.domino.ViewEntry, CouchBase {
	private CouchBase parent;
	private int idx;
	private JsonJavaObject raw;
	private JsonJavaObject columns;

	ViewEntry(CouchBase _parent, int _idx, JsonJavaObject _raw, JsonJavaObject _columns) {
		parent = _parent;
		idx = _idx;
		raw = _raw;
		columns = _columns;
		// System.out.println("<><> Entry raw: " + raw.toString());
		// System.out.println("<><> Entry columns: " + columns.toString());
	}

	protected int getIndex() {
		return idx;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Base#recycle()
	 */
	@Override
	public void recycle() throws NotesException {
		// TODO Auto-generated method stub

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
	 * @see org.openntf.redomino.couch.CouchBase#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return parent.getAncestorSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getChildCount()
	 */
	@Override
	public int getChildCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getColumnIndentLevel()
	 */
	@Override
	public int getColumnIndentLevel() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getColumnValues()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getColumnValues() throws NotesException {
		Vector values = new Vector(0);

		for (int i = 0; i < columns.size(); i++) {
			values.add(objectToValueColumn(i));
		}

		return values;
	}

	public Object getColumnValue(String name) {
		int colidx;
		// System.out.println("<><> getColumnValue()");

		for (colidx = 0; colidx < columns.size(); colidx++) {
			if (!columns.containsKey(String.valueOf(colidx)))
				throw new OpenNTFNotesException("View design is corrupted.");
			if (name.equals(columns.getAsObject(String.valueOf(colidx)).getAsString(FieldNames.VIEW_COLUMN_NAME))
					|| name.equals(
							columns.getAsObject(String.valueOf(colidx)).getAsString(FieldNames.VIEW_COLUMN_LABEL)))
				break;
		}
		//System.out.println("<><> colidx = " + colidx);
		if (colidx >= columns.size())
			return null;

		// System.out.println("<><> objectToValueColumn()");
		return objectToValueColumn(colidx);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Object objectToValueColumn(int colidx) {
		JsonJavaObject coldef = columns.getAsObject(String.valueOf(colidx));
		if (colidx >= columns.size())
			// TODO throw exception here, maybe?
			return null;
		JsonJavaObject colvals = raw.getAsObject(FieldNames.VIEW_DATA_VALUE);
		int type = coldef.getAsInt(FieldNames.ITEM_TYPE);
		if (!colvals.containsKey(coldef.getAsString(FieldNames.VIEW_COLUMN_NAME)))
			return null;
		Object val = colvals.get(coldef.getAsString(FieldNames.VIEW_COLUMN_NAME));

		if (type == Item.Type.TEXT) {
			// System.out.println("<><> TEXT");
			if (val instanceof JsonJavaArray) {
				// System.out.println("<><> JsonJavaArray");
				JsonJavaArray jarray = (JsonJavaArray) val;
				Vector result = new Vector(0);
				for (int i = 0; i < jarray.size(); i++)
					result.add(jarray.getAsString(i));
				return result;
			} else if (val instanceof String) {
				// System.out.println("<><> String");
				return (String) val;
			} else
				new OpenNTFNotesException(
						"Invalid view column value in column " + coldef.getAsString(FieldNames.VIEW_COLUMN_NAME) + ".");
		} else if (type == Item.Type.NUMBERS) {
			if (val instanceof JsonJavaArray) {
				JsonJavaArray jarray = (JsonJavaArray) val;
				Vector result = new Vector(0);
				for (int i = 0; i < jarray.size(); i++)
					result.add(Double.valueOf(jarray.getAsDouble(i)));
				return result;
			} else if (val instanceof Double) {
				return (Double) val;
			} else
				new OpenNTFNotesException(
						"Invalid view column value in column " + coldef.getAsString(FieldNames.VIEW_COLUMN_NAME) + ".");
		} else if (type == Item.Type.DATETIMES) {
			if (val instanceof JsonJavaArray) {
				JsonJavaArray jarray = (JsonJavaArray) val;
				Vector result = new Vector(0);
				for (int i = 0; i < jarray.size(); i++)
					result.add(new DateTime(getAncestorSession(), jarray.getAsObject(i)));
				return result;
			} else if (val instanceof JsonJavaObject) {
				return new DateTime(getAncestorSession(), (JsonJavaObject) val);
			} else
				new OpenNTFNotesException(
						"Invalid view column value in column " + coldef.getAsString(FieldNames.VIEW_COLUMN_NAME) + ".");
		}

		throw new OpenNTFNotesException(
				"Invalid view column value in column " + coldef.getAsString(FieldNames.VIEW_COLUMN_NAME) + ".");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getDescendantCount()
	 */
	@Override
	public int getDescendantCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getDocument()
	 */
	@Override
	public Document getDocument() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getFTSearchScore()
	 */
	@Override
	public int getFTSearchScore() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getIndentLevel()
	 */
	@Override
	public int getIndentLevel() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getNoteID()
	 */
	@Override
	public String getNoteID() throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getNoteIDAsInt()
	 */
	@Override
	public int getNoteIDAsInt() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getParent()
	 */
	@Override
	public Object getParent() throws NotesException {
		return parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getPosition(char)
	 */
	@Override
	public String getPosition(char arg0) throws NotesException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getRead()
	 */
	@Override
	public boolean getRead() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getRead(java.lang.String)
	 */
	@Override
	public boolean getRead(String arg0) throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getSiblingCount()
	 */
	@Override
	public int getSiblingCount() throws NotesException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#getUniversalID()
	 */
	@Override
	public String getUniversalID() throws NotesException {
		return raw.getAsObject(FieldNames.VIEW_DATA_VALUE).getAsString(FieldNames.ID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isCategory()
	 */
	@Override
	public boolean isCategory() throws NotesException {
		return raw.getAsObject(FieldNames.VIEW_DATA_VALUE).getAsBoolean(FieldNames.VIEW_COLUMN_CATEGORY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isConflict()
	 */
	@Override
	public boolean isConflict() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isDocument()
	 */
	@Override
	public boolean isDocument() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isPreferJavaDates()
	 */
	@Override
	public boolean isPreferJavaDates() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isTotal()
	 */
	@Override
	public boolean isTotal() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#isValid()
	 */
	@Override
	public boolean isValid() throws NotesException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.ViewEntry#setPreferJavaDates(boolean)
	 */
	@Override
	public void setPreferJavaDates(boolean arg0) throws NotesException {
		// TODO Auto-generated method stub

	}

}
