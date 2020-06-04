import java.util.Scanner;

public class GuiMethods {
	private MatrixController controller;

	private int choice = 0;
	
	public void printResult() {
		if(choice == 1) {
			if(controller.getLengthA() == null) {
				matrixError();
			}
			else {
				System.err.println("Input matrices: ");
				controller.printM();
			}
		}
		else if(choice == 2) {
			if(controller.getLengthA() == null) {
				matrixError();
			}
			else {
				System.err.println("Result matrix: ");
				controller.printFinal();
			}
		}
		standardInfo();
	}


	public void mathOperations() {
		if(choice == 1) {
			if(controller.getLengthA() == null) {
				matrixError();
			}
			else {
				System.err.println("Transpose succeeded. ");
				controller.transValue();
			}
		}
		else if(choice == 2) {
			if(controller.getLengthA() == null) {
				matrixError();
			}
			else {
				System.err.println("Multiply succeeded. ");
				controller.multiplyMatrix();
			}
		}
		else if(choice == 3) {
			if(controller.getLengthA() == null) {
				matrixError();
			}
			else {
				System.err.println("Transpose succeeded. ");
				controller.transFinal();
			}
		}
		standardInfo();
	}
	
	public void standardInfo() {
		System.out.println(""
				+	" 1. Enter input matrices\n"
				+ 	" 2. Arithmetic operations\n"
				+ 	" 3. Display matrices\n"
				+ 	"-1. End of program");
	}
	
	public void secondInfo() {
		System.out.println(""
				+ "1. Transpose matrices\n"
				+ "2. Multiply matrices\n"
				+ "3. Transpose the resulting matrix\n");
	}
	
	public void thirdInfo() {
        System.out.println(""
        		+ "1. Display input matrices\n"
        		+ "2. Display result matrix\n");	
	}
	
	public void matrixError() {
		System.err.println("Matrices have not been entered!");
	}
	
	public void checkValue(Scanner scanner)
	{
        while (!scanner.hasNextDouble()) {
            System.out.println("Not found: "+scanner.next());  
        }
	}
}