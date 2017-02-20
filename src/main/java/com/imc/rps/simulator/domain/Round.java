package com.imc.rps.simulator.domain;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class Round {
	private Referee referee = new Referee();
	private Result result;

	String winnerName;
	
	Gesture player1Gesture;
	Gesture player2Gesture;
	
	public Gesture getPlayer1Gesture() {
		return player1Gesture;
	}

	public Gesture getPlayer2Gesture() {
		return player2Gesture;
	}


	public Result play(Player player1, Player player2 ) {
		this.player1Gesture = player1.getGesture();
		this.player2Gesture = player2.getGesture();
		this.result = referee.judge(player1Gesture, player2Gesture);

		if(this.result == Result.PLAYER1) winnerName =  player1.getDisplayName();
		else if(this.result == Result.PLAYER2) winnerName = player2.getDisplayName();
		
		return this.result;
	}

	public Result getResult(){
		return this.result;
	}
	
	public Boolean hasAWinner(){
		if(this.result != Result.DRAW) return true;
		
		return false;
	}
	
	public String getWinnerName(){
		return this.winnerName;
	}
	
}
