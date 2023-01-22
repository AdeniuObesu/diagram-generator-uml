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
public abstract class UMLModel extends UMLClassifier{
	
	public UMLModel(String name) {
		super(name);
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
	
	@Override
	public String toString() {
		return super.toString();
	}
}
