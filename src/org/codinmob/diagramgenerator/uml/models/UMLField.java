/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.codinmob.diagramgenerator.uml.utils.ReflectionUtils;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLField extends UMLProperty {
	
	private Multiplicity multiplicity;
	
	public boolean isMultiple() {
		return multiplicity.isMultiple();
	}
	
	public UMLField(Field field) {
		super(field.getName());
		this.visibility = visibilityOf(field.getModifiers());
		this.type = field.getType().getName();
		if(Modifier.toString(field.getModifiers()).contains("static")) {
			this._static = true;
		}
		if(Modifier.toString(field.getModifiers()).contains("final")) {
			this._final = true;
		}
		multiplicity = new Multiplicity();
		if (ReflectionUtils.isIterable((Field) field)) {
			multiplicity.setUpperBound('n');
		}
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		return visibility.getSymbol() + " " + name + " : " + type;
	}
}
