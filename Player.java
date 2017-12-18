
public class Player extends Person{

	private String name; // ���a�m�W
	private int chips; // ���a�����w�X
	private int bet; // ���a�����U�`���w�X

	// Player constructor�A�s�WPlayer����ɡA�ݭn�m�W�B�֦����w�X����ӰѼ�
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	
    //name��getter
	public String getName() {
		return name;
	}

	//�U�`�A�^�ǹw�p�U�`���w�X
	public int makeBet() {
		
		// �]�p�����ˬd�O�_�٦����A�S���F�N����A�~��U�`
		if (getCurrentChips() == 0) {
			return 0;
		} else {
			//�򥻤U�`�G�@��1��
			bet = 1;
			return bet;
		}
	}


	//�^�Ǧ��P���ұo���d�I�ƥ[�`
	//public int getTotalValue() {
	//	int total = 0;
	//	for (int i = 0; i < oneRoundCard.size(); i++) {
	//		int getrank = oneRoundCard.get(i).getRank();
			// �]�p������ " J & Q & K " ��"10"
	//		if (getrank > 10 && getrank < 14) {
	//			getrank = 10;
	//		}
			// �]�p������Ace��"1"or"11"
	//		if (total > 10 && getrank == 1) {
	//			getrank = 1;

	//		}
	//		if (total < 10 && getrank == 1) {
	//			getrank = 11;
	//		}
	//		total += getrank;
	//	}
	//	return total;
	//}

	//�^�Ǫ��a�{���w�X
	public int getCurrentChips() {
		return this.chips;
	}

	//���a�w�X�ܰʡAsetter
	public void increaseChips(int diff) {
		this.chips += diff;
	}

	//start game
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
	
	@Override
	//�O�_�n�P�A�O�^��true�A���A�n�P�h�^��false
	//�򥻰Ѧұ���G16�I�H�U�n�P�A17�I�H�W���n�P
	public boolean hit_me(Table tbl) {
		return  (getTotalValue() < 17);
	}
}
