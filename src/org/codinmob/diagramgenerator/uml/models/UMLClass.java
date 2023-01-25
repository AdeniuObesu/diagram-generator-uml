/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;
import java.util.Vector;

/**
 * UMLClass represents future classes, it is a UMLModel
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLClass extends UMLModel {
	
	private List<String> implementedInterfacesNames;
	
	public UMLClass(String name) {
		super(name);
		implementedInterfacesNames = new Vector<>();
	}
	public void addImplementedInterface(String name){
		if(!"".equals(name))
			implementedInterfacesNames.add(name);
	}
	
	public List<String> getImplementedInterfaces(){
		return implementedInterfacesNames;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Class : ");
		temp.append(super.toString());
		return temp.toString();
	}
}
