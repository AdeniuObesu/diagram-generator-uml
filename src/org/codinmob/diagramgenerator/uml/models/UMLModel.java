/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * Represents future types, inherited by UMLClass and UMLInterface
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public abstract class UMLModel {
	protected String name;
	protected List<UMLCharacteristic> characteristics;
	
	public UMLModel(File file) {
		this.name = PathResolver.retrieveClassFileRelativePath(file.getAbsolutePath());
		this.characteristics = new Vector<>();
	}
	
	public List<UMLCharacteristic> getCharacteristics(){
		return characteristics;
	}
	
	/**
	 * Returns the UMLModel's binary name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the UMLModel's name
	 * @return calculated simple name
	 */
	public String getSimpleName() {
		String str = getName();
		return str.substring(str.lastIndexOf(".")+1);
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
