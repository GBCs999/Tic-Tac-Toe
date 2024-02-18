package ultimatetictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int GRID_SIZE = 3;
	private static final int LABEL_FONT_SIZE = 24;
	private static final int THIN_BORDER_WIDTH = 1;
	private static final int THICK_BORDER_WIDTH = 2;
	private static final int SMALL_CELL_SIZE = 50;
	private static final int LARGE_CELL_SIZE = 150;
	private static final int SMALL_CELL_FONT_SIZE = 30;
	private static final int LARGE_CELL_FONT_SIZE = 90;

	private JLabel roundLabel;
	private int round = 0;

	private JLabel prevStepLabel;
	private Step prevStep;

	private JLabel currentSubgridLabel;
	private Step currentSubgrid;

	private final Cell[][][][] board;
	private final Grid[][] subgrids;
	private final JPanel[][] subgridLayout;
	private final JPanel boardLayout;
	
	public Game() {
		JPanel roundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		roundLabel = new JLabel("Round: " + (round + 1));
		setBaseFont(roundLabel);
		roundPanel.add(roundLabel);

		JPanel prevStepPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		prevStepLabel = new JLabel("Previous Step: None");
		setBaseFont(prevStepLabel);
		prevStepPanel.add(prevStepLabel);

		JPanel currentSectorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		currentSubgridLabel = new JLabel("Current Step: All");
		setBaseFont(currentSubgridLabel);
		currentSectorPanel.add(currentSubgridLabel);

		JPanel statsPanel = new JPanel(new BorderLayout());
		statsPanel.add(roundPanel, BorderLayout.NORTH);
		statsPanel.add(prevStepPanel, BorderLayout.CENTER);
		statsPanel.add(currentSectorPanel, BorderLayout.SOUTH);

		JPanel boardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		board = initBoard();
		subgrids = initSubgrids();
		subgridLayout = new JPanel[GRID_SIZE][GRID_SIZE];
		boardLayout = createBoardLayout();
		boardPanel.add(boardLayout);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(statsPanel, BorderLayout.NORTH);
		pane.add(boardPanel, BorderLayout.CENTER);

		currentSubgrid = new Step(0, 0, 0, 0);

		setTitle("Ultimate Tic-Tac-Toe");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setBaseFont(JLabel label) {
		label.setFont(new Font("Arial", Font.BOLD, LABEL_FONT_SIZE));
	}

	private Cell[][][][] initBoard() {
		Cell[][][][] board = new Cell[GRID_SIZE][GRID_SIZE][GRID_SIZE][GRID_SIZE];

		for (Cell[][][] row3D : board) {
			for (Cell[][] row2D : row3D) {
				for (Cell[] row1D : row2D) {
					Arrays.fill(row1D, new Cell());
				}
			}
		}

		return board;
	}

	private Grid[][] initSubgrids() {
		Grid[][] subgrids = new Grid[GRID_SIZE][GRID_SIZE];

		for (Grid[] grid1D : subgrids) {
			Arrays.fill(grid1D, new Grid());
		}
		return subgrids;
	}

	private JPanel createBoardLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				JPanel subGrid = createSubGridLayout();
				createButtons(subGrid, i, j);
				panel.add(subGrid);
				subgridLayout[i][j] = subGrid;
			}
		}

		return panel;
	}

	private JPanel createSubGridLayout() {
		JPanel subGrid = new JPanel();
		subGrid.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		subGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK, THICK_BORDER_WIDTH));

		return subGrid;
	}

	private void createButtons(JPanel subGrid, int subgridRow, int subgridCol) {
		for (int i = 0; i < GRID_SIZE; i++) {
			final int row = i;

			for (int j = 0; j < GRID_SIZE; j++) {
				final int column = j;

				Cell cell = new Cell();
				cell.setPreferredSize(new Dimension(SMALL_CELL_SIZE, SMALL_CELL_SIZE));
				cell.setBackground(Color.WHITE);
				cell.setFont(new Font("Arial", Font.BOLD, SMALL_CELL_FONT_SIZE));
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, THIN_BORDER_WIDTH));
				cell.setFocusPainted(false);
				
				cell.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if (cell.isEnabled()) {
							cell.setBackground(Color.LIGHT_GRAY);
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						if (cell.isEnabled()) {
							cell.setBackground(Color.WHITE);
						}
					}
				});

				cell.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (cell.getState() == Cell.State.EMPTY) {
							handleCellClick(cell, subgridRow, subgridCol, row, column);
						}
					}
				});

				board[subgridRow][subgridCol][row][column] = cell;
				subGrid.add(cell);
			}
		}
	}

	// 
	private void handleCellClick(Cell cell, int subgridRow, int subgridCol, int row, int col) {
		if (Grid.isEmpty(subgrids[subgridRow][subgridCol])) {
			round++;
			roundLabel.setText("Round: " + (round + 1));
			updateCellState(cell);
			
			prevStep = new Step(subgridRow, subgridCol, row, col);
			prevStepLabel.setText("Previous Step: " + formatPrevStep());

			Grid.State localWinner = checkWinner(board[subgridRow][subgridCol]);

			if (localWinner != Grid.State.EMPTY) {
				// subgrids[subgridRow][subgridCol].setState(localWinner);
				
				replaceWonSubgrid(localWinner, subgridRow, subgridCol);
				
				// temporary messages
				String localWinnerMessage;
				String localWinnerTitle;
				String currentSubgrid = formatCurrentSubgrid();
				
				if (localWinner == Grid.State.TIED) {
					localWinnerMessage = String.format("%s tied.", currentSubgrid);
					localWinnerTitle = "Grid tied!";
				}
				else {
					localWinnerMessage = String.format("%s won by %s.", currentSubgrid, localWinner);
					localWinnerTitle = "Grid won!";
				}
				
				JOptionPane.showMessageDialog(this, localWinnerMessage, localWinnerTitle, JOptionPane.INFORMATION_MESSAGE);
				
				Grid.State globalWinner = checkWinner(subgrids);
				if (globalWinner != Grid.State.EMPTY) {
					endGame(globalWinner);
				}
			}
			
			// Enable the subgrid of subgridRow and subgridCol based on prevStep's row and col
			for (int i = 0; i < GRID_SIZE; i++) {
				for (int j = 0; j < GRID_SIZE; j++) {
					if (i == prevStep.row && j == prevStep.col) {
						currentSubgrid = new Step(i, j);
						toggleSubgrid(true, i, j);
					}
					else {
						toggleSubgrid(false, i, j);
					}
				}
			}
						
			currentSubgridLabel.setText("Current Step: " + formatCurrentSubgrid());
		}
	}
	
	//
	private void updateCellState(Cell cell) {
		boolean isEven = round % 2 == 0;
		Cell.State state = cell.getTurnState(isEven);
		Cell.Sign sign = cell.getTurnSign(isEven);
		cell.setState(state);
		cell.setSign(sign);
		
		cell.setText(cell.getSign());
	}

	//
	private String formatPrevStep() {
		int sector = prevStep.subgridRow * GRID_SIZE + prevStep.subgridCol + 1;
		int cell = prevStep.row * GRID_SIZE + prevStep.col + 1;

		return String.format("Grid %d, Cell %d", sector, cell);
	}

	//
	private void toggleSubgrid(boolean isActive, int row, int col) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				Cell cell = board[row][col][i][j];

				if (!isSubgridDisabled(row, col)) {
					Color cellColor = isActive ? Color.WHITE : Color.LIGHT_GRAY;
					cell.setEnabled(isActive);
					cell.setBackground(cellColor);
				}
			}
		}
	}

	//
	private boolean isSubgridDisabled(int row, int col) {
		return subgrids[row][col].getState() != Grid.State.EMPTY;
	}

	//
	private String formatCurrentSubgrid() {
		int subgrid = currentSubgrid.subgridRow * GRID_SIZE + currentSubgrid.subgridCol + 1;
		
		return "Grid " + Integer.toString(subgrid);
	}

	//
	private void replaceWonSubgrid(Grid.State winner, int subgridRow, int subgridCol) {
	    JPanel subgrid = subgridLayout[subgridRow][subgridCol];
	    boardLayout.remove(subgrid);

	    JButton filledSubgrid = new JButton();
	    filledSubgrid.setEnabled(false);
	    filledSubgrid.setPreferredSize(new Dimension(LARGE_CELL_SIZE, LARGE_CELL_SIZE));
	    filledSubgrid.setBackground(Color.WHITE);
	    filledSubgrid.setFont(new Font("Arial", Font.BOLD, LARGE_CELL_FONT_SIZE));
	    filledSubgrid.setBorder(BorderFactory.createLineBorder(Color.BLACK, THICK_BORDER_WIDTH));
	    filledSubgrid.setFocusPainted(false);
	    
	    switch (winner) {
        	case CROSS:
        		filledSubgrid.setText(Cell.Sign.CROSS.get());
        		break;
        	case CIRCLE:
        		filledSubgrid.setText(Cell.Sign.CIRCLE.get());
        		break;
        	case TIED:
                filledSubgrid.setText("-");
        	default:
        		break;
	    }
	    
	    // Add the button back at the specified indexes
	    boardLayout.add(filledSubgrid, subgridRow * GRID_SIZE + subgridCol);
	    boardLayout.revalidate();
	    boardLayout.repaint();
	}


	// Check winning conditions for the a single grid
	private <T> Grid.State checkWinner(T[][] grid) {
		// Check horizontal lines
		for (int row = 0; row < GRID_SIZE; row++) {
			if (checkLine(grid[row][0], grid[row][1], grid[row][2])) {
				if (grid[row][0] instanceof Cell) {
					return Grid.convertCellState(castToCell(grid[row][0]).getState());
				}

				return castToGrid(grid[row][0]).getState();
			}
		}

		// Check vertical lines
		for (int col = 0; col < GRID_SIZE; col++) {
			if (checkLine(grid[0][col], grid[1][col], grid[2][col])) {
				if (grid[0][col] instanceof Cell) {
					return Grid.convertCellState(castToCell(grid[0][col]).getState());
				}

				return castToGrid(grid[0][col]).getState();
			}
		}

		// Check diagonal lines
		if (checkLine(grid[0][0], grid[1][1], grid[2][2]) || checkLine(grid[0][2], grid[1][1], grid[2][0])) {
			if (grid[1][1] instanceof Cell) {
				return Grid.convertCellState(castToCell(grid[1][1]).getState());
			}

			return castToGrid(grid[1][1]).getState();
		}

		// Check for tie
		if (isGameTied(grid)) {
			return Grid.State.TIED;
		}

		// If no winner and no tie, return EMPTY
		return Grid.State.EMPTY;
	}

	// Check if a line (row, column, or diagonal) has the same states
	private <T> boolean checkLine(T cell1, T cell2, T cell3) {
		// We need to check if the state of the cells are empty or not
		if (cell1 instanceof Cell && cell2 instanceof Cell && cell3 instanceof Cell) {
			Cell.State state1 = castToCell(cell1).getState();
			Cell.State state2 = castToCell(cell2).getState();
			Cell.State state3 = castToCell(cell3).getState();
			
			return state1 != Cell.State.EMPTY && state1 == state2 && state2 == state3;
		}
		else {
			Grid.State state1 = castToGrid(cell1).getState();
			Grid.State state2 = castToGrid(cell2).getState();
			Grid.State state3 = castToGrid(cell3).getState();
			
			return state1 != Grid.State.EMPTY && state1 == state2 && state2 == state3;
		}
	}

	private <T> Cell castToCell(T element) {
		return (Cell) element;
	}

	private <T> Grid castToGrid(T element) {
		return (Grid) element;
	}

	// Check if the game is tied for a grid (either local or global)
	private <T> boolean isGameTied(T[][] grid) {
		// Check if all cells are filled and there is no winner
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (grid[i][j] instanceof Cell) {
					if (castToCell(grid[i][j]).getState() == Cell.State.EMPTY) {
						return false; // If any cell is empty, game is not tied
					}
				}
				else {
					if (castToGrid(grid[i][j]).getState() == Grid.State.EMPTY) {
						return false; // If any subgrid is empty, game is not tied
					}
				}
			}
		}

		// If all cells are filled and there is no winner, then game is tied
		return true;
	}
	
	private void endGame(Grid.State winner) {
		String message;

		if (winner == Grid.State.TIED) {
			message = "It's a tie!";
		}
		else {
			message = String.format(winner + " wins!");
		}

		JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);

		// resetGame();
	}

	/**
	 * The rule remaining implementation:
	 * 
	 * If a sector is won then no more moves can be made there Meaning that if a
	 * player is sent to that sector they can make a move in free sectors with EMPTY
	 * states
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Game());
	}
}