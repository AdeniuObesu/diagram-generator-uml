/**
 * 
 */
package org.mql.uml.models;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class Project {
	private static final Logger logger = Logger.getLogger(Project.class.getName());
	private String path;
	private String name;
	private List<UMLPackage> packages;
	
	private static Project project;
	
	public static Project getInstance(String path) { // Lazy instantiation
		if(project == null)
			project = new Project(path);
		return project;
	}
	
	private Project(String path) {
		name = "root";
		this.path = path;
		logger.info("The project instance is created !");
	}
	
	public void setUMLPackages(List<UMLPackage> packages) {
		this.packages = packages;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Project : " + name);
		for(UMLPackage item : packages)
			temp.append( "\n\t"+ item);
		return temp.toString();
	}
}
