/**
 * 
 */
package org.mql.uml.models;

import org.mql.uml.enums.Modifiers;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLField {
	private int modifier;
	private String name;
	private String type;
	private String initialValue; // if there is one
	
	public UMLField() { }
	
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
	public String getInitialValue() {
		return initialValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		String temp = Modifiers.valueOf(modifier) + name + " : " + type;
		if(initialValue != null)
			return temp.concat(" = " + initialValue);
		return temp;
	}
}
