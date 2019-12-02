package games;

import com.reki.Player;
import com.reki.services.Services;

//ruleta have a very small chance of get a high price, and lots of chances of getting medium ones
public class Ruleta extends Game{
	static double prize = 80;
	static double prize2 = 5;
	static double prize3= 2;
	static double percentWin = 10;
	double maxBet=1000;
	double minBet = 10;
	
	
	@Override
	public double play(Player player,int bet) {
		if(Services.getRandom(0,100)<(percentWin/10)) {
			System.out.println(player.getPlayerName() + " won big price of ruleta!");
			return bet*prize;
		}else if(Services.getRandom(0,100)<(percentWin*2)){
			System.out.println(player.getPlayerName() + " won second price of ruleta!");
			return bet*prize2;
		}else if(Services.getRandom(0,100)<(percentWin*4)){
			System.out.println(player.getPlayerName() + " won third price of ruleta!");
			return bet*prize3;
		}else {
			System.out.println(player.getPlayerName()+" lost in ruleta the bet : -"+ bet + " €");
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
}
