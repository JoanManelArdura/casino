package games;

import com.reki.Player;
import com.reki.services.Services;

public class Poker extends Game{
	static double prize = 50;
	static double percentWin = 20;
	double maxBet=100000;
	double minBet = 50;
	String name = "Poker";
	
	@Override
	public double play(Player player,int bet) {
		if(Services.getRandom(0,100)<percentWin) {
			System.out.println(player.getPlayerName()+" won in poker a total of :"+ bet*prize + " €!");
			return bet*prize;
		}else {
			System.out.println(player.getPlayerName()+" lost in poker the bet : -"+ bet + " €");
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
