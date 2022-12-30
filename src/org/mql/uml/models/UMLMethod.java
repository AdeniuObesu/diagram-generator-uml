/**
 * 
 */
package org.mql.uml.models;

import org.mql.uml.enums.Modifiers;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod {
	private int modifier;
	private String name;
	private String type;
	
	public UMLMethod() {
		// TODO Think of a way to initialize a list of parameters
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
		String temp = Modifiers.valueOf(modifier) + name + " : " + type;
		// TODO : add parameters to the representation
		return temp;
	}
}
