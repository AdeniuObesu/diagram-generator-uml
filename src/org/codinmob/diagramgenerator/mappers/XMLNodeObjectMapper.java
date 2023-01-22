/**
 * 
 */
package org.codinmob.diagramgenerator.mappers;

import org.codinmob.diagramgenerator.uml.parsers.dom.XMLNode;

/** Responsible of mapping an object into the associated XMLNode
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public interface XMLNodeObjectMapper {
	XMLNode objectToXMLNode(Object obj);
}
