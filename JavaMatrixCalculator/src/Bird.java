public class Bird {
	public static void main(String[] args) {
			MatrixView theView = new MatrixView();
			MatrixModel MatrixA = new MatrixModel();
			MatrixModel MatrixB = new MatrixModel();
			MatrixModel MatrixC = new MatrixModel();
			@SuppressWarnings("unused")
			MatrixController controller = new MatrixController(theView, MatrixA, MatrixB, MatrixC);
			theView.start();
		}
}