/**
*
* @author Harry 1422729
*/
package nz.ac.aut.ense701.welcome;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Background extends JPanel {

	Image bg;
	
	//This function does not working well, should be fix later
	
	public Background() {
		// Loads the background image and stores in img object.
		//this.bg = Toolkit.getDefaultToolkit().createImage("bg.jpg");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(this.bg, 0, 0, this.getWidth(), this.getHeight(), null);

	}
}
