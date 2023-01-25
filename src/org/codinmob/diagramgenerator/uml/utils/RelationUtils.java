package org.codinmob.diagramgenerator.uml.utils;

import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.models.UMLParameter;

/**
 * @author MOUKHAFI Anass
 * @On Tuesday, January 24, 2023
 */
public class RelationUtils {

	public static boolean parameterInAtLeastOneConstructor(String parameterTypeName, UMLModel parent) {
		for (UMLCharacteristic member : parent.getCharacteristics()) {
			if (member instanceof UMLMethod) {
				UMLMethod method = (UMLMethod) member;
				if (RelationUtils.isConstructorParameter(parameterTypeName, method)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean isConstructorParameter(String parameterTypeName, UMLMethod method) {
		return isOperationParameter(parameterTypeName, method) && method.isConstructor();
	}
	
	public static boolean isMethodParameter(String parameterTypeName, UMLMethod method) {
		return isOperationParameter(parameterTypeName, method) && !method.isConstructor();
	}
	
	private static boolean isOperationParameter(String parameterTypeName, UMLMethod method) {
		for (UMLParameter param : method.getParameters()) {
			if (param.getType().equals(parameterTypeName))
				return true;
		}
		
		return false;
	}
	
	public static boolean isClassAttribute(UMLClass umlClass, UMLField attribute) {
		for (UMLCharacteristic characteristic : umlClass.getCharacteristics()) {
			if (characteristic instanceof UMLField) {
				UMLField field = (UMLField) characteristic;

				if (field.getType().contains(attribute.getType())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static boolean isFinalClassAttribute(UMLClass umlClass, UMLField attribute) {
		return (isClassAttribute(umlClass, attribute) && attribute.isFinal());
	}
	
	public static UMLField childInParentAttributes(UMLModel child, UMLModel parent) {
		for (UMLCharacteristic characteristic : parent.getCharacteristics()) {
			if (characteristic instanceof UMLField) {
				UMLField field = (UMLField) characteristic;
				if (field.getType().contains(child.getName()))
					return field;
			}
		}
		
		return null;
	}
}
