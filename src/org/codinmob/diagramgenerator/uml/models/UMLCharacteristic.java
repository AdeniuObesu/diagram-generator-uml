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
	protected Class<?> type;
	protected boolean _static;
	protected boolean _final;
	
	public Visibility getVisibility() {
		return visibility;
	}
	
	public boolean isStatic() {
		return _static;
	}
	
	public boolean isFinal() {
		return _final;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<?> getType(){
		return (type != null ? type : null);
	}
	
	// derived attribute : calculated using type
	public String getSimpleType() {
		if(type!=null)
			return type.getSimpleName();
		return null;
	}
	
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
