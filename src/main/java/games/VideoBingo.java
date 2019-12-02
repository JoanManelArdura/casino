package games;

import com.reki.Player;
import com.reki.services.Services;


public class VideoBingo extends Game{
	
	static double prize = 40;
	//int numberCards;
	//int cardsSold;
	static double percentWin = 2.5;
	double maxBet=100;
	double minBet = 10;
	String name = "VideoBingo";
	
	@Override
	public double play(Player player,int bet) {
		if(Services.getRandom(0,100)<percentWin) {
			System.out.println(player.getPlayerName()+" won in videobingo a total of :"+ bet*prize + " €!");
			return bet*prize;
		}else {
			System.out.println(player.getPlayerName()+" lost in videobingo the bet : -"+ bet + " €");
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
