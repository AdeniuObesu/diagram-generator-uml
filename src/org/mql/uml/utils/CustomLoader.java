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
	public static Class<?> loadClass(File file){
		URLClassLoader loader;
		String fileName = file.getAbsolutePath();
		String className = "org.mql.example.behaviors.Noisy";
		System.out.println("file:///" + file.getAbsolutePath().replace(fileName, "").replace("\\", "/"));
		String uri = file.toURI().toString().replace(fileName, "");
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
