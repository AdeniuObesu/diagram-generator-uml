/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Vector;

/**
 * UMLClass represents future classes, it is a UMLModel
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLClass extends UMLModel {
	
	public UMLClass(String name) {
		super(name);
	}
	
	public List<UMLMethod> getConstructors(){
		List<UMLMethod> constructors = new Vector<>();
		for(UMLMethod method : methods)
			if(method.isConstructor())
				constructors.add(method);
		return constructors;
	}
	
	public void addConstructor(Constructor<?> constructor) {
		methods.add(new UMLMethod(constructor));
	}
	
	@Override
	public String toString() {
		String temp = "Class : " + super.toString();
		return temp;
	}
}
