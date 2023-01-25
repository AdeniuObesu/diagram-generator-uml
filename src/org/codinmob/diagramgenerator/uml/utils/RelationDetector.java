package org.codinmob.diagramgenerator.uml.utils;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.enums.RelationType;
import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.models.UMLRelation;

/**
 * @author MOUKHAFI Anass
 * @On Tuesday, January 24, 2023
 */
public class RelationDetector {
	private static Logger logger = Logger.getLogger(RelationDetector.class.getName());
	
	public List<UMLRelation> parse(UMLModel child, UMLModel parent) {

		if (child != null && parent != null) {
			List<UMLRelation> relations = new Vector<>();
			
			if (!child.equals(parent)) {
				UMLRelation dependency = detectDependency(child, parent);
				if (dependency != null) {
					logRelation("dependency", child, parent);
					relations.add(dependency);
				}
				
				UMLRelation association = detectAssociation(child, parent);
				if (association != null) {
					logRelation("association", child, parent);
					relations.remove(dependency);
					relations.add(association);
				}
				
				UMLRelation aggregation = null;
				if (association != null) {
					aggregation = detectAggregation(child, parent);
					if (aggregation != null) {
						logRelation("aggregation", child, parent);
						relations.remove(association);
						relations.add(aggregation);
					}					
				}
				
				UMLRelation composition = detectComposition(child, parent);
				if (composition != null) {
					logRelation("composition", child, parent);
					relations.remove(aggregation);
					relations.add(composition);
				}
				
				UMLRelation realization = detectRealization(child, parent);
				if (realization != null) {
					logRelation("realization", child, parent);
					relations.add(realization);
				}
				
				UMLRelation generalization = detectGeneralization(child, parent);
				if (generalization != null) {
					logRelation("generalization", child, parent);
					relations.add(generalization);
				}
			}
			
			return relations;
		}
		
		return null;
	}
	
	private UMLRelation detectDependency(UMLModel child, UMLModel parent) {
		UMLRelation dependency = null;
		
		for (UMLCharacteristic member : parent.getCharacteristics()) {
			if (member instanceof UMLMethod) {
				UMLMethod operation = (UMLMethod) member;
				if (RelationUtils.isMethodParameter(child.getName(), operation)) {
					dependency = new UMLRelation(child, parent, RelationType.DEPENDENCY);
				}
			}
		}
		
		return dependency;
	}
	
	private UMLRelation detectAssociation(UMLModel child, UMLModel parent) {		
		if (child instanceof UMLClass && parent instanceof UMLClass) {
			if (RelationUtils.childInParentAttributes(child, parent) != null) {
				return new UMLRelation(child, parent, RelationType.ASSOCIATION);
			}
		}
		
		return null;
	}
	
	private UMLRelation detectAggregation(UMLModel child, UMLModel parent) {
		if (child instanceof UMLClass && parent instanceof UMLClass) {	
			UMLField field = RelationUtils.childInParentAttributes(child, parent);
			
			if (field != null && field.isMultiple()) {
				if (RelationUtils.parameterInAtLeastOneConstructor(field.getType(), parent)) {
					return new UMLRelation(child, parent, RelationType.AGGREGATION);
				}
			}
		}
		
		return null;
	}
	
	private UMLRelation detectComposition(UMLModel child, UMLModel parent) {				
		if (child instanceof UMLClass && parent instanceof UMLClass) {
			
			// inner class
			if (child.getName().contains(parent.getName())) {
				return new UMLRelation(child, parent, RelationType.COMPOSITION);
			}
			else {
				UMLField field = RelationUtils.childInParentAttributes(child, parent);
				
				if (field != null && field.isMultiple() && field.isFinal()) {
					if (RelationUtils.parameterInAtLeastOneConstructor(field.getType(), parent)) {
						return new UMLRelation(child, parent, RelationType.COMPOSITION);
					}
				}
			}
		}
		
		return null;
	}
	
	private UMLRelation detectRealization(UMLModel child, UMLModel parent) {		
		if (child instanceof UMLClass && parent instanceof UMLInterface) {
			UMLClass clazz = (UMLClass) child;
			if (clazz.getImplementedInterfaces().contains(parent.getName())) {
				return new UMLRelation(child, parent, RelationType.REALIZATION);
			}
		}
		
		return null;
	}
	
	private UMLRelation detectGeneralization(UMLModel child, UMLModel parent) {		
		if (child.getMotherModelName().equals(parent.getName())) {
			return new UMLRelation(child, parent, RelationType.GENERALIZATION);
		}
		
		return null;
	}
	
	private void logRelation(String relation, UMLModel child, UMLModel parent) {
		logger.info("Found " + relation + " between " + child.getSimpleName() + " and " + parent.getSimpleName());
	}
}
 