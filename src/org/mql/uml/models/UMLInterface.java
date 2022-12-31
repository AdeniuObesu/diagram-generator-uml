/**
 * 
 */
package org.mql.uml.models;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLInterface extends UMLModel {
	
	public UMLInterface(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		String temp = "Interface : " + super.toString();
		return temp;
	}
}
