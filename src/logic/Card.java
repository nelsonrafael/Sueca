package logic;

import java.awt.image.BufferedImage;

public class Card {

	private int type;

	private int suit;

	private int valor;

	private int x, y;

	private BufferedImage imageDown;

	private BufferedImage imageUp;

	private BufferedImage imageLeft;

	private BufferedImage imageRight;

	private boolean played = false;

	private boolean special = false;

	private boolean movement = false;

	private boolean inTable = true;

	public Card(int t, int s, int v, BufferedImage d, BufferedImage u, BufferedImage l, BufferedImage r) {
		this.type = t;
		this.suit = s;
		this.valor = v;
		this.imageDown = d;
		this.imageUp = u;
		this.imageLeft = l;
		this.imageRight = r;
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

	public BufferedImage getImageDown() {
		return this.imageDown;
	}

	public BufferedImage getImageUp() {
		return this.imageUp;
	}

	public BufferedImage getImageLeft() {
		return this.imageLeft;
	}

	public BufferedImage getImageRight() {
		return this.imageRight;
	}

	public boolean getPlayed() {
		return this.played;
	}

	public void setPlayed(boolean b) {
		this.played = b;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpecial(boolean b) {
		this.special = b;
	}

	public boolean getSpecial() {
		return this.special;
	}

	public void setMovement(boolean b) {
		this.movement = b;
	}

	public boolean getMovement() {
		return this.movement;
	}

	public void setInTable(boolean b) {
		this.inTable = b;
	}

	public boolean getInTable() {
		return this.inTable;
	}

}
