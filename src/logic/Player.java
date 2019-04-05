package logic;

public class Player {

	private int position;

	private String name;

	private Hand hand;

	public Player(int p, String n) {
		this.position = p;
		this.name = n;
	}

	public void setHand(Card[] h) {
		this.hand = new Hand(h);
	}

	public Hand getHand() {
		return this.hand;
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

}
