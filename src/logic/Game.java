package logic;

import java.awt.Graphics;

import javax.swing.JPanel;

import display.MainWindow;
import miscellaneous.Constants;

public class Game extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Deck deck = null;

	private MainWindow parentFrame;

	public Game() {
		this.setBackground(Constants.tableBackgroundColor);
	}

	public void setParentFrame(MainWindow parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void createDeck() {
		deck = new Deck();
		deck.Shuffle();

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (deck != null) {
			g.drawImage(this.deck.getDeckOfCards()[0].getImage(), parentFrame.getSize().width / 2 - 275,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[1].getImage(), parentFrame.getSize().width / 2 - 225,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[2].getImage(), parentFrame.getSize().width / 2 - 175,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[3].getImage(), parentFrame.getSize().width / 2 - 125,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[4].getImage(), parentFrame.getSize().width / 2 - 75,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[5].getImage(), parentFrame.getSize().width / 2 - 25,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[6].getImage(), parentFrame.getSize().width / 2 + 25,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[7].getImage(), parentFrame.getSize().width / 2 + 75,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[8].getImage(), parentFrame.getSize().width / 2 + 125,
					parentFrame.getSize().height - 180, this);
			g.drawImage(this.deck.getDeckOfCards()[9].getImage(), parentFrame.getSize().width / 2 + 175,
					parentFrame.getSize().height - 180, this);
		}
	}

}
