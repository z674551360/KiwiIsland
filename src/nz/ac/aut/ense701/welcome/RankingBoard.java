
package nz.ac.aut.ense701.welcome;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RankingBoard. the derby based ranking board
 */
public class RankingBoard {
	ArrayList<String[]> rankList = new ArrayList<String[]>();
	JOptionPane board;
	DefaultTableModel model;
	JTable boardT;
	String[] items;
	

	/**
	 * Instantiates a new ranking board.
	 */
	public RankingBoard(Ranking rank) {
		boardT = new JTable();
		model = new DefaultTableModel();
		boardT.setModel(model);
		boardT.setEnabled(false);
		model.addColumn("Player Name");
		model.addColumn("Highest Score");
		
		rankList = rank.getScoreboard();
		
		for (int i = 0; i < rankList.size(); i++) {
			
			items =  rankList.get(i);
			model.addRow(items);
		}

		JScrollPane jsp = new JScrollPane(boardT);
		board = new JOptionPane();
		board.setMessage(null);
		board.add(jsp, 0);
		JDialog localJDialog = board.createDialog(board, "Ranking Board");
		localJDialog.setVisible(true);

	}
}
