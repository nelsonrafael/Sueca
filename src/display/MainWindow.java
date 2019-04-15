package display;

import java.awt.GridLayout;

import javax.swing.JFrame;

import logic.Game;
import logic.OfflineGame;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuBar menuBar = new MenuBar(this);

	private Game game = new Game();

	public MainWindow() {

		this.setJMenuBar(menuBar);

		this.setLayout(new GridLayout(1, 1));

		this.add(game);
	}

	public void startOfflineGame() {
		OfflineGame offlineGame = new OfflineGame(game, this);
	}

}
