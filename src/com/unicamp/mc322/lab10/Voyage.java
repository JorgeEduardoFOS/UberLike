package com.unicamp.mc322.lab10;
import java.util.ArrayList;

public class Voyage {
	public static double FIXED_PRICE_COMMON = 3.00, FIXED_PRICE_LUX = 7.00;
	public static double DISTANCE_COMMON_PRICE = 0.02, DISTANCE_LUX_PRICE = 0.035;
	public static double COMMON_STOP_PRICE = 1.50, LUX_STOP_PRICE = 2.70;
	private Driver driver;
	private ArrayList<Passenger> actualPassengers = new ArrayList<Passenger>();
	private ArrayList<Passenger> totalPassengers = new ArrayList<Passenger>();
	private ArrayList<Position> pontos = new ArrayList<Position>();
	private Vehicle vehicle;
	//private double distance;
	
	public Voyage(Driver driver, Vehicle vehicle, Passenger passenger, Position depart, Position nextStop) {
		this.driver = driver;
		this.vehicle = vehicle;
		actualPassengers.add(passenger);
		totalPassengers.add(passenger);
		pontos.add(depart);
		pontos.add(nextStop);
	}
	public void addPoint(Position point) {
		pontos.add(point);
	}
	public void removePoint(Position point) {
		if(pontos.size() < 3)
			System.out.println("Não é possível remover pontos. Adicione outro ponto antes.");
		else
			pontos.remove(point);
	}
	public void removePoint(int i) {
		if(pontos.size() < 3)
			System.out.println("Não é possível remover pontos. Adicione outro ponto antes.");
		else
			pontos.remove(i-1);
	}
	public Driver getDriver() {
		return driver;
	}
	public double getDistance() {
		int i = 0;
		double distance = 0;
		while(i < (pontos.size() - 1)) {
			distance += Math.sqrt((Math.pow(pontos.get(i).getX() - pontos.get(i +1).getX(), 2)
					+ Math.pow(pontos.get(i).getY() - pontos.get(i + 1).getY(), 2)));
			++i;
		}
		return distance;
	}
	public double getPrice() {
		if(!vehicle.getVehicleClass()) {
			return FIXED_PRICE_COMMON + getDistance() * DISTANCE_COMMON_PRICE + (pontos.size() - 1) * COMMON_STOP_PRICE;
		}
		else {
			return FIXED_PRICE_LUX + getDistance() * DISTANCE_LUX_PRICE + (pontos.size() - 1) * LUX_STOP_PRICE;
		}
	}
	public void addPassenger(Passenger passenger) {
		if(actualPassengers.size() > 2)
			System.out.println("Número de passageiros ecedido. Nada a ser feito.");
		else {
			actualPassengers.add(passenger);
			totalPassengers.add(passenger);
		}		
	}
	public int getStops() {
		return pontos.size() - 1;
	}
	public void removePassenger(Passenger passenger) {
		if(actualPassengers.size() < 2)
			System.out.println("O carro já está com o número mínimo de passageiros da viagem. Nada a ser feito.");
		else
			actualPassengers.remove(passenger);
	}
	public void getPassengers() {
		if(totalPassengers.size() <= 0)
			System.out.println("Acorreu algum erro no sistema.");
		else {
			System.out.println("A viagem contou com os passageiros:");
			for(Passenger passenger : totalPassengers)
				System.out.println(passenger.getName());
		}
	}
}
