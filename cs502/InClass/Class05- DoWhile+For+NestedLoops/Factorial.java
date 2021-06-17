import java.util.Scanner;

public class Factorial {
	
	public static void main (String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int input = scan.nextInt();
		int fact = 1;

		for (int i=input; i>0; i--) 
			fact *= i;
		System.out.println(input + "! = " + fact);
	}
}	
