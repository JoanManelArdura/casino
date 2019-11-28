package games;

public class VideoBingo extends Game{
	
	int id;
	int[] prizes;
	int numberCards;
	int cardsSold;
	
	public VideoBingo(int[] prizes, int numberCards, int cardsSold) {
		this.id= super.id;
		super.id++;
		this.tipo = "bingo";
		
		this.prizes = prizes;
		this.numberCards = numberCards;
		this.cardsSold = cardsSold;
	}
	
	
}
