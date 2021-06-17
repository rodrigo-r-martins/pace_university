import java.util.*;

public class Multiplication {

	public static void main(String[] args) {

		/* Program generates two random numbers, multiply these two numbers and ask for an answer. User types the answer. If user's answer is wrong, a new attempt is generated, otherwise if user's answer is correct it generates two more numbers until user inputs -1 which ends the program */

		Random myRandomNumber = new Random();
		Scanner scan = new Scanner(System.in);

		int num1 = Math.abs(myRandomNumber.nextInt() % 10);
		int num2 = Math.abs(myRandomNumber.nextInt() % 10);

		int studentAnswer;
		int systemAnswer;

		do {
			System.out.println("How much is " + num1 + " times " + num2 + "? [Enter -1 to exit]");
			studentAnswer = scan.nextInt();
			systemAnswer = num1 * num2;

			if (studentAnswer == systemAnswer) {
				System.out.println("Very good!");
				num1 = Math.abs(myRandomNumber.nextInt() % 10);
				num2 = Math.abs(myRandomNumber.nextInt() % 10);

			} else if (studentAnswer != -1) {
				System.out.println("No. Please try again.");

			}

		} while (studentAnswer != -1); 
	}
}

