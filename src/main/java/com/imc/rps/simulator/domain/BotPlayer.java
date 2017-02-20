package com.imc.rps.simulator.domain;

import java.util.Random;

import com.imc.rps.simulator.model.Gesture;

public class BotPlayer extends Player {
	public BotPlayer() {
		//placeholder to enable empty DisplayName
	}
	public BotPlayer(String nameToDisplay) {
		super(nameToDisplay);
		
	}

	private Random random = new Random();
//
//	public Gesture play() {
//		int randomNumber = random.nextInt(Gesture.values().length);
//		setGesture(Gesture.values()[randomNumber]);
//		return getGesture();
//	}
	
	public Gesture getGesture() {
		int randomNumber = random.nextInt(Gesture.values().length);
        setGesture(Gesture.values()[randomNumber]);
        return super.getGesture();
	}
}
