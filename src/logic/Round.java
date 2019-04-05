package logic;

public class Round {

	private int currentTurn;

	private int currentPlayer;

	private int currentSuit;

	private int currentSpecial;

	public Round(int p) {
		this.currentTurn = 0;
		this.currentPlayer = p;
	}

	public int getCurrentTurn() {
		return this.currentTurn;
	}

	public boolean nextTurn() {
		this.currentTurn++;
		this.currentPlayer++;
		if (currentPlayer > 3)
			currentPlayer = 0;
		if (currentTurn < 10)
			return false;
		return true;
	}

	public int getCurrentSpecial() {
		return this.currentSpecial;
	}

	public void setCurrentSpecial(int s) {
		this.currentSpecial = s;
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
