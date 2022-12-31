/**
 * 
 */
package org.mql.uml.models;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

import org.mql.uml.enums.Modifiers;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod {
	private int modifier;
	private String name;
	private String returnType;
	private List<Parameter> parameters;
	
	public UMLMethod(Method method) {
		// TODO Think of a way to initialize a list of parameters
		name = method.getName();
		returnType = method.getReturnType().toString();
		modifier = method.getModifiers();
		parameters = new Vector<>();
		for(Parameter parameter : method.getParameters()) {
			parameters.add(parameter);
		}
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
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String type) {
		this.returnType = type;
	}
	
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		String temp = Modifiers.valueOf(modifier) + " " + name+"(";
		for(Parameter parameter : parameters) {
			temp = temp + parameter.getType() + " " + parameter.getName() + ", ";
		}
		temp = temp + ") : " + returnType;
		// TODO : We need our return types to be factored
		return temp;
	}
}
