package ultimatetictactoe;

public class Step {
	public int subgridRow;
	public int subgridCol;
	public int row;
	public int col;

	public Step(int sectorRow, int sectorCol, int row, int col) {
		this.subgridRow = sectorRow;
		this.subgridCol = sectorCol;
		this.row = row;
		this.col = col;
	}

	// only if the subgrid is needed
	public Step(int subgridRow, int subgridCol) {
		this.subgridRow = subgridRow;
		this.subgridCol = subgridCol;
	}
}