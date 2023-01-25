/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;
import java.util.Vector;

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
	
	public String getName() {
		return name;
	}
	
	public void addCharacteristic(UMLCharacteristic field) {
		if(field!=null)
			this.characteristics.add(field);
	}
	
	public List<UMLCharacteristic> getUmlCharacteristics(){
		return characteristics;
	}
	
	public UMLClassifier(String name) {
		this.name = name;
		characteristics = new Vector<>();
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
