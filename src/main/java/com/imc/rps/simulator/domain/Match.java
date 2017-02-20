package com.imc.rps.simulator.domain;

import java.util.ArrayList;
import java.util.List;

import com.imc.rps.simulator.model.Result;

public class Match {
	
	private List<Result> listOfMatchsResults = new ArrayList<Result>();
	private Player player2;
	private Player player1;
	private int matchesToPlayAtThisRound = 0;
	
	public Player getPlayer2() {
		return player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		
	}
	
	public Match(Player player1, Player player2, int matchesToPlayAtThisRound) {
		this.player1 = player1;
		this.player2 = player2;
		this.matchesToPlayAtThisRound = matchesToPlayAtThisRound;
	}
	
	
	public void addMatchResult(Result result){
		
		this.listOfMatchsResults.add(result);
	}
	
	public List<Result> getMatchResults(){
		return this.listOfMatchsResults;
	}
	
	public int getNumberOfRounds(){
		return this.listOfMatchsResults.size();
	}
	
	
	public int getWinsPlayer1(){
		return (int) this.listOfMatchsResults.stream().filter( r -> r == Result.PLAYER1).count();
	}
	
	public int getWinsPlayer2(){
		return (int) this.listOfMatchsResults.stream().filter( r -> r == Result.PLAYER2).count();
	}
	
	public int getDRAWsCount(){
		return (int) this.listOfMatchsResults.stream().filter( r -> r == Result.DRAW).count();
	}
	
	public boolean hasRoundAWinner(){
		double numberOfMatchesToPlay = (this.matchesToPlayAtThisRound + this.getDRAWsCount()  )/ 2; // "Discount" the number of DRAW's
		if(numberOfMatchesToPlay % 1 == 0 ){
			if(this.getWinsPlayer1() > numberOfMatchesToPlay || this.getWinsPlayer2() > numberOfMatchesToPlay)
				return true;
		}else{
			 numberOfMatchesToPlay = Math.ceil(numberOfMatchesToPlay);
			 if(this.getWinsPlayer1() == numberOfMatchesToPlay || this.getWinsPlayer2() == numberOfMatchesToPlay)
					return true;
		}
		
		return false;
	}
	
	public Player getRoundWinner(){
		if(this.getWinsPlayer1() > this.getWinsPlayer2()){
			return this.player1;
		}else{
			return this.player2;
		}
	}

}
