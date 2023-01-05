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
	private List<UMLModel> umlModels;
	
	public UMLPackage(String name) {
		this.name = name;
		this.umlModels = new Vector<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addUMLModel(UMLModel anotherOne) {
		umlModels.add(anotherOne);
	}
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + name);
		for(UMLModel model : umlModels) {
			temp.append("\n\t" + model);
		}
		return temp.toString();
	}
}
