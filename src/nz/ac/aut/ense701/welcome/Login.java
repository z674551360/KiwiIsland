package nz.ac.aut.ense701.welcome;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	public JOptionPane login;
	private JLabel userNameL, passwordL;
	private JTextField userNameIn;
	private JPasswordField passwordIn;

	/**
	 * Instantiates a new creat new.
	 */
	public Login() {
		login = new JOptionPane();
		userNameL = new JLabel("UserName:");
		passwordL = new JLabel("Password:");
		userNameIn = new JTextField(20);
		passwordIn = new JPasswordField(12);
		
		login.setMessage(null);
		login.setLayout(new FlowLayout());
		login.setPreferredSize(new Dimension(300, 120));
		login.add(userNameL, 0);
		login.add(userNameIn, 1);
		login.add(passwordL, 2);
		login.add(passwordIn, 3);

		JDialog localJDialog = login.createDialog(login, "Login to the game");

		localJDialog.setVisible(true);

	}

	
	public String getUserNmae(){
		return userNameIn.getText();
		
	}
	
	public String getPassword(){
		char[] pass = passwordIn.getPassword();
		return new String(pass);
		
	}

}
