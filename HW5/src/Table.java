import java.util.ArrayList;

public class Table {

	// Class field
	public static final int MAXPLAYER = 4;// �̦h�@�i�P��৤�X�ӤH

	// instance field
	private Deck deck; // �s��Ҧ����P
	private int nDeck;// ���X�ƵP
	private Player[] players;// �s��Ҧ������a
	private Dealer dealer;// �s��@�Ӳ��a
	private int[] pos_betArray = new int[MAXPLAYER];// �s��C�Ӫ��a�b�@���U���`

	private ArrayList<Card> player1Card = new ArrayList<Card>();
	private ArrayList<Card> player2Card = new ArrayList<Card>();
	private ArrayList<Card> player3Card = new ArrayList<Card>();
	private ArrayList<Card> player4Card = new ArrayList<Card>();
	private ArrayList<Card> dealerCard = new ArrayList<Card>();

	// Table constructor // ��J�ѼƬ� int nDeck
	public Table(int nDeck) {
		this.nDeck = nDeck;
		deck = new Deck(this.nDeck); // �NDeck class�����,�æs�Jinstance field "deck"
		players = new Player[MAXPLAYER];// ��l��"players"�A�ëŧi�@�Ӫ��׬OMAXPLAYER
										// ��Player array
	}

	// �NPlayer���P��W,player��setter
	// pos���P���m�A�̦hMAXPLAYER�H�Ap��Player instance
	public void set_player(int pos, Player p) {
		players[pos] = p;
	}

	// �^�ǩҦ��b�P��W��player,player��getter
	// �N�Y�^�ǫ��O��Player[]���ܼ�(instance field)�ܼ�
	public Player[] get_player() {
		return players;
	}

	// �NDealer���P��W ,dealer��setter
	// �N�Y�NDealer��쫬�O��Dealer ���ܼ�(instance field) ��
	public void set_dealer(Dealer d) {
		dealer = d;
	}

	// �^��dealer�P���¤W���P�A�]�N�O�ĤG�i�P
	public Card get_face_up_card_of_dealer() {
		return dealer.getOneRoundCard().get(0);
	}

	private void ask_each_player_about_bets() {
		for (int i = 0; i < MAXPLAYER; i++) {
			players[i].sayHello();// �ШC�Ӫ��a���۩I
			players[i].makeBet();// �ШC�Ӫ��a�U�`
			pos_betArray[i] = players[i].makeBet();// �C�Ӫ��a�U���`�n�s�bpos_betArray�Ѥ���ϥ�
		}
	}

	// �o�P�����a����a
	// �o�P�����a��A�b�e���W�L�X���a���}���P"Dealer's face up card is " (����: printCard())
	private void distribute_cards_to_dealer_and_players() {

		// �o��i���}���P�����a1
		player1Card.add(deck.getOneCard(true));
		player1Card.add(deck.getOneCard(true));
		players[0].setOneRoundCard(player1Card);// �]�w���a1���P���o�쪺�d

		// �o��i���}���P�����a2
		player2Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		players[1].setOneRoundCard(player2Card);// �]�w���a2���P���o�쪺�d

		// �o��i���}���P�����a3
		player3Card.add(deck.getOneCard(true));
		player3Card.add(deck.getOneCard(true));
		players[2].setOneRoundCard(player3Card);// �]�w���a3���P���o�쪺�d

		// �o��i���}���P�����a4
		player4Card.add(deck.getOneCard(true));
		player4Card.add(deck.getOneCard(true));
		players[3].setOneRoundCard(player4Card);// �]�w���a4���P���o�쪺�d

		// �o�@�i�\�۪��P�A�H�Τ@�i���}���P�����a�C
		dealerCard.add(deck.getOneCard(false));
		dealerCard.add(deck.getOneCard(true));
		dealer.setOneRoundCard(dealerCard);// �]�w���a���P���o�쪺�d
		System.out.print("Dealer's face up card is ");
		dealerCard.get(1).printCard();// �b�e���W�L�X���a"���}"���P
	}

