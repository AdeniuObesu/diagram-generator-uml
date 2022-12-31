/**
 * 
 */
package org.mql.example.models;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Employee extends Person {
	private double salary;
	
	public Employee(int id) {
		super(id);
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [" + getFullName() + " gets paid " + salary + "USD]";
	}
}
