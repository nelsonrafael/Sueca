package logic;

import display.MainWindow;

public class OfflineGame extends Game{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Game game;

	public OfflineGame(Game game, MainWindow parentFrame) {
		this.game = game;
		this.game.setParentFrame(parentFrame);
		this.game.createDeck();
	}

}
