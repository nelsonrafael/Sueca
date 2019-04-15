package logic;

public class Round {

	private int initialPlayer;

	private int currentTurn;

	private int currentPlayer;

	private int currentSuit;

	private Card currentSpecial;

	private Card[] pile;

	public Round(int p) {
		this.currentTurn = 0;
		this.currentPlayer = p;
		this.initialPlayer = p;
		this.pile = new Card[4];
	}

	// TODO
	public void playCard(Card c) {
		this.pile[currentPlayer] = c;

	}

	public void increaseCurrentPlayer() {
		this.currentPlayer++;
		if (currentPlayer > 3)
			currentPlayer = 0;
	}

	public boolean nextTurn() {
		this.currentTurn++;
		if (currentTurn < 10)
			return true;
		return false;
	}

	public Card getCurrentSpecial() {
		return this.currentSpecial;
	}

	public void setCurrentSpecial(Card c) {
		this.currentSpecial = c;
	}

	public int getCurrentPlayer() {
		return this.currentPlayer;
	}

	public int getCurrentSuit() {
		return this.currentSuit;
	}

	public void setCurrentSuit(int s) {
		this.currentSuit = s;
	}

}
