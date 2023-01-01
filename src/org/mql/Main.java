package org.mql;

import org.mql.uml.parsers.ProjectParser;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2023
 */
public class Main {
	public Main(String projectPath) {
		exp01(projectPath);
	}
	
	private void exp01(String arg0) {
		ProjectParser parser = new ProjectParser(arg0);
	}
	
	public static void main(String[] args) {
//		new Main(args[0]);
		// After we finish, we would like to be able to pass only the path of a project, the JAR application
		// will abstract the way things are done and generate what it is supposed to generate.
		new Main("C:/eclipse-workspace/p01-revision/bin");
	}
}
