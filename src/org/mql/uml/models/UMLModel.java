/**
 * 
 */
package org.mql.uml.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

/**
 * Represents future types, inherited by UMLClass and UMLInterface
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLModel {
	private String name;
	protected List<UMLField> fields;
	protected List<UMLMethod> methods;
	
	public UMLModel(String name) {
		this.name = name;
		fields = new Vector<>();
		methods = new Vector<>();
	}
	
	/**
	 * Returns the UMLModel's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	public List<UMLField> getFields() {
		return fields;
	}
	public List<UMLMethod> getMethods() {
		List<UMLMethod> meths = new Vector<>();
		for(UMLMethod method : methods)
			if( !method.isConstructor() )
				meths.add(method);
		return meths;
	}

	public void addField(Field field) {
		fields.add(new UMLField(field));
		
	}
	public void addMethod(Method method) {
		methods.add( new UMLMethod(method));
	}
	
	@Override
	public String toString() {
		String temp = getName() + "\n";
		//TODO : Resolve modifiers in case of synchronized fields|methods
		for(UMLField field : fields) {
			temp = temp + "********" + field + "\n";
		}
		for(UMLMethod method : methods) {
			temp = temp + "********" + method + "\n";
		}
		return temp;
	}
}
