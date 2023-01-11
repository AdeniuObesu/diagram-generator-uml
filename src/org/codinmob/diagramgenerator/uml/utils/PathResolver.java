/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

import java.io.File;

import org.codinmob.diagramgenerator.uml.models.Project;

/**
 * Responsible of resolving and converting paths
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class PathResolver {
	private static final String projectPath = Project.getAbsolutePath();
	
	public static final String retrievePackageRelativePath(String absolutePath) {
		if(absolutePath != null && ! "".equals(projectPath)) {
			return retrieveProjectPathFrom(absolutePath)
					.replace(File.separator, ".");
		}
		return "";
	}
	
	public static final String retrieveClassFileRelativePath(String absolutePath) {
		if(absolutePath != null) {
			return retrieveProjectPathFrom(absolutePath)
					.replace(".class", "");
		}
		return "";
	}
	
	private static final String retrieveProjectPathFrom(String str) {
		return str.replace(projectPath+"\\", "");
	}
	// TODO : this is not PathResolver's responsibility
	public static final String getShortFormOfType(String type) {
		String str = type;
		type = type.substring(str.lastIndexOf(".")+1, str.length());
		type = type.replace(";", "");
		type = type.replace("class", "");
		type = type.replace("interface", "");
		return type.trim();
	}
}
