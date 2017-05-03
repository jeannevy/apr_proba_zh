package apr_proba_zh;

public class Cell {
	private double rowPos;
	private double colPos;
	public BasisStation basis = null;
	
	public Cell(double r, double c) {
		this.rowPos = r;
		this.colPos = c;
	}
	
	public double getRow() {
		double row = this.rowPos;
		return row;
	}
	
	public double getCol() {
		double col = this.colPos;
		return col;
	}
	
	public synchronized void setCell(double row, double col) {
		this.rowPos = row;
		this.colPos = col;
	}
	
	public double calculateDistance(Cell b) {
		double rowB = b.getRow();
		double colB = b.getCol();
		double distanceRow = Math.abs(this.rowPos - rowB);
		double distanceCol = Math.abs(this.colPos - colB);
		double result = Math.sqrt((distanceRow*distanceRow + distanceCol*distanceCol));
		return result;

	}
	
}
