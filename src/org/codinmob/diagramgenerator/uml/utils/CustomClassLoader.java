/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
public class CustomClassLoader {
	private static URLClassLoader loader;
	
	public static Class<?> loadClass(File file){
		try {
			System.out.println(file.getAbsolutePath());
			if(loader == null) {
				loader = URLClassLoader.newInstance(new URL[] {
						new URL("file:///"+file.getAbsolutePath())
				});
			}
			// The argument here must be like the following "org.codinmob.diagramgenerator.RunUMLGenerator"
			String className = PathResolver.retrieveClassFileRelativePath(file.getAbsolutePath());
			return loader.loadClass(className);
		} catch (Exception e) {
			System.err.println("Failed to load : " + file.getName());
		}
		return null;
	}
}
