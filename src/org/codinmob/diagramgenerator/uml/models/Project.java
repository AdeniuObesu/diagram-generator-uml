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
		if(project == null && folder!=null )
			project = new Project(folder);
		return project;
	}
	
	public static String getAbsolutePath() {
		if(project != null)
			return project.getPath();
		return "";
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
	
	private Project(File folder) {
		this.name = folder.getName();
		this.path = folder.getAbsolutePath();
		packages = new Vector<>();
		logger.info("The project instance is created !");
	}
	
	public List<UMLPackage> getPackages(){
		return packages;
	}
	
	public void addPackage(UMLPackage anotherPackage) {
		if(anotherPackage !=null )
			this.packages.add(anotherPackage);
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
