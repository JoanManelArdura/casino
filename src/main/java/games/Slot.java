package games;

import com.reki.Player;
import com.reki.services.Services;

//will make slot do 3 possible prices with decreasing % 

public class Slot extends Game{
	static double prize = 20;
	static double prize2 = 10;
	static double prize3= 5;
	static double percentWin = 2;
	
	public static double play(Player player,int bet) {
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
}
