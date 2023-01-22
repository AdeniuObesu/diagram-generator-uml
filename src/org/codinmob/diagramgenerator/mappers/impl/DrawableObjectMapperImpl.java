/**
 * 
 */
package org.codinmob.diagramgenerator.mappers.impl;

import org.codinmob.diagramgenerator.mappers.DrawableObjectMapper;
import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLConstant;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
import org.codinmob.diagramgenerator.uml.ui.swing.Drawable;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class DrawableObjectMapperImpl implements DrawableObjectMapper {

	@Override
	public Drawable objectToDrawable(Object obj) {
		Drawable toReturn = null;
		if(obj instanceof Project) {
			Project actualObj = (Project) obj;
			// TODO : process project instance
		} else if(obj instanceof UMLPackage) {
			UMLPackage actualObj = (UMLPackage) obj;
			// TODO : process umlPackage instance
		} else if(obj instanceof UMLClass) {
			UMLClass actualObj = (UMLClass) obj;
			// TODO : process umlClass instance
		} else if(obj instanceof UMLInterface) {
			UMLInterface actualObj = (UMLInterface) obj;
			// TODO : process umlInterface instance
		} else if(obj instanceof UMLEnum) {
			UMLEnum actualObj = (UMLEnum) obj;
			// TODO : process umlEnum instance
		} else if(obj instanceof UMLField) {
			UMLField actualObj = (UMLField) obj;
			// TODO : process umlField instance
		} else if(obj instanceof UMLMethod) {
			UMLMethod actualObj = (UMLMethod) obj;
			// TODO : process umlMethod instance
		} else if(obj instanceof UMLConstant) {
			UMLConstant actualObj = (UMLConstant) obj;
			// TODO : process umlConstant instance
		}
		return toReturn;
	}

}
