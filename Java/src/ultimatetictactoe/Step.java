package ultimatetictactoe;

public class Step {
	public int sectorRow;
	public int sectorCol;
	public int row;
	public int col;
	
	public Step(int sectorRow, int sectorCol, int row, int col) {
		this.sectorRow = sectorRow;
		this.sectorCol = sectorCol;
		this.row = row;
		this.col = col;
	}
}