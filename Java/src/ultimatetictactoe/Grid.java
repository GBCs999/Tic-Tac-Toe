package ultimatetictactoe;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.util.EnumMap;

/**
 * Represents the main grid of the game, consisting of subgrids.
 */
public class Grid extends JPanel {
	private static final long serialVersionUID = 1L;
	private static Subgrid[][] subgrids;
	private static final EnumMap<Subgrid.State, Grid.State> STATE_MAP = new EnumMap<>(Subgrid.State.class) {
		private static final long serialVersionUID = 1L;
		{
			put(Subgrid.State.CROSS, Grid.State.CROSS);
		    put(Subgrid.State.CIRCLE, Grid.State.CIRCLE);
		    put(Subgrid.State.EMPTY, Grid.State.EMPTY);
		}
	};
	
	/**
	 * The possible states of a grid.
	 */
	public enum State {
		EMPTY, CROSS, CIRCLE, TIED
	}
	
	/**
	 * Initializes the main grid, and fills it with subgrids.
	 */
	public Grid() {
		setLayout(new GridLayout(Game.GRID_SIZE, Game.GRID_SIZE));
		subgrids = new Subgrid[Game.GRID_SIZE][Game.GRID_SIZE];
		
        for (int i = 0; i < Game.GRID_SIZE; i++) {
            for (int j = 0; j < Game.GRID_SIZE; j++) {
            	subgrids[i][j] = new Subgrid(i, j);
            	add(subgrids[i][j]);
            }
        }
	}
	
	public Subgrid getSubgrid(int row, int col) {
        return subgrids[row][col];
    }
	
	/**
     * Enables all subgrids in the grid when a step is made into a disabled subgrid.
     */
	public void enableAllSubgrids() {
	    for (int i = 0; i < Game.GRID_SIZE; i++) {
	        for (int j = 0; j < Game.GRID_SIZE; j++) {
	        	subgrids[i][j].toggleSubgrid(true);
	        }
	    }
	}
	
	/**
     * Checks for the global winner in the main grid.
     * 
     * @return The state of the grid.
     */
	public State checkWinner() {
		// Check horizontal lines
		for (int row = 0; row < Game.GRID_SIZE; row++) {
			if (isLineWon(subgrids[row][0], subgrids[row][1], subgrids[row][2])) {
				return STATE_MAP.get(subgrids[row][0].getState());
			}
		}

		// Check vertical lines
		for (int col = 0; col < Game.GRID_SIZE; col++) {
			if (isLineWon(subgrids[0][col], subgrids[1][col], subgrids[2][col])) {
				return STATE_MAP.get(subgrids[0][col].getState());
			}
		}

		// Check diagonal lines
		if (isLineWon(subgrids[0][0], subgrids[1][1], subgrids[2][2]) ||
			isLineWon(subgrids[0][2], subgrids[1][1], subgrids[2][0])) {
			return STATE_MAP.get(subgrids[1][1].getState());
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
	 * @param subgrid1
	 * @param subgrid2
	 * @param subgrid3
	 * @return If neither states are empty, and all 3 are the same.
	 */
	private boolean isLineWon(Subgrid subgrid1, Subgrid subgrid2, Subgrid subgrid3) {
		Subgrid.State state1 = subgrid1.getState();
		Subgrid.State state2 = subgrid2.getState();
		Subgrid.State state3 = subgrid3.getState();
		
		return state1 != Subgrid.State.EMPTY && state1 == state2 && state2 == state3;
	}

	/**
	 * Check if the game is tied for the main grid.
	 * 
	 * @return false if there is at least one empty subgrid, true if there aren't any empty subgrids.
	 */
	private boolean isTied() {
		for (int i = 0; i < Game.GRID_SIZE; i++) {
			for (int j = 0; j < Game.GRID_SIZE; j++) {
				if (subgrids[i][j].getState() == Subgrid.State.EMPTY) {
					return false; // If any subgrid is empty, the game is not tied
				}
			}
		}

		// If all subgrids are filled and there is no winner, then the game is tied
		return true;
	}
}