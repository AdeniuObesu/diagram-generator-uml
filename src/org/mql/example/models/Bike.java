/**
 * 
 */
package org.mql.example.models;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Bike extends Vehicle {
	private String exaustBrand;
	public Bike(String name) {
		super(name);
		exaustBrand = "SC Project";
	}
	
	public String getExaustBrand() {
		return exaustBrand;
	}
	public void setExaustBrand(String exaustBrand) {
		this.exaustBrand = exaustBrand;
	}

	@Override
	public String toString() {
		return "Bike [" + getName() + " makes a loud sound with its " + exaustBrand + " exaust]";
	}

	
}
