/**
 * 
 */
package org.mql.uml.parsers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.mql.uml.models.UMLClass;
import org.mql.uml.models.UMLInterface;
import org.mql.uml.models.UMLModel;
import org.mql.uml.utils.StringResolver;

/**
 * Parses a UMLModel (Class | Interface)
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class ModelParser {
	private UMLModel umlModel;
	
	public ModelParser(Class<?> clazz) {
		if(clazz.isInterface()) {
			umlModel = new UMLInterface(StringResolver.getShortFormOfType(clazz.getName()));
		} else {
			// Put here everything that is specific to class type
			umlModel = new UMLClass(StringResolver.getShortFormOfType(clazz.getName()));
			UMLClass actualUMLClass = (UMLClass) umlModel; // Hey JAVA, I know what I'm doing (Down-casting)
			for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
				actualUMLClass.addConstructor(constructor);
			}
		}
		for(Field field : clazz.getDeclaredFields()) {
			umlModel.addField(field);
		}
		for(Method method : clazz.getDeclaredMethods()) {
			umlModel.addMethod(method);
		}
	}

	public UMLModel getUMLModel() {
		return umlModel;
	}
}
