package com.unicamp.mc322.lab10;
import java.util.ArrayList;

public class Driver extends User{
	private String habilitation;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Driver(String name, String cpf, String creditCard, int year, int month, int day, String habilitation) {
		super(name, cpf, creditCard, year, month, day);
		this.habilitation = habilitation;
	}
	public String getHabilitation() {
		return habilitation;
	}
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}
	public Vehicle searchLicencePlace(String licencePlate) {
		//System.out.println("-----------");
		//System.out.println("Procurando usuário por CPF no cadastro.");
		for(Vehicle vehicle : vehicles)
			if(vehicle.getLicencePlate().compareTo(licencePlate) == 0)
				return vehicle;
		return null;
	}
}
