package com.imc.rps.simulator.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;

public class RoundTest {

	@Test
	public void shouldBeThePlayer1TheWinner() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");

		// 1
		player1.setGesture(Gesture.SCISSORS);
		player2.setGesture(Gesture.PAPER);
		Round round = new Round();
		Result result = round.play(player1, player2);

		assertEquals(result, Result.PLAYER1);

	}

	@Test
	public void shouldBeThePLayer2TheWinner() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");

		// 1
		player1.setGesture(Gesture.ROCK);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);

		assertEquals(result, Result.PLAYER2);
	}

	@Test
	public void shouldBeDRAW() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");

		// 1
		player1.setGesture(Gesture.PAPER);
		player2.setGesture(Gesture.PAPER);

		Round round = new Round();
		Result result = round.play(player1, player2);

		assertEquals(result, Result.DRAW);
	}


}
