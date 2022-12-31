/**
 * 
 */
package org.mql.example.models;

import org.mql.example.enums.FuelType;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, December 31, 2022
 */
public class Car extends Vehicle {
	private FuelType fuelType;
	private int wheelsNumber;
	
	public Car(String name) {
		super(name);
		fuelType = FuelType.DIESEL_FUEL;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public int getWheelsNumber() {
		return wheelsNumber;
	}

	public void setWheelsNumber(int wheelsNumber) {
		this.wheelsNumber = wheelsNumber;
	}

	@Override
	public String toString() {
		return "Car [" + getName() + " uses " + fuelType + "]";
	}
	
	
}
