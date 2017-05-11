package nz.ac.aut.ense701.gameModel;

import java.io.Serializable;

public class User {
	private String userName, password, score;
	// private ArrayList<Item> ownedItem;
	private int kiwiCount;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public int getKiwiCount(){
		return kiwiCount;
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}
