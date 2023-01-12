/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.io.File;

/**
 * Represents future interfaces to parse and extends UMLModel
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLInterface extends UMLModel {
	
	public UMLInterface(File file) {
		super(file);
	}
	
	@Override
	public String toString() {
		String temp = "Interface : " + super.toString();
		return temp;
	}
}
