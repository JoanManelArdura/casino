package com.reki.services;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.reki.Player;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	long id;
	private int playerId;
	private double initialTotal;
	private double amount;
	private double finalTotal;
	private LocalDate transactionDate;
	private String source;

	public Transaction(Player player, double amount, String source) {
		this.playerId = player.getId();
		this.transactionDate = java.time.LocalDate.now();
		this.initialTotal = player.getCash();
		this.finalTotal = player.getCash() + amount;
		player.setCash(finalTotal);
		this.source=source;

	}
}
