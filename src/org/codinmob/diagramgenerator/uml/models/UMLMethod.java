/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod extends UMLProperty {
	private List<Parameter> parameters;
	private boolean _constructor;
	
	public UMLMethod(Method method) {
		super(method.getName());
		this._constructor = false;
		this.visibility = visibilityOf(method.getModifiers());
		this.type = method.getReturnType();
		this.parameters = new Vector<>();
		for(Parameter parameter : method.getParameters()) {
			parameters.add(parameter);
		}
		if(Modifier.toString(method.getModifiers()).contains("static")) {
			this._static = true;
		}
		if(Modifier.toString(method.getModifiers()).contains("final")) {
			this._final = true;
		}
	}
	
	public List<Parameter> getParameters(){
		return parameters;
	}
	
	public UMLMethod(Constructor<?> constructor) {
		super((constructor.getName().contains(".") ?
				constructor.getName().substring(constructor.getName().lastIndexOf(".")+1)
				: constructor.getName()));
		this._constructor = true;
		this.visibility = visibilityOf(constructor.getModifiers());
		this.type = null; // A constructor has no return type
		parameters = new Vector<>();
		for(Parameter parameter : constructor.getParameters()) {
			parameters.add(parameter);
		}
	}
	
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public boolean isConstructor() {
		return _constructor;
	}
	/**
	 * Returns grammar for UML Class diagram
	 * */
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer(visibility.getSymbol() + " " + name +"(");
		for(int i=0; i<parameters.size(); i++) {
			temp.append(parameters.get(i).getType().getSimpleName());
			if( i != parameters.size() - 1)
				temp.append(", ");
		}
		temp.append(")");
		if( ! this.isConstructor() ) // Then add the return type
			temp.append(" : " + type.getSimpleName());
		return temp.toString();
	}
}
