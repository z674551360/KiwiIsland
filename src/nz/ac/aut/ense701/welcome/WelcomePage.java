package nz.ac.aut.ense701.welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Ranking;
import nz.ac.aut.ense701.gameModel.User;
import nz.ac.aut.ense701.gui.KiwiCountUI;

public class WelcomePage extends JFrame implements ActionListener {
	private Background bg;
	private JButton newPlayer, login, ranking;
	private JPanel space, btn;
	private Ranking rank;
	private User currentUser;
	private final String rankFileName = "ranking";

	public WelcomePage() throws ClassNotFoundException, IOException {
		super();
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDimension = tk.getScreenSize();
		Dimension frameDimension = this.getSize();
		this.setLocation((screenDimension.width - frameDimension.width) / 2,
				(screenDimension.height - frameDimension.height) / 2);
		this.setTitle("KiwiIland Management System");

		bg = new Background();
		btn = new JPanel();
		space = new JPanel();
		BorderLayout bl = new BorderLayout();
		FlowLayout fl = new FlowLayout();
		bg.setLayout(bl);
		btn.setLayout(fl);
		btn.setSize(100, 600);
		space.setSize(200, 600);

		newPlayer = new JButton("New Player");
		login = new JButton("Login");
		ranking = new JButton("Ranking Board");
		newPlayer.addActionListener(this);
		login.addActionListener(this);
		ranking.addActionListener(this);

		btn.add(newPlayer);
		btn.add(login);
		btn.add(ranking);

		// bg.add(space,BorderLayout.WEST);
		bg.add(btn);
		this.add(bg);

		this.setVisible(true);
		initUserDatabase();
	}

	private void initUserDatabase() {
		rank = new Ranking();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		if (source == newPlayer) {
			CreateNew creat;
			String userName = null, password = null;
			do {
				creat = new CreateNew();
				JOptionPane creatplayer = creat.creat;
				userName = creat.getUserNmae();
				password = creat.getPassword();
			} while (userName.length() == 0 || password.length() < 6);
			currentUser = new User(userName, password);

			if (rank.addUser(currentUser) == false) {
				JOptionPane.showMessageDialog(null, "The user is already exist", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				this.setVisible(false);
				// create the game object
				final Game game = new Game(currentUser);
				// create the GUI for the game
				final KiwiCountUI gui = new KiwiCountUI(game);
				// make the GUI visible
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						gui.setVisible(true);
					}
				});
			}
		}
		  if(source == login){
                    Login login;
                    String userName = null; 
                    String password = null;
                    login= new Login();
		    JOptionPane playerLogin = login.login;
                    userName = login.getUserNmae();
                    password = login.getPassword();
                    currentUser = new User(userName, password);
                   
                    //get infomation fromdatabase
                    String checkName = "abc";
                    String checkPass = "abc";
                    boolean isSaving = false;
                   //TODO Need to change after the saving function have been made
                    if(rank.loadUser(currentUser)== "1"){
                       if(isSaving){
                           System.out.print("Login successful");
                       }else{
                            this.setVisible(false);
                            final Game game = new Game(currentUser);
                            final KiwiCountUI gui = new KiwiCountUI(game);
                            java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
				public void run() {
				gui.setVisible(true);
				}
			});
                       }
                     }
                     if(rank.loadUser(currentUser)== "2"){
                         	JOptionPane.showMessageDialog(null, "Plz enter the right PassWord", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
                     }
                     if(rank.loadUser(currentUser)== "3"){
                         	JOptionPane.showMessageDialog(null, "Plz check the UserName", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
                     }
                    
	}

	}

}
