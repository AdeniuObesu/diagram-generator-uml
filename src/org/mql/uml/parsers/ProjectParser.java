/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;

import org.mql.uml.models.Project;

/**
 * Parses a project, finds all packages, classes and interfaces.
 * TODO : think of a way to parse annotations and enumerations
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class ProjectParser {
	private Project project;
	
	public ProjectParser(String pathName) {
		try {
			File directory = new File(pathName);
			Project project = new Project(directory.getName());
			this.project = project;
			System.out.println(project.getName());
		} catch (Exception e) {
			System.err.println("Oups ! No file found!");
		}
	}
	
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
}
