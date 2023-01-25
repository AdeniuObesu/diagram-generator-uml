package org.codinmob.diagramgenerator;

import java.io.File;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.parsers.Parser;
import org.codinmob.diagramgenerator.uml.parsers.ProjectParser;
import org.codinmob.diagramgenerator.uml.parsers.dom.DOMParser;
import org.codinmob.diagramgenerator.uml.ui.swing.SwingUI;
import org.codinmob.diagramgenerator.uml.utils.FileUtils;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class RunUMLGenerator {
	private static final Logger logger = Logger.getLogger(RunUMLGenerator.class.getName());

	public static void main(String[] args) {
		if (args.length != 2) { // Add the paths as an argument in running config args for execution
			System.out.println("Invalid arguments, needs two arguments !");
			System.out.println("-> The Complete path to a folder containing binaries !");
			System.out.println("-> The Complete path to a folder where you want to save your xml file !");
			return;
		} else {
			RunUMLGenerator obj = new RunUMLGenerator();
			obj.startProcess(args[0], args[1]);
		}
	}

	/*
	 * Starts the process of UML diagrams generation
	 */
	private void startProcess(String inFolderPath, String outFolderPath) {
		logger.info("-> Start Processing");
		File projectFile = new File(inFolderPath);
		if(FileUtils.isAValidProject(projectFile)) {
			parseProject(projectFile);
			generateXMLDocument(outFolderPath);
			displaySwingUI();
		}
		logger.info("-> End Processing");
	}

	private void displaySwingUI() {
		if (Project.getInstance(null) != null) {
			logger.info("-> Started Swing UI display operation...");
			SwingUI.main(null);
			logger.info("-> Swing UI is displayed successfully !");
		} else {
			logger.info("Cannot dispaly swing UI (The project instance is not yet created !)");
		}
	}

	private void parseProject(File file) {
		Parser parser = new ProjectParser();
		System.out.println(parser.parse(file));
	}

	private void generateXMLDocument(String path) {
		if (Project.getInstance(null) != null) {
			logger.info("-> Started XML document generation...");
			DOMParser domParser = new DOMParser();
			domParser.generateXML(path);
			logger.info("-> XML document file is generated successfully !");
		} else {
			logger.info("Cannot generated XML document (The project instance is not yet created) !");
		}
	}
}
