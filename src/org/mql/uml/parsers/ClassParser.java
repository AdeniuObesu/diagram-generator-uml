/**
 * 
 */
package org.mql.uml.parsers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.mql.uml.models.UMLClass;
import org.mql.uml.utils.TypeResolver;

/**
 * Converts a class to a UMLClass
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class ClassParser {
	private UMLClass umlClass;
	
	public ClassParser(Class<?> clazz) {
		umlClass = new UMLClass();
		umlClass.setName(TypeResolver.getShortTypeFormOf(clazz.getName()));
		if(clazz.isInterface()) {
			umlClass.setInterface(true);
		}
		for(Field field : clazz.getDeclaredFields()) {
			umlClass.addField(field);
		}
		for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			umlClass.addConstructor(constructor);
		}
		for(Method method : clazz.getDeclaredMethods()) {
			umlClass.addMethod(method);
		}
	}

	public UMLClass getUmlClass() {
		return umlClass;
	}
	public void setUmlClass(UMLClass umlClass) {
		this.umlClass = umlClass;
	}
}
