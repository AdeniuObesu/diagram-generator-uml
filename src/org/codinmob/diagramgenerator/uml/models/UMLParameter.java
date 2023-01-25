/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * @author MOUKHAFI Anass
 * @On Tuesday, January 24, 2023
 */
public class UMLParameter {
	private String type;
	
	public UMLParameter(String type) {
		this.type = type;
	}
	
	public String getSimpleType() {
		return type;
		// return type.substring(type.lastIndexOf(".") + 1);
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
