package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.MoveDirection;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel {
	/**
	 * Creates new GridSquarePanel.
	 * 
	 * @param game
	 *            the game to represent
	 * @param row
	 *            the row to represent
	 * @param column
	 *            the column to represent
	 */
	public GridSquarePanel(Game game, int row, int column) {
		this.game = game;
		this.row = row;
		this.column = column;
		initComponents();
		lblText.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		boolean squareVisible = game.isVisible(row, column);
		boolean squareExplored = game.isExplored(row, column);
		boolean isCurrentRow = (game.getPlayer().getPosition().getRow() == row);
		boolean isCurrentCol = (game.getPlayer().getPosition().getColumn() == column);

		if (squareVisible && !squareExplored || this.Isvisible || (isCurrentRow && isCurrentCol)) {
			String imagePath = "image/" + imageName;
			ImageIcon icon = new ImageIcon(imagePath);
			Image img = icon.getImage();
			Dimension Size = this.getParent().getSize();
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
			this.Isvisible = true;
		}

		if (this.showOccupant) {
			char[] arrays = this.lblText.getText().toCharArray();
			for (int i = 0; i < arrays.length; i++) {
				if (arrays[i] == 'H') {
					ImageIcon ico = new ImageIcon("image/hazard.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}
				if (arrays[i] == 'T') {
					ImageIcon ico = new ImageIcon("image/tool.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}
				if (arrays[i] == 'P') {
					ImageIcon ico = new ImageIcon("image/predator.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}
				if (arrays[i] == 'K') {
					ImageIcon ico = new ImageIcon("image/kiwi.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}
				if (arrays[i] == 'F') {
					ImageIcon ico = new ImageIcon("image/fauna.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}
				if (arrays[i] == 'E') {
					ImageIcon ico = new ImageIcon("image/food.png");
					Image imge = ico.getImage();
					g.drawImage(imge, 0, 0, this.getWidth(), this.getHeight(), null);
					// System.out.println(arrays[i]);
				}


			}
		}

		if (isCurrentRow && isCurrentCol) {
			ImageIcon icon = new ImageIcon("image/player.png");
			Image img = icon.getImage();
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
			this.Isvisible = true;
		}

		this.repaint();
	}

	/**
	 * Updates the representation of the grid square panel.
	 */
	public void update() {
		// get the GridSquare object from the world
		Terrain terrain = game.getTerrain(row, column);
		boolean squareVisible = game.isVisible(row, column);
		boolean squareExplored = game.isExplored(row, column);

		Color color;
		String type = "";

		switch (terrain) {
		case SAND:
			type = "sand.png";
			break;
		case FOREST:
			color = Color.GREEN;
			type = "forest.png";
			break;
		case WETLAND:
			color = Color.BLUE;
			type = "wetland.png";
			break;
		case SCRUB:

			color = Color.DARK_GRAY;
			type = "scrub.png";
			break;
		case WATER:

			color = Color.CYAN;
			type = "water.png";
			break;
		default:
			color = Color.LIGHT_GRAY;
			break;
		}

		if (squareExplored || squareVisible) {
			// Set the text of the JLabel according to the occupant
			lblText.setText(game.getOccupantStringRepresentation(row, column));
			// Set the icon
			this.imageName = type;
			// set the visible
			this.Isvisible = true;
			if (squareVisible) {
				this.showOccupant = true;
			}
			// lblText.setBackground(color);
			// set border colour according to
			// whether the player is in the grid square or not
			setBorder(game.hasPlayer(row, column) ? activeBorder : normalBorder);
		} else {
			lblText.setText("");
			lblText.setBackground(null);
			setBorder(normalBorder);
			// set the visible
			this.Isvisible = false;
			this.showOccupant = false;
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lblText = new javax.swing.JLabel();

		setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		setLayout(new java.awt.BorderLayout());

		lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblText.setText("content");
		lblText.setOpaque(true);
		add(lblText, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JLabel lblText;
	// End of variables declaration//GEN-END:variables

	private Game game;
	private int row, column;
	private boolean Isvisible = false;
	private boolean showOccupant = false;
	private String imageName;

	private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
	private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
