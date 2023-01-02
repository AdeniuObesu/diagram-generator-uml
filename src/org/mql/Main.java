package org.mql;

import org.mql.uml.parsers.ProjectParser;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class Main {
	public Main(String projectPath, String projectName) {
		exp01(projectPath, projectName);
	}
	
	private void exp01(String arg0, String args1) {
		ProjectParser parser = new ProjectParser(arg0, args1);
		System.out.println(parser.getProject());
	}
	
	public static void main(String[] args) {
//		new Main(args[0], args[1]);
		// After we finish, we would like to be able to pass only the path of a project and its name,
		// the JAR application will abstract the way things are done and generates what it is supposed to generate.
		new Main("C:/eclipse-workspace/", "p01-revision/bin");
	}
}
