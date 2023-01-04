package org.mql;

import java.io.File;
import java.io.IOException;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class RunUMLGenerator {
	
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Invalid arguments, needs two arguments !");
			System.out.println("1. Complete folder path to java files.");
			System.out.println("2. Project architecture file output with XML file name");
			System.out.println("Output file will be of .xml format, no need to enter extenstion.");
			return;
		}
		RunUMLGenerator obj = new RunUMLGenerator();
		obj.startProcess(args[0], args[1]);
	}
	/*
	 * Starts the process of UML diagrams generation
	 * */
	private void startProcess(String inputPath, String outputFileName) {
		if (inputPath.indexOf(".zip") != -1) {
//			try {
//				// TODO : process any individual package and java file
//			} catch (IOException e) {
//				System.out.println("Failed to unzip the folder. \nNote: Keep the Java files in root folder of zip:\n"+ e.getMessage());
//			}
		} else {
			File folder = new File(inputPath);
			if (folder == null || !folder.isDirectory()) {
				System.out.println("Folder path provided is not valid, please check -> " + inputPath);
				return;
			}
		}
	}
}
