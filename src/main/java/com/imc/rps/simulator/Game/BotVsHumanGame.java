package com.imc.rps.simulator.Game;

import com.imc.rps.simulator.domain.BotPlayer;
import com.imc.rps.simulator.domain.Game;
import com.imc.rps.simulator.domain.Match;
import com.imc.rps.simulator.domain.Player;
import com.imc.rps.simulator.domain.Round;
import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.model.Result;
import com.imc.rps.simulator.util.ConsoleHelper;
import com.imc.rps.simulator.view.TerminalConsole;

public class BotVsHumanGame {
	
	private int matchesToPlayAtThisRound;
	private int matchesPlayed ;
	Player player1;
	Player player2;
	Round round;
	TerminalConsole terminal;
	public BotVsHumanGame() {
		player1 = new BotPlayer("TAR's");
		player2 = new Player("You");
		terminal = new TerminalConsole();
	}
	
	public void startGame(){
		terminal.cleanConsole();
		terminal.printGreeting();
		
		Game game = new Game(this.player1, this.player2);
		
		startRound(game); // at least one round always
		while(terminal.askForInitNewRound()){
		
			startRound(game);
		}
		
		terminal.printGameStats(game);
	}
	
	public void startRound(Game game){
		
		terminal.askNUmberOfRounds();
		int matchesToPlayAtThisRound = terminal.getNumberOfRounds();
		this.matchesToPlayAtThisRound = matchesToPlayAtThisRound;
		
		matchesPlayed = 1;
		round = new Round(game.getPlayer1(), game.getPlayer2());
		
		while(this.hasMoreMatchesToPlayInThisRound()){
			
			terminal.askGestureFromHuman(matchesPlayed);
			
			Gesture selectedGesture = terminal.getHumanGesture();
			this.player2.setGesture(selectedGesture);
			
			Match match = new Match();
			
			Result result = match.play(this.player1, this.player2);
			
			if(match.hasAWinner()){
				round.addMatchResult(result);
				terminal.printMatchResultMessage(match.getPlayer1Gesture(), match.getPlayer2Gesture(), match.getWinnerName());
				matchesPlayed++;
				this.nextMatch();
				
			}else{
				
				terminal.printDRAWMessage(match.getPlayer1Gesture());
				
			}
			
		}
		processFinishedRound(game, round);
	}

	private void processFinishedRound(Game game , Round round) {
		ConsoleHelper.logResult("");
		ConsoleHelper.logResult(">>>>>>> ROUND RESULTS <<<<<<<<");
		ConsoleHelper.logResult("Scores " 
								+ round.getPlayer1().getDisplayName() 
								+ " : " + round.getWinsPlayer1() + "  " 
								+ round.getPlayer2().getDisplayName() + " : "
								+ round.getWinsPlayer2());
		
		game.saveRound(round);
		
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
