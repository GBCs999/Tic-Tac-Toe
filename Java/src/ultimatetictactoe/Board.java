package ultimatetictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Board extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int GRID_SIZE = 3;
    private static final int LABEL_FONT_SIZE = 24;
    private static final int THIN_BORDER_WIDTH = 1;
    private static final int THICK_BORDER_WIDTH = 2;
    
    private JLabel roundLabel;
    private int round = 0;
    
    private JLabel prevStepLabel;
    private Step prevStep;
    
    private JLabel currentSectorLabel;
    private Sector currentSector;
    
    private final Cell[][][][] board;
    private final Grid[][] subgrids;
    private final JPanel boardLayout;

    public Board() {
    	JPanel roundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	roundLabel = new JLabel("Round: " + (round + 1));
    	setBaseFont(roundLabel);
        roundPanel.add(roundLabel);
        
        JPanel prevStepPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        prevStepLabel = new JLabel("Previous Step: None");
        setBaseFont(prevStepLabel);
        prevStepPanel.add(prevStepLabel);
        
        JPanel currentSectorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        currentSectorLabel = new JLabel("Current Step: All");
        setBaseFont(currentSectorLabel);
        currentSectorPanel.add(currentSectorLabel);
        
        JPanel statsPanel = new JPanel(new BorderLayout());
        statsPanel.add(roundPanel, BorderLayout.NORTH);
        statsPanel.add(prevStepPanel, BorderLayout.CENTER);
        statsPanel.add(currentSectorPanel, BorderLayout.SOUTH);
        
        JPanel boardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        board = initBoard();
        subgrids = initSubgrids();
        boardLayout = createBoardLayout();
        boardPanel.add(boardLayout);
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(statsPanel, BorderLayout.NORTH);
        pane.add(boardPanel, BorderLayout.CENTER);
        
        currentSector = new Sector(0, 0);
        
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
                cell.setPreferredSize(new Dimension(50, 50));
                cell.setBackground(Color.WHITE);
                cell.setFont(new Font("Arial", Font.BOLD, 30));
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

    private void handleCellClick(Cell cell, int subgridRow, int subgridCol, int row, int col) {
        Grid activeSubgrid = subgrids[subgridRow][subgridCol];
        
        if (Grid.isEmpty(activeSubgrid)) {
            updateCellState(cell);
            
            round++;
            roundLabel.setText("Round: " + (round + 1));
            
            prevStep = new Step(subgridRow, subgridCol, row, col);
            prevStepLabel.setText("Previous Step: " + formatPrevStep());
            
            // Based on prevStep's row and col, enable the subgrid of subgridRow and subgridCol
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (i == prevStep.row && j == prevStep.col) {
                    	currentSector = new Sector(i, j);
                        toggleSubgrid(true, i, j);
                    }
                    else {
                    	toggleSubgrid(false, i, j);
                    }
                }
            }
            
            currentSectorLabel.setText("Current Step: " + formatCurrentSector());
            
            Grid.State localWinner = checkWinner(board[subgridRow][subgridCol]);
            activeSubgrid.setState(localWinner);
            
            if (localWinner == Grid.State.PLAYER1 || localWinner == Grid.State.PLAYER2) {
            	String gridWonMessage = String.format("Grid %s won by %s",
            			formatCurrentSector(), localWinner);
            	
            	JOptionPane.showMessageDialog(this, gridWonMessage, "Grid won!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            Grid.State globalWinner = checkWinner(subgrids);
            if (globalWinner != Grid.State.EMPTY) {
                endGame(globalWinner);
            }
        }
    }
    
    private void updateCellState(Cell cell) {
    	boolean isEven = round % 2 == 0;
        cell.state = cell.getTurnState(isEven);
        cell.sign = cell.getTurnSign(isEven);
        
        cell.setText(cell.sign.get());
        cell.setEnabled(false);
    }
    
    private String formatPrevStep() {
    	int sector = prevStep.sectorRow * GRID_SIZE + prevStep.sectorCol + 1;
        int cell = prevStep.row * GRID_SIZE + prevStep.col + 1;
        
        return String.format("Grid %d, Cell %d", sector, cell);
    }
    
    private void toggleSubgrid(boolean isActive, int row, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Cell cell = board[row][col][i][j];
                if (!isSubgridDisabled(row, col)) {
                    Color cellColor = isActive ? Color.WHITE : Color.LIGHT_GRAY;
                    cell.setEnabled(isActive);
                    cell.setBackground(cellColor);
                } else {
                    cell.setEnabled(false);  // Disable cells in locked subgrid
                    cell.setBackground(Color.GRAY);  // Set a visual indicator for locked subgrid
                }
            }
        }
    }

    
    private boolean isSubgridDisabled(int row, int col) {
    	return subgrids[row][col].getState() != Grid.State.EMPTY;
    }
    
    private String formatCurrentSector() {
    	int sector = currentSector.row * GRID_SIZE + currentSector.col + 1;;
    	
    	return "Grid " + Integer.toString(sector);
    }
    
    private <T> Grid.State checkWinner(T[][] array) {
        int size = array.length;
        
        // Check horizontal lines
        for (int row = 0; row < size; row++) {
            if (checkLine(array[row][0], array[row][1], array[row][2])) {
                return getState(array[row][0]);
            }
        }
        
        // Check vertical lines
        for (int col = 0; col < size; col++) {
            if (checkLine(array[0][col], array[1][col], array[2][col])) {
                return getState(array[0][col]);
            }
        }
        
        // Check diagonal lines
        if (checkLine(array[0][0], array[1][1], array[2][2]) ||
            checkLine(array[0][2], array[1][1], array[2][0])) {
            return getState(array[1][1]);
        }
        
        // Check for tie
        if (isGameTied(array)) {
        	 return Grid.State.TIED;
        }
        
        // If no winner and no tie, return EMPTY
        return Grid.State.EMPTY;
    }

    private <T> boolean checkLine(T cell1, T cell2, T cell3) {
        return getState(cell1) != Grid.State.EMPTY &&
               getState(cell1) == getState(cell2) &&
               getState(cell2) == getState(cell3);
    }

    private Grid.State getState(Object obj) {
        if (obj instanceof Grid) {
            return ((Grid) obj).getState();
        }
        
        return Grid.State.EMPTY;
    }
    
    private <T> boolean isGameTied(T[][] array) {
        // Check if all subgrids are filled
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (getState(array[i][j]) == Grid.State.EMPTY) {
                	return false; // If any subgrid is empty, game is not tied
                }
            }
        }
        
        // If all subgrids are filled and there is no winner, then game is tied
        return true;
    }
    
    private void endGame(Grid.State winner) {
        String message;
        
        if (winner == Grid.State.TIED) {
            message = "It's a tie!";
        }
        else {
            message = "Player " + (winner == Grid.State.PLAYER1 ? "X" : "O") + " wins!";
        }
        
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        
        // resetGame();
    }
    
    /**
     * Rules reminder
     * 
     * If a sector is won then no more moves can be made there
     * Meaning that if a player is sent to that sector they can make a move in free sectors with EMPTY states
     * */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Board());
    }
}
