/**
 * 
 */
package org.mql.example.models;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Vehicle {
	private String name;
	private String brand;
	private String model;
	private double price;
	
	public Vehicle(String name) { this.name = name; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", costs " + price + "USD]";
	}
	
	
}
