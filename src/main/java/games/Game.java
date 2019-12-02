package games;

import com.reki.Player;

public class Game {
	
	static int id;
	String name;
	private double maxBet;
	private double minBet;
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public double play(Player player, int aposta) {
		return aposta;
		// TODO Auto-generated method stub
		
	}
	public double getMinBet() {
		return minBet;
	}
	public void setMinBet(double minBet) {
		this.minBet = minBet;
	}
	public double getMaxBet() {
		return maxBet;
	}
	public void setMaxBet(double maxBet) {
		this.maxBet = maxBet;
	}

	
	
}
