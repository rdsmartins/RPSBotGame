package com.imc.rps.simulator.game;

import com.imc.rps.simulator.domain.BotPlayer;
import com.imc.rps.simulator.domain.Game;
import com.imc.rps.simulator.domain.Round;
import com.imc.rps.simulator.domain.Player;
import com.imc.rps.simulator.domain.Match;
import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;
import com.imc.rps.simulator.view.TerminalConsole;

public class BotVsHumanGame {
	
	private int matchesToPlayAtThisRound;
	private int roundsPlayed ;
	Player player1;
	Player player2;
	Match match;
	TerminalConsole terminal;
	int matchesPlayed;
	public BotVsHumanGame() {
		player1 = new BotPlayer("TAR's"); 
		player2 = new Player("You");
		terminal = new TerminalConsole();
		matchesPlayed = 1;
	}
	
	public void startGame(){
		terminal.cleanConsole();
		terminal.printGreeting();
		
		Game game = new Game(this.player1, this.player2);
		
		startMatch(game); // at least one round always
		while(terminal.askForInitNewRound()){
			this.matchesPlayed++;
			startMatch(game);
		}
		
		terminal.printGameStats(game);
	}
	
	public void startMatch(Game game){
		terminal.printMatchNumber(this.matchesPlayed);
		terminal.askNUmberOfRounds();
		this.matchesToPlayAtThisRound = terminal.getNumberOfRounds();
		
		roundsPlayed = 1;
		match = new Match(game.getPlayer1(), game.getPlayer2() , this.matchesToPlayAtThisRound);
		
		while(this.hasMoreMatchesToPlayInThisRound() && !match.hasRoundAWinner()){
			
			terminal.askGestureFromHuman(roundsPlayed);
			
			Gesture selectedGesture = terminal.getHumanGesture();
			this.player2.setGesture(selectedGesture);
			
			Round round = new Round();
			
			Result result = round.play(this.player1, this.player2);
			
			if(round.hasAWinner()){
				match.addMatchResult(result);
				terminal.printMatchResultMessage(round.getPlayer1Gesture(), round.getPlayer2Gesture(), round.getWinnerName());
				roundsPlayed++;
				this.nextMatch();
				
			}else{
				
				terminal.printDRAWMessage(round.getPlayer1Gesture());
				
			}
			
		}
		processFinishedRound(game, match);
	}

	private void processFinishedRound(Game game , Match match) {
		terminal.printMatchStats(match);
		
		game.saveMatch(match);
		
	}
	
	private boolean hasMoreMatchesToPlayInThisRound(){
		if(this.matchesToPlayAtThisRound > 0){
			return true;
		}
		return false;
	}
	public void nextMatch(){
		this.matchesToPlayAtThisRound--;
	}
	
}
