package games;

import com.reki.Player;
import com.reki.services.Services;

public class BlackJack extends Game{
	static double prize = 30;
	static double percentWin = 15;
	
	public static double play(Player player,int bet) {
		if(Services.getRandom(0,100)<percentWin) {
			System.out.println(player.getPlayerName()+" won in blackjack a total of :"+ bet*prize + " €!");
			return bet*prize;
		}else {
			System.out.println(player.getPlayerName()+" lost in blackjack the bet : -"+ bet + " €");
			return bet * -1;
		}
}
}