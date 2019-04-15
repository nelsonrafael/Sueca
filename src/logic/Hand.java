package logic;

public class Hand {

	private Card[] handCards = new Card[10];

	private int cardsLeft;

	public Hand(Card[] c) {
		this.handCards = c;
		this.cardsLeft = 10;
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

	public int getCardsLeft() {
		return this.cardsLeft;
	}

	public boolean decreaseCardsLeft() {
		this.cardsLeft--;
		if (cardsLeft < 0)
			return false;
		return true;
	}

	public void resetCardsLeft() {
		this.cardsLeft = 10;
	}

}
