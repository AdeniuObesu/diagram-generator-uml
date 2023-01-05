/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.mql.uml.models.Project;
import org.mql.uml.models.UMLPackage;
import org.mql.uml.utils.FileUtils;

/**
 * Parses a project, finds all packages, classes and interfaces.
 * TODO : think of a way to parse annotations and enumerations
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class ProjectParser implements Parser{
	private final static Logger logger = Logger.getLogger(ProjectParser.class.getName());
	private Project project;
	
	public ProjectParser(String path) {
		logger.info("Parsing : " + path);
		project = Project.getInstance(path);
		project.setPath(path);
		project.setName("My old project !");
		// copy the bin
		List<UMLPackage> umlPackages = new Vector<>();
		Set<String> packageNames = new HashSet<>();
		FileUtils.getAllPackages(path, packageNames);
		UMLPackage umlPackage;
		for(String item : packageNames) {
			PackageParser parser = new PackageParser(item);
			umlPackages.add(parser.getUmlPackage());
		}
		project.setUMLPackages(umlPackages);
		System.out.println(project);
	}
	
	public Project getProject() {
		return project;
	}

	@Override
	public Object parse(File file) {
		if(FileUtils.isAValidProject(file)) {
			// TODO : Put the business logic to parse the project
			// TODO : challenge make sure one instance is going 2 be created :) !
			System.out.println("We can parse it");
		} else {
			System.out.println("We cannot parse it");
		}
		return null;
	}
}
