/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Vector;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public class UMLMethod extends UMLProperty {
	private List<UMLParameter> parameters;
	private boolean _constructor;
	
	public UMLMethod(Method method) {
		super(method.getName());
		this._constructor = false;
		this.visibility = visibilityOf(method.getModifiers());
		this.type = method.getGenericReturnType().getTypeName();
		this.parameters = new Vector<>();
		for(Parameter param : method.getParameters()) {
			parameters.add(new UMLParameter(param.getType().getName()));
		}
	}
	
	public List<UMLParameter> getParameters(){
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
		for(Parameter param : constructor.getParameters()) {
			parameters.add(new UMLParameter(param.getType().getName()));
		}
	}
	
	public void setParameters(List<UMLParameter> parameters) {
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
			temp.append(parameters.get(i).getType());
			if( i != parameters.size() - 1)
				temp.append(", ");
		}
		temp.append(")");
		if( ! this.isConstructor() ) // Then add the return type
			temp.append(" : " + type);
		return temp.toString();
	}
}
