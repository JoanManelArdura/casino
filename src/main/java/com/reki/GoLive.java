package com.reki;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;

import com.reki.services.Services;
import com.reki.services.TransactionService;

public class GoLive implements Runnable {

	Player player;
	private final AtomicBoolean running = new AtomicBoolean(false);

	@Autowired
	TransactionService transServ;

	public GoLive(Player player, TransactionService transServ) {
		this.player = player;
		this.transServ = transServ;

	}

	@Override
	public void run() {
		running.set(true);
		
		while (running.get()) {
			
			System.out.println("new player going live");
			firstMoney(transServ);
			while (player.getCash() > 2) {
				Jugada jugada = new Jugada(player, randomBet(), chooseGame(), transServ);
				try {
					Thread.sleep((long) Services.getRandom(500, 3000));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
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

	private String chooseGame() {
		String[] games = { "black", "poker", "slot", "bingo", "ruleta" };
		return games[(int) Services.getRandom(0, 4)];

	}

	private int randomBet() {
		return (int) Services.getRandom(1, player.getCash());
	}
}
