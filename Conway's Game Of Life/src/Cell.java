import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cell{
	private int x;
	private int y;
	private int row;


	private int col;

	private int cellSize;
	private boolean state; //true = alive , false = dead
	Cell(int row,int col,int cellSize){
		this.row = row;
		this.col = col;
		this.cellSize = cellSize;
		y = row*cellSize;
		x = col*cellSize;
	}
	
	public void drawCell(Graphics g) {
		
		if(state) {
			g.setColor(new Color(91, 132, 177));
			g.fillRect(x, y, cellSize, cellSize);
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, cellSize, cellSize);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	
	public void setRandomState() {
		/*
		int temp = new Random().nextInt(100)+1;
		if(temp<=50) {
			this.state = true;
			return;
		}
		this.state = false;
		*/
		this.state = new Random().nextBoolean();
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
