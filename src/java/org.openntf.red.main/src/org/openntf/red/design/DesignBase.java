package org.openntf.red.design;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import javax.xml.transform.Transformer;

import org.openntf.red.Database;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface DesignBase extends org.openntf.red.types.Design, org.openntf.red.types.DatabaseDescendant, Serializable {

	enum ItemFlag {
		_SIGN, _SUMMARY
	}

	enum DxlFormat {
		NONE, RAWNOTE, DXL
	}

	public static final Set<ItemFlag> FLAG_NONE = EnumSet.noneOf(ItemFlag.class);
	public static final Set<ItemFlag> FLAG_SIGN = EnumSet.of(ItemFlag._SIGN);
	public static final Set<ItemFlag> FLAG_SUMMARY = EnumSet.of(ItemFlag._SUMMARY);
	public static final Set<ItemFlag> FLAG_SIGN_SUMMARY = EnumSet.of(ItemFlag._SIGN, ItemFlag._SUMMARY);

	/**
	 * @return the DXL of the design element, as a String
	 */
	public String getDxlString(Transformer filter);

	/**
	 * @return whether hidden from web
	 */
	public boolean isHideFromWeb();

	/**
	 * @return whether hidden from notes
	 */
	public boolean isHideFromNotes();

	/**
	 * @return whether refresh flag is set
	 */
	public boolean isNeedsRefresh();

	/**
	 * @return whether prohibit design refresh is set
	 */
	public boolean isPreventChanges();

	/**
	 * @return whether the design element propagates its prevent-changes settings
	 */
	public boolean isPropagatePreventChanges();

	/**
	 * Reattach the design element to a new Database, either due to deserialization or to copy to a new DB
	 * 
	 * @param database
	 *            the Database object to attach the design element to
	 */
	public void reattach(Database database);

	public void setHideFromWeb(boolean hideFromWeb);

	public void setHideFromNotes(boolean hideFromNotes);

	public void setNeedsRefresh(boolean needsRefresh);

	public void setPreventChanges(boolean preventChanges);

	public void setPropagatePreventChanges(boolean propagatePreventChanges);

	/**
	 * Save any changes to the design element (may change the Note ID)
	 */
	public boolean save();

	//	/**
	//	 * Every element should have an (abstract) name
	//	 * 
	//	 * @return
	//	 */
	//	public String getName();

	/**
	 * Returns the On-Disk folder component
	 * 
	 */
	//	public String getOnDiskFolder();
	//
	//	public String getOnDiskName();
	//
	//	public String getOnDiskExtension();
	//
	//	public String getOnDiskPath();

	public void writeOnDiskFile(File odsFile) throws IOException;

	public Collection<String> getItemNames();
}