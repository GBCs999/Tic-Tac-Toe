package ultimatetictactoe;

import javax.swing.JButton;

public class Cell extends JButton {
	private static final long serialVersionUID = 1L;

	private State state;
	private Sign sign;

	public enum State {
		EMPTY, CROSS, CIRCLE
	}
	
	public enum Sign {
		CROSS("X"), CIRCLE("O");

		private final String sign;

		Sign(String sign) {
			this.sign = sign;
		}

		public String get() {
			return sign;
		}
	}

	public State getTurnState(boolean isEven) {
		return isEven ? State.CIRCLE : State.CROSS;
	}

	public State getState() {
		return state;
	}

	public void setState(State newState) {
		this.state = newState;
	}

	public Sign getTurnSign(boolean isEven) {
		return isEven ? Sign.CIRCLE : Sign.CROSS;
	}
	
	public String getSign() {
		return sign.get();
	}
	
	public void setSign(Sign newSign) {
		this.sign = newSign;
	}

	public Cell() {
		state = State.EMPTY;
	}
}