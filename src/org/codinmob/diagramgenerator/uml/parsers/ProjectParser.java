/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLModel;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
import org.codinmob.diagramgenerator.uml.utils.FileUtils;
import org.codinmob.diagramgenerator.uml.utils.RelationDetector;

/**
 * Parses a project, finds all packages, classes and interfaces.
 * TODO : think of a way to parse annotations and enumerations
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class ProjectParser implements Parser {
	private final static Logger logger = Logger.getLogger(ProjectParser.class.getName());

	@Override
	public Object parse(File projectFolder) {
		if(FileUtils.isAValidProject(projectFolder)) {
			logger.info("Parsing the project : " + projectFolder.getAbsolutePath());
			Project project = Project.getInstance(projectFolder);
			// A special use case : Loading default-package if there is one
			Parser packageParser = new PackageParser();
			UMLPackage aPackage;
			if(FileUtils.isAValidPackage(projectFolder)) {
				aPackage = (UMLPackage) packageParser.parse(projectFolder);
				// But this package is the default package so :
				// TODO : make a way out
//				aPackage.setRelativePath("(default-package)");
				project.addPackage(aPackage);
			}
			// Start loading packages
			Set<File> packagesFolders = new HashSet<>();
			FileUtils.getAllPackages(projectFolder, packagesFolders);
			for(File item : packagesFolders) {
				aPackage = (UMLPackage) packageParser.parse(item);
				project.addPackage(aPackage);
			}
			logger.info("Detecting relations...");
			
			RelationDetector relationDetector;
			for (UMLModel parent : project.getModels()) {
				relationDetector = new RelationDetector();
				for (UMLModel child : project.getModels()) {				
					project.addRelations(relationDetector.parse(parent, child));
				}
			}
			
			logger.info("Relations detection end");
			return project;
		} else {
			logger.info(projectFolder.getAbsolutePath() + " is not a valid project !");
		}
		return null;
	}
}
