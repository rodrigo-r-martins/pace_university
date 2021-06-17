import java.util.Scanner;

public class EvenIntegers {

	public static void main(String[] args) {

		/* Enter an integer greater than 1 and it returns the sum of all even numbers between 2 and the typed number */

		Scanner scan = new Scanner(System.in);
		int num;
		int sumEven = 0;
		int i = 2;
	
		System.out.println("Enter a number");
		num = scan.nextInt();

		if (num < 2) {
			System.out.println("Sorry. Only number greater than one");
		} else {
			while (i<=num) {
				if (i%2 == 0) {
					sumEven += i;
				}
				i++;
			}
			System.out.println("sumEven=" + sumEven);
		}				
	}
}