/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;
import java.util.logging.Logger;

import org.mql.uml.models.UMLModel;
import org.mql.uml.models.UMLPackage;
import org.mql.uml.utils.FileUtils;
import org.mql.uml.utils.StringResolver;
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
			thePackage.setRelativePath(
					StringResolver.convertPackagePathToRelative(thePackage.getAbsolutePath())
				);
			Parser parser = new ModelParser();
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