	// �ݨC�Ӫ��a�n���n�P (����: hit_me(Table tbl))
	// �߰ݶ���: ���ӥ[�J�P�������Ǧөw (��m)
	private void ask_each_player_about_hits() {

		// ���L�Xplayer1�ثe���P
		System.out.println(players[0].getName() + "'s Cards now:");
		players[0].printAllCard();
		// �߰�player1�O�_�n�P
		boolean hit = false;
		do {
			hit = players[0].hit_me(this);// ��hit_me��k�P�_���a�O�_�n�P,"�n"�^��true,"�_"�^��false
			if (hit) {
				// �^��true
				player1Card.add(deck.getOneCard(false));// "�A"�o�����a1�@�i�P
				players[0].setOneRoundCard(player1Card);// ���s�]�w���a1���P���o�쪺�d
				System.out.print("Hit! ");
				System.out.println(players[0].getName() + "'s Cards now:");
				players[0].printAllCard();// �N���a1"�n�P��"������P�L�X
			} else {
				// �^��false
				System.out.println("Pass hit!");
				System.out.println(players[0].getName() + "'s hit is over!");
			}
		} while (hit);// ���p���a�٭n�P,�A����@���j��

		// ���L�Xplayer2�ثe���P
		System.out.println(players[1].getName() + "'s Cards now:");
		players[1].printAllCard();
		// �߰�player2�O�_�n�P
		hit = false;
		do {
			hit = players[1].hit_me(this); // ��hit_me��k�P�_���a�O�_�n�P,"�n"�^��true,"�_"�^��false
			if (hit) {
				// �^��true
				player2Card.add(deck.getOneCard(false));// "�A"�o�����a2�@�i�P
				players[1].setOneRoundCard(player2Card);// ���s�]�w���a2���P���o�쪺�d
				System.out.print("Hit! ");
				System.out.println(players[1].getName() + "'s Cards now:");
				players[1].printAllCard();// �N���a2"�n�P��"������P�L�X
			} else {
				// �^��false
				System.out.println("Pass hit!");
				System.out.println(players[1].getName() + "'s hit is over!");
			}
		} while (hit);// ���p���a�٭n�P,�A����@���j��

		// ���L�Xplayer3�ثe���P
		System.out.println(players[2].getName() + "'s Cards now:");
		players[2].printAllCard();
		// �߰�player3�O�_�n�P
		hit = false;
		do {
			hit = players[2].hit_me(this); // ��hit_me��k�P�_���a�O�_�n�P,"�n"�^��true,"�_"�^��false
			if (hit) {
				// �^��true
				player3Card.add(deck.getOneCard(false));// "�A"�o�����a3�@�i�P
				players[2].setOneRoundCard(player3Card);// ���s�]�w���a3���P���o�쪺�d
				System.out.print("Hit! ");
				System.out.println(players[2].getName() + "'s Cards now:");
				players[2].printAllCard();// �N���a3"�n�P��"������P�L�X
			} else {
				// �^��false
				System.out.println("Pass hit!");
				System.out.println(players[2].getName() + "'s hit is over!");
			}
		} while (hit);// ���p���a�٭n�P,�A����@���j��

		// ���L�Xplayer4�ثe���P
		System.out.println(players[3].getName() + "'s Cards now:");
		players[3].printAllCard();
		// �߰�player4�O�_�n�P
		hit = false;
		do {
			hit = players[3].hit_me(this); // ��hit_me��k�P�_���a�O�_�n�P,"�n"�^��true,"�_"�^��false
			if (hit) {
				// �^��true
				player4Card.add(deck.getOneCard(false));// "�A"�o�����a4�@�i�P
				players[3].setOneRoundCard(player4Card);// ���s�]�w���a4���P���o�쪺�d
				System.out.print("Hit! ");
				System.out.println(players[3].getName() + "'s Cards now:");
				players[3].printAllCard();// �N���a4"�n�P��"������P�L�X
			} else {
				// �^��false
				System.out.println("Pass hit!");
				System.out.println(players[3].getName() + "'s hit is over!");
			}
		} while (hit);// ���p���a�٭n�P,�A����@���j��
	}

	// �߰ݲ��a�O�_�n�P
	private void ask_dealer_about_hits() {

		boolean hit = false;
		do {
			hit = dealer.hit_me(this); // this
			if (hit) {
				dealerCard.add(deck.getOneCard(false));// "�A"�o�����a�@�i�P
				dealer.setOneRoundCard(dealerCard);// ���s�]�w���a���P���o�쪺�d
			} else {
				System.out.println("Dealer's hit is over!");// ������A�L�X"Dealer's
															// hit is over!"

			}
		} while (hit);
	}

	// ���a��C�@�Ӫ��a���P��j�p
	private void calculate_chips() {
		// dealer
		System.out.println("Dealer's card value is " + dealer.getTotalValue() + " ,Cards:");// �L�X���a���I��
		dealer.printAllCard();// �L�X���a�Ҧ����P

		int p1Bet = players[0].makeBet();
		int p2Bet = players[1].makeBet();
		int p3Bet = players[2].makeBet();
		int p4Bet = players[3].makeBet();

		// �L�X���a1���Ҧ��P
		System.out.println(players[0].getName() + " ,Cards:");
		players[0].printAllCard();

		// ���a�S�z,���a�z->���aĹ
		if (dealer.getTotalValue() <= 21 && players[0].getTotalValue() > 21) {
			players[0].increaseChips(-p1Bet);// �S�����a1���U�`�w�X
			System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue() + ", Loss " + p1Bet
					+ " Chips, the Chips now is:" + players[0].getCurrentChips());
			// �L�X���a1���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
		}

