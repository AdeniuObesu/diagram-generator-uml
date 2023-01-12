/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.io.File;

/**
 * UMLClass represents future classes, it is a UMLModel
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLClass extends UMLModel {
	
	public UMLClass(File file) {
		super(file);
	}
	
	@Override
	public String toString() {
		String temp = "Class : " + super.toString();
		return temp;
	}
}
