/**
 * 
 */
package org.codinmob.diagramgenerator.mappers.impl;

import java.lang.reflect.Parameter;
import java.util.List;

import org.codinmob.diagramgenerator.mappers.DrawableObjectMapper;
import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLClassifier;
import org.codinmob.diagramgenerator.uml.models.UMLConstant;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
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
			JUMLPackage jUMLPackage = new JUMLPackage(actualObj.getName());
			for(UMLClassifier classifier : actualObj.getClassifiers()) {
				jUMLPackage.addJUMLClassifier(objectToDrawable(classifier));
			}
			drawable = jUMLPackage;
		} else if(obj instanceof UMLClass) {
			UMLClass actualObj = (UMLClass) obj;
			JUMLClass jUMLClass = new JUMLClass(actualObj.getSimpleName());
			for(UMLCharacteristic property : actualObj.getCharacteristics()) {
				jUMLClass.addJUMLProperty(objectToDrawable(property));
			}
			drawable = jUMLClass;
		} else if(obj instanceof UMLInterface) {
			UMLInterface actualObj = (UMLInterface) obj;
			JUMLInterface jUMLInterface = new JUMLInterface(actualObj.getSimpleName());
			for(UMLCharacteristic property : actualObj.getCharacteristics()) {
				jUMLInterface.addJUMLProperty(objectToDrawable(property));
			}
			drawable = jUMLInterface;
		} else if(obj instanceof UMLEnum) {
			UMLEnum actualObj = (UMLEnum) obj;
			JUMLEnum jUMLEnum = new JUMLEnum(actualObj.getSimpleName());
			for(UMLCharacteristic constant : actualObj.getCharacteristics()) {
				jUMLEnum.addJUMLConstant(objectToDrawable(constant));
			}
			drawable = jUMLEnum;
		} else if(obj instanceof UMLField) {
			UMLField actualObj = (UMLField) obj;
			JUMLField jUMLField = new JUMLField();
			StringBuffer temp = new StringBuffer(actualObj.getVisibility().getSymbol() + " ");
			temp.append(actualObj.getName() + " : " + actualObj.getSimpleType());
			jUMLField.setText(temp.toString());
			if(actualObj.isStatic()) jUMLField.underline();
			drawable = jUMLField;
		} else if(obj instanceof UMLMethod) {
			UMLMethod actualObj = (UMLMethod) obj;
			JUMLMethod jUMLMethod = new JUMLMethod();
			StringBuffer temp = new StringBuffer(actualObj.getVisibility().getSymbol() + " ");
			temp.append(actualObj.getName() + "(");
			List<Parameter> params = actualObj.getParameters();
			int i = params.size();
			for(Parameter param : params) {
				temp.append(param.getType().getSimpleName());
				if(i!=0) temp.append(", ");
			}
			temp.append(")");
			if(! actualObj.isConstructor() ) {
				temp.append(" : " + actualObj.getSimpleType());
			}
			jUMLMethod.setText(temp.toString());
			if(actualObj.isStatic()) jUMLMethod.underline();
			drawable = jUMLMethod;
		} else if(obj instanceof UMLConstant) {
			UMLConstant actualObj = (UMLConstant) obj;
			JUMLConstant jUMLConstant = new JUMLConstant();
			jUMLConstant.setText(actualObj.getName());
			drawable = jUMLConstant;
		}
		return drawable;
	}

}
