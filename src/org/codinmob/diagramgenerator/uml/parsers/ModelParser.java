/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.utils.CustomLoader;
import org.codinmob.diagramgenerator.uml.utils.PathResolver;

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
				model = new UMLInterface(PathResolver.getShortFormOfType(clazz.getName()));
			} else {
				// Put here everything that is specific to class type
				if(clazz.isEnum()) {
					model = new UMLEnum(PathResolver.getShortFormOfType(clazz.getName()));
				} else {
					model = new UMLClass(PathResolver.getShortFormOfType(clazz.getName()));
					UMLClass actualUMLClass = (UMLClass) model; // Hey JAVA, I know what I'm doing (Down-casting)
					for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
						actualUMLClass.addCharacteristic(new UMLMethod(constructor));
					}
				}
			}
			// TODO: Test whether a model is an enum and load declared constants
			for(Field field : clazz.getDeclaredFields()) {
				model.addCharacteristic(new UMLField(field));
			}
			if(! clazz.isEnum() ) {
				for(Method method : clazz.getDeclaredMethods()) {
					model.addCharacteristic(new UMLMethod(method));
				}
			}
			return model;
		}
		return null;
	}
}
