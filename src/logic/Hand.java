package logic;

public class Hand {

	private Card[] handCards = new Card[10];

	public Hand(Card[] c) {
		this.handCards = c;
	}

	public void orderHand() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9 - i; j++) {
				if ((handCards[j].getSuit() * 10 + handCards[j].getType()) > (handCards[j + 1].getSuit() * 10
						+ handCards[j + 1].getType())) {
					Card tempCard = handCards[j];
					handCards[j] = handCards[j + 1];
					handCards[j + 1] = tempCard;
				}
			}
		}
	}

	public Card[] getHandCards() {
		return this.handCards;
	}

}
