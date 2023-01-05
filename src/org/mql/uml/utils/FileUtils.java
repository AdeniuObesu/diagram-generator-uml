/**
 * 
 */
package org.mql.uml.utils;

import java.io.File;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author MOUKHAFI ANASS
 * @On Wednesday, January 04, 2023
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class.getName());
	
	public static void getAllPackages(String path, Set<String> names) {
		File folder = new File(path);
		for(File item : folder.listFiles()) {
			if(isPackage(item.getAbsolutePath())) {
				names.add(item.getAbsolutePath());
				getAllPackages(item.getAbsolutePath(), names);
			}
			if(!item.isFile())
				getAllPackages(item.getAbsolutePath(), names);
		}
	}
	
	public static boolean isPackage(String path) {
		File folder = new File(path);
		if(folder.isDirectory()) {
			for(File item : folder.listFiles()) {
				if(item.getAbsolutePath().endsWith(".class"))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isClassFile(String fileName) {
		File destFile = new File(fileName);
		if(destFile.isFile()) {
			fileName = destFile.getAbsolutePath();
			if(fileName.endsWith(".class")
				&& !fileName.contains("$") )
				return true;
		}
		return false;
	}
}
