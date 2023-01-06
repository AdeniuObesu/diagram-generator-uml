package org.mql;

import java.io.File;
import java.util.logging.Logger;

import org.mql.uml.models.Project;
import org.mql.uml.parsers.Parser;
import org.mql.uml.parsers.ProjectParser;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class RunUMLGenerator {
	// TODO : Configure RunUMLGenerator to log in the console
	private static final Logger logger = Logger.getLogger(RunUMLGenerator.class.getName());
	
	public static void main(String[] args) {
//		if(args.length < 1) {
//			System.out.println("Invalid argument, needs one argument !");
//			System.out.println("-> The Complete path to a folder containing binaries !");
//			return;
//		}
		RunUMLGenerator obj = new RunUMLGenerator();
//		obj.startProcess(args[0]);
		// For now let's try with a hard coded argument
		obj.startProcess("C:\\eclipse-workspace\\diagram-generator-uml\\bin");
	}
	/*
	 * Starts the process of UML diagrams generation
	 * */
	private void startProcess(String projectPath) {
		// TODO : create the class diagram
		Parser parser = new ProjectParser();
		Project project = (Project) parser.parse(new File(projectPath));
		System.out.println(project);
	}
}
