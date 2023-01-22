/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import org.codinmob.diagramgenerator.uml.enums.RelationType;

/**
 * This type represents the relationship between two future types
 * it contains two UMLModels (parent and child) the relationship type
 * and two cardinalities (parent's and child's).
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class Relationship {
	private UMLModel parent;
	private RelationType relationType;
	private UMLModel child;
	private String parentCardinality;
	private String childCardinality;
	
	@Override
	public String toString() {
		if(parentCardinality != null && childCardinality != null){
			return (child.getName() + "\"" + parentCardinality + "\"" + relationType.getSymbol() + "\"" + childCardinality + "\"" + parent.getName() + "\n\n");
		}
		return (child.getName() + relationType.getSymbol() + parent.getName() + "\n\n");
	}
}
