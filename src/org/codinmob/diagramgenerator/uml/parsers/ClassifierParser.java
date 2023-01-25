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
import org.codinmob.diagramgenerator.uml.models.UMLClassifier;
import org.codinmob.diagramgenerator.uml.models.UMLConstant;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.utils.CustomClassLoader;
import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * Parses a UMLClassifier (Class | Interface | Enum)
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class ClassifierParser implements Parser {
	private static final Logger logger = Logger.getLogger(ClassifierParser.class.getName());

	@Override
	public Object parse(File file) {
		UMLClassifier classifier = null;
		Class<?> clazz = CustomClassLoader.loadClass(file);
		if(clazz != null && ! clazz.isAnnotation()) {
			String fileName = PathResolver.retrieveClassFileRelativePath(file.getAbsolutePath());
			logger.info("Parsing file : " + file.getName());
			if(clazz.isEnum()) {
				classifier = new UMLEnum(fileName);
			} else if(clazz.isInterface()){
				classifier = new UMLInterface(fileName);
			} else {
				classifier = new UMLClass(fileName);
				for (Class<?> interfaceClass : clazz.getInterfaces()) {
					((UMLClass) classifier).addImplementedInterface(interfaceClass.getName());
				}
			}
			if(!clazz.isEnum()) {
				((UMLModel)classifier).setMotherModelName(clazz.getSuperclass()==null ? "" : clazz.getSuperclass().getName());
				for(Field field : clazz.getDeclaredFields()) {
					classifier.addCharacteristic(new UMLField(field));
				}
				for(Method method : clazz.getDeclaredMethods()) {
					classifier.addCharacteristic(new UMLMethod(method));
				}
				if(!clazz.isInterface()) {
					for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
						classifier.addCharacteristic(new UMLMethod(constructor));
					}
				}
			} else {// We process an enum so we have to store its associated constants
				for(Object constant : clazz.getEnumConstants()) {
					classifier.addCharacteristic(new UMLConstant(constant.toString().toUpperCase()));
				}
			}
		}
		return classifier;
	}
}
