package com.reki;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.reki.services.Transaction;
import com.reki.services.TransactionService;

import games.BlackJack;
import games.Poker;
import games.Ruleta;
import games.Slot;
import games.VideoBingo;

public class Jugada {
	
	@Id
	@GeneratedValue
	long id;
	int playerId;
	int aposta;
	String game;
	double result;
	boolean won;
	@Autowired
	TransactionService transServ;

	public Jugada(Player player, int aposta, String game) {
		this.aposta=aposta;
		this.playerId=player.getId();
		this.game=game;
		switch (game) {
		case "bingo":
			this.result = VideoBingo.play(player, aposta);
			break;
		case "slot":
			this.result = Slot.play(player, aposta);
			break;
		case "black":
			this.result = BlackJack.play(player, aposta);
			break;
		case "poker":
			this.result = Poker.play(player, aposta);
			break;
		case "ruleta":
			this.result = Ruleta.play(player, aposta);
			break;			
		}
		this.won=result>0;
		transServ.setTransaction(player, result, game);
		
		
	}

}
