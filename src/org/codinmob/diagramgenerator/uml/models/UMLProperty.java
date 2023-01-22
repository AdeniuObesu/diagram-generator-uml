/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import org.codinmob.diagramgenerator.uml.enums.Visibility;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public abstract class UMLProperty extends UMLCharacteristic {
	protected Visibility visibility;
	protected Class<?> type;
	protected boolean _static;
	protected boolean _final;
	// derived attribute : calculated using type
	public String getSimpleType() {
		if(type!=null)
			return type.getSimpleName();
		return null;
	}
	public UMLProperty(String name) {
		super(name);
	}
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
}
