package nz.ac.aut.ense701.welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.User;
import nz.ac.aut.ense701.gui.KiwiCountUI;

public class WelcomePage extends JFrame implements ActionListener {
	private Background bg;
	private JButton newPlayer, login, ranking;
	private JPanel space, btn;
	private Ranking rank;
	private User currentUser;
	private final String rankFileName = "ranking";
	
	
	//To create user interface of main page
	//Need more work it to make it better
	public WelcomePage() {
		super();
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDimension = tk.getScreenSize();
		Dimension frameDimension = this.getSize();
		this.setLocation((screenDimension.width - frameDimension.width) / 2,
				(screenDimension.height - frameDimension.height) / 2);
		this.setTitle("KiwiIland Management System");
		
        
		bg = new Background();
		bg.setPreferredSize(new Dimension(400, 500));
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
		
		ImageIcon img = new ImageIcon("image/welcome.jpg");  
        //Ҫ���õı���ͼƬ  
        JLabel imgLabel = new JLabel(img);  
        //
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        //
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        //
        JPanel jp=(JPanel)this.getContentPane(); 
        jp.setOpaque(false);
		pack();
		setVisible(true);
		initUserDatabase();
	}

	private void initUserDatabase() {
		rank = new Ranking();

	}

	
	/**
	 * regular expression user to check the username and password
	 * @param string
	 * @return
	 */
	public boolean verifyFormat(String string) {
		String regEx = "[A-Za-z0-9-]{6,12}";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		
		// If player click creat new player button
		if (source == newPlayer) {
			String userName = null, password = null;

			CreateNew creat = new CreateNew();
			JOptionPane creatplayer = creat.creat;
			userName = creat.getUserNmae();
			password = creat.getPassword();

			if (!verifyFormat(userName)) {
				JOptionPane.showMessageDialog(null,
						"The length of username must more then 6 character, must be letter or number", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
				currentUser = null;
			} else if (!verifyFormat(password)) {
				JOptionPane.showMessageDialog(null,
						"The length of password must more then 6 character, must be letter or number", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
				currentUser = null;
			} else {
				currentUser = new User(userName, password);
			}

			if (currentUser != null) {
				if (rank.addUser(currentUser) == false) {
					JOptionPane.showMessageDialog(null, "The user is already exist", "WARNING!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					this.setVisible(false);
					// create the game object
					final Game game = new Game(currentUser, false);
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

		// If user click the login button
		if (source == login) {
			Login login;
			String userName = null, password = null;
			login = new Login();
			JOptionPane playerLogin = login.login;
			userName = login.getUserNmae();
			password = login.getPassword();
			if (!verifyFormat(userName)) {
				JOptionPane.showMessageDialog(null,
						"The length of username must more then 6 character, must be letter or number", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
				currentUser = null;
			} else if (!verifyFormat(password)) {
				JOptionPane.showMessageDialog(null,
						"The length of password must more then 6 character, must be letter or number", "WARNING!",
						JOptionPane.WARNING_MESSAGE);
				currentUser = null;
			} else {
				currentUser = new User(userName, password);
			}

			if (currentUser != null) {
				if (rank.loadUser(currentUser) == true) {
					String fileName = "./data/" + userName;
					File file = new File(fileName);
					if (file.exists()) {
						this.setVisible(false);
						// create the game object
						final Game game = new Game(currentUser, true);
						// create the GUI for the game
						final KiwiCountUI gui = new KiwiCountUI(game);
						// make the GUI visible
						java.awt.EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								gui.setVisible(true);
							}
						});
					} else {
						this.setVisible(false);
						// create the game object
						final Game game = new Game(currentUser, false);
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

				} else {
					JOptionPane.showMessageDialog(null, "Username or Password is wrong", "WARNING!",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		}
		if (source == ranking) {
			RankingBoard rankingBoard = new RankingBoard(rank);
			JOptionPane loginplayer = rankingBoard.board;
		}

	}

}