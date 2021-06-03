import java.awt.Graphics;

public class Grid {
	public Cell[][] currentGrid;
	public Cell[][] futureGrid;
	
	private int height,width;
	private int rows;
	private int cols;
	private int cellSize;
	
	Grid(int width,int height,int cellSize){
		rows = (int)(height/cellSize);
		cols = (int)(width/cellSize);
		this.cellSize = cellSize;
		this.height = height;
		this.width = width;
		init();
	}
	
	private void init() {
		currentGrid = new Cell[rows][cols];
		futureGrid = new Cell[rows][cols];
		for(int r = 0;r < rows;r++) {
			for(int c =0; c<cols ;c++) {
				currentGrid[r][c] = new Cell(r,c,cellSize);
				currentGrid[r][c].setRandomState();
				futureGrid[r][c] = new Cell(r,c,cellSize);
			}
		}	
		
		
	}

	
	public void setFutureGrid() {
		for(int r = 0;r < rows;r++) {
			for(int c =0; c<cols ;c++) {
				futureGrid[r][c].setState(checkStateFor(currentGrid[r][c]));
			}
		}
		Cell[][] temp;
		temp = currentGrid;
		currentGrid = futureGrid;
		futureGrid = temp;
		
	}
	
	private boolean checkStateFor(Cell current) {
		int nb = countNeighbor(current);
		if(current.getState() == false && nb == 3) {
			return true;
		}else if (current.getState() == true && (nb < 2 || nb > 3)) {
			return false;
		}else {
			return current.getState();
		}
	}

	
	
	
	
	
	public void drawGrid(Graphics g) {
		
		for(int r = 0;r < rows;r++) {
			for(int c =0;c < cols;c++) {
				
				currentGrid[r][c].drawCell(g);
			}
	
		}
		
	}
	
	
	public int countNeighbor(Cell current) {
		int result = 0;
		for (int r = current.getRow()-1;r<=current.getRow()+1;r++ ) {
			for (int c = current.getCol()-1;c<=current.getCol()+1;c++ ) {
				if(r == current.getRow() && c == current.getCol())
					continue;
				if(currentGrid[(r+rows)%rows][(c+cols)%cols].getState())
					result++;
			}
		}
		
		return result;
	}
	
	
	//this is just for fun
	public void makeGlider() {
		
		for(int r = 0;r < rows;r++) {
			for(int c =0;c < cols;c++) {
				currentGrid[r][c].setState(false);
			}
		}
		
		currentGrid[0][1].setState(true);
		currentGrid[1][2].setState(true);
		currentGrid[2][0].setState(true);
		currentGrid[2][1].setState(true);
		currentGrid[2][2].setState(true);
		
		
		
		
		
	}
	
}
