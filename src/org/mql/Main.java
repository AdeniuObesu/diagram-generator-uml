package org.mql;

import org.mql.example.models.Bike;
import org.mql.example.models.Car;
import org.mql.example.models.Employee;
import org.mql.example.models.Student;
import org.mql.example.utils.Date;
import org.mql.uml.parsers.ClassParser;

public class Main {
	public Main() {
		exp01();
	}
	
	private void exp01() {
		new Student(123);
		new Employee(123);
		new Bike("Bitwin");
		new Car("Lambo");
		new Date(1, 1, 2023);
		
		try {
			ClassParser cp = new ClassParser(Class.forName("org.mql.example.models.Car"));
			System.out.println(cp.getUmlClass());
		} catch(Exception e) { }
	}
	
	private void test01() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
