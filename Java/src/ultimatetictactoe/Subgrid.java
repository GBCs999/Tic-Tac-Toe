package ultimatetictactoe;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.EnumMap;

/**
 * Represents a subgrid within the main grid, consisting of cells.
 */
public class Subgrid extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int SIZE = 150;
	private static final int FONT_SIZE = 90;
	private static final int BORDER_WIDTH = 2;
	private static final EnumMap<Cell.State, Subgrid.State> STATE_MAP = new EnumMap<>(Cell.State.class) {
		private static final long serialVersionUID = 1L;
		{
			put(Cell.State.CROSS, Subgrid.State.CROSS);
		    put(Cell.State.CIRCLE, Subgrid.State.CIRCLE);
		    put(Cell.State.EMPTY, Subgrid.State.EMPTY);
		}
	};
	
	private static final String DRAW_SIGN = "-";
	private static final EnumMap<Subgrid.State, String> STATE_SIGN_MAP = new EnumMap<>(Subgrid.State.class) {
	    private static final long serialVersionUID = 1L;
	    {
	        put(Subgrid.State.CROSS, Cell.Sign.CROSS.get());
	        put(Subgrid.State.CIRCLE, Cell.Sign.CIRCLE.get());
	        put(Subgrid.State.TIED, DRAW_SIGN);
	    }
	};
	
	/**
	 * The possible states of a subgrid.
	 */
	public enum State {
		EMPTY, CROSS, CIRCLE, TIED
	}
	
	private State state;
	private Cell[][] cells;
	private int row;
	private int col;
	
	/**
	 * Initializes the subgrid with the specified row and column indices, and fills it with cells.
	 * 
	 * @param row The row index of the subgrid.
	 * @param col The column index of the subgrid.
	 */
	public Subgrid(int row, int col) {
		this.row = row;
		this.col = col;
		this.state = State.EMPTY;
		this.cells = new Cell[Game.GRID_SIZE][Game.GRID_SIZE];
		
		setLayout(new GridLayout(Game.GRID_SIZE, Game.GRID_SIZE));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, BORDER_WIDTH));
		
        for (int i = 0; i < Game.GRID_SIZE; i++) {
            for (int j = 0; j < Game.GRID_SIZE; j++) {
                cells[i][j] = new Cell(i, j);
                add(cells[i][j]);
                cells[i][j].setEnabled(true);
                cells[i][j].setBackground(Color.white);
            }
        }
	}
	
	public Cell getCell(int i, int j) {
		return cells[i][j];
	}
	
	public State getState() {
		return state;
	}

	public void setState(State newState) {
		state = newState;
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
	
	public boolean isEmpty() {
		return state == State.EMPTY;
	}
	
	public boolean isPlayed() {
		return state != State.EMPTY;
	}
	
	/**
     * Toggles the color and the enabled state of all cells in the subgrid.
     * 
     * @param isActive True to enable, false to disable.
     */
	public void toggleSubgrid(boolean isActive) {
	    for (int i = 0; i < Game.GRID_SIZE; i++) {
            for (int j = 0; j < Game.GRID_SIZE; j++) {
                Cell cell = getCell(i, j);
                Color cellColor = isActive ? Color.WHITE : Color.LIGHT_GRAY;
                cell.setBackground(cellColor);
                cell.setEnabled(isActive);
            }
        }
	}
	
	/**
     * Replaces a won subgrid with the winning sign.
     * 
     * @param winner The winner of the subgrid.
     */
	public void replaceWonSubgrid(Subgrid.State winner) {
		Game.grid.remove(this);

	    Cell filledSubgrid = new Cell(row, col);
	    filledSubgrid.setCellStyle(Subgrid.SIZE, Subgrid.FONT_SIZE, Subgrid.BORDER_WIDTH);
	    filledSubgrid.setContentAreaFilled(false);
	    filledSubgrid.setEnabled(false);
	    filledSubgrid.setText(STATE_SIGN_MAP.get(winner));
	    
	    // Add the button back at the specified indexes
	    Game.grid.add(filledSubgrid, row * Game.GRID_SIZE + col);
	    Game.grid.revalidate();
	    Game.grid.repaint();
	}
	
	 /**
     * Checks for the local winner in the subgrid.
     * 
     * @return The state of the subgrid.
     */
	public State checkWinner() {
		// Check horizontal lines
		for (int row = 0; row < Game.GRID_SIZE; row++) {
			if (isLineWon(cells[row][0], cells[row][1], cells[row][2])) {
				return STATE_MAP.get(cells[row][0].getState());
			}
		}
		
		// Check vertical lines
		for (int col = 0; col < Game.GRID_SIZE; col++) {
			if (isLineWon(cells[0][col], cells[1][col], cells[2][col])) {
				return STATE_MAP.get(cells[0][col].getState());
			}
		}

		// Check diagonal lines
		if (isLineWon(cells[0][0], cells[1][1], cells[2][2]) ||
			isLineWon(cells[0][2], cells[1][1], cells[2][0])) {
			return STATE_MAP.get(cells[1][1].getState());
		}

		// Check for tie
		if (isTied()) {
			return State.TIED;
		}

		// If no winner and no tie, return EMPTY
		return State.EMPTY;
	}

	/**
	 * Check if a line has the same states.
	 * 
	 * @param cell1
	 * @param cell2
	 * @param cell3
	 * @return If neither states are empty, and all 3 are the same.
	 */
	private boolean isLineWon(Cell cell1, Cell cell2, Cell cell3) {
		Cell.State state1 = cell1.getState();
		Cell.State state2 = cell2.getState();
		Cell.State state3 = cell3.getState();
		
		return state1 != Cell.State.EMPTY && state1 == state2 && state2 == state3;
	}

	/**
	 * Check if the game is tied for a subgrid
	 * 
	 * @return false if there is at least one empty cell, true if there aren't any empty cells.
	 */
	private boolean isTied() {
		for (int i = 0; i < Game.GRID_SIZE; i++) {
			for (int j = 0; j < Game.GRID_SIZE; j++) {
				if (cells[i][j].getState() == Cell.State.EMPTY) {
					return false; // If any cell is empty, the subgrid is not tied
				}
			}
		}

		// If all cells are filled and there is no winner, then the subgrid is tied
		return true;
	}
}