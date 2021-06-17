import java.util.Scanner;

public class AverageGrade {

	public static void main(String[] args) {

/* Program outputs average grade of total exams typed by user. 
If user types out of range of 0 and 100 it returns an error message. 
If user types -1 the program ends. */

		Scanner scan = new Scanner(System.in);
		int input;
	
		int numExam = 0;
		int sum = 0;
		double average;
	
		System.out.println("Enter exam or -1 to quit:");
		input = scan.nextInt();

		while (input != -1) {
			if (input >= 0 && input <= 100) {
				sum += input;
				numExam++;
			} else {
				System.out.println("Invalid input. Enter value between 0 and 100");
			}

		System.out.println("Enter exam or -1 to quit:");
		input = scan.nextInt();
		}

		System.out.println("sum=" + sum + "  numExam=" + numExam);

		if (numExam > 0) {
			average = sum / (double)numExam;
			System.out.println("Average=" + average);
		
		} else {
			System.out.println("No exam entered");
		}
	}
}