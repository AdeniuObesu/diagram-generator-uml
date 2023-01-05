/**
 * 
 */
package org.mql.uml.utils;

/**
 * Responsible of resolving return type of new types(classes, interfaces...),
 * parameters, fields and methods
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class StringResolver {
	public static String getShortFormOfType(String type) {
		String str = type;
		type = type.substring(str.lastIndexOf(".")+1, str.length());
		type = type.replace(";", "");
		type = type.replace("class", "");
		type = type.replace("interface", "");
		return type.trim();
	}
	
	public static String getPackageName(String absolutePath) {
		return absolutePath.substring(
				absolutePath.indexOf("\\bin\\") + 5
				, absolutePath.length())
				.replace("\\", ".");
	}
}
