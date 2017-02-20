package com.imc.rps.simulator.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class RoundTest {

	@Test
	public void shouldHaveTreeMatchesPlayed() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Round round = new Round(game.getPlayer1(), game.getPlayer2());
		// 1
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Match match = new Match();
		Result result = match.play(player1, player2);
		round.addMatchResult(result);

		// 2
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		match = new Match();
		result = match.play(player1, player2);
		round.addMatchResult(result);

		// 3
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		match = new Match();
		result = match.play(player1, player2);
		round.addMatchResult(result);
		
		int actual = round.getMatchResults().size();
		int expected = 3; 
		assertEquals(expected, actual);
	}

}
