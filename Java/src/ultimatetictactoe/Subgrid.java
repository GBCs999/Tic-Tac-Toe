package ultimatetictactoe;

import javax.swing.JButton;

public class Subgrid extends JButton {
	private static final long serialVersionUID = 1L;
	
	public enum State {
		EMPTY, CROSS, CIRCLE, TIED
	}

	private State state;
	
	public static boolean isEmpty(Subgrid grid) {
		return grid.getState() == State.EMPTY;
	}

	public Subgrid() {
		state = State.EMPTY;
	}

	public State getState() {
		return state;
	}

	public void setState(State newState) {
		this.state = newState;
	}
	
	public static State convertCellState(Cell.State cellState) {
		switch (cellState) {
		case CROSS:
			return State.CROSS;
		case CIRCLE:
			return State.CIRCLE;
		default:
			return State.EMPTY;
		}
	}
}