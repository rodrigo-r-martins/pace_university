import java.util.Scanner;

public class Change {

	public static void main(String[] args) {

/* Program outputs the change of an amount between 0-100 typed by user. 
It returns the quantity of each coins (25, 10, 5, 1) user would get according the value typed. 
If user inputs a value out of range it returns an error message */
		
		int number;
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Enter the purchase amount [0-100]:");
		number = scan.nextInt();
	
		int change;
		int remainder;
		int quarters;
		int dimes;
		int nickels;
		int pennies;
	
		if (number >= 0 && number <= 100) {
			change = 100 - number;
			quarters = change / 25;
			remainder = change % 25;
			dimes = remainder / 10;
			remainder %= 10;
			nickels = remainder / 5;
			remainder %= 5;
			pennies = remainder / 1;
			
			System.out.println("Your change of " + change + " cents is given as:");
			System.out.println(quarters + " Quarters");
			System.out.println(dimes + " Dimes");
			System.out.println(nickels + " Nickels");
			System.out.println(pennies + " Pennies");
		} else {
			System.out.println("Sorry. Only numbers between 0 and 100");
		}
	}

}