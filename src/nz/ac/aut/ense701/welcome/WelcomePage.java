package nz.ac.aut.ense701.welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class WelcomePage extends JFrame implements ActionListener{
	private Background bg;
	private JButton newPlayer, login, ranking;
	private JPanel space,btn;
	
	public WelcomePage() {
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
		btn.setSize(100,600);
		space.setSize(200,600);
		
		
		newPlayer = new JButton("New Player");
		login = new JButton("Login");
		ranking = new JButton("Ranking Board");
		newPlayer.addActionListener(this);
		login.addActionListener(this);
		ranking.addActionListener(this);
		
		btn.add(newPlayer);
		btn.add(login);
		btn.add(ranking);
		
		
		//bg.add(space,BorderLayout.WEST);
		bg.add(btn);
		this.add(bg);
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
