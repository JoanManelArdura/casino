package com.reki;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	
	
	private static int id = 1;
	@Id
	private int idPlayer;
	private String playerName;
	private LocalDate registerDate;
	private double balance;
	private double time;
	private int idProvider;
	

	public Player(String name, int idProvider) {
		this.playerName = name;
		this.idPlayer = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
		this.balance = 0;
		this.time = 0;
		this.idProvider= idProvider;
	}
	public Player() {
		this.playerName = "ANONIMOUS";
		this.idPlayer = id;
		id++;
		this.registerDate = java.time.LocalDate.now();
		this.balance = 0;
		this.time = 0;
	}	
	
	
	public int getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setName(String next) {
		this.playerName = next;
		
	}
	public double getCash() {
		return balance;
	}
	public void setCash(double cash) {
		this.balance = cash;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	
	

}