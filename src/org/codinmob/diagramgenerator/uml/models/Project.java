/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.io.File;
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
	
	/*
	 * One instance only of Project will be created during execution !
	 * */
	public static Project getInstance(File folder) { // Lazy instantiation
		if(project == null)
			project = new Project(folder);
		return project;
	}
	
	private Project(File folder) {
		this.name = folder.getName();
		this.path = folder.getAbsolutePath();
		packages = new Vector<>();
		logger.info("The project instance is created !");
	}
	
	public void setPackages(List<UMLPackage> packages) {
		this.packages = packages;
	}
	public void addPackage(UMLPackage anotherPackage) {
		if(anotherPackage !=null )
			this.packages.add(anotherPackage);
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
		temp.append("\n--Packages : ");
		for(UMLPackage item : packages)
			temp.append( "\n----"+ item);
		return temp.toString();
	}
}
