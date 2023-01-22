/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public class UMLEnum extends UMLModel {
	
	public UMLEnum(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Enum : ");
		temp.append(super.toString());
		return temp.toString();
	}
}
