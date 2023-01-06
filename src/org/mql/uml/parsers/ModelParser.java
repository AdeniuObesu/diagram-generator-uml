/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.mql.uml.models.UMLClass;
import org.mql.uml.models.UMLEnum;
import org.mql.uml.models.UMLInterface;
import org.mql.uml.models.UMLModel;
import org.mql.uml.utils.CustomLoader;
import org.mql.uml.utils.StringResolver;

/**
 * Parses a UMLModel (Class | Interface)
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class ModelParser implements Parser {
	private static final Logger logger = Logger.getLogger(ModelParser.class.getName());

	@Override
	public Object parse(File file) {
		Class<?> clazz = CustomLoader.loadClass(file);
		if(clazz != null) {
			logger.info("Parsing file : " + file.getName());
			UMLModel model;
			if(clazz.isInterface()) {
				model = new UMLInterface(StringResolver.getShortFormOfType(clazz.getName()));
			} else {
				// Put here everything that is specific to class type
				if(clazz.isEnum()) {
					model = new UMLEnum(StringResolver.getShortFormOfType(clazz.getName()));
				} else {
					model = new UMLClass(StringResolver.getShortFormOfType(clazz.getName()));
					UMLClass actualUMLClass = (UMLClass) model; // Hey JAVA, I know what I'm doing (Down-casting)
					for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
						actualUMLClass.addConstructor(constructor);
					}
				}
			}
			for(Field field : clazz.getDeclaredFields()) {
				model.addField(field);
			}
			if(! clazz.isEnum() ) {
				for(Method method : clazz.getDeclaredMethods()) {
					model.addMethod(method);
				}
			}
			return model;
		}
		return null;
	}
}
