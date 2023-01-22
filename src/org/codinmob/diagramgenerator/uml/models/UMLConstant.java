/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class UMLConstant extends UMLCharacteristic {
	
	public UMLConstant(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer(name);
		return temp.toString();
	}
}
