//package minesweeper;
//VIDEO LINK: https://youtu.be/3yhMM2W_avA
import java.util.Random;


public class Grid {
	
	private boolean[][] bombGrid;
	private int[][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		this.createBombGrid();
		this.createCountGrid();
	}
	
	public Grid(int rows, int columns) {
		numRows = rows;
		numColumns = columns;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		this.createBombGrid();
		this.createCountGrid();
		
	}
	
	public Grid(int rows, int columns, int numBombs) {
		numRows = rows;
		numColumns = columns;
		this.numBombs = numBombs;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		this.createBombGrid();
		this.createCountGrid();
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public int getNumBombs() {
		return numBombs;
	}
	
	public boolean[][] getBombGrid() {
		boolean[][] newGrid = new boolean[numRows][numColumns];
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				newGrid[i][j] = bombGrid[i][j];
			}
		}
		
		return newGrid;
	}
	
	public int[][] getCountGrid() {
		int[][] newGrid = new int[numRows][numColumns];
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				newGrid[i][j] = countGrid[i][j];
			}
		} 
		
		return newGrid;
	}
	
	public boolean isBombAtLocation(int row, int column) {
		
		if ((row >= 0 && row < numRows) && (column >= 0 && column < numColumns)) {
			return bombGrid[row][column];
		}
		else {
			return false;
		}
	}
	
	public int getCountAtLocation(int row, int column) {
		
		return countGrid[row][column];
	}
	
	private void createBombGrid() {
		boolean[][] daNewGrid = new boolean[numRows][numColumns];
		Random myRand = new Random();
		int currentRow = myRand.nextInt(numRows);
		int currentColumn = myRand.nextInt(numColumns);
		int count = 0;
		
		while (count < numBombs) {
			if (!(daNewGrid[currentRow][currentColumn])) {
				daNewGrid[currentRow][currentColumn] = true;
				count++;
			}
			currentRow = myRand.nextInt(numRows);
			currentColumn = myRand.nextInt(numColumns);
		}
		
		this.bombGrid = daNewGrid;
	}
	
	
	
	private void createCountGrid() {
		int[][] myCountGrid = new int[numRows][numColumns];
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				//check there is a cell above, check there is a cell to the right, check a cell below, check a cell to the left
				int adjBombs = 0;
				
				if (isBombAtLocation(i-1, j-1)) {
					adjBombs++;
				}
				if (isBombAtLocation(i-1, j)) {
					adjBombs++;
				}
				if (isBombAtLocation(i-1,j+1)) {
					adjBombs++;
				}
				if(isBombAtLocation(i,j-1)) {
					adjBombs++;
				}
				if(isBombAtLocation(i,j+1)) {
					adjBombs++;
				}
				if(isBombAtLocation(i+1, j-1)) {
					adjBombs++;
				}
				if(isBombAtLocation(i+1, j)) {
					adjBombs++;
				}
				if(isBombAtLocation(i+1,j+1)) {
					adjBombs++;
				}
				if(isBombAtLocation(i,j)) {
					adjBombs++;
				}
				
				
				
				myCountGrid[i][j] = adjBombs;
				
			}
		}
		
		this.countGrid = myCountGrid;
		
		//TODO for first and last row and first and last column, code has to be different so no null exception
	}
	
	

}
