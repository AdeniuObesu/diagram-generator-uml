/**
 * 
 */
package org.mql.uml.utils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests each neighbor class (classes in the same package)
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
@SuppressWarnings("unused")
public class Examples {
	private static final String folderName = "C:\\eclipse-workspace\\diagram-generator-uml\\bin\\";
	private static final String fileName = folderName + "\\mql\\RunUMLGenerator.class";
	File file;
	
	public Examples() {
		testAllPackagesNames();
	}
	public static void main(String[] args) {
		new Examples();
	}
	
	
	/*---------------FileUtils class-----------------*/
	private void testAllPackagesNames() {
		Set<File> packages = new HashSet<>();
		FileUtils.getAllPackages(new File(folderName), packages);
		for(var item : packages) {
			System.out.println(item.getName() + " is a package name");
		}
	}
	private void testAValidClassFile() {
		file = new File(fileName);
		if(FileUtils.isAValidClassFile(file)) {
			System.out.println(file.getName() + " is a valid class file !");
		} else 
		System.out.println(file.getName() + " is not a valid class file !");
		file = new File(folderName);
		if(FileUtils.isAValidClassFile(file)) {
			System.out.println(file.getName() + " is a valid class file !");
			return ;
		}
		System.out.println(file.getName() + " is not a valid class file !");
	}
	
	private void testAValidPackageMethod() {
		file = new File(folderName);
		if(FileUtils.isAValidPackage(file)) {
			System.out.println(file.getName() + " is a valid package !");
		} else
		System.out.println(file.getName() + " is not a valid package !");
		file = new File(folderName + "mql\\");
		if(FileUtils.isAValidPackage(file)) {
			System.out.println(file.getName() + " is a valid package !");
			return ;
		}
		System.out.println(file.getName() + " is not a valid package !");
	}
}
