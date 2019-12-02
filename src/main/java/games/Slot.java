package games;

import com.reki.Player;
import com.reki.services.Services;

//will make slot do 3 possible prices with decreasing % 

public class Slot extends Game{
	static double prize = 20;
	static double prize2 = 10;
	static double prize3= 5;
	static double percentWin = 2;
	double maxBet= 10;
	double minBet = 1;
	String name= "Slot";
	
	@Override
	public double play(Player player,int bet) {
		if(Services.getRandom(0,100)<percentWin) {
			System.out.println(player.getPlayerName() + "won big price of slot!");
			return bet*prize;
		}else if(Services.getRandom(0,100)<(percentWin*2)){
			System.out.println(player.getPlayerName() + "won second price of slot!");
			return bet*prize2;
		}else if(Services.getRandom(0,100)<(percentWin*5)){
			System.out.println(player.getPlayerName() + "won third price of slot!");
			return bet*prize3;
		}else {
			System.out.println(player.getPlayerName()+" lost in slot machines the bet : -"+ bet + " €");
			return bet * -1;
		}
		
	}

	public double getMaxBet() {
		return maxBet;
	}

	public void setMaxBet(double maxBet) {
		this.maxBet = maxBet;
	}

	public double getMinBet() {
		return minBet;
	}

	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
