/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import org.codinmob.diagramgenerator.uml.models.Project;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
public class CustomClassLoader {
	private static URLClassLoader loader;
	
	public static Class<?> loadClass(File file){
		try {
			if(loader == null) {
				loader = URLClassLoader.newInstance(new URL[] {
						new URL("file:///"+Project.getAbsolutePath().replace('\\', '/')+"/")
				});
			}
			// The class name here must be a binary name
			String className = PathResolver.retrieveClassFileRelativePath(file.getAbsolutePath());
			return loader.loadClass(className);
		} catch (Exception e) {
			System.err.println("Failed to load : " + file.getName());
		}
		return null;
	}
}
