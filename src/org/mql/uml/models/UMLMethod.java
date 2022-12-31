/**
 * 
 */
package org.mql.uml.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

import org.mql.uml.enums.Modifiers;
import org.mql.uml.utils.TypeResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod {
	private int modifier;
	private String name;
	private String returnType;
	private List<Parameter> parameters;
	private boolean isConstructor;
	
	public UMLMethod(Method method) {
		isConstructor = false;
		name = method.getName();
		returnType = TypeResolver.getShortTypeFormOf(method.getReturnType().toString());
		modifier = method.getModifiers();
		parameters = new Vector<>();
		for(Parameter parameter : method.getParameters()) {
			parameters.add(parameter);
		}
	}
	
	public UMLMethod(Constructor<?> constructor) {
		isConstructor = true;
		name = constructor.getName();
		returnType = null; // A constructor has no return type
		modifier = constructor.getModifiers();
		parameters = new Vector<>();
		for(Parameter parameter : constructor.getParameters()) {
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
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public boolean isConstructor() {
		return isConstructor;
	}
	public void setConstructor(boolean isConstructor) {
		this.isConstructor = isConstructor;
	}
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		String temp = Modifiers.valueOf(modifier) + " " + name+"(";
		for(int i=0; i<parameters.size(); i++) {
			temp = temp + parameters.get(i).getName() + ": ";
			temp = temp + TypeResolver.getShortTypeFormOf(parameters.get(i).getType().toString());
			if(i!=parameters.size()-1)
				temp = temp + ", ";
		}
		temp = temp + ")";
		if( !this.isConstructor ) // Then add the return type
			temp = temp + " : " + returnType;
		// TODO : We need our return types to be factored
		return temp;
	}
}
