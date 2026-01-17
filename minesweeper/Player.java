package minesweeper;

import java.util.Objects;

public class Player {
	
	private String playerSymbol;
	private String playerName;
	private int numGames, numWins, numLosses;
	
	public Player() {
		playerSymbol = " * ";
		playerName = "Player 1";
		numGames = 0;
		numWins = 0;
		numLosses = 0;
		
	}
	
	public Player (String name) {
		this();
		playerSymbol = (name != null) ? (" " + name.charAt(0)) : " * ";
		if (name!= null) {playerName = name;}
	}
	
	public Player (String name, String symbol) {
		this();
		playerSymbol = symbol;
		playerName = (name != null) ? name : "Player 1";
	}
	
	protected void addNumWins() {
		numGames++;
		numWins++;
	}
	
	protected void addNumLosses() {
		numGames++;
		numLosses++;
	}

	public String getPlayerSymbol() {
		return playerSymbol;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getNumGames() {
		return numGames;
	}

	public int getNumWins() {
		return numWins;
	}

	public int getNumLosses() {
		return numLosses;
	}

	@Override
	public String toString() {
		return "Player [playerSymbol=" + playerSymbol + ", playerName=" + playerName + ", numGames=" + numGames
				+ ", numWins=" + numWins + ", numLosses=" + numLosses + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numGames, numLosses, numWins, playerName, playerSymbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return numGames == other.numGames && numLosses == other.numLosses && numWins == other.numWins
				&& Objects.equals(playerName, other.playerName) && Objects.equals(playerSymbol, other.playerSymbol);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
