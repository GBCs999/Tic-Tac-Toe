package ultimatetictactoe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Represents the main class for the Ultimate Tic-Tac-Toe game.
 */
public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String LABEL_FONT = "Arial";
	private static final int LABEL_FONT_SIZE = 24;
	public static final int GRID_SIZE = 3;
	
	public static Grid grid = new Grid();
	
	public static int round = 0;
	public static JLabel roundLabel = new JLabel("Round: " + (round + 1));
	
	public static Step prevStep;
	public static JLabel prevStepLabel = new JLabel("Previous Step: None");
	
	public static Step currentStep;
	
	public static JLabel currentPlayerLabel = new JLabel("Current Player: X");
	
	private static JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private Container pane = getContentPane();
	
	/**
     * Constructs a new instance of the Game class, initializing the game UI.
     */
	public Game() {
		JPanel roundPanel = createStatLabel(roundLabel);
		JPanel prevStepPanel = createStatLabel(prevStepLabel);
		JPanel currentPlayerPanel = createStatLabel(currentPlayerLabel);
		
		JPanel statsPanel = new JPanel(new BorderLayout());
		statsPanel.add(roundPanel, BorderLayout.NORTH);
		statsPanel.add(prevStepPanel, BorderLayout.CENTER);
		statsPanel.add(currentPlayerPanel, BorderLayout.SOUTH);
		
		gridPanel.add(grid);

		pane.setLayout(new BorderLayout());
		pane.add(statsPanel, BorderLayout.NORTH);
		pane.add(gridPanel, BorderLayout.CENTER);

		setTitle("Ultimate Tic-Tac-Toe");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JPanel createStatLabel(JLabel label) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		setBaseFont(label);
		panel.add(label);
		
		return panel;
	}
	
	/**
     * Sets the base font for a JLabel.
     * 
     * @param label The JLabel to set the font for.
     */
	private void setBaseFont(JLabel label) {
		label.setFont(new Font(LABEL_FONT, Font.BOLD, LABEL_FONT_SIZE));
	}
	
	/**
     * Displays the end game message dialog.
     * 
     * @param parentComponent The parent component for the dialog.
     * @param winner The winner of the game.
     */
	public static void endGame(Component parentComponent, Grid.State winner) {
	    String message;

	    if (winner == Grid.State.TIED) {
	        message = "It's a tie!";
	    }
	    else {
	        message = String.format(winner + " wins!");
	    }

	    Object[] options = {"New Game", "Exit"};
	    int choice = JOptionPane.showOptionDialog(
	    		parentComponent,
	    		message,
	    		"Game Over",
	    		JOptionPane.YES_NO_OPTION,
	    		JOptionPane.INFORMATION_MESSAGE,
	    		null,
	    		options,
	    		options[0]
	    );

	    if (choice == JOptionPane.YES_OPTION) {
	        resetGame();
	    }
	    else {
	        System.exit(0); // Exit the application
	    }
	}
	
	/**
	 * Resets the game to its initial state.
	 */
	public static void resetGame() {
	    round = 0;
	    roundLabel.setText("Round: " + (round + 1));
	    prevStep = new Step(0, 0, 0, 0);
	    prevStepLabel.setText("Previous Step: None");
	    currentStep = new Step(0, 0);
	    currentPlayerLabel.setText("Current Player: X");
	    gridPanel.removeAll();
	    gridPanel.revalidate();
	    gridPanel.repaint();
	    grid = new Grid();
	    
	    // TODO: Fix cell coloring issue 
	    for (int i = 0; i < GRID_SIZE; i++) {
	        for (int j = 0; j < GRID_SIZE; j++) {
	            Subgrid subgrid = grid.getSubgrid(i, j);
	            subgrid.setState(Subgrid.State.EMPTY);
	            subgrid.toggleSubgrid(true);
	        }
	    }
	    
	    gridPanel.add(grid);
	    gridPanel.revalidate();
	    gridPanel.repaint();
	}

	
	/**
     * Main method to start the application.
     * 
     * @param args The command line arguments.
     */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Game());
	}
}