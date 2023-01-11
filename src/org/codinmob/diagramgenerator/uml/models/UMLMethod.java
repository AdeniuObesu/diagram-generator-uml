/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod extends UMLCharacteristic {
	private List<Parameter> parameters;
	private boolean isConstructor;
	
	public UMLMethod(Method method) {
		this.isConstructor = false;
		this.visibility = visibilityOf(method.getModifiers());
		this.name = method.getName();
		this.type = method.getReturnType().toString();
		this.parameters = new Vector<>();
		for(Parameter parameter : method.getParameters()) {
			parameters.add(parameter);
		}
	}
	
	public UMLMethod(Constructor<?> constructor) {
		this.isConstructor = true;
		this.visibility = visibilityOf(constructor.getModifiers());
		this.name = constructor.getName();
		type = ""; // A constructor has no return type
		parameters = new Vector<>();
		for(Parameter parameter : constructor.getParameters()) {
			parameters.add(parameter);
		}
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
		String temp = visibility.getSymbol() + " " + PathResolver.getShortFormOfType(name) +"(";
		for(int i=0; i<parameters.size(); i++) {
			temp = temp + parameters.get(i).getName() + ": ";
			temp = temp + PathResolver.getShortFormOfType(parameters.get(i).getType().toString());
			if(i!=parameters.size()-1)
				temp = temp + ", ";
		}
		temp = temp + ")";
		if( !this.isConstructor ) // Then add the return type
			temp = temp + " : " + PathResolver.getShortFormOfType(type);
		return temp;
	}
}
