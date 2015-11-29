package jung.ch07.연습문제;
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		for (int i = 0, n = 1; i < cards.length; i++, n++) {
			boolean isKwang = false;

			isKwang = i < 10 && (n == 1 || n == 3 || n == 8);
			n = (n % 10 == 0) ? 10 : n % 10;

			cards[i] = new SutdaCard(n, isKwang);
		}
	}

	/*
	 * (1) 위에 정의된 세 개의 메서드를 작성하시오.
	 */

} // SutdaDeck

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Exercise7_2 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();

		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");

		System.out.println();
		System.out.println(deck.pick(0));
	}
}
