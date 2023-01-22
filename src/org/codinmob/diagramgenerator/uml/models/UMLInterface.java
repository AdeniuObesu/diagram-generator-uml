/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * Represents future interfaces to parse and extends UMLModel
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLInterface extends UMLModel {
	
	public UMLInterface(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Interface : ");
		temp.append(super.toString());
		return temp.toString();
	}
}
