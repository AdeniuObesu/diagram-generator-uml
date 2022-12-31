/**
 * 
 */
package org.mql.uml.models;

import java.util.List;
import java.util.Vector;

/**
 * A model representing each provided class
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLClass {
	private String name;
	private List<UMLField> fields;
	private List<UMLMethod> methods;
	
	public UMLClass() {
		name = "";
		fields = new Vector<>();
		methods = new Vector<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UMLField> getFields() {
		return fields;
	}

	public void setFields(List<UMLField> fields) {
		this.fields = fields;
	}

	public List<UMLMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<UMLMethod> methods) {
		this.methods = methods;
	}
	
	@Override
	public String toString() {
		return "Class : " + name;
	}
}
