package com.imc.rps.simulator.domain;

import com.imc.rps.simulator.model.Gesture;

public class Player {
	private Gesture gesture;
	private int score;
	private String displayName = null;
	
	public Player() {
		// placeholder to enable empty DisplayName
	}
	public Player(String nameToDisplay) {
		this.setDisplayName(nameToDisplay); 
	}
	public Gesture getGesture() {
		return gesture;
	}

	public void setGesture(Gesture gesture) {
		this.gesture = gesture;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
