package org.openntf.red.design;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 *
 */
public interface AnyFileResource extends DesignBaseNamed, org.openntf.red.types.DatabaseDescendant {

	/**
	 * @return the file resource's data as a byte array
	 */
	public byte[] getFileData();

	/**
	 * @return the file data in the given item as a byte array
	 */
	//public byte[] getFileData(final String itemName);

	/**
	 * @param fileData
	 *            The new data for the file resource, as a byte array
	 */
	public void setFileData(final byte[] fileData);

	//public void setFileData(String itemName, byte[] fileData);

	/**
	 * @return mime type
	 */
	public String getMimeType();

	/**
	 * @param mimeType
	 *            The new MIME type for the file resource
	 */
	public void setMimeType(final String mimeType);

	/**
	 * @return whether the file resource is marked as read-only
	 */
	public boolean isReadOnly();

	/**
	 * @return whether the file resource is marked as "deployable", whatever that means
	 */
	public boolean isDeployable();

	//	/**
	//	 * @return whether the file resource is hidden from the design list in Designer (e.g. WebContent files)
	//	 */
	//	public boolean isHideFromDesignList();

	public void setReadOnly(final boolean readOnly);

	public void setDeployable(final boolean deployable);

	//	public void setHideFromDesignList(final boolean hideFromDesignList);
}
