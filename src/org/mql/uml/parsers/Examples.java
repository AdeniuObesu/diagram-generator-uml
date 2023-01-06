/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;

import org.mql.uml.models.Project;

/**
 * Tests neighbor classes (classes in the same package)
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public class Examples {
	private static final String folderName = "C:\\eclipse-workspace\\diagram-generator-uml\\bin\\";
	
	public Examples() {
		testProjectParsing();
	}
	
	public static void main(String[] args) {
		new Examples();
	}

	/*---------------Project parser class-----------------*/
	private void testProjectParsing(){
		Parser parser = new ProjectParser();
		Project project = (Project) parser.parse(new File(folderName));
		if(project != null) {
			System.out.println(project);
		} else System.out.println("Project instance is not created !");
	}
	
}
