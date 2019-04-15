package logic;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import display.MainWindow;
import miscellaneous.Constants;

public class Game extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Deck deck = null;

	private Player player1, player2, player3, player4;

	private Round round;

	private Timer timer;

	public Game() {
		this.setBackground(Constants.tableBackgroundColor);
	}

	public void setParentFrame() {

		this.addMouseListener(this);
	}

	public void setPlayers(Player p1, Player p2, Player p3, Player p4) {
		this.player1 = p1;
		this.player2 = p2;
		this.player3 = p3;
		this.player4 = p4;
	}

	public void dealCards(int position, boolean top) {
		if (top) {
			if (position == player1.getPosition()) {
				round = new Round(1);
				player1.setHand(deck.dealCards(0));
				player2.setHand(deck.dealCards(1));
				player3.setHand(deck.dealCards(2));
				player4.setHand(deck.dealCards(3));
			}
			if (position == player2.getPosition()) {
				round = new Round(2);
				player2.setHand(deck.dealCards(0));
				player3.setHand(deck.dealCards(1));
				player4.setHand(deck.dealCards(2));
				player1.setHand(deck.dealCards(3));
			}
			if (position == player3.getPosition()) {
				round = new Round(3);
				player3.setHand(deck.dealCards(0));
				player4.setHand(deck.dealCards(1));
				player1.setHand(deck.dealCards(2));
				player2.setHand(deck.dealCards(3));
			} else {
				round = new Round(0);
				player4.setHand(deck.dealCards(0));
				player1.setHand(deck.dealCards(1));
				player2.setHand(deck.dealCards(2));
				player3.setHand(deck.dealCards(3));
			}
			deck.getDeckOfCards()[0].setSpecial(true);
			round.setCurrentSpecial(deck.getDeckOfCards()[0]);
		} else {
			if (position == player1.getPosition()) {
				round = new Round(1);
				player1.setHand(deck.dealCards(3));
				player2.setHand(deck.dealCards(2));
				player3.setHand(deck.dealCards(1));
				player4.setHand(deck.dealCards(0));
			}
			if (position == player2.getPosition()) {
				round = new Round(2);
				player2.setHand(deck.dealCards(0));
				player3.setHand(deck.dealCards(2));
				player4.setHand(deck.dealCards(1));
				player1.setHand(deck.dealCards(0));
			}
			if (position == player3.getPosition()) {
				round = new Round(3);
				player3.setHand(deck.dealCards(3));
				player4.setHand(deck.dealCards(2));
				player1.setHand(deck.dealCards(1));
				player2.setHand(deck.dealCards(0));
			} else {
				round = new Round(0);
				player4.setHand(deck.dealCards(3));
				player1.setHand(deck.dealCards(2));
				player2.setHand(deck.dealCards(1));
				player3.setHand(deck.dealCards(0));
			}
			deck.getDeckOfCards()[39].setSpecial(true);
			round.setCurrentSpecial(deck.getDeckOfCards()[39]);
		}

		this.player1.getHand().orderHand();
		this.player2.getHand().orderHand();
		this.player3.getHand().orderHand();
		this.player4.getHand().orderHand();

		generateCardCoordinates();
	}

	private void clearCardsInTable() {
		for (int i = 0; i < 10; i++) {
			if (this.player1.getHand().getHandCards()[i].getInTable())
				this.player1.getHand().getHandCards()[i].setInTable(false);
			if (this.player2.getHand().getHandCards()[i].getInTable())
				this.player2.getHand().getHandCards()[i].setInTable(false);
			if (this.player3.getHand().getHandCards()[i].getInTable())
				this.player3.getHand().getHandCards()[i].setInTable(false);
			if (this.player4.getHand().getHandCards()[i].getInTable())
				this.player4.getHand().getHandCards()[i].setInTable(false);
		}
	}

	// FIX LATER
	private void generateCardCoordinates() {
		int cardsPlayer1 = this.player1.getHand().getCardsLeft();
		int cardCounterPlayer1 = 0;
		int cardsPlayer2 = this.player2.getHand().getCardsLeft();
		int cardCounterPlayer2 = 0;
		int cardsPlayer3 = this.player3.getHand().getCardsLeft();
		int cardCounterPlayer3 = 0;
		int cardsPlayer4 = this.player4.getHand().getCardsLeft();
		int cardCounterPlayer4 = 0;

		int x, y;

		for (int i = 0; i < 10; i++) {
			if (this.player1.getHand().getHandCards()[i].getPlayed() == false) {
				x = 150 + cardCounterPlayer1 * 45 + (10 - cardsPlayer1) * 22;
				y = 620;
				this.player1.getHand().getHandCards()[i].setX(x);
				this.player1.getHand().getHandCards()[i].setY(y);
				cardCounterPlayer1++;
			}

			if (this.player2.getHand().getHandCards()[i].getPlayed() == false) {
				x = 25;
				y = 130 + cardCounterPlayer2 * 45 + (10 - cardsPlayer2) * 22;
				this.player2.getHand().getHandCards()[i].setX(x);
				this.player2.getHand().getHandCards()[i].setY(y);
				cardCounterPlayer2++;
			}

			if (this.player3.getHand().getHandCards()[i].getPlayed() == false) {
				x = 150 + cardCounterPlayer3 * 45 + (10 - cardsPlayer3) * 22;
				y = 25;
				this.player3.getHand().getHandCards()[i].setX(x);
				this.player3.getHand().getHandCards()[i].setY(y);
				cardCounterPlayer3++;
			}

			if (this.player4.getHand().getHandCards()[i].getPlayed() == false) {
				x = 660;
				y = 130 + cardCounterPlayer4 * 45 + (10 - cardsPlayer4) * 22;
				this.player4.getHand().getHandCards()[i].setX(x);
				this.player4.getHand().getHandCards()[i].setY(y);
				cardCounterPlayer4++;
			}
		}

		repaint();
	}

	public void createDeck() {
		deck = new Deck();
		deck.Shuffle();
	}

	// TODO choose back
	private void drawHandCards(Graphics g) {
		for (int i = 0; i < 10; i++) {
			if (this.player1.getHand().getHandCards()[i].getPlayed() == false
					|| this.player1.getHand().getHandCards()[i].getInTable() == true) {
				if (this.player1.getHand().getHandCards()[i].getSpecial() == false)
					g.drawImage(this.player1.getHand().getHandCards()[i].getImageDown(),
							this.player1.getHand().getHandCards()[i].getX(),
							this.player1.getHand().getHandCards()[i].getY(), this);
				else {
					// SOMETHING
				}
			}

			if (this.player2.getHand().getHandCards()[i].getPlayed() == false
					|| this.player2.getHand().getHandCards()[i].getInTable() == true) {
				if (this.player2.getHand().getHandCards()[i].getSpecial() == false)
					g.drawImage(this.deck.getCardBackSide()[0], this.player2.getHand().getHandCards()[i].getX(),
							this.player2.getHand().getHandCards()[i].getY(), this);
				else
					g.drawImage(this.player2.getHand().getHandCards()[i].getImageLeft(),
							this.player2.getHand().getHandCards()[i].getX(),
							this.player2.getHand().getHandCards()[i].getY(), this);
			}

			if (this.player3.getHand().getHandCards()[i].getPlayed() == false
					|| this.player3.getHand().getHandCards()[i].getInTable() == true) {
				if (this.player3.getHand().getHandCards()[i].getSpecial() == false)
					g.drawImage(this.deck.getCardBackFront()[0], this.player3.getHand().getHandCards()[i].getX(),
							this.player3.getHand().getHandCards()[i].getY(), this);
				else
					g.drawImage(this.player3.getHand().getHandCards()[i].getImageUp(),
							this.player3.getHand().getHandCards()[i].getX(),
							this.player3.getHand().getHandCards()[i].getY(), this);

			}

			if (this.player4.getHand().getHandCards()[i].getPlayed() == false
					|| this.player4.getHand().getHandCards()[i].getInTable() == true) {
				if (this.player4.getHand().getHandCards()[i].getSpecial() == false)
					g.drawImage(this.deck.getCardBackSide()[0], this.player4.getHand().getHandCards()[i].getX(),
							this.player4.getHand().getHandCards()[i].getY(), this);
				else
					g.drawImage(this.player4.getHand().getHandCards()[i].getImageRight(),
							this.player4.getHand().getHandCards()[i].getX(),
							this.player4.getHand().getHandCards()[i].getY(), this);
			}
		}

	}

	private void moveCard(Player p, int cardIndex, int xFinal, int yFinal) {
		timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (xFinal > p.getHand().getHandCards()[cardIndex].getX()) {
					p.getHand().getHandCards()[cardIndex].setX(p.getHand().getHandCards()[cardIndex].getX() + 10);
					if (xFinal < p.getHand().getHandCards()[cardIndex].getX()) {
						p.getHand().getHandCards()[cardIndex].setX(xFinal);
					}
				} else if (xFinal < p.getHand().getHandCards()[cardIndex].getX()) {
					p.getHand().getHandCards()[cardIndex].setX(p.getHand().getHandCards()[cardIndex].getX() - 10);
					if (xFinal > p.getHand().getHandCards()[cardIndex].getX()) {
						p.getHand().getHandCards()[cardIndex].setX(xFinal);
					}
				}

				if (yFinal > p.getHand().getHandCards()[cardIndex].getY()) {
					p.getHand().getHandCards()[cardIndex].setY(p.getHand().getHandCards()[cardIndex].getY() + 10);
					if (yFinal < p.getHand().getHandCards()[cardIndex].getY()) {
						p.getHand().getHandCards()[cardIndex].setY(yFinal);
					}
				} else if (yFinal < p.getHand().getHandCards()[cardIndex].getY()) {
					p.getHand().getHandCards()[cardIndex].setY(p.getHand().getHandCards()[cardIndex].getY() - 10);
					if (yFinal > p.getHand().getHandCards()[cardIndex].getY()) {
						p.getHand().getHandCards()[cardIndex].setY(yFinal);
					}
				}
				repaint();

				if (yFinal == p.getHand().getHandCards()[cardIndex].getY()
						&& xFinal == p.getHand().getHandCards()[cardIndex].getX()) {
					p.getHand().getHandCards()[cardIndex].setMovement(false);
					p.getHand().getHandCards()[cardIndex].setPlayed(true);

					generateCardCoordinates();

					timer.stop();
				}
			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (deck != null) {
			drawHandCards(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		int lastCard = 0;

		int xVar;

		for (int i = 0; i < 10; i++) {

			xVar = 45;

			if (!this.player1.getHand().getHandCards()[i].getPlayed())
				lastCard++;
			if (lastCard == this.player1.getHand().getCardsLeft())
				xVar = 71;

			if (!this.player1.getHand().getHandCards()[i].getPlayed()
					&& x > this.player1.getHand().getHandCards()[i].getX()
					&& x < this.player1.getHand().getHandCards()[i].getX() + xVar
					&& y > this.player1.getHand().getHandCards()[i].getY()
					&& y < this.player1.getHand().getHandCards()[i].getY() + 96) {

				this.player1.getHand().getHandCards()[i].setMovement(true);
				this.player1.getHand().decreaseCardsLeft();

				// NOT TO BE HERE
				int xFinal = 0, yFinal = 0;
				switch (player1.getPosition()) {
				case 0:
					xFinal = 365;
					yFinal = 410;
					break;
				case 1:
					xFinal = 294;
					yFinal = 365;
					break;
				case 2:
					xFinal = 365;
					yFinal = 294;
					break;
				case 3:
					xFinal = 294;
					yFinal = 410;
					break;
				default:
					break;
				}

				moveCard(player1, i, xFinal, yFinal);

				return;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
