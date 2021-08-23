package fr.formation.bll;

import java.util.ArrayList;
import java.util.List;

public class BllException extends Exception {
	
	List<String> messages;
	
	public BllException() {
		messages = new ArrayList<String>();
	}

	public void ajoutMessage(String msg) {
		messages.add(msg);
	}
	
	public List<String> getMessages(){
		return messages;
	}
	
	public boolean estVide() {
		return messages.isEmpty();
	}
}
