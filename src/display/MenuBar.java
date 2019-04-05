package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import miscellaneous.Constants;

public class MenuBar extends JMenuBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainWindow parentFrame;
	
	private JMenu fileMenu = new JMenu("File");
	private JMenu optionsMenu = new JMenu("Options");
	private JMenu helpMenu = new JMenu("Help");
	
	private JMenuItem startNewOfflineGameItem = new JMenuItem("Start New Offline Game");
	private JMenuItem startNewOnlineGameItem = new JMenuItem("Start New Online Game");
	private JMenuItem joinOnlineGameItem = new JMenuItem("Join Online Game");
	private JMenuItem exitItem = new JMenuItem("Exit");
	
	private JMenuItem preferencesItem = new JMenuItem("Preferences");
	
	private JMenuItem helpItem = new JMenuItem("Help Contents");
	private JMenuItem aboutItem = new JMenuItem("About " + Constants.nameOfGameString);
	
	public MenuBar(MainWindow parentFrame) {
		this.parentFrame = parentFrame;
		
		fileMenu.add(startNewOfflineGameItem);
		fileMenu.add(startNewOnlineGameItem);
		fileMenu.add(joinOnlineGameItem);
		fileMenu.add(exitItem);
		
		optionsMenu.add(preferencesItem);
		
		helpMenu.add(helpItem);
		helpMenu.add(aboutItem);

		this.add(fileMenu);
		this.add(optionsMenu);
		this.add(helpMenu);

		startNewOfflineGameItem.addActionListener(this);
		startNewOnlineGameItem.addActionListener(this);
		joinOnlineGameItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		preferencesItem.addActionListener(this);
		
		helpItem.addActionListener(this);
		aboutItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == startNewOfflineGameItem) {
			this.parentFrame.startOfflineGame();
		}else if(source == startNewOnlineGameItem) {
			//TODO
		}else if(source == joinOnlineGameItem) {
			//TODO
		}else if(source == exitItem) {
			//TODO
			System.exit(0);
		}else if(source == preferencesItem) {
			//TODO
		}else if(source == helpItem) {
			//TODO
		}else if (e.getSource() == aboutItem) {
			JOptionPane.showMessageDialog(this.parentFrame,
					Constants.creditsString, "About " + Constants.nameOfGameString,
					JOptionPane.PLAIN_MESSAGE);
		}
	}

}
