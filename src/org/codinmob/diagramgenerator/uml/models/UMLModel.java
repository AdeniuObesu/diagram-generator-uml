/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;
import java.util.Vector;

/**
 * Represents future types, inherited by UMLClass and UMLInterface
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public abstract class UMLModel {
	protected String name;
	protected List<UMLCharacteristic> characteristics;
	
	public UMLModel(String name) {
		this.name = name;
		this.characteristics = new Vector<>();
	}
	
	/**
	 * Returns the UMLModel's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	

	public void addCharacteristic(UMLCharacteristic field) {
		if(field!=null)
			this.characteristics.add(field);
	}
	
	@Override
	public String toString() {
		String temp = getName() + "\n";
		for(UMLCharacteristic characteristic : this.characteristics) {
			temp = temp + "********" + characteristic + "\n";
		}
		return temp;
	}
}
