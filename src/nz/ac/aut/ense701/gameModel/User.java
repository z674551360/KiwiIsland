package nz.ac.aut.ense701.gameModel;

import java.io.Serializable;



public class User implements Serializable{
	private String userName, password;
	//private ArrayList<Item> ownedItem;

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

	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
}
