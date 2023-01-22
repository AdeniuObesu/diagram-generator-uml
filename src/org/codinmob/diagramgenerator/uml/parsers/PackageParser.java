/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers;

import java.io.File;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
import org.codinmob.diagramgenerator.uml.utils.FileUtils;
/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class PackageParser implements Parser {
	private static final Logger logger = Logger.getLogger(PackageParser.class.getName());
	
	@Override
	public Object parse(File packageFolder) {
		if(FileUtils.isAValidPackage(packageFolder)) {
			logger.info("Parsing package : " + packageFolder.getAbsolutePath());
			UMLPackage thePackage = new UMLPackage(packageFolder.getAbsolutePath());
			Parser parser = new ClassifierParser();
			for(File file : packageFolder.listFiles()) {
				if(FileUtils.isAValidClassFile(file)) {
					UMLModel aModel = (UMLModel) parser.parse(file);
					thePackage.addModel(aModel);
				}
			}
			return thePackage;
		}
		return null;
	}
}
