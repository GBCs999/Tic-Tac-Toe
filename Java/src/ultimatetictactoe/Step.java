package ultimatetictactoe;

public class Step {
	public int subgridRow;
	public int subgridCol;
	public int row;
	public int col;
	
	/**
     * Constructs a new instance of the Step class with specified coordinates.
     * 
     * @param sectorRow The row index of the subgrid.
     * @param sectorCol The column index of the subgrid.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
	public Step(int sectorRow, int sectorCol, int row, int col) {
		this.subgridRow = sectorRow;
		this.subgridCol = sectorCol;
		this.row = row;
		this.col = col;
	}

	/**
     * Constructs a new instance of the Step class with only subgrid coordinates.
     * 
     * @param subgridRow The row index of the subgrid.
     * @param subgridCol The column index of the subgrid.
     */
	public Step(int subgridRow, int subgridCol) {
		this.subgridRow = subgridRow;
		this.subgridCol = subgridCol;
	}
	
	/**
     * Formats the previous step for display.
     * 
     * @return The formatted previous step string.
     */
	public String formatPrevStep() {
		int subgrid = calculatePosition(subgridRow, subgridCol);
		int cell = calculatePosition(row, col);

		return String.format("Subgrid %d, Cell %d", subgrid, cell);
	}
	
	/**
     * Formats the current step for display.
     * 
     * @return The formatted current step string.
     */
	public String formatCurrentStep() {
		int subgrid = calculatePosition(subgridRow, subgridCol);
		
		return "Subgrid " + subgrid;
	}
	
	/**
     * Calculates the position of a cell in the grid.
     * 
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The position of the cell.
     */
	private int calculatePosition(int row, int col) {
		return row * Game.GRID_SIZE + col + 1;
	}
}