package ultimatetictactoe;

public class Grid {
	public enum State {
		EMPTY, CROSS, CIRCLE, TIED
	}

	private State state;
	
	public static boolean isEmpty(Grid grid) {
		return grid.getState() == State.EMPTY;
	}

	public Grid() {
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