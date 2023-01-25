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
	private XMLNodeObjectMapper mapper;
	private XMLNode root;
	
	public DOMParser() {
		mapper = new XMLNodeObjectMapperImpl();
		root = mapper.objectToXMLNode(Project.getInstance(null));
	}
	
	public void generateXML(String outFolderPath) {
		root.generate(outFolderPath);
	}
	
	@Override
	public Object parse(File file) {
		// TODO : Create a project instance from a valid document
		return null;
	}
	
}
