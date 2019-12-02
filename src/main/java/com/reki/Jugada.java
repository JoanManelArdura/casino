package com.reki;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.reki.services.JugadaService;
import com.reki.services.TransactionService;

import games.BlackJack;
import games.Game;
import games.Poker;
import games.Ruleta;
import games.Slot;
import games.VideoBingo;

@Entity
public class Jugada {
	
	private static int id = 1;
	@Id
	long idJugada;
	int playerId;
	int aposta;
	String game;
	double result;
	boolean won;
	//@Autowired
	//TransactionService transServ;

	public Jugada(Player player, int aposta, Game game2, TransactionService transServy, JugadaService jugServy) {
		TransactionService transServ = transServy;
		this.aposta=aposta;
		this.playerId=player.getId();
		this.game=game2.getName();
		this.idJugada=id;
		JugadaService jugServ= jugServy;
		id++;
//		switch (game2) {
//		case "bingo":
//			this.result = VideoBingo.play(player, aposta);
//			break;
//		case "slot":
//			this.result = Slot.play(player, aposta);
//			break;
//		case "black":
//			this.result = BlackJack.play(player, aposta);
//			break;
//		case "poker":
//			this.result = Poker.play(player, aposta);
//			break;
//		case "ruleta":
//			this.result = Ruleta.play(player, aposta);
//			break;			
//		}
		this.result = game2.play(player, aposta);
		this.won=result>0;
		transServ.setTransaction(player, result, game2.getName());
		jugServ.saveJugada(this);
		
		
	}

}
