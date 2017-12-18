import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard; // fields to record used card in an ArrayList
	private ArrayList<Card> openCard; // 存放此副牌中所有打開的牌，洗牌時要重置
	public int nUsed; // fields to record how many crads are using

	public Deck(int nDeck) {

		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();

		for (int n = 1; n <= nDeck; n++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int r = 1; r <= 13; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}
		}
		shuffle();// Deck constructor calls the shuffle method at the end
	}

	public void printDeck() {

		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	// new method to shuffle the card's index
	public void shuffle() {

		for (int i = 0; i < cards.size(); i++) {
			Collections.swap(cards, i, (int) (Math.random() * cards.size() - 1));
		}

		usedCard = new ArrayList<Card>(); // reset "usedCard"
		nUsed = 0; // reset "nUsed"
		openCard = new ArrayList<Card>(); // reset "openCard"

	}

	// new method to get one card in "cards" ,and put it into "usedCard"
	public Card getOneCard(boolean isOpened) {

		// if no card in "cards",shuffle()!
		if (usedCard.size() == cards.size()) {
			shuffle();
		}

		// 根據 isOpened 參數，決定發出去的牌是開著還是蓋起來的。
		// 若是開著的牌，加入openCard
		if (isOpened == true) {
			usedCard.add(cards.get(nUsed));
			openCard.add(cards.get(nUsed));
		} else {
			usedCard.add(cards.get(nUsed));
		}
		nUsed += 1;

		return usedCard.get(usedCard.size() - 1);

	}

	// 回傳此副牌中所有打開過的牌，意即openCard
	public ArrayList<Card> getOpenedCard() {
		return openCard;
	}

}
