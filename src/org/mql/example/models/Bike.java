/**
 * 
 */
package org.mql.example.models;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Bike extends Vehicle {
	private String exhaustBrand;
	public Bike(String name) {
		super(name);
		exhaustBrand = "SC Project";
	}
	
	public String getExhaustBrand() {
		return exhaustBrand;
	}
	public void setExhaustBrand(String exaustBrand) {
		this.exhaustBrand = exaustBrand;
	}

	@Override
	public String toString() {
		return "Bike [" + getName() + " makes a loud sound with its " + exhaustBrand + " exaust]";
	}	
}
