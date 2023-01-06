/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

import org.codinmob.diagramgenerator.uml.models.Project;

/**
 * Responsible of resolving and converting strings
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class StringResolver {
	private static final String projectPath = Project.getInstance(null).getPath();
	
	public static final String convertPackagePathToRelative(String absolutePath) {
		if(absolutePath != null) {
			return retrieveProjectPathFrom(absolutePath);
		}
		return "";
	}
	
	public static final String convertClassFilePathToRelative(String absolutePath) {
		if(absolutePath != null) {
			return retrieveProjectPathFrom(absolutePath).replace(".class", "").replace("\\", ".");
		}
		return "";
	}
	
	private static final String retrieveProjectPathFrom(String str) {
		return str.replace(projectPath+"\\", "");
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
