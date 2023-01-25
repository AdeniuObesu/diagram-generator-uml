package org.codinmob.diagramgenerator.uml.models;

import org.codinmob.diagramgenerator.uml.enums.RelationType;

/**
 * @author MOUKHAFI Anass
 * @On Tuesday, January 24, 2023
 */
public class UMLRelation {
	private UMLModel child;
	private UMLModel parent;
	private RelationType type;

	public UMLRelation(UMLModel child, UMLModel parent, RelationType type) {
		super();
		this.child = child;
		this.parent = parent;
		this.type = type;
	}
	
	public UMLModel getChild() {
		return child;
	}
	
	public UMLModel getParent() {
		return parent;
	}
	
	public RelationType getType() {
		return type;
	}

	@Override
	public String toString() {
		return type + " : " + child.getName() + " " + type.getSymbol() + " " + parent.getName();
	}
}
