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
		Round round = new Round(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Match match = new Match();
		Result result = match.play(player1, player2);
		round.addMatchResult(result);
		game.saveRound(round);
		Boolean actual = game.hasAWinner();
		boolean expected = true;

		assertEquals(actual, expected);
	}

	@Test
	public void shouldNotHaveAWinner() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Round round = new Round(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Match match = new Match();
		Result result = match.play(player1, player2);
		round.addMatchResult(result);
		game.saveRound(round);
		Boolean actual = game.hasAWinner();
		boolean expected = false;

		assertEquals(actual, expected);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotThrowRunTimeException() throws RuntimeException {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Round round = new Round(game.getPlayer1(), game.getPlayer2());

		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Match match = new Match();
		Result result = match.play(player1, player2);
		round.addMatchResult(result);
		//game.saveRound(round); // To Test
		game.hasAWinner();
		
		
	}

	@Test
	public void shouldReportThreeRounds() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Game game = new Game(player1, player2);
		Round round = new Round(game.getPlayer1(), game.getPlayer2());
		// 1
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Match match = new Match();
		Result result = match.play(player1, player2);
		round.addMatchResult(result);
		
		game.saveRound(round);

		round = new Round(game.getPlayer1(), game.getPlayer2());
		// 2
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		match = new Match();
		result = match.play(player1, player2);
		round.addMatchResult(result);
		game.saveRound(round);

		round = new Round(game.getPlayer1(), game.getPlayer2());
		// 3
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		match = new Match();
		result = match.play(player1, player2);
		round.addMatchResult(result);
		match.play(player1, player2);
		game.saveRound(round);

		int actual = game.getFinishedRounds().size();
		int expected = 3;

		assertEquals(actual, expected);
	}

}
