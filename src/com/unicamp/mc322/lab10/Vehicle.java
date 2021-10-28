package com.unicamp.mc322.lab10;

public class Vehicle {
	public final static boolean COMMOM = false, LUX = true;
	private String licencePlate;
	private int manufactureYear;
	private boolean vehicleClass;
	private User owner;
	
	public Vehicle(String licencePlate, int manufactureYear) {
		this.licencePlate = licencePlate;
		this.manufactureYear = manufactureYear;
	}
	public Vehicle(String licencePlate, int manufactureYear, User owner) {
		this(licencePlate, manufactureYear);
		this.owner = owner;
	}
	public Vehicle(String licencePlate, int manufactureYear, boolean vehicleClass) {
		this(licencePlate, manufactureYear);
		this.vehicleClass = vehicleClass;
	}
	public Vehicle(String licencePlate, int manufactureYear, boolean vehicleClass, User owner) {
		this(licencePlate, manufactureYear, vehicleClass);
		this.owner = owner;
	}
	public void setOwner(Driver owner) {
		this.owner = owner;
	}
	public String getLicencePlate() {
		return licencePlate;
	}
	public int getManufactureYear() {
		return manufactureYear;
	}
	public User getOwner() {
		return owner;
	}
	public boolean getVehicleClass() {
		return vehicleClass;
	}
}
