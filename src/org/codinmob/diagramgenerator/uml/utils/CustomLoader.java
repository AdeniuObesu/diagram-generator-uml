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
	
	public static Class<?> loadClass(File file){
		Thread.currentThread().getContextClassLoader().getResourceAsStream("context.xml");
		URLClassLoader loader;
		String className;
		className = StringResolver.convertClassFilePathToRelative(file.getAbsolutePath());
		System.out.println(className + " is the class name !");
		String uri = file.toURI().toString();
		System.out.println(uri + " is the uri !");
		try {
			loader = URLClassLoader.newInstance(new URL[] {
				new URL(uri)
			});
			return loader.loadClass("Vehicle");
		} catch (Exception e) {
			logger.warning("Failed loading class : "+ file.getName());
			e.printStackTrace();
		}
		return null;
	}
}
