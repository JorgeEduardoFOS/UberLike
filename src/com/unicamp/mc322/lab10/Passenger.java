package com.unicamp.mc322.lab10;

public class Passenger extends User{
	public Passenger(String name, String cpf, String creditCard, int year, int month, int day) {
		super(name, cpf, creditCard, year, month, day);
	}
	//////////////////////////
	//Área de testes
	//////////////////////////
	public static void main(String[] args) {
		//Passenger p1 = new Passenger("Marco", "145678798", "369874", 1998, 7, 15);
		//System.out.println(p1.GetBirthDate().toString());
	}
}
