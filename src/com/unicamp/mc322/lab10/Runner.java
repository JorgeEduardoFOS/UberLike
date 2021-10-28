package com.unicamp.mc322.lab10;

public class Runner {
	public static void main(String[] args) {
		Uber uber = Uber.getInstance();
		uber.addPassenger("Marco", "145678798", "369874", 1998, 7, 15);
		uber.addDriver("Maria", "248679108", "483530", 1997, 2, 12, "987654");
		uber.addPassenger("João", "654973652", "785632", 2002, 3, 1);
		uber.addDriver("Ayrton Sena da Silva", "148.654.721-25", "843", 1971, 02, 23, "456987");
		uber.addDriver("Joaquina", "248679108", "646465", 1978, 8, 22, "66855");//CPF repetido
		uber.addPassenger("Rodrigo", "145678798", "369874", 1998, 7, 15);//CPF repetido
		uber.addDriver("Jaime", "288.546.843-28", "993530", 1997, 2, 12, "987654");//habilitação repetida
		uber.addPassenger("Rodrigo", "", "369874", 1998, 7, 15);//CPF = ""
		uber.addDriver("Jaime", "", "993530", 1997, 2, 12, "387654");//CPF = ""
		uber.addDriver("Jaime", "288.546.843-28", "993530", 1997, 2, 12, "");//habilitação = ""
		uber.addVehicle("OOP2020", 2013, "248679108");//placa repetida
		uber.addVehicle("ABC1234", 2009, Vehicle.LUX, "248679108");//placa repetida
		uber.addVehicle("ABC1234", 2009, Vehicle.LUX, "148.654.721-25");
		uber.addVehicle("OOP2020", 2013, "248679108");
		uber.setVoyage("248679108", "ABC1234", "145678798", new Position(0.0, 0.0), new Position(0.0, 300.0));//método 1
		uber.addPoint(0, new Position(200.0, 300.0));
		uber.showVoyage(0);
		uber.setVoyage(uber.searchDriverCPF("248679108"), uber.searchLicencePlate("OOP2020"),
				uber.searchPassengerCPF("145678798"), new Position(0.0, 0.0), new Position(400.0, 0.0));//método 2
		uber.addPassenger(1, uber.searchPassengerCPF("654973652"));
		uber.addPoint(1, new Position(400.0, 400.0));
		uber.addPoint(1, new Position(0.0, 400.0));
		uber.removePassenger(1, uber.searchPassengerCPF("654973652"));
		uber.addPoint(1, new Position(0.0, 800.0));
		uber.addPoint(1, new Position(400.0, 800.0));
		uber.showVoyage(1);
		uber.setVoyage("248679108", "ABC1234", "654973652", new Position(300.0, 300.0), new Position(300.0, 500.0));//método 1
		uber.addPoint(2, new Position(500.0, 500.0));
		uber.addPoint(2, new Position(500.0, 800.0));
		uber.showVoyage(2);
	}
}
