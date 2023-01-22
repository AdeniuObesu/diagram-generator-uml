/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers.dom;

import java.io.File;

import org.codinmob.diagramgenerator.mappers.XMLNodeObjectMapper;
import org.codinmob.diagramgenerator.mappers.impl.XMLNodeObjectMapperImpl;
import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.parsers.Parser;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class DOMParser implements Parser{
	private XMLNode root;
	
	public DOMParser() {
		XMLNodeObjectMapper mapper = new XMLNodeObjectMapperImpl();
		root = mapper.objectToXMLNode(Project.getInstance(null));
	}
	
	public void generateXML() {
		root.generate();
	}
	
	@Override
	public Object parse(File file) {
		// TODO : (not necessary) Create a project instance from a valid document
		return null;
	}
	
}
