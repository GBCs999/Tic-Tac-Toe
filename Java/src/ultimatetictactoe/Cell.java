package ultimatetictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Represents a cell within a subgrid, allowing player interaction.
 */
public class Cell extends JButton {
	private static final long serialVersionUID = 1L;
	private static final int SIZE = 50;
	private static final int FONT_SIZE = 30;
	private static final int BORDER_WIDTH = 1;
	
	/**
	 * Represents the possible states of a cell.
	 */
	public enum State {
		EMPTY, CROSS, CIRCLE
	}
	
	/**
	 * Represents the possible signs (X and O) for the cell.
	 */
	public enum Sign {
		CROSS("X"), CIRCLE("O");

		private final String sign;

		private Sign(String sign) {
			this.sign = sign;
		}
		
		public String get() {
			return sign;
		}
	}
	
	private State state;
	private Sign sign;
	private int row;
	private int col;
	
	/**
     * Initializes the cell with the specified row and column indices.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.state = State.EMPTY;
		
		setCellStyle(SIZE, FONT_SIZE, BORDER_WIDTH);
		
		/**
	     * Configures mouse hover effects for the cell.
	     */
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (isEnabled()) {
					setBackground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (isEnabled()) {
					setBackground(Color.WHITE);
				}
			}
		});

		/**
	     * Configures action listener for the cell.
	     */
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getState() == Cell.State.EMPTY) {
					handleCellClick();
				}
			}
		});
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public String getSign() {
		return sign.get();
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
	
	/**
     * Sets the style attributes for the cell.
     *
     * @param dimension The size of the cell.
     * @param fontSize  The font size of the cell content.
     * @param borderWidth The width of the cell border.
     */
	public void setCellStyle(int dimension, int fontSize, int borderWidth) {
		setPreferredSize(new Dimension(dimension, dimension));
		setBackground(Color.WHITE);
		setFont(new Font("Arial", Font.BOLD, fontSize));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, borderWidth));
		setFocusPainted(false);
	}
	
	/**
     * Updates the state and sign of the cell based on the current turn.
     */
	private void updateCellState() {
		boolean isTurnEven = Game.round % 2 == 0;
		state = determineCellState(isTurnEven);
		sign = determineCellSign(isTurnEven);
		setText(getSign());
	}
	
	/**
     * Handles the click event on the cell, updating game state and UI.
     */
	private void handleCellClick() {
		Subgrid currentSubgrid = (Subgrid) getParent();
		
		if (currentSubgrid.isEmpty() && this.isEnabled()) {
			Game.round++;
			Game.roundLabel.setText("Round: " + (Game.round + 1));
			updateCellState();
			
			Game.prevStep = new Step(currentSubgrid.getRow(), currentSubgrid.getCol(), this.row, this.col);
			Game.prevStepLabel.setText("Previous Step: " + Game.prevStep.formatPrevStep());
			
			// Get the next turn's sign
			boolean isNextTurnEven = (Game.round + 1) % 2 == 0;
			Sign currentPlayerSign = determineCellSign(isNextTurnEven);
			Game.currentPlayerLabel.setText("Current Player: " + currentPlayerSign.get());
			
			Subgrid.State localWinner = currentSubgrid.checkWinner();
			
			if (localWinner != Subgrid.State.EMPTY) {
				currentSubgrid.setState(localWinner);
				currentSubgrid.replaceWonSubgrid(localWinner);
				
				Grid.State globalWinner = Game.grid.checkWinner();
				
				if (globalWinner != Grid.State.EMPTY) {
					Game.endGame(globalWinner);
				}
			}
			
			// Enable the subgrid of subgridRow and subgridCol based on prevStep's row and col
			for (int i = 0; i < Game.GRID_SIZE; i++) {
				for (int j = 0; j < Game.GRID_SIZE; j++) {
					Subgrid subgrid = Game.grid.getSubgrid(i, j);
					
					if (i == Game.prevStep.getRow() && j == Game.prevStep.getCol()) {
						Game.currentStep = new Step(i, j);
						
						// Check if a step is made into a played subgrid
						if (subgrid.isPlayed()) {
							Game.grid.enableAllSubgrids();
							return;
						}
						else {
							subgrid.toggleSubgrid(true);
						}
					}
					else {
						subgrid.toggleSubgrid(false);
					}
				}
			}
		}
	}
	
	/**
     * Determines the state of the cell based on the current turn.
     *
     * @param isTurnEven True if it's an even turn, false otherwise.
     * @return The state of the cell.
     */
	private State determineCellState(boolean isTurnEven) {
		return isTurnEven ? State.CIRCLE : State.CROSS;
	}
	
	/**
     * Determines the sign to be displayed on the cell based on the current turn.
     *
     * @param isTurnEven True if it's an even turn, false otherwise.
     * @return The sign to be displayed on the cell.
     */
	private Sign determineCellSign(boolean isTurnEven) {
		return isTurnEven ? Sign.CIRCLE : Sign.CROSS;
	}
}