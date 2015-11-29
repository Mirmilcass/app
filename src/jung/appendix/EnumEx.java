package jung.appendix;
import java.util.*;

class EnumEx {
	public static void main(String args[]) {
		Deck deck = new Deck();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick(1));
		System.out.println(deck.pick(2));
	}
}

class Card {
	enum Kind {
		CLOVER, HEART, DIAMOND, SPADE
	}

	enum Value {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	final Kind kind;
	final Value value;

	Card(Kind kind, Value value) {
		this.kind = kind;
		this.value = value;
	}

	Card() {
		this(Kind.SPADE, Value.ACE);
	}

	public String toString() {
		return "[" + kind + "," + value + "]";
	}
}

class Deck {
	ArrayList<Card> cards = new ArrayList<Card>();

	Deck() {
		for (Card.Kind kind : Card.Kind.values())
			for (Card.Value value : Card.Value.values())
				cards.add(new Card(kind, value));
	}

	Card pick(int index) {
		return cards.get(index);
	}
}