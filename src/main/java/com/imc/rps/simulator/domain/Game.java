package com.imc.rps.simulator.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Player player1;
	private Player player2;
	private List<Match> listOfFinisedMatches = new ArrayList<Match>();
	
	public Game() {
		// assume botPlayer
		//initBotGame();
	}
	
	public Game(Player player1 , Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
//	public void initBotGame() {
//		this.player1 = new BotPlayer("TARS [-]");
//		this.player2 = new Player("You :)");
//	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void saveMatch(Match match) {
		this.listOfFinisedMatches.add(match);
		
	}
	
	public List<Match> getFinishedMatches(){
		return this.listOfFinisedMatches;
	}
	
	public int getWinsPlayer1(){
		int count = 0;
		for (Match round : this.listOfFinisedMatches) {
			count += round.getWinsPlayer1();
		}
		return count;
		
	}
	
	public int getWinsPlayer2(){
		int count = 0;
		for (Match round : this.listOfFinisedMatches) {
			count += round.getWinsPlayer2();
		}
		return count;
		
	}
	
	public int getDRAWsCount(){
		int count = 0;
		for (Match round : this.listOfFinisedMatches) {
			count += round.getDRAWsCount();
		}
		return count;
		
	}
	
	public int getNumberOfMatches(){ // just Valid
		int count = 0;
		for (Match match : listOfFinisedMatches) {
			count += match.getMatchResults().size();
		}
		return count;
	}
	
	public boolean hasAWinner(){
		if(this.listOfFinisedMatches.size() == 0) throw new RuntimeException("There is no Rounds at the Game.");
		if(this.getGameWinner() != null){
			return true;
		}
		return false;
	}
	
	public Player getGameWinner(){
		if(this.getWinsPlayer1() > this.getWinsPlayer2())
			return this.getPlayer1();
		else if (this.getWinsPlayer1() < this.getWinsPlayer2())
			return this.getPlayer2();
		else return null;
	}
	
}