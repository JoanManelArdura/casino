package games;

import com.reki.Player;
import com.reki.services.Services;

public class Poker extends Game{
	static double prize = 50;
	static double percentWin = 20;
	
	public static double play(Player player,int bet) {
		if(Services.getRandom(0,100)<percentWin) {
			System.out.println(player.getPlayerName()+" won in poker a total of :"+ bet*prize + " €!");
			return bet*prize;
		}else {
			System.out.println(player.getPlayerName()+" lost in poker the bet : -"+ bet + " €");
			return bet * -1;
		}
}
}
