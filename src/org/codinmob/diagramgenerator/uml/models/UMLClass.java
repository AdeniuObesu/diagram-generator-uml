/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * UMLClass represents future classes, it is a UMLModel
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLClass extends UMLModel {
	
	public UMLClass(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Class : ");
		temp.append(super.toString());
		return temp.toString();
	}
}
