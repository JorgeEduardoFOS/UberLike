package com.unicamp.mc322.lab10;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Uber {
	private DecimalFormat df0 = new DecimalFormat("##.##");
	private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private static ArrayList<Driver> drivers = new ArrayList<Driver>();
	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static ArrayList<Voyage> voyages = new ArrayList<Voyage>();
	private static Uber uber;
	
	private Uber() {
		df0.setRoundingMode(RoundingMode.UP);
	}
	
	public static Uber getInstance() {
		if(uber == null) {
			uber = new Uber();
		}
		return uber;
	}
	public void addPassenger(String name, String cpf, String creditCard, int year, int month, int day) {
		if(cpf == "")
			System.out.println("CPF inválido.");
		else if(searchPassengerCPF(cpf) != null)
			System.out.println("CPF já cadastrado anteriormente. Nada a ser feito.");
		else
			passengers.add(new Passenger(name, cpf, creditCard, year, month, day));
	}
	public void addDriver(String name, String cpf, String creditCard, int year, int month, int day, String habilitation) {
		if(cpf == "")
			System.out.println("CPF inválido.");
		else if (habilitation == "")
			System.out.println("Habilitação inválida");
		else if(searchDriverDocuments(cpf, habilitation) != null)
			System.out.println("CPF ou habilitação já cadastrado anteriormente. Nada a ser feito.");
		else
			drivers.add(new Driver(name, cpf, creditCard, year, month, day, habilitation));
	}
	public void addVehicle(String licencePlate, int manufactureYear, String cpf) {
		if(searchLicencePlate(licencePlate) != null)
			System.out.println("Placa já cadastrada. Nada a ser feito");
		else {
			Vehicle carro = new Vehicle(licencePlate, manufactureYear);
			vehicles.add(carro);
			Driver driver = uber.searchDriverCPF(cpf);
			if(driver.searchLicencePlace(licencePlate) != null)
				System.out.println("Veículo já cadastrado anteriormente na frota do motorista.");
			else {
				driver.addVehicle(carro);
				carro.setOwner(driver);
			}
		}
	}
	public void addVehicle(String licencePlate, int manufactureYear, boolean vehicleClass, String cpf) {
		if(searchLicencePlate(licencePlate) != null)
			System.out.println("Placa já cadastrada. Nada a ser feito");
		else {
			Vehicle carro = new Vehicle(licencePlate, manufactureYear, vehicleClass);
			vehicles.add(carro);
			Driver driver = uber.searchDriverCPF(cpf);
			if(driver.searchLicencePlace(licencePlate) != null)
				System.out.println("Veículo já cadastrado anteriormente na frota do motorista.");
			else {
				driver.addVehicle(carro);
				carro.setOwner(driver);
			}
		}
	}
	/*public void addVehicle(String licencePlate, int manufactureYear, boolean vehicleClass, String habilitation) {
		if(searchLicencePlate(licencePlate) != null)
			System.out.println("Placa já cadastrada. Nada a ser feito");
		else {
			Vehicle carro = new Vehicle(licencePlate, manufactureYear, vehicleClass);
			vehicles.add(carro);
			Driver driver = uber.searchDriverHabilitation(habilitation);
			if(driver.searchLicencePlace(licencePlate) != null)
				System.out.println("Veículo já cadastrado anteriormente na frota do motorista.");
			else {
				driver.addVehicle(carro);
				carro.setOwner(driver);
			}
		}
	}*/
	public void setVoyage(Driver driver, Vehicle vehicle, Passenger passenger, Position depart, Position nextStop) {
		voyages.add(new Voyage(driver, vehicle, passenger, depart, nextStop));
	}
	public void setVoyage(String driverCPF, String licencePlate, String passengerCPF, Position depart, Position nextStop) {
		voyages.add(new Voyage(searchDriverCPF(driverCPF), searchLicencePlate(licencePlate),
				searchPassengerCPF(passengerCPF), depart, nextStop));
	}
	public Passenger searchPassengerCPF(String cpf) {
		//System.out.println("-----------");
		//System.out.println("Procurando usuário por CPF no cadastro.");
		for(Passenger user : passengers)
			if(user.getCPF().compareTo(cpf) == 0)
				return user;
		return null;
	}
	public Driver searchDriverDocuments(String cpf, String habilitation) {
		//System.out.println("-----------");
		//System.out.println("Procurando motorista por CPF e por habilitação no cadastro.");
		for(Driver user : drivers) {
			if(user.getCPF().compareTo(cpf) == 0)
				return user;
			if(user.getHabilitation().compareTo(habilitation) == 0)
				return user;
		}
		return null;
	}
	public Driver searchDriverCPF(String cpf) {
		//System.out.println("-----------");
		//System.out.println("Procurando motorista por CPF e por habilitação no cadastro.");
		for(Driver user : drivers)
			if(user.getCPF().compareTo(cpf) == 0)
				return user;
		return null;
	}
	public Driver searchDriverHabilitation(String habilitation) {
		//System.out.println("-----------");
		//System.out.println("Procurando motorista por CPF e por habilitação no cadastro.");
		for(Driver user : drivers)
			if(user.getHabilitation().compareTo(habilitation) == 0)
				return user;
		return null;
	}
	public Vehicle searchLicencePlate(String licencePlate) {
		//System.out.println("-----------");
		//System.out.println("Procurando veículo pela placa no cadastro.");
		for(Vehicle vehicle: vehicles)
			if(vehicle.getLicencePlate().compareTo(licencePlate) == 0)
				return vehicle;
		return null;
	}
	public void addPassenger(int voyageIndex, Passenger passenger) {
		voyages.get(voyageIndex).addPassenger(passenger);
	}
	public double getPrice(int i) {
		return voyages.get(i).getPrice();
	}
	public void addPoint(int voyage, Position point) {
		voyages.get(voyage).addPoint(point);
	}
	public void removePoint(int voyage, int point) {
		voyages.get(voyage).removePoint(point);
	}
	public void removePassenger(int voyage, Passenger passenger) {
		voyages.get(voyage).removePassenger(passenger);
	}
	public void showVoyage(int voyageIndex) {
		System.out.println("------------------");
		System.out.println("Sumário de viagem");
		Voyage voyage = voyages.get(voyageIndex);
		voyage.getPassengers();
		System.out.println("A viagem teve " + voyage.getStops() + " paradas.");
		System.out.println("A distância percorrida foi de: " + df0.format(voyage.getDistance()) + " metros.");
		System.out.println("A viagem foi conduzida pelo(a) motorista: " + voyage.getDriver().getName());
		System.out.println("O preço total da viagem foi de R$" + df0.format(voyage.getPrice()));
	}
	//////////////////////////
	//Área de testes
	//////////////////////////
	public static void main(String[] args) {
		uber = getInstance();
		uber.addDriver("Maria", "248679108", "483530", 1997, 2, 12, "987654");
		uber.addDriver("Ayrton Sena da Silva", "148.654.721-25", "843", 1971, 02, 23, "456987");
		uber.addPassenger("Marco", "145678798", "369874", 1998, 7, 15);
		uber.addPassenger("João", "654973652,", "785632", 2002, 3, 1);
		uber.addDriver("Joaquina", "248679108", "646465", 1978, 8, 22, "66855");
		uber.addPassenger("Rodrigo", "145678798", "369874", 1998, 7, 15);
	}
}