package com.unicamp.mc322.lab10;

import java.util.Calendar;

public class User {
	protected String name, cpf, creditCard;
	Calendar birthdate = Calendar.getInstance();
	Voyage voyage;
	
	public User(String name, String cpf, String creditCard, int year, int month, int date) {
		this.name = name;
		this.cpf = cpf;
		this.creditCard = creditCard;
		birthdate.set(year, month, date);
	}
	public String getCreditCard() {
		return creditCard;
	}
	public String getCPF() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	/*public Calendar GetBirthDate() {
		return birthdate;
	}*/
}
