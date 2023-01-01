package org.mql;

import org.mql.example.models.Bike;
import org.mql.example.models.Car;
import org.mql.example.models.Employee;
import org.mql.example.models.Student;
import org.mql.example.utils.Date;
import org.mql.uml.parsers.ModelParser;

public class Main {
	public Main() {
		exp01();
	}
	
	private void exp01() {
		// Provoke execution to create binaries to associated source files.
		new Student(123);
		new Employee(123);
		new Bike("Bitwin");
		new Car("Lambo");
		new Date(1, 1, 2023);
		
		try {
			ModelParser cp = new ModelParser(Class.forName("org.mql.example.behaviors.Noisy"));
			System.out.println(cp.getUMLModel());
		} catch(Exception e) { }
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
