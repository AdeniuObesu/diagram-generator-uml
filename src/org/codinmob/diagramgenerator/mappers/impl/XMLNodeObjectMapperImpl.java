/**
 * 
 */
package org.codinmob.diagramgenerator.mappers.impl;

import java.lang.reflect.Parameter;

import org.codinmob.diagramgenerator.mappers.XMLNodeObjectMapper;
import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLClassifier;
import org.codinmob.diagramgenerator.uml.models.UMLEnum;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLInterface;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
import org.codinmob.diagramgenerator.uml.parsers.dom.XMLNode;
/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class XMLNodeObjectMapperImpl implements XMLNodeObjectMapper {

	@Override
	public XMLNode objectToXMLNode(Object obj) {
		XMLNode node = null;
		if(obj instanceof Project) {
			Project actualObj = (Project) obj;
			node = new XMLNode("project", 1);
			node.setAttribute("path", actualObj.getPath());
			node.setAttribute("name", actualObj.getName());
			XMLNode packagesNode = new XMLNode("packages", 1);
			node.appendChild(packagesNode);
			for(UMLPackage aPackage : actualObj.getPackages()) {
				packagesNode.appendChild(objectToXMLNode(aPackage));
			}
		} else if(obj instanceof UMLPackage) {
			UMLPackage actualObj = (UMLPackage) obj;
			node = new XMLNode("package", 1);
			node.setAttribute("name", actualObj.getName());
			XMLNode modelsNode = new XMLNode("models", 1);
			for(UMLClassifier classifier : actualObj.getClassifiers()) {
				modelsNode.appendChild(objectToXMLNode(classifier));
			}
			node.appendChild(modelsNode);
		} else if(obj instanceof UMLClass) {
			UMLClass actualObj = (UMLClass) obj;
			node = new XMLNode("class", 1);
			node.setAttribute("name", actualObj.getName());
			XMLNode characteristicsNode = new XMLNode("characteristics", 1);
			for(UMLCharacteristic aCharacteristic : actualObj.getCharacteristics()) {
				characteristicsNode.appendChild(objectToXMLNode(aCharacteristic));
			}
			node.appendChild(characteristicsNode);
		} else if(obj instanceof UMLInterface) {
			UMLInterface actualObj = (UMLInterface) obj;
			node = new XMLNode("interface", 1);
			node.setAttribute("name", actualObj.getName());
			
		} else if(obj instanceof UMLEnum) {
			UMLEnum actualObj = (UMLEnum) obj;
			node = new XMLNode("enumeration", 1);
			node.setAttribute("name", actualObj.getName());
		} else if (obj instanceof UMLField) {
			UMLField actualObj = (UMLField) obj;
			node = new XMLNode("field", 1);
			node.setAttribute("visibility", actualObj.getVisibility().toString().toLowerCase());
			node.setAttribute("static", String.valueOf(actualObj.isStatic()));
			node.setAttribute("final", String.valueOf(actualObj.isFinal()));
			node.setAttribute("declaration-type", actualObj.getType());
			node.setAttribute("name", actualObj.getName());
		} else if(obj instanceof UMLMethod) {
			UMLMethod actualObj = (UMLMethod) obj;
			if(actualObj.isConstructor()) {
				node = new XMLNode("constructor", 1);
			} else {
				node = new XMLNode("method", 1);
			}
			node.setAttribute("visibility", actualObj.getVisibility().toString().toLowerCase());
			if(!actualObj.isConstructor()) {
				node.setAttribute("static", String.valueOf(actualObj.isStatic()));
				node.setAttribute("final", String.valueOf(actualObj.isFinal()));
				node.setAttribute("return-type", actualObj.getType());
			}
			node.setAttribute("name", actualObj.getName());
			if(actualObj.getParameters().size() > 0) {
				XMLNode paramsNode = new XMLNode("parameters", 1);
//				for(Parameter param : actualObj.getParameters()) {
//					paramsNode.appendChild(objectToXMLNode(param));
//				} TODO : add params
				node.appendChild(paramsNode);
			}
		} else if(obj instanceof Parameter) {
			Parameter actualObj = (Parameter) obj;
			node = new XMLNode("parameter", 1);
			node.setAttribute("type", actualObj.getType().getTypeName());
		}
		// TODO : process relations
		return node;
	}
}
