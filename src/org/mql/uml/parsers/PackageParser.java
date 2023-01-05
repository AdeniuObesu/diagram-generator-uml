/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;
import java.util.logging.Logger;

import org.mql.uml.models.UMLPackage;
import org.mql.uml.utils.CustomLoader;
import org.mql.uml.utils.FileUtils;
import org.mql.uml.utils.StringResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class PackageParser {
	private static final Logger logger = Logger.getLogger(PackageParser.class.getName());
	private UMLPackage umlPackage;
	
	public PackageParser(String path) {
		logger.info("Parsing package : " + path);
		File packageFolder = new File(path);
		umlPackage = new UMLPackage(path);
		umlPackage.setName(StringResolver.getPackageName(umlPackage.getName()));
		String fileName;
		for(File item : packageFolder.listFiles()) {
			if(FileUtils.isClassFile(item.getAbsolutePath())) {
				// TODO : load the class
				ModelParser parser = new ModelParser(CustomLoader.load(item));
				umlPackage.addUMLModel(parser.getUMLModel());
			}
		}
	}
	
	public UMLPackage getUmlPackage() {
		return umlPackage;
	}
}
