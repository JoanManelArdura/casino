package com.reki;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;

import com.reki.services.JugadaService;
import com.reki.services.Services;
import com.reki.services.TransactionService;

import games.BlackJack;
import games.Game;
import games.Poker;
import games.Ruleta;
import games.Slot;
import games.VideoBingo;

public class GoLive implements Runnable {

	Player player;
	private final AtomicBoolean running = new AtomicBoolean(false);

	@Autowired
	TransactionService transServ;
	
	@Autowired
	JugadaService jugServ;

	public GoLive(Player player, TransactionService transServ, JugadaService jugServ) {
		this.player = player;
		this.transServ = transServ;
		this.jugServ = jugServ;

	}

	@Override
	public void run() {
		running.set(true);

		while (running.get()) {
			System.out.println("new player going live");
			firstMoney(transServ);
			while (player.getCash() > 2) {
				if (player.getTime() > 0) {
					Game game = chooseGame();
					new Jugada(player, randomBet(game), game, transServ, jugServ);
					try {
						Thread.sleep((long) 1000);
						player.setTime(player.getTime() - 1);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}else {
					System.out.println(player.getPlayerName() + " has left the casino because time is over");
					stop();
				}
			}
			if (Services.getRandom(1, 100) > 50) { // hi ha un 50% possiblitats de que el jugador recarregui
				firstMoney(transServ);
				System.out.println(player.getPlayerName() + " run out of money and decided to keep playing ");
			} else {
				System.out.println(player.getPlayerName() + " run out of money and retired ");
				stop();
			}
			try {
				Thread.sleep((long) Services.getRandom(1000, 10000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread was interrupted, Failed to complete operation");
			}
		}

	}

	public void stop() {
		running.set(false);
	}

	private void firstMoney(TransactionService transServ) {
		transServ.setTransaction(player, Math.round(Services.getRandom(500, 10000)), "Ingreso inicial");
		System.out.println(player.getPlayerName() + " done a deposit of: " + player.getCash() + " €");
	}

	private Game chooseGame() {
		Game game;
		Game[] games = new Game[5];
		games[0]=new BlackJack();
		games[1]= new Poker();
		games[2]= new Ruleta();
		games[3]=new Slot();
		games[4]= new VideoBingo();
		game= games[(int) Services.getRandom(0, 4)];
		if(player.getCash()<game.getMinBet())game = games[3];
		return game;

	}

	private int randomBet(Game game) {
		double min= game.getMinBet();
		double max=game.getMaxBet();
		if(player.getCash()<game.getMaxBet()) max=player.getCash();
		return (int) Services.getRandom(min, max);
	}
}
