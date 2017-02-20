
package com.imc.rps.simulator.domain;

import static com.imc.rps.simulator.model.Result.DRAW;
import static com.imc.rps.simulator.model.Result.PLAYER1;
import static com.imc.rps.simulator.model.Result.PLAYER2;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class Referee {

	private Result[][] results = {
			// Rock,	Paper, 		Scissors
			{DRAW, 		PLAYER2, 	PLAYER1}, 	// Rock
			{PLAYER1, 	DRAW, 		PLAYER2}, 	// Paper
			{PLAYER2, 	PLAYER1, 	DRAW}  		// Scissors
	};
	
	public Result judge(Gesture gesture1, Gesture gesture2){
		return results[gesture1.ordinal()][gesture2.ordinal()];
	}
	
}
