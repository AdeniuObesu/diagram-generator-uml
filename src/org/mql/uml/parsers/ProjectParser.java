/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.mql.uml.models.Project;
import org.mql.uml.models.UMLPackage;
import org.mql.uml.utils.FileUtils;

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
				aPackage.setRelativePath("(default-package)");
				project.addPackage(aPackage);
			}
			// Start loading packages
			Set<File> packagesFolders = new HashSet<>();
			FileUtils.getAllPackages(projectFolder, packagesFolders);
			for(File item : packagesFolders) {
				aPackage = (UMLPackage) packageParser.parse(item);
				project.addPackage(aPackage);
			}
			return project;
		} else {
			logger.info(projectFolder.getAbsolutePath() + " is not a valid project !");
		}
		return null;
	}
}
