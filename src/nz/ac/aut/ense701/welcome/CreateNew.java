/**
 *
 * @author Harry 1422729
 */
package nz.ac.aut.ense701.welcome;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatNew. dialog box for creat new player
 */
public class CreateNew {
	public JOptionPane creat;
	private JLabel userNameL, passwordL;
	private JTextField userNameIn;
	private JPasswordField passwordIn;

	/**
	 * Instantiates a new creat new.
	 */
	public CreateNew() {
		creat = new JOptionPane();
		userNameL = new JLabel("Entery UserName:");
		passwordL = new JLabel("Entery Password:");
		userNameIn = new JTextField(12);
		passwordIn = new JPasswordField(12);

		creat.setMessage(null);
		creat.setLayout(new FlowLayout());
		creat.setPreferredSize(new Dimension(300, 150));
		creat.add(userNameL, 0);
		creat.add(userNameIn, 1);
		creat.add(passwordL, 2);
		creat.add(passwordIn, 3);
		JDialog localJDialog = creat.createDialog(creat, "Creat new player");
		localJDialog.setVisible(true);

	}

	
	/**
	 * 
	 * @return the user name
	 */
	public String getUserNmae() {
		return userNameIn.getText();

	}

	/**
	 * 
	 * @return the password
	 */
	public String getPassword() {
		char[] pass = passwordIn.getPassword();
		return new String(pass);

	}

}