package com.imc.rps.simulator.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class MatchTest {

	@Test
	public void shouldHaveTreeMatchesPlayed() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2());
		// 1
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);

		// 2
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		round = new Round();
		result = round.play(player1, player2);
		match.addMatchResult(result);

		// 3
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		round = new Round();
		result = round.play(player1, player2);
		match.addMatchResult(result);
		
		int actual = match.getMatchResults().size();
		int expected = 3; 
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldHaveBestOfResultAndShouldBePlayer2() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2(), 3); // Important number 3
		// 1
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);

		// 2
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		round = new Round();
		result = round.play(player1, player2);
		match.addMatchResult(result);

		boolean actual = match.hasRoundBestOfWinner();
		boolean expected = true; 
		
		Player actual2 = match.getRoundWinner();
		Player expected2 = player2;
		
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);
	}

}
