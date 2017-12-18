
public class Player extends Person{

	private String name; // 玩家姓名
	private int chips; // 玩家有的籌碼
	private int bet; // 玩家此局下注的籌碼

	// Player constructor，新增Player物件時，需要姓名、擁有的籌碼等兩個參數
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	
    //name的getter
	public String getName() {
		return name;
	}

	//下注，回傳預計下注的籌碼
	public int makeBet() {
		
		// 設計條件檢查是否還有錢，沒錢了就不能再繼續下注
		if (getCurrentChips() == 0) {
			return 0;
		} else {
			//基本下注：一次1元
			bet = 1;
			return bet;
		}
	}


	//回傳此牌局所得的卡點數加總
	//public int getTotalValue() {
	//	int total = 0;
	//	for (int i = 0; i < oneRoundCard.size(); i++) {
	//		int getrank = oneRoundCard.get(i).getRank();
			// 設計條件讓 " J & Q & K " 為"10"
	//		if (getrank > 10 && getrank < 14) {
	//			getrank = 10;
	//		}
			// 設計條件讓Ace為"1"or"11"
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

	//回傳玩家現有籌碼
	public int getCurrentChips() {
		return this.chips;
	}

	//玩家籌碼變動，setter
	public void increaseChips(int diff) {
		this.chips += diff;
	}

	//start game
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
	
	@Override
	//是否要牌，是回傳true，不再要牌則回傳false
	//基本參考條件：16點以下要牌，17點以上不要牌
	public boolean hit_me(Table tbl) {
		return  (getTotalValue() < 17);
	}
}
