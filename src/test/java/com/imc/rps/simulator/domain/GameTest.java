package com.imc.rps.simulator.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class GameTest {

	@Test
	public void shouldHaveAWinner() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);
		game.saveMatch(match);
		Boolean actual = game.hasAWinner();
		boolean expected = true;

		assertEquals(actual, expected);
	}

	@Test
	public void shouldNotHaveAWinner() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);
		game.saveMatch(match);
		Boolean actual = game.hasAWinner();
		boolean expected = false;

		assertEquals(actual, expected);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotThrowRunTimeException() throws RuntimeException {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);
		//game.saveRound(match); // To Test
		game.hasAWinner();
		
		
	}

	@Test
	public void shouldReportThreeRounds() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Match match = new Match(game.getPlayer1(), game.getPlayer2());
		// 1
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);
		match.addMatchResult(result);
		
		game.saveMatch(match);

		match = new Match(game.getPlayer1(), game.getPlayer2());
		// 2
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		round = new Round();
		result = round.play(player1, player2);
		match.addMatchResult(result);
		game.saveMatch(match);

		match = new Match(game.getPlayer1(), game.getPlayer2());
		// 3
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		round = new Round();
		result = round.play(player1, player2);
		match.addMatchResult(result);
		round.play(player1, player2);
		game.saveMatch(match);

		int actual = game.getFinishedMatches().size();
		int expected = 3;

		assertEquals(actual, expected);
	}

}
