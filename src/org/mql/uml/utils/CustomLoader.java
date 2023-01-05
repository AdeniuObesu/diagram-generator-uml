/**
 * 
 */
package org.mql.uml.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
public class CustomLoader {
	public static Class<?> load(File file){
		URLClassLoader loader;
		String fileName = file.getName();
		String className = fileName.replace(".class", "");
		String uri = file.toURI().toString().replace(fileName, "");
		System.out.println(uri);
		System.out.println(className);
		try {
			loader = URLClassLoader.newInstance(new URL[] {
					new URL(uri)
			});
			return loader.loadClass(className);
		} catch (Exception e) {
			System.out.println("Oups ! : " + e.getMessage());
		}
		return null;
	}
}
