package org.codinmob.diagramgenerator;

import java.io.File;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.parsers.Parser;
import org.codinmob.diagramgenerator.uml.parsers.ProjectParser;
import org.codinmob.diagramgenerator.uml.parsers.dom.DOMParser;
import org.codinmob.diagramgenerator.uml.utils.FileUtils;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class RunUMLGenerator {
	private static final Logger logger = Logger.getLogger(RunUMLGenerator.class.getName());
	
	public static void main(String[] args) {
		if(args.length != 1) { // Add the path as an argument in running config args for execution
			System.out.println("Invalid argument, needs one argument !");
			System.out.println("-> The Complete path to a folder containing binaries !");
			return;
		} else {
			RunUMLGenerator obj = new RunUMLGenerator();
			File projectFile = new File(args[0]);
			if(FileUtils.isAValidProject(projectFile)) {
				obj.startProcess(projectFile);
			}
		}
	}
	/*
	 * Starts the process of UML diagrams generation
	 * */
	private void startProcess(File file) {
		logger.info("-> Start Processing");
		parseProject(file);
		generateXMLDocument();
		logger.info("-> End Processing");
	}
	
	private void parseProject(File file) {
		Parser parser = new ProjectParser();
		System.out.println(parser.parse(file));
	}
	
	private void generateXMLDocument() {
		if(Project.getInstance(null) != null) {
			logger.info("-> Started XML document generation...");
			DOMParser domParser = new DOMParser();
			domParser.generateXML();
			logger.info("-> XML document file is generated successfully !");
		} else {
			logger.info("Cannot generated XML document (The project instance is not yet created) !");
		}
	}
}
