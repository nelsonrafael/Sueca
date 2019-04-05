package logic;

import java.awt.image.BufferedImage;

public class Card {

	private int type;

	private int suit;

	private int valor;

	private BufferedImage image;

	private boolean played = false;

	public Card(int t, int s, int v, BufferedImage i) {
		this.type = t;
		this.suit = s;
		this.valor = v;
		this.image = i;
	}

	public int getType() {
		return this.type;
	}

	public int getSuit() {
		return this.suit;
	}

	public int getValor() {
		return this.valor;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public boolean getPlayed() {
		return this.played;
	}

	public void setPlayed(boolean b) {
		this.played = b;
	}

}
