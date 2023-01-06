/**
 * 
 */
package org.mql.uml.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
public class CustomLoader {
	private static final Logger logger = Logger.getLogger(CustomLoader.class.getName());
	
	public static Class<?> loadClass(File file){
		URLClassLoader loader;
		String className = StringResolver.convertClassFilePathToRelative(file.getAbsolutePath());
		String uri = file.toURI().toString();
		try {
			loader = URLClassLoader.newInstance(new URL[] {
					new URL(uri)
			});
			return loader.loadClass(className);
		} catch (Exception e) {
			logger.warning("Failed loading class : "+ file.getName() + e.getMessage());
		}
		return null;
	}
}
