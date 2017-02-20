package com.imc.rps.simulator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.imc.rps.simulator.domain.Game;
import com.imc.rps.simulator.model.Gesture;
import com.imc.rps.simulator.util.ConsoleHelper;

public class TerminalConsole {
	private Scanner sc ;
	private Gesture selectedHumanGesture;
	private int selectedNumberOfRounds;
	public void askGestureFromHuman(int matchSequency) {
		boolean answareIsnotValid = true;
		
		while (answareIsnotValid){
			ConsoleHelper.printQuestion("MATCH: " + matchSequency + " - Enter 1 -> Rock / 2 -> Paper / 3 -> Scissors: ");
			Scanner input = new Scanner(System.in);
			
			if(verifyIsHumanGestureIndexIsvalid(input )){
				answareIsnotValid = false;
			}else{
				printInvalidChoiceMessage();
			}
		}
		
	}
	
	public void askNUmberOfRounds(){
		boolean answareIsnotValid = true;
		while (answareIsnotValid){
			ConsoleHelper.printQuestion("Please enter the number of Match(es) you want to play: ");
			Scanner input = new Scanner(System.in);
			
			if(verifyNUmberOfRoundsIsValid(input )){
				answareIsnotValid = false;
			}else{
				printInvalidChoiceMessage();
			}
		}
	}
	
	private boolean verifyNUmberOfRoundsIsValid(Scanner input) {
		try {
			int choice = input.nextInt();

			if (choice < 1 || choice > 20)
				return false;
			else 
				this.selectedNumberOfRounds =choice ;
				return  true;
		} catch (InputMismatchException ex) {
			return false;
		}
	}

	public int getNumberOfRounds() {
		return this.selectedNumberOfRounds;
	}
	
	public boolean askForInitNewRound() {
		ConsoleHelper.printQuestion("Play it Again ? y/n: ");
		sc = new Scanner(System.in);
		if (sc.next().equalsIgnoreCase("y")) {
			ConsoleHelper.clearConsole();
			
			return true;
			
		}
		sc.close();
		return false;
	}
	
	private boolean verifyIsHumanGestureIndexIsvalid(Scanner gestureIndex){
		try {
			int choice = gestureIndex.nextInt();

			if (choice > 3)
				return false;
			else 
				this.setHumanGesture(choice);
				return  true;
		} catch (InputMismatchException ex) {
			return false;
		}
	}
	
	private void setHumanGesture(int gestureIndex){
		this.selectedHumanGesture = Gesture.values()[gestureIndex -1];
	}
	
	public Gesture getHumanGesture(){
		return this.selectedHumanGesture;
	}

	private void printInvalidChoiceMessage() {
		ConsoleHelper.printLog("C'Mon: Invalid choice ! Giving you another chance....");
	}
	
	public void printMatchResultMessage(Gesture player1Gesture, Gesture player2Gesture, String winnerName ){
		
		ConsoleHelper.printLog("(" + player1Gesture + "," + player2Gesture + ") -> Winner: " + winnerName);
	}

	public void printDRAWMessage(Gesture playerGesture){
		
		ConsoleHelper.printLog("DRAW !! Both played ["+ playerGesture + "] - Play again !");
		
	}

	public void printGameStats(Game game) {
		ConsoleHelper.logResult(">>>>>>> GAME STATS <<<<<<<<");
		ConsoleHelper.logResult("Number of Rounds: " + game.getFinishedRounds().size());
		ConsoleHelper.logResult("Number of Matches: " + game.getNumberOfMatches()); // just Valid
		ConsoleHelper.logResult(game.getPlayer1().getDisplayName() + " Score: " + game.getWinsPlayer1() );
		ConsoleHelper.logResult(game.getPlayer2().getDisplayName() + " Score: " + game.getWinsPlayer2() );
		if(game.hasAWinner())
			ConsoleHelper.printLog("Winner: " + game.getGameWinner().getDisplayName());
		else
			ConsoleHelper.printLog("GAME: DRAW :/");
	}

	public void printGreeting() {

		ConsoleHelper.printLog("Welcome to the IMC's Rock Paper Scissors Game !");
		
	}
	public void cleanConsole(){
		ConsoleHelper.clearConsole();
	}
}
