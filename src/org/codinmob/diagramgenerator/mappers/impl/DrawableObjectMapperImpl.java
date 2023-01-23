/**
 * 
 */
package org.codinmob.diagramgenerator.mappers.impl;

import org.codinmob.diagramgenerator.mappers.DrawableObjectMapper;
import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLClassifier;
import org.codinmob.diagramgenerator.uml.models.UMLConstant;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
import org.codinmob.diagramgenerator.uml.ui.swing.Drawable;
import org.codinmob.diagramgenerator.uml.ui.swing.JProject;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLClass;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLConstant;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLEnum;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLField;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLInterface;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLMethod;
import org.codinmob.diagramgenerator.uml.ui.swing.JUMLPackage;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class DrawableObjectMapperImpl implements DrawableObjectMapper {

	@Override
	public Drawable objectToDrawable(Object obj) {
		Drawable drawable = null;
		if(obj instanceof Project) {
			Project actualObj = (Project) obj;
			JProject jProject = new JProject();
			for(UMLPackage aPackage : actualObj.getPackages()) {
				jProject.addJUMLPackage(objectToDrawable(aPackage));
			}
			drawable = jProject;
		} else if(obj instanceof UMLPackage) {
			UMLPackage actualObj = (UMLPackage) obj;
			JUMLPackage jUMLPackage = new JUMLPackage();
			for(UMLClassifier classifier : actualObj.getClassifiers()) {
				jUMLPackage.addJUMLClassifier(objectToDrawable(classifier));
			}
			drawable = jUMLPackage;
		} else if(obj instanceof UMLClass) {
			UMLClass actualObj = (UMLClass) obj;
			JUMLClass jUMLClass = new JUMLClass();
			// TODO : process umlClass instance
			drawable = jUMLClass;
		} else if(obj instanceof UMLInterface) {
			UMLInterface actualObj = (UMLInterface) obj;
			JUMLInterface jUMLInterface = new JUMLInterface();
			// TODO : process umlInterface instance
			drawable = jUMLInterface;
		} else if(obj instanceof UMLEnum) {
			UMLEnum actualObj = (UMLEnum) obj;
			JUMLEnum jUMLEnum = new JUMLEnum();
			// TODO : process umlEnum instance
			drawable = jUMLEnum;
		} else if(obj instanceof UMLField) {
			UMLField actualObj = (UMLField) obj;
			JUMLField jUMLField = new JUMLField();
			// TODO : process umlField instance
			drawable = jUMLField;
		} else if(obj instanceof UMLMethod) {
			UMLMethod actualObj = (UMLMethod) obj;
			JUMLMethod jUMLMethod = new JUMLMethod();
			// TODO : process umlMethod instance
			drawable = jUMLMethod;
		} else if(obj instanceof UMLConstant) {
			UMLConstant actualObj = (UMLConstant) obj;
			JUMLConstant jUMLConstant = new JUMLConstant();
			// TODO : process umlConstant instance
			drawable = jUMLConstant;
		}
		return drawable;
	}

}
