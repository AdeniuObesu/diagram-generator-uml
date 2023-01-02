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
public class UMLPackage {
	private String name;
	private List<UMLPackage> subPackages;
	private List<UMLModel> umlModels;
	
	public UMLPackage(String name) {
		this.name = name;
		subPackages = new Vector<>();
		umlModels = new Vector<>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<UMLPackage> getSubPackages() {
		return subPackages;
	}
	
	public List<UMLModel> getUmlModels() {
		return umlModels;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + name);
		for(UMLPackage item : subPackages) {
			temp.append(item);
		}
		for(UMLModel item : umlModels) {
			temp.append(item);
		}
		return temp.toString();
	}
}
