/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLField extends UMLCharacteristic {
	
	public UMLField(Field field) {
		this.visibility = visibilityOf(field.getModifiers());
		this.name = field.getName();
		this.type = field.getType();
		if(Modifier.toString(field.getModifiers()).contains("static")) {
			this._static = true;
		}
		if(Modifier.toString(field.getModifiers()).contains("final")) {
			this._final = true;
		}
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		return visibility.getSymbol() + " " + name + " : " + type.getSimpleName();
	}
}
