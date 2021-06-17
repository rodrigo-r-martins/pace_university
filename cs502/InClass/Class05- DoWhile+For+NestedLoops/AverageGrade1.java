import java.util.Scanner;

public class AverageGrade1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input;
	
		int numExam = 0;
		int sum = 0;
		double average;
	
		do {
			System.out.println("Enter exam or -1 to quit:");
			input = scan.nextInt();
			
			/* 
			if (input == -1) 
				break; 
			*/

			if (input >= 0 && input <= 100) {
				sum += input;
				numExam++;
			} else if (input != -1) {
				System.out.println("Invalid input. Enter value between 0 and 100");
			}
		} while (input != -1);

		System.out.println("sum=" + sum + "  numExam=" + numExam);

		if (numExam > 0) {
			average = sum / (double)numExam;
			System.out.println("Average=" + average);
		
		} else {
			System.out.println("No exam entered");
		}
	}
}