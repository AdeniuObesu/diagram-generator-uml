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
	protected String absolutePath;
	protected List<UMLCharacteristic> characteristics;
	
	public UMLModel(File file) {
		this.absolutePath = file.getAbsolutePath();
		this.characteristics = new Vector<>();
	}
	
	public List<UMLCharacteristic> getCharacteristics(){
		return characteristics;
	}
	
	/**
	 * Returns the UMLModel's relative path to the project's path
	 * @return calculated relativePath
	 */
	public String getRelativePath() {
		return PathResolver.retrieveClassFileRelativePath(this.absolutePath);
	}
	
	/**
	 * Returns the UMLModel's name
	 * @return calculated name
	 */
	public String getName() {
		String str = getRelativePath();
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
