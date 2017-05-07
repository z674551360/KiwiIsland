package nz.ac.aut.ense701.welcome;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import nz.ac.aut.ense701.gameModel.User;

public class Ranking implements Serializable {
	Connection c = null;
	Statement stmt = null;

	public Ranking() {
		creatDatabase();

	}

	/**
	 * To create user database if not exist
	 */
	public void creatDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:user.db");
			// System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS USER " + "(userName CHAR(20) PRIMARY KEY NOT NULL,"
					+ " password CHAR(12) NOT NULL," + " score CHAR(10) NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(1);
			// e.printStackTrace();
		}
		// System.out.println("Table created successfully");
	}

	/**
	 * To check if user exist and add user into databse
	 * 
	 * @param user
	 */
	public boolean addUser(User user) {
		String userName = "";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:user.db");
			// System.out.println("Opened database successfully");

			String sql = "SELECT userName FROM USER WHERE userName = '" + user.getUserName() + "'";
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userName += rs.getString("userName");
			}
			if (userName.equals(user.getUserName())) {
				rs.close();
				stmt.close();
				c.close();
				return false;
			} else {
				sql = "INSERT INTO USER (userName, password, score)" + "VALUES ('" + user.getUserName() + "', '"
						+ user.getPassword() + "', '999999')";
				stmt = c.createStatement();
				stmt.executeUpdate(sql);
				rs.close();
				stmt.close();
				c.close();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			return false;
			// System.exit(1);

		}
	}

	/**
	 * To check if user exist and password is right
	 * 
	 * @param user
	 */
	public boolean loadUser(User user) {
		String userName = "";
		String password = "";
		String score = "";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:user.db");
			// System.out.println("Opened database successfully");

			String sql = "SELECT userName, password, score FROM USER WHERE userName = '" + user.getUserName()
					+ "' and password = '" + user.getPassword() + "'";
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userName += rs.getString("userName");
				password += rs.getString("password");
				score += rs.getString("score");
			}
			if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {

				user.setScore(score);
				rs.close();
				stmt.close();
				c.close();
				return true;
			} else {
				rs.close();
				stmt.close();
				c.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println(e.getClass().getName() + ": " +
			// e.getMessage());
			return false;
			// System.exit(1);
		}

	}

	/**
	 * To check and update the highest score
	 * 
	 * @param user
	 * @param time
	 */
	public void updateScore(User user, String time) {
		if (Integer.parseInt(user.getScore()) > Integer.parseInt(time)) {
			try {
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:user.db");
				// System.out.println("Opened database successfully");

				stmt = c.createStatement();
				String sql = "UPDATE USER set score = '" + time + "' where userName='" + user.getUserName() + "'";
				stmt.executeUpdate(sql);
				c.commit();
				stmt.close();
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
				// System.err.println(e.getClass().getName() + ": " +
				// e.getMessage());
				// System.exit(1);
			}
			JOptionPane.showMessageDialog(null, "Highest score updated!", "Win!", JOptionPane.WARNING_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Good job, but not the best score", "Win!", JOptionPane.WARNING_MESSAGE);
		}
	}

}
