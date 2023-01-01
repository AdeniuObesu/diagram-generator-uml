/**
 * 
 */
package org.mql.uml.models;

import java.util.List;
import java.util.Vector;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class Project {
	private String name;
	private List<UMLPackage> packages;
	
	public Project(String name) {
		this.name = name;
		packages = new Vector<>();
	}
	/**
	 * Returns the project's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns all the project's packages
	 * @return packages
	 */
	public List<UMLPackage> getPackages() {
		return packages;
	}
}
