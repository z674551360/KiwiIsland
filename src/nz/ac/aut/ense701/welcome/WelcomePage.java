package nz.ac.aut.ense701.welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		this.setTitle("AUT Sudoku Championship");

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

	private void initUserDatabase() throws IOException, ClassNotFoundException {
		String rankFileName = "ranking";
		FileInputStream in = null;
		Boolean success = false;
		try {
			in = new FileInputStream(rankFileName);
			success = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("First run of program, will initial all data");
		}
		if (success) {
			ObjectInputStream rankingObject = new ObjectInputStream(in);
			rank = (Ranking) rankingObject.readObject();
		}else{
			FileOutputStream out = new FileOutputStream(rankFileName); 
			ObjectOutputStream rankingObject = new ObjectOutputStream(out);
			rank = new Ranking();
			rankingObject.writeObject(rank);
			rankingObject.flush();
		}
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
				final Game game = new Game();
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
	}

}
