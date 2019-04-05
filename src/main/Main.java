package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import display.MainWindow;
import miscellaneous.Constants;

public class Main {

	public static void main(String s[]) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		MainWindow mainWindow = new MainWindow();

		mainWindow.setTitle(Constants.nameOfGameString);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(800, 800));

		mainWindow.setLocationRelativeTo(null);
		mainWindow.pack();

		mainWindow.setLocation(dim.width / 2 - mainWindow.getSize().width / 2,
				dim.height / 2 - mainWindow.getSize().height / 2);

		mainWindow.setVisible(true);
	}

}
