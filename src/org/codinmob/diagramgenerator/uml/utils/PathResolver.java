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
	
	public static final String retrievePackageRelativePath(String absolutePath) {
		if(absolutePath != null && ! "".equals(Project.getAbsolutePath())) {
			return retrieveProjectPathFrom(absolutePath)
					.replace(Project.getAbsolutePath(), "")
					.replace(File.separator, ".");
		}
		return "";
	}
	
	public static final String retrieveClassFileRelativePath(String absolutePath) {
		if(absolutePath != null) {
			return retrieveProjectPathFrom(absolutePath)
					.replace(".class", "").replace(File.separatorChar, '.');
		}
		return "";
	}
	
	private static final String retrieveProjectPathFrom(String str) {
		return str.replace(Project.getAbsolutePath()+File.separator, "");
	}
}
