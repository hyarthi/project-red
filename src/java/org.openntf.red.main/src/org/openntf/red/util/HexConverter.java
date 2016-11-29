/**
 * 
 */
package org.openntf.red.util;

/**
 * @author Vladimir Kornienko
 *
 */
public enum HexConverter {
	;
	public static Integer toInteger(String hex) {
		// TODO check for supported characters
		hex.replace("0x", "");
		if (hex.length() > 8)
			throw new IllegalArgumentException("Input is too long.");
		if (hex.charAt(0) >= '8')
			hex = "-" + hex;

		return Integer.valueOf(Integer.parseInt(hex, 16));
	}
	
	public static int toInt(String hex) {
		// TODO check for supported characters
		hex.replace("0x", "");
		if (hex.length() > 8)
			throw new IllegalArgumentException("Input is too long.");
		if (hex.charAt(0) >= '8')
			hex = "-" + hex;

		return Integer.parseInt(hex, 16);
	}
}
