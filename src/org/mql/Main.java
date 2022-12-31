package org.mql;

import org.mql.uml.parsers.ClassParser;

public class Main {
	public Main() {
		exp01();
	}
	
	private void exp01() {
		try {
			ClassParser cp = new ClassParser(Class.forName("java.lang.Object"));
			System.out.println(cp.getUmlClass());
		} catch(Exception e) { }
	}
	
	private void test01() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
