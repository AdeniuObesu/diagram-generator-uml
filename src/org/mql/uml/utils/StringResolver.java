/**
 * 
 */
package org.mql.uml.utils;

import org.mql.uml.models.Project;

/**
 * Responsible of resolving and converting strings
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class StringResolver {
	
	public static final String convertPackagePathToRelative(String absolutePath) {
		if(absolutePath != null) {
			return absolutePath
					.replace(Project.getInstance(null).getPath() + "\\", "")
					.replace("\\", ".");
		}
		return "";
	}
	
	public static final String convertClassFilePathToRelative(String absolutePath) {
		if(absolutePath != null) {
			return convertPackagePathToRelative(absolutePath).replace(".class", "");
		}
		return "";
	}
	
	public static final String getShortFormOfType(String type) {
		String str = type;
		type = type.substring(str.lastIndexOf(".")+1, str.length());
		type = type.replace(";", "");
		type = type.replace("class", "");
		type = type.replace("interface", "");
		return type.trim();
	}
}
