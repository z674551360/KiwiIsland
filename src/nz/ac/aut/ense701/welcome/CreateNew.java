/**
 *
 * @author Harry 1422729
 */
package nz.ac.aut.ense701.welcome;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	private JLabel userNameL, passwordL,warning;
	private JTextField userNameIn;
	private JPasswordField passwordIn;

	/**
	 * Instantiates a new creat new.
	 */
	public CreateNew() {
		creat = new JOptionPane();
		userNameL = new JLabel("UserName:");
		passwordL = new JLabel("Password:");
                warning=new JLabel("User Name And Password Must Be Longer Than 6 Characters!");
		userNameIn = new JTextField(12);
		passwordIn = new JPasswordField(12);
                
		creat.setMessage(null);
		creat.setLayout(new FlowLayout());
		creat.setPreferredSize(new Dimension(400, 150));
		creat.add(userNameL, 0);
		creat.add(userNameIn, 1);
		creat.add(passwordL, 2);
		creat.add(passwordIn, 3);
                creat.add(warning, 4);
		JDialog localJDialog = creat.createDialog(creat, "Creat new player");
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