		// ���a�z,���a�S�z->���aĹ
		if (dealer.getTotalValue() > 21 && players[0].getTotalValue() <= 21) {
			players[0].increaseChips(p1Bet);// �ߪ��a�P�U�`�w�X�۲Ť��w�X
			System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue() + " ,Get " + p1Bet
					+ " Chips, the Chips now is:" + players[0].getCurrentChips());// �L�X���a1���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
		}

		// ���a�S�z,���a�S�z->����ֳ̱���21�I
		if (dealer.getTotalValue() <= 21 && players[0].getTotalValue() <= 21) {
			if (dealer.getTotalValue() == players[0].getTotalValue()) {// ���⪺���p
				System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue()
						+ " chips have no change!, the Chips now is: " + players[0].getCurrentChips());
			}
			if (dealer.getTotalValue() > players[0].getTotalValue()) {// ���a������21�I->���aĹ
				players[0].increaseChips(-p1Bet);// �S�����a1���U�`�w�X
				System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue() + ", Loss "
						+ p1Bet + " Chips, the Chips now is:" + players[0].getCurrentChips());// �L�X���a1���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
			}
			if (dealer.getTotalValue() < players[0].getTotalValue()) {// ���a������21�I->���aĹ
				players[0].increaseChips(p1Bet);
				System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue() + " ,Get "
						+ p1Bet + " Chips, the Chips now is:" + players[0].getCurrentChips());// �L�X���a1���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
			}

		}

		// ���a�z,���a�z->����֥��z�P*
		if (dealer.getTotalValue() > 21 && players[0].getTotalValue() > 21) {
			System.out.println(players[0].getName() + " card value is " + players[0].getTotalValue()
					+ " chips have no change!, the Chips now is: " + players[0].getCurrentChips());
		}

		// �L�X���a2���Ҧ��P
		System.out.println(players[1].getName() + " ,Cards:");
		players[1].printAllCard();

		// ���a�S�z,���a�z->���aĹ
		if (dealer.getTotalValue() <= 21 && players[0].getTotalValue() > 21) {
			players[1].increaseChips(-p2Bet);// �S�����a2���U�`�w�X
			System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue() + ", Loss " + p2Bet
					+ " Chips, the Chips now is:" + players[1].getCurrentChips());
			// �L�X���a2���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
		}

		// ���a�z,���a�S�z->���aĹ
		if (dealer.getTotalValue() > 21 && players[1].getTotalValue() <= 21) {
			players[1].increaseChips(p2Bet);// �ߪ��a�P�U�`�w�X�۲Ť��w�X
			System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue() + " ,Get " + p2Bet
					+ " Chips, the Chips now is:" + players[1].getCurrentChips());// �L�X���a2���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
		}

		// ���a�S�z,���a�S�z->����ֳ̱���21�I
		if (dealer.getTotalValue() <= 21 && players[1].getTotalValue() <= 21) {
			if (dealer.getTotalValue() == players[1].getTotalValue()) {// ���⪺���p
				System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue()
						+ " chips have no change!, the Chips now is: " + players[1].getCurrentChips());
			}
			if (dealer.getTotalValue() > players[1].getTotalValue()) {// ���a������21�I->���aĹ
				players[1].increaseChips(-p2Bet);// �S�����a2���U�`�w�X
				System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue() + ", Loss "
						+ p2Bet + " Chips, the Chips now is:" + players[1].getCurrentChips());// �L�X��2���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
			}
			if (dealer.getTotalValue() < players[1].getTotalValue()) {// ���a������21�I->���aĹ
				players[1].increaseChips(p2Bet);
				System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue() + " ,Get "
						+ p2Bet + " Chips, the Chips now is:" + players[1].getCurrentChips());// �L�X���a2���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
			}

		}

		// ���a�z,���a�z->����֥��z�P*
		if (dealer.getTotalValue() > 21 && players[1].getTotalValue() > 21) {
			System.out.println(players[1].getName() + " card value is " + players[1].getTotalValue()
					+ " chips have no change!, the Chips now is: " + players[1].getCurrentChips());
		}

		// �L�X���a3���Ҧ��P
		System.out.println(players[2].getName() + " ,Cards:");
		players[2].printAllCard();

		// ���a�S�z,���a�z->���aĹ
		if (dealer.getTotalValue() <= 21 && players[2].getTotalValue() > 21) {
			players[2].increaseChips(-p3Bet);// �S�����a3���U�`�w�X
			System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue() + ", Loss " + p3Bet
					+ " Chips, the Chips now is:" + players[2].getCurrentChips());
			// �L�X���a3���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
		}

		// ���a�z,���a�S�z->���aĹ
		if (dealer.getTotalValue() > 21 && players[2].getTotalValue() <= 21) {
			players[2].increaseChips(p3Bet);// �ߪ��a�P�U�`�w�X�۲Ť��w�X
			System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue() + " ,Get " + p3Bet
					+ " Chips, the Chips now is:" + players[2].getCurrentChips());// �L�X���a1���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
		}

		// ���a�S�z,���a�S�z->����ֳ̱���21�I
		if (dealer.getTotalValue() <= 21 && players[2].getTotalValue() <= 21) {
			if (dealer.getTotalValue() == players[2].getTotalValue()) {// ���⪺���p
				System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue()
						+ " chips have no change!, the Chips now is: " + players[2].getCurrentChips());
			}
			if (dealer.getTotalValue() > players[2].getTotalValue()) {// ���a������21�I->���aĹ
				players[2].increaseChips(-p3Bet);// �S�����a1���U�`�w�X
				System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue() + ", Loss "
						+ p3Bet + " Chips, the Chips now is:" + players[2].getCurrentChips());// �L�X���a3���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
			}
			if (dealer.getTotalValue() < players[2].getTotalValue()) {// ���a������21�I->���aĹ
				players[2].increaseChips(p2Bet);
				System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue() + " ,Get "
						+ p3Bet + " Chips, the Chips now is:" + players[2].getCurrentChips());// �L�X���a3���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
			}

		}

		// ���a�z,���a�z->����֥��z�P*
		if (dealer.getTotalValue() > 21 && players[2].getTotalValue() > 21) {
			System.out.println(players[2].getName() + " card value is " + players[2].getTotalValue()
					+ " chips have no change!, the Chips now is: " + players[2].getCurrentChips());
		}

		// �L�X���a4���Ҧ��P
		System.out.println(players[3].getName() + " ,Cards:");
		players[3].printAllCard();

		// ���a�S�z,���a�z->���aĹ
		if (dealer.getTotalValue() <= 21 && players[3].getTotalValue() > 21) {
			players[3].increaseChips(-p4Bet);// �S�����a3���U�`�w�X
			System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue() + ", Loss " + p4Bet
					+ " Chips, the Chips now is:" + players[3].getCurrentChips());
			// �L�X���a3���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
		}

		// ���a�z,���a�S�z->���aĹ
		if (dealer.getTotalValue() > 21 && players[3].getTotalValue() <= 21) {
			players[3].increaseChips(p4Bet);// �ߪ��a�P�U�`�w�X�۲Ť��w�X
			System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue() + " ,Get " + p4Bet
					+ " Chips, the Chips now is:" + players[3].getCurrentChips());// �L�X���a4���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
		}

		// ���a�S�z,���a�S�z->����ֳ̱���21�I
		if (dealer.getTotalValue() <= 21 && players[3].getTotalValue() <= 21) {
			if (dealer.getTotalValue() == players[3].getTotalValue()) {// ���⪺���p
				System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue()
						+ " chips have no change!, the Chips now is: " + players[3].getCurrentChips());
			}
			if (dealer.getTotalValue() > players[3].getTotalValue()) {// ���a������21�I->���aĹ
				players[3].increaseChips(-p4Bet);// �S�����a1���U�`�w�X
				System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue() + ", Loss "
						+ p4Bet + " Chips, the Chips now is:" + players[3].getCurrentChips());// �L�X���a4���I���`�M,�骺�w�X,�{�b�Ѫ��w�X
			}
			if (dealer.getTotalValue() < players[3].getTotalValue()) {// ���a������21�I->���aĹ
				players[3].increaseChips(p4Bet);
				System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue() + " ,Get "
						+ p4Bet + " Chips, the Chips now is:" + players[3].getCurrentChips());// �L�X���a4���I���`�M,�o�쪺�U�`�w�X,�ثe���w�X
			}

		}

		// ���a�z,���a�z->����֥��z�P*
		if (dealer.getTotalValue() > 21 && players[3].getTotalValue() > 21) {
			System.out.println(players[3].getName() + " card value is " + players[3].getTotalValue()
					+ " chips have no change!, the Chips now is: " + players[3].getCurrentChips());
		}

	}

	public int[] get_palyers_bet() {
		return pos_betArray;
	}

	public void play() {
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}

}