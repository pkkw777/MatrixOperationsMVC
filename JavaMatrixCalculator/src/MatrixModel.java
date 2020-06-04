public class MatrixModel {
	private int row;
	private int col;
	private double[][]Matrix;
	
	public MatrixModel() {}	
	
	public MatrixModel(int row, int col)
	{
		Matrix = new double[row][col];
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int column) {
		this.col = column;
	}
	
	public double[][] getMatrix() {
		return Matrix;
	}

	public void setMatrix(double[][] matrix) {
		Matrix = matrix;
	}
}