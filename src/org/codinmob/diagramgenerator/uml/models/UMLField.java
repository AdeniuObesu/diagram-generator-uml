/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Field;

import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLField extends UMLCharacteristic {
	
	public UMLField(Field field) {
		this.visibility = visibilityOf(field.getModifiers());
		this.name = field.getName();
		this.type = field.getType().toString();
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		return visibility.getSymbol() + " " + name + " : " + PathResolver.getShortFormOfType(type);
	}
}
