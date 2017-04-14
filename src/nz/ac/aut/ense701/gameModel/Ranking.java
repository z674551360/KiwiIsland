package nz.ac.aut.ense701.gameModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Ranking implements Serializable{
	private HashMap<String,User> userList = new HashMap<String,User>();
	private ArrayList<Integer> score = new ArrayList<Integer>();
	
	public Ranking(){
	}
	
	public boolean addUser(User user){
		if(userList.containsKey(user.getUserName())){
			return false;
		}else{
			userList.put(user.getUserName(), user);
			return true;
		}
	}
	
	
}
