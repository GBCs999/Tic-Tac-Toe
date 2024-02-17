package ultimatetictactoe;

public class Grid {
	public enum State {
	    EMPTY,
	    PLAYER1,
	    PLAYER2,
	    TIED
	}
	
    private State state;
    
    public static boolean isEmpty(Grid grid) {
    	return grid.getState() == Grid.State.EMPTY;
    }
    
    public Grid() {
        state = State.EMPTY;
    }

    public Grid.State getState() {
        return state;
    }

    public void setState(State newState) {
        this.state = newState;
    }
}