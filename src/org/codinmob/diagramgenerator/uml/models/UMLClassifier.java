/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public abstract class UMLClassifier {
	protected String name;
	protected List<UMLCharacteristic> characteristics;
	/*
	 * Derived attribute : calculated using the binary name (name)
	 * */
	public String getSimpleName() {
		return name.substring(name.lastIndexOf('.')+1);
	}
	
	public void addCharacteristic(UMLCharacteristic field) {
		if(field!=null)
			this.characteristics.add(field);
	}
	
	public UMLClassifier(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String temp = getSimpleName() + "\n";
		for(UMLCharacteristic characteristic : this.characteristics) {
			temp = temp + "********" + characteristic + "\n";
		}
		return temp;
	}
}
