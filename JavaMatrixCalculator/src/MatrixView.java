import java.util.Scanner;

public class MatrixView extends GuiMethods {
	private MatrixController controller;
	private int row, col;
	private int choice = 0;
	private boolean flag = true;
	
	public void start() {
		Scanner scanner = new Scanner(System.in);
		standardInfo();
		while(flag) {
			checkValue(scanner);
            choice = scanner.nextInt();
            switch(choice) {
            case 1:
                insertValue(scanner);
                break;
            case 2:
            	secondInfo();
            	checkValue(scanner);
                choice = scanner.nextInt();
            	mathOperations();
                break;
            case 3:
            	thirdInfo();
            	checkValue(scanner);
                choice = scanner.nextInt();
                printResult();
                break;
            case -1:
            	flag = false;
            	break;
            default:
            	standardInfo();
            	break;	
            }
		}
		System.err.println("Ending ...");
		scanner.close();
	}

	public MatrixController getController() {
		return controller;
	}

	public void setController(MatrixController controller) {
		this.controller = controller;
	}
	
	public void insertValue(Scanner scanner) {
		System.out.println("Enter the number of rows:");
		row = scanner.nextInt();
		
		System.out.println("Enter the number of cols:");
		col = scanner.nextInt();
		
		controller.createMatrix(row, col);
		controller.setValue();
		standardInfo();
	}
}