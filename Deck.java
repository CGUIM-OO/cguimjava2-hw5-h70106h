import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard; // fields to record used card in an ArrayList
	private ArrayList<Card> openCard; // �s�񦹰ƵP���Ҧ����}���P�A�~�P�ɭn���m
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

		// �ھ� isOpened �ѼơA�M�w�o�X�h���P�O�}���٬O�\�_�Ӫ��C
		// �Y�O�}�۪��P�A�[�JopenCard
		if (isOpened == true) {
			usedCard.add(cards.get(nUsed));
			openCard.add(cards.get(nUsed));
		} else {
			usedCard.add(cards.get(nUsed));
		}
		nUsed += 1;

		return usedCard.get(usedCard.size() - 1);

	}

	// �^�Ǧ��ƵP���Ҧ����}�L���P�A�N�YopenCard
	public ArrayList<Card> getOpenedCard() {
		return openCard;
	}

}
