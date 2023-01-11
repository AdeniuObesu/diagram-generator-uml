/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

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
	private static URLClassLoader loader;
	
	public static Class<?> loadClass(File file){
		try {
			if(loader == null) {
				loader = URLClassLoader.newInstance(new URL[] {
						new URL(file.toURI().toString())
				});
			}
			return loader.loadClass(file.getName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Failed to load " + file.getName());
		}
		return null;
	}
}
