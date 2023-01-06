/**
 * 
 */
package org.codinmob.diagramgenerator.uml.utils;

import java.io.File;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author MOUKHAFI ANASS
 * @On Wednesday, January 04, 2023
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

	/*
	 * Checks whether a folder is a valid project folder
	 * */
	public static boolean isAValidProject(File folder){
		if(doesFileExists(folder)) {
			if(isAValidPackage(folder)) {
				return true; // This is enough
			} else { // Or it is enough if that folder contain at least one class file
				for(File file : folder.listFiles())
					if(isAValidPackage(file))
						return true;
			}
		}
		return false;
	}
	/*
	 * Retrieves all sub-packages of a folder
	 * */
	public static void getAllPackages(File folder, Set<File> packages) {
		if(doesFileExists(folder)) {
			for(File subFolder : folder.listFiles()) {
				if(isAValidPackage(subFolder)) {
					packages.add(subFolder);
					getAllPackages(subFolder, packages);
				}
				if(!subFolder.isFile())
					getAllPackages(subFolder, packages);
			}
		}
	}
	
	/*
	 * Checks whether a folder is package or not
	 * */
	public static boolean isAValidPackage(File folder) {
		if(doesFileExists(folder)) {
			if(folder.isDirectory()) {
				for(File file : folder.listFiles()) {
					if(file.getAbsolutePath().endsWith(".class")) {
						logger.info( folder.getAbsolutePath() + " is a valid package.");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Checks whether a file is class file
	 * */
	public static boolean isAValidClassFile(File file) {
		if(doesFileExists(file)) {
			if(file.isFile()) {
				String fileName = file.getAbsolutePath();
				if(fileName.endsWith(".class") ) {
					logger.info( file.getAbsolutePath() + " is a class file.");
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * Checks whether a file is class file that we can count as a UMLmodel or not
	 * */
	public static boolean isAValidClassFileToLoad(File file) {
		if(doesFileExists(file)) {
			if(file.isFile()) {
				String fileName = file.getAbsolutePath();
				if(fileName.endsWith(".class")
					&& !fileName.contains("$") ) {
					logger.info( file.getAbsolutePath() + " is a class file to load.");
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Checks whether a file exists or not !
	 * */
	private static boolean doesFileExists(File file) {
		if(! file.exists()) {
			logger.info(file.getAbsolutePath() + " does not exist !");
			return false;
		}
		return true;
	}
}
