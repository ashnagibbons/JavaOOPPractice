package minesweeper;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GridJP extends JPanel implements MouseListener{
	
	private final int MAX_X, MAX_Y, CELL_WIDTH, CELL_HEIGHT;
	
	public GridJP() {
	MAX_X = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	MAX_Y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	CELL_WIDTH = MAX_X/10;
	CELL_HEIGHT = MAX_Y/10;
	addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//box is clicked
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void boxClicked(int x, int y) {
		//do stuff to the cell in the location where it was clicked?
	}
	

}
