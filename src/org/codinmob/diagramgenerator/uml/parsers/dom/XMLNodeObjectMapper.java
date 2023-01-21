/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers.dom;

import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class XMLNodeObjectMapper implements Mapper {

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
		}
		// TODO : process models, characteristics and relations
		return node;
	}
}
