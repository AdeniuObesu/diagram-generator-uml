/**
 * 
 */
package org.mql.uml.models;

import java.lang.reflect.Method;
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
	private boolean isInterface; 
	
	public UMLClass() {
		name = "";
		isInterface = false;
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
	public boolean isInterface() {
		return isInterface;
	}
	public void setInterface(boolean isInterface) {
		this.isInterface = isInterface;
	}

	public void addMethod(Method method) {
		methods.add( new UMLMethod(method));
	}
	
	@Override
	public String toString() {
		String temp = "Class : " + name + "\n";
		for(UMLField field : fields) {
			temp = "\t" + temp + field + "\n";
		}
		for(UMLMethod method : methods) {
			temp = "\t" + temp + method + "\n";
		}
		return temp;
	}

}
