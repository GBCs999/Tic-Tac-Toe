package ultimatetictactoe;
import javax.swing.*;

public class Cell extends JButton {
	private static final long serialVersionUID = 1L;
	
	public State state;
	public Sign sign;
	
	public enum State {
	    EMPTY,
	    PLAYER1,
	    PLAYER2
	}
	
	public enum Sign {
	    PLAYER1("X"),
	    PLAYER2("O");
		
		private final String sign;

	    Sign(String sign) {
	        this.sign = sign;
	    }

	    public String get() {
	        return sign;
	    }
	}

    public State getTurnState(boolean isEven) {
        return isEven ? State.PLAYER2 : State.PLAYER1;
    }
    
    public State getState() {
        return state;
    }
    
    public void setState(State newState) {
        this.state = newState;
    }
    
    public Sign getTurnSign(boolean isEven) {
        return isEven ? Sign.PLAYER2 : Sign.PLAYER1;
    }

    public void setSign(Sign newSign) {
        this.sign = newSign;
    }
    
    public Cell() {
        state = State.EMPTY;
    }
}