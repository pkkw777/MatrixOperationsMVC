import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixController {

	private MatrixView theView;
	private MatrixModel MatrixA, MatrixB, MatrixC;
	
	public MatrixController(MatrixView theView, MatrixModel MatrixA, MatrixModel MatrixB, MatrixModel MatrixC) {			
		this.theView = theView;
		this.theView.setController(this);
		this.MatrixA = MatrixA;
		this.MatrixB = MatrixB;
		this.MatrixC = MatrixC;
	}
		
	public void createMatrix(int row, int col) {
		MatrixA = new MatrixModel(row, col);
		MatrixB = new MatrixModel(col, row);
		MatrixC = new MatrixModel(MatrixA.getRow(), MatrixB.getCol());
	}
	
	public void setValue() {
		System.out.println("Enter values into matrix A: ");
		setValue(MatrixA);
		System.out.println("Enter values into matrix B: ");
		setValue(MatrixB);
	}
	
	public void transValue() {
		transMatrix(MatrixA);
		transMatrix(MatrixB);
	}
	
	public void transFinal() {
		transMatrix(MatrixC);
	}
	
	public void printM() {
		printMatrix(MatrixA);
		printMatrix(MatrixB);
	}
	
	public void printFinal() {
		printMatrix(MatrixC);
	}
	
	public double[][] getLengthA()
	{
		double [][] A = MatrixA.getMatrix();
		return A;
	}
	
    public void multiplyMatrix() {
    	double [][] A = MatrixA.getMatrix();
    	double [][] B = MatrixB.getMatrix();
        int aRows 	 = A.length;
        int aColumns = A[0].length;
        int bColumns = B[0].length;
        
        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++){
            for (int j = 0; j < bColumns; j++){
                C[i][j] = 0;
            }
        }
        
        for (int i = 0; i < aRows; i++) { 				// a Row
            for (int j = 0; j < bColumns; j++) { 		// b Column
                for (int k = 0; k < aColumns; k++) { 	// a Column
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
       MatrixC.setRow(C.length);
       MatrixC.setCol(C[0].length);
       MatrixC.setMatrix(C);
    }
	
	private void setValue(MatrixModel Matrix) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		double temp = 0;
		int cnt = 0;
		int row = Matrix.getRow();
		int col = Matrix.getCol();
		double [][]tempM = Matrix.getMatrix();
		for (int i = 0; i < row; i++) {
			for	(int j = 0; j < col; j++) {
				while(true) {
					try {
						temp = scanner.nextDouble();
						tempM[i][j] = temp;
						cnt +=1;
						System.out.println("Value entered successfully. You have " + (row * col - cnt) + " values to enter.");
						break;
					}catch(InputMismatchException  e) {
						System.err.println("Invalid value. If floating point use { . } or { , }.\n");
						scanner.next();
					}
				}
			}
		}
		Matrix.setMatrix(tempM);
	}

	private void transMatrix(MatrixModel Matrix) {
		double[][] tempM = Matrix.getMatrix();
		int row = Matrix.getRow();
		int col = Matrix.getCol();
		double[][] newM = new double [row][col];
		for (int i = 0; i < row; i++) {
			for	(int j = 0; j < col; j++) {
				newM[j][i] = tempM[i][j];
			}
		}
		Matrix.setRow(newM.length);
		Matrix.setCol(newM[0].length);
		Matrix.setMatrix(newM);	
	}	
	
	private void printMatrix(MatrixModel Matrix) {
		double[][] tempM = Matrix.getMatrix();
		int row = Matrix.getRow();
		int col = Matrix.getCol();
		for (int i =0; i < row; i++) {
			for	(int j = 0; j < col; j++) {
				System.out.println(tempM[i][j] + " ");
			}
			System.out.println();
		}
	}
}