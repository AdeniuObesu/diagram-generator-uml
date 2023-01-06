/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.lang.reflect.Modifier;

import org.codinmob.diagramgenerator.uml.enums.Visibility;

/** Inherited by UMLField and UMLMethod
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public abstract class UMLCharacteristic {
	protected Visibility visibility;
	protected String name;
	protected String type;
	
	protected Visibility visibilityOf(int modifier) {
		String str = Modifier.toString(modifier);
		if(str.contains("public"))
			return Visibility.PUBLIC;
		else if(str.contains("private"))
			return Visibility.PRIVATE;
		else if(str.contains("protected"))
			return Visibility.PROTECTED;
		return Visibility.PACKAGE;
	}
}
