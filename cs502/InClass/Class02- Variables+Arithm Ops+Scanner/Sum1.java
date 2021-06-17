import java.util.Scanner;

public class Sum1 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		int sum;

		System.out.println("Enter a number: ");
		num1 = scan.nextInt();
		System.out.println("Enter a number: ");
		num2 = scan.nextInt();

		sum = num1 + num2;

		System.out.println("The sum is " + sum);

	}

}
