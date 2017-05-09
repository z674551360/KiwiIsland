package nz.ac.aut.ense701.main;

import java.io.IOException;

import nz.ac.aut.ense701.gameModel.BGM;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gui.KiwiCountUI;
import nz.ac.aut.ense701.welcome.WelcomePage;

/**
 * Kiwi Count Project
 * 
 * @author AS
 * @version 2011
 */
public class Main {
	/**
	 * Main method of Kiwi Count.
	 * 
	 * @param args
	 *            the command line arguments
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		WelcomePage welcome = new WelcomePage();
		Thread music = new BGM();
		music.start();
	}

}
