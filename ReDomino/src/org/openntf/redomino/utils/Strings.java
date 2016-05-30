package org.openntf.redomino.utils;

public enum Strings {
	;
	public static final String FORMAT_DATEONLY_DMY = "%1$td{dsep}%1$tb{dsep}%1$tY";
	public static final String FORMAT_DATEONLY_MDY = "%1$tb{dsep}%1$td{dsep}%1$tY";
	public static final String FORMAT_DATEONLY_YMD = "%1$tY{dsep}%1$tb{dsep}%1$td";
	public static final String FORMAT_TIMEONLY_NOAM = "%1$tH{tsep}%1$tM{tsep}%1$tS";
	public static final String FORMAT_TIMEONLY_AM = "%1$tl{tsep}%1$tM{tsep}%1$tS {ampm}";
	public static final String FORMAT_DATETIME_DMY_NOAM = FORMAT_DATEONLY_DMY + " " + FORMAT_TIMEONLY_NOAM;
	public static final String FORMAT_DATETIME_DMY_AM = FORMAT_DATEONLY_DMY + " " + FORMAT_TIMEONLY_AM;
	public static final String FORMAT_DATETIME_MDY_NOAM = FORMAT_DATEONLY_MDY + " " + FORMAT_TIMEONLY_NOAM;
	public static final String FORMAT_DATETIME_MDY_AM = FORMAT_DATEONLY_MDY + " " + FORMAT_TIMEONLY_AM;
	public static final String FORMAT_DATETIME_YMD_NOAM = FORMAT_DATEONLY_YMD + " " + FORMAT_TIMEONLY_NOAM;
	public static final String FORMAT_DATETIME_YMD_AM = FORMAT_DATEONLY_YMD + " " + FORMAT_TIMEONLY_AM;
	
	public static final String FORMAT_DATETIME_STORAGE = "%1$tY-%1$tb-%1$td-%1$tH-%1$tM-%1$tS-%1$tL";
}
