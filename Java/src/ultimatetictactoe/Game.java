package ultimatetictactoe;

import java.awt.BorderLayout;
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
	private static final String RESET_YES_OPTION = "New Game";
	private static final String RESET_NO_OPTION = "Exit";
	public static final int GRID_SIZE = 3;
	
	private static JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	public static Grid grid = new Grid();
	public static int round = 0;
	public static JLabel roundLabel = new JLabel("Round: " + (round + 1));
	public static Step prevStep;
	public static JLabel prevStepLabel = new JLabel("Previous Step: None");
	public static Step currentStep;
	public static JLabel currentPlayerLabel = new JLabel("Current Player: X");
	
	private Container pane = getContentPane();
	
	/**
     * Constructs a new instance of the Game class, initializing the game UI.
     */
	public Game() {
	    try {
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
	        setLocationRelativeTo(null);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	private static JPanel createStatLabel(JLabel label) {
		JPanel panel = new JPanel(
			new FlowLayout(FlowLayout.CENTER)
		);
		label.setFont(
			new Font(LABEL_FONT, Font.BOLD, LABEL_FONT_SIZE)
		);
		panel.add(label);
		
		return panel;
	}
	
	/**
     * Displays the end game message dialog.
     * 
     * @param winner The winner of the game, can also be a tie.
     */
	public static void endGame(Grid.State winner) {
		String message = (winner == Grid.State.TIED) ? "It's a tie!" : winner + " wins!";
	    String[] options = { RESET_YES_OPTION, RESET_NO_OPTION };
	    
	    int choice = JOptionPane.showOptionDialog(
	    		null, 								// No parent
	    		message,
	    		"Game Over", 						// Title
	    		JOptionPane.YES_NO_OPTION,
	    		JOptionPane.INFORMATION_MESSAGE,
	    		null, 								// No icon
	    		options,
	    		options[0] 							// Initially selected RESET_YES_OPTION
	    );

	    if (choice == JOptionPane.YES_OPTION) {
	        resetGame();
	    }
	    else {
	        System.exit(0); // Exit the application
	    }
	}
	
	/**
	 * Resets the game to its initial state without restarting the application.
	 */
	public static void resetGame() {
	    round = 0;
	    roundLabel.setText("Round: " + (round + 1));
	    
	    /**
	     * TODO: prevStep works with a NullPointerException, find a fix later.
	     * If changed to something like new Step(-1, -1, -1, -1), all subgrids get disabled.
	     */
	    prevStep = null;
	    
	    prevStepLabel.setText("Previous Step: None");
	    currentStep = null;
	    currentPlayerLabel.setText("Current Player: X");
	    
	    gridPanel.remove(grid);
	    grid = new Grid();
	    
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