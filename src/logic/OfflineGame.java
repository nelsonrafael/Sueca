package logic;

import javax.swing.JOptionPane;

import display.MainWindow;

public class OfflineGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game game;

	public OfflineGame(Game game, MainWindow parentFrame) {
		String playerName = "";

		playerName = JOptionPane.showInputDialog(parentFrame, "What's your name?");
		if(playerName==null || playerName.length() == 0) {
			return;
		}

		this.game = game;
		this.game.setParentFrame();

		this.game.createDeck();

		Player human = new Player(0, playerName);
		Player computer1 = new Player(1, "Manuel");
		Player computer2 = new Player(2, "Joaquim");
		Player computer3 = new Player(3, "António");

		this.game.setPlayers(human, computer1, computer2, computer3);
		
		//TODO
		this.game.dealCards(1, true);

	}

}
