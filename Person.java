import java.util.ArrayList;

public abstract class Person {
	private ArrayList<Card> oneRoundCard;
	
	//�]�w���P���ұo�쪺�d setter
	public void setOneRoundCard(ArrayList<Card> cards){
		oneRoundCard=cards;
	}
	
	//return���P���o�쪺�dgetter
	public ArrayList<Card> getOneRoundCard(){
		return oneRoundCard;
	}
	
	public abstract boolean hit_me(Table table);
	
	public int getTotalValue() {
		int Ace_count = 0;
		int total_value = 0;
		for (Card c : oneRoundCard) {
			if (Ace_count == 0 && c.getRank() == 1) {
				Ace_count = 1;
				continue;//�V�U�@��step����
			} else {
				if (c.getRank() == 11 || c.getRank() == 12 || c.getRank() == 13)
					total_value += 10;
				else
					total_value += c.getRank();
			}
		}
		if (Ace_count != 0) {
			if (total_value < 11) {
				total_value += 11;
			} else {
				total_value += 1;
			}

		}
		return total_value;
	}
	
	public boolean hasAce() {
		boolean hasAce= false;
		for (Card c : oneRoundCard) {
			if (c.getRank() == 1) {
				hasAce = true;
			} 
		}
		return hasAce;
	}
	
	public void printAllCard(){
		for(Card c : oneRoundCard){
			c.printCard();
		}
	}
}
