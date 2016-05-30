/**
 * 
 */
package org.openntf.redomino.impl;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.Session;
import org.openntf.domino.View;
import org.openntf.domino.WrapperFactory;

/**
 * @author Vladimir Kornienko
 *
 */
public class ViewColumn extends BaseNonThreadSafe<org.openntf.domino.ViewColumn, lotus.domino.ViewColumn, View>
		implements org.openntf.domino.ViewColumn {

	/**
	 * @param delegate
	 * @param parent
	 */
	protected ViewColumn(lotus.domino.ViewColumn delegate, View parent) {
		super(delegate, parent, NOTES_VIEWCOLUMN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnValuesIndex(boolean correctValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNoteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniversalID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getAncestorDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getAncestorSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAlignment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnValuesIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDateFmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFontColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFontFace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFontPointSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFontStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeaderAlignment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeaderFontColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHeaderFontFace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeaderFontPointSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeaderFontStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListSep() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberAttrib() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberDigits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberFormat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getResortToViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSecondaryResortColumnIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeDateFmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeFmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeZoneFmt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAccentSensitiveSort() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCaseSensitiveSort() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCategory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConstant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isField() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFontBold() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFontItalic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFontStrikethrough() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFontUnderline() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFormula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHeaderFontBold() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHeaderFontItalic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHeaderFontStrikethrough() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHeaderFontUnderline() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHideDetail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHideFormula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIcon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNumberAttribParens() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNumberAttribPercent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNumberAttribPunctuated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResize() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResortAscending() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResortDescending() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResortToView() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSecondaryResort() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSecondaryResortDescending() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isShowTwistie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSortDescending() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSorted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAccentSensitiveSort(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignment(int alignment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCaseSensitiveSort(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDateFmt(int format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontBold(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontColor(int color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontFace(String face) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontItalic(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontPointSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontStrikethrough(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontStyle(int style) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFontUnderline(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFormula(String formula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderAlignment(int alignment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontBold(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontColor(int color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontFace(String face) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontItalic(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontPointSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontStrikethrough(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontStyle(int style) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeaderFontUnderline(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHidden(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHideDetail(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHideFormula(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListSep(int separator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberAttrib(int attributes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberAttribParens(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberAttribPercent(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberAttribPunctuated(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberDigits(int digits) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberFormat(int format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(int position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResize(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResortAscending(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResortDescending(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResortToView(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResortToViewName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSecondaryResort(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSecondaryResortColumnIndex(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSecondaryResortDescending(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setShowTwistie(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSortDescending(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSorted(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimeDateFmt(int format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimeFmt(int format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimeZoneFmt(int format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub

	}

	@Override
	protected WrapperFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
