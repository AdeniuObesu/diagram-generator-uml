package org.mql;

import java.io.File;
import java.util.logging.Logger;

import org.mql.uml.parsers.ProjectParser;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class RunUMLGenerator {
	// TODO : Configure RunUMLGenerator to log in the console
	private static final Logger logger = Logger.getLogger(RunUMLGenerator.class.getName());
	
	public static void main(String[] args) {
//		if(args.length < 2) {
//			System.out.println("Invalid arguments, needs one argument !");
//			System.out.println("-> The Complete path to a folder containing binaries\"bin\" for instance !");
//			return;
//		}
		RunUMLGenerator obj = new RunUMLGenerator();
//		obj.startProcess(args[0], "bin");
		// For now let's try with a hard coded argument
//		obj.startProcess("C:\\project\\bin\\", "bin");
		obj.startProcess("C:\\eclipse-workspace\\diagram-generator-uml\\", "bin");
	}
	/*
	 * Starts the process of UML diagrams generation
	 * */
	private void startProcess(String binPath, String useless) {
		// TODO : create the class diagram
		File binFolder = new File(binPath);
		if (!binFolder.isDirectory()) {
			logger.warning("Folder path provided is not valid, please check -> " + binPath);
			return;
		}
		ProjectParser project = new ProjectParser(binFolder.getAbsolutePath());
	}
}
