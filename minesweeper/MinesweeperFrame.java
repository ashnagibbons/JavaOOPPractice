package minesweeper;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MinesweeperFrame extends JFrame {
	
	private JPanel mainJP;
	private MineGridJP myGrid;
	private Scoreboard myScoreboard;
	
	private Player myPlayer;
	private int count = 0;
	
	public MinesweeperFrame() {
		myPlayer = new Player();
		
		mainJP = new JPanel();
		mainJP.setLayout(new GridLayout(2,1));
		add(mainJP);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,500);
		pack();
		
		myGrid = new MineGridJP();
		myScoreboard = new Scoreboard();
		//add panel for the scoreboard first so it goes on top
		mainJP.add(myScoreboard);
		myScoreboard.jlCurrPlayerName.setText(myPlayer.getPlayerName());
		myScoreboard.jlCurrPlayerNumWins.setText(String.valueOf(myPlayer.getNumWins()));
		mainJP.add(myGrid);
		
	}//end constructor
		
	class MineGridJP extends JPanel implements ActionListener {
		
		private static Grid myGrid = new Grid();
		private JButton[][] board;
		private static final int NUM_ROWS = myGrid.getNumRows();
		private static final int NUM_COLS = myGrid.getNumColumns();
		
		public MineGridJP() {
			setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
			//this.setBackground(Color.getHSBColor(0, 255, 255));
			displayBoard();
		}//end constructor
		
		public void displayBoard() {
			board = new JButton[NUM_ROWS][NUM_COLS];
			Font countFont = new Font(Font.SANS_SERIF, Font.BOLD, 25); //check size and color later
			for (int row = 0; row < NUM_ROWS; row++) {
				for (int col = 0; col < NUM_COLS; col++) {
					board[row][col] = new JButton();
					board[row][col].setFont(countFont);
					board[row][col].setBackground(Color.green);
					board[row][col].addActionListener(this);
					board[row][col].setText("");
					board[row][col].setEnabled(true);
					board[row][col].setFocusable(false); 
					this.add(board[row][col]);
				}
			}
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			JButton btnClicked = (JButton) e.getSource();
			for (int i = 0; i < NUM_ROWS; i++) {
				for (int j = 0; j < NUM_COLS; j++) {
					if (btnClicked.equals(board[i][j])) {
						
						if(count <=1) {
							revealSurrounding(i, j);
						}
						
						if (myGrid.isBombAtLocation(i,j)) {
							lose();
						}
						else {
							btnClicked.setBackground(Color.white);
							btnClicked.setText((String.valueOf(myGrid.getCountAtLocation(i,j))));
							if (isWinner()) {
								win();
							}
							
						}
					}
				}
			}
			
			
		}
		
		public void revealSurrounding(int i, int j) {
			
			if (i-1 >= 0) {
				if (j-1 >= 0 && (!myGrid.isBombAtLocation(i-1, j-1))) {
				board[i-1][j-1].setText((String.valueOf(myGrid.getCountAtLocation(i-1,j-1))));
				}
				if ((!myGrid.isBombAtLocation(i-1, j))) {
				board[i-1][j].setText((String.valueOf(myGrid.getCountAtLocation(i-1,j))));
				}
				
				if (j+1 < NUM_COLS && (!myGrid.isBombAtLocation(i-1, j+1))) {
				board[i-1][j+1].setText((String.valueOf(myGrid.getCountAtLocation(i-1,j+1))));
				}
			}
			
			if (j-1 >= 0 && (!myGrid.isBombAtLocation(i, j-1))) {
			board[i][j-1].setText((String.valueOf(myGrid.getCountAtLocation(i,j-1))));
			}
			
			if (j+1 < NUM_COLS && (!myGrid.isBombAtLocation(i, j+1))) {
			board[i][j+1].setText((String.valueOf(myGrid.getCountAtLocation(i,j+1))));
			}
			
			if (i+1 < NUM_ROWS) {
				
				if (j-1 >= 0 && (!myGrid.isBombAtLocation(i+1, j-1))) {
				board[i+1][j-1].setText((String.valueOf(myGrid.getCountAtLocation(i+1,j-1))));
				}
				
				if ((!myGrid.isBombAtLocation(i+1, j))) {
				board[i+1][j].setText((String.valueOf(myGrid.getCountAtLocation(i+1,j))));
				}
				
				if (j+1 < NUM_COLS && (!myGrid.isBombAtLocation(i+1, j+1))) {
				board[i+1][j+1].setText((String.valueOf(myGrid.getCountAtLocation(i+1,j+1))));
				}
			}
		}
		
		public void lose() {
			for (int row = 0; row < NUM_ROWS; row++) {
				for (int col = 0; col < NUM_COLS; col++) {
					if (!(myGrid.isBombAtLocation(row, col))) {
						board[row][col].setBackground(Color.white);
						board[row][col].setText((String.valueOf(myGrid.getCountAtLocation(row,col))));
					}
					else {
						//put bomb icons on all bombs
					}
			
				}
			}
			myPlayer.addNumLosses();
			myScoreboard.jlCurrPlayerNumLosses.setText(String.format("%02d", myPlayer.getNumLosses()));
			playAgain();
		}
		
		public void win() {
			//put bomb icons on all bombs
			myPlayer.addNumWins();
			myScoreboard.jlCurrPlayerNumWins.setText(String.format("%02d", myPlayer.getNumWins()));
			playAgain();
		}
		
		public boolean isWinner() {
			boolean isWinner = true;
			
			for (int row = 0; row < NUM_ROWS; row++) {
				for (int col = 0; col < NUM_COLS; col++) {
					if (!(myGrid.isBombAtLocation(row, col))) {
						if ((board[row][col].getText().equals(""))) {
							isWinner = false;
							break;
						}
						
					}
				}
			}
			return isWinner;
		}
		
		public void playAgain() {
			int yesNo = JOptionPane.showConfirmDialog(null, "Play again?", "Yes or no", JOptionPane.YES_NO_OPTION);
			if (yesNo == JOptionPane.YES_OPTION) {
				reset();
			}
			else {
				System.exit(EXIT_ON_CLOSE);
			}
		}
		
		public void reset() {
			count = 0;
			myGrid = new Grid();
			for (int row = 0; row < NUM_ROWS; row++) {
				for (int col = 0; col < NUM_COLS; col++) {
					board[row][col].setText("");
					board[row][col].setEnabled(true);
				}
		}
		}
	
		
		
		
		
		//TODO
		/*update the scoreboard
		 */
		
	}//end of gridJP class
	
	class Scoreboard extends JPanel {
		private JLabel jlCurrPlayerName, jlCurrPlayerNumWins, jlForCurrPlayer, jlForNumWins, jlForNumLosses, jlCurrPlayerNumLosses;
		
		public Scoreboard () {
			setLayout(new GridLayout(3,2));
			jlForCurrPlayer = new JLabel("Current Player");
			jlCurrPlayerName = new JLabel("------");
			jlForNumWins = new JLabel("Number of Wins");
			jlCurrPlayerNumWins = new JLabel("---");
			jlForNumLosses = new JLabel("Number of Losses");
			jlCurrPlayerNumLosses = new JLabel("--");
			
			JLabel[] myJLabels  = {jlForCurrPlayer, jlCurrPlayerName, jlForNumWins, jlCurrPlayerNumWins, jlForNumLosses, jlCurrPlayerNumLosses};
			
			for (int i = 0; i < myJLabels.length; i++) {
				myJLabels[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
				this.add(myJLabels[i]);
			}
			
		}//end of constructor
		
	}//end of class
			
			
		
		
}




