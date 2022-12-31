/**
 * 
 */
package org.mql.uml.models;

import java.lang.reflect.Field;

import org.mql.uml.enums.Modifiers;
import org.mql.uml.utils.TypeResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLField {
	private int modifier;
	private String name;
	private String type;
	
	public UMLField(Field field) {
		modifier = field.getModifiers();
		name = field.getName();
		type = TypeResolver.getShortFormOfType(field.getType().toString());
	}

	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		return Modifiers.valueOf(modifier) + " " + name + " : " + type;
	}
}